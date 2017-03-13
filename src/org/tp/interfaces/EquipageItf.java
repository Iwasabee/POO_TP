package org.tp.interfaces;

import java.util.Date;
import java.util.Map;

// capsule pour associer pilote et véhicule pour un championnat

public interface EquipageItf {
	
	public PiloteItf getPilote();
	public VehiculeItf getVehicule();
	
	// contient les temps par course d'un championnat
	// <K date course, V temps du participant>
	//public Map<Date, Date> getTempsCourses(); 
	
	/**
	 * Récupérer le temps mis par l'équipage pour une course du championnat
	 * identifiée par sa date de départ
	 * @param date
	 * @return Date
	 */
	public Date getTempsCourse(Date date);
	
}
