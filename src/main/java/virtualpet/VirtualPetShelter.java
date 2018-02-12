package virtualpet;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class VirtualPetShelter {

	private Map<String, Pet> pets = new HashMap<>();
	private Map<String, Cage> cages = new HashMap<>();
	private LitterBox litterBox;

	public Pet getPet(String name) {
		return pets.get(name);
	}

	public Collection<Pet> getPets() {
		return pets.values();
	}

	public Cage getCage(String name) {
		return new Cage();
	}

	public Collection<Cage> getCages() {
		return cages.values();
	}

	public int numberOfPets() {
		return getPets().size();
	}

	public int numberOfCages() {
		return cages.size();
	}

	public int getDirtyness() {
		return litterBox.getDirtyness();
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
		getPets().forEach(pet -> {
			if (pet instanceof Walkable) {
				((Walkable) pet).walk();
			}
		});
	}

	public void adoptPet(String name) {
		pets.remove(name);
	}

	public void oilAllRobots() {
		getPets().forEach(pet -> {
			if (pet instanceof Robotic) {
				((Robotic) pet).oil();
			}
		});
	}

	public void feed() {
		getPets().forEach(pet -> {
			if (pet instanceof Organic) {
				((Organic) pet).feed();
			}
		});
	}

	public void water() {
		getPets().forEach(pet -> {
			if (pet instanceof Organic) {
				((Organic) pet).water();
			}
		});
	}

	public void play(String name) {
		getPet(name).play();
	}

	public void tick() {
		getPets().forEach(pet -> {
			pet.tick();
		});
	}

	public void emptyLitterBox() {
		litterBox.clean();
	}

	public void cleanCages() {
		cages.forEach((petName, cage) -> {
			cage.clean();
		});
	}

	public Set<String> getNames() {
		return pets.keySet();
	}

	public String status() {
		String tab = "\t|";
		String result = "Name\t|Type\t|Health\t|Boredom|Hunger\t|Thirst\t|Waste\t|dryness\n";
		for (Pet pet : getPets()) {
			Organic organicDog = (Organic) pet;
			result += organicDog.getName() + tab + "OrgDog" + tab + organicDog.getHealth() + tab
					+ organicDog.getBoredom() + tab + organicDog.getHunger() + tab + organicDog.getThirst() + tab
					+ organicDog.getWaste() + tab + "N/A" + "\n";
		}
		System.out.println(result);
		return result;
	}

}
