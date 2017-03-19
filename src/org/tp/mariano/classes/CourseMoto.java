package org.tp.mariano.classes;


public class CourseMoto extends Course {
	
	private static final long serialVersionUID = 3588347861377038534L;
	// ATTRIBUTS	
	final static int PARTICIPANTS_MIN = 2;
	final static int PARTICIPANTS_MAX = 16;
	
	// CONSTRUCTEUR(S)
	public CourseMoto(){
		super();
	}
	
	public CourseMoto(int year, int month, int dayOfMonth){
		super(year, month, dayOfMonth);
	}
	
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
