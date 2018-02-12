package virtualpet;

public abstract class Box {

	public static final int DEFAULT_DIRTYNESS = 10;
	int dirtyness;

	public int getDirtyness() {
		return dirtyness;
	}

	public void clean() {
		dirtyness = 0;
	}

	public void addWaste(int waste) {
		dirtyness += waste;
	}

}