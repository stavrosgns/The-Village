package houseComponets.furniture;

public class Sofa extends Furniture {
	
	public Sofa(String type, String name, String color) {
		super("Furniture",type,name,color);
	}
	
	public void inspectSofa() {
		System.out.println("[*] Inspect Sofa");
		System.out.println("\tType: " + super.type);
		System.out.println("\tName: " + super.name);
		System.out.println("\tColor: " + super.color);
	}
	
	public boolean seated() {
		return true;
	}
	
	public boolean standup() {
		if(seated()) return true;
		return false; // You are already standing up
	}
	
	public String toString() {
		return "Sofa";
	}
}
