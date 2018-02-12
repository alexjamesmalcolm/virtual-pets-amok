package virtualpet;

import java.util.Scanner;

public class VirtualPetShelterApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		LitterBox litterBox = new LitterBox();
		VirtualPetShelter shelter = new VirtualPetShelter(litterBox);
		while (true) {
			if (shelter.numberOfPets() > 0) {
				System.out.println("This is the status of your pets:\n");
				System.out.println(shelter.status());
				System.out.println("What would you like to do next?");
				System.out.println("1. Feed the Organic pets");
				System.out.println("2. Water the Organic pets");
				System.out.println("3. Play with a pet");
				System.out.println("4. Walk dogs");
				System.out.println("5. Oil all robots");
				System.out.println("6. Clean all cages");
				System.out.println("7. Empty litter box");
				System.out.println("8. Adopt a pet");
				System.out.println("9. Admit a pet");
				System.out.println("0. Quit");
			} else {
				System.out.println("9. Admit a pet");
				System.out.println("0. Quit");
			}
			shelter.tick();
			String choice = input.next();
			input.nextLine();
			if (choice.equals("1")) {
				System.out.println("You feed all the organic pets");
				shelter.feed();
			} else if (choice.equals("2")) {
				System.out.println("You put water in all the organic pet's dishes");
				shelter.water();
			} else if (choice.equals("3")) {
				System.out.println("These are the pets you can play with: ");
				System.out.println(shelter.getNames());
				System.out.println("Enter the name of the pet you want to play with: ");
				String name = input.nextLine();
				shelter.play(name);
			} else if (choice.equals("4")) {
				System.out.println("You walk the dogs");
				shelter.walk();
			} else if (choice.equals("5")) {
				System.out.println("You oil all the robotic pets");
				shelter.oilAllRobots();
			} else if (choice.equals("6")) {
				System.out.println("You clean all the cages");
				shelter.cleanCages();
			} else if (choice.equals("7")) {
				System.out.println("You empty the litter box");
				shelter.emptyLitterBox();
			} else if (choice.equals("8")) {
				System.out.println("Enter name of pet to adopt: ");
				String name = input.nextLine();
				shelter.adoptPet(name);
			} else if (choice.equals("9")) {
				System.out.println("Pick type of pet: ");
				System.out.println("1. Organic Dog");
				System.out.println("2. Organic Cat");
				System.out.println("3. Robotic Dog");
				System.out.println("4. Robotic Cat");
				String type = input.next();
				input.nextLine();
				System.out.println("Enter name: ");
				String name = input.nextLine();
				System.out.println("Enter description: ");
				String description = input.nextLine();
				if (type.equals("2")) {
					OrganicCat pet = new OrganicCat(name, description, shelter.getLitterBox());
					shelter.add(pet);
				} else if (type.equals("3")) {
					RoboticDog pet = new RoboticDog(name, description);
					shelter.add(pet);
				} else if (type.equals("4")) {
					RoboticCat pet = new RoboticCat(name, description);
					shelter.add(pet);
				} else {
					OrganicDog pet = new OrganicDog(name, description);
					shelter.add(pet);
				}
			} else if (choice.equals("0")) {
				break;
			}
		}
		input.close();
	}

}
