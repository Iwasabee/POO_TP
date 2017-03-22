package org.tp.mariano.classes;

import java.time.LocalDateTime;

import org.tp.interfaces.EquipageItf;
import org.tp.interfaces.PiloteItf;
import org.tp.interfaces.VehiculeItf;
import org.tp.mariano.exceptions.EquipageException;
import org.tp.mariano.exceptions.PiloteException;

/**
 * 
 * @author Élodie Mariano
 *
 */
public class Equipage implements EquipageItf {
	
	
	// ---------- ATTRIBUTS
	
	private static final long serialVersionUID = -3921934647760086873L;
	
	private PiloteItf pilote;
	private VehiculeItf vehicule;
	
	// ---------- CONSTRUCTEUR
	
	/**
	 *  la création d'un équipage effectue certaines vérifications :
	 *  <ul>
	 *  <li>Un équipage DOIT contenir un pilote et un véhicule</li>
	 *  <li>Un Pilote doit être majeur (age > 18)</li>
	 *  <li>Un Pilote doit avoir le permis adapté pour le Vehicule</li>
	 *  </ul>
	 * @param p le Pilote
	 * @param v le Vehicule (Moto, Voiture...)
	 */
	public Equipage(Pilote p, Vehicule v) 
			throws EquipageException, PiloteException {
		try {
			// Il faut un Pilote et un Vehicule
			if ( (p == null) || (v == null) )
				throw(new EquipageException());
			
			// Un Pilote ne peut pas participer s'il n'est pas majeur
			if (p.age() < 18)
				throw(new PiloteException(PiloteException.messageMajeur));
			
			// Un Pilote doit avoir le permis adapté à son Vehicule
			String typeVehicule = v.getClass().getName().toLowerCase();	
			if (p.permis().contains(typeVehicule)) 
				throw(new PiloteException(PiloteException.messagePermis));
		} finally{}; // TODO
	}

	// ---------- MÉTHODES
	
	public boolean rentrerTemps(LocalDateTime temps) {
		return false;
	}
	
	// ---------- MÉTHODES D'INTERFACE

	@Override
	public PiloteItf pilote() {
		return this.pilote;
	}

	@Override
	public VehiculeItf vehicule() {
		return this.vehicule;
	}
}
