// Under construction

package commandline;

public class HumanPlayer implements Player {

	  String name;
	  Card[] playerCards;
	  int cardTotal;


	  public HumanPlayer() {		  
		  this.playerCards = new Card[40];
	  }
	  
	  
	  public Card[] getPlayerCards() {
		  return playerCards;
	  }

	  public void getName() {
		  
	  };
	  
	  public void getLastCard() {
		  
	  };
	 
	  
	  public void getCardTotal() {
		  
	  };
	  
	  public void incrementCardTotal() {
		  this.cardTotal++;
	  };
	  
	  
	  public void setCardTotal() {
		  
	  }


	}