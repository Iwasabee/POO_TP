package org.tp.mariano.classes;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.tp.interfaces.PiloteItf;
import org.tp.mariano.exceptions.PiloteException;

public class Pilote implements PiloteItf {
	
	// ---------- ATTRIBUTS
	
	private static final long serialVersionUID = 214171758734551995L;
	
    private static int pilotesCompte = 0;
    private static List<String> typesPermis = Arrays.asList("voiture", "moto");
	private int piloteId;
	
	// 5
	private String nom;
	private String prenom;
	private String nationalite;
	private LocalDate dateDeNaissance; 
	private List<String> permis; // "voiture", "moto"...

	
	// CONSTRUCTEURS

	// init vide
	/**
	 * <ul>
	 * <li>pilotesCompte ++;</li>
	 * <li>this.piloteId = pilotesCompte;</li>
	 * <li>this.fichier = "pilote" + this.piloteId;</li>
	 * <li>this.nom = "pilote n° " + this.piloteId;</li>
	 * <li>this.prenom = "";</li>
	 * <li>this.nationalite = "";</li>
	 * <li>this.dateDeNaissance = null;</li>
	 * <li>this.permis = Arrays.asList("");</li>
	 * </ul>
	 */
	public Pilote() {
		pilotesCompte ++;
		this.piloteId = pilotesCompte;
		this.nom = "pilote " + this.piloteId;
		this.prenom = "";
		this.nationalite = "";
		this.dateDeNaissance = null;
		this.permis = null;
	}
	
	// init total
	public Pilote (String nom, String prenom, String nationalite, 
			LocalDate dateDeNaissance, List<String> permis)
	throws PiloteException {
		pilotesCompte ++;
		this.piloteId = pilotesCompte;
		this.nom = nom;
		this.prenom = prenom;
		this.nationalite = nationalite;
		this.dateDeNaissance = dateDeNaissance;
		this.permis = permis;
	}
	
	
	// ---------- MÉTHODES
	
    @Override
	public String toString() {
		return ("Pilote" +
				"\nnom : " + nom + 
				"\nprenom : " + prenom +
				"\nnationalite : " + nationalite + 
				"\ndate de naissance : " + dateDeNaissance + 
				"\nage : " + this.age() +
				"\npermis : " + permis +
				"\n"
				);
	}
    
    public int PilotesCompte(){
        return pilotesCompte;
    }

	public int PiloteId(){
        return piloteId;
    }
	
	/**
	 * Cette méthode effectue les vérifications des informations requises <br>
	 * pour que le Pilote puisse s'inscrire à une Course ou un Championnat. <br>
	 * <ul>
	 * <li>nom</li>
	 * <li>prénom</li>
	 * <li>nationalité</li>
	 * <li>age (être majeur)</li>
	 * </ul>
	 * @return
	 */
	public boolean estEnRegle() throws PiloteException{
		// un pilote doit avoir un nom
		if (this.nom() == null || this.nom().trim() == "")
			throw new PiloteException(PiloteException.messageNom);
		// un pilote doit avoir un prénom
		if (this.prenom() == null || this.prenom().trim() == "")
			throw new PiloteException(PiloteException.messagePrenom);
		// un pilote doit avoir une nationalité (réelle)
		if (this.nom() == null || this.nom().trim() == "")
			throw new PiloteException(PiloteException.messageNationalite);
		// un pilote doit être majeur (age >= 18)
		if (this.age() < 18)
			throw new PiloteException(PiloteException.messageMajeur);
		return true;
	}
    

	// ---------- MÉTHODES D' INTERFACE

	@Override
	public String nom() {
		return this.nom;
	}

	@Override
	public String prenom() {
		return this.prenom;
	}
	
	public void setDateDeNaissance(LocalDate date) {
    	this.dateDeNaissance = date;
	}

	/**
	 * @return int age du Pilote <br>
	 * 0 si la date de naissance n'a pas été renseignée / est future. <br>
	 * 
	 */
	@Override
	public int age() {
		LocalDate naissance = this.dateDeNaissance;
		LocalDate now = LocalDate.now();
		if ( (naissance == null) || (naissance.isAfter(now)) )
			return 0;
		Period p = Period.between(naissance, now );
		int age = p.getYears();
		return age;
	}

	@Override
	public String nationalite() {
		return this.nationalite;
	}
	
	public void setNationalite(String string) {
		this.nationalite = string;
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
    
	public void setPermis(List<String> permis) {
    	this.permis = permis;
	}
	
	public static List<String> typesPermis() {
		return typesPermis;
	}


}
