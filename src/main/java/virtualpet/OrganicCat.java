package virtualpet;

public class OrganicCat extends Organic {

	public OrganicCat(String name, String description) {
		this(name, description, DEFAULT_BOREDOM, 20, 30);
	}

	public OrganicCat(String name, String description, int boredom, int hunger, int thirst) {
		this.name = name;
		this.description = description;
		this.boredom = boredom;
		this.hunger = hunger;
		this.thirst = thirst;
	}

}
