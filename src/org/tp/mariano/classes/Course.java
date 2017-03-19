package org.tp.mariano.classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

import org.tp.interfaces.CourseItf;

/**
 * <ul>
 * <li>LocalDate dateDepart</li>
 * <li>SortedMap < LocalDateTime, Equipage > classement</li>
 * @author elodie
 *
 */
public abstract class Course implements CourseItf {
	
	private static final long serialVersionUID = 714618350493019619L;
	
	private static DateTimeFormatter formatageChrono = 
			DateTimeFormatter.ofPattern("hh:mm:ss nnn");
	
	private LocalDate dateDepart;
	// les équipages seront classés selon leur temps pour la Course
	private SortedMap<LocalDateTime, Equipage> classement;
		
	// CONSTRUCTEUR	
	
	public Course(){
		this.dateDepart = LocalDate.now();
	}
	
	public Course(int year, int month, int dayOfMonth){
		this.dateDepart = LocalDate.of(year, month, dayOfMonth);
	}

	@Override
	public LocalDate getDate() {
		return this.dateDepart;
	}

	@Override
	public Collection<Equipage> getEquipages() {
		if (this.classement == null)
			this.classement = 
			new TreeMap<LocalDateTime, Equipage>();
		return (Collection<Equipage>)classement.values();
	}


	@Override
	public void entrerResultats() {
		// TODO Auto-generated method stub

	}

	@Override
	public void afficherResultats() {
		for(LocalDateTime t : this.classement.keySet()) {			
			String temps = t.format(Course.formatageChrono);
			//String pilote = classement
			//System.out.println(ligne);
		}
	}

	@Override
	public void arriveeCourse() {
		// TODO Auto-generated method stub

	}

}
