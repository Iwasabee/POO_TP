package org.tp.mariano.classes;

import org.tp.interfaces.VehiculeItf;

/**
 * La classe abstraite <class>Vehicule</class> implémente <interface>VehiculeItf</inteface>.</br>
 * Ses attributs principaux :
 * <ul>
 * <li>vitesseMax : double</li>
 * <li>cylindree : int</li>
 * <li>modele : String</li>
 * <li>modeles : String[]</li>
 * </ul>
 * @author Élodie 
 * @see <interface>VehiculeItf</inteface> 
 * @see<class>Voiture</class> 
 * @see<class>Moto</class>
 */
public abstract class Vehicule implements VehiculeItf {
	
	//----------  ATTRIBUTS
	
	private static final long serialVersionUID = 1066567529758464271L;
	
	private static int vehiculesCompte = 0;
	private final int vehiculeId;
	
	private String fichier = "";
	
	protected double vitesseMax;
	protected int cylindree;
	protected String modele;
	
	
	// ---------- CONSTRUCTEUR
	
	public Vehicule () {
		vehiculesCompte ++;
		this.vehiculeId = vehiculesCompte;
		this.fichier = this.getClass().getName() + this.vehiculeId;
		this.vitesseMax = 0;
		this.cylindree = 0;
		this.modele = "";
	}
	
	
	// MÉTHODES
	
	@Override
	public String toString() {
		//TODO >> Moto Voiture
		return ("Vehicule [" +
				"vehiculeId=" + vehiculeId + 
				"\nvitesseMax=" + vitesseMax + 
				"\ncylindree=" + cylindree + 
				"\n");
	}
	
	
	public String fichier(){
		return this.fichier;
	}
	
	public void setVitesseMax(double v) {
		this.vitesseMax = v;
	}

	public void setCylindree(int c) {
		this.cylindree = c;
	}

	public void setModele(String m) {
		this.modele = m;
	}
	
	
	// ---------- MÉTHODES D'INTERFACE

	@Override
	public String type() {
		return this.getClass().getName().toLowerCase();
	}
	
	@Override
	public double vitesseMax() {
		return this.vitesseMax;
	}

	@Override
	public int cylindree() {
		return this.cylindree;
	}

	@Override
	public String modele() {
		return this.modele;
	}

}
