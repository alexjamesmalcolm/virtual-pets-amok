package virtualpet;

public class OrganicCat extends Organic{

	public OrganicCat(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public OrganicCat(String name, String description, int boredom) {
		this.boredom = boredom;
	}

}
