package org.tp.mariano.exceptions;


public class InscriptionException extends AbstractException {
	
	// ---------- ATTRIBUTS
	private static final long serialVersionUID = 7458403117816074808L;
	
	public static final String messageDate = 
			"Il n'est plus possible de s'inscrire à cette course !";
	
	public static final String messageLimite = 
			"Le nombre de participants maximum est atteint !";
	
	public static final String messageEnCours = 
			"Les inscriptions sont closes !";

	
	// ---------- CONSTRUCTEURS
	public InscriptionException() {
		super();
	}
	
	public InscriptionException(String message){
		super(message);
	}
}