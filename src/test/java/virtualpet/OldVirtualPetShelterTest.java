package virtualpet;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class OldVirtualPetShelterTest {

	private OldVirtualPetShelter petShelter;
	private OldVirtualPet tommy;
	private OldVirtualPet joey;

	@Before
	public void setup() {
		petShelter = new OldVirtualPetShelter();
		tommy = new OldVirtualPet("Tommy", "Boy this one stinks");
		joey = new OldVirtualPet("Joey", "That's one cool pet");
	}

	@Test
	public void shouldAddVirtualPet() {
		petShelter.addPet(tommy);
		OldVirtualPet returnedPet = petShelter.getPet("Tommy");
		assertThat(returnedPet, is(tommy));
	}

	@Test
	public void shouldReturnAllPets() {
		petShelter.addPet(tommy);
		petShelter.addPet(joey);
		Collection<OldVirtualPet> pets = petShelter.pets();
		assertThat(pets, containsInAnyOrder(joey, tommy));
	}

	@Test
	public void shouldAdoptPet() {
		petShelter.addPet(tommy);
		petShelter.addPet(joey);
		petShelter.adoptPet(joey.getName());
		Collection<OldVirtualPet> pets = petShelter.pets();
		assertThat(pets, contains(tommy));
	}

	@Test
	public void shouldHaveFeedFeedPet() {
		petShelter.addPet(tommy);
		petShelter.feed();
		int hunger = petShelter.getPet("Tommy").getHunger();
		assertThat(hunger, is(0));
	}

	@Test
	public void shouldHaveWaterWaterPet() {
		petShelter.addPet(tommy);
		petShelter.water();
		int thirst = petShelter.getPet("Tommy").getThirst();
		assertThat(thirst, is(0));
	}

	@Test
	public void shouldHavePlayWithPet() {
		petShelter.addPet(tommy);
		String name = tommy.getName();
		petShelter.play(name);
		int boredom = petShelter.getPet(name).getBoredom();
		assertThat(boredom, is(0));
	}

	@Test
	public void shouldHaveTickUpdatePetsNeeds() {
		petShelter.addPet(tommy);
		petShelter.addPet(joey);
		petShelter.tick();
		Collection<OldVirtualPet> pets = petShelter.pets();
		OldVirtualPet expectedTommy = new OldVirtualPet("Tommy", "Boy this one stinks");
		OldVirtualPet expectedJoey = new OldVirtualPet("Joey", "That's one cool pet");
		expectedTommy.tick();
		expectedJoey.tick();
		for (OldVirtualPet pet : pets) {
			assertThat(pet.getHunger(), anyOf(is(expectedTommy.getHunger()), is(expectedJoey.getHunger())));
		}
	}

	@Test
	public void shouldHaveToStringForTwoPets() {
		petShelter.addPet(joey);
		petShelter.addPet(tommy);
		String line1 = "Name\t|Hunger\t|Thirst\t|Boredom\n";
		String line2 = "--------|-------|-------|-------\n";
		String line3 = "Joey\t|50\t|50\t|50\n";
		String line4 = "Tommy\t|50\t|50\t|50\n";
		String message = line1 + line2 + line3 + line4;
		String actual = petShelter.toString();
		assertEquals(message, actual);
	}

	@Test
	public void shouldHaveToStringForThreePets() {
		petShelter.addPet(joey);
		petShelter.addPet(tommy);
		petShelter.addPet(new OldVirtualPet("Dee dee", "", 20, 30, 60));
		String line1 = "Name\t|Hunger\t|Thirst\t|Boredom\n";
		String line2 = "--------|-------|-------|-------\n";
		String line3 = "Dee dee\t|20\t|30\t|60\n";
		String line4 = "Joey\t|50\t|50\t|50\n";
		String line5 = "Tommy\t|50\t|50\t|50\n";
		String message = line1 + line2 + line3 + line4 + line5;
		String actual = petShelter.toString();
		assertEquals(message, actual);
	}

	@Test
	public void shouldHaveToStringForNoPets() {
		String message = "There are no pets in the shelter.";
		String actual = petShelter.toString();
		assertThat(actual, is(message));
	}

	@Test
	public void shouldHaveOnePet() {
		petShelter.addPet(joey);
		int number = petShelter.count();
		assertThat(number, is(1));
	}

	@Test
	public void shouldHaveTwoPets() {
		petShelter.addPet(joey);
		petShelter.addPet(tommy);
		int number = petShelter.count();
		assertThat(number, is(2));
	}

	@Test
	public void shouldReturnNamesOfTwoPets() {
		petShelter.addPet(joey);
		petShelter.addPet(tommy);
		String message = "[Joey] That's one cool pet\n[Tommy] Boy this one stinks\n";
		String actual = petShelter.getNames();
		assertThat(actual, is(message));
	}

	@Test
	public void shouldReturnNamesOfOnePets() {
		petShelter.addPet(joey);
		String message = "[Joey] That's one cool pet\n";
		String actual = petShelter.getNames();
		assertThat(actual, is(message));
	}
}
