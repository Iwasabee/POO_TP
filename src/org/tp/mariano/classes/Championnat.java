/*
 * Élodie MARIANO
 */

package org.tp.mariano.classes;


import java.io.Serializable;
import java.util.Queue;

import org.tp.interfaces.ChampionnatItf;
import org.tp.interfaces.CourseItf;
import org.tp.mariano.exceptions.NombreCoursesException;

public class Championnat implements ChampionnatItf, Serializable {

	private static final long serialVersionUID = -8170535423892797963L;
	
	private Queue<CourseItf> courseQueue;
	
	private String type;
	
	
	// CONSTRUCTEUR
	
	public Championnat() {
		
	}
	
	// /!\ minimum 2 courses !!
	public Championnat(Queue<CourseItf> courseQueue) throws NombreCoursesException{
		this.courseQueue = courseQueue;
	}
	
	@Override
	public Queue<CourseItf> getCourseQueue() {
		return courseQueue;
	}	

	@Override
	public String getType() {
		return this.type;
	}

	@Override
	public String getModele() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCylindree() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void afficherResultatsCourses() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afficherResultats() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inscription() {
		// TODO Auto-generated method stub
		
	}

}
