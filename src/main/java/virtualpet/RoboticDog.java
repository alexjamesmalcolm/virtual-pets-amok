package virtualpet;

public class RoboticDog extends Robotic implements Walkable {

	public RoboticDog(String name, String description) {
		this(name, description, DEFAULT_HEALTH, DEFAULT_BOREDOM, DEFAULT_DRYNESS);
	}

	public RoboticDog(String name, String description, int health, int boredom, int dryness) {
		this.name = name;
		this.description = description;
		this.health = health;
		this.boredom = boredom;
		this.dryness = dryness;
	}

	@Override
	public void walk() {
		boredom = 0;
	}

}
