package org.tp.mariano.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.tp.interfaces.ChampionnatItf;
import org.tp.mariano.exceptions.ChampionnatException;

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
	
	// ---------- ATTRIBUTS
	
	private static final long serialVersionUID = 4256717921797117801L;
	
	// public final int NOMBRE_COURSES_MIN = 2; // ex S1
	
	// 25 nationalités
	private List<String> nationalites = Arrays.asList(
			"Angleterre", "Belgique", "Chine", "Danemark", "Espagne",
			"France", "Guatemala", "Hongrie", "Irlande", "Japon",
			"Kenia", "Lituanie", "Maroc", "Nouvelle-Zélande", "Ouganda", 
			"Portugal", "Quatar", "Russie", "Suisse", "Tibet",
			"Uruguay", "Vénézuela", "Wallis-et-Futuna", "Yémen", "Zambie"
			);
	
	private String nom;
	// ordonnée par la date de départ des courses
	private PriorityQueue<Course> courses; // ex S1
	//private boolean enCours; // TODO si true, empêche l'ajout de course ou de participant
	
	// ---------- CONTRUCTEURS
	
	/**
	 * Un Championnat peut être instancié "vide".<br/>
	 * Dans ce cas, la première Course ajoutée fournit les contraintes<br/>
	 * (type, modele, cylindree, nombres max et min de participants...)<br/>
	 * Un championnat ne pourra être lancé s'il ne remplit pas les conditions<br/>
	 * de nombre minimal de course (2) et de de participants (variable).<br/>
	 * 
	 */
	public Championnat() {
		this.nom = "";
		this.courses = new PriorityQueue<Course>();
	}
	
	
	// ---------- MÉTHODES
	
	@Override
	public String toString() {
		String str = "Championnat : " + this.nom;
		for (Course c : this.courses()) {
			str = str + "\n" + c.toString();
		}
		return str;
	}
	
	public String nom() {
		return this.nom;
	}
	
	public String type() {
		if (this.courses.isEmpty() || (this.courses == null) )
			return null;
		return this.courses.peek().type();
	}
	
	public String modele() {
		if (this.courses.isEmpty() || (this.courses == null) )
			return null;
		return this.courses.peek().modele();
	}

	
	public Integer cylindree() {
		if (this.courses.isEmpty() || (this.courses == null) )
			return null;
		return this.courses.peek().cylindree();
	}
	
	public List<String> nationalites() {
		if (this.nationalites == null)
			return new ArrayList<String>();
		return this.nationalites;
	}
	
	/**
	 * Vérifie si on peut planifier une Course de ce Championnat à cette date.
	 * @param date
	 * @return true si aucune autre course du Championnat n'a lieu à cette date.
	 * @return false si une course de ce championnat a déjà lieu à cette date.
	 */
	public boolean dateDisponible(LocalDate date) {
		for (Course course : this.courses) {
			if ( course.date().compareTo(date) == 0 )
					return false;
		}
		return true;
	}
	
	/**
	 * Pour une Course donnée, vérifie qu'elle respecte les contraintes de ce<br/>
	 * Championnat. S'il ne contient aucune course, elle est acceptée.
	 * <ul>
	 * <li>le type de Vehicule</li>
	 * <li>le modele de Vehicule</li>
	 * <li>la cylindree de Vehicule</li>
	 * </ul>
	 * @param Course course : la course à tester
	 * @return true si la Course peut être intégrée au Championnat
	 * @return false si au moins une des contraintes n'est pas respectée
	 * 
	 */
	public boolean courseConforme(Course course) {
		if ( (course.type() == this.type()) || (this.type() == null) )
			return true;
		return false;
	}
	
	// contrainte : 2 courses ne doivent pas se dérouler le même jour
	/**
	 * Ajouter une Course à un Championnat. Plusieurs contraintes :
	 * <ul>
	 * <li>2 courses ne peuvent pas se dérouler à la même date</li>
	 * <li>le type de Vehicule imposé par la course doit être conforme</li>
	 * <li>le modele de Vehicule imposé par la course doit être conforme</li>
	 * <li>la cylindree de Vehicule imposé par la course doit être conforme </li>
	 * </ul>
	 * @param nouvelle
	 * @return
	 */
	public void ajouterCourse(Course course) throws ChampionnatException {
		try {
			if (course == null)
				throw new NullPointerException();
			if (! (courseConforme(course)) )
				throw new ChampionnatException(ChampionnatException.messageCourse);
			if (! (this.dateDisponible(course.date())) )
				throw new ChampionnatException(ChampionnatException.messageDate);
		} finally{};
	}
	
	// ---------- MÉTHODES D'INTERFACE

	/**
	 * Renvoie la liste (queue) des courses du championnat
	 * Renvoie une queue vide si CourseQueue n'était pas créée
	 */
	@Override
	public Queue<Course> courses() {
		if (this.courses == null) 
			this.courses = new PriorityQueue<Course>();
		return (Queue<Course>) this.courses;
	}
	
//	@Override
//	public void ajouterCourse(Class<? extends CourseItf> course) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void enleverCourse(Class<? extends CourseItf> course) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void afficherResultats() {
		for (Course c : this.courses) {
			c.arriveeCourse();
		}
	}

	
	@Override
	public void afficherVainqueurChampionnats() {
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
