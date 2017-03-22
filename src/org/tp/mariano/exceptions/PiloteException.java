package org.tp.mariano.exceptions;

public class PiloteException extends AbstractException {
	
	// ---------- ATTRIBUTS
	private static final long serialVersionUID = 270725623033065871L;
	
	// ---------- MESSAGES
	public static final String messageNom = 
			"Le nom du pilote n'est pas conforme !";
	public static final String messagePrenom = 
			"Le prénom du pilote n'est pas conforme !";
	public static final String messageNationalite = 
			"La nationalité du pilote n'est pas conforme !";
	public static final String messageMajeur = 
			"Le pilote n'est pas majeur !";
	
	public static final String messagePermis = 
			"Le pilote n'a pas le permis adéquat !";

	
	// ---------- CONSTRUCTEURS
	
	public PiloteException() {
		super();
	}
	
	public PiloteException(String message) {
		super(message);
	}
}
