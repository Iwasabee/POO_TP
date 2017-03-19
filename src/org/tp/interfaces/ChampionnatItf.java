package org.tp.interfaces;

import java.io.Serializable;
import java.util.Collection;

/**
 * Interface commune pour la classe Championnat.<br/>
 * 
 * @author Élodie Mariano, Philippe Normand, Roux Raverdy
 *
 */

public interface ChampionnatItf extends Serializable{
	
	public final int NOMBRE_COURSES_MIN = 2;
	
	// Retourne les courses composant le championnat.
	// test : <? extends CourseItf> pour permettre <Course>
	public Collection<? extends CourseItf> getCourses();
	
	// contraintes sur les véhicules
	public String getType(); // moto ou voiture
	public String getModele(); // sport, classique...
	public int getCylindree(); // cc

	/*
	 * Affiche dans l'ordre les résultats des courses
	 * revient à appeler dans l'ordre afficherResultats() de chaque course
	 */
	public void afficherResultatsCourses();
	
	// affiche les résultats du championnat 
	// classement | pilote | score | temps total
	public void afficherResultats();
	
	public boolean sauverDansFichier(String nomFichier);
	
	public ChampionnatItf chargerDepuisFichier(String nomFichier);
	
}
