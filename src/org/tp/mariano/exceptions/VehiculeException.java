package org.tp.mariano.exceptions;

public class VehiculeException extends AbstractException {

	// ---------- ATTRIBUTS
	private static final long serialVersionUID = -7650933680506637229L;
	
	// ---------- MESSAGES
	public static final String messageType = 
			"Le type du véhicule n'est pas conforme ! ";
	public static final String messageModele = 
			"Le modèle du véhicule n'est pas conforme ! ";
	public static final String messageCylindree = 
			"La cylindrée du véhicule n'est pas conforme ! ";
	// propres aux Voitures
	public static final String messageRouesMotrices = 
			"Le nombre de roues motrices n'est pas valide ! ";
	public static final String messageCarburant = 
			"Le carburant n'est pas valide ! ";
	// propres aux Motos
	public static final String messagePoids = 
			"Le poids de la moto n'est pas valide ! ";

	
	// ---------- CONSTRUCTEURS
	
	public VehiculeException() {
		super();
	}
	
	public VehiculeException(String message){
		super(message);
	}
	
}
