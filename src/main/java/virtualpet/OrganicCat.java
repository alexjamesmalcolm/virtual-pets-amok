package virtualpet;

public class OrganicCat extends Organic {

	private LitterBox litterBox;

	public OrganicCat(String name, String description, LitterBox litterBox) {
		this(name, description, litterBox, DEFAULT_BOREDOM, 20, 30, 40);
	}

	public OrganicCat(String name, String description, LitterBox litterBox, int boredom, int hunger, int thirst,
			int waste) {
		this.name = name;
		this.description = description;
		this.boredom = boredom;
		this.hunger = hunger;
		this.thirst = thirst;
		this.waste = waste;
		this.litterBox = litterBox;
		this.health = 100;
	}

	public LitterBox getLitterBox() {
		return litterBox;
	}

	public void cleanLitterBox() {
		getLitterBox().clean();
	}

	public int getDirtyness() {
		return getLitterBox().getDirtyness();
	}

	public void useLitterBox() {
		getLitterBox().addWaste(getWaste());
		waste = 0;
	}

	@Override
	void goToBathroom() {
		useLitterBox();
	}

}
