package virtualpet;

public abstract class Robotic extends VirtualPet {

	protected int dryness;

	public Robotic(String name, String description) {
		super(name, description);
	}

	public Robotic(String name, String description, int dryness) {
		super(name, description);
		this.dryness = dryness;
	}

	public int getDryness() {
		return dryness;
	}

	public void oil() {
		dryness = 0;
	}

}
