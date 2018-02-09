package virtualpet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RoboticDogTest {
	
	@Test
	public void shouldHaveNameJoey() {
		RoboticDog underTest = new RoboticDog();
		String name = underTest.getName();
		assertThat(name, is("Joey"));
	}
}
