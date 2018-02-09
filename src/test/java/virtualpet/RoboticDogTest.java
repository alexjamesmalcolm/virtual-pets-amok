package virtualpet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

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
		RoboticDog underTest = new RoboticDog("", "", 80, 100);
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
		RoboticDog underTest = new RoboticDog("", "", 80, 100);
		underTest.oil();
		int dryness = underTest.getDryness();
		assertThat(dryness, is(0));
	}

	@Test
	public void shouldHaveHealth100() {
		RoboticDog underTest = new RoboticDog("", "", 80, 100);
		int health = underTest.getHealth();
		assertThat(health, is(100));
	}

	@Test
	public void shouldHaveHealth20() {
		RoboticDog underTest = new RoboticDog("", "", 80, 20);
		int health = underTest.getHealth();
		assertThat(health, is(20));
	}
}
