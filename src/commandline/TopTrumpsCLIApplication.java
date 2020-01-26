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

//		boolean writeGameLogsToFile = false; // Should we write game logs to file?
//		
//		// the args[0] if statement is commented-out so the program will run in the eclipse console
//		
////		if (args[0].equalsIgnoreCase("true")) writeGameLogsToFile=true; // Command line selection
//
//		// State
//		boolean userWantsToQuit = false; // flag to check whether the user wants to quit the application
		
		 System.out.print("Welcome to Top Trumps!\n");
		    // Testing main card deck and player's own decks to prove dealDeck works
	        Player human = new HumanPlayer();
	        Player comp1 = new CompPlayer();
	        Player comp2 = new CompPlayer();
	        Player comp3 = new CompPlayer();
	        Player comp4 = new CompPlayer();
	        Player dealer = new CompPlayer();
	        Deck deck = new Deck(human, comp1, comp2, comp3, comp4);
	        try {
	            // file address is set to Emmet's computer - change url below for own machine
	            FileReader fr = new FileReader("C:\\code\\_eclipse\\eclipse-workspace\\template_project\\strikers_group\\src\\commandline\\MarvelDeck.txt");
	            deck.loadCards(fr);
	        }catch (FileNotFoundException e) {
	            System.out.print("File not found.");
	        }

	        System.out.println("Testing cards have been loaded onto deck:\n");
		    System.out.print(deck.getCard(0).toString());
		    System.out.print(deck.getCard(1).toString());
		    System.out.print(deck.getCard(2).toString());
		    System.out.print(deck.getCard(3).toString());
		    System.out.print(deck.getCard(4).toString());
		    System.out.print(deck.getCard(5).toString());
		    System.out.print(deck.getCard(6).toString());
		    System.out.print(deck.getCard(7).toString());
		    System.out.print(deck.getCard(8).toString());
		    System.out.print(deck.getCard(9).toString());

	        deck.shuffleDeck();
	        deck.dealDeck();

	        System.out.print("\nCards have been dealt to players.\n");
	        System.out.println("Testing card deck has been emptied:");
	        try {
	            System.out.println(deck.getCard(0).toString());
	        } catch (Exception e) {
	            System.out.println("\nNo cards in deck.\n");
	        }

	        System.out.println("Testing players all have 2 cards each:");

	        System.out.println("Human player:");
	        System.out.println(human.getPlayerCards()[0].toString());
	        System.out.println(human.getPlayerCards()[1].toString());
	        try {
	            System.out.println(human.getPlayerCards()[2].toString());
	        } catch (Exception e) {
	            System.out.println("\nThere is no 3rd card.\n");
	        }

	        System.out.println("Comp1 player:");
	        System.out.println(comp1.getPlayerCards()[0].toString());
	        System.out.println(comp1.getPlayerCards()[1].toString());
	        try {
	            System.out.println(comp1.getPlayerCards()[2].toString());
	        } catch (Exception e) {
	            System.out.println("\nThere is no 3rd card.\n");
	        }

	        System.out.println("Comp2 player:");
	        System.out.println(comp2.getPlayerCards()[0].toString());
	        System.out.println(comp2.getPlayerCards()[1].toString());
	        try {
	            System.out.println(comp2.getPlayerCards()[2].toString());
	        } catch (Exception e) {
	            System.out.println("\nThere is no 3rd card.\n");
	        }

	        System.out.println("Comp3 player:");
	        System.out.println(comp3.getPlayerCards()[0].toString());
	        System.out.println(comp3.getPlayerCards()[1].toString());
	        try {
	            System.out.println(comp3.getPlayerCards()[2].toString());
	        } catch (Exception e) {
	            System.out.println("\nThere is no 3rd card.\n");
	        }

	        System.out.println("Comp4 player:");
	        System.out.println(comp4.getPlayerCards()[0].toString());
	        System.out.println(comp4.getPlayerCards()[1].toString());
	        try {
	            System.out.println(comp4.getPlayerCards()[2].toString());
	        } catch (Exception e) {
	            System.out.println("\nThere is no 3rd card.\n");
	        }
	        System.out.println("Testing card values are accessible:");

	        System.out.println(human.getPlayerCards()[0].getName());
	        System.out.println(human.getPlayerCards()[0].getCategories()[0]);
	        System.out.println(human.getPlayerCards()[0].getValues()[0]);

	        System.out.println(comp1.getPlayerCards()[0].getName());
	        System.out.println(comp1.getPlayerCards()[0].getCategories()[1]);
	        System.out.println(comp1.getPlayerCards()[0].getValues()[1]);

	        System.out.println(comp2.getPlayerCards()[0].getName());
	        System.out.println(comp2.getPlayerCards()[0].getCategories()[2]);
	        System.out.println(comp2.getPlayerCards()[0].getValues()[2]);

	        System.out.println(comp3.getPlayerCards()[0].getName());
	        System.out.println(comp3.getPlayerCards()[0].getCategories()[3]);
	        System.out.println(comp3.getPlayerCards()[0].getValues()[3]);

	        System.out.println(comp4.getPlayerCards()[0].getName());
	        System.out.println(comp4.getPlayerCards()[0].getCategories()[4]);
	        System.out.println(comp4.getPlayerCards()[0].getValues()[4]);


	}

}
