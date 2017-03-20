package org.tp.mariano.exceptions;

public class PiloteException extends Exception {

	private static final long serialVersionUID = 270725623033065871L;
	
	// MESSAGES
	public static final String messagePermis = "Le pilote n'a pas le permis adéquat !";
	public static final String messageMajeur = "Le pilote n'est pas majeur !";

	
	// CONSTRUCTEURS
	
	public PiloteException() {}
	
	public PiloteException(String message)
	{
		super(message);
	}
}
