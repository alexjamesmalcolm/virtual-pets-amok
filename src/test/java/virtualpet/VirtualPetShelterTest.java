package virtualpet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VirtualPetShelterTest {

	private VirtualPetShelter petShelter;
	private LitterBox litterBox;
	private OrganicDog organicDog;
	private RoboticDog roboticDog;
	private OrganicCat organicCat;
	private RoboticCat roboticCat;

	@Before
	public void setup() {
		litterBox = new LitterBox();
		petShelter = new VirtualPetShelter(litterBox);
		organicDog = new OrganicDog("Joey", "Cool OrganicDog");
		organicCat = new OrganicCat("Phil", "Cool OrganicCat", litterBox);
		roboticDog = new RoboticDog("Auto", "Chill RoboticDog");
		roboticCat = new RoboticCat("Synth", "Chill RoboticCat");
	}
	
	@Test
	public void shouldWalkOrganicDog() {
		petShelter.add(organicDog);
		petShelter.add(organicCat);
		petShelter.add(roboticDog);
		petShelter.add(roboticCat);
		petShelter.walk();
		Pet pet = petShelter.getPet("Joey");
		assertThat(pet.getBoredom(), is(0));
	}
}
