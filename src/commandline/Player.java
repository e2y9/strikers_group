package commandline;

interface Player {

	  public String getName();
	  public Card getCurrentCard();
	  public Card getLastCard();
	  public void getCardTotal();
	  public void setCardTotal();
	  public void incrementCardTotal();
	  public Card[] getPlayerCards();
	  public int chooseCategory();
	  public void updateCurrentCard();
	  public int findArrayPosition();

	}

