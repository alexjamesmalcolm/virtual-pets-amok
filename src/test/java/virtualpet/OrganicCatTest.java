package virtualpet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static virtualpet.Box.DEFAULT_DIRTYNESS;

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
		OrganicCat underTest = new OrganicCat("Joey", "Cool", litterBox, 10, 20, 30, 40);
		int boredom = underTest.getBoredom();
		assertThat(boredom, is(10));
	}

	@Test
	public void shouldHaveCustomName() {
		OrganicCat underTest = new OrganicCat("Joey", "Cool", litterBox, 10, 20, 30, 40);
		String name = underTest.getName();
		assertThat(name, is("Joey"));
	}

	@Test
	public void shouldHaveHunger() {
		OrganicCat underTest = new OrganicCat("Joey", "Cool", litterBox, 10, 20, 30, 40);
		int hunger = underTest.getHunger();
		assertThat(hunger, is(20));
	}

	@Test
	public void shouldHaveThirst() {
		OrganicCat underTest = new OrganicCat("Joey", "Cool", litterBox, 10, 20, 30, 40);
		int thirst = underTest.getThirst();
		assertThat(thirst, is(30));
	}

	@Test
	public void shouldHaveWaste() {
		OrganicCat underTest = new OrganicCat("Joey", "Cool", litterBox, 10, 20, 30, 40);
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

	@Test
	public void shouldHaveDefaultDirtyness() {
		OrganicCat underTest = new OrganicCat("Joey", "Cool", litterBox);
		int dirtyness = underTest.getDirtyness();
		assertThat(dirtyness, is(DEFAULT_DIRTYNESS));
	}

	@Test
	public void shouldUseLitterBox120() {
		OrganicCat underTest = new OrganicCat("Joey", "Cool", litterBox, 0, 0, 0, 120);
		underTest.useLitterBox();
		int dirtyness = underTest.getDirtyness();
		assertThat(dirtyness, is(DEFAULT_DIRTYNESS + 120));
	}

	@Test
	public void shouldUseLitterBox130() {
		OrganicCat underTest = new OrganicCat("Joey", "Cool", litterBox, 0, 0, 0, 130);
		underTest.useLitterBox();
		int dirtyness = underTest.getDirtyness();
		assertThat(dirtyness, is(DEFAULT_DIRTYNESS + 130));
	}

	@Test
	public void shouldHaveTickUseLitterBox70() {
		OrganicCat underTest = new OrganicCat("Joey", "Cool", litterBox, 0, 0, 0, 70);
		underTest.tick();
		int dirtyness = underTest.getDirtyness();
		assertThat(dirtyness, is(DEFAULT_DIRTYNESS + 70));
	}

	@Test
	public void shouldHaveTickNotUseLitterBox69() {
		OrganicCat underTest = new OrganicCat("Joey", "Cool", litterBox, 0, 0, 0, 69);
		underTest.tick();
		int dirtyness = underTest.getDirtyness();
		assertThat(dirtyness, is(DEFAULT_DIRTYNESS));
	}

	@Test
	public void shouldBeDeadIfHealhIsZero() {
		OrganicCat underTest = new OrganicCat("Joey", "Cool", litterBox, 200, 0, 0, 0);
		underTest.tick();
		boolean status = underTest.isAlive();
		assertThat(status, is(false));
	}

	@Test
	public void shouldBeAliveIfHealthIsOne() {
		OrganicCat underTest = new OrganicCat("Joey", "Cool", litterBox, 199, 0, 0, 0);
		underTest.tick();
		boolean status = underTest.isAlive();
		assertThat(status, is(true));
	}

	@Test
	public void shouldHaveHealth100() {
		OrganicCat underTest = new OrganicCat("Joey", "Cool", litterBox);
		int health = underTest.getHealth();
		assertThat(health, is(100));
	}
	
	@Test
	public void usingLitterBoxShouldSetWasteToZero() {
		OrganicCat underTest = new OrganicCat("Joey","",litterBox,0,0,0,90);
		underTest.useLitterBox();
		int waste = underTest.getWaste();
		assertThat(waste, is(0));
	}

}
