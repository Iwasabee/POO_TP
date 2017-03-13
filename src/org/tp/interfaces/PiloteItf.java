package org.tp.interfaces;

public interface PiloteItf {
	
	public String getNom();
	public String getPrenom();
	// tip : avoir une Date en attribut
	public int getAge();
	public String getNationalite();
	
	// contraintes de permis
	public boolean hasPermisVoiture();
	public boolean hasPermisMoto();

}
