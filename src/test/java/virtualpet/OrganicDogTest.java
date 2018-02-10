package virtualpet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class OrganicDogTest {

	@Test
	public void shouldHaveFeedDecreaseHunger() {
		int hunger = 100;
		OrganicDog underTest = new OrganicDog(hunger, 0);
		underTest.feed();
		int returnedHunger = underTest.getHunger();
		assertThat(returnedHunger, is(0));
	}

	@Test
	public void shouldHaveWaterDecreaseThirst() {
		int thirst = 100;
		OrganicDog underTest = new OrganicDog(0, thirst);
		underTest.water();
		int returnedThirst = underTest.getThirst();
		assertThat(returnedThirst, is(0));
	}

	@Test
	public void shouldHaveFeedIncreaseThirst() {
		OrganicDog underTest = new OrganicDog(100, 0);
		underTest.feed();
		int thirst = underTest.getThirst();
		assertThat(thirst, is(100 / OrganicDog.HUNGER_TO_THIRST));
	}

}
