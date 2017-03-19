package org.tp.main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

import org.tp.interfaces.PiloteItf;
import org.tp.mariano.classes.Pilote;

// Les mains doivent pouvoir fonctionner indépendamment des packages !!

public class MainMariano {
	
	// on crée un ensemble de Pilotes
	// Set : cannot contain duplicate elements.
	private Collection<PiloteItf> pilotes = new HashSet<PiloteItf>();
	
	//for (i=0; i < 30; i++) 
		
		//PiloteItf p = new Pilote();
		//pilotes.add(p);
	
	
	    


	public static void main(String[] args) {
		
		LocalDateTime t1 = LocalDateTime.of(1, 1, 1, 1, 1, 0, 0);
		LocalDateTime t2 = LocalDateTime.of(1, 1, 1, 1, 2, 0, 0);
		LocalDateTime t3 = LocalDateTime.of(1, 1, 1, 1, 3, 0, 0);
		
		PiloteItf p1 = new Pilote();
		PiloteItf p2 = new Pilote();
		PiloteItf p3 = new Pilote();
		
		Map<PiloteItf, LocalDateTime> classement = new Hashtable<PiloteItf, LocalDateTime>();
		classement.put(p1, t1);
		classement.put(p2, t2);
		classement.put(p3, t3);
		classement.put(p3, t3);
		classement.put(p3, t1);
		
		String test = "";
		
		Queue<LocalDateTime> q = new PriorityQueue<LocalDateTime>();
		q.addAll(classement.values());
		
		System.out.println(q.toString() + "\n");
		
		Map<Integer, List<String>> c = new TreeMap<Integer, List<String>>();
		
		List<String> position = null;
		for (LocalDateTime t : q) {
			position = new ArrayList<String>();
			for ( PiloteItf p : classement.keySet() ) {
				if (classement.get(p) == t) {
					position.add(p.getNom());
				}
			}
			c.put(t.getMinute(), position);
		}
		
		for (PiloteItf p : classement.keySet()) {
			test = test + p.getNom() + " "+ classement.get(p).getMinute();
			test = test + "\n";
		}
		
		test = c.toString();			

		System.out.println(test);
				
		System.out.println();

	}
}