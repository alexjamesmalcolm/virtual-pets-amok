package virtualpet;

public class RoboticCat extends Robotic {

	public RoboticCat(String name, String description) {
		this(name, description, DEFAULT_HEALTH, DEFAULT_BOREDOM, DEFAULT_DRYNESS);
	}

	public RoboticCat(String name, String description, int health, int boredom, int dryness) {
		this.name = name;
		this.description = description;
		this.health = health;
		this.boredom = boredom;
		this.dryness = dryness;
	}

}
