package org.tp.mariano.classes;

public class CourseMoto extends Course {
	
	public final int PARTICIPANTS_MIN = 2;
	public final int PARTICIPANTS_MAX = 20;
	
	
	
	@Override
	public int getParticipantsMin() {
		return this.PARTICIPANTS_MIN;
	}

	@Override
	public int getParticipantsMax() {
		return this.PARTICIPANTS_MAX;
	}

}
