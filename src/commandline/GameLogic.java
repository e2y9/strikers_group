package commandline;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {
	
	private Players playersList;
	private DeckOfCards allCards;
	private Player winnerOfRound;
	private DeckOfCards commonPile;
	private int totalNumberOfDraws = 0;
	private static int gameId = 0;
	private int numOfPlayers;
	private int totalNumberOfRounds=0;
	private Card winnerCard;
	private boolean draw = false;

	public GameLogic(int numOfPlayers)
	{
		this.numOfPlayers = numOfPlayers;
		playersList = new Players();
		allCards = new DeckOfCards();
		commonPile = new DeckOfCards();
		try
		{
	    	FileReader fr = new FileReader("C:\\Users\\Ashwin\\Documents\\Glasgow\\Master Project IT\\Emmet Repo\\strikers_group\\src\\commandline\\MarvelDeck.txt");
	    	loadCards(fr);
	    }
		catch (FileNotFoundException e) 
		{
	      System.out.print("File not found.");
	    }

	
		gameId++;
		playersList.addPlayer(new HumanPlayer("Human Player"));		
		winnerOfRound = playersList.getPlayers().get(0);
		for(int i=1; i<numOfPlayers; i++)
		{
			String name = "AI "+ i;
			playersList.addPlayer(new CompPlayer(name));
		}
		
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
	
	public void roundWinner()
	{
		int category = winnerOfRound.chooseCategory();
		int temp = 0;
		if(lastPlayerLeft() == false)
		{
			for(int i=0; i<playersList.getPlayers().size(); i++)
			{
				if(playersList.getPlayers().get(i).getLost() == false)
				{
					for(int j=i+1 ; j<playersList.getPlayers().size(); j++)
					{
						if(playersList.getPlayers().get(j).getLost() == false)
						{
							if((this.getPlayersTopCardValue(i, category) > this.getPlayersTopCardValue(j, category)) && (this.getPlayersTopCardValue(i, category)>temp))
							{
								temp = this.getPlayersTopCardValue(i, category);
								winnerOfRound = playersList.getPlayers().get(i);
								if(commonPile.getDeck().isEmpty() == false)
								{
									addFromCommonPile(i);
								}
								
							}
							
							else if(this.getPlayersTopCardValue(i, category) < this.getPlayersTopCardValue(j, category) && this.getPlayersTopCardValue(j, category)>temp)
							{
								temp = this.getPlayersTopCardValue(i, category);
								winnerOfRound = playersList.getPlayers().get(j);
								if(commonPile.getDeck().isEmpty() == false)
								{
									addFromCommonPile(i);
								}
							}
							else if(this.getPlayersTopCardValue(i, category) == this.getPlayersTopCardValue(j, category))
							{
								draw = true;
								System.out.println("Its a draw case");
								drawCase();
								totalNumberOfDraws++;
							}
						}
					}
				}
				
			}
		}
		winnerOfRound.incNumberOfRoundsWon();
		this.incrementTotalNumberOfRounds();
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
		int sizeOfList = playersList.getPlayers().size();
		for(int i=0; i<sizeOfList; i++)
		{
			if(playersList.getPlayers().get(i).getLost() == false)
			{
				System.out.println("\n" + playersList.getPlayers().get(i).getName());
				System.out.println(playersList.getPlayers().get(i).getPlayerDeck().getTopCard());
		
			}
		}
	}
	
	public void playRound()
	{
		previousDraw();
		roundWinner();
		System.out.println("\n"+ getWinnerOfRound() + " won the round and will choose the category of next card");
		if(draw == false)
		{
			transferCards();
		}
		 lostPlayer();
	}
	
	public void lostPlayer()
	{
		for(int i=0; i<playersList.getPlayers().size(); i++)
		{
			if(playersList.getPlayers().get(i).getPlayerDeck().getDeck().isEmpty() == true)
			{
				playersList.getPlayers().get(i).setLost(true);
			}
		}
	}

	public Players getPlayersList() {
		return playersList;
	}
	
	public void transferCards()
	{
		winnerCard =  winnerOfRound.getPlayerDeck().getDeck().get(0);
		int playersListSize = playersList.getPlayers().size();
		int tempSize =0;
		DeckOfCards temp = new DeckOfCards();
		for(int i=0; i<playersListSize; i++)
		{
			if(playersList.getPlayers().get(i).getLost() == false)
			{
				temp.addCard(playersList.getPlayers().get(i).getPlayerDeck().getDeck().get(0));
				playersList.getPlayers().get(i).getPlayerDeck().getDeck().remove(0);
			}
		}
		
		this.shuffleHand(temp);
		tempSize = temp.getDeck().size();
		for(int i=0; i<playersListSize; i++) //5
		{
			if(playersList.getPlayers().get(i).equals(winnerOfRound)) 
			{
				for(int j=0; j<tempSize; j++) //5
				{
					playersList.getPlayers().get(i).getPlayerDeck().getDeck().add(temp.getDeck().get(0));
					temp.getDeck().remove(0);
				}
			}
			
		}
	}
	public void shuffleHand(DeckOfCards cards)
	{
		Random randomInteger = new Random();
		for(int i=0; i<cards.getDeck().size(); i++)
		{
			int randomIndexPosition = randomInteger.nextInt(cards.getDeck().size());
			Card temp = cards.getDeck().get(randomIndexPosition);
			cards.getDeck().set(randomIndexPosition, cards.getDeck().get(i));
			cards.getDeck().set(i, temp);
		}
	}

	public int getTotalNumberOfDraws() {
		return totalNumberOfDraws;
	}

	public static int getGameId() {
		return gameId;
	}
	
	public int getPlayersTopCardValue(int index,int category)
	{
		return this.playersList.getPlayers().get(index).getPlayerDeck().getTopCardValue(category);
	}
	
	public boolean lastPlayerLeft()
	{
		boolean result = false; 
		int playerCount=0;
		for(int i=0; i<playersList.getPlayers().size(); i++)
		{
			if(playersList.getPlayers().get(i).getLost() == false)
			{
				playerCount++;
			}
		}
		if(playerCount==1)
		{
			System.out.println("We have a winner " + winnerOfRound.getName());
			result = true;
		}
		return result;
	}
	
	public void displayWinnerDeck()
	{
		for(int i=0; i<winnerOfRound.getPlayerDeck().getDeck().size(); i++)
		{
			System.out.println(winnerOfRound.getPlayerDeck().getDeck().get(i).toString());
		}
	}
	
	public void drawCase()
	{
		for(int i=0; i<playersList.getPlayers().size(); i++)
		{
			if(playersList.getPlayers().get(i).getLost() == false)
			{
				commonPile.addCard(playersList.getPlayers().get(i).getPlayerDeck().getDeck().get(0));
			}
		}
		for(int i=0; i<playersList.getPlayers().size(); i++)
		{
			if(playersList.getPlayers().get(i).getLost() == false)
			{
				playersList.getPlayers().get(i).getPlayerDeck().getDeck().remove(0);
			}
		}
		
	}
	public void previousDraw()
	{
		if(commonPile.getDeck().isEmpty() == false)
		{
			transferCards();
			
			for(int i=0; i<commonPile.getDeck().size(); i++)
			{
				System.out.println(commonPile.getDeck().get(i).toString());
			}
		}
	}
	public void incrementTotalNumberOfRounds()
	{
		totalNumberOfRounds++;
	}
	
	public ArrayList<String> getWinnerAttribute()
	{
		ArrayList<String> result = new ArrayList<String>(); 
		
		if(draw == false)
		{
			result.add(winnerOfRound.getName());
			result.add(winnerCard.getName());
			result.add(Integer.toString(winnerCard.getIntelligence()));
			result.add(Integer.toString(winnerCard.getSpeed()));
			result.add(Integer.toString(winnerCard.getStrength()));
			result.add(Integer.toString(winnerCard.getAgility()));
			result.add(Integer.toString(winnerCard.getCombat()));
		}
		
		
		return result;
	}
	
	public ArrayList<String> getHumanPlayerTopCardAttributes()
	{
		ArrayList<String> result = new ArrayList<String>();
		if(playersList.getPlayers().get(0).getLost() == false)
		{
			result.add(playersList.getPlayers().get(0).getPlayerDeck().getDeck().get(0).getName());
			result.add(Integer.toString(playersList.getPlayers().get(0).getPlayerDeck().getDeck().get(0).getIntelligence()));
			result.add(Integer.toString(playersList.getPlayers().get(0).getPlayerDeck().getDeck().get(0).getSpeed()));
			result.add(Integer.toString(playersList.getPlayers().get(0).getPlayerDeck().getDeck().get(0).getStrength()));
			result.add(Integer.toString(playersList.getPlayers().get(0).getPlayerDeck().getDeck().get(0).getAgility()));
			result.add(Integer.toString(playersList.getPlayers().get(0).getPlayerDeck().getDeck().get(0).getCombat()));
		}
		
		return result;
	}
	public ArrayList<Integer> getNumberOfCards()
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=0; i<playersList.getPlayers().size(); i++)	
		{
			result.add(playersList.getPlayers().get(i).getPlayerDeck().getNumberOfCards());
		}
		return result;				
	}
	
	public void addFromCommonPile(int playerIndex)
	{
		this.shuffleHand(commonPile);
		for(int k=0; k<commonPile.getDeck().size(); k++)
		{
			playersList.getPlayers().get(playerIndex).getPlayerDeck().addCard(commonPile.getDeck().get(k));
		}
	}
}
