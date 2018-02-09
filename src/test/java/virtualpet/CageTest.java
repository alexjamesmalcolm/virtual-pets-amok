package virtualpet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CageTest {
	
	@Test
	public void shouldHaveDirtynessLevelDefault() {
		Cage underTest = new Cage();
		int cleanliness = underTest.getDirtyness();
		assertThat(cleanliness,is(Cage.DEFAULT_DIRTYNESS));
	}
}
