package virtualpet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class OrganicCatTest {

	private LitterBox litterBox;

	@Before
	public void setup() {
		litterBox = new LitterBox();
	}

	@Test
	public void shouldHaveName() {
		OrganicCat underTest = new OrganicCat("Joey", "Cool", litterBox);
		String name = underTest.getName();
		assertThat(name, is("Joey"));
	}

	@Test
	public void shouldHaveDescription() {
		OrganicCat underTest = new OrganicCat("Joey", "Cool", litterBox);
		String description = underTest.getDescription();
		assertThat(description, is("Cool"));
	}

	@Test
	public void shouldHaveBoredom() {
		OrganicCat underTest = new OrganicCat("Joey", "Cool", 10, 20, 30, 40, litterBox);
		int boredom = underTest.getBoredom();
		assertThat(boredom, is(10));
	}

	@Test
	public void shouldHaveCustomName() {
		OrganicCat underTest = new OrganicCat("Joey", "Cool", 10, 20, 30, 40, litterBox);
		String name = underTest.getName();
		assertThat(name, is("Joey"));
	}

	@Test
	public void shouldHaveHunger() {
		OrganicCat underTest = new OrganicCat("Joey", "Cool", 10, 20, 30, 40, litterBox);
		int hunger = underTest.getHunger();
		assertThat(hunger, is(20));
	}

	@Test
	public void shouldHaveThirst() {
		OrganicCat underTest = new OrganicCat("Joey", "Cool", 10, 20, 30, 40, litterBox);
		int thirst = underTest.getThirst();
		assertThat(thirst, is(30));
	}

	@Test
	public void shouldHaveWaste() {
		OrganicCat underTest = new OrganicCat("Joey", "Cool", 10, 20, 30, 40, litterBox);
		int waste = underTest.getWaste();
		assertThat(waste, is(40));
	}

	@Test
	public void shouldHaveLitterBox() {
		OrganicCat underTest = new OrganicCat("Joey", "Cool", litterBox);
		LitterBox check = underTest.getLitterBox();
		assertThat(check instanceof LitterBox, is(true));
	}

	@Test
	public void shouldCleanLitterBox() {
		OrganicCat underTest = new OrganicCat("Joey", "Cool", litterBox);
		underTest.cleanLitterBox();
		int dirtyness = underTest.getDirtyness();
		assertThat(dirtyness, is(0));
	}
}
