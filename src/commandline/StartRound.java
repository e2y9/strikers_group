package commandline;

public class StartRound extends StartGame {
	
	public StartRound() {
		super();
		welcomeToRound();
//		System.out.println() print current chooser for testing
		System.out.println(getHuman().displayCurrentCard());
	}
	
	
    public Player getHuman() {
    	return human;
    }
    
    public void welcomeToRound() {
    	System.out.printf("%n%nWelcome to a new round!%n");
    }
    


	
}
