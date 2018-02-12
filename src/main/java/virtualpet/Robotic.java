package virtualpet;

public abstract class Robotic extends Pet {

	static final int DRYNESS_PER_TICK = 15;
	static final int DEFAULT_DRYNESS = 20;
	int dryness;

	public int getDryness() {
		return dryness;
	}

	public void oil() {
		dryness = 0;
	}

	@Override
	public void tick() {
		health = DEFAULT_HEALTH;
		if (dryness > 100) {
			health -= dryness - 100;
		}
		if (boredom > 100) {
			health -= boredom - 100;
		}
		dryness += DRYNESS_PER_TICK;
		boredom += BOREDOM_PER_TICK;
	}

}