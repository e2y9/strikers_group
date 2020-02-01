package commandline;

import java.util.ArrayList;

public class DeckOfCards {
		
	private ArrayList<Card> deck;
	
	public DeckOfCards()
	{
		this.deck = new ArrayList<Card>();
	}

	
	public void displayDeck()
	{ int i = 0;
		for(Card element:deck)
		{
			System.out.println(element.toString() + "card " + i++);
		}
	}
	
	public void addCard(Card cardToAdd)
	{
		deck.add(cardToAdd);
	}
	
	public void removeCard(Card cardToRemove)
	{
		deck.remove(cardToRemove);
	}
	
	public String getTopCard()
	{
		return deck.get(0).toString();
	}
	
	public int getTopCardValue(int category)
	{
		return deck.get(0).getValue(category);
	}
	
	public ArrayList<Card> getDeck() 
	{
		return deck;
	}
	
	public int getNumberOfCards()
	{
		return deck.size();
	}
}
