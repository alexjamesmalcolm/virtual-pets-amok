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
}
