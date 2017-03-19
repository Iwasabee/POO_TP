package org.tp.mariano.classes;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.tp.interfaces.PiloteItf;
import org.tp.mariano.exceptions.PasMajeurException;

public class Pilote implements PiloteItf {
	
	// ATTRIBUTS
	
    private static int pilotesCompte = 0;
	private int piloteId;
	private String fichier;
	
	private static final long serialVersionUID = 214171758734551995L;

	private String nom;
	private String prenom;
	private String nationalite;
	private LocalDate dateDeNaissance; 
	private List<String> permis; // "voiture", "moto"

	
	// CONSTRUCTEURS

	public Pilote() {
		pilotesCompte ++;
		this.piloteId = pilotesCompte;
		this.fichier = "pilote n° " + this.piloteId;
		this.nom = "pilote n° " + this.piloteId;
		this.prenom = "";
		this.nationalite = "";
		this.dateDeNaissance = null;
		this.permis = Arrays.asList("");
	}
	
	public Pilote (String nom, String prenom, String nationalite, 
			LocalDate dateDeNaissance, List<String> permis)
	throws PasMajeurException {
		try {
			Period age = Period.between(dateDeNaissance, LocalDate.now());
			if (age.getYears() < 18)
				throw (new PasMajeurException());
			this.nom = nom;
			this.prenom = prenom;
			this.nationalite = nationalite;
			this.dateDeNaissance = dateDeNaissance;
			this.permis = permis;
		} catch (PasMajeurException e) {
			System.err.println(e.getMessage());
		}

	}
	
	// MÉTHODES
	
    public int PilotesCompte(){
        return pilotesCompte;
    }
    
    public int PiloteId(){
        return piloteId;
    }
	
	// permet l'accès sécurisé aux permis : retourne une liste vide si null
	public List<String> permis() {
		if (this.permis == null)
			this.permis = new ArrayList<String>();
		return (List<String>)this.permis;
	}
	
	// MÉTHODES D' INTERFACE

	@Override
	public String getNom() {
		return this.nom;
	}

	@Override
	public String getPrenom() {
		return this.prenom;
	}

	@Override
	public int getAge() {
		Period p = Period.between(this.dateDeNaissance, LocalDate.now());
		int age = p.getYears();
		return age;
	}

	@Override
	public String getNationalite() {
		return this.nationalite;
	}

	@Override
	public boolean hasPermisVoiture() {
		if (permis.contains("voiture"))
			return true;
		return false;
	}

	@Override
	public boolean hasPermisMoto() {
		if (permis().contains("moto"))
			return true;
		return false;
	}

}
