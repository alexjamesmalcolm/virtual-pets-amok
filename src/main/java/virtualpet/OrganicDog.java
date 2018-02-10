package virtualpet;

public class OrganicDog extends Pet{

	protected static final int HUNGER_TO_THIRST = 4;
	protected static final int HUNGER_PER_TICK = 1;
	protected static final int THIRST_PER_TICK = 1;
	protected static final int HUNGER_TO_WASTE = 4;
	private int hunger;
	private int thirst;

	public int getHunger() {
		return hunger;
	}

	public int getThirst() {
		return thirst;
	}

	public int getWaste() {
		// TODO Auto-generated method stub
		return 14;
	}

	public OrganicDog(int hunger, int thirst, int boredom, int waste) {
		this.hunger = hunger;
		this.thirst = thirst;
		this.boredom = boredom;
	}

	public void feed() {
		thirst = hunger / HUNGER_TO_THIRST;
		hunger = 0;
	}

	public void water() {
		thirst = 0;
	}

	@Override
	public void tick() {
		hunger += HUNGER_PER_TICK;
		thirst += THIRST_PER_TICK;
		boredom += BOREDOM_PER_TICK;
	}

}
