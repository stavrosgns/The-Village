package houseComponets.furniture;

public class Library extends Furniture {
	
	private int size;
	
	public Library(String type, String color, int size) {
		super("Library", type, "Library", color);
		this.size = size;
	}
	
	public void inspectLibrary() {
		System.out.println("[*] Inspecting Library");
		System.out.println("\tType: " + type);
		System.out.println("\tColor: " + color);
		System.out.println("\tThis library can store " + size + " books");
	}
	
	public String toString() {
		return "Library";
	}
}
