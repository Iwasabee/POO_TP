package org.tp.interfaces;

import java.io.Serializable;

public interface PiloteItf extends Serializable {
	
	public String getNom();
	public String getPrenom();
	public int getAge(); // tip : avoir une Date en attribut
	public String getNationalite();
	
	// contraintes de permis
	public boolean hasPermisVoiture();
	public boolean hasPermisMoto();

}
