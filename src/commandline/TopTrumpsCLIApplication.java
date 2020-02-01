package commandline;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TopTrumpsCLIApplication {

	public static void main(String[] args) {
		
		Players players = new Players();
		Player p1 = new HumanPlayer("Ashwin");
		Player p2 = new CompPlayer("AI 1");
		Player p3 = new CompPlayer("AI 2");
		Player p4 = new CompPlayer("AI 3");
		Player p5 = new CompPlayer("AI 4");

		players.addPlayer(p1);
		players.addPlayer(p2);
		players.addPlayer(p3);
		players.addPlayer(p4);
		players.addPlayer(p5);
		
		GameLogic game = new GameLogic(players);
		
		 System.out.print("Welcome to Top Trumps!\n");
		 
		 game.shuffleDeck();
		 game.dealDeck();
//		 game.printDeck();
		 System.out.println("Player 1 deck");
		 p1.getPlayerDeck().displayDeck();
		 game.displayAllPLayersTopCard();
		 
		 
		 while(game.getPlayersList().getPlayers().size()!= 1)
		 {
			 game.playRound();
			 game.transferCards();
			 game.lostPlayer();
			 game.displayAllPLayersTopCard();
			 
		 }
		 

	}

}
