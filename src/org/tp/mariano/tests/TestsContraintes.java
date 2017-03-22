package org.tp.mariano.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
// à tester
import org.tp.interfaces.ChampionnatItf;
import org.tp.interfaces.CourseItf;
import org.tp.interfaces.EquipageItf;
import org.tp.interfaces.VehiculeItf;
import org.tp.mariano.classes.Championnat;
import org.tp.mariano.classes.CourseMoto;
import org.tp.mariano.classes.Equipage;
import org.tp.mariano.classes.Moto;
import org.tp.mariano.classes.Pilote;

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
	
//	@Test(expected=IndexOutOfBoundsException.class)
//	public void testIndexOutOfBoundsException() {
//	    ArrayList emptyList = new ArrayList();
//	    Object o = emptyList.get(0);
//	}

	/*@Test
	public void uneCourseDoitContenirUneSeulefoisUnVehicule() {
		// tester l'inscription d'un véhicule déja inscrit avec un autre pilote
		CourseItf c = new CourseMoto();
		// on crée deux équipages avec un même véhicule
		VehiculeItf m = new Moto();
		EquipageItf e1 = new Equipage(new Pilote(), m);
		EquipageItf e2 = new Equipage(new Pilote(), m);
		// on les inscrit pour la course
		c.inscrire(e1);
		c.inscrire(e2);
		// on vérifie que la 2ème inscription a été rejetée
		assertEquals(1, c.getEquipages().size());
	} */
	
	@Test
	public void uneCourseDoitContenirUneSeulefoisUnPilote() {
		// tester l'inscription d'un pilote déjà inscrit avec un autre véhicule
		CourseItf c = new CourseMoto();
	}
	
	@Test
	public void deuxCoursesDUnChampionnatNeDoiventPasSeDeroulerEnMemeTemps () {
		ChampionnatItf chm = new Championnat();
		//chm.ajouterCourse();
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