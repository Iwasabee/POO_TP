package org.tp.mariano.exceptions;

public class VehiculeException extends Exception {

	private static final long serialVersionUID = -7650933680506637229L;
	// MESSAGES
	public static final String messageType = 
			"Le type du véhicule n'est pas conforme ! ";
	public static final String messageModele = 
			"Le modèle du véhicule n'est pas conforme ! ";
	public static final String messageCylindree = 
			"La cylindrée du véhicule n'est pas conforme ! ";

	
	// CONSTRUCTEURS
	
	public VehiculeException() {}
	
	public VehiculeException(String message)
	{
		super(message);
	}
}
