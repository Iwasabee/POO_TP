package org.tp.mariano.exceptions;


public class NombreDeParticipantsException extends Exception {

	private static final long serialVersionUID = 7458403117816074808L;

	//CONSTRUCTEURS
	public NombreDeParticipantsException() {}
	
	public NombreDeParticipantsException(String message)
	{
		super(message);
	}
}