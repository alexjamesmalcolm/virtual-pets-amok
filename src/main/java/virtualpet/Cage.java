package virtualpet;

public class Cage {

	public static final int DEFAULT_DIRTYNESS = 10;
	private int dirtyness;

	public Cage(int dirtyness) {
		this.dirtyness = dirtyness;
	}

	public Cage() {
		this(DEFAULT_DIRTYNESS);
	}

	public int getDirtyness() {
		return dirtyness;
	}

	public void clean() {
		dirtyness = 0;
	}

}
