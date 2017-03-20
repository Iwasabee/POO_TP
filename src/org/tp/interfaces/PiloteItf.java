package org.tp.interfaces;

import java.io.Serializable;
import java.util.List;

/**
 * Interface pour un Pilote de Vehicule.
 * L'interface ne fait qu'imposer la présence des éléments définissant un pilote d'après le sujet
 * par des fonctions de type getter (sous-entend un attribut par méthode, mais ne force pas).
 * N.B. : un Pilote peut avoir plusieurs permis (un permis par type de véhicule).
 * @author Elodie Mariano, Philippe Normand, Roux Raverdy
 *
 */
public interface PiloteItf extends Serializable {
	
	public String nom();
	public String prenom();
	public int age(); // tip : avoir une Date en attribut
	public String nationalite();
	public List<String> permis();

}
