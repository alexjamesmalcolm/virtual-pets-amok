package virtualpet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static virtualpet.Box.DEFAULT_DIRTYNESS;
import static virtualpet.OrganicDog.HUNGER_PER_TICK;
import static virtualpet.OrganicDog.HUNGER_TO_THIRST;
import static virtualpet.OrganicDog.HUNGER_TO_WASTE;
import static virtualpet.OrganicDog.THIRST_PER_TICK;
import static virtualpet.OrganicDog.THIRST_TO_WASTE;
import static virtualpet.OrganicDog.WASTE_TO_DIRTYNESS;
import static virtualpet.Pet.BOREDOM_PER_TICK;
import static virtualpet.Pet.DEFAULT_HEALTH;

import org.junit.Test;

public class OrganicDogTest {

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
		Organic underTest = new OrganicDog("Joey", "Cool", 0, 0, 10, 0, new Cage());
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
		Organic underTest = new OrganicDog("Joey", "Cool", 120, 0, 0, 0, new Cage());
		underTest.tick();
		int health = underTest.getHealth();
		assertThat(health, is(80));
	}

	@Test
	public void shouldHaveDefaultHealth() {
		Organic underTest = new OrganicDog("Joey", "Cool", 0, 0, 0, 0, new Cage());
		underTest.tick();
		int health = underTest.getHealth();
		assertThat(health, is(DEFAULT_HEALTH));
	}

	@Test
	public void shouldHaveTickDecreaseHealthIfThirsty() {
		Organic underTest = new OrganicDog("Joey", "Cool", 0, 130, 0, 0, new Cage());
		underTest.tick();
		int health = underTest.getHealth();
		assertThat(health, is(70));
	}

	@Test
	public void shouldHaveTickDecreaseHealthIfBored() {
		Organic underTest = new OrganicDog("Joey", "Cool", 0, 0, 140, 0, new Cage());
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
		OrganicDog underTest = new OrganicDog("Joey", "Cool", 0, 0, 0, 0, new Cage());
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
		Cage returnedCage = underTest.getCage();
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
		OrganicDog underTest = new OrganicDog("Joey", "Cool", 0, 0, 0, 0, new Cage());
		String name = underTest.getName();
		assertThat(name, is("Joey"));
	}

	@Test
	public void shouldHaveDescriptionCool() {
		OrganicDog underTest = new OrganicDog("Joey", "Cool", 0, 0, 0, 0, new Cage());
		String description = underTest.getDescription();
		assertThat(description, is("Cool"));
	}
	
	@Test
	public void shouldHaveDefaultsConstructorName() {
		OrganicDog underTest = new OrganicDog("Joey", "Cool");
		String name = underTest.getName();
		assertThat(name, is("Joey"));
	}
}
