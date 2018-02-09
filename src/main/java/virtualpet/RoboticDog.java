package virtualpet;

public class RoboticDog {

	private String name;
	private int dryness;
	private String description;

	public RoboticDog(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public RoboticDog(String name, String description, int dryness, int health) {
		this.dryness = dryness;
	}

	public int getHealth() {
		// TODO Auto-generated method stub
		return 100;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getDryness() {
		return dryness;
	}

	public void oil() {
		dryness = 0;
	}

}
