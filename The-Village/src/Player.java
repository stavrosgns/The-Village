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

/*
 * 	@Author: Stavros Gkounis
 * 	@Class Name: Player
 * 	@Constructors: 1
 * 	@Parameterized Constructor: The constructor take the name (String), surname (String), age (int), job (String)
 * 								and initialize the corresponding instance variables. It also initialize the usb
 * 								variable of type ArrayList<String>, the variables interactingObject, currentRoom
 * 								and sets up John's house by calling the setUpJohnHouse method. Lastly it initializes
 * 								the variable houseMap of type ArrayList<Room>
 * 
 * 	@Description: This class is the one of the most important classes in this text-adventure mini-game since the user
 * 				  uses the player to interact with the game.
 * 
 * 	@Version: 1 (incremental)
 * 	@What's New? :
 */
public class Player {
	private String name;
	private String surname;
	private int age;
	private String job;
	private ArrayList<String> usb; // In USB, we are going to save important information [Sensitive Info | Browser History]
	private House johnHouse; // The house that the player is in
	private Object interactingObject; // The object that the player focuses on
	private ArrayList<Room> houseMap; // Important for the player in order to move around the house
	private Room currentRoom; // The player selects one of the rooms
	
	// This array holds the commands that the player can execute. Some of them could be executed under certain circumstances
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
	
	// Player's thoughts that he speaks out loud. Helps the user to type the correct commands
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
	
	// See Parameterized Constructor section
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
	
	/*
	 * 	@Name: showInventory
	 * 	@Return Type: void
	 * 	@Access Modifier: public
	 * 	@Description: This method show the contents of the USB instance variable of type ListArray<String>
	 * 				  If the usb is empty, that's an indication that the player didn't find the important information
	 * 				  which is located on the laptop. Otherwise, that's indicates the end of the game
	 */
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
	
	/*
	 * 	@Name: whereIsMyFocus
	 * 	@Return Type: void
	 * 	@Access Modifier: public
	 * 	@Description: This method provides an auxiliary functionality which informs the user about with what object
	 * 				  he/she is interacting with. [ I didn't use it, though]
	 */
	public void whereIsMyFocus() {
		if(interactingObject != null) {
			System.out.println("[*] You are interacting with object: " + interactingObject.toString());
		}
	}
	
	/*
	 * 	@Name: showCommands
	 * 	@Return Type: void
	 * 	@Access Modifier: private
	 * 	@Description: This method is used internally and informs the user about the available commands
	 */
	private void showCommands() {
		System.out.println("[*] Here Are The Available Commands:");
		for(String command : COMMANDS)
			System.out.println("\t" + command);
	}
	
	/*
	 * 	@Name: lookAround
	 * 	@Return Type: void
	 * 	@Access Modifier: private
	 * 	@Description: This method checks the type of room and type casting to that type accordingly.
	 * 				  Then calls the inspectRoom method to inform the user about the available objects
	 * 				  that he/she can interact with
	 */
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
	
	/*
	 * 	@Name: focusOn
	 * 	@Return Type: void
	 * 	@Access Modifier: public
	 * 	@Description: This method sets the interactingObject instance variable to the object that the user
	 * 				  wants to interact with
	 */
	public void focusOn(Object obj) {
		interactingObject = obj;
	}
	
	/*
	 * 	@Name: commandAndExecute
	 * 	@Return Type: void
	 * 	@Access Modifier: public
	 * 	@Description: This is the most important method in this class because it's the method that will be executed
	 * 				  by the main. Uses a Scanner object to retrieve the command that the user enters.
	 * 
	 * 				  The command "get map" retrieves the rooms of the house.
	 * 				  The command "help" displays the available commands that the user can enter
	 * 				  The command "look around" prints an warning if the user doesn't have the map of the house. Otherwise,
	 * 				  prints the available rooms that the player can go to and asks the user to select a room by number.
	 * 				  Then after the program retrieves the room, it inspects it with the aim to informing the user about
	 * 				  the available objects.
	 * 
	 * 				  The command "focus on" sets the instance variable interactingObject with the help of focusOn method
	 * 				  In addition, it may be confusing that I type casting directly without any validation to Office type.
	 * 				  This is because this is a demo and I knew that I have only one type of room. It's against the good 
	 * 				  practice of keeping a class/method as abstract as possible in order to reuse the code
	 * 
	 * 				  The command "display usb contents" prints the contents of the usb. See showInventory method
	 * 				  The command "inspect" uses the method inspectObject in order to inspect the object that the player
	 * 				  is focused on. See inspectObject for more details
	 */
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
	
	/*
	 * 	@Name: inspectObject
	 * 	@Return Type: void
	 * 	@Access Modifier: private
	 * 	@Description: This method inspects the object that the player is focused on. But in order for the player to
	 * 				  proceed with that action we need to type casting from Object to corresponding type. Using the
	 * 				  override method toString and Java's polymorphism we can type casting to correct roomObject type 
	 */
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

	/*
	 * 	@Name: checkCommandAndShowHint
	 * 	@Return Type: void
	 * 	@Access Modifier: private
	 * 	@Description: This method checks if the user enters the correct command.
	 * 				  It keeps asking the user until he/she gives the correct command
	 */
	private void checkCommandAndShowHint(Scanner terminal, String cmd, String prompt, String hint ){
		do {
			System.out.println(prompt);
			System.out.print("[>]: ");
			cmd = terminal.nextLine().strip().toLowerCase();
		} while(!cmd.equals(hint));
	}

	/*
	 * 	@Name: playerGuessedCorrectly
	 * 	@Return Type: void
	 * 	@Access Modifier: private
	 * 	@Description: This method consists a flow of actions that must be executed in case that the user guesses the
	 * 				  password correctly
	 */
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
	
	/*
	 * 	@Name: saveSensitiveInfoAndBrowserHistory2Usb
	 * 	@Return Type: void
	 * 	@Access Modifier: private
	 * 	@Description: This method saves sensitive information and browser history that was found on
	 * 				  John's laptop to player's usb
	 */
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

	/*
	 *	@Name: hack
	 *	@Return Type: void
	 *	@Access Modifier: private
	 *	@Description: If the operating system of the laptop is Linux we can save sensitive information and
	 *                the browser history because we get access when we used to liveUSB
	 *                
	 *                In case that the operating system is Windows the we just planted the seed that we 
	 *                will help us hack into the computer. If that action is successful then we can
	 *                retrieve the sensitive information and browser history
	 */
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
