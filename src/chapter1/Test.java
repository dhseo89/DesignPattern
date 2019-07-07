package chapter1;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		//기본 Guitart클래스 생성
		GuitarSpec spec1 = new GuitarSpec(Builder.FENDER, "model1", Type.ACCOUSTIC, Wood.ALDER, Wood.BRAZILIAN_ROSEWOOD, 12); 
		Guitar g1 = new Guitar("111111",100000.0, spec1);
		
		
		Inventory inventory = new Inventory();
		inventory.addGuitar(g1);
		
		GuitarSpec find = new GuitarSpec(Builder.FENDER, "model1",Type.ACCOUSTIC, Wood.ALDER, Wood.BRAZILIAN_ROSEWOOD, 12);
		List<Guitar> findList = inventory.search(find);
		
		if(!findList.isEmpty()) {
			System.out.println("찾는 기타가 있습니다");
			for (Guitar guitar : findList)
			{
				GuitarSpec spec = guitar.getSpec();
				System.out.println(spec.getModel()+"\n");
				System.out.println(spec.getNumStrings()+"\n");
				System.out.println(spec.getBackWood()+"\n");
				System.out.println(spec.getBuilder()+"\n");
				System.out.println(spec.getTopWood()+"\n");
				System.out.println(spec.getType()+"\n");
			}
		}
		else {
			System.out.println("찾는 기타가 없습니다");
		}
	}
}
