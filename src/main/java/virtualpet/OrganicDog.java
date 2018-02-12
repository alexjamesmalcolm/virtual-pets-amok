package virtualpet;

public class OrganicDog extends Organic implements Walkable{

	private Cage cage;

	public int getDirtyness() {
		return cage.getDirtyness();
	}

	public Cage getCage() {
		return cage;
	}

	public OrganicDog(String name, String description, int hunger, int thirst, int boredom, int waste, Cage cage) {
		this.name = name;
		this.description = description;
		this.health = DEFAULT_HEALTH;
		this.hunger = hunger;
		this.thirst = thirst;
		this.boredom = boredom;
		this.waste = waste;
		this.cage = cage;
	}

	public OrganicDog(String name, String description) {
		this(name, description, DEFAULT_HUNGER, DEFAULT_THIRST, DEFAULT_BOREDOM, DEFAULT_WASTE, new Cage());
	}

	public void cleanCage() {
		cage.clean();
	}

	public void soilCage() {
		if (waste > 100) {
			cage.addWaste((waste - 100) / WASTE_TO_DIRTYNESS);
		}
	}

	@Override
	void goToBathroom() {
		soilCage();
	}

	@Override
	public void walk() {
		boredom = 0;
		waste = 0;
	}

	public boolean isAlive() {
		return health > 0;
	}

}
