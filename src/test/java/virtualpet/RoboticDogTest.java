package virtualpet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static virtualpet.RoboticDog.DEFAULT_BOREDOM;
import static virtualpet.RoboticDog.DEFAULT_DRYNESS;
import static virtualpet.RoboticDog.DEFAULT_HEALTH;
import static virtualpet.RoboticDog.DRYNESS_PER_TICK;

import org.junit.Test;

public class RoboticDogTest {

	@Test
	public void shouldHaveNameJoey() {
		Pet underTest = new RoboticDog("Joey", "");
		String name = underTest.getName();
		assertThat(name, is("Joey"));
	}

	@Test
	public void shouldHaveDescriptionStinky() {
		Pet underTest = new RoboticDog("", "Stinky");
		String description = underTest.getDescription();
		assertThat(description, is("Stinky"));
	}

	@Test
	public void shouldHaveDryness80() {
		Robotic underTest = new RoboticDog("", "", 0, 80);
		int dryness = underTest.getDryness();
		assertThat(dryness, is(80));
	}

	@Test
	public void shouldHaveDryness0() {
		Robotic underTest = new RoboticDog("", "", 0, 0);
		int dryness = underTest.getDryness();
		assertThat(dryness, is(0));
	}

	@Test
	public void shouldOilToReduceDryness() {
		Robotic underTest = new RoboticDog("", "", 0, 80);
		underTest.oil();
		int dryness = underTest.getDryness();
		assertThat(dryness, is(0));
	}

	@Test
	public void shouldHaveTickIncreaseDryness() {
		Robotic underTest = new RoboticDog("", "", 0, 10);
		underTest.tick();
		int dryness = underTest.getDryness();
		assertThat(dryness, is(10 + DRYNESS_PER_TICK));
	}

	@Test
	public void shouldHaveBoredom10() {
		int boredom = 10;
		Pet underTest = new RoboticDog("", "", boredom, 0);
		int returnedBoredom = underTest.getBoredom();
		assertThat(returnedBoredom, is(10));
	}

	@Test
	public void shouldHaveBoredom100() {
		int boredom = 100;
		Pet underTest = new RoboticDog("", "", boredom, 0);
		int returnedBoredom = underTest.getBoredom();
		assertThat(returnedBoredom, is(100));
	}

	@Test
	public void shouldHaveNameAlan() {
		Pet underTest = new RoboticDog("Alan", "", 0, 0);
		String name = underTest.getName();
		assertThat(name, is("Alan"));
	}

	@Test
	public void shouldHaveDescriptionGoodBoy() {
		Pet underTest = new RoboticDog("", "Good boy", 0, 0);
		String description = underTest.getDescription();
		assertThat(description, is("Good boy"));
	}

	@Test
	public void shouldHavePlayReduceBoredom() {
		Pet underTest = new RoboticDog("", "", 100, 0);
		underTest.play();
		int boredom = underTest.getBoredom();
		assertThat(boredom, is(0));
	}

	@Test
	public void shouldHaveDefaultHealth() {
		Pet underTest = new RoboticDog("", "");
		int health = underTest.getHealth();
		assertThat(health, is(DEFAULT_HEALTH));
	}

	@Test
	public void shouldHaveDefaultBoredom() {
		Pet underTest = new RoboticDog("", "");
		int boredom = underTest.getBoredom();
		assertThat(boredom, is(DEFAULT_BOREDOM));
	}

	@Test
	public void shouldHaveDefaultDryness() {
		Robotic underTest = new RoboticDog("", "");
		int dryness = underTest.getDryness();
		assertThat(dryness, is(DEFAULT_DRYNESS));
	}

	@Test
	public void shouldHaveTickIncreaseBoredom() {
		Pet underTest = new RoboticDog("", "");
		underTest.tick();
		int boredom = underTest.getBoredom();
		assertThat(boredom, is(DEFAULT_DRYNESS + Pet.BOREDOM_PER_TICK));
	}

	@Test
	public void shouldHaveWalkDecreaseBoredom() {
		RoboticDog underTest = new RoboticDog("", "");
		underTest.walk();
		int boredom = underTest.getBoredom();
		assertThat(boredom, is(0));
	}

	@Test
	public void shouldHaveTickDecreaseHealthIfDry120() {
		RoboticDog underTest = new RoboticDog("", "", 0, 120);
		underTest.tick();
		int health = underTest.getHealth();
		assertThat(health, is(80));
	}
	
	@Test
	public void shouldHaveTickDecreaseHealthIfBored() {
		RoboticDog underTest = new RoboticDog("", "", 130, 0);
		underTest.tick();
		int health = underTest.getHealth();
		assertThat(health, is (70));
	}
	
	@Test
	public void shouldHaveTickIncreaseHealthIfNothingsWrong() {
		RoboticDog underTest = new RoboticDog("", "", 100, 100);
		underTest.tick();
		int health = underTest.getHealth();
		assertThat(health, is(100));
	}
}
