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
	
	
	// CONSTANTES
	
	public final int NOMBRE_COURSES_MIN = 2;
	
	
	// MÉTHODES
	
	@Override
	public String toString();
	
	/**
	 * Retourne toutes les courses composant ce Championnat.
	 * @return Collection des courses composant ce Championnat
	 */
	public Collection<? extends CourseItf> courses();
	
	/**
	 * Retourne tous les Equipages participant à ce championnat.
	 * @return Collection des Equipages participant à ce championnat
	 */
	/*
	 * nécessaire ? je ne crois pas.
	 */
	//public Collection<? extends EquipageItf> equipages();
	
	// ??
//	public void ajouterCourse(Class<? extends CourseItf> course);
//	
//	public void enleverCourse(Class<? extends CourseItf> course);

	/**
	 * Affiche les résultats du Championnat
	 */
	public void afficherResultats();
	
	/**
	 * Affiche le vainqueur pour CHAQUE Championnat une fois toutes les courses
	 * de tous les championnats effectuées.
	 */
	public void afficherVainqueurChampionnats();
	
	/**
	 * Sauve ce Championnat dans un fichier (txt) de chemin nomFichier.
	 * @param nomFichier
	 * @return
	 * @return null si échec
	 */
	public boolean sauverDansFichier(String nomFichier);
	
	/**
	 * Lit le Championnat depuis un fichier (txt) de chemin nomFichier.
	 * @param nomFichier
	 * @return le Championnat qui était stocké dans le fichier en paramètre
	 * @return null si échec
	 */
	public ChampionnatItf chargerDepuisFichier(String nomFichier);
	
}
