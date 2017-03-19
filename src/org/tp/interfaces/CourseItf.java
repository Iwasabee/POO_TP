package org.tp.interfaces;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

/**
 * 
 * @author Élodie Mariano, Philippe Normand, Roux Raverdy
 * 
 */
public interface CourseItf extends Serializable {	
	
	// date du départ yyyy MM dd hh mm ss (ms?)
	// LocalDate standard JDK 8
	public LocalDate getDate();
	
	// autorise les doublons (temps 00:00 avant la course)
	// mais PAS les valeurs null
	public Collection<? extends EquipageItf> getEquipages();
	
	// contraintes
	public int getParticipantsMin();
	public int getParticipantsMax();
	
	// Entrer les temps pour tous les participants
	public void entrerResultats();
	
	// Pour tous les pilotes et dans l'ordre (logique)
	// classement | pilote | score | temps
	public void afficherResultats();
	
	// fonctionnalité pour rentrer les temps de chaque participants
	// puis affiche les résultats de la course
	public void arriveeCourse();

}
