package commandline;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer implements Player {

	  String name;
	  Card[] playerCards;
	  int cardTotal;


	  public HumanPlayer() {		  
		  this.playerCards = new Card[40];
	  }
	  
	  public int chooseCategory() {
		  int catNum = 0;
		  try {
			  System.out.printf("%n%nWhat category would you like to choose?%n");
			  System.out.println("0 - Intelligence");
			  System.out.println("1 - Speed");
			  System.out.println("2 - Strength");
			  System.out.println("3 - Agility");
			  System.out.println("4 - Combat");
			  System.out.println("");
			  Scanner s = new Scanner(System.in);
			  String category = s.nextLine();
			  catNum = Integer.parseInt(category);
			  // array starts at 0, above list starts at 1, so -1
		  } catch (Exception e) {
			  System.out.println("Please enter a number between 0 and 4.");
		  }
		  return catNum;
	  }

	@Override
	public void updateCurrentCard() {

	}


	public Card[] getPlayerCards() {
		  return playerCards;
	  }

	  
	  public void updateCardPositions() {
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

	@Override
	public String displayCurrentCard() {
		return null;
	}


	public String getName() {
		  return name;
	  }

	@Override
	public Card getCurrentCard() {
		return null;
	}

	@Override
	public Card getLastCard() {
		return null;
	}

	public void getCardTotal() {
	  }

	  public void incrementCardTotal() {
		  this.cardTotal++;
	  };
	  
	  
	  public void setCardTotal() {
		  
	  }

	@Override
	public int chooseCompCategory() {
		int test = 0;
		// TODO Auto-generated method stub
		return test;
	}




	}