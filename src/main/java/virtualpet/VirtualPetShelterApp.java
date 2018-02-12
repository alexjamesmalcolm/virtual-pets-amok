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
				System.out.println("4. Adopt a pet");
				System.out.println("5. Admit a pet");
				System.out.println("6. Quit");
				/*
				 * Feed
				 * Water
				 * Play
				 * Adopt
				 * Admit
				 * walk
				 * oil all robots
				 * clean all cages
				 * empty litter box
				 * quit
				 */

			} else {
				/*
				 * Adopt
				 * quit
				 */
			}
//			String choice = input.next();
			input.nextLine();
			//choices
//			break;
			shelter.tick();
			break;
		}
		input.close();
	}

}
