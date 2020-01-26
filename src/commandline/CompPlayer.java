package commandline;

public class CompPlayer implements Player {

	  String name;
	  Card[] playerCards;
	  int cardTotal;
	  Card currentCard;
	  Card lastCard;


	  public CompPlayer() {		  
		  this.playerCards = new Card[40];
	  }
	  
	  public int chooseCategory() {
		  int test = 0;
		  return test;
	  }
	  
	  public int chooseCompCategory() {
		 int[] categoryArray = new int[5];
		 int intelligence = currentCard.getIntelligence();
		 int speed = currentCard.getSpeed();
		 int strength = currentCard.getStrength();
		 int agility = currentCard.getAgility();
		 int combat = currentCard.getCombat();
		 categoryArray[0] = intelligence;
		 categoryArray[1] = speed;
		 categoryArray[2] = strength;
		 categoryArray[3] = agility;
		 categoryArray[4] =	combat;
		 int position = 1;
		 int max = categoryArray[0];		 
		 for (position = 1; position < categoryArray.length; position++) {
			 if (categoryArray[position] > max) {
				 max = categoryArray[position];
			 }
		 }
		 return position;
		  
	  };
	  
	  public Card[] getPlayerCards() {
		  return playerCards;
	  }
	  
	  public void updateCurrentCard() {
		  this.currentCard = this.playerCards[0];
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
	  
	  public String displayCurrentCard() {
		  return this.currentCard.toString();
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

