package virtualpet;

public class RoboticDog extends VirtualPet{

	private int dryness;

	public RoboticDog(String name, String description) {
		super(name, description);
	}

	public RoboticDog(String name, String description, int dryness) {
		super(name, description);
		this.dryness = dryness;
	}

	public int getDryness() {
		return dryness;
	}

}
