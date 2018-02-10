package virtualpet;

public abstract class Pet {

	protected static final int DEFAULT_HEALTH = 100;
	protected static final int DEFAULT_BOREDOM = 20;
	protected static final int BOREDOM_PER_TICK = 1;
	protected String name;
	protected String description;
	protected int health;
	protected int boredom;

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

	public abstract void tick();

	public void play() {
		boredom = 0;
	}

}