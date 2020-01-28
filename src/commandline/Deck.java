package commandline;

import java.io.FileReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Deck {

	  Card[] cardDeck;
	  Player[] playerList;
	  Card[] humanCards;
	  Card[] comp1Cards;
	  Card[] comp2Cards;
	  Card[] comp3Cards;
	  Card[] comp4Cards;
	  Card[] dealerCards;
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


	  public Deck(Player p1, Player p2, Player p3, Player p4, Player p5) {
	    
		cardDeck = new Card[10];
		playerList = new Player[5];
		
	    this.playerList[0] = p1;
	    this.playerList[1] = p2;
	    this.playerList[2] = p3;
	    this.playerList[3] = p4;
	    this.playerList[4] = p5;
	    
	    humanCards = new Card[10];
	    comp1Cards = new Card[10];
	    comp2Cards = new Card[10];
	    comp3Cards = new Card[10];
	    comp4Cards = new Card[10];
	    dealerCards = new Card[10];
	    
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
		  int deckPos = 0; // goes to 39

		  for (int i = 0; i < 2; i++) {
		  humanCards[i] = cardDeck[deckPos];
		  cardDeck[deckPos] = null;
//		  System.out.println(humanCards[arrayPos].toString());
		  deckPos++;
		  comp1Cards[i] = cardDeck[deckPos];
		  cardDeck[deckPos] = null;
		  deckPos++;
		  comp2Cards[i] = cardDeck[deckPos];
		  cardDeck[deckPos] = null;
		  deckPos++;
		  comp3Cards[i] = cardDeck[deckPos];
		  cardDeck[deckPos] = null;
		  deckPos++;
		  comp4Cards[i] = cardDeck[deckPos];
		  cardDeck[deckPos] = null;
		  deckPos++;
		  }
	  }
	  
	  public int chooseCategory(int player) {
		 int[] categoryArray = new int[5];
		 int intelligence = 99;
		 int speed = 99;
		 int strength = 99;
		 int agility = 99;
		 int combat = 99;
		
		 if (player == 0) {
			 intelligence = humanCards[0].getValues()[0];
			 speed = humanCards[0].getValues()[1];
			 strength = humanCards[0].getValues()[2];
			 agility = humanCards[0].getValues()[3];
			 combat = humanCards[0].getValues()[4];
		 } else if (player == 1) {
			 intelligence = comp1Cards[0].getValues()[0];
			 speed = comp1Cards[0].getValues()[1];
			 strength = comp1Cards[0].getValues()[2];
			 agility = comp1Cards[0].getValues()[3];
			 combat = comp1Cards[0].getValues()[4];
		 } else if (player == 2) {
			 intelligence = comp2Cards[0].getValues()[0];
			 speed = comp2Cards[0].getValues()[1];
			 strength = comp2Cards[0].getValues()[2];
			 agility = comp2Cards[0].getValues()[3];
			 combat = comp2Cards[0].getValues()[4];
		 } else if (player == 3) {
			 intelligence = comp3Cards[0].getValues()[0];
			 speed = comp3Cards[0].getValues()[1];
			 strength = comp3Cards[0].getValues()[2];
			 agility = comp3Cards[0].getValues()[3];
			 combat = comp3Cards[0].getValues()[4];
		 } else if (player == 4) {
			 intelligence = comp4Cards[0].getValues()[0];
			 speed = comp4Cards[0].getValues()[1];
			 strength = comp4Cards[0].getValues()[2];
			 agility = comp4Cards[0].getValues()[3];
			 combat = comp4Cards[0].getValues()[4];
		 }

		 categoryArray[0] = intelligence;
		 categoryArray[1] = speed;
		 categoryArray[2] = strength;
		 categoryArray[3] = agility;
		 categoryArray[4] =	combat;
		 
		 // find the highest values on the comp player's card
		 // set max to first int in the array
		 int max = categoryArray[0];	
		 // set starting index position to be 1 higher than max's [0] position in the array
		 // loop through array until end, comparing max to other numbers and storing highest number as max
		 for (int i = 1; i < categoryArray.length; i++) {
			 if (categoryArray[i] > max) {
				 max = categoryArray[i];
			 }
		 }
		 
		 // now check which stored card value matches max, and return the corresponding category number
		 if (max == intelligence) {
			 return 0;
			 } else if (max == speed) {
			 return 1;
			 } else if (max == strength) {
			 return 2;
			 } else if (max == agility) {
			 return 3;
			 } else if (max == combat) {
			 return 4;
			 } else { return 99; } // return 99 (out of bounds) in result of an error 
		 }
	  
		// TESTING
		public void whoChoosesCategory(int winner) {
			// decide which player gets to choose a category
			// based on winner variable, which is set by getAWinner
			if (winner == 0) {
				this.chosenCategory = playerList[0].chooseCategory();
			} else if (winner == 1) {
				this.chosenCategory = chooseCategory(1); // error starts here
			} else if (winner == 2) {
				this.chosenCategory = chooseCategory(2);
			} else if (winner == 3) {
				this.chosenCategory = chooseCategory(3);
			} else if (winner == 4) {
				this.chosenCategory = chooseCategory(4);
			}
		}
		
		// NOW TESTING
		public void compareValues() {
			
//			assign chosen category values (chooseCategory method returns an int) to an int per player
			int humanValue = humanCards[0].getValues()[this.chosenCategory];
			int comp1Value = comp1Cards[0].getValues()[this.chosenCategory];
			int comp2Value = comp2Cards[0].getValues()[this.chosenCategory];
			int comp3Value = comp3Cards[0].getValues()[this.chosenCategory];
			int comp4Value = comp4Cards[0].getValues()[this.chosenCategory];
			
			System.out.println(humanCards[0].toString());
			System.out.println(comp1Cards[0].toString());
			System.out.println(comp2Cards[0].toString());
			System.out.println(comp3Cards[0].toString());
			System.out.println(comp4Cards[0].toString());
			
			System.out.println(humanValue);
			System.out.println(comp1Value);
			System.out.println(comp2Value);
			System.out.println(comp3Value);
			System.out.println(comp4Value);

			
			// check which player has the highest value 
			// print the winning card to the screen
			// or, if draw, notify players that the dealer is holding onto the cards
			// also set the ___LastWinner variable based on who wins the round
			if ((humanValue > comp1Value) && (humanValue > comp2Value) 
					&& (humanValue > comp3Value) && (humanValue > comp4Value)) {
				System.out.printf("%nWinning card:%n" + humanCards[0].toString());
				setAWinner(0);
				
			} else if ((comp1Value > humanValue) && (comp1Value > comp2Value) 
					&& (comp1Value > comp3Value) && (comp1Value > comp4Value)) {
				System.out.printf("%nWinning card:%n" + comp1Cards[0].toString());
				setAWinner(1);
				
			} else if ((comp2Value > humanValue) && (comp2Value > comp1Value) 
					&& (comp2Value > comp3Value) && (comp2Value > comp4Value)) {
				System.out.printf("%nWinning card:%n" + comp2Cards[0].toString());
				setAWinner(2);
				
			} else if ((comp3Value > humanValue) && (comp3Value > comp1Value) 
					&& (comp3Value > comp2Value) && (comp3Value > comp4Value)) {
				System.out.printf("%nWinning card:%n" + comp3Cards[0].toString());
				setAWinner(3);
				
			} else if ((comp4Value > humanValue) && (comp4Value > comp1Value) 
					&& (comp4Value > comp2Value) && (comp4Value > comp3Value)) {
				System.out.printf("%nWinning card:%n" + comp4Cards[0].toString());
				setAWinner(4);
				
			} else { System.out.println("The round was a draw. Cards added to the dealer's pile.");
				setAWinner(5);
			}
		}
		
		
		public void assignRoundCards() {
			int arrayPos = 99; // 99 set as it is out of bounds (testing if stmnt)
			if (getDealerLastWinner() == true) {
				arrayPos = findArrayPosition(5);
				dealerCards[arrayPos] = humanCards[0];
				humanCards[0] = null;
				arrayPos++;
				dealerCards[arrayPos] = comp1Cards[0];
				comp1Cards[0] = null;
				arrayPos++;
				dealerCards[arrayPos] = comp2Cards[0];
				comp2Cards[0] = null;
				arrayPos++;
				dealerCards[arrayPos] = comp3Cards[0];
				comp3Cards[0] = null;
				arrayPos++;
				dealerCards[arrayPos] = comp4Cards[0];
				comp4Cards[0] = null;
				} else if (getHumanLastWinner() == true) {
					arrayPos = findArrayPosition(0);
					humanCards[arrayPos] = comp1Cards[0];
					comp1Cards[0] = null;
					arrayPos++;
					humanCards[arrayPos] = comp2Cards[0];
					comp2Cards[0] = null;
					arrayPos++;
					humanCards[arrayPos] = comp3Cards[0];
					comp3Cards[0] = null;
					arrayPos++;
					humanCards[arrayPos] = comp4Cards[0];
					comp4Cards[0] = null;
					arrayPos++;
					} else if (getComp1LastWinner() == true) {
						arrayPos = findArrayPosition(1);
						comp1Cards[arrayPos] = humanCards[0];
						humanCards[0] = null;
						arrayPos++;
						comp1Cards[arrayPos] = comp2Cards[0];
						comp2Cards[0] = null;
						arrayPos++;
						comp1Cards[arrayPos] = comp3Cards[0];
						comp3Cards[0] = null;
						arrayPos++;
						comp1Cards[arrayPos] = comp4Cards[0];
						comp4Cards[0] = null;
						arrayPos++;
						} else if (getComp2LastWinner() == true) {
							arrayPos = findArrayPosition(2);
							comp2Cards[arrayPos] = humanCards[0];
							humanCards[0] = null;
							arrayPos++;
							comp2Cards[arrayPos] = comp1Cards[0];
							comp1Cards[0] = null;
							arrayPos++;
							comp2Cards[arrayPos] = comp3Cards[0];
							comp3Cards[0] = null;
							arrayPos++;
							comp2Cards[arrayPos] = comp4Cards[0];
							comp4Cards[0] = null;
							arrayPos++;
							} else if (getComp3LastWinner() == true) {
								arrayPos = findArrayPosition(3);
								comp3Cards[arrayPos] = humanCards[0];
								humanCards[0] = null;
								arrayPos++;
								comp3Cards[arrayPos] = comp1Cards[0];
								comp1Cards[0] = null;
								arrayPos++;
								comp3Cards[arrayPos] = comp2Cards[0];
								comp2Cards[0] = null;
								arrayPos++;
								comp3Cards[arrayPos] = comp4Cards[0];
								comp4Cards[0] = null;
								arrayPos++;
								} else if (getComp4LastWinner() == true) {
									arrayPos = findArrayPosition(4);
									comp4Cards[arrayPos] = humanCards[0];
									humanCards[0] = null;
									arrayPos++;
									comp4Cards[arrayPos] = comp1Cards[0];
									comp1Cards[0] = null;
									arrayPos++;
									comp4Cards[arrayPos] = comp2Cards[0];
									comp2Cards[0] = null;
									arrayPos++;
									comp4Cards[arrayPos] = comp3Cards[0];
									comp3Cards[0] = null;
									arrayPos++;
								}
			}
		
		public void assignDealerCards() {
			if ((getDealerLastWinner() == false) && (dealerCards[0] != null)) {
				int startPos = 99; // 99 to throw out of bounds exception testing whether the if statements break
				if (getHumanLastWinner() == true) {
					startPos = findArrayPosition(0);
					for (int i = 0; i < findArrayPosition(5); i++) {
						humanCards[startPos] = dealerCards[i];
						startPos++;
						}
				} else if (getComp1LastWinner() == true) {
					startPos = findArrayPosition(1);
					for (int i = 0; i < findArrayPosition(5); i++) {
						comp1Cards[startPos] = dealerCards[i];
						startPos++;}
				} else if (getComp2LastWinner() == true) {
					startPos = findArrayPosition(2);
					for (int i = 0; i < findArrayPosition(5); i++) {
						comp2Cards[startPos] = dealerCards[i];
						startPos++;}
				} else if (getComp3LastWinner() == true) {
					startPos = findArrayPosition(3);
					for (int i = 0; i < findArrayPosition(5); i++) {
						comp3Cards[startPos] = dealerCards[i];
						startPos++;}
				} else if (getComp4LastWinner() == true) {
					startPos = findArrayPosition(4);
					for (int i = 0; i < findArrayPosition(5); i++) {
						comp4Cards[startPos] = dealerCards[i];
						startPos++;}
				}
				// after assigning cards, wipe the dealer's deck
				for (int i = 0; i < findArrayPosition(5); i++) {
					dealerCards[i] = null;
					}
				
				}
		}
		
		// tested & working
		public void getAWinner() {
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
				this.winner = 5;
			}
		}
		
		// tested & working
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
		
		// UNDER CONSTRUCTION
		public void moveCardsUp() {
			// move all playerCards[i] up one
			// CHECK if last card is also being wiped/overwritten, as it doesn't seem like it from looking at this
			// could do an arrayPosition check on the
			
			// HUMAN
			int newPosition = 0;
			for (int i = 1; i < findArrayPosition(0); i++) {
				humanCards[newPosition] = humanCards[i];
				newPosition++;
			}
			for (int i = 1; i < findArrayPosition(1); i++) {
				comp1Cards[newPosition] = comp1Cards[i];
				newPosition++;
			}
			for (int i = 1; i < findArrayPosition(2); i++) {
				comp2Cards[newPosition] = comp2Cards[i];
				newPosition++;
			}
			for (int i = 1; i < findArrayPosition(3); i++) {
				comp3Cards[newPosition] = comp3Cards[i];
				newPosition++;
			}
			for (int i = 1; i < findArrayPosition(4); i++) {
				comp4Cards[newPosition] = comp4Cards[i];
				newPosition++;
			}
			// COMP1
			// COMP2
			// COMP3
			// COMP4
			
		}
	  
	  // use if statements like above will
	  public int findArrayPosition(int player) {
		  int arrayPos = 99; // set to 40 (out of bounds) so a broken for loop will produce a clear error
	 
		  if (player == 0) {
			  for (int i = 0; i < humanCards.length; i++) {
				  if (humanCards[i] == null) {
					  arrayPos = i;
					  break;
					  }
				  }
		  } else if (player == 1) {
			  for (int i = 0; i < comp1Cards.length; i++) {
				  if (comp1Cards[i] == null) {
					  arrayPos = i;
					  break;
					  }
				  }
		  } else if (player == 2) {
			  for (int i = 0; i < comp2Cards.length; i++) {
				  if (comp2Cards[i] == null) {
					  arrayPos = i;
					  break;
					  }
				  }
		  } else if (player == 3) {
			  for (int i = 0; i < comp3Cards.length; i++) {
				  if (comp3Cards[i] == null) {
					  arrayPos = i;
					  break;
					  }
				  }
		  } else if (player == 4) {
			  for (int i = 0; i < comp4Cards.length; i++) {
				  if (comp4Cards[i] == null) {
					  arrayPos = i;
					  break;
					  }
				  }
		  } else if (player == 5) {
			  for (int i = 0; i < dealerCards.length; i++) {
				  if (dealerCards[i] == null) {
					  arrayPos = i;
					  break;
					  }
				  }
		  }
		  return arrayPos;
	  }
	  
	  
//	  // WORKING string representation
//	  public void testNewDeck() {
//		  humanCards[0].toString();
//		  comp1Cards[0].toString();
//	  }
//	  
//	  
//	  // WORKING string
//		public void testDeckStuff(int p) {
//			System.out.println(comp1Cards[0].toString());
//		}
		
//		// WORKING value
//		public void returnMeACard() {
//			System.out.println(comp1Cards[0].getValues()[1]);
//		}
	  
	  // Original dealDeck
//	  public void dealDeck() {
//		  // deal 8 cards to 1st player, then 2nd, 3rd, 4th, 5th 
//		  int player = 0; // goes to 4
//		  int arrayPos = 0; // goes to 7
//		  int deckPos = 0; // goes to 39
//
//			  for (player = 0; player < 5; player++) {
//				  for (arrayPos = 0; arrayPos < 2; arrayPos++) {
//					  playerList[player].getPlayerCards()[arrayPos] = cardDeck[deckPos];
//					  cardDeck[deckPos] = null;
//					  // TEST print statements
//					  System.out.println("\nPlayer " + player);
//					  System.out.println(playerList[player].getPlayerCards()[arrayPos].toString());
//					  System.out.println(deckPos);
//					  deckPos++;
//				  }
//				  System.out.println("-+-+-+-+-+");
//			  }
//	  }

	  
	  public Player[] getPlayerList() {
		  return playerList;
	  }

	  public Card[] getDeck() {
		return cardDeck;
	}

	  public Card getCard(int i) {
	    return cardDeck[i];
	  }
	  
	  public Card[] getHumanCards() {
		  return humanCards;
	  }
	  
	  public Card[] getComp1Cards() {
		  return comp1Cards;
	  }
	  
	  public Card[] getComp2Cards() {
		  return comp2Cards;
	  }
	  
	  public Card[] getComp3Cards() {
		  return comp3Cards;
	  }
	  
	  public Card[] getComp4Cards() {
		  return comp4Cards;
	  }
	  
		public boolean getHumanLastWinner() {
			return humanLastWinner;
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
			return comp4LastWinner;
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



	}


