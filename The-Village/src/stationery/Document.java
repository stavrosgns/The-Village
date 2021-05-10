package stationery;

/*
 * 	@Class Name: Documents
 * 	@Constructors: 2
 * 		> Parameterized Constructor: Initializes the instance variables with the proper arguments provided to parameters
 * 		> Simple Constructor: Sets some default values
 * 
 * 	@Description: Despite the fact that the class itself is self-explanatory,
 * 				  this class is not important for the progress of game so
 * 				  I keep it simple
 * 
 * 	@Version: 1 (incremental by change)
 * 	@What's New? :
 */
public class Document {
	private String category;
	private String title;
	private String bodyText;
	
	public Document(String category, String title, String bodyText) {
		this.category = category;
		this.title = title;
		this.bodyText = bodyText;
	}
	
	public Document() {
		category = "N/A";
		title = "N/A";
		bodyText = "N/A";
	}

	public void inspectDocument() {
		System.out.println("[*] Document Details");
		System.out.println("\tCategory: " + category);
		System.out.println("\tTitle: " + title);
		System.out.println("\tBody: " + bodyText);
	}
	
	public String getTitle() {
		return title;
	}
	
	public String toString() {
		return "Document";
	}
}
