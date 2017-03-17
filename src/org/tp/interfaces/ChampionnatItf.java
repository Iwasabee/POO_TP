package org.tp.interfaces;

import java.util.Collection;

/**
 * Interface commune pour à implémenter par un objet Championnat
 * @author Élodie Mariano, Philippe Normand, Roux Raverdy
 *
 */

public interface ChampionnatItf {
	
	public final int COURSES_MIN = 2;
	
	/**
	 * Retourne les courses composant le championnat
	 * @return Queue<CourseItf>
	 */
	public Collection<CourseItf> getCourses();
	
	// contraintes sur les véhicules
	public String getType(); // moto ou voiture
	public String getModele(); // sport, classique...
	public int getCylindree(); // cc
	
	// ajout d'un participant
	public void inscription();

	// affiche dans l'ordre les résultats des courses
	// revient à appeler dans l'ordre afficherResultats() de chaque course
	public void afficherResultatsCourses();
	
	// affiche les résultats du championnat 
	// classement | pilote | score | temps total
	public void afficherResultats();
	
	
}
