package virtualpet;

public class RoboticDog extends Robotic implements Walkable {

	public RoboticDog(String name, String description) {
		this(name, description, DEFAULT_BOREDOM, DEFAULT_DRYNESS);
	}

	public RoboticDog(String name, String description, int boredom, int dryness) {
		this.health = DEFAULT_HEALTH;
		this.name = name;
		this.description = description;
		this.boredom = boredom;
		this.dryness = dryness;
	}

	@Override
	public void walk() {
		boredom = 0;
	}

}
