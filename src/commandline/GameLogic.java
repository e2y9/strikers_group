//Why use these methods in deck.java  1)assign roundCards 2) assign dealer cards

package commandline;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {
	
	private Players playersList;
	private DeckOfCards allCards;
	private Player winnerOfRound;
	

	public GameLogic(Players players)
	{
		this.playersList = players;
		allCards = new DeckOfCards();
		try
		{
	    	FileReader fr = new FileReader("C:\\Users\\Ashwin\\Documents\\Glasgow\\Master Project IT\\Emmet Repo\\strikers_group\\src\\commandline\\MarvelDeck.txt");
	    	loadCards(fr);
	    }
		catch (FileNotFoundException e) 
		{
	      System.out.print("File not found.");
	    }
		winnerOfRound = playersList.getPlayers().get(0);
		
	}
	
	//Check this method might be logically wrong.
	 public void loadCards(FileReader fr) 
	 {
		    Scanner s = new Scanner(fr);
		    // use nextLine to skip the first line
		    s.nextLine();
		    int counter = 0;
		    while (counter < 10)
		    { // only load 10 cards for demo
		    	Card c = new Card();
		        String line = s.nextLine();
		        String[] values = line.split(" ");
		        String name = values[0];
		        int intelligence = Integer.parseInt(values[1]);
		        int speed = Integer.parseInt(values[2]);
		        int strength = Integer.parseInt(values[3]);
		        int agility = Integer.parseInt(values[4]);
		        int combat = Integer.parseInt(values[5]);
		        allCards.addCard(c);
		        // store card objects in the deck, increment a counter for position
		       
		        this.allCards.getDeck().get(counter).fillCard(name, intelligence, speed, strength, agility, combat);
		        counter++;
		    }
		    s.close();
		}
	public void dealDeck()
	{
		int deckPosition = 0;
		int count = allCards.getDeck().size() / playersList.getPlayers().size(); //2
		while(count>0 && deckPosition < allCards.getDeck().size())
		{
			for(int i=0; i<playersList.getPlayers().size(); i++)
			{
				playersList.getPlayers().get(i).getPlayerDeck().addCard(allCards.getDeck().get(deckPosition++));
			}
			count--;
		}
		
	}
	
	
	//Might throw a null pointer exception
	public void shuffleDeck()
	{
		Random randomInteger = new Random();
		for(int i=0; i<allCards.getDeck().size(); i++)
		{
			int randomIndexPosition = randomInteger.nextInt(allCards.getDeck().size());
			Card temp = allCards.getDeck().get(randomIndexPosition);
			allCards.getDeck().set(randomIndexPosition, allCards.getDeck().get(i));
			allCards.getDeck().set(i, temp);
		}
	}
	
	//Work on the draw case and improve  winner case.
	public Player roundWinner()
	{
		int temp = 0;
		int card1Value=0;
		int card2Value=0;
		int chosenCategory = winnerOfRound.chooseCategory();
		int playersLeft = playersList.getPlayers().size();
		if(playersLeft > 0)
		{
			for(int i =0; i<playersLeft-1; i++)
			{
				card1Value = playersList.getCardValue(i, chosenCategory);
				card2Value = playersList.getCardValue(i+1, chosenCategory);
				if(card1Value > card2Value &&  card1Value > temp && card2Value > temp )
				{
					temp = card1Value;
					winnerOfRound = playersList.getPlayers().get(i);

				}
				else if(card1Value == card2Value)
				{
					System.out.println("It's a draw case");
				}
				else
				{
					winnerOfRound = playersList.getPlayers().get(i+1);
				}
				
			}
		}
		return winnerOfRound;
		
	}
	
	public void whoChooseCategory()
	{
		winnerOfRound.chooseCategory();
	}
	
	public void printDeck()
	{
		allCards.displayDeck();
	}
	
	public String getWinnerOfRound()
	{
		return winnerOfRound.getName() + "\n" +  winnerOfRound.getPlayerDeck().getTopCard();
	}
	
	public void displayAllPLayersTopCard()
	{
		
		for(int i=0; i<playersList.getPlayers().size(); i++)
		{
			System.out.println("\n" + playersList.getPlayers().get(i).getName());
			System.out.println(playersList.getPlayers().get(i).getPlayerDeck().getTopCard());
		}
	}
	
	public void playRound()
	{
		roundWinner();
		whoChooseCategory();
		System.out.println("\n"+ getWinnerOfRound() + "won the round and will choose the category of next card");
		System.out.println("\n All players top card");
		displayAllPLayersTopCard();
	}
	
	public void lostPlayer()
	{
		for(int i=0; i<playersList.getPlayers().size(); i++)
		{
			if(playersList.getPlayers().get(i).getPlayerDeck().getDeck().isEmpty())
			{
				playersList.getPlayers().remove(i);
			}
		}
		
	}

	public Players getPlayersList() {
		return playersList;
	}
	
	//I think cards need to be shuffled before adding to winners deck
	public void transferCards()
	{
		DeckOfCards temp = new DeckOfCards();
		for(int i=0; i<playersList.getPlayers().size(); i++)
		{
			temp.addCard(playersList.getPlayers().get(i).getPlayerDeck().getDeck().get(0));
			playersList.getPlayers().get(i).getPlayerDeck().getDeck().remove(0);
		}
		
		for(int i=0; i<playersList.getPlayers().size(); i++)
		{
			if(playersList.getPlayers().get(i).equals(winnerOfRound))
			{
				for(int j=0; j<temp.getDeck().size(); j++)
				{
					playersList.getPlayers().get(i).getPlayerDeck().getDeck().add(temp.getDeck().get(0));
					temp.getDeck().remove(0);
				}
			}
			
		}
	}

}
