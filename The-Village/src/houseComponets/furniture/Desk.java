package houseComponets.furniture;

import java.util.ArrayList;
import stationery.*;
import houseComponets.electronicDevices.ElectricalDevice;

public class Desk extends Furniture {
	private ArrayList<ElectricalDevice> devices;
	private ArrayList<Book> books;
	private ArrayList<Document> documents;
	
	public Desk(String type, String name, String color) {
		super("Desk", type, name, color);
		devices = new ArrayList<ElectricalDevice>();
		books = new ArrayList<Book>();
		documents = new ArrayList<Document>();
	}
	
	public void addElectricalDevice(ElectricalDevice device) {
		this.devices.add(device);
	}
	
	public void addBook(Book book) {
		this.books.add(book);
	}
	
	public void addDocument(Document document) {
		this.documents.add(document);
	}
	
	private boolean checkIfThereAreElectricalDevices() {
		if(devices.size() > 0 ) return true;
		return false;
	}
	
	private boolean checkIfThereAreBooks() {
		if(books.size() > 0 ) return true;
		return false;
	}
	
	private boolean checkIfThereAreDocuments() {
		if(documents.size() > 0 ) return true;
		return false;
	}
	
	public ArrayList<ElectricalDevice> getElectricalDevices(){
		return devices;
	}
	
	public ArrayList<Document> getDocuments(){
		return documents;
	}
	
	public ArrayList<Book> getBooks(){
		return books;
	}
	
	private void showDevices() {
		for(ElectricalDevice d : devices)
			System.out.println("\t" + d.getSubcategory());
	}
	
	private void showBooks() {
		for(Book b : books)
			System.out.println("\t" + b.getTitle());
	}
	
	private void showDocuments() {
		for(Document d : documents)
			System.out.println("\t" + d.getTitle());
	}

	public void inspectDesk() {
		System.out.println("[*] Desk Inspection");
		System.out.println("\tType: " + getType());
		System.out.println("\tName: " + getName());
		System.out.println("\tColor: "+ getColor());
		System.out.println("[*] Objects On The Desk");
		if(checkIfThereAreElectricalDevices()) showDevices();
		else System.out.println("\t" + "No Electrical Devices On The Desk");
		
		if(checkIfThereAreBooks()) showBooks();
		else System.out.println("\t" + "No Books On The Desk");
		
		if(checkIfThereAreDocuments()) showDocuments();
		else System.out.println("\t" + "No Documents On The Desk");
	}
	
	public String toString() {
		return "Desk";
	}
}
