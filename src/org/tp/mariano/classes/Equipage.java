package org.tp.mariano.classes;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.tp.interfaces.*;

/**
 * 
 * @author Élodie Mariano
 *
 */
public class Equipage implements EquipageItf {
	
	private PiloteItf pilote;
	private VehiculeItf vehicule;
	
	// Map qui associe à la Date de départ d'une course le temps réalisé
	// par l'équipage lors de cette course
	private Map<Date, Date> tempsCourses;

	@Override
	public PiloteItf getPilote() {
		return this.pilote;
	}

	@Override
	public VehiculeItf getVehicule() {
		return this.vehicule;
	}

	@Override
	public Date getTempsCourse(Date date) {
		return this.tempsCourses.get(date);
	}

	@Override
	public Map<Date, Date> getTempsCourses() {
		if (this.tempsCourses == null)
			this.tempsCourses = new HashMap<Date, Date>();
		return this.tempsCourses;
	}

}
