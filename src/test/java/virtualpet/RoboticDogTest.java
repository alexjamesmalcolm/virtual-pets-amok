package virtualpet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static virtualpet.RoboticDog.DRYNESS_PER_TICK;

import org.junit.Test;

public class RoboticDogTest {

	@Test
	public void shouldHaveNameJoey() {
		RoboticDog underTest = new RoboticDog("Joey", "");
		String name = underTest.getName();
		assertThat(name, is("Joey"));
	}

	@Test
	public void shouldHaveDescriptionStinky() {
		RoboticDog underTest = new RoboticDog("", "Stinky");
		String description = underTest.getDescription();
		assertThat(description, is("Stinky"));
	}

	@Test
	public void shouldHaveDryness80() {
		RoboticDog underTest = new RoboticDog("", "", 100, 0, 80);
		int dryness = underTest.getDryness();
		assertThat(dryness, is(80));
	}

	@Test
	public void shouldHaveDryness0() {
		RoboticDog underTest = new RoboticDog("", "");
		int dryness = underTest.getDryness();
		assertThat(dryness, is(0));
	}

	@Test
	public void shouldOilToReduceDryness() {
		RoboticDog underTest = new RoboticDog("", "", 100, 0, 80);
		underTest.oil();
		int dryness = underTest.getDryness();
		assertThat(dryness, is(0));
	}

	@Test
	public void shouldHaveHealth100() {
		RoboticDog underTest = new RoboticDog("", "", 100, 0, 80);
		int health = underTest.getHealth();
		assertThat(health, is(100));
	}

	@Test
	public void shouldHaveHealth20() {
		RoboticDog underTest = new RoboticDog("", "", 20, 0, 80);
		int health = underTest.getHealth();
		assertThat(health, is(20));
	}

	@Test
	public void shouldHaveTickIncreaseDryness() {
		RoboticDog underTest = new RoboticDog("", "", 50, 0, 10);
		underTest.tick();
		int dryness = underTest.getDryness();
		assertThat(dryness, is(10 + DRYNESS_PER_TICK));
	}

	@Test
	public void shouldHaveBoredom10() {
		int boredom = 10;
		RoboticDog underTest = new RoboticDog("", "", 0, boredom, 0);
		int returnedBoredom = underTest.getBoredom();
		assertThat(returnedBoredom, is(10));
	}

	@Test
	public void shouldHaveBoredom100() {
		int boredom = 100;
		RoboticDog underTest = new RoboticDog("", "", 0, boredom, 0);
		int returnedBoredom = underTest.getBoredom();
		assertThat(returnedBoredom, is(100));
	}

	@Test
	public void shouldHaveNameAlan() {
		RoboticDog underTest = new RoboticDog("Alan", "", 0, 0, 0);
		String name = underTest.getName();
		assertThat(name, is("Alan"));
	}

	@Test
	public void shouldHaveDescriptionGoodBoy() {
		RoboticDog underTest = new RoboticDog("", "Good boy", 0, 0, 0);
		String description = underTest.getDescription();
		assertThat(description, is("Good boy"));
	}

	@Test
	public void shouldHavePlayReduceBoredom() {
		RoboticDog underTest = new RoboticDog("", "", 0, 100, 0);
		underTest.play();
		int boredom = underTest.getBoredom();
		assertThat(boredom, is(0));
	}
}
