package virtualpet;

public class RoboticDog {

	public static final int DRYNESS_PER_TICK = 1;
	private String name;
	private String description;
	private int dryness;
	private int health;

	public RoboticDog(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public RoboticDog(String name, String description, int dryness, int health) {
		this.health = health;
		this.dryness = dryness;
	}

	public int getHealth() {
		return health;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getDryness() {
		return dryness;
	}

	public void oil() {
		dryness = 0;
	}

	public void tick() {
		dryness += DRYNESS_PER_TICK;
	}

}
