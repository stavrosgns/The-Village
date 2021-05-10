package stationery;
/*	@Class Name: Book
 * 	@Constructors: 2
 * 	@Parameterized Constructor Description: This constructor initialize the instance variables
 * 											with the proper arguments that are provided to parameters
 * 
 * 	@Simple Constructor: This constructors uses default arguments for the instance variables
 * 	@Description: Despite the fact that the class is self-explanatory, this class is not important for the progress
 * 				  of the story so I keep it simple
 * 
 * 	@Version: 1 (incremental by change)
 * 	@What Changed? :
 * 
 */
public class Book {
	private String title;
	private String author;
	private String category;
	private String subcategory;
	private int pages;
	
	public Book(String title, String author, String category, String subcategory, int pages) {
		this.title = title;
		this.author = author;
		this.category = category;
		this.subcategory = subcategory;
		this.pages = pages;
	}
	
	public Book() {
		title = "Thinking Fast and Slow";
		author = "Daniel Kahneman";
		category = "Psychology";
		subcategory = "Cognitive Psychology";
		pages = 504;
	}

	public void inspectBook() {
		System.out.println("[*] Book Details");
		System.out.println("\tTitle: " + title);
		System.out.println("\tAuthor: " + author);
		System.out.println("\tCategory: " + category);
		System.out.println("\tSubcategory: " + subcategory);
		System.out.println("\tPages: " + pages);
	}
	
	public String getTitle() {
		return title;
	}
	
	public String toString() {
		return "Book";
	}
}
