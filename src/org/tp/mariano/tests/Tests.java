package org.tp.mariano.tests;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
// à tester
import org.tp.interfaces.ChampionnatItf;
import org.tp.interfaces.CourseItf;
import org.tp.interfaces.PiloteItf;
import org.tp.interfaces.VehiculeItf;
import org.tp.mariano.classes.Championnat;
import org.tp.mariano.classes.CourseMoto;
import org.tp.mariano.classes.CourseVoiture;
import org.tp.mariano.classes.Moto;
import org.tp.mariano.classes.Pilote;
import org.tp.mariano.classes.Voiture;

public class Tests {
	
	@Before
	public void sep() {
		System.out.println();
	}
	
	
	// AFFICHAGES
	
	@Test
	public void testAffichageChampionnat() {
		ChampionnatItf c = new Championnat();
		System.out.println(c.toString());
	}
	
	@Test
	public void testAffichageCourse() {
		CourseItf cm = new CourseMoto();
		System.out.println(cm.toString());
	}
	
	@Test @Ignore
	public void testAffichageCourseVoiture() {
		CourseItf cv = new CourseVoiture();
		System.out.println(cv.toString());
	}
	
	@Test
	public void testAffichageVehicule() {
		VehiculeItf m = new Moto();
		VehiculeItf v = new Voiture();
		System.out.println(m.toString());
		System.out.println(v.toString());
	}
	
	@Test
	public void testAffichagePilote() {
		PiloteItf p = new Pilote();
		System.out.println(p.toString());
	}

}
