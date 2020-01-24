package commandline;

import java.io.FileNotFoundException;
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

		boolean writeGameLogsToFile = false; // Should we write game logs to file?
		
		// the args[0] if statement is commented-out so the program will run in the eclipse console
		
//		if (args[0].equalsIgnoreCase("true")) writeGameLogsToFile=true; // Command line selection

		// State
		boolean userWantsToQuit = false; // flag to check whether the user wants to quit the application

		// Loop until the user wants to exit the game
		while (!userWantsToQuit) {

			System.out.println("Welcome to Top Trumps!");
			System.out.println("Here are the first 10 cards:");
			
		    Player human = new HumanPlayer();
		    Player comp1 = new CompPlayer();
		    Player comp2 = new CompPlayer();
		    Player comp3 = new CompPlayer();
		    Player comp4 = new CompPlayer();
		    Deck deck = new Deck(human, comp1, comp2, comp3, comp4);

		    try {
		    	FileReader fr = new FileReader("C:\\code\\java_code\\test_folder\\toptrumps\\ComicbookDeckTest.txt");
		    	deck.loadCards(fr);
		    }catch (FileNotFoundException e) {
		      System.out.print("File not found.");
		    }
		    System.out.println(deck.getCard(0).toString());
		    System.out.println(deck.getCard(1).toString());
		    System.out.println(deck.getCard(2).toString());
		    System.out.println(deck.getCard(3).toString());
		    System.out.println(deck.getCard(4).toString());
		    System.out.println(deck.getCard(5).toString());
		    System.out.println(deck.getCard(6).toString());
		    System.out.println(deck.getCard(7).toString());
		    System.out.println(deck.getCard(8).toString());
		    System.out.println(deck.getCard(9).toString());

			// ----------------------------------------------------
			// Add your game logic here based on the requirements
			// ----------------------------------------------------

			userWantsToQuit=true; // use this when the user wants to exit the game

		}


	}

}
