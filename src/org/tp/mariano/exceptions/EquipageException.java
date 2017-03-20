package org.tp.mariano.exceptions;

public class EquipageException extends Exception {

	private static final long serialVersionUID = 3303274610463559482L;

	public static final String messagePilote = "L'équipage n'a pas de pilote !";
	public static final String messageVoiture = "L'équipage n'a pas de véhicule !";

	
	// CONSTRUCTEURS
	
	public EquipageException() {}
	
	public EquipageException(String message)
	{
		super(message);
	}
}

