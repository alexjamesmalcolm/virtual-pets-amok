package virtualpet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static virtualpet.Box.DEFAULT_DIRTYNESS;
import static virtualpet.Organic.DEFAULT_HUNGER;
import static virtualpet.Organic.HUNGER_PER_TICK;
import static virtualpet.Organic.HUNGER_TO_THIRST;
import static virtualpet.Organic.HUNGER_TO_WASTE;
import static virtualpet.Organic.THIRST_PER_TICK;
import static virtualpet.Organic.THIRST_TO_WASTE;
import static virtualpet.Organic.WASTE_TO_DIRTYNESS;
import static virtualpet.Pet.BOREDOM_PER_TICK;
import static virtualpet.Pet.DEFAULT_HEALTH;

import org.junit.Before;
import org.junit.Test;

public class OrganicDogTest {

	private OrganicDog joey;

	@Before
	public void setup() {
		joey = new OrganicDog("Joey", "Cool");
	}

	@Test
	public void shouldHaveFeedDecreaseHunger() {
		int hunger = 100;
		Organic underTest = new OrganicDog("Joey", "Cool", hunger, 0, 0, 0, new Cage());
		underTest.feed();
		int returnedHunger = underTest.getHunger();
		assertThat(returnedHunger, is(0));
	}

	@Test
	public void shouldHaveWaterDecreaseThirst() {
		int thirst = 100;
		Organic underTest = new OrganicDog("Joey", "Cool", 0, thirst, 0, 0, new Cage());
		underTest.water();
		int returnedThirst = underTest.getThirst();
		assertThat(returnedThirst, is(0));
	}

	@Test
	public void shouldHaveFeedIncreaseThirst() {
		Organic underTest = new OrganicDog("Joey", "Cool", 100, 10, 0, 0, new Cage());
		underTest.feed();
		int thirst = underTest.getThirst();
		assertThat(thirst, is(10 + 100 / HUNGER_TO_THIRST));
	}

	@Test
	public void shouldHaveTickIncreaseHunger() {
		Organic underTest = new OrganicDog("Joey", "Cool", 10, 0, 0, 0, new Cage());
		underTest.tick();
		int hunger = underTest.getHunger();
		assertThat(hunger, is(10 + HUNGER_PER_TICK));
	}

	@Test
	public void shouldHaveTickIncreaseThirst() {
		Organic underTest = new OrganicDog("Joey", "Cool", 0, 10, 0, 0, new Cage());
		underTest.tick();
		int thirst = underTest.getThirst();
		assertThat(thirst, is(10 + THIRST_PER_TICK));
	}

	@Test
	public void shouldHaveTickIncreaseBoredom() {
		Pet underTest = new OrganicDog("Joey", "Cool", 0, 0, 10, 0, new Cage());
		underTest.tick();
		int boredom = underTest.getBoredom();
		assertThat(boredom, is(10 + BOREDOM_PER_TICK));
	}

	@Test
	public void shouldHaveFeedIncreaseWaste() {
		Organic underTest = new OrganicDog("Joey", "Cool", 100, 0, 0, 10, new Cage());
		underTest.feed();
		int waste = underTest.getWaste();
		assertThat(waste, is(10 + 100 / HUNGER_TO_WASTE));
	}

	@Test
	public void shouldHaveWaterIncreaseWaste() {
		Organic underTest = new OrganicDog("Joey", "Cool", 0, 100, 0, 20, new Cage());
		underTest.water();
		int waste = underTest.getWaste();
		assertThat(waste, is(20 + 100 / THIRST_TO_WASTE));
	}

	@Test
	public void shouldHaveTickDecreaseHealthIfHungry() {
		Pet underTest = new OrganicDog("Joey", "Cool", 120, 0, 0, 0, new Cage());
		underTest.tick();
		int health = underTest.getHealth();
		assertThat(health, is(80));
	}

	@Test
	public void shouldHaveDefaultHealth() {
		Pet underTest = new OrganicDog("Joey", "Cool", 0, 0, 0, 0, new Cage());
		underTest.tick();
		int health = underTest.getHealth();
		assertThat(health, is(DEFAULT_HEALTH));
	}

	@Test
	public void shouldHaveTickDecreaseHealthIfThirsty() {
		Pet underTest = new OrganicDog("Joey", "Cool", 0, 130, 0, 0, new Cage());
		underTest.tick();
		int health = underTest.getHealth();
		assertThat(health, is(70));
	}

	@Test
	public void shouldHaveTickDecreaseHealthIfBored() {
		Pet underTest = new OrganicDog("Joey", "Cool", 0, 0, 140, 0, new Cage());
		underTest.tick();
		int health = underTest.getHealth();
		assertThat(health, is(60));
	}

	@Test
	public void shouldGetCage() {
		OrganicDog underTest = new OrganicDog("Joey", "Cool", 0, 0, 0, 0, new Cage());
		Box cage = underTest.getCage();
		assertThat(cage instanceof Cage, is(true));
	}

	@Test
	public void shouldGetDirtyness() {
		Organic underTest = new OrganicDog("Joey", "Cool", 0, 0, 0, 0, new Cage());
		int dirtyness = underTest.getDirtyness();
		assertThat(dirtyness, is(DEFAULT_DIRTYNESS));
	}

	@Test
	public void shouldHaveCleanCageCleanTheCage() {
		OrganicDog underTest = new OrganicDog("Joey", "Cool", 0, 0, 0, 0, new Cage());
		underTest.cleanCage();
		int dirtyness = underTest.getDirtyness();
		assertThat(dirtyness, is(0));
	}

	@Test
	public void shouldHaveConstructorTakeCage() {
		Cage cage = new Cage(50);
		OrganicDog underTest = new OrganicDog("Joey", "Cool", 0, 0, 0, 0, cage);
		underTest.cleanCage();
		Box returnedCage = underTest.getCage();
		assertThat(returnedCage.getDirtyness(), is(cage.getDirtyness()));
	}

	@Test
	public void shouldHaveSoilCageIncreaseCageDirtyness150() {
		OrganicDog underTest = new OrganicDog("Joey", "Cool", 0, 0, 0, 150, new Cage());
		underTest.soilCage();
		int dirtyness = underTest.getDirtyness();
		assertThat(dirtyness, is(DEFAULT_DIRTYNESS + (150 - 100) / WASTE_TO_DIRTYNESS));
	}

	@Test
	public void shouldHaveSoilCageIncreaseCageDirtyness120() {
		OrganicDog underTest = new OrganicDog("Joey", "Cool", 0, 0, 0, 120, new Cage());
		underTest.soilCage();
		int dirtyness = underTest.getDirtyness();
		assertThat(dirtyness, is(DEFAULT_DIRTYNESS + (120 - 100) / WASTE_TO_DIRTYNESS));
	}

	@Test
	public void shouldHaveSoilCageNotIncreaseCageDirtyness90() {
		OrganicDog underTest = new OrganicDog("Joey", "Cool", 0, 0, 0, 90, new Cage());
		underTest.soilCage();
		int dirtyness = underTest.getDirtyness();
		assertThat(dirtyness, is(DEFAULT_DIRTYNESS));
	}

	@Test
	public void shouldHaveNameJoey() {
		Pet underTest = new OrganicDog("Joey", "Cool", 0, 0, 0, 0, new Cage());
		String name = underTest.getName();
		assertThat(name, is("Joey"));
	}

	@Test
	public void shouldHaveDescriptionCool() {
		Pet underTest = new OrganicDog("Joey", "Cool", 0, 0, 0, 0, new Cage());
		String description = underTest.getDescription();
		assertThat(description, is("Cool"));
	}

	@Test
	public void shouldHaveDefaultsConstructorName() {
		String name = joey.getName();
		assertThat(name, is("Joey"));
	}

	@Test
	public void shouldHaveDefaultHunger() {
		int hunger = joey.getHunger();
		assertThat(hunger, is(DEFAULT_HUNGER));
	}

	@Test
	public void shouldHaveTickUseBathroom110() {
		Organic underTest = new OrganicDog("Joey", "Cool", 0, 0, 0, 110, new Cage());
		underTest.tick();
		int dirtyness = underTest.getDirtyness();
		assertThat(dirtyness, is(DEFAULT_DIRTYNESS + 10 / WASTE_TO_DIRTYNESS));
	}

	@Test
	public void shouldHaveWalkReduceBoredom() {
		joey.walk();
		int boredom = joey.getBoredom();
		assertThat(boredom, is(0));
	}

	@Test
	public void shouldHaveWalkReduceWaste() {
		joey.walk();
		int waste = joey.getWaste();
		assertThat(waste, is(0));
	}

	@Test
	public void shouldHaveTickReduceHealthIfDirty() {
		Cage cage = new Cage(120);
		Pet underTest = new OrganicDog("Joey", "Cool", 0, 0, 0, 0, cage);
		underTest.tick();
		int health = underTest.getHealth();
		assertThat(health, is(80));
	}

	@Test
	public void shouldBeDeadIfHealth0() {
		Pet underTest = new OrganicDog("Joey", "Cool", 140, 140, 140, 0, new Cage());
		underTest.tick();
		boolean status = underTest.isAlive();
		assertThat(status, is(false));
	}

	@Test
	public void shouldBeAliveIfHealthisOne() {
		Pet underTest = new OrganicDog("Joey", "Cool", 199, 0, 0, 0, new Cage());
		underTest.tick();
		boolean status = underTest.isAlive();
		assertThat(status, is(true));
	}
}
