package org.tp.mariano.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Traduction bête et méchante des phrases du sujet en tests
 * 
 * @author Élodie Mariano
 *
 */
public class TestsContraintes {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void uneCourseDoitContenirUneSeulefoisUnVehicule() {
		// tester l'inscription d'un véhicule déja inscrit avec un autre pilote
		fail("Not yet implemented");
	}
	
	@Test
	public void uneCourseDoitContenirUneSeulefoisUnPilote() {
		// tester l'inscription d'un pilote déjà inscrit avec un autre véhicule
		fail("Not yet implemented");
	}
	
	@Test
	public void deuxCoursesDUnChampionnatNeDoiventPasSeDeroulerEnMemeTemps () {
		// on présuppose qu'une course ne dure pas plus d'un jour 
		fail("Not yet implemented");
	}
	
	@Test
	public void unChampionnatPeutEtreSauvegardeDansUnFichier() {
		fail("Not yet implemented");
	}
	
	@Test
	public void unChampionnatPeutEtreChargeDepuisUnFichier() {
		fail("Not yet implemented");
	}
	
	@Test
	public void unVehiculePeutEtreSauvegardeDansUneBDD() {
		fail("Not yet implemented");
	}

}