package org.tp.mariano.classes;

import org.tp.interfaces.VehiculeItf;

/**
 * La classe abstraite <class>Vehicule</class> implémente <interface>VehiculeItf</inteface>.</br>
 * Ses attributs (private) :
 * <ul>
 * <li>vitesseMax : double</li>
 * <li>cylindree : int</li>
 * <li>modele : String</li>
 * </ul>
 * @author Élodie 
 * @see <interface>VehiculeItf</inteface> 
 * @see<class>Voiture</class> 
 * @see<class>Moto</class>
 */
public abstract class Vehicule implements VehiculeItf {
	
	private static final long serialVersionUID = 1066567529758464271L;
	
	private double vitesseMax;
	private int cylindree;
	private String modele;

	@Override
	public double getVitesseMax() {
		return this.vitesseMax;
	}

	@Override
	public int getCylindree() {
		return this.cylindree;
	}

	@Override
	public String getModele() {
		return this.modele;
	}

}
