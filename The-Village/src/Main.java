public class Main {
	
	public static void main(String[] args)
	{
		Narrator nrtr = new Narrator();
		System.out.println(nrtr.sayIntro());
		
		Player plyr = new Player("James", "Brown", 24, "P.I");
		plyr.commandAndExecute();
		
	}
}
