package org.tp.mariano.classes;


public class Voiture extends Vehicule {

	// ATTRIBUTS
	private static final long serialVersionUID = -1452834441812244728L;
	
	private static String[] types = {"sportive", "classique"};
	private String carburant;
	
	// CONSTRUCTEUR
	
	public Voiture(){
		super();
		this.carburant = "";
	}
	
	// MÉTHODES
	
	public String[] types(){
		return Voiture.types;
	}
	
	public String carburant() {
		return this.carburant;
	}
	
}
