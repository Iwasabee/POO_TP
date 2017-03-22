package org.tp.mariano.tests;

import org.junit.BeforeClass;
import org.junit.Test;

// à tester
import org.tp.interfaces.*;
import org.tp.mariano.classes.*;

/**
 * Vérifier l'esthétique des différents affichages.
 * 
 * @author Élodie Mariano
 *
 */
public class TestsAffichages {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@Test
	public void testPilote() {
		PiloteItf p = new Pilote();
		System.out.println(p.toString());
	}
	
	@Test
	public void testMoto() {
		VehiculeItf m = new Moto();
		System.out.println(m.toString());
	}
	
	@Test
	public void testVoiture() {
		VehiculeItf v = new Voiture();
		System.out.println(v.toString());
	}
	
	@Test
	public void testCourseMoto() {
		CourseItf cm = new CourseMoto();
		System.out.println(cm.toString());
	}
	
	@Test
	public void testCourseVoiture() {
		CourseItf cv = new CourseMoto();
		System.out.println(cv.toString());
	}
	
	@Test
	public void testChampionnat() {
		ChampionnatItf c = new Championnat();
		System.out.println(c.toString());
	}
	
	@Test
	public void testCourseFinie() {
		CourseItf cf = new CourseMoto();
		cf.afficherResultats();
	}
	
	@Test
	public void testChampionnatFini() {
		ChampionnatItf cf = new Championnat();
		cf.afficherResultats();
	}
	
	@Test
	public void testChampionnatsFinis() {
		PiloteItf p = new Pilote();
		System.out.println(p.toString());
	}

}
