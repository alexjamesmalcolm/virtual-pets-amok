package virtualpet;

public class OrganicCat extends Organic {

	public OrganicCat(String name, String description) {
		this(name, description, DEFAULT_BOREDOM);
	}

	public OrganicCat(String name, String description, int boredom) {
		this.name = name;
		this.description = description;
		this.boredom = boredom;
	}

}
