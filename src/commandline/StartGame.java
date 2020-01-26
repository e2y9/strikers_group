package commandline;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class StartGame {
    Player human;
    Player comp1;
    Player comp2;
    Player comp3;
    Player comp4;
    Player dealer;
	Player categoryChooser;
    Deck deck;
    
	
	
	public StartGame() {
	    human = new HumanPlayer();
	    comp1 = new CompPlayer();
	    comp2 = new CompPlayer();
	    comp3 = new CompPlayer();
	    comp4 = new CompPlayer();
	    dealer = new CompPlayer();
	    deck = new Deck(human, comp1, comp2, comp3, comp4);

	    try {
	    	// file address is set to Emmet's computer - change url below for own machine
	    	FileReader fr = new FileReader("C:\\code\\_eclipse\\eclipse-workspace\\template_project\\strikers_group\\src\\commandline\\MarvelDeck.txt");
	    	deck.loadCards(fr);
	    }catch (FileNotFoundException e) {
	      System.out.print("File not found.");
	    }
	    deck.shuffleDeck();
	    deck.dealDeck();
	
	}

}
