package houseComponets.rooms;


public class Room {
	protected int nWindows;
	protected int nDoors;
	protected String color;
	
	Room(int nWindows, int nDoors, String color){
		this.nWindows = nWindows;
		this.nDoors = nDoors;
		this.color = color;
	}
	
	Room(){
		this.nWindows = 1;
		this.nDoors = 1;
		this.color = "white";
	}
	
	public String toString() {
		return "Room";
	}
}
