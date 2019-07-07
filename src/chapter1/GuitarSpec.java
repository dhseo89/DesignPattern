package chapter1;

public class GuitarSpec {
	
	private Builder builder;
	
	private String model;
	
	private Type type;
	
	private Wood backWood;
	
	private Wood topWood;
	
	private int numStrings; //추가된 마지막 속성
	
	public GuitarSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood, int numStrings) {
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.backWood = backWood;
		this.topWood = topWood;
		this.numStrings = numStrings; 
	}

	public Builder getBuilder() {
		return builder;
	}

	public String getModel() {
		return model;
	}

	public Type getType() {
		return type;
	}

	public Wood getBackWood() {
		return backWood;
	}

	public Wood getTopWood() {
		return topWood;
	}

	public int getNumStrings() { //추가된 메서드
		return numStrings;
	}

	public boolean matches(GuitarSpec find) {
		if(builder != find.builder)
			return false;
		if(type != find.type)
			return false;
		
		//다른 속성 비교~~
		
		return true;
	}
}
