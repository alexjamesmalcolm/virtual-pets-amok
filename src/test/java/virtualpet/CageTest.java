package virtualpet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static virtualpet.Cage.DEFAULT_DIRTYNESS;

import org.junit.Test;

public class CageTest {
	
	@Test
	public void shouldHaveDirtynessLevelDefault() {
		Cage underTest = new Cage(DEFAULT_DIRTYNESS);
		int dirtyness = underTest.getDirtyness();
		assertThat(dirtyness,is(DEFAULT_DIRTYNESS));
	}
	
	@Test
	public void shouldHaveDirtynessLevelBe69() {
		Cage underTest = new Cage(69);
		int dirtyness = underTest.getDirtyness();
		assertThat(dirtyness, is(69));
	}
}