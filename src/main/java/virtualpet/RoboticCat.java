package virtualpet;

public class RoboticCat extends Robotic {

	public RoboticCat(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public RoboticCat(String name, String description, int health, int boredom, int dryness) {
		this.health = health;
		this.boredom = boredom;
		this.dryness = dryness;
	}

}
