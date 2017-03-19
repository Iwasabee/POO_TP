package org.tp.mariano.tests;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

// à tester
import org.tp.interfaces.*;
import org.tp.mariano.*;


/*
 * Tentative de transcription du sujet en tests
 */
public class TestsSujet {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		int i = 0, j = 0;
		List pilotes = new ArrayList();
		for (i=0; i<1; i++){
			//pilotes.add(new Pilote())
		}
	}
	
    @Test
    public void unChampionnatDoitComprendreAuMoins2Courses() {
    	//ChampionnatItf c = new Championnat();
    	//assert(c.getCourses().size() >= 2);
    }
    
    @Test
    public void uneCourseDoitImposerUnType() {
    	//CourseItf c = new Course();
    }
    
    @Test
    public void uneCourseDoitImposerUnModele() {
    	fail("Not yet implemented");
    }
    
    @Test
    public void uneCourseDoitImposerUneCylindree() {
    	fail("Not yet implemented");
    }
    
    @Test
    public void uneCourseMotoDoitAvoirAuMoins2Participants() {
    	fail("Not yet implemented");
    }
    
    @Test
    public void uneCourseMotoDoitAvoirAuPlus20Participants() {
    	fail("Not yet implemented");
    }
    
    @Test
    public void uneCourseDoitAvoirAuMoins4Participants() {
    	fail("Not yet implemented");
    }
    
    @Test
    public void uneCourseVoitureDoitAvoirAuPlus16Participants() {
    	// tester l'ajout de participants sur une course "pleine"
    	fail("Not yet implemented");
    }
    
    @Test
    public void unPiloteDoitAvoirAuMoins18Ans() {
    	fail("Not yet implemented");
    }
    
    @Test
    public void unPiloteDoitAvoirLePermisAdapte() {
    	fail("Not yet implemented");
    }
    
    @Test
    public void desVehiculesDoiventEtreReferences() {
    	fail("Not yet implemented");
    }
    
    @Test
    public void unVehiculeDoitSEngagerPourToutUnChampionnat() {
    	fail("Not yet implemented");
    }
    
    @Test
    public void lesTempsDesParticipantsDoiventPouvoirEtreRentres() {
    	fail("Not yet implemented");
    }
    
    @Test
    public void lesTempsDesParticipantsDoiventPouvoirEtreAffiches() {
    	fail("Not yet implemented");
    }
    
    @Test
    public void testArriveeCourse() {
    	fail("Not yet implemented");
    }
    
    @Test
    public void lesPilotesDoiventGagnerDesPointsParCourse() {
    	// dérouler une course
    	//assertEquals(10, course.get(1).getScore())
    	//assertEquals(8, course.get(1).getScore())
    	//assertEquals(2, course.get(3).getScore())
    	fail("Not yet implemented");
    }
    
    @Test
    public void uneVoitureDoitAvoirUneCylindree() {
    	//assert
    	// VoitureItf v
    	//assert(v.getCylindree() > 0);
    	fail("Not yet implemented");
    }
    
    
    @Test
    public void uneVoitureDoitAvoirUnNombreDeRouesMotrices() {
    	// VoitureItf v
    	//assert(v.getRouesMotrices() == 2 || v.getRouesMotrices == 4);
    	fail("Not yet implemented");
    }
    
    @Test
    public void uneVoitureDoitAvoirUnModele() {
    	// VoitureItf v
    	//assert(v.getModele() == "sport" || v.getModele() == "classique");
    	fail("Not yet implemented");
    }
    
    @Test
    public void uneVoitureDoitAvoirUneVitesseMax() {
    	// VoitureItf v
    	//assert(v.getVMax()  > 0);
    	fail("Not yet implemented");
    }
    
    @Test
    public void uneVoitureDoitAvoirUnCarburant() {
    	// VoitureItf v
    	//assert(v.getCarburant()  != "");
    	fail("Not yet implemented");
    }
    
    @Test
    public void uneMotoDoitAvoirUneCylindree() {
//    	MotoItf m = new Moto();
//    	assert(m.getCylindree() instanceof Integer);
//    	assert(m.getCylindree() > 0);
    }
    
    @Test
    public void uneMotoDoitAvoirUneVitesseMax() {
    	// MotoItf m
    	//assert(m.VMax() > 0);
    	fail("Not yet implemented");
    }
    
    @Test
    public void uneMotoDoitAvoirUneType() {
    	// MotoItf m
    	//assert(m.getType() == "sportive" ||m.getType() == "enduro" 
    	//||m.getType() == "trial" );
    	fail("Not yet implemented");
    }
    
    @Test
    public void uneMotoDoitAvoirUnePoids() {
    	// MotoItf m
    	//assert(m.getPoids() > 0);
    	fail("Not yet implemented");
    }
    

}