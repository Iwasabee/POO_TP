package org.tp.mariano.classes;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

import org.tp.interfaces.CourseItf;
import org.tp.interfaces.EquipageItf;

public abstract class Course implements CourseItf {
	
	private Date dateDepart;
	private Set<EquipageItf> equipages;
	

	@Override
	public Date getDate() {
		return this.dateDepart;
	}

	@Override
	public Collection<EquipageItf> getEquipages() {
		if (this.equipages == null)
			this.equipages = new HashSet<EquipageItf>();
		return equipages;
	}


	@Override
	public void entrerResultats() {
		// TODO Auto-generated method stub

	}

	@Override
	public void afficherResultats() {
		// TODO Auto-generated method stub

	}

	@Override
	public void arriveeCourse() {
		// TODO Auto-generated method stub

	}

}
