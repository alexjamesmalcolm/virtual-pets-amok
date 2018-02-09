package virtualpet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class VirtualPetTest {
	@Test
	public void shouldHaveNameJoey() {
		VirtualPet underTest = new VirtualPet("Joey", "");
		String name = underTest.getName();
		assertThat(name, is("Joey"));
	}

	@Test
	public void shouldHaveNamePhil() {
		VirtualPet underTest = new VirtualPet("Phil", "");
		String name = underTest.getName();
		assertThat(name, is("Phil"));
	}

	@Test
	public void shouldHaveDescriptionStinky() {
		VirtualPet underTest = new VirtualPet("", "Stinky");
		String description = underTest.getDescription();
		assertThat(description, is("Stinky"));
	}

	@Test
	public void shouldHaveDescriptionCool() {
		VirtualPet underTest = new VirtualPet("", "Cool");
		String description = underTest.getDescription();
		assertThat(description, is("Cool"));
	}
}
