package org.tp.interfaces;

import java.util.Queue;

public interface ChampionnatItf {
	
	public final int COURSES_MIN = 2;
	
	
	/**
	 * Retourne la Queue des courses classées par date
	 * @return Queue<CourseItf>
	 */
	public Queue<CourseItf> getCourseQueue();
	
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
