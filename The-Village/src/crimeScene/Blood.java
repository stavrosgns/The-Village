package crimeScene;

public class Blood {
	private String pattern;
	private String type;
	private String dna;
	
	public Blood(String pattern, String type, String dna) {
		this.pattern = pattern;
		this.type = type;
		this.dna = dna;
	}
	
	public String getPattern() {
		return pattern;
	}
	
	public String getType() {
		return type;
	}
	
	public String getDna() {
		return dna;
	}
	
	public String toString() {
		return "Blood";
	}
}
