package commandline;
import java.io.FileReader;

public class TopTrumpsCLIApplication {

	public static void main(String[] args) {
		
		 System.out.print("Welcome to Top Trumps!\n");
		 
		 	// initialise the game, creating 5 players with a card pile each (+ a dealer pile for commonPile cards)
		    // also use loadCards method to extract card info from the MarvelDeck.txt file
		 	StartGame newGame = new StartGame();
		 	// Shuffle deck first, using Random and a loop to swap cards about randomly
		 	newGame.getDeck().shuffleDeck();
		 	// dealDeck assigns cards to all 5 players (1 human + 4 computer players)
		 	// they are loaded into the start of every player's deck at position 0
		 	// there are 10 cards in the demo deck, so player piles have cards at positions 0 and 1
		 	newGame.getDeck().dealDeck();
		 	
		 	// the TEST method showAllCards is used to print each card in each players pile (10 in total)
		 	System.out.println("\n\nShow all cards in the deck (10 in demo): ");
		 	newGame.getDeck().showAllCards();
		 	System.out.println("\n\n\n");
		   
		 	
		 	System.out.println("\nStart Game!\n");
		 	// show the user their card (the one at position 0 is everyone's current card)
		 	System.out.println("User Card:\n" + newGame.getDeck().getUserCard());
		 	
		 	// change the int in the setAWinner method (0-4) to test different category choosers 
		 	// (otherwise it's auto-set to human for round 1)
		 	// newGame.getDeck().setAWinner(1);
		 	// ^ un-mute the above line for testing ^
		 	
		 	// the getAWinner method checks all the booleans at the top of the Deck class (humanLastWinner etc)
		 	// whichever is set to true was the winner of the last round (1st round starts with humanLastWinner as true)
		 	// when the getAWinner method finds a true boolean it changes the winner (int) in Deck to the corresponding number
		 	// 0 = human, 1 = comp1, 2 = comp2, 3 = comp3, 4 = comp4, 5 = dealer (dealer has a pile but not a player)
		 	// getAWinner also returns that int (winner) for use in whoChoosesCategory
		 	
		 	
		 	// whoChoosesCategory method automatically runs the chooseCategory method after being told who has won
		 	newGame.getDeck().whoChoosesCategory(newGame.getDeck().getAWinner());
		 	// with compareValues, compare all player category values based on the chosenCategory
		 	newGame.getDeck().compareValues();
		 	
		 	// if someone has won, assign all 5 current cards to the back of their deck (incl. their own current card)
		 	newGame.getDeck().assignRoundCards();
		 	// if there are cards in the dealer's deck (after a draw), assign them to the winner of the last round
//		 	newGame.getDeck().assignDealerCards();
		 	
//		    // TEST CARDS are in player decks
//		 	System.out.println("\n\nWinner was player #" + newGame.getDeck().getWinnerNumber() + ", round cards assigned.");
//		 	System.out.println("\nArray Positions (first null found) after assignCards but before moveCardsUp: \n");
//		 	System.out.println("Human: " + newGame.getDeck().findArrayPosition(0));
//		 	System.out.println("Comp1: " + newGame.getDeck().findArrayPosition(1));
//		 	System.out.println("Comp2: " + newGame.getDeck().findArrayPosition(2));
//		 	System.out.println("Comp3: " + newGame.getDeck().findArrayPosition(3));
//		 	System.out.println("Comp4: " + newGame.getDeck().findArrayPosition(4));
//		 	System.out.println("Dealer: " + newGame.getDeck().findArrayPosition(5));
		 	// moveCardsUp uses a loop to move card in array position 1 to position 0, then position 2 to position 1
		 	// the method stops when it finds a null value (so that it doesn't write over the previous moved card)
		 	newGame.getDeck().moveCardsUp();
//		 	System.out.println("\nArray Positions (first null found) after moving cards: \n");
//		 	System.out.println("Human: " + newGame.getDeck().findArrayPosition(0));
//		 	System.out.println("Comp1: " + newGame.getDeck().findArrayPosition(1));
//		 	System.out.println("Comp2: " + newGame.getDeck().findArrayPosition(2));
//		 	System.out.println("Comp3: " + newGame.getDeck().findArrayPosition(3));
//		 	System.out.println("Comp4: " + newGame.getDeck().findArrayPosition(4));
//		 	System.out.println("Dealer: " + newGame.getDeck().findArrayPosition(5));
		 	
		 	System.out.println("\nEvery player's new card[0] : \n");
//		 	System.out.println(newGame.getDeck().getHumanCards()[0].toString());
		 	System.out.println(newGame.getDeck().getHumanCards(0).toString());
		 	System.out.println(newGame.getDeck().getComp1Cards(0).toString());
		 	System.out.println(newGame.getDeck().getComp2Cards(0).toString());
		 	System.out.println(newGame.getDeck().getComp3Cards(0).toString());
		 	System.out.println(newGame.getDeck().getComp4Cards(0).toString());
	

	}

}
