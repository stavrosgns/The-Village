package houseComponets.rooms;

public class RoomObject {
	protected String category;
	
	public RoomObject(String category){
		this.category = category;
	}
	
	public RoomObject(){
		category = "N/A";
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public String toString() {
		return "Room Object";
	}
}
