package virtualpet;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static virtualpet.Box.DEFAULT_DIRTYNESS;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class VirtualPetShelterTest {

	private VirtualPetShelter underTestState;
	private LitterBox litterBox;
	private OrganicDog organicDog;
	private RoboticDog roboticDog;
	private OrganicCat organicCat;
	private RoboticCat roboticCat;

	@InjectMocks
	private VirtualPetShelter underTestMock;

	@Mock(extraInterfaces = { Walkable.class })
	private Pet walkable1;

	@Mock(extraInterfaces = { Walkable.class })
	private Pet walkable2;

	@Mock
	private Robotic robot1;

	@Mock
	private Robotic robot2;

	@Mock
	private Organic organic1;

	@Mock
	private Organic organic2;

	@Mock
	private Pet pet1;

	@Before
	public void setup() {
		litterBox = new LitterBox();
		underTestState = new VirtualPetShelter(litterBox);
		organicDog = new OrganicDog("Joey", "Cool OrganicDog");
		organicCat = new OrganicCat("Phil", "Cool OrganicCat", litterBox);
		roboticDog = new RoboticDog("Auto", "Chill RoboticDog");
		roboticCat = new RoboticCat("Synth", "Chill RoboticCat");
		underTestState.add(organicDog);
		underTestState.add(organicCat);
		underTestState.add(roboticDog);
		underTestState.add(roboticCat);
		MockitoAnnotations.initMocks(this);
		when(organic1.getName()).thenReturn("organic1");
		underTestMock.add(organic1);
		when(organic2.getName()).thenReturn("organic2");
		underTestMock.add(organic2);
		when(walkable1.getName()).thenReturn("walkable1");
		underTestMock.add(walkable1);
		when(walkable2.getName()).thenReturn("walkable2");
		underTestMock.add(walkable2);
		when(robot1.getName()).thenReturn("robot1");
		underTestMock.add(robot1);
		when(robot2.getName()).thenReturn("robot2");
		underTestMock.add(robot2);
		when(pet1.getName()).thenReturn("pet1");
		underTestMock.add(pet1);
	}

	@Test
	public void shouldWalkDogs() {
		underTestMock.walk();
		verify((Walkable) walkable1).walk();
		verify((Walkable) walkable2).walk();
	}

	@Test
	public void shouldAdoptOnePet() {
		underTestState.adoptPet("Joey");
		int numberOfPets = underTestState.numberOfPets();
		assertThat(numberOfPets, is(3));
	}

	@Test
	public void shouldAdoptTwoPets() {
		underTestState.adoptPet("Joey");
		underTestState.adoptPet("Auto");
		int numberOfPets = underTestState.numberOfPets();
		assertThat(numberOfPets, is(2));
	}

	@Test
	public void shouldOilRobots() {
		underTestMock.oilAllRobots();
		verify(robot1).oil();
		verify(robot2).oil();
	}

	@Test
	public void shouldFeedOrganics() {
		underTestMock.feed();
		verify(organic1).feed();
		verify(organic2).feed();
	}

	@Test
	public void shouldWaterOrganics() {
		underTestMock.water();
		verify(organic1).water();
		verify(organic2).water();
	}

	@Test
	public void shouldPlayWithPet() {
		underTestMock.play("pet1");
		verify(pet1).play();
	}

	@Test
	public void shouldHaveTickCallPetsTick() {
		underTestMock.tick();
		verify(pet1).tick();
	}

	@Test
	public void shouldEmptyLitterBox() {
		underTestState.emptyLitterBox();
		int dirtyness = underTestState.getDirtyness();
		assertThat(dirtyness, is(0));
	}

	@Test
	public void shouldHaveDefaultDirtyness() {
		int dirtyness = underTestState.getDirtyness();
		assertThat(dirtyness, is(DEFAULT_DIRTYNESS));
	}

	@Test
	public void shouldHaveCageForJoey() {
		Cage cage = underTestState.getCage("Joey");
		assertThat(cage instanceof Cage, is(true));
	}

	@Test
	public void shouldHaveOneCage() {
		int numberOfCages = underTestState.numberOfCages();
		assertThat(numberOfCages, is(1));
	}

	@Test
	public void shouldHaveTwoCages() {
		underTestState.add(new OrganicDog("anne", "Is okay"));
		int numberOfCages = underTestState.numberOfCages();
		assertThat(numberOfCages, is(2));
	}

	@Test
	public void shouldCleanCages() {
		underTestState.add(new OrganicDog("anne", "Is okay"));
		underTestState.cleanCages();
		Collection<Cage> cages = underTestState.getCages();
		for (Cage cage : cages) {
			assertThat(cage.getDirtyness(), is(0));
		}
	}

	@Test
	public void shouldGetPets() {
		Collection<Pet> pets = underTestState.getPets();
		assertThat(pets.size(), is(4));
	}

	@Test
	public void shouldGetNames() {
		Collection<String> names = underTestState.getNames();
		assertThat(names, is(containsInAnyOrder("Joey", "Phil", "Auto", "Synth")));
	}

	@Test
	public void shouldGetStatusNoPets() {
		VirtualPetShelter underTest = new VirtualPetShelter(litterBox);
		String status = underTest.status();
		String line1 = "Name\t|Type\t|Health\t|Boredom|Hunger\t|Thirst\t|Waste\t|Dryness|Dirtyness\n";
		String message = line1;
		assertThat(status, is(message));
	}

	@Test
	public void shouldGetStatusOrganicDog() {
		VirtualPetShelter underTest = new VirtualPetShelter(litterBox);
		underTest.add(organicDog);
		String status = underTest.status();
		String line1 = "Name\t|Type\t|Health\t|Boredom|Hunger\t|Thirst\t|Waste\t|Dryness|Dirtyness\n";
		String line2 = "Joey\t|OrgDog\t|100\t|20\t|25\t|25\t|25\t|N/A\t|10\n";
		String message = line1 + line2;
		assertEquals(message, status);
	}

	@Test
	public void shouldGetStatusOrganicCat() {
		VirtualPetShelter underTest = new VirtualPetShelter(litterBox);
		underTest.add(organicDog);
		underTest.add(organicCat);
		String status = underTest.status();
		String line1 = "Name\t|Type\t|Health\t|Boredom|Hunger\t|Thirst\t|Waste\t|Dryness|Dirtyness\n";
		String line2 = "Joey\t|OrgDog\t|100\t|20\t|25\t|25\t|25\t|N/A\t|10\n";
		String line3 = "Phil\t|OrgCat\t|100\t|20\t|20\t|30\t|40\t|N/A\t|10\n";
		String message = line1 + line2 + line3;
		assertThat(status, is(message));
	}

	@Test
	public void shouldGetStatusRoboticDog() {
		VirtualPetShelter underTest = new VirtualPetShelter(litterBox);
		underTest.add(organicDog);
		underTest.add(organicCat);
		underTest.add(roboticDog);
		String status = underTest.status();
		String line1 = "Name\t|Type\t|Health\t|Boredom|Hunger\t|Thirst\t|Waste\t|Dryness|Dirtyness\n";
		String line2 = "Auto\t|RobDog\t|100\t|20\t|N/A\t|N/A\t|N/A\t|20\t|N/A\n";
		String line3 = "Joey\t|OrgDog\t|100\t|20\t|25\t|25\t|25\t|N/A\t|10\n";
		String line4 = "Phil\t|OrgCat\t|100\t|20\t|20\t|30\t|40\t|N/A\t|10\n";
		String message = line1 + line2 + line3 + line4;
		assertThat(status, is(message));
	}

	@Test
	public void shouldGetStatusRoboticCat() {
		VirtualPetShelter underTest = new VirtualPetShelter(litterBox);
		underTest.add(organicDog);
		underTest.add(organicCat);
		underTest.add(roboticDog);
		underTest.add(roboticCat);
		String status = underTest.status();
		String line1 = "Name\t|Type\t|Health\t|Boredom|Hunger\t|Thirst\t|Waste\t|Dryness|Dirtyness\n";
		String line2 = "Auto\t|RobDog\t|100\t|20\t|N/A\t|N/A\t|N/A\t|20\t|N/A\n";
		String line3 = "Synth\t|RobCat\t|100\t|20\t|N/A\t|N/A\t|N/A\t|20\t|N/A\n";
		String line4 = "Joey\t|OrgDog\t|100\t|20\t|25\t|25\t|25\t|N/A\t|10\n";
		String line5 = "Phil\t|OrgCat\t|100\t|20\t|20\t|30\t|40\t|N/A\t|10\n";
		String message = line1 + line2 + line3 + line4 + line5;
		assertEquals(message, status);
	}

	@Test
	public void shouldGetDescriptions() {
		Collection<String> check = underTestState.getNamesAndDescriptions();
		assertThat(check, containsInAnyOrder("Joey | Cool OrganicDog", "Phil | Cool OrganicCat",
				"Auto | Chill RoboticDog", "Synth | Chill RoboticCat"));
	}

	@Test
	public void shouldRemovePetWhenDead() {
		for (int i = 0; i < 100; i++) {
			underTestState.tick();
		}
		assertThat(underTestState.numberOfPets(), is(0));
	}

	@Test
	public void shouldGetNumberOfRoboticPets() {
		int roboticPets = underTestState.numberOfRoboticPets();
		assertThat(roboticPets, is(2));
	}

	@Test
	public void shouldGetNumberOfRoboticPets3() {
		underTestState.add(new RoboticDog("robotdog", ""));
		int roboticPets = underTestState.numberOfRoboticPets();
		assertThat(roboticPets, is(3));
	}

	@Test
	public void shouldGetNumberOfWalkables() {
		int walkables = underTestState.numberOfWalkablePets();
		assertThat(walkables, is(2));
	}

	@Test
	public void shouldGetNumberOfWalkables3() {
		underTestState.add(new OrganicDog("orgdogo", ""));
		int walkables = underTestState.numberOfWalkablePets();
		assertThat(walkables, is(3));
	}

	@Test
	public void shouldGetNumberOfOrganicPets2() {
		int organics = underTestState.numberOfOrganicPets();
		assertThat(organics, is(2));
	}

	@Test
	public void shouldGetNumberOfOrganicPets3() {
		underTestState.add(new OrganicDog("orgdogo", ""));
		int organics = underTestState.numberOfOrganicPets();
		assertThat(organics, is(3));
	}
}
