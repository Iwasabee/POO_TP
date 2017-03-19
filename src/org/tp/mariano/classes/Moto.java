package org.tp.mariano.classes;

import java.util.Arrays;
import java.util.List;

public class Moto extends Vehicule {
	
	// ATTRIBUTS
	
	private static final long serialVersionUID = -8711150777346661042L;
	
	private static List<String> modeles = Arrays.asList("sport", "enduro", "trial");
	
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
	
	public List<String> modeles() {
		return Moto.modeles;
	}

}
