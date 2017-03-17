package org.tp.mariano.classes;

import java.util.Collection;
import java.util.PriorityQueue;
import java.util.Queue;

import org.tp.interfaces.ChampionnatItf;
import org.tp.interfaces.CourseItf;

public class Championnat implements ChampionnatItf {
	
	// ATTRIBUTS
	private Queue<CourseItf> courses; // liste ordonnée par date des courses
	private String type; // précise le type de véhicule autorisé
	private int cylindree; // précise la cylindrée autorisé
	private String modele; // véhicule sportif, classique...
	
	// CONTRUCTEURS
	
	/*
	 * 
	 */
	public Championnat(){
		
	}
	
	

	/**
	 * Renvoie la liste (queue) des courses du championnat
	 * Renvoie une queue vide si CourseQueue n'était pas créée
	 */
	@Override
	public Queue<CourseItf> getCourses() {
		if (this.courses == null) 
			this.courses = new PriorityQueue<CourseItf>();
		return this.courses;
	}

	@Override
	public String getType() {
		return this.type;
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
	public void inscription() {
		// TODO Auto-generated method stub

	}

	@Override
	public void afficherResultatsCourses() {
		// TODO Auto-generated method stub

	}

	@Override
	public void afficherResultats() {
		// TODO Auto-generated method stub

	}

}
