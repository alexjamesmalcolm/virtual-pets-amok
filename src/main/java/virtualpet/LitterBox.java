package virtualpet;

public class LitterBox extends Box {
	
	public LitterBox() {
		this.dirtyness = DEFAULT_DIRTYNESS;
	}
	
	public LitterBox(int dirtyness) {
		this.dirtyness = dirtyness;
	}

}
