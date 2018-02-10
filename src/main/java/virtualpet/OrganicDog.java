package virtualpet;

public class OrganicDog {

	protected static final int HUNGER_TO_THIRST = 4;
	private int hunger;
	private int thirst;

	public OrganicDog(int hunger, int thirst) {
		this.hunger = hunger;
		this.thirst = thirst;
	}

	public int getHunger() {
		return 0;
	}

	public int getThirst() {
		return thirst;
	}

	public void feed() {
		thirst = hunger / HUNGER_TO_THIRST;
	}

	public void water() {
		thirst = 0;
	}

}
