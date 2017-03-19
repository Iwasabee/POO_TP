package org.tp.interfaces;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * 
 * @author Élodie Mariano, Philippe Normand, Roux Raverdy
 * 
 */
public interface CourseItf extends Serializable {	
	
	// LocalDate standard JDK 8
	/**
	 * Date à laquelle s'est déroulée ou se déroulera cette course<br/>
	 * @return LocalDate : yyyy-MM-dd
	 */
	public LocalDate getDate();
	/**
	 * Date précise du départ 
	 * @return LocalDateTime : yyyy MM dd hh mm ss SSS
	 */
	public LocalDateTime getDepart();
	
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
