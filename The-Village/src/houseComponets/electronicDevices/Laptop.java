package houseComponets.electronicDevices;
import java.util.ArrayList;
import java.util.Scanner;

public class Laptop extends ElectricalDevice {
	
	private String brand; // The brand of the laptop like "Dell"
	private String ramSize; // The size of the RAM
	private String hardDriveSize; // The size of the Hard Drive
	private String securityMechanism; // What kind of mechanism is in place. Such as full disk encryption or just log in password or even none
	private String operatingSystem; // What Operating System does the laptop run?
	private String owner; // Who own's the laptop
	
	private static final String[] SENSITIVEINFO = {"Drug Dealing Incedents and Police Arrests Have Been Increased Dramatically!",
												   "Evedence of Dangerous and Horrific gang on the Streets of This Rather Lovely and Quiet City",
												   "Dead Pet Animal in Front of Businessman. Gang Threatening?",
												   "A Police Officer Dead After Exchange Fire With Gang Members",
												   "Every Gang Members Has a Name or Symbol. None of Them on the Streets! Not famous or Dangerous Underground Gang?"
												  }; // Sensitive Information that strengthen the story
	
	private static final String[] BROWSERHIST = {"Trinity Symbol",
												 "Trinity Gang Symbol",
												 "Tattoo Shops Near Me",
												 "Berreta",
												 "Glock",
												 "Knives",
												 "Self-Defence Moves",
												 "Gang Member Stories",
												 "Undercover Techniques & Psychology",
												 "Poker Face"
												}; // Browser History Information that strengthen the story
	
	private boolean hacked; // A boolean variable that depicts if the laptop was hacked. That is the user upgraded his privileges to ROOT or SYSTEM
	private boolean browserHistoryCleared; // A boolean variable that shows if the browser history has been deleted by someone
	private boolean logOnto; // A boolean variable in which the value true show that the user is connect to the laptop
	private static final String PASSWD = "1337"; // I give the player the chance of guessing correct the password
	private boolean utilmanHack; // one of the ways that a hacker can use in he has physical access to a windows machine
	
	/*	@Constructor: Parameterized
	 * 	@super Constructor: A laptop is an electrical device in subcategory "laptop". So we use the argument "Laptop".
	 * 	@Description: Just an initialization of the instance variables with the proper values
	 */
	public Laptop(String brand, String ram, String hardDrive, String secMechanism, String os, String owner){
		super("Electronic Device", "Laptop");
		this.brand = brand;
		ramSize = ram;
		hardDriveSize = hardDrive;
		securityMechanism = secMechanism;
		operatingSystem = os;
		hacked = false;
		browserHistoryCleared = true;
		logOnto = false;
		utilmanHack = false;
		this.owner = owner;
	}
	
	/*	@Constructor: Empty
	 * 	@Description: Giving default values to instance variables. Mostly used for debugging purposes
	 */
	public Laptop(){
		super();
		brand = "N/A";
		ramSize = "N/A";
		hardDriveSize = "N/A";
		securityMechanism = "none";
		operatingSystem = "N/A";
		hacked = false;
		browserHistoryCleared = true;
		logOnto = false;
		utilmanHack = false;
	}
	
	
	/*
	 * 	@Name: getSystemInfo
	 * 	@Parameters: empty
	 * 	@Return Type: void
	 * 	@Access Modifier: public
	 * 	@Description: The method displays the system details of the laptop object
	 */
	public void getSystemInfo() {
		if(logOnto) {
			System.out.println("[*] Brand: " + brand);
			System.out.println("[*] RAM: " + ramSize);
			System.out.println("[*] Hard Drive: " + hardDriveSize);
			System.out.println("[*] Security Mechanism: " + securityMechanism);
			System.out.println("[*] OS: " + operatingSystem);
			return;
		}
		System.out.println("[!] You are not connected to the computer");
	}
	
	/*
	 * @Name: checkIfThereIsNotASecurityMechanism
	 * @Parameters: empty
	 * @Return Type: void
	 * @Access Modifier: private
	 * @Description: This is an auxiliary private method that is being used in the useComputer method 
	 */
	private void checkIfThereIsNotASecurityMechanism() {
		if(securityMechanism == "none") {
			System.out.println("[*] Welcome Back");
			return;
		}
		System.out.println("[*] Security Mechanism: " + securityMechanism);
		System.out.println("[!] You can't access the machine");
	}
	
	/*
	 * @Name: hackIntoComputer
	 * @Parameters: empty
	 * @Return Type: void
	 * @Access Modifier: public
	 * @Description: This method consist the first line of defense of the laptop.
	 *               If there isn't a security mechanism in place, then the "user" can use the laptop.
	 *               Otherwise, the terminal prompts him/her to guess the password.
	 *               Of course there are mechanisms in place which the user can use to bypass that mechanism
	 *               In addition, if the utilman exploit is in place then the user bypass the security Mechanism
	 */
	public void hackIntoComputer() {
		switch(operatingSystem) {
			case "Linux":
				checkIfThereIsNotASecurityMechanism();
				break;
			
			case "Windows":
				checkIfThereIsNotASecurityMechanism();
				if(utilmanHack) {
					System.out.println("[*] Pressing [Windows key + u] ...");
					System.out.println("C:\\Windows\\system32> whoami");
					System.out.println("NT AUTHORITY\\SYSTEM");
					System.out.println("[*] Mounting USB Drive ...");
					System.out.println("[*] Executing mimikatz ...");
					System.out.println("mimikatz # sekurlsa::logonPasswords");
					System.out.println("[+] Password retrieved SUCCESSFULLY");
					logOnto = true;
					hacked=true;
					return;
				}
				break;
			default:
				System.out.println("[!] I don't recognize that operating system");
		}
	}
	
	/*
	 * 	@Name: rebootAndUseLiveUSB
	 * 	@Parameters: empty
	 * 	@Return Type: void
	 * 	@Access Modifier: public
	 * 	@Description: This method is used to bypass the security mechanism in Linux and
	 *                plant the seed which will help us to bypass the security mechanism
	 *                in Windows in second phase
	 */
	public void rebootAndUseLiveUSB() {
		if(operatingSystem == "Linux") {
			System.out.println("[*] Using Run Level 1 ...");
			System.out.println("# whoami");
			System.out.println("root");
			System.out.println("# passwd root");
			System.out.println("[*] Changing root's password ...");
			System.out.println("[*] Password changed SUCCESSFULLY");
			logOnto = true;
			hacked = true;
			System.out.println("[*] Forcing Rebooting ...");
		}
		else if(operatingSystem == "Windows") {
			System.out.println("[*] Mounting Windows Filesystem to " + "/mnt" + "...");
			System.out.println("[*] Navigating to Windows/System32 ...");
			System.out.println("[*] Renaming file \"utilman.exe\" -> \"utilman.old\" ...");
			System.out.println("[*] Copying file \"cmd.exe\" -> \"utilman.exe\" ...");
			System.out.println("[*] Umounting Windows Filesystem ...");
			System.out.println("[*] Rebooting ...");
			utilmanHack = true;
		}
		else {
			System.out.println("[!] I don't recognize that Operating System. Exiting ...");
			return;
		}
	}
	
	/*
	 * @Name: guessPassword
	 * @Parameters: empty
	 * @Return Type: void
	 * @Acess Modifier: public
	 * @Description: This method ask the user of the laptop to guess the password
	 * 				 giving him/her three chances. Otherwise, a time-out mechanism
	 * 				 will be activated
	 */
	public boolean guessPassword(Scanner terminal) {
		String userAns;
		int guessTimes = 3;
		
		System.out.println("[>] Username: John");
		while(guessTimes != 0) {
			System.out.print("[>] Password: ");
			userAns = terminal.nextLine().strip();
			if(userAns.equals(PASSWD)) {
				System.out.println("[+] Password CORRECT");
				logOnto = true;
				System.out.println("[*] ACCESS GRANDED");
				return true;
			}
			System.out.println("[!] Password Incorrect");
			guessTimes--;
		}
		System.out.println("[!] Try again in 10 minutes"); // I should keep this mechanism time-driven but KISS
		System.out.println("[!] ACCESS DENIED");
		return false;
	}
	
	/*
	 * @Name: linuxPrivilegeEscalation
	 * @Parameters: empty
	 * @Return Type: void
	 * @Access Modifier: public
	 * @Description: This method is used if the user guess the password correctly in order to upgrade his/her privilege from user to ROOT
	 */
	public void linuxPrivilegeEscalation() {
		if(operatingSystem == "Linux") {
			System.out.println("[*] Searching for Vulnerabilities...");
			System.out.println("[+] Sudo Vulnerability CVE-2021-3156 FOUND");
			System.out.println("[*] Constructing shellcode...");
			System.out.println("[*] Executing exploit...");
			System.out.println("[+] Privilege Escalation completed SUCCESSFULLY");
			System.out.println("# whoami");
			System.out.println("root");
			hacked = true;
			return;
		}
		System.out.println("[!] You can't use it in a system not running Linux");
	}
	
	/*
	 * 	@Name: windowsPrivilegeEscalation
	 * 	@Parameters: empty
	 * 	@Return Type: void
	 * 	@Access Modifier: public
	 * 	@Description: This method is used if the user guess the password correctly in order to upgrade his/her privilege from user to SYSTEM
	 */
	public void windowsPrivilegeEscalation() {
		if(operatingSystem == "Windows"){
			System.out.println("[*] Searching for Unquoted Path vulnerability ... ");
			System.out.println("PS C:\\Users\\user> Invoke-AllChecks");
			System.out.println("[+] Service FOUND");
			System.out.println("[*] Creating shellcode ...");
			System.out.println("[*] Copying shellcode to directory ...");
			System.out.println("[*] Restarting service ...");
			System.out.println("[+] NT AUTHORITY\\SYSTEM");
			hacked=true;
			return;
		}
		System.out.println("[!] You can't use it in a system not running Windows");
	}
	
	/*
	 * 	@Name: retrieveSensitiveInformation
	 * 	@Parameters: empty
	 * 	@Return Type: void
	 * 	@Access Modifier: public
	 * 	@Description: This method displays sensitive information from the laptop which is helpful for the progression of the story, if and only if the laptop is hacked
	 */
	public void retrieveSensitiveInformation() {
		if(hacked) {
			System.out.println("[*] Retrieving Sensitive Information...");
			System.out.println("[*] Sensitive Information was Retrieved SUCCESSFULLY");
			for(String si : SENSITIVEINFO) {
				System.out.println("\t[>] " + si);			
			}
			return;
		}
		System.out.println("[!] You don't have the proper permision to access that kind of information...");
		System.out.println("[!] The insident will be logged");
	}
	
	/*
	 * 	@Name: performRecoveryOfTheHardDrive
	 * 	@Parameters: empty
	 * 	@Return Type: void
	 * 	@Access Modifier: public
	 * 	@Description: In a computer nothing is really deleted. So the user performs a recovery on the hard drive
	 */
	public void performRecoveryOfTheHardDrive() {
		System.out.println("[*] Performing Automatic Recovery Of The Disk: " + "/dev/sda");
		System.out.println("[*] Tool: " + "TestDisk");
		System.out.println("[+] Any deleted file was recovered and stored on location: " + "~/.recovery/files/");
		browserHistoryCleared = false;
	}
	
	/*
	 * 	@Name: retrieveBrowserInformation
	 * 	@Parameters: empty
	 * 	@Return Type: void
	 * 	@Access Modifier: public
	 * 	@Description: This method retrieves browser history which is helpful for the progression of the strory, if and only if the user recovered the deleted history 
	 */
	public void retrieveBrowserInformation() {
		if(browserHistoryCleared) {
			System.out.println("[*] Browser history was cleared ...");
			return;
		}
		System.out.println("[*] Retrieving Browser History ...");
		System.out.println("[+] Browser History Retrieved SUCCESSFULLY");
		System.out.println("[*] Displaying History ...");
		for(String bh : BROWSERHIST) {
			System.out.println("\t[>] " + bh);
		}
	}
	
	/*
	 * 	@Name: connectToLaptop
	 * 	@Parameters: empty
	 * 	@Return Type: void
	 * 	@Access Modifier: public
	 * 	@Description: This method let the user to connect to the laptop
	 */
	public void connectToLaptop() {
		switch(operatingSystem) {
		case "Windows":
			if(logOnto || (securityMechanism.equals("none"))) {
				System.out.println("[*] Welcome Back ");
				if(hacked) {
					System.out.println("C:\\Users\\user> whoami");
					System.out.println("NT AUTHORITY\\SYSTEM");
				}
				System.out.println("C:\\Users\\user> whoami");
				System.out.println("desktop-cksfded\\user");
				return;
			}
			System.out.println("[!] You don't have access to the computer");
			break;
		case "Linux":
			if(logOnto || (securityMechanism.equals("none"))) {
				System.out.println("[*] Welcome Back ");
				if(hacked) {
					System.out.println("# whoami");
					System.out.println("root");
					return;
				}
				System.out.println("$ whoami");
				System.out.println("user");
			}
			System.out.println("[!] You don't have access to the computer");
			break;
		default:
			System.out.println("[!] I don't recognize this operating system");
		}
	}
	
	/*
	 * 	@Name: saveSensitiveInformation
	 * 	@Parameters: ArrayList<String> usb
	 * 	@Return Type: void
	 * 	@Access Modifier: public
	 * 	@Description: This method save the contents of the SENSITIVEINFO String array to player's USB
	 *                The purpose is the player to keep an inventory of important clues without the need
	 *                to return the that house or place to read them again
	 */
	public int saveBrowserHistory(ArrayList<String> usb) {
		if(hacked) {
			if(!browserHistoryCleared) {
				for(String info : BROWSERHIST)
					usb.add(owner + " - " + "BH" + " - " + info);
				return 0;
			}
			else {
				System.out.println("[*] Browser history cleared");
				return 1;
			}
		}
		System.out.println("[!] You can't access that information");
		return 2;
	}
	
	/*
	 * 	@Name: saveBrowserHistory
	 * 	@Parameters: ArrayList<String> usb
	 * 	@Return Type: void
	 * 	@Access Modifier: public
	 * 	@Description: This method save the contents of the BROWSERHIST String array to player's USB
	 *                The purpose is the player to keep an inventory of important clues without the need
	 *                to return the that house or place to read them again
	 */
	public boolean saveSensitiveInformation(ArrayList<String> usb) {
		if(hacked)
		{
			for(String history: SENSITIVEINFO) 
				usb.add(owner + " - " + "SI" + " - " + history);
			return true;
		}
		System.out.println("[!] You can't access that information");
		return false;
	}
	
	public String getOS() {
		return operatingSystem;
	}
	
	public String toString() {
		return "Laptop";
	}
}
