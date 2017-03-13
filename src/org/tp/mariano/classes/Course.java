/*
 * Élodie MARIANO
 */

package org.tp.mariano.classes;

import java.util.Date;
import java.util.Queue;

import org.tp.interfaces.CourseItf;
import org.tp.interfaces.EquipageItf;

public abstract class Course implements CourseItf {
	
	private Date date; // la date précise du départ
	private Queue<EquipageItf> equipagesQueue; // queue des participants
	private int[] score = {10, 8, 2};
	

	@Override
	public Date getDate() {
		return this.date;
	}
	
	@Override
	public Queue<EquipageItf> getEquipagesQueue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void entrerResultats() {
		// TODO Auto-generated method stub
		
	}
	
	// points en fonction de la position p
	private int getScore(int p){
		if ( p > score.length) return 0;
		return score[p-1];
	}

	@Override
	public void afficherResultats() {
		int p = 1; // position
		for (EquipageItf e : equipagesQueue) {
			System.out.println(
					p + e.getPilote().getNom() + e.getTempsCourse(this.date) + getScore(p));
		}
	}

	@Override
	public void arriveeCourse() {
		// TODO Auto-generated method stub
		
	}

}
