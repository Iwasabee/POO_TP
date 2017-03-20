package org.tp.mariano.classes;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Une course de Voiture n'a aucune méthode particulière par rapport à une<br/>
 * Course Abstraite (dont elle hérite).
 * @author elodie
 *
 */
public class CourseVoiture extends Course {
	
	// ATTRIBUTS	
	
	private static final long serialVersionUID = 1725043232717180129L;

	final static int PARTICIPANTS_MIN = 2;
	final static int PARTICIPANTS_MAX = 16;
	
	{
		this.participants_min = CourseVoiture.PARTICIPANTS_MIN;
		this.participants_max = CourseVoiture.PARTICIPANTS_MAX;
	}
	
	
	// CONSTRUCTEUR(S)
	public CourseVoiture(){
		super();	
	}
	
	public CourseVoiture(LocalDateTime depart){
		super(depart);
	}
	
	public CourseVoiture(int year, int month, int day,
			int hour, int minutes, int seconds, int nanoseconds){
		super(year, month, day, hour, minutes, seconds, nanoseconds);
	}

}
