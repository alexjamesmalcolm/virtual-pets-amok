package virtualpet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class OrganicCatTest {

	@Test
	public void shouldHaveName() {
		OrganicCat underTest = new OrganicCat("Joey", "Cool");
		String name = underTest.getName();
		assertThat(name, is("Joey"));
	}

	@Test
	public void shouldHaveDescription() {
		OrganicCat underTest = new OrganicCat("Joey", "Cool");
		String description = underTest.getDescription();
		assertThat(description, is("Cool"));
	}

	@Test
	public void shouldHaveBoredom() {
		OrganicCat underTest = new OrganicCat("Joey", "Cool", 10);
		int boredom = underTest.getBoredom();
		assertThat(boredom, is(10));
	}

	@Test
	public void shouldHaveCustomName() {
		OrganicCat underTest = new OrganicCat("Joey", "Cool", 10);
		String name = underTest.getName();
		assertThat(name, is("Joey"));
	}
}
