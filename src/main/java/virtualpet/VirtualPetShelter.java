package virtualpet;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	private Map<String, Pet> pets = new HashMap<>();
	private Map<String, Cage> cages = new HashMap<>();
	private LitterBox litterBox;

	public Pet getPet(String name) {
		return pets.get(name);
	}

	public VirtualPetShelter(LitterBox litterBox) {
		this.litterBox = litterBox;
	}

	public void add(Pet pet) {
		pets.put(pet.getName(), pet);
		if (pet instanceof OrganicDog) {
			cages.put(pet.getName(), ((OrganicDog) pet).getCage());
		}
	}

	public void walk() {
		pets.forEach((name, pet) -> {
			if (pet instanceof Walkable) {
				((Walkable) pet).walk();
			}
		});
	}

	public void adoptPet(String name) {
		pets.remove(name);
	}

	public int numberOfPets() {
		return pets.size();
	}

	public void oilAllRobots() {
		pets.forEach((name, pet) -> {
			if (pet instanceof Robotic) {
				((Robotic) pet).oil();
			}
		});
	}

	public void feed() {
		pets.forEach((name, pet) -> {
			if (pet instanceof Organic) {
				((Organic) pet).feed();
			}
		});
	}

	public void water() {
		pets.forEach((name, pet) -> {
			if (pet instanceof Organic) {
				((Organic) pet).water();
			}
		});
	}

	public void play(String name) {
		pets.get(name).play();
	}

	public void tick() {
		pets.forEach((name, pet) -> {
			pet.tick();
		});
	}

	public void emptyLitterBox() {
		litterBox.clean();
	}

	public int getDirtyness() {
		return litterBox.getDirtyness();
	}

	public Cage getCage(String name) {
		return new Cage();
	}

	public int numberOfCages() {
		return cages.size();
	}

	public void cleanCages() {
		cages.forEach((petName, cage) -> {
			cage.clean();
		});
	}

	public Collection<Cage> getCages() {
		return cages.values();
	}

}
