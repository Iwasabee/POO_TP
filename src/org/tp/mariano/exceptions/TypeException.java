package org.tp.mariano.exceptions;

public class TypeException extends Exception {

	// ATTRIBUTS
	
	private static final long serialVersionUID = 9053037271624111673L;
	public static final String messageDefaut = "Type de véhicule non conforme !";

	
	// CONSTRUCTEURS
	
	public TypeException() {}
	
	public TypeException(String message)
	{
		super(message);
	}

}
