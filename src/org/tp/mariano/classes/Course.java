package org.tp.mariano.classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.tp.interfaces.CourseItf;
import org.tp.interfaces.EquipageItf;

/**
 * <ul>
 * <li>LocalDate dateDepart</li>
 * <li>SortedMap < LocalDateTime, Equipage > classement</li>
 * @author elodie
 *
 */
public abstract class Course implements CourseItf {
	
	// ATRIBUTS
	
	private static final long serialVersionUID = 714618350493019619L;
	
	private static int coursesCompte = 0;
	private final int courseId;
	
	private String fichier = "";
	
	private static final int[] score = {10, 8, 2}; // système de points
	
	private static DateTimeFormatter formatageChrono = 
			DateTimeFormatter.ofPattern("hh:mm:ss nnn");
	
	// PAS de setter
	protected int participants_min;
	protected int participants_max;
	
	protected LocalDateTime dateDepart;
	// Les équipages sont uniques, mais plusieurs peuvent réaliser 
	// le même temps (s'ils arrivent ex aequo)
	protected Hashtable<Equipage, LocalDateTime> resultats;
	
		
	// CONSTRUCTEUR	
	
	public Course(){
		Course.coursesCompte ++;
		this.courseId = Course.coursesCompte;
		this.fichier = this.getClass().getName() + this.courseId;
		this.dateDepart = LocalDateTime.now(); // défaut
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
	
	
	// MÉTHODES
	
	public String getFichier() {
		return this.fichier;
	}
	
	public void setFichier(String fichier) {
		this.fichier = fichier;
	}
	
	public int points(int position) {
		if (position > score.length)
			return 0;
		return score[position];
	}
	
	/**
	 * Ajoute un Equipage comme participant à cette course.<br/>
	 * Cette méthode N'EFFECTUE PAS LES VÉRIFICATIONS sur l'Equipage car<br/> 
	 * ces vérifications de conformité sont effectuées par le Championnat<br/>
	 */
	public void inscrire(Equipage e){
		// à l'inscription, tous les participants ont un temps à 0
		this.resultats.put(e, this.getDepart());
	}
	
	/**
	 * Classe les équipages selon leurs temps : à chaque temps (key)<br/>
	 * est associé la liste des Equipages (value) ayant effectué ce temps<br/>
	 * (qui revient à une liste d'un seul élément si aucun ex-aequo).<br/>
	 * 
	 * @return Hashtable< LocalDateTime, List< Equipage > > classement
	 */
	public Hashtable<LocalDateTime, List<Equipage>> classement() {
		/*
		 *  En ajoutant les temps dans la PriorityQueue, ils sonts classés
		 *  selon l'ordre naturel (comparator) de LocalDteTime et donc
		 *  du plus court au plus long
		 */
		Queue<LocalDateTime> temps = new PriorityQueue<LocalDateTime>();
		temps.addAll(resultats.values());
		
		Hashtable<LocalDateTime, List<Equipage>> classement = 
				new Hashtable<LocalDateTime, List<Equipage>>();
		
		List<Equipage> enPosition = null; // liste pour les ex-aquo
		
		for (LocalDateTime t : temps) {
			enPosition = new ArrayList<Equipage>();
			for ( Equipage e : resultats.keySet() ) {
				if (t == resultats.get(e))
					enPosition.add(e);
			}
			classement.put(t, enPosition);
		}
		return classement;
	}
	
	
	// MÉTHODES D'INTERFACE
	
	@Override
	public int getParticipantsMin() {
		return this.participants_min;
	}

	@Override
	public int getParticipantsMax() {
		return this.participants_max;
	}

	@Override
	public LocalDate getDate() {
		return this.dateDepart.toLocalDate();
	}
	
	@Override
	public LocalDateTime getDepart() {
		return this.dateDepart;
	}

	/**
	 *  Les équipages seront classés selon leur temps pour la Course.<br/>
	 *  <i>Hashtable DOES NOT ALLOW null keys or values.<br/>
	 *  (HashMap allows one null key and any number of null values.)</i>
	 *  @return Collection< Equipage >, éventuellement vide, jamais null
	 */ 
	@Override
	public Collection<Equipage> getEquipages() {
		if (this.resultats == null)
			this.resultats = new Hashtable<Equipage, LocalDateTime>();
		return resultats.keySet();
	}


	@Override
	public void entrerResultats() {
		for (EquipageItf e : this.getEquipages()) {
			// TODO
		}
	}

	@Override
	public void afficherResultats() {
		// TODO
		for(LocalDateTime t : this.classement().keySet()) {			
			String ligne = t.format(Course.formatageChrono);
			//t = t + 
			//String pilote = classement
			//System.out.println(ligne);
		}
	}

	@Override
	public void arriveeCourse() {
		// TODO Auto-generated method stub

	}

}
