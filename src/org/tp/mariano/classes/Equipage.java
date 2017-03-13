package org.tp.mariano.classes;

import java.util.Date;
import java.util.Map;

import org.tp.interfaces.EquipageItf;
import org.tp.interfaces.PiloteItf;
import org.tp.interfaces.VehiculeItf;

public class Equipage implements EquipageItf {

	private Map<Date, Date>tempsCourses;
	private PiloteItf pilote;
	private VehiculeItf vehicule;
	
	@Override
	public PiloteItf getPilote() {
		return this.pilote;
	}

	@Override
	public VehiculeItf getVehicule() {
		return this.vehicule;
	}

	public Map<Date, Date> getTempsCourses() {
		return this.tempsCourses;
	}
	
	@Override
	public Date getTempsCourse(Date date) {
		return this.tempsCourses.get(date);
	}

}
