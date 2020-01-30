/*It creates a deck for each player and dealer*/
package commandline;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Deck {

	  Card[] cardDeck;
	  ArrayList<Player> playerList;
	  ArrayList<Card> humanCards;
	  ArrayList<Card> comp1Cards;
	  ArrayList<Card> comp2Cards;
	  ArrayList<Card> comp3Cards;
	  ArrayList<Card> comp4Cards;
	  ArrayList<Card> dealerCards;
	  
	  
	  int chosenCategory;
	  int winner; // set by getAWinner at start of each category choice
	  boolean humanLastWinner;
	  boolean comp1LastWinner;
	  boolean comp2LastWinner;
	  boolean comp3LastWinner;
	  boolean comp4LastWinner;
	  boolean dealerLastWinner;

	  Card card0, card1, card2, card3, card4, card5, card6, card7,
	  card8, card9, card10;


	  // CHANGE deck to have an add player function rather than taking in a set number of players?
	  public Deck(Player p1, Player p2, Player p3, Player p4, Player p5) {
	    
		cardDeck = new Card[10];
		playerList = new ArrayList<Player>();
		
	    playerList.add(p1);
	    playerList.add(p2);
	    playerList.add(p3);
	    playerList.add(p4);
	    playerList.add(p5);
	    
	    humanCards  = new  ArrayList<Card>();
	    comp1Cards  = new  ArrayList<Card>();
	    comp2Cards  = new  ArrayList<Card>();
	    comp3Cards  = new  ArrayList<Card>();
	    comp4Cards  = new  ArrayList<Card>();
	    dealerCards  = new  ArrayList<Card>();
	    
	    chosenCategory = 99;
	    winner = 0;
	    
		humanLastWinner = true;
		comp1LastWinner = false;
		comp2LastWinner = false;
		comp3LastWinner = false;
		comp4LastWinner = false;
		dealerLastWinner = false;
	
		Card card0 = new Card(); Card card1 = new Card(); Card card2 = new Card();
		Card card3 = new Card(); Card card4 = new Card(); Card card5 = new Card();
		Card card6 = new Card(); Card card7 = new Card(); Card card8 = new Card();
		Card card9 = new Card();
		
		cardDeck[0] = card0; cardDeck[1] = card1; cardDeck[2] = card2; cardDeck[3] = card3;
		cardDeck[4] = card4; cardDeck[5] = card5; cardDeck[6] = card6; cardDeck[7] = card7;
		cardDeck[8] = card8; cardDeck[9] = card9;
	  }
	  
	  // Tested & Working
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
	  
	// Tested & Working
	  public void shuffleDeck() {	  
		  Random rdm = new Random();	
		  for (int i = 0; i < cardDeck.length; i++) {
			  int rdmIndexPos = rdm.nextInt(cardDeck.length);
			  Card temp = cardDeck[rdmIndexPos];
			  cardDeck[rdmIndexPos] = cardDeck[i];
			  cardDeck[i] = temp;
			}
	  }
	  
	  // UPDATED dealDeck method
	  public void dealDeck() {
		  ArrayList<ArrayList<Card>> temp = new ArrayList<ArrayList<Card>>();
		  temp.add(humanCards);
		  temp.add(comp1Cards);
		  temp.add(comp2Cards);
		  temp.add(comp3Cards);
		  temp.add(comp4Cards);
		  
		  int deckPos = 0; // position in cardDeck
		  int playerCount = 5; // number of active players
		  int count = 2; // number of cards in deck divided by number of players 
		  
		  while (count > 0) {
			  // use playerCount to set how many different players to give cards to
		  for(int i = 0; i < playerCount; i++) {
			  // get a player's card deck, add a card from the cardDeck to it
			  temp.get(i).add(cardDeck[deckPos]);
			  cardDeck[deckPos] = null;
			  deckPos++;
			  }
		  count--;
		  }
	  }
	  
		// Tested & working
		public int getAWinner() {
			if (getHumanLastWinner() == true) {
				this.winner = 0;
			} else if (getComp1LastWinner() == true) {
				this.winner = 1;
			} else if (getComp2LastWinner() == true) {
				this.winner = 2;
			} else if (getComp3LastWinner() == true) {
				this.winner = 3;
			} else if (getComp4LastWinner() == true) {
				this.winner = 4;
			} else if (getDealerLastWinner() == true) {
			// if dealer is last winner, don't update the int number for winner
			// instead keep the same int as used on previous round (i.e. the last player winner)
				return winner;
			} return winner;
		}
		
		// Tested & working
		public void setAWinner(int winner) {
			this.winner = winner;
			if (winner == 0) {
				setTHumanLastWinner(); setFComp1LastWinner(); setFComp2LastWinner(); setFComp3LastWinner(); 
				setFComp4LastWinner(); setFDealerLastWinner();
			} else if (winner == 1) {
				setFHumanLastWinner(); setTComp1LastWinner(); setFComp2LastWinner(); setFComp3LastWinner(); 
				setFComp4LastWinner(); setFDealerLastWinner();
			} else if (winner == 2) {
				setFHumanLastWinner(); setFComp1LastWinner(); setTComp2LastWinner(); setFComp3LastWinner(); 
				setFComp4LastWinner(); setFDealerLastWinner();
			} else if (winner == 3) {
				setFHumanLastWinner(); setFComp1LastWinner(); setFComp2LastWinner(); setTComp3LastWinner(); 
				setFComp4LastWinner(); setFDealerLastWinner();
			} else if (winner == 4) {
				setFHumanLastWinner(); setFComp1LastWinner(); setFComp2LastWinner(); setFComp3LastWinner(); 
				setTComp4LastWinner(); setFDealerLastWinner();
			} else if (winner == 5) {	
				setFHumanLastWinner(); setFComp1LastWinner(); setFComp2LastWinner(); setFComp3LastWinner(); 
				setFComp4LastWinner(); setTDealerLastWinner();
			}
		}
		
	  	// Tested & Working
		public void whoChoosesCategory(int playerWon) {
			// decide which player gets to choose a category
			// based on winner variable, which is set by getAWinner
			// human player has their own chooseCategory method
			// otherwise pass the comp player's number (1-4) into comp chooseACategory method
			if (playerWon == 0) {
				this.chosenCategory = playerList.get(0).chooseCategory();
			} else if (playerWon == 1) {
				this.chosenCategory = chooseACategory(1);
			} else if (playerWon == 2) {
				this.chosenCategory = chooseACategory(2);
			} else if (playerWon == 3) {
				this.chosenCategory = chooseACategory(3);
			} else if (playerWon == 4) {
				this.chosenCategory = chooseACategory(4);
			} else if (playerWon == 5 ) {
				System.out.println("Dealer can't choose categories.");
			}
		}
	  
		// UPDATED method with ArrayLists
	  public int chooseACategory(int player) {
		  ArrayList<ArrayList<Card>> temp = new ArrayList<ArrayList<Card>>();
		  temp.add(humanCards);
		  temp.add(comp1Cards);
		  temp.add(comp2Cards);
		  temp.add(comp3Cards); 
		  temp.add(comp4Cards);
		  
		  // store the card values from the player's 0 card in an array (value 0 = intelligence, 1 = agility ..)
		  int[] tempValues = new int[5];
		  for (int i = 0; i < 5; i++) {
			  tempValues[i] = temp.get(player).get(0).getValues()[i];
			  }

		  int max = tempValues[0];	
		 // set starting index position to be 1 higher than max's [0] position in the array
		 // loop through array until end, comparing max to other numbers and storing highest number as max
		  for (int i = 1; i < tempValues.length; i++) {
			 if (tempValues[i] > max) {
				 max = tempValues[i];
				 }
			 }
		 // now check which value (still in order 0-4, intelligence to combat) matches max
		 // this method is called by whoChoosesCategory, so the return value is passed back to that method to set category
		 if (max == tempValues[0]) {
			 return 0;
			 } else if (max == tempValues[1]) {
			 return 1;
			 } else if (max == tempValues[2]) {
			 return 2;
			 } else if (max == tempValues[3]) {
			 return 3;
			 } else if (max == tempValues[4]) {
			 return 4;
			 } else { return 99; } // return 99 (out of bounds) in result of an error 
		 }
		
	  
		// Tested & Working
		public void compareValues() {
			// assign chosen category values (chooseCategory method returns an int, used to set chosenCategory) 
			// values assigned to 1 int per player
			// index pos [0] is every player's current card
			int humanValue = humanCards.get(0).getValues()[this.chosenCategory];
			int comp1Value = comp1Cards.get(0).getValues()[this.chosenCategory];
			int comp2Value = comp2Cards.get(0).getValues()[this.chosenCategory];
			int comp3Value = comp3Cards.get(0).getValues()[this.chosenCategory];
			int comp4Value = comp4Cards.get(0).getValues()[this.chosenCategory];
			
//			// TESTING: print out all cards being compared
//			System.out.println("\nEvery player's current card [0] being compared:\n");
//			System.out.println(humanCards.get(0).toString());
//			System.out.println(comp1Cards.get(0).toString());
//			System.out.println(comp2Cards.get(0).toString());
//			System.out.println(comp3Cards.get(0).toString());
//			System.out.println(comp4Cards.get(0).toString());
//			
//			// TESTING:  print out all values being compared
//			System.out.println("\nValues being compared:\n");
//			System.out.println(humanValue);
//			System.out.println(comp1Value);
//			System.out.println(comp2Value);
//			System.out.println(comp3Value);
//			System.out.println(comp4Value);
//
//			
			// check which player has the highest value 
			// print the winning card to the screen
			// or, if draw, notify players that the dealer is holding onto the cards
			// also set the ___LastWinner variable based on who wins the round using setAWinner() method
			if ((humanValue > comp1Value) && (humanValue > comp2Value) 
					&& (humanValue > comp3Value) && (humanValue > comp4Value)) {
				System.out.printf("%nWinning card:%n" + humanCards.get(0).toString());
				setAWinner(0);
				
			} else if ((comp1Value > humanValue) && (comp1Value > comp2Value) 
					&& (comp1Value > comp3Value) && (comp1Value > comp4Value)) {
				System.out.printf("%nWinning card:%n" + comp1Cards.get(0).toString());
				setAWinner(1);
				
			} else if ((comp2Value > humanValue) && (comp2Value > comp1Value) 
					&& (comp2Value > comp3Value) && (comp2Value > comp4Value)) {
				System.out.printf("%nWinning card:%n" + comp2Cards.get(0).toString());
				setAWinner(2);
				
			} else if ((comp3Value > humanValue) && (comp3Value > comp1Value) 
					&& (comp3Value > comp2Value) && (comp3Value > comp4Value)) {
				System.out.printf("%nWinning card:%n" + comp3Cards.get(0).toString());
				setAWinner(3);
				
			} else if ((comp4Value > humanValue) && (comp4Value > comp1Value) 
					&& (comp4Value > comp2Value) && (comp4Value > comp3Value)) {
				System.out.printf("%nWinning card:%n" + comp4Cards.get(0).toString());
				setAWinner(4);
				
			} else { System.out.println("The round was a draw. Cards added to the dealer's pile.");
				setAWinner(5);
			}
		}
		
		// UPDATED method with ArrayLists, so now we don't need moveCardsUp
		public void assignRoundCards() {
			ArrayList<ArrayList<Card>> temp = new ArrayList<ArrayList<Card>>();
			temp.add(humanCards);
			temp.add(comp1Cards);
			temp.add(comp2Cards);
			temp.add(comp3Cards);
			temp.add(comp4Cards);
			
			// Create a Card array and add the current [0] position cards to it
			// (extracted from the player decks in temp arraylist)
			
			ArrayList<Card> cardTemp = new ArrayList<Card>();
			for (int i = 0; i < temp.size(); i++) {
				cardTemp.add(temp.get(i).get(0));
				temp.get(i).remove(0);
			}
			
			// Shuffle the cards (required for project)
			Random rdm = new Random();	
			for (int i = 0; i < cardTemp.size(); i++) {
				int rdmIndexPos = rdm.nextInt(cardTemp.size());
				Card card = cardDeck[rdmIndexPos];
				cardDeck[rdmIndexPos] = cardDeck[i];
				cardDeck[i] = card;
				}
			
			int playerCount = 5; // number of active players

			if (getDealerLastWinner() == true) {
				for(int i = 0; i < playerCount; i++) {
					dealerCards.add(cardTemp.get(i));
					}
				} else if (getHumanLastWinner() == true) {
					for(int i = 0; i < playerCount; i++) {
						humanCards.add(cardTemp.get(i));
						}
					} else if (getComp1LastWinner() == true) {
						for(int i = 0; i < playerCount; i++) {
							comp1Cards.add(cardTemp.get(i));
							}
						} else if (getComp2LastWinner() == true) {
							for(int i = 0; i < playerCount; i++) {
								comp2Cards.add(cardTemp.get(i));
								}
							} else if (getComp3LastWinner() == true) {
								for(int i = 0; i < playerCount; i++) {
									comp3Cards.add(cardTemp.get(i));
									}
								} else if (getComp4LastWinner() == true) {
									for(int i = 0; i < playerCount; i++) {
										comp4Cards.add(cardTemp.get(i));
										}
									}
			}
		
		
		// not fully tested (only 1 round played so far)
		public void assignDealerCards() {
			if ((getDealerLastWinner() == false) && (dealerCards.isEmpty() == false)) {
				if (getHumanLastWinner() == true) {
					for (int i = 0; i < dealerCards.size(); i++) {
						humanCards.add(dealerCards.get(i));
						}
				} else if (getComp1LastWinner() == true) {
					for (int i = 0; i < dealerCards.size(); i++) {
						comp1Cards.add(dealerCards.get(i));
						}
				} else if (getComp2LastWinner() == true) {
					for (int i = 0; i < dealerCards.size(); i++) {
						comp2Cards.add(dealerCards.get(i));
						}
				} else if (getComp3LastWinner() == true) {
					for (int i = 0; i < dealerCards.size(); i++) {
						comp3Cards.add(dealerCards.get(i));
						}
				} else if (getComp4LastWinner() == true) {
					for (int i = 0; i < dealerCards.size(); i++) {
						comp4Cards.add(dealerCards.get(i));
						}
				}
//				 after assigning cards, wipe the dealer's deck
				for (int i = 0; i < dealerCards.size(); i++) {
					dealerCards.remove(i);
					}	
				}
		}
		
	
	  public ArrayList<Player> getPlayerList() {
		  return playerList;
	  }

	  public Card[] getDeck() {
		return cardDeck;
	}

	  public Card getUserCard() {
	    return humanCards.get(0);
	  }
	  
		  
		public boolean getHumanLastWinner() {
			return humanLastWinner;
		}
		
		public Card getHumanCards(int index) {
			return humanCards.get(index);
		}

		public Card getComp1Cards(int index) {
			return comp1Cards.get(index);
		}

		public Card getComp2Cards(int index) {
			return comp2Cards.get(index);
		}

		public Card getComp3Cards(int index) {
			return comp3Cards.get(index);
		}

		public Card getComp4Cards(int index) {
			return comp4Cards.get(index);
		}

		public boolean getComp1LastWinner() {
			return comp1LastWinner;
		}
		
		public boolean getComp2LastWinner() {
			return comp2LastWinner;
		}
		
		public boolean getComp3LastWinner() {
			return comp3LastWinner;
		}
		
		public boolean getComp4LastWinner() {
			return comp4LastWinner;
		}
		
		public boolean getDealerLastWinner() {
			return dealerLastWinner;
		}
		
		public void setTHumanLastWinner() {
			humanLastWinner = true;
		}
		
		public void setTComp1LastWinner() {
			comp1LastWinner = true;
		}
		
		public void setTComp2LastWinner() {
			comp2LastWinner = true;
		}
		
		public void setTComp3LastWinner() {
			comp3LastWinner = true;
		}
		
		public void setTComp4LastWinner() {
			comp4LastWinner = true;
		}
		
		public void setTDealerLastWinner() {
			dealerLastWinner = true;
		}
		
		public void setFHumanLastWinner() {
			humanLastWinner = false;
		}
		
		public void setFComp1LastWinner() {
			comp1LastWinner = false;
		}
		
		public void setFComp2LastWinner() {
			comp2LastWinner = false;
		}
		
		public void setFComp3LastWinner() {
			comp3LastWinner = false;
		}
		
		public void setFComp4LastWinner() {
			comp4LastWinner = false;
		}
		
		public void setFDealerLastWinner() {
			dealerLastWinner = false;
		}
		
		public int getWinnerNumber() {
			return winner;
		}
		
		// FOR TESTING
		public void showAllCards() {
			System.out.println(humanCards.get(0));
			System.out.println(humanCards.get(1));
			System.out.println(comp1Cards.get(0));
			System.out.println(comp1Cards.get(1));
			System.out.println(comp2Cards.get(0));
			System.out.println(comp2Cards.get(1));
			System.out.println(comp3Cards.get(0));
			System.out.println(comp3Cards.get(1));
			System.out.println(comp4Cards.get(0));
			System.out.println(comp4Cards.get(1));
		}
	}