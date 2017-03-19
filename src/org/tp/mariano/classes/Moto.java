package org.tp.mariano.classes;

public class Moto extends Vehicule {
	
	// ATTRIBUTS
	
	private static final long serialVersionUID = -8711150777346661042L;
	
	private double poids;
	
	// CONSTRUCTEURS
	
	public Moto() {
		super();
		this.poids = 0;
	}
	
	// MÉTHODES
	
	public double getPoids() {
		return this.poids;
	}

}
