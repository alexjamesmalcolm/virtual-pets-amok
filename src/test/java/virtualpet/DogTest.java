package virtualpet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DogTest {
	
	@Test
	public void shouldHaveNameJoey() {
		Dog underTest = new Dog("Joey", "");
		String name = underTest.getName();
		assertThat(name, is("Joey"));
	}
	
	@Test
	public void shouldHaveNamePhil() {
		Dog underTest = new Dog("Phil", "");
		String name = underTest.getName();
		assertThat(name, is("Phil"));
	}
	
	@Test
	public void shouldHaveDescriptionStinky() {
		Dog underTest = new Dog("", "Stinky");
		String description = underTest.getDescription();
		assertThat(description, is("Stinky"));
	}
}
