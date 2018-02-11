package virtualpet;

import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	Map<String, Pet> pets = new HashMap<>();

	public Pet getPet(String name) {
		return pets.get(name);
	}

	public VirtualPetShelter(LitterBox litterBox) {
	}

	public void add(Pet pet) {
		pets.put(pet.getName(), pet);
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

}
