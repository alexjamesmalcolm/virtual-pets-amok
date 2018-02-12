package virtualpet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static virtualpet.Box.DEFAULT_DIRTYNESS;

import org.junit.Test;

public class LitterBoxTest {

	@Test
	public void shouldHaveDefaultDirtynessLevel() {
		LitterBox underTest = new LitterBox();
		int dirtyness = underTest.getDirtyness();
		assertThat(dirtyness, is(DEFAULT_DIRTYNESS));
	}

	@Test
	public void shouldHaveDirtynessBe69() {
		LitterBox underTest = new LitterBox(69);
		int dirtyness = underTest.getDirtyness();
		assertThat(dirtyness, is(69));
	}
}
