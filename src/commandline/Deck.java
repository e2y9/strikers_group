package commandline;

import java.io.FileReader;
import java.util.Scanner;

public class Deck {

	  Card[] cardDeck;
	  Card[] commonPile;
	  Player[] playerList;

	  Card card0;
	  Card card1;
	  Card card3;
	  Card card4;
	  Card card5;
	  Card card6;
	  Card card7;
	  Card card8;
	  Card card9;


	  public Deck(Player p1, Player p2, Player p3, Player p4, Player p5) {
	    
		cardDeck = new Card[10]; //10 cards for demo
		commonPile = new Card[40];
		playerList = new Player[5];
		
	    this.playerList[0] = p1;
	    this.playerList[1] = p2;
	    this.playerList[2] = p3;
	    this.playerList[3] = p4;
	    this.playerList[4] = p5;
	
		Card card0 = new Card();
		Card card1 = new Card();
		Card card2 = new Card();
		Card card3 = new Card();
		Card card4 = new Card();
		Card card5 = new Card();
		Card card6 = new Card();
		Card card7 = new Card();
		Card card8 = new Card();
		Card card9 = new Card();
		
		cardDeck[0] = card0;
		cardDeck[1] = card1;
		cardDeck[2] = card2;
		cardDeck[3] = card3;
		cardDeck[4] = card4;
		cardDeck[5] = card5;
		cardDeck[6] = card6;
		cardDeck[7] = card7;
		cardDeck[8] = card8;
		cardDeck[9] = card9;

	  }
	  
	  public void loadCards(FileReader fr) {
	    Scanner s = new Scanner(fr);
	    int counter = 0;
	    while (counter < 10) {
	        String line = s.nextLine();
	        String[] values = line.split(" ");
	        String name = values[0];
	        int intelligence = Integer.parseInt(values[1]);
	        int speed = Integer.parseInt(values[2]);
	        int strength = Integer.parseInt(values[3]);
	        int agility = Integer.parseInt(values[4]);
	        int fighting = Integer.parseInt(values[5]);
	        // store card objects in the deck, increment a counter for position
	        this.cardDeck[counter].fillCard(name, intelligence, speed, strength, agility, fighting);
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


	  public void dealDeck() {

	  }

	  public void updateCommonPile() {

	  }

	  public void addCardDeck() {

	// load cards into deck
	  }

	  public void addPlayer(Player p, int i) {
	    this.playerList[i] = p;
	  }

	  public void shuffle() {

	  }


	}

