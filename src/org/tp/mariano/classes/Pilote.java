package org.tp.mariano.classes;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.tp.interfaces.PiloteItf;
import org.tp.mariano.exceptions.PiloteException;

public class Pilote implements PiloteItf {
	
	// ATTRIBUTS
	
    private static int pilotesCompte = 0;
	private int piloteId;
	private String fichier;
	
	private static final long serialVersionUID = 214171758734551995L;

	// 5
	private String nom;
	private String prenom;
	private String nationalite;
	private LocalDate dateDeNaissance; 
	private List<String> permis; // "voiture", "moto"...

	
	// CONSTRUCTEURS

	// init vide
	public Pilote() {
		pilotesCompte ++;
		this.piloteId = pilotesCompte;
		this.fichier = "pilote" + this.piloteId;
		this.nom = "pilote n° " + this.piloteId;
		this.prenom = "";
		this.nationalite = "";
		this.dateDeNaissance = null;
		this.permis = Arrays.asList("");
	}
	
	// init total
	public Pilote (String nom, String prenom, String nationalite, 
			LocalDate dateDeNaissance, List<String> permis)
	throws PiloteException {
		this.nom = nom;
		this.prenom = prenom;
		this.nationalite = nationalite;
		this.dateDeNaissance = dateDeNaissance;
		this.permis = permis;
	}
	
	// MÉTHODES
	
    public int PilotesCompte(){
        return pilotesCompte;
    }
    
    public int PiloteId(){
        return piloteId;
    }
    

	// MÉTHODES D' INTERFACE

	@Override
	public String nom() {
		return this.nom;
	}

	@Override
	public String prenom() {
		return this.prenom;
	}

	@Override
	public int age() {
		Period p = Period.between(this.dateDeNaissance, LocalDate.now());
		int age = p.getYears();
		return age;
	}

	@Override
	public String nationalite() {
		return this.nationalite;
	}

	/**
	 *  Permet l'accès sécurisé aux permis que le Pilote a :<br/>
	 *  ne retourne JAMAIS null.
	 *  @return List < String > permis
	 *  @return List < String > vide si le Pilote n'a aucun permis
	 */
    @Override
	public List<String> permis() {
		if (this.permis == null)
			this.permis = new ArrayList<String>();
		return this.permis;
	}
}
