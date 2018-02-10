package virtualpet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static virtualpet.Cage.DEFAULT_DIRTYNESS;

import org.junit.Test;

public class CageTest {
	
	@Test
	public void shouldHaveDirtynessLevelDefault() {
		Box underTest = new Cage();
		int dirtyness = underTest.getDirtyness();
		assertThat(dirtyness,is(DEFAULT_DIRTYNESS));
	}
	
	@Test
	public void shouldHaveDirtynessLevelBe69() {
		Box underTest = new Cage(69);
		int dirtyness = underTest.getDirtyness();
		assertThat(dirtyness, is(69));
	}
	
	@Test
	public void shouldCleanCage() {
		Box underTest = new Cage(69);
		underTest.clean();
		int dirtyness = underTest.getDirtyness();
		assertThat(dirtyness, is(0));
	}
	
}
