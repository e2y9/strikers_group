package commandline;

import java.io.FileReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Deck {

	  Card[] cardDeck;
	  Card[] commonPile;
	  Player[] playerList;

	  Card card0, card1, card2, card3, card4, card5, card6, card7,
	  card8, card9, card10;


	  public Deck(Player p1, Player p2, Player p3, Player p4, Player p5) {
	    
		cardDeck = new Card[10];
		commonPile = new Card[10];
		playerList = new Player[5];
		
	    this.playerList[0] = p1;
	    this.playerList[1] = p2;
	    this.playerList[2] = p3;
	    this.playerList[3] = p4;
	    this.playerList[4] = p5;
	
		Card card0 = new Card(); Card card1 = new Card(); Card card2 = new Card();
		Card card3 = new Card(); Card card4 = new Card(); Card card5 = new Card();
		Card card6 = new Card(); Card card7 = new Card(); Card card8 = new Card();
		Card card9 = new Card();
		
		cardDeck[0] = card0; cardDeck[1] = card1; cardDeck[2] = card2; cardDeck[3] = card3;
		cardDeck[4] = card4; cardDeck[5] = card5; cardDeck[6] = card6; cardDeck[7] = card7;
		cardDeck[8] = card8; cardDeck[9] = card9;
	  }
	  
	  public void loadCards(FileReader fr) {
	    Scanner s = new Scanner(fr);
	    // use nextLine to skip the first line
	    s.nextLine();
	    int counter = 0;
	    while (counter < 10) { // only load 10 cards for demo
	        String line = s.nextLine();
	        String[] values = line.split(" ");
	        String name = values[0];
	        int intelligence = Integer.parseInt(values[1]);
	        int speed = Integer.parseInt(values[2]);
	        int strength = Integer.parseInt(values[3]);
	        int agility = Integer.parseInt(values[4]);
	        int combat = Integer.parseInt(values[5]);
	        // store card objects in the deck, increment a counter for position
	        this.cardDeck[counter].fillCard(name, intelligence, speed, strength, agility, combat);
	        counter++;
	    }
	    s.close();
	}

	  public Card[] getDeck() {
		return cardDeck;
	}

	  public Card getCard(int i) {
	    return cardDeck[i];
	  }

	  public void shuffleDeck() {	  
		  Random rdm = new Random();	
		  for (int i = 0; i < cardDeck.length; i++) {
			  int rdmIndexPos = rdm.nextInt(cardDeck.length);
			  Card temp = cardDeck[rdmIndexPos];
			  cardDeck[rdmIndexPos] = cardDeck[i];
			  cardDeck[i] = temp;
			}
	  }

	  public void dealDeck() {
		  // deal 8 cards to 1st player, then 2nd, 3rd, 4th, 5th 
		  int player = 0; // goes to 4
		  int arrayPos = 0; // goes to 7
		  int deckPos = 0; // goes to 39

			  for (player = 0; player < 5; player++) {
				  for (arrayPos = 0; arrayPos < 2; arrayPos++) {
					  playerList[player].getPlayerCards()[arrayPos] = cardDeck[deckPos];
					  cardDeck[deckPos] = null;
					  deckPos++;
				  }
			  }
	  }

	  // Replace by adding to dealer instead?
//	  public void updateCommonPile() {
//		  // add 5 current cards to commonPile array
//		  for (int i = 0; i < 5; i++) {
//			  commonPile[i] = playerList[i].getCurrentCard();
//		  }
//		  // shuffle cards in array
//		  Random rdm = new Random();
//		  for (int i = 0; i < 5; i++) {
//			  int rdmIndexPos = rdm.nextInt(5);
//			  Card temp = commonPile[rdmIndexPos];
//			  commonPile[rdmIndexPos] = commonPile[i];
//			  commonPile[i] = temp;
//		  }
//	  }
	  


	  
	  public Player[] getPlayerList() {
		  return playerList;
	  }



	}


