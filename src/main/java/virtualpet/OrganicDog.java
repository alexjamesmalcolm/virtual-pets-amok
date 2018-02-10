package virtualpet;

public class OrganicDog extends Organic {

	private Cage cage;

	public int getDirtyness() {
		return cage.getDirtyness();
	}

	public Cage getCage() {
		return cage;
	}

	public OrganicDog(String name, int hunger, int thirst, int boredom, int waste, Cage cage) {
		this.name = name;
		this.health = DEFAULT_HEALTH;
		this.hunger = hunger;
		this.thirst = thirst;
		this.boredom = boredom;
		this.waste = waste;
		this.cage = cage;
	}

	public void cleanCage() {
		cage.clean();
	}

	public void soilCage() {
		if (waste > 100) {
			cage.addWaste((waste - 100) / WASTE_TO_DIRTYNESS);
		}
	}

}
