package org.tp.mariano.classes;

import java.util.Arrays;
import java.util.List;

public class Voiture extends Vehicule {

	// ATTRIBUTS
	private static final long serialVersionUID = -1452834441812244728L;
	
	private static List<String> modeles = Arrays.asList("sport", "enduro", "trial");
	
	private String carburant;
	
	// CONSTRUCTEUR
	
	public Voiture(){
		super();
		this.carburant = "";
	}
	
	// MÉTHODES
	
	public List<String> modeles(){
		return Voiture.modeles;
	}
	
	public String carburant() {
		return this.carburant;
	}
	
}
