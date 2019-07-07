package chapter1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory {
	
	public Inventory() {
		guitars = new ArrayList<>();
	}

	private List<Guitar> guitars; // = new ArrayList<>();
	
	
	void addGuitar(Guitar aa){
		this.guitars.add(aa);
	}

	Guitar getGuitar() {
		GuitarSpec spec1 = new GuitarSpec(Builder.FENDER, "model1", Type.ACCOUSTIC, Wood.ALDER, Wood.BRAZILIAN_ROSEWOOD, 12); 
		Guitar g1 = new Guitar("111111",100000.0, spec1);
		return g1;
	}
	
	public List<Guitar> search(GuitarSpec find) {
		List<Guitar> matchingGuitars = new ArrayList<Guitar>();
		
		for (Iterator<Guitar> i = guitars.iterator(); i.hasNext();) {
			Guitar guitar = (Guitar) i.next();
			if(guitar.getSpec().matches(find))
				matchingGuitars.add(guitar);
		}
		
		return matchingGuitars;
	}

	public List<Guitar> getGuitars() {
		return guitars;
	}
	
}
