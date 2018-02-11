package virtualpet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static virtualpet.Box.DEFAULT_DIRTYNESS;
import static virtualpet.Pet.BOREDOM_PER_TICK;
import static virtualpet.Pet.DEFAULT_BOREDOM;

import java.util.Collection;

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
		petShelter.add(organicDog);
		petShelter.add(organicCat);
		petShelter.add(roboticDog);
		petShelter.add(roboticCat);
	}

	@Test
	public void shouldWalkOrganicDog() {
		petShelter.walk();
		Pet pet = petShelter.getPet("Joey");
		assertThat(pet.getBoredom(), is(0));
	}

	@Test
	public void shouldWalkRoboticDog() {
		petShelter.walk();
		Pet pet = petShelter.getPet("Auto");
		assertThat(pet.getBoredom(), is(0));
	}

	@Test
	public void shouldAdoptOnePet() {
		petShelter.adoptPet("Joey");
		int numberOfPets = petShelter.numberOfPets();
		assertThat(numberOfPets, is(3));
	}

	@Test
	public void shouldAdoptTwoPets() {
		petShelter.adoptPet("Joey");
		petShelter.adoptPet("Auto");
		int numberOfPets = petShelter.numberOfPets();
		assertThat(numberOfPets, is(2));
	}

	@Test
	public void shouldOilRoboticCat() {
		petShelter.oilAllRobots();
		int dryness = ((Robotic) petShelter.getPet("Synth")).getDryness();
		assertThat(dryness, is(0));
	}

	@Test
	public void shouldOilRoboticDog() {
		petShelter.oilAllRobots();
		int dryness = ((Robotic) petShelter.getPet("Auto")).getDryness();
		assertThat(dryness, is(0));
	}

	@Test
	public void shouldFeedOrganicDog() {
		petShelter.feed();
		int hunger = ((Organic) petShelter.getPet("Joey")).getHunger();
		assertThat(hunger, is(0));
	}

	@Test
	public void shouldFeedOrganicCat() {
		petShelter.feed();
		int hunger = ((Organic) petShelter.getPet("Phil")).getHunger();
		assertThat(hunger, is(0));
	}

	@Test
	public void shouldWaterOrganicDog() {
		petShelter.water();
		int thirst = ((Organic) petShelter.getPet("Joey")).getThirst();
		assertThat(thirst, is(0));
	}

	@Test
	public void shouldPlayWithOrganicDog() {
		petShelter.play("Joey");
		int boredom = petShelter.getPet("Joey").getBoredom();
		assertThat(boredom, is(0));
	}

	@Test
	public void shouldHaveTickCallTick() {
		petShelter.tick();
		int boredom = petShelter.getPet("Joey").getBoredom();
		assertThat(boredom, is(DEFAULT_BOREDOM + BOREDOM_PER_TICK));
	}
	
	@Test
	public void shouldEmptyLitterBox() {
		petShelter.emptyLitterBox();
		int dirtyness = petShelter.getDirtyness();
		assertThat(dirtyness, is(0));
	}
	
	@Test
	public void shouldHaveDefaultDirtyness() {
		int dirtyness = petShelter.getDirtyness();
		assertThat(dirtyness, is(DEFAULT_DIRTYNESS));
	}
	
	@Test
	public void shouldHaveCageForJoey() {
		Cage cage = petShelter.getCage("Joey");
		assertThat(cage instanceof Cage, is(true));
	}
	
	@Test
	public void shouldHaveOneCage() {
		int numberOfCages = petShelter.numberOfCages();
		assertThat(numberOfCages, is(1));
	}
	
	@Test
	public void shouldHaveTwoCages() {
		petShelter.add(new OrganicDog("anne", "Is okay"));
		int numberOfCages = petShelter.numberOfCages();
		assertThat(numberOfCages, is(2));
	}
	
	@Test
	public void shouldCleanCages() {
		petShelter.add(new OrganicDog("anne", "Is okay"));
		petShelter.cleanCages();
		Collection<Cage> cages = petShelter.getCages();
		for(Cage cage : cages) {
			assertThat(cage.getDirtyness(), is(0));
		}
	}
}
