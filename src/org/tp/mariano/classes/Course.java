package org.tp.mariano.classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.tp.interfaces.CourseItf;
import org.tp.interfaces.VehiculeItf;
import org.tp.mariano.exceptions.InscriptionException;
import org.tp.mariano.exceptions.VehiculeException;

/**
 * <ul>
 * <li>LocalDate dateDepart</li>
 * <li>SortedMap < LocalDateTime, Equipage > classement</li>
 * @author elodie
 *
 */
public abstract class Course implements CourseItf {
	
	// ---------- ATRIBUTS
	
	private static final long serialVersionUID = 714618350493019619L;
	
	private static int coursesCompte = 0;
	private final int courseId;
	
	private String fichier = "";
	
	private static DateTimeFormatter formatageChrono = 
			DateTimeFormatter.ofPattern("hh:mm:ss:SSS");
	
	private List<Integer> score = Arrays.asList(10, 8, 2); // système de score
	
	// PAS de setter
	protected int participants_min;
	protected int participants_max;
	
	protected Class<? extends Vehicule> type;
	protected String modele;
	protected int cylindree;
	
	protected LocalDateTime dateDepart;
	
	protected Hashtable<Equipage, LocalDateTime> resultats;
	
	protected boolean inscriptionsOuvertes;
	
		
	// ---------- CONSTRUCTEUR	
	
	public Course(){
		Course.coursesCompte ++;
		this.courseId = Course.coursesCompte;
		this.fichier = this.getClass().getName() + this.courseId;
		this.dateDepart = LocalDateTime.now(); // défaut
	}
	
	public Course(LocalDateTime depart){
		Course.coursesCompte ++;
		this.courseId = Course.coursesCompte;
		this.fichier = this.getClass().getName() + this.courseId;
		this.dateDepart = depart;
	}
	
	public Course(int year, int month, int day, 
			int hour, int minutes, int seconds, int nanoseconds){
		Course.coursesCompte ++;
		this.courseId = Course.coursesCompte;
		this.fichier = this.getClass().getName() + this.courseId;
		LocalDate date = LocalDate.of(year, month, day);
		LocalTime depart = LocalTime.of(hour, minutes, seconds, nanoseconds);
		this.dateDepart = LocalDateTime.of(date, depart);
	}
	
	
	// ---------- MÉTHODES
	
	/**
	 * Affiche le nom de la course et la date de départ, le reste <br/>
	 * (type, modele, cylindree) est relayé par les classes filles <br/>
	 * non abstraite. <br/>
	 */
	@Override
	public String toString() {
		return ("Course n°" + courseId + 
				"\nDépart : " + date().format(formatageChrono) + 
				"\n"
				);
	}	
	
	public String fichier() {
		return this.fichier;
	}

	public void setFichier(String fichier) {
		this.fichier = fichier;
	}
	
	public void setDateDepart(LocalDateTime dateDepart) {
		this.dateDepart = dateDepart;
	}
	
	public String type() {
		return this.type.getClass().getName().toLowerCase();
	}
	
	public String modele() {
		return this.modele();
	}
	
	public int cylindree() {
		return this.cylindree;
	}
	
	/**
	 * Cette méthode indique si l'inscription d'un équipage à cette course <br>
	 * est ouverte ou non. L'inscription est fermée notamment si : 
	 * <ul>
	 * <li>le nombre max de participants pour cette Course est atteint</li>
	 * <li>la date limite d'inscription est atteinte, ici la date même</li>
	 * </ul>
	 * 
	 */
	public boolean inscriptionsOuvertes() 
			throws InscriptionException {
		// les inscriptions peuvent être fermées par le Championnat
		if (this.inscriptionsOuvertes == false)
			return false;
		if (LocalDate.now().isAfter(this.date()) || 
				LocalDate.now().isEqual(this.date())) {
			throw new InscriptionException(InscriptionException.messageDate);
		}
		// cas où le nombre de participants max est atteint
		if (this.resultats.size() == this.participantsMax()) {
			throw new InscriptionException(InscriptionException.messageLimite);
		}
		return true;
	}
	
	public void setInscriptionsOuvertes(boolean etat) {
		this.inscriptionsOuvertes = etat;
	}
	
	/**
	 *  Les équipages seront classés selon leur temps d'arrivée.<br/>
	 *  <i>Hashtable DOES NOT ALLOW null keys or values.<br/>
	 *  (HashMap allows one null key and any number of null values.)</i>
	 *  @return Collection< Equipage >, éventuellement vide, jamais null
	 */ 
	public Hashtable<Equipage, LocalDateTime> resultats() {
		if (this.resultats == null) {
			this.resultats = new Hashtable<Equipage, LocalDateTime>();
		}
		return this.resultats;
	}
	
	/**
	 * Classe les temps réalisés par les Equipages du plus court au plus long.
	 * @return Queue<LocalDateTime> temps
	 */
	private Queue<LocalDateTime> temps(){
		Queue<LocalDateTime> temps = new PriorityQueue<LocalDateTime>();
		temps.addAll(this.resultats.values());
		return temps;
	}
	
	/**
	 * Ajoute un Equipage comme participant à cette course à condition <br>
	 * que certaines contraintes soient vérifiées : <br>
	 * <ul>
	 * <li>S2 : le type du Vehicule est conforme</li>
	 * <li>S2 : le modele du Vehicule est conforme</li>
	 * <li>S2 : la cylindree du Vehicule est conforme</li>
	 * <li>S5 : une course de moto est limitée à 20 participants</li>
	 * <li>S5 : une course de voiture est limitée à 16 participants</li>
	 * <li>(l'equipage est disponible à cette date ?)</li>
	 * </ul>
	 */
	public void inscrire(Equipage e) 
			throws VehiculeException, InscriptionException{
		//TODO
		// à l'inscription, tous les participants n'ont effectué aucun temps
		// l'inscription peut être rejetée
		try {
			boolean conforme = this.vehiculeEstConforme(e.vehicule());
			boolean disponible = this.inscriptionsOuvertes();
			if (conforme && disponible)
					this.resultats.put(e, null);
		} // si l'inscription a échoué, on notifie l'utilisateur
		catch(VehiculeException v){
		} catch(InscriptionException p){
		}finally {}
	}

	/**
	 * Cette méthode effectue les vérifications des informations requises <br>
	 * pour que le Vehicule puisse concourir dans une Course ou un Championnat. <br>
	 * On vérifie notamment que tous les champs définissant le Veshicule <br>
	 * selon son type (Moto, Voiture) ont été renseignés. <br>
	 * <ul>
	 * <li>S2 : type de véhicule</li>
	 * <li>S2 : modèle, dépend du type</li>
	 * <li>S2 : cylindrée</li>
	 * </ul>
	 * S13 : Voiture -> carburant, nombre de roues motrices
	 * S14 : Moto -> poids
	 * 
	 * @return true si le véhicule est conforme
	 * @see 
	 */
	public boolean vehiculeEstConforme(VehiculeItf v) 
			throws VehiculeException {
		boolean conforme = true;
		if (v.type() != this.type()) {
			conforme = false;
			throw new VehiculeException(VehiculeException.messageType);
		}
		if (v.modele() != this.modele()) {
			conforme = false;
			throw new VehiculeException(VehiculeException.messageModele);
		}
		if (v.cylindree() != this.cylindree()) {
			conforme = false;
			throw new VehiculeException(VehiculeException.messageCylindree);
			}
		return conforme;
	}
	
	
	/**
	 * Retourne les points gagnés pour cette cours en fonction de la <br/>
	 * position. Système de score :
	 * <ul>
	 * <li>10 points pour le 1er</li>
	 * <li>8 pour le 2e</li>
	 * <li>2 pour le 3e</li>
	 * <li>0 pour les suivants</li>
	 * </ul>
	 * @param position
	 * @return int points gagnés
	 */
	public int points(int position) {
		if (position > score.size())
			return 0;
		return score.get(position);
	}
	
	/**
	 * Classe les équipages selon leurs temps (une fois la course effectuée). 
	 * <ul>
	 * <li>pour chaque temps, on déclare une clef position (Integer)</li>
	 * <li>à chaque position, on associe en valeur une liste des équipages</li>
	 * </ul>
	 * (liste d'un seul élément si aucun ex-aequo).<br/>
	 * 
	 * @return Hashtable< LocalDateTime, List< Equipage > > classement
	 */
	public Hashtable<Integer, List<Equipage>> classement() {
		/*(une fois la course finie) :
		 *  En ajoutant les temps dans la PriorityQueue, ils sonts classés
		 *  selon l'ordre naturel (comparator) de LocalDateTime, et donc
		 *  du plus court au plus long.
		 */
		
		Hashtable<Integer, List<Equipage>> classement = 
				new Hashtable<Integer, List<Equipage>>();
		
		Integer position = 0;
		List<Equipage> equipages = null; // liste pour les ex-aquo
		
		for (LocalDateTime t : temps()) {
			equipages = new ArrayList<Equipage>();
			for ( Equipage e : this.resultats.keySet() ) {
				if (t == this.resultats.get(e))
					equipages.add(e);
			}
			classement.put(position, equipages);
		}
		return classement;
	}
	
	/**
	 * 
	 * @return Hashtable< List< Equipage >, Integer > classement
	 */
	
	
	// ---------- MÉTHODES D'INTERFACE
	
	@Override
	public int participantsMin() {
		return this.participants_min;
	}

	@Override
	public int participantsMax() {
		return this.participants_max;
	}

	@Override
	public LocalDate date() {
		return this.dateDepart.toLocalDate();
	}
	
	@Override
	public LocalDateTime depart() {
		return this.dateDepart;
	}
	
	@Override
	public Collection<Equipage> equipages() {
		return resultats().keySet();
	}

	@Override
	public void entrerResultats() {
		LocalDateTime arrivee = null;
		for (Equipage e : this.equipages()) {
			//arrivee = this.arriveeAleatoire();
			this.resultats.put(e, arrivee);
		}
	}
	
	public List<String> tableauResultats() {
		List<String> tableau = new ArrayList<String>();
		String ligne = "";
		for (Integer i : this.classement().keySet()) {
			for (Equipage e : this.classement().get(i)) {
				ligne = i + " " + ligne + e.pilote().nom()
						+ " " + resultats.get(e);
				tableau.add(ligne);
			}
		}
		return tableau;
	}
	
	@Override
	public void afficherResultats() {
		for (String l : tableauResultats()) {
			System.out.println(l);
		}
	}

	@Override
	public void arriveeCourse() {
		this.entrerResultats();
		this.afficherResultats();
	}

}

	
