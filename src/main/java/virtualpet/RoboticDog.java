package virtualpet;

public class RoboticDog {

	static final int DRYNESS_PER_TICK = 1;
	static final int DEFAULT_HEALTH = 100;
	static final int DEFAULT_BOREDOM = 20;
	static final int DEFAULT_DRYNESS = 20;
	static final int BOREDOM_PER_TICK = 1;
	private String name;
	private String description;
	private int dryness;
	private int health;
	private int boredom;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getHealth() {
		return health;
	}

	public int getBoredom() {
		return boredom;
	}

	public int getDryness() {
		return dryness;
	}

	public RoboticDog(String name, String description) {
		this.name = name;
		this.description = description;
		health = DEFAULT_HEALTH;
		boredom = DEFAULT_BOREDOM;
		dryness = DEFAULT_DRYNESS;
	}

	public RoboticDog(String name, String description, int health, int boredom, int dryness) {
		this.name = name;
		this.description = description;
		this.health = health;
		this.boredom = boredom;
		this.dryness = dryness;
	}

	public void oil() {
		dryness = 0;
	}

	public void tick() {
		dryness += DRYNESS_PER_TICK;
		boredom += BOREDOM_PER_TICK;
	}

	public void play() {
		boredom = 0;
	}

	public void walk() {
		boredom = 0;
	}

}
