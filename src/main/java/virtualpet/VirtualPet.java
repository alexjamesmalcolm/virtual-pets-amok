package virtualpet;

public abstract class VirtualPet {
	
	private String name;
	private String description;
	
	public VirtualPet(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

}
