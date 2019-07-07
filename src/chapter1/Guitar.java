package chapter1;

public class Guitar {

	private String serialNumber;
	private double priace;
	private GuitarSpec spec;
	

	public Guitar(String serialNumber, double priace, GuitarSpec spec) {
		this.serialNumber = serialNumber;
		this.priace = priace;
		this.spec = spec;
	}


	public String getSerialNumber() {
		return serialNumber;
	}

	public double getPriace() {
		return priace;
	}

	public GuitarSpec getSpec() {
		return spec;
	}
	
}
