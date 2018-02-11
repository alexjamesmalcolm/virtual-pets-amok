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
	}

	@Override
	void goToBathroom() {
		useLitterBox();
	}

}
