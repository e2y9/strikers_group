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
		 
		 	StartGame newGame = new StartGame();
		 	// Shuffle deck & Deal deck
		 	newGame.getDeck().shuffleDeck();
		 	newGame.getDeck().dealDeck();
		 	
//		 	newGame.getDeck().showAllCards();
//		 	System.out.println("\n\n\n");
		   
		    // TEST CARDS are in player decks
//		 	System.out.println(newGame.getDeck().getHumanCards()[0].toString());
//		 	System.out.println(newGame.getDeck().getHumanCards()[1].toString());
//		 	System.out.println(newGame.getDeck().getComp1Cards()[0].toString());
//		 	System.out.println(newGame.getDeck().getComp1Cards()[1].toString());
//		 	System.out.println(newGame.getDeck().getComp2Cards()[0].toString());
//		 	System.out.println(newGame.getDeck().getComp2Cards()[1].toString());
//		 	System.out.println(newGame.getDeck().getComp3Cards()[0].toString());
//		 	System.out.println(newGame.getDeck().getComp3Cards()[1].toString());
//		 	System.out.println(newGame.getDeck().getComp4Cards()[0].toString());
//		 	System.out.println(newGame.getDeck().getComp4Cards()[1].toString());

//		 	// TEST CARD VALUES are reachable
//		 	System.out.println("Get Intelligence: ");
//		 	System.out.println(newGame.getDeck().getHumanCards()[0].getValues()[0]);		 	
//		 	System.out.println(newGame.getDeck().getHumanCards()[1].getValues()[0]);				 	
//		 	System.out.println(newGame.getDeck().getComp1Cards()[0].getValues()[0]);	
//		 	System.out.println(newGame.getDeck().getComp1Cards()[1].getValues()[0]);	
//		 	System.out.println(newGame.getDeck().getComp2Cards()[0].getValues()[0]);	
//		 	System.out.println(newGame.getDeck().getComp2Cards()[1].getValues()[0]);	
//		 	System.out.println(newGame.getDeck().getComp3Cards()[0].getValues()[0]);	
//		 	System.out.println(newGame.getDeck().getComp3Cards()[1].getValues()[0]);	
//		 	System.out.println(newGame.getDeck().getComp4Cards()[0].getValues()[0]);	
//		 	System.out.println(newGame.getDeck().getComp4Cards()[1].getValues()[0]);
		 	
//		 	System.out.println("\nStart Game!\n");
//		 	System.out.println("User Card:\n" + newGame.getDeck().getUserCard());
//		 	newGame.getDeck().getAWinner();
//		 	newGame.getDeck().whoChoosesCategory(1);
//		 	newGame.getDeck().compareValues();
		 	
//		 	System.out.println("\nbooleans for who won:");
//		 	System.out.println(newGame.getDeck().getHumanLastWinner());
//		 	System.out.println(newGame.getDeck().getComp1LastWinner());		 
//		 	System.out.println(newGame.getDeck().getComp2LastWinner());	
//		 	System.out.println(newGame.getDeck().getComp3LastWinner());	
//		 	System.out.println(newGame.getDeck().getComp4LastWinner());	
//		 	System.out.println(newGame.getDeck().getDealerLastWinner());	
		 	
		 	newGame.getDeck().setAWinner(0);
		 	newGame.getDeck().assignRoundCards();
//		 	newGame.getDeck().assignDealerCards();
		 	
//		    // TEST CARDS are in player decks
		 	System.out.println("Winner assigned, round cards assigned.");
		 	System.out.println("\n-=-=-=-=\n");
		 	System.out.println(newGame.getDeck().findArrayPosition(0));
		 	System.out.println(newGame.getDeck().findArrayPosition(1));
		 	System.out.println(newGame.getDeck().findArrayPosition(2));
		 	System.out.println(newGame.getDeck().findArrayPosition(3));
		 	System.out.println(newGame.getDeck().findArrayPosition(4));
		 	System.out.println(newGame.getDeck().findArrayPosition(5));
		 	newGame.getDeck().moveCardsUp();
		 	System.out.println(newGame.getDeck().findArrayPosition(0));
		 	System.out.println(newGame.getDeck().findArrayPosition(1));
		 	System.out.println(newGame.getDeck().findArrayPosition(2));
		 	System.out.println(newGame.getDeck().findArrayPosition(3));
		 	System.out.println(newGame.getDeck().findArrayPosition(4));
		 	System.out.println(newGame.getDeck().findArrayPosition(5));
		 	
//		 	System.out.println(newGame.getDeck().getHumanCards()[0].toString());
//		 	System.out.println(newGame.getDeck().getHumanCards()[1].toString());
//		 	System.out.println(newGame.getDeck().getHumanCards()[2].toString());
//		 	System.out.println(newGame.getDeck().getHumanCards()[3].toString());
//		 	System.out.println(newGame.getDeck().getHumanCards()[4].toString());
//		 	System.out.println(newGame.getDeck().getHumanCards()[5].toString());
//		 	System.out.println(newGame.getDeck().getHumanCards()[6].toString());
//		 	
//		 	System.out.println("\nComp cards:");
//		 	System.out.println(newGame.getDeck().getComp1Cards()[1].toString());
//		 	System.out.println(newGame.getDeck().getComp2Cards()[1].toString());
//		 	System.out.println(newGame.getDeck().getComp3Cards()[1].toString());
//		 	System.out.println(newGame.getDeck().getComp4Cards()[1].toString());
//		 	newGame.getDeck().showAllCards();
		 	
//		 	// Testing Cards have been moved
//		 	System.out.println(newGame.getDeck().getHumanCards()[0].toString());
//		 	System.out.println(newGame.getDeck().getComp1Cards()[0].toString());
//		 	System.out.println(newGame.getDeck().getComp2Cards()[0].toString());
//		 	System.out.println(newGame.getDeck().getComp3Cards()[0].toString());
//		 	System.out.println(newGame.getDeck().getComp4Cards()[0].toString());
		 	
//		 	// Testing Cards have been moved
//		 	System.out.println(newGame.getDeck().getHumanCards()[1].toString());
//		 	System.out.println(newGame.getDeck().getComp1Cards()[1].toString());
//		 	System.out.println(newGame.getDeck().getComp2Cards()[1].toString());
//		 	System.out.println(newGame.getDeck().getComp3Cards()[1].toString());
//		 	System.out.println(newGame.getDeck().getComp4Cards()[1].toString());
		 	
//		 	try {
//		 	System.out.println(newGame.getDeck().getHumanCards()[1].toString());
//		 	} catch (Exception e) {System.out.println("no human card here");}
//		 	try {
//		 	System.out.println(newGame.getDeck().getComp1Cards()[1].toString());
// 	} catch (Exception e) {System.out.println("no comp1 card here");}
//		 	try {
//		 	System.out.println(newGame.getDeck().getComp2Cards()[1].toString());
//	} catch (Exception e) {System.out.println("no comp2 card here");}
//		 	try {
//		 	System.out.println(newGame.getDeck().getComp3Cards()[1].toString());
//	 	} catch (Exception e) {System.out.println("no comp3 card here");}
//		 	try {
//		 	System.out.println(newGame.getDeck().getComp4Cards()[1].toString());
//	 	} catch (Exception e) {System.out.println("no comp4 card here");}



	}

}
