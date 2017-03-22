package org.tp.interfaces;

import java.io.Serializable;

// capsule pour associer pilote et véhicule pour un Championnat
public interface EquipageItf extends Serializable {
	
	@Override
	public String toString();
	
	public PiloteItf pilote();
	public VehiculeItf vehicule();
	
	// C'est pas à l'Equipage d'avoir conscience de ses temps.
	// Les temps c'est des résultats d'une Course.
}
