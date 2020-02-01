/*This method implements Player interface, Choose Category method is still incomplete*/
package commandline;

public class CompPlayer implements Player {

	 private String name;
	 private DeckOfCards playerDeck;


	public CompPlayer(String name) 
	  {		  
		  this.name = name;
		  playerDeck = new DeckOfCards();
	  }
	

	  public String getName() {
		  return name;
	  }


	@Override
	public int chooseCategory() {
		return 0;
	}
	
	public String topCard()
	{
		String result = "";
		if(playerDeck.getDeck().isEmpty())
		{
			result = "";
		}
		else
		{
			result = playerDeck.getTopCard();
		}
		return result;
	}
	
	 public DeckOfCards getPlayerDeck() {
			return playerDeck;
		}
}

