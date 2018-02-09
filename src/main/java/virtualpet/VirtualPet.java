package virtualpet;

public class VirtualPet {

	public static final int HUNGER_PER_TICK = 8;
	public static final int THIRST_PER_TICK = 8;
	public static final int BOREDOM_PER_TICK = 8;
	public static final int HUNGER_TO_THIRST = 2;
	public static final int DEFAULT_HUNGER = 50;
	public static final int DEFAULT_THIRST = 50;
	public static final int DEFAULT_BOREDOM = 50;
	private String name;
	private String description;
	private int hunger;
	private int thirst;
	private int boredom;

	public VirtualPet(String name, String description) {
		this(name, description, DEFAULT_HUNGER, DEFAULT_THIRST, DEFAULT_BOREDOM);
	}

	public VirtualPet(String name, String description, int hunger, int thirst, int boredom) {
		this.name = name;
		this.description = description;
		this.hunger = hunger;
		this.thirst = thirst;
		this.boredom = boredom;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "VirtualPet {name: " + name + ", description: " + description + ", hunger: " + hunger + ", thirst: "
				+ thirst + ", boredom: " + boredom + "}";
	}

	public String getDescription() {
		return description;
	}

	public int getHunger() {
		return hunger;
	}

	public int getThirst() {
		return thirst;
	}

	public int getBoredom() {
		return boredom;
	}

	public void feed() {
		thirst += hunger / HUNGER_TO_THIRST;
		hunger = 0;
	}

	public void water() {
		thirst = 0;
	}

	public void play() {
		boredom = 0;
	}

	public void tick() {
		hunger += HUNGER_PER_TICK;
		thirst += THIRST_PER_TICK;
		boredom += BOREDOM_PER_TICK;
	}

}
