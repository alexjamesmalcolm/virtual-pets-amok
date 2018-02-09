package virtualpet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static virtualpet.OldVirtualPet.BOREDOM_PER_TICK;
import static virtualpet.OldVirtualPet.DEFAULT_BOREDOM;
import static virtualpet.OldVirtualPet.DEFAULT_HUNGER;
import static virtualpet.OldVirtualPet.DEFAULT_THIRST;
import static virtualpet.OldVirtualPet.HUNGER_PER_TICK;
import static virtualpet.OldVirtualPet.HUNGER_TO_THIRST;
import static virtualpet.OldVirtualPet.THIRST_PER_TICK;

import org.junit.Before;
import org.junit.Test;

public class OldVirtualPetTest {

	private OldVirtualPet tommy;
	private OldVirtualPet joey;

	@Before
	public void setup() {
		tommy = new OldVirtualPet("Tommy", "Boy this one stinks", 50, 50, 50);
		joey = new OldVirtualPet("Joey", "That's one cool pet");
	}

	@Test
	public void shouldHaveDescription() {
		OldVirtualPet underTest = new OldVirtualPet("Tommy", "Boy this one stinks");
		String description = underTest.getDescription();
		assertThat(description, is("Boy this one stinks"));
	}

	@Test
	public void shouldHaveDifferentDescription() {
		OldVirtualPet underTest = new OldVirtualPet("Joey", "That's one cool pet");
		String description = underTest.getDescription();
		assertThat(description, is("That's one cool pet"));
	}

	@Test
	public void shouldHaveHunger() {
		OldVirtualPet underTest = new OldVirtualPet("Tommy", "Boy this one stinks", 50, 0, 0);
		int hunger = underTest.getHunger();
		assertThat(hunger, is(50));
	}

	@Test
	public void shouldHaveThirst() {
		OldVirtualPet underTest = new OldVirtualPet("Tommy", "Boy this one stinks", 0, 50, 0);
		int thirst = underTest.getThirst();
		assertThat(thirst, is(50));
	}

	@Test
	public void shouldHaveBoredom() {
		OldVirtualPet underTest = new OldVirtualPet("Tommy", "Boy this one stinks", 0, 0, 50);
		int boredom = underTest.getBoredom();
		assertThat(boredom, is(50));
	}

	@Test
	public void shouldFeedPet() {
		OldVirtualPet underTest = new OldVirtualPet("Tommy", "Boy this one stinks", 50, 0, 0);
		underTest.feed();
		int hunger = underTest.getHunger();
		assertThat(hunger, is(0));
	}

	@Test
	public void shouldWaterPet() {
		OldVirtualPet underTest = new OldVirtualPet("Tommy", "Boy this one stinks", 0, 50, 0);
		underTest.water();
		int thirst = underTest.getThirst();
		assertThat(thirst, is(0));
	}

	@Test
	public void shouldPlayWithPet() {
		OldVirtualPet underTest = new OldVirtualPet("Tommy", "Boy this one stinks", 0, 0, 50);
		underTest.play();
		int boredom = underTest.getBoredom();
		assertThat(boredom, is(0));
	}

	@Test
	public void shouldHaveTickIncreaseHunger() {
		tommy.tick();
		int hunger = tommy.getHunger();
		assertThat(hunger, is(50 + HUNGER_PER_TICK));
	}

	@Test
	public void shouldHaveTickIncreaseThirst() {
		tommy.tick();
		int thirst = tommy.getThirst();
		assertThat(thirst, is(50 + THIRST_PER_TICK));
	}

	@Test
	public void shouldHaveTickIncreaseBoredom() {
		tommy.tick();
		int boredom = tommy.getBoredom();
		assertThat(boredom, is(50 + BOREDOM_PER_TICK));
	}

	@Test
	public void shouldHaveFeedIncreaseThirst() {
		tommy.feed();
		int thirst = tommy.getThirst();
		assertThat(thirst, is(50 + 50 / HUNGER_TO_THIRST));
	}

	@Test
	public void shouldHaveDefaultHunger() {
		int hunger = joey.getHunger();
		assertThat(hunger, is(DEFAULT_HUNGER));
	}

	@Test
	public void shouldHaveDefaultThirst() {
		int thirst = joey.getThirst();
		assertThat(thirst, is(DEFAULT_THIRST));
	}

	@Test
	public void shouldHaveDefaultBoredom() {
		int boredom = joey.getBoredom();
		assertThat(boredom, is(DEFAULT_BOREDOM));
	}

	@Test
	public void shouldBeCalledJoey() {
		String name = joey.getName();
		assertThat(name, is("Joey"));
	}

}
