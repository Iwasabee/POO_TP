package org.tp.mariano.classes;


public class CourseMoto extends Course {
	
	// ATTRIBUTS	
	final static int PARTICIPANTS_MIN = 2;
	final static int PARTICIPANTS_MAX = 16;
	
	// CONSTRUCTEUR(S)
	
	// MÉTHODES

	@Override
	public int getParticipantsMin() {
		return CourseMoto.PARTICIPANTS_MIN;
	}

	@Override
	public int getParticipantsMax() {
		return CourseMoto.PARTICIPANTS_MAX;
	}

}
