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
import org.tp.mariano.exceptions.VehiculeException;

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
	
	private static DateTimeFormatter formatageChrono = 
			DateTimeFormatter.ofPattern("hh:mm:ss nnn");
	
	private int[] score = {10, 8, 2};
	
	// PAS de setter
	protected int participants_min;
	protected int participants_max;
	
	protected Class<? extends Vehicule> type;
	protected String modele;
	protected int cylindree;
	
	protected LocalDateTime dateDepart;
	/*
	 *  Les équipages sont uniques, mais plusieurs peuvent réaliser 
	 *  le même temps (s'ils arrivent ex aequo)
	 */
	protected Hashtable<Equipage, LocalDateTime> temps;
	
		
	// CONSTRUCTEUR	
	
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
	
	
	// MÉTHODES
	
	public String fichier() {
		return this.fichier;
	}
	
	public void setFichier(String fichier) {
		this.fichier = fichier;
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
	
	
	public int points(int position) {
		if (position > score.length)
			return 0;
		return score[position];
	}
	
	/**
	 * Ajoute un Equipage comme participant à cette course.<br/>
	 * Attention, certaines contraintes sont à vérifier :
	 * <ul>
	 * <li>le type du Vehicule est conforme</li>
	 * <li>le modele du Vehicule est conforme</li>
	 * <li>la cylindree du Vehicule est conforme</li>
	 * <li>(l'equipage est disponible à cette date ?)</li>
	 * </ul>
	 */
	public void inscrire(Equipage e) throws VehiculeException{
		// à l'inscription, tous les participants ont un temps à 0
		try {
			if (e.vehicule().type() != this.type())
				throw new VehiculeException(VehiculeException.messageType);
			if (e.vehicule().modele() != this.modele())
				throw new VehiculeException(VehiculeException.messageModele);
			if (e.vehicule().cylindree() != this.cylindree())
				throw new VehiculeException(VehiculeException.messageCylindree);
		} finally {}
		this.temps.put(e, this.depart());
	}
	
	/**
	 * Classe les équipages selon leurs temps (une fois la course finie) : 
	 * <ul>
	 * <li>pour chaque temps, on déclare une clef position (Integer)</li>
	 * <li>à chaque position, on associe en valeur une liste des équipages</li>
	 * </ul>
	 * (liste d'un seul élément si aucun ex-aequo).<br/>
	 * 
	 * @return Hashtable< LocalDateTime, List< Equipage > > classement
	 */
	public Hashtable<Integer, List<Equipage>> classement() {
		/*
		 *  En ajoutant les temps dans la PriorityQueue, ils sonts classés
		 *  selon l'ordre naturel (comparator) de LocalDteTime, et donc
		 *  du plus court au plus long
		 */
		Queue<LocalDateTime> temps = new PriorityQueue<LocalDateTime>();
		temps.addAll(this.temps.values());
		
		Hashtable<Integer, List<Equipage>> classement = 
				new Hashtable<Integer, List<Equipage>>();
		
		int position = 1;
		List<Equipage> equipages = null; // liste pour les ex-aquo
		
		for (LocalDateTime t : temps) {
			equipages = new ArrayList<Equipage>();
			for ( Equipage e : this.temps.keySet() ) {
				if (t == this.temps.get(e))
					equipages.add(e);
			}
			classement.put(position, equipages);
		}
		return classement;
	}
	// MÉTHODES D'INTERFACE
	
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

	/**
	 *  Les équipages seront classés selon leur temps pour la Course.<br/>
	 *  <i>Hashtable DOES NOT ALLOW null keys or values.<br/>
	 *  (HashMap allows one null key and any number of null values.)</i>
	 *  @return Collection< Equipage >, éventuellement vide, jamais null
	 */ 
	public Collection<Equipage> equipages() {
		if (this.temps == null)
			this.temps = new Hashtable<Equipage, LocalDateTime>();
		return temps.keySet();
	}


	@Override
	public void entrerResultats() {
		for (EquipageItf e : this.equipages()) {
			// TODO
		}
	}

	@Override
	public void afficherResultats() {
		// TODO
	}

	@Override
	public void arriveeCourse() {
		// TODO Auto-generated method stub

	}

}

	
