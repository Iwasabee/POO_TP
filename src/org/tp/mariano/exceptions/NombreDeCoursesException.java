package org.tp.mariano.exceptions;


public class NombreDeCoursesException extends Exception {

	private static final long serialVersionUID = 7458403117816074808L;

	//CONSTRUCTEURS
	public NombreDeCoursesException() {}
	
	public NombreDeCoursesException(String message)
	{
		super(message);
	}
}
