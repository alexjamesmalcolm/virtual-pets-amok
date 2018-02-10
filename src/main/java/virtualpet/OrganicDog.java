package virtualpet;

public class OrganicDog extends Pet{

	protected static final int HUNGER_TO_THIRST = 4;
	protected static final int HUNGER_PER_TICK = 1;
	private int hunger;
	private int thirst;

	public OrganicDog(int hunger, int thirst) {
		this.hunger = hunger;
		this.thirst = thirst;
	}

	public int getHunger() {
		return hunger;
	}

	public int getThirst() {
		return thirst;
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
	}

}
