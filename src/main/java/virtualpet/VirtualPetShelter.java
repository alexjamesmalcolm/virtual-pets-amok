package virtualpet;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class VirtualPetShelter {

	private Map<String, VirtualPet> pets = new TreeMap<String, VirtualPet>();

	public void addPet(VirtualPet pet) {
		pets.put(pet.getName(), pet);
	}

	public VirtualPet getPet(String name) {
		return pets.get(name);
	}

	public Collection<VirtualPet> pets() {
		return pets.values();
	}

	public void adoptPet(String name) {
		pets.remove(name);
	}

	public void feed() {
		pets.forEach((name, pet) -> pet.feed());
	}

	public void water() {
		pets.forEach((name, pet) -> pet.water());
	}

	public void play(String name) {
		getPet(name).play();
	}

	public void tick() {
		pets.forEach((name, pet) -> pet.tick());
	}

	@Override
	public String toString() {
		if (pets().size() == 0) {
			return "There are no pets in the shelter.";
		}
		String message = "Name\t|Hunger\t|Thirst\t|Boredom\n--------|-------|-------|-------\n";
		for (VirtualPet pet : pets()) {
			message += pet.getName() + "\t|" + pet.getHunger() + "\t|" + pet.getThirst() + "\t|" + pet.getBoredom()
					+ "\n";
		}
		return message;
	}

	public int count() {
		return pets.size();
	}

	public String getNames() {
		String message = "";
		for (VirtualPet pet : pets()) {
			message += "[" + pet.getName() + "] " + pet.getDescription() + "\n";
		}
		return message;
		// return "[Joey] That's one cool pet\n[Tommy] Boy this one stinks\n";
	}

}
