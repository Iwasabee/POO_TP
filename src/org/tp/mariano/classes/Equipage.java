package org.tp.mariano.classes;

import java.time.LocalDateTime;

import org.tp.interfaces.EquipageItf;
import org.tp.interfaces.PiloteItf;
import org.tp.interfaces.VehiculeItf;

/**
 * 
 * @author Élodie Mariano
 *
 */
public class Equipage implements EquipageItf {
	
	private static final long serialVersionUID = -3921934647760086873L;
	
	private PiloteItf pilote;
	private VehiculeItf vehicule;
	
	// CONSTRUCTEUR
	public Equipage(Pilote p, Vehicule v) {
		// 1. il faut un Pilote et un Vehicule
	}

	// MÉTHODES
	
	public boolean rentrerTemps(LocalDateTime temps) {
		return false;
	}
	
	// MÉTHODES D'INTERFACE

	@Override
	public PiloteItf getPilote() {
		return this.pilote;
	}

	@Override
	public VehiculeItf getVehicule() {
		return this.vehicule;
	}
}
