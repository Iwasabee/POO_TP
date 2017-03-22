package org.tp.mariano.exceptions;

public class ChampionnatException extends AbstractException{

	private static final long serialVersionUID = -7964477269090390564L;
	
	// MESSAGES
	
	public static final String messageCourse = 
			"La course n'est pas conforme pour ce championnat ! ";
	public static final String messageDate = 
			"Une course du championnat a déjà lieu à cette date ! ";
	public static final String messageEquipage = 
			"L'équipage n'est pas conforme pour ce championnat ! ";

	
	// CONSTRUCTEURS
	
	public ChampionnatException() {
		super();
	}
	
	public ChampionnatException(String message)
	{
		super(message);
	}
}
