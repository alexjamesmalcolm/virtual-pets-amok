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
	public void shouldHaveNamePhil() {
		RoboticDog underTest = new RoboticDog("Phil", "");
		String name = underTest.getName();
		assertThat(name, is("Phil"));
	}
	
	@Test
	public void shouldHaveDescriptionStinky() {
		RoboticDog underTest = new RoboticDog("", "Stinky");
		String description = underTest.getDescription();
		assertThat(description, is("Stinky"));
	}
	
	@Test
	public void shouldHaveDescriptionCool() {
		RoboticDog underTest = new RoboticDog("", "Cool");
		String description = underTest.getDescription();
		assertThat(description, is("Cool"));
	}
}
