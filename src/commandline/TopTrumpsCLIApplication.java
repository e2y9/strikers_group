package commandline;

import java.util.Scanner;

public class TopTrumpsCLIApplication {

	public static void main(String[] args) {
		boolean userWantsToQuit = false;
		int choice = 0;
		
		
		GameLogic game = new GameLogic(4);
		Scanner s = new Scanner(System.in);
		
		
		 System.out.print("Welcome to Top Trumps!\n");
		 
		 game.shuffleDeck();
		 game.dealDeck();
//		 
//		 try {
//			 System.out.println("Press 1 to Start Game\nPress 2 to Show Statistics");
//			 choice = s.nextInt();
//			 if(choice==1)
//			 {
				 while(game.lastPlayerLeft() == false)
				 {
					 if(userWantsToQuit == false)
					 {
//						 game.getPlayersList().getPlayers().get(0).getPlayerDeck().displayDeck();
						 game.displayAllPLayersTopCard();
						 game.playRound();
//						 game.displayAllPLayersTopCard();
					 }
					 else
					 {
						 System.out.println("Thank you for Playing the game.");
					 }
				 }
			}
//			 else if(choice == 2)
//			 {
//				 System.out.println("In stats");
//			 }
//			 
//		  } catch (Exception e) {
//			  System.out.println("Please enter 1 or 2.");
//		 
//		  }
//	}
}
