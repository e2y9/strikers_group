package commandline;

public class TopTrumpsCLIApplication {

	public static void main(String[] args) {
		boolean userWantsToQuit = false;
		
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
		
		 while(game.lastPlayerLeft() == false)
		 {
			 if(userWantsToQuit == false)
			 {
				 game.playRound();
				 game.transferCards();
				 game.lostPlayer();
			 }
			 else
			 {
				 System.out.println("Thank you for Playing the game.");
			 }
		 }

	}
}
