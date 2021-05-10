package houseComponets.rooms;

import crimeScene.Blood;
import houseComponets.decoration.Painting;
import houseComponets.electronicDevices.Laptop;
import houseComponets.furniture.Desk;
import houseComponets.furniture.Library;
import houseComponets.furniture.Sofa;
import stationery.*;

public class Office extends Room {
	private Sofa sofa;
	private Desk desk;
	private Painting painting;
	private Library library;
	private Blood poolBlood;
	private Blood gravityDrops;
	
	
	public Office(int nWindows, int nDoors, String color) {
		super(nWindows,nDoors,color);
		this.sofa = new Sofa("Sofa", "Chesterfield", "red");
		this.desk = new Desk("Desk","Computer Desk", "black");
		this.painting = new Painting();
		this.library = new Library("Library", "Brown", 50);
		this.poolBlood = new Blood("Pool of Blood", "A+", "John");
		this.gravityDrops = new Blood("Gravity Drops of Blood", "0+", "Unknown");
		
		desk.addBook(new Book());
		desk.addDocument(
						  new Document("Article", "Statistical Crime Analysis For Long River", 
								  	   "Fear has been clouded the Long River since the crime insidents,\n"+
								  	   "especially drug dealing have been increased dramatically")
						);
		
		desk.addElectricalDevice(new Laptop("System1761", "16G", "1T", "Log In With Password", "Windows", "John"));
	}
	
	public void inspectRoom() {
		System.out.println("[*]Inspecting Room");
		System.out.println("\tWindows: " + super.nWindows);
		System.out.println("\tDoors: " + super.nDoors);
		System.out.println("\tRoom Color: " + super.color);
		System.out.println("[*] Objects");
		System.out.println("\tSofa");
		System.out.println("\tDesk");
		System.out.println("\tPainting");
		System.out.println("\tLibrary");
		System.out.println("\tPool of Blood");
		System.out.println("\tGravity Drops of Blood");
	}
	
	public String whosDNAIsInPoolOfBlood() {
		return poolBlood.getDna();
	}
	
	public String whosDNAInGravityDrops() {
		return gravityDrops.getDna();
	}
	
	public Sofa interactWithSofa() {
		return sofa;
	}
	
	public Desk interactWithDesk() {
		return desk;
	}
	
	public Painting interactWithPainting() {
		return painting;
	}
	
	public Library interactWithLibrary() {
		return library;
	}
	
	public Blood interactWithPoolOfBlood() {
		return poolBlood;
	}
	
	public Blood interactWithGravityDrops() {
		return gravityDrops;
	}
	
	public String toString() {
		return "Office";
	}
}
