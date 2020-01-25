package commandline;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer implements Player {

	  String name;
	  Card[] playerCards;
	  int cardTotal;
	  Card currentCard;
	  Card lastCard;


	  public HumanPlayer() {		  
		  this.playerCards = new Card[40];
	  }
	  
	  public int chooseCategory() {
		  int catNum = 0;
		  try {
			  System.out.println("What category would you like to choose?");
			  System.out.println("1 - Intelligence");
			  System.out.println("2 - Speed");
			  System.out.println("3 - Strength");
			  System.out.println("4 - Agility");
			  System.out.println("5 - Combat");
			  Scanner s = new Scanner(System.in);
			  String category = s.nextLine();
			  catNum = Integer.parseInt(category);
			  // array starts at 0, above list starts at 1, so -1
			  catNum -= 1;
		  } catch (InputMismatchException e) {
			  System.out.println("Please enter a number between 0 and 4.");
		  }
		  return catNum;
	  }
	  
	  public Card[] getPlayerCards() {
		  return playerCards;
	  }
	  
	  public void updateCurrentCard() {
		  this.currentCard = this.playerCards[0];
	  }
	  
	  public void updateCardPostions() {
		  int movePos = 0;
		  for (int i = 1; i < playerCards.length; i++) {
			  playerCards[movePos] = playerCards[i];
			  movePos++;
		  }
	  }
	  
	  public int findArrayPosition() {
		  int arrayPos = 40; // set to 40 so if for loop is broken it will produce a clear error (array is 0-39)
		  for (int i = 0; i < playerCards.length; i++) {
			  if (playerCards[i] == null) {
				  arrayPos = i;
				  break;
			  }
		  }
		  return arrayPos;
		 
	  }
	  
	  

	  public Card getCurrentCard() {
		  return currentCard;
	  }

	  public String getName() {
		  return name;
	  }
	  
	  public Card getLastCard() {
		  return lastCard;
	  };
	 
	  
	  public void getCardTotal() {
		  
	  };
	  
	  public void incrementCardTotal() {
		  this.cardTotal++;
	  };
	  
	  
	  public void setCardTotal() {
		  
	  }




	}