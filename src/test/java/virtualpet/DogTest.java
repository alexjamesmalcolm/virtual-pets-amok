package virtualpet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DogTest {
	
	@Test
	public void shouldHaveNameJoey() {
		Dog underTest = new Dog("Joey");
		String name = underTest.getName();
		assertThat(name, is("Joey"));
	}
}
