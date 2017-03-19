package org.tp.mariano.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;
// à tester
import org.tp.interfaces.*;
import org.tp.mariano.classes.*;

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
		CourseItf c = new CourseMoto();
	}
	
	@Test
	public void deuxCoursesDUnChampionnatNeDoiventPasSeDeroulerEnMemeTemps () {
		// on présuppose qu'une course ne dure pas plus d'un jour 
	}
	
	@Test
	public void unChampionnatPeutEtreSauvegardeDansUnFichier() {
		String nomFichier = "test_championnat";
		ChampionnatItf c1 = new Championnat();
		assertTrue(c1.sauverDansFichier(nomFichier));
		c1 = null;
		c1 = new Championnat();
		c1 = c1.chargerDepuisFichier(nomFichier);
		assertNotNull(c1);
	}
	
	@Test
	public void unChampionnatPeutEtreChargeDepuisUnFichier() {
		String nomFichier = "championnat_test";
		ChampionnatItf c1 = new Championnat();
		c1 = c1.chargerDepuisFichier(nomFichier);
		assertNotNull(c1);
	}
	
	@Test
	public void unVehiculePeutEtreSauvegardeDansUneBDD() {
	}

}