package org.tp.mariano.classes;

import java.util.Date;

import org.tp.interfaces.PiloteItf;

public class Pilote implements PiloteItf {

	private String nom;
	private String prenom;
	private Date age;
	
	// CONSTRUCTEUR
	
	public Pilote() {
		
	}
	
	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getPrenom() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getNationalite() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean hasPermisVoiture() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean hasPermisMoto() {
		// TODO Auto-generated method stub
		return false;
	}
}
