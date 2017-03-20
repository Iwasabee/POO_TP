package org.tp.mariano.classes;

import java.time.LocalDateTime;

/**
 * Une course de Moto n'a aucune méthode particulière par rapport à une<br/>
 * Course Abstraite (dont elle hérite).
 * 
 * @author Élodie Mariano
 */
public class CourseMoto extends Course {
	
	// ATTRIBUTS	
	
	private static final long serialVersionUID = 3588347861377038534L;

	final static int PARTICIPANTS_MIN = 2;
	final static int PARTICIPANTS_MAX = 16;
	
	{
		this.participants_min = CourseMoto.PARTICIPANTS_MIN;
		this.participants_max = CourseMoto.PARTICIPANTS_MAX;
	}
	
	
	// CONSTRUCTEUR(S)
	public CourseMoto(){
		super();
	}
	
	public CourseMoto(LocalDateTime depart){
		super(depart);
	}
	
	public CourseMoto(int year, int month, int day,
			int hour, int minutes, int seconds, int nanoseconds){
		super(year, month, day, hour, minutes, seconds, nanoseconds);
	}
	
}
