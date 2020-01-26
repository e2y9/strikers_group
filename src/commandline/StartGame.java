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
	    human.updateCurrentCard();
	    comp1.updateCurrentCard();
	    comp2.updateCurrentCard();
	    comp3.updateCurrentCard();
	    comp4.updateCurrentCard();
//	    // Testing main card deck and player's own decks to prove dealDeck works
//	    System.out.print("\n\nPrint first card in deck:");
//	    System.out.print(deck.getCard(0).toString());
//	    System.out.print("\n\nPrint Player 1's fifth card:");
//	    System.out.print(deck.getPlayerList()[0].getPlayerCards()[4].toString());
//	    System.out.print("\n\nPrint Player 2's seventh card:");
//	    System.out.print(deck.getPlayerList()[1].getPlayerCards()[7].toString());
//	    System.out.print("\n\nPrint Player 5's third card:");
//	    System.out.print(deck.getPlayerList()[4].getPlayerCards()[3].toString());
	    
	
	}

}
