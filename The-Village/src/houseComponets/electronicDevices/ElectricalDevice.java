package houseComponets.electronicDevices;

import houseComponets.rooms.RoomObject;

public class ElectricalDevice extends RoomObject {
	protected final String POWERSUPPLY = "Electricity";
	protected String subcategory;
	
	ElectricalDevice(String category, String subcategory){
		super(category);
		this.subcategory = subcategory;
	}
	
	ElectricalDevice(){
		super();
		this.subcategory="N/A";
	}
	
	public String getSubcategory() {
		return this.subcategory;
	}
	
	public String toString() {
		return "Electrical Device";
	}
}
