
public class Narrator {
	/*	@Author: Stavros Gkounis
	 *  @Class_Name: Narrator
	 * 	@Description: The usages of this class, Narrator, is to tell the story of this mini to medium range game to the user in a progressive way 
	 */
	
	// This is a constant variable which includes the introduction of the story
	private final String INTRO = 
			" Welcome stranger, here an interesting story.\n" +
		    " In a village of 10 residents, all of the sudden" +
			" 2 went missing in the last 3 months, two males named Nick and John.\n" +
			" John is a investigative reporter having his own blog and have released some scandals over the time\n" +
			" One of them was the scandal with the Company ABC which tried to cover up the fact it was responsible\n" +
			" for the water poisoning on \"Long River\" as a result of not following the proper protocols in order to save money\n" +
			" On the other hand, Nick is a farmer and is working in a laundry as part-time job\n" +
			" There is nothing to connect these two people what so ever\n" +
			" Or... Maybe I am wrong\n" +
			" Well, It's your job to find it out, isn't it? ... James!" +
			" In the end not such a stranger at all, right?\n";
	
	private final String PS1 = "< Narrator >\n"; // This constant defines a variable named PS1, using the HTML tag notion to define where the Narrator starts telling the story
	private final String PS2 = "< Narrator />\n"; // and where he/she stops
	
	private String nextStory; // This variable holds the story that the narrator is going to tell to user [As simple as that]
	
	//Constructor
	Narrator(){
		this.nextStory = this.INTRO;
	}
	
	/*	@Name: sayIntro
	 * 	@Return Type: String
	 * 	@Access Modifier: public
	 * 	@Description: this method returns the value, that is tells the introduction of the story, of the private constant INTRO
	 */
	public String sayIntro() {
		return this.PS1 + this.INTRO + this.PS2;
	}
	
	/*	@Name: sayNextStory
	 * 	@Return Type: String
	 * 	@Access Modifier: public
	 * 	@Description: This method returns the value of the private variable nextStory if its value is different from that of INTRO constant.
	 * 				  In other words, the narrator proceeds with the story only if there is a progress
	 */
	public String sayNextStory() {
		if(this.nextStory != this.INTRO) {
			return this.PS1 + this.nextStory + this.PS2;
		}
		return this.PS1 + "Nothing new, investigate more" + this.PS2;
	}
	
	/*	@Name: setNextStory
	 * 	@Return Type: void (none)
	 * 	@Access Modifier: public
	 * 	@Description: The method just set the value of the private variable nextStory to the value contained in the parameter story
	 */
	public void setNextStory(String story) {
		this.nextStory = story;
	}
}
