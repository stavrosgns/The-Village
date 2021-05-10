package houseComponets.furniture;
import houseComponets.rooms.RoomObject;

public class Furniture extends RoomObject {
	protected String type;
	protected String name;
	protected String color;
	
	public Furniture(String category, String type, String name, String color) {
		super(category);
		this.type = type;
		this.name = name;
		this.color = color;
	}
	
	public Furniture() {
		super("Furniture");
		type = "Seat";
		name = "Armchair";
	}

	public void InspectFurniture() {
		System.out.println("[*] Furniture Details");
		System.out.println("\tType: " + type);
		System.out.println("\tName: " + name);
	}
	
	protected String getType() {
		return this.type;
	}
	
	protected String getName() {
		return this.name;
	}
	
	protected String getColor() {
		return this.color;
	}
	
	public String toString() {
		return "Furniture";
	}
}
