package houseComponets.decoration;

public class Painting {
	private String name;
	private String painter;
	private String smallDescription;
	
	public Painting(String name, String painter, String smallDescription) {
		this.name = name;
		this.painter = painter;
		this.smallDescription = smallDescription;
	}
	
	public Painting() {
		name = "Stairy Night";
		painter = "Van Gogh";
		smallDescription = "Stairy Night is an oil on canvas painting by Dutch Post-Impressionist painter\n" +
						   "Vincent van Gogh. Painted in June 1889, it depicts the view from the east-facing\n"+
						   "windows of his asylum room at Saint-Remy-de-Provence, just before sunrise, with\n"+
						   "the addition of an imaginary village";
	}
	
	public void inspectPainting() {
		System.out.println("[*] Inspecting Painting");
		System.out.println("\tName: " + name);
		System.out.println("\tPainter: " + painter);
		System.out.println("\tDescription: " + smallDescription);
	}
	
	public String toString() {
		return "Painting";
	}
}
