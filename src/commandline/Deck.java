package commandline;

import java.io.FileReader;
import java.util.Scanner;

public class Deck {

	  Card[] cardDeck;
	  Card[] commonPile;
	  Player[] playerList;

	  Card card0, card1, card2, card3, card4, card5, card6, card7,
	  card8, card9, card10, card11, card12, card13, card14, card15,
	  card16, card17, card18, card19, card20, card21, card22, card23,
	  card24, card25, card26, card27, card28, card29, card30, card31,
	  card32, card33, card34, card35, card36, card37, card38, card39;


	  public Deck(Player p1, Player p2, Player p3, Player p4, Player p5) {
	    
		cardDeck = new Card[40];
		commonPile = new Card[40];
		playerList = new Player[5];
		
	    this.playerList[0] = p1;
	    this.playerList[1] = p2;
	    this.playerList[2] = p3;
	    this.playerList[3] = p4;
	    this.playerList[4] = p5;
	
		Card card0 = new Card(); Card card1 = new Card(); Card card2 = new Card();
		Card card3 = new Card(); Card card4 = new Card(); Card card5 = new Card();
		Card card6 = new Card(); Card card7 = new Card(); Card card8 = new Card();
		Card card9 = new Card(); Card card10 = new Card(); Card card11 = new Card();
		Card card12 = new Card(); Card card13 = new Card(); Card card14 = new Card();
		Card card15 = new Card(); Card card16 = new Card(); Card card17 = new Card();
		Card card18 = new Card(); Card card19 = new Card(); Card card20 = new Card();
		Card card21 = new Card(); Card card22 = new Card(); Card card23 = new Card();
		Card card24 = new Card(); Card card25 = new Card(); Card card26 = new Card();
		Card card27 = new Card(); Card card28 = new Card(); Card card29 = new Card();
		Card card30 = new Card(); Card card31 = new Card(); Card card32 = new Card();
		Card card33 = new Card(); Card card34 = new Card(); Card card35 = new Card();
		Card card36 = new Card(); Card card37 = new Card(); Card card38 = new Card();
		Card card39 = new Card();
		
		cardDeck[0] = card0; cardDeck[1] = card1; cardDeck[2] = card2; cardDeck[3] = card3;
		cardDeck[4] = card4; cardDeck[5] = card5; cardDeck[6] = card6; cardDeck[7] = card7;
		cardDeck[8] = card8; cardDeck[9] = card9; cardDeck[10] = card10; cardDeck[11] = card11;
		cardDeck[12] = card12; cardDeck[13] = card13; cardDeck[14] = card14; cardDeck[15] = card15;
		cardDeck[16] = card16; cardDeck[17] = card17; cardDeck[18] = card18; cardDeck[19] = card19;
		cardDeck[20] = card20; cardDeck[21] = card21; cardDeck[22] = card22; cardDeck[23] = card23;
		cardDeck[24] = card24; cardDeck[25] = card25; cardDeck[26] = card26; cardDeck[27] = card27;
		cardDeck[28] = card28; cardDeck[29] = card29; cardDeck[30] = card30; cardDeck[31] = card31;
		cardDeck[32] = card32; cardDeck[33] = card33; cardDeck[34] = card34; cardDeck[35] = card35;
		cardDeck[36] = card36; cardDeck[37] = card37; cardDeck[38] = card38; cardDeck[39] = card39;
	  }
	  
	  public void loadCards(FileReader fr) {
	    Scanner s = new Scanner(fr);
	    // use nextLine to skip the first line
	    s.nextLine();
	    int counter = 0;
	    while (counter < 40) {
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

	  }

	  public void dealDeck() {
		  int player = 0;
		  int arrayPos = 0; // go to 8
		  int deckPos = 0; // go to 39
		  
		  for (player = 0; player < 5; player++) {
			  for (arrayPos = 0; arrayPos < 8; arrayPos++) {
				  playerList[player].getPlayerCards()[arrayPos] = cardDeck[deckPos];
				  deckPos++;
			  }
		  }


	  }

	  public void updateCommonPile() {

	  }

	  public void addPlayer(Player p, int i) {
	    this.playerList[i] = p;
	  }
	  
	  public Player[] getPlayerList() {
		  return playerList;
	  }



	}

