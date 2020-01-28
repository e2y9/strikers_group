package commandline;
import java.io.FileReader;

/**
 * Top Trumps command line application
 */
public class TopTrumpsCLIApplication {

	/**
	 * This main method is called by TopTrumps.java when the user specifies that they want to run in
	 * command line mode. The contents of args[0] is whether we should write game logs to a file.
 	 * @param args
	 */
	public static void main(String[] args) {

//		boolean writeGameLogsToFile = false; // Should we write game logs to file?
//		
//		// the args[0] if statement is commented-out so the program will run in the eclipse console
//		
////		if (args[0].equalsIgnoreCase("true")) writeGameLogsToFile=true; // Command line selection
//
//		// State
//		boolean userWantsToQuit = false; // flag to check whether the user wants to quit the application
		
		 System.out.print("Welcome to Top Trumps!\n");
//		    // Testing main card deck and player's own decks to prove dealDeck works
//	        Player human = new HumanPlayer();
//	        Player comp1 = new CompPlayer();
//	        Player comp2 = new CompPlayer();
//	        Player comp3 = new CompPlayer();
//	        Player comp4 = new CompPlayer();
//	        Player dealer = new CompPlayer();
//	        Deck deck = new Deck(human, comp1, comp2, comp3, comp4);
		 
		 	// test chooseCategory
		 
		 	StartGame newGame = new StartGame();
		 	// Shuffle deck & Deal deck
		 	newGame.getDeck().shuffleDeck();
		 	newGame.getDeck().dealDeck();
		   
		    // TEST CARDS are in player decks
		 	System.out.println(newGame.getDeck().getHumanCards()[0].toString());
		 	System.out.println(newGame.getDeck().getHumanCards()[1].toString());
		 	System.out.println(newGame.getDeck().getComp1Cards()[0].toString());
		 	System.out.println(newGame.getDeck().getComp1Cards()[1].toString());
		 	System.out.println(newGame.getDeck().getComp2Cards()[0].toString());
		 	System.out.println(newGame.getDeck().getComp2Cards()[1].toString());
		 	System.out.println(newGame.getDeck().getComp3Cards()[0].toString());
		 	System.out.println(newGame.getDeck().getComp3Cards()[1].toString());
		 	System.out.println(newGame.getDeck().getComp4Cards()[0].toString());
		 	System.out.println(newGame.getDeck().getComp4Cards()[1].toString());
		 	// TEST CARD VALUES are reachable
		 	System.out.println("Get Intelligence: ");
		 	System.out.println(newGame.getDeck().getHumanCards()[0].getValues()[0]);		 	
		 	System.out.println(newGame.getDeck().getHumanCards()[1].getValues()[0]);				 	
		 	System.out.println(newGame.getDeck().getComp1Cards()[0].getValues()[0]);	
		 	System.out.println(newGame.getDeck().getComp1Cards()[1].getValues()[0]);	
		 	System.out.println(newGame.getDeck().getComp2Cards()[0].getValues()[0]);	
		 	System.out.println(newGame.getDeck().getComp2Cards()[1].getValues()[0]);	
		 	System.out.println(newGame.getDeck().getComp3Cards()[0].getValues()[0]);	
		 	System.out.println(newGame.getDeck().getComp3Cards()[1].getValues()[0]);	
		 	System.out.println(newGame.getDeck().getComp4Cards()[0].getValues()[0]);	
		 	System.out.println(newGame.getDeck().getComp4Cards()[1].getValues()[0]);	
		 	
		 




	}

}
