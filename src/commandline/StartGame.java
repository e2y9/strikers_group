package commandline;

import java.io.FileNotFoundException;
import java.io.FileReader;

// StartGame class passes 5 players & the dealer into a newly created deck
// Then it reads the Deck.txt file and writes the info onto cards stored in the deck 
public class StartGame {
    Player human;
    Player comp1;
    Player comp2;
    Player comp3;
    Player comp4;
    Player dealer;
    Deck deck;
    
	
	
	public StartGame() {
	    human = new HumanPlayer("Ashwin");
	    comp1 = new CompPlayer("Comp Player 1");
	    comp2 = new CompPlayer("Comp Player 2");
	    comp3 = new CompPlayer("Comp Player 3");
	    comp4 = new CompPlayer("Comp Player 4");
	    dealer = new CompPlayer("Dealer");
	    deck = new Deck(human, comp1, comp2, comp3, comp4);

		// load cards into deck
	    try {
	    	// file address is set to Emmet's computer - change url below for own machine
	    	FileReader fr = new FileReader("C:\\Users\\Ashwin\\Documents\\Glasgow\\Master Project IT\\Emmet Repo\\strikers_group\\src\\commandline\\MarvelDeck.txt");
	    	deck.loadCards(fr);
	    }catch (FileNotFoundException e) {
	      System.out.print("File not found.");
	    }
	   
	    // deal deck now prints out cards each player has
	
	}
	
	public Deck getDeck() {
		return this.deck;
	}
	

}
