package org.tp.interfaces;

import java.util.Collection;
import java.util.Date;

public interface CourseItf {	
	
	// date du départ yyyy MM dd hh mm ss (ms?)
	public Date getDate();
	
	// autorise les doublons (temps 00:00 avant la course)
	// mais PAS les valeurs null
	public Collection<EquipageItf> getEquipages();
	
	// contraintes
	public int getParticipantsMin();
	public int getParticipantsMax();
	
	public void entrerResultats();
	
	// Pour tous les pilotes et dans l'ordre (logique)
	// classement | pilote | score | temps
	public void afficherResultats();
	
	// fonctionnalité pour rentrer les temps de chaque participants
	// puis affiche les résultats de la course
	public void arriveeCourse();

}
