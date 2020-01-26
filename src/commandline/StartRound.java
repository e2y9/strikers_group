package commandline;

public class StartRound extends StartGame {
	
	
	public StartRound() {
		super();
		welcomeToRound();
		System.out.println(getHuman().getPlayerCards()[0].toString());
	}
	
	
    public Player getHuman() {
    	return human;
    }
    
    public void welcomeToRound() {
    	System.out.printf("%n%nWelcome to a new round!%n");
    }
    



	
}
