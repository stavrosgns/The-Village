package houseComponets;

import java.util.ArrayList;

import houseComponets.rooms.*;

public class House {
	private String owner;
	private String color;
	private boolean garden;
	private ArrayList<Room> rooms;
	
	public House(String owner, String color, boolean garden){
		this.owner = owner;
		this.color = color;
		this.garden = garden;
		rooms = new ArrayList<Room>();
	}
	
	public void setUpJohnHouse() {
		rooms.add(new Office(2,1,"White"));
	}
	
	public String getOwner() {
		return owner;
	}
	
	public String getColor() {
		return color;
	}
	
	public boolean hasGarden() {
		return garden;
	}
	
	public ArrayList<Room> mapTheHouse(){
		return rooms;
	}
	
	public String toString() {
		return "House";
	}
}
