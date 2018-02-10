package virtualpet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static virtualpet.OrganicDog.HUNGER_PER_TICK;
import static virtualpet.OrganicDog.HUNGER_TO_THIRST;
import static virtualpet.OrganicDog.THIRST_PER_TICK;
import static virtualpet.Pet.BOREDOM_PER_TICK;

import org.junit.Test;

public class OrganicDogTest {

	@Test
	public void shouldHaveFeedDecreaseHunger() {
		int hunger = 100;
		OrganicDog underTest = new OrganicDog(hunger, 0, 0, 0);
		underTest.feed();
		int returnedHunger = underTest.getHunger();
		assertThat(returnedHunger, is(0));
	}

	@Test
	public void shouldHaveWaterDecreaseThirst() {
		int thirst = 100;
		OrganicDog underTest = new OrganicDog(0, thirst, 0, 0);
		underTest.water();
		int returnedThirst = underTest.getThirst();
		assertThat(returnedThirst, is(0));
	}

	@Test
	public void shouldHaveFeedIncreaseThirst() {
		OrganicDog underTest = new OrganicDog(100, 0, 0, 0);
		underTest.feed();
		int thirst = underTest.getThirst();
		assertThat(thirst, is(100 / HUNGER_TO_THIRST));
	}

	@Test
	public void shouldHaveTickIncreaseHunger() {
		OrganicDog underTest = new OrganicDog(10, 0, 0, 0);
		underTest.tick();
		int hunger = underTest.getHunger();
		assertThat(hunger, is(10 + HUNGER_PER_TICK));
	}
	
	@Test
	public void shouldHaveTickIncreaseThirst() {
		OrganicDog underTest = new OrganicDog(0, 10, 0, 0);
		underTest.tick();
		int thirst = underTest.getThirst();
		assertThat(thirst, is(10 + THIRST_PER_TICK));
	}
	
	@Test
	public void shouldHaveTickIncreaseBoredom() {
		OrganicDog underTest = new OrganicDog(0, 0, 10, 0);
		underTest.tick();
		int boredom = underTest.getBoredom();
		assertThat(boredom, is(10 + BOREDOM_PER_TICK));
	}
	
	@Test
	public void shouldHaveFeedIncreaseWaste() {
		OrganicDog underTest = new OrganicDog(100, 0, 0, 10);
		underTest.feed();
		int waste = underTest.getWaste();
		assertThat(waste, is(10 + OrganicDog.HUNGER_TO_WASTE));
	}

}
