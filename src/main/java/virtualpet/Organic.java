package virtualpet;

public abstract class Organic extends Pet {

	protected static final int HUNGER_TO_THIRST = 8;
	protected static final int HUNGER_PER_TICK = 6;
	protected static final int THIRST_PER_TICK = 10;
	protected static final int HUNGER_TO_WASTE = 8;
	protected static final int THIRST_TO_WASTE = 3;
	protected static final int WASTE_TO_DIRTYNESS = 5;
	protected static final int DEFAULT_HUNGER = 25;
	protected static final int DEFAULT_THIRST = 25;
	protected static final int DEFAULT_WASTE = 25;
	int hunger;
	int thirst;
	int waste;

	public int getHunger() {
		return hunger;
	}

	public int getThirst() {
		return thirst;
	}

	public int getWaste() {
		return waste;
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
		health = DEFAULT_HEALTH;
		if (hunger > 100) {
			health -= hunger - 100;
		}
		if (thirst > 100) {
			health -= thirst - 100;
		}
		if (boredom > 100) {
			health -= boredom - 100;
		}
		hunger += HUNGER_PER_TICK;
		thirst += THIRST_PER_TICK;
		boredom += BOREDOM_PER_TICK;
		if (waste >= 70) {
			goToBathroom();
		}
		if (getDirtyness() > 100) {
			health -= getDirtyness() - 100;
		}
	}

	abstract void goToBathroom();

	abstract int getDirtyness();

}