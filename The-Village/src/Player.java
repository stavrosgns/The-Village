import java.util.ArrayList;

import houseComponets.House;
import houseComponets.decoration.Painting;
import houseComponets.electronicDevices.ElectricalDevice;
import houseComponets.electronicDevices.Laptop;
import houseComponets.furniture.*;
import houseComponets.rooms.*;
import stationery.*;

import java.util.Scanner;

import crimeScene.Blood;

public class Player {
	private String name;
	private String surname;
	private int age;
	private String job;
	private ArrayList<String> usb;
	private House johnHouse;
	private Object interactingObject;
	private ArrayList<Room> houseMap;
	private Room currentRoom;
	private static final String[] COMMANDS = {"inspect",
											  "focus on",
											  "help",
											  "get map",
											  "look around",
											  "hack the laptop",
											  "reboot and use liveUSB",
											  "privilege escalation",
											  "save sensitive information to usb",
											  "perform disk recovery",
											  "save browser history to usb",
											  "display usb contents",
											  "exit"
											  };
	
	private static final String[] PLAYERTHOUGHTS = {
													"Maybe I would be able to guess the password! [type: guess password]",
													"I should escalate my privileges [type: privilege escalation]",
													"Now I should be able to retrieve sensitive information [type: save sensitive info]",
													"I should retrieve the browser history [type: save browser history]",
													"I should try recover the files and try again [type: perform disk recovery]",
													"Now I should be able to retrieve the history [save browser history]",
													"No luck, I should use my hacking skills [type: reboot and use liveusb]",
													"Now, Let's hack into the computer [type: hack into computer]"
												   };
	
	Player(String name, String surname, int age, String job)
	{
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.job = job;
		usb = new ArrayList<String>();
		johnHouse = new House("John","Blue and White", false);
		johnHouse.setUpJohnHouse();
		interactingObject = null;
		currentRoom = null;
		houseMap = new ArrayList<Room>();
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getJob() {
		return job;
	}
	
	public void showInventory() {
		if(usb.size() != 0) {
			System.out.println("[*] Displaying The Contents of USB");
			for(String info : usb)
				System.out.println("\t[+] " + info);
			System.out.println("\nCONGRADULATIONS, you have finished the demo of the mini-game \"The Village\" ");
			System.out.println("[!] Type 'exit' to exit the game");
		}
		else {
			System.out.println("[!] The USB is empty");
			System.out.println("[!] You have many things to do in order to finish the demo version");
		}
	}
	
	public void whereIsMyFocus() {
		if(interactingObject != null) {
			System.out.println("[*] You are interacting with object: " + interactingObject.toString());
		}
	}
	
	private void showCommands() {
		System.out.println("[*] Here Are The Available Commands:");
		for(String command : COMMANDS)
			System.out.println("\t" + command);
	}
	
	private void lookAround(Room room) {
		switch(room.toString()) {
		case "Office":
			Office officeRoom = (Office) room;
			officeRoom.inspectRoom();
			break;
		default:
			System.out.println("[!] This a demo of the text adventure game \"The Village\".\n"+ 
		                            "There aren't more rooms other than the office yet.");
		}
	}
	
	public void focusOn(Object obj) {
		interactingObject = obj;
	}
	
	public void commandAndExecute() {
		System.out.println("{Type 'exit' for exiting}");
		Scanner terminal = new Scanner(System.in);
		String command = "";
		do {
			System.out.print("[>] ");
			command = terminal.nextLine().strip().toLowerCase();
			
			switch(command) {
			case "get map":
				houseMap = johnHouse.mapTheHouse();
				break;
			
			case "help":
				showCommands();
				break;
			
			case "look around":
				if(houseMap.size() == 0) {
					System.out.println("You don't have the map for the house [type:get map]");
					break;
				}
				System.out.println("[*] Select Room By Number");
				int index = -1;
				for(Room rm : houseMap) {
					index++;
					System.out.println("\t" + index + " - " + rm.toString());
				}
				System.out.print("[>>]: ");
				int roomSelection = Integer.parseInt(terminal.nextLine().strip());
				currentRoom = houseMap.get(roomSelection);
				lookAround(currentRoom);
				break;
				
			case "focus on":
				if(currentRoom != null) {
					Office office = (Office) currentRoom;
					System.out.print("[>>] Select object: ");
					String object = terminal.nextLine().strip().toLowerCase();

					switch(object) {
					case "sofa":
						focusOn(office.interactWithSofa());
						break;
					
					case "desk":
						focusOn(office.interactWithDesk());
						break;
					
					case "painting":
						focusOn(office.interactWithPainting());
						break;
						
					case "library":
						focusOn(office.interactWithLibrary());
						break;
						
					case "pool of blood":
						focusOn(office.interactWithPoolOfBlood());
						break;
					
					case "gravity drops of blood":
						focusOn(office.interactWithGravityDrops());
						break;
					
					default:
						System.out.println("[!] There is no " + object + " object in the room");
						break;
					}
				}
				else System.out.println("[!] You don't know what's in the room [type: look around]");
				break;
				
			
			case "inspect":
				inspectObject(terminal);
				break;
			
			case "display usb contents":
				showInventory();
				break;
			}
		} while(!command.equals("exit"));
		terminal.close();
	}
	
	private void inspectObject(Scanner terminal) {
		if(interactingObject != null) {
			switch(interactingObject.toString().toLowerCase()) {
			case "sofa":
				Sofa sf = (Sofa) interactingObject;
				sf.inspectSofa();
				System.out.println("It's better not get comfy, I have work to do");
				break;
				
			case "painting":
				Painting pntg = (Painting) interactingObject;
				pntg.inspectPainting();
				System.out.println("What a masterpiece, one of my favourites");
				break;
				
			case "library":
				Library lbr = (Library) interactingObject;
				lbr.inspectLibrary();
				System.out.println("Well there are definetely lots of book to read");
				break;
				
			case "blood":
				Blood blood = (Blood) interactingObject;
				String pattern = blood.getPattern().toLowerCase();
				if(pattern.equals("pool of blood")) {
					System.out.println("That's not good at all. Who's blood is that?");
					System.out.println("Analyzing blood...");
					System.out.println("\tPattern: " + blood.getPattern());
					System.out.println("\tDNA: " + blood.getDna());
					System.out.println("John's DNA? Hope he is alive");
				}
				else if(pattern.equals("gravity drops of blood")) {
					System.out.println("A second blood source?");
					System.out.println("Analyzing blood...");
					System.out.println("\tPattern: " + blood.getPattern());
					System.out.println("\tDNA: " + blood.getDna());
					System.out.println("Hmm Unknown... The potential victor is not from this place because\n" + 
					                   "later this evening I perform a DNA swab to the residents of this village");
				}
				break;
				
			
			case "desk":
				Desk dsk = (Desk) interactingObject;
				dsk.inspectDesk();
				System.out.println("\nInteresting... I should inspect the desk further");
				ArrayList<Book> bks = dsk.getBooks();
				ArrayList<ElectricalDevice> eldv = dsk.getElectricalDevices();
				ArrayList<Document> dcmt = dsk.getDocuments();
				
				System.out.println("\nInspecting the book");
				bks.get(0).inspectBook();
				System.out.println("Nothing interesting here\n");
				
				System.out.println("\nInspecting the documents");
				dcmt.get(0).inspectDocument();
				System.out.println("Wasn't as helpful as I expected");
				
				System.out.println("\nHopefully the Laptop will yield the information I am looking for...It must...");
				Laptop lap = (Laptop) eldv.get(0);
				lap.connectToLaptop();
				System.out.println("\nGrrr nice... now I have to hack into the computer");
				
				String cmd ="";
				
				checkCommandAndShowHint(terminal, cmd, PLAYERTHOUGHTS[0], "guess password");
				
				if(lap.guessPassword(terminal)) playerGuessedCorrectly(terminal, cmd, lap);
				else { // rebooting and hacking
					checkCommandAndShowHint(terminal, cmd, PLAYERTHOUGHTS[6], "reboot and use liveusb");
					lap.rebootAndUseLiveUSB();
					
					hack(terminal, cmd, lap);
				}
				break;
			default:
				System.out.println("You haven't focused on an object");
				break;
			}
		}
		else {
			System.out.println("[!] You are not interacting with an object [type: focus on]");
		}
	}

	private void checkCommandAndShowHint(Scanner terminal, String cmd, String prompt, String hint ){
		do {
			System.out.println(prompt);
			System.out.print("[>]: ");
			cmd = terminal.nextLine().strip().toLowerCase();
		} while(!cmd.equals(hint));
	}

	private void playerGuessedCorrectly(Scanner terminal, String cmd, Laptop lap){
		
		System.out.println("OK, now I have access to the computer as a user");
		checkCommandAndShowHint(terminal, cmd, PLAYERTHOUGHTS[1], "privilege escalation");
					
		if(lap.getOS().equals("Linux")) lap.linuxPrivilegeEscalation();
		else if(lap.getOS().equals("Windows")) lap.windowsPrivilegeEscalation();
		else {
				System.out.println("Unknown Operating System... Exiting");
				return;
		}
					
		checkCommandAndShowHint(terminal, cmd, PLAYERTHOUGHTS[2], "save sensitive info");
		if(lap.saveSensitiveInformation(usb)) System.out.println("[+] I got it!");
		else {
				System.out.println("[!] Something went wrong");
				return;
		}
					
		checkCommandAndShowHint(terminal, cmd, PLAYERTHOUGHTS[3], "save browser history");
		if(lap.saveBrowserHistory(usb) == 1) {
				System.out.println("Someone cleared the history...");
				checkCommandAndShowHint(terminal, cmd, PLAYERTHOUGHTS[4], "perform disk recovery");
				lap.performRecoveryOfTheHardDrive();
						
				checkCommandAndShowHint(terminal, cmd, PLAYERTHOUGHTS[5], "save browser history");
				if(lap.saveBrowserHistory(usb) == 0) System.out.println("[+] I got it!");
				else {
					System.out.println("[!] Something went wrong");
					return;
				}
		}
		else {
				System.out.println("[!] Something went wrong");
				return;
		}
	}
	
	private void saveSensitiveInfoAndBrowserHistory2Usb(Scanner terminal, String cmd, Laptop lap) {
		checkCommandAndShowHint(terminal, cmd, PLAYERTHOUGHTS[2], "save sensitive info");
		if(lap.saveSensitiveInformation(usb)) System.out.println("[+] I got it!");
		else {
			System.out.println("[!] Something went wrong");
			return;
		}
		
		checkCommandAndShowHint(terminal, cmd, PLAYERTHOUGHTS[3], "save browser history");
		if(lap.saveBrowserHistory(usb) == 1) {
			System.out.println("Someone cleared the history...");
			checkCommandAndShowHint(terminal, cmd, PLAYERTHOUGHTS[4], "perform disk recovery");
			lap.performRecoveryOfTheHardDrive();
							
			checkCommandAndShowHint(terminal, cmd, PLAYERTHOUGHTS[5], "save browser history");
			if(lap.saveBrowserHistory(usb) == 0) System.out.println("[+] I got it!");
			else {
				System.out.println("[!] Something Went Wrong");
				return;
			}
		}
		else {
			System.out.println("[!] Something Went Wrong");
			return;
		}
	}

	private void hack(Scanner terminal, String cmd, Laptop lap)
	{
		if(lap.getOS().equals("Linux")) saveSensitiveInfoAndBrowserHistory2Usb(terminal, cmd, lap);
		else if(lap.getOS().equals("Windows")) {
			System.out.println("OK, the utilman functionality is being exploited");
			checkCommandAndShowHint(terminal, cmd, PLAYERTHOUGHTS[7], "hack into computer");
			lap.hackIntoComputer();
			
			saveSensitiveInfoAndBrowserHistory2Usb(terminal, cmd, lap);
		}
		
	}	
}
