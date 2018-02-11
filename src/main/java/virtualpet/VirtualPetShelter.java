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
			if(pet instanceof Walkable) {
				((Walkable) pet).walk();
			}
		});
	}

}
