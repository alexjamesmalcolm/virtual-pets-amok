package virtualpet;

public class OrganicDog extends Pet{

	protected static final int HUNGER_TO_THIRST = 8;
	protected static final int HUNGER_PER_TICK = 1;
	protected static final int THIRST_PER_TICK = 1;
	protected static final int HUNGER_TO_WASTE = 4;
	protected static final int THIRST_TO_WASTE = 3;
	private int hunger;
	private int thirst;
	private int waste;

	public int getHunger() {
		return hunger;
	}

	public int getThirst() {
		return thirst;
	}

	public int getWaste() {
		return waste;
	}

	public OrganicDog(int hunger, int thirst, int boredom, int waste) {
		this.hunger = hunger;
		this.thirst = thirst;
		this.boredom = boredom;
		this.waste = waste;
	}

	public void feed() {
		thirst += hunger / HUNGER_TO_THIRST;
		waste += hunger / HUNGER_TO_WASTE;
		hunger = 0;
	}

	public void water() {
		waste += thirst / THIRST_TO_WASTE;
		thirst = 0;
	}

	@Override
	public void tick() {
		hunger += HUNGER_PER_TICK;
		thirst += THIRST_PER_TICK;
		boredom += BOREDOM_PER_TICK;
	}

}