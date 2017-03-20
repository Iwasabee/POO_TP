package org.tp.mariano.exceptions;

/**
 * Exception levée soit lorsqu'on tente d'ajouter une course à un Championnat
 * ou de modifier la date d'une course d'un Championnat à une date à laquelle
 * une autre course du Cahmpionnat a déjà lieu.
 * 
 * @author elodie
 *
 */
public class DateCourseException extends Exception{
	
	private static final long serialVersionUID = 6759469914656566074L;
	
	public static final String messageConflit = "Une course du championnat a déjà lieu ce jour !";

	
	// CONSTRUCTEURS
	
	public DateCourseException() {}
	
	public DateCourseException(String message)
	{
		super(message);
	}

}
