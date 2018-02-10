package virtualpet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RoboticCatTest {
	
	@Test
	public void shouldHaveRoboticCatExtendPet() {
		RoboticCat underTest = new RoboticCat("Joey", "");
		String name = underTest.getName();
		assertThat(name, is("Joey"));
	}
	
	@Test
	public void shouldHaveDescription() {
		RoboticCat underTest = new RoboticCat("Joey", "Cool");
		String description = underTest.getDescription();
		assertThat(description, is("Cool"));
	}
}
