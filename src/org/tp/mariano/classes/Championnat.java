package org.tp.mariano.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

import org.tp.interfaces.ChampionnatItf;
import org.tp.interfaces.VehiculeItf;
import org.tp.mariano.exceptions.TypeException;

/**
 * Un Championnat est composé de Courses, au minimum 2, auxquelles participent 
 * des Equipages, composés chacun d'un Vehicule et d'un Pilote.
 * L'inscription à un Championnat entraîne la participation de l'Equipage à
 * chacune de ses Courses.
 * Un Equipage est référencé (connu, existe) avant de s'inscrire à un Championnat.
 * Un Equipage doit remplir certains critères pour s'inscrire : 
 * <ul>
 * <li>Pilote : possède le permis adéquat</li>
 * <li>Vehicule : type (Voiture ou Moto), modèle (sportif, classique) 
 * et cylindrée adéquats</li>
 * </ul>
 *  
 * @author elodie
 *
 */
public class Championnat implements ChampionnatItf{
	
	// ATTRIBUTS
	
	private static final long serialVersionUID = 4256717921797117801L;
	
	// types connus
	private static final String[] types = {"moto", "voiture"};
	
	private String nom;
	// ordonnée par la date de départ des courses
	private PriorityQueue<Course> courses; 
	
	// contraintes
	private Class<? extends Vehicule> type; // précise le type de véhicule (Voiture, Moto)
	private int cylindree; // précise la cylindrée autorisé
	private String modele; // véhicule sportif, classique...
		
	// CONTRUCTEURS
	
	/*
	 * Un Championnat peut être instancié "vide" mais ne pourra être lancé
	 * que s'il remplit les conditions
	 */
	public Championnat() {
		this.nom = "";
		this.courses = null;
		this.type = null;
		this.cylindree = 0;
		this.modele = "";
	}

	// MÉTHODES
	
	@Override
	public String toString() {
		return "Championnat [courses = " + courses + 
				"\ntype=" + type + 
				"\ncylindree=" + cylindree + 
				"\nmodele=" + modele +
				"]";
	}
	
	public String getNom() {
		return this.nom;
	}

	public boolean setModele(String modele) {
		this.modele  = modele;
		return true;
	}

	public boolean setCylindree(int cylindree) {
		this.cylindree = cylindree;
		return true;
	}
	
	// contrainte : 2 courses ne doivent pas se dérouler le même jour
	public boolean ajouterCourse(Course nouvelle) {
		for (Course course : this.courses) {
			if ( nouvelle.getDate().compareTo(course.getDate()) == 0 )
					return false;
		}
		return courses.add(nouvelle);
	}
	
	// MÉTHODES D'INTERFACE

	/**
	 * Renvoie la liste (queue) des courses du championnat
	 * Renvoie une queue vide si CourseQueue n'était pas créée
	 */
	@Override
	public Queue<Course> getCourses() {
		if (this.courses == null) 
			this.courses = new PriorityQueue<Course>();
		return this.courses;
	}

	@Override
	public String getType() {
		return this.type.getName();
	}

	@Override
	public String getModele() {
		return this.modele;
	}

	@Override
	public int getCylindree() {
		return this.cylindree;
	}

	@Override
	public void afficherResultatsCourses() {
		// TODO Auto-generated method stub

	}

	@Override
	public void afficherResultats() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public boolean sauverDansFichier(String nomFichier) {
		File file = new File (nomFichier);
		ObjectOutputStream oos = null;
		try {
		   oos = new ObjectOutputStream(new FileOutputStream(file));
		   oos.writeObject(this);
		   oos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
		    if (oos != null) {
		        try {
		            oos.close();
		        } catch (IOException e) {
		        	e.printStackTrace();
		        	return false;
		        	}
		        }
		    }
		return true;
		}
	
	@Override
	public ChampionnatItf chargerDepuisFichier(String nomFichier) {
		File file = new File (nomFichier);
		ChampionnatItf c = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream (file);
			ObjectInputStream ois = new ObjectInputStream (fis);		
			c = (ChampionnatItf) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
		        try {
		            fis.close();
		        } catch (IOException e) {
		        	return null;
		        	}
		        }
		}
		return c;
	}

}
