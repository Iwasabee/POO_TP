package org.tp.interfaces;

import java.io.Serializable;


/**
 * Interface commune aux Véhicules, qui se définissent notamment par leur :
 * <ul>
 * <li>type</li>
 * <li>vitesseMax</li>
 * <li>cylindree</li>
 * <li>modele</li>
 * </ul>
 * L'interface impose donc des getters (syntaxe simple : attribut() ).
 */
public interface VehiculeItf extends Serializable{

	/**
	 * 
	 * @return
	 */
	public String type(); // correspond par exemple à "moto", "voiture"...
	public double vitesseMax();
	public int cylindree();
	public String modele();
	
}
