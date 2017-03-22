package org.tp.mariano.tests;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.tp.interfaces.PiloteItf;
import org.tp.interfaces.VehiculeItf;
import org.tp.mariano.main.Main;

/**
 * 
 * @author Élodie Mariano
 *
 */
public class TestMainMariano {
	
	public static Main main = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		main = new Main(20);
	}
	

	// A2 : Générer un ensemble de pilotes
	@Test
	public void testEnsembleVehicules() {
		for (VehiculeItf v : main.vehicules()) {
			System.out.println(v.toString());
		}
	}

	// A2 : Générer un ensemble de pilotes
	@Test @Ignore
	public void testEnsemblePilotes() {
		for (PiloteItf p : main.pilotes()) {
			System.out.println(p.toString());
		}
	}

}
