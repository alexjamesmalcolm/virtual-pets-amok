package virtualpet;

public class RoboticCat extends Robotic {

	public RoboticCat(String name, String description) {
		this(name, description, DEFAULT_BOREDOM, DEFAULT_DRYNESS);
	}

	public RoboticCat(String name, String description, int boredom, int dryness) {
		this.name = name;
		this.description = description;
		this.health = 100;
		this.boredom = boredom;
		this.dryness = dryness;
	}

}
