package commandline;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Top Trumps command line application
 */
public class TopTrumpsCLIApplication {

	/**
	 * This main method is called by TopTrumps.java when the user specifies that they want to run in
	 * command line mode. The contents of args[0] is whether we should write game logs to a file.
 	 * @param args
	 */
	public static void main(String[] args) {

		boolean writeGameLogsToFile = false; // Should we write game logs to file?
		
		// the args[0] if statement is commented-out so the program will run in the eclipse console
		
//		if (args[0].equalsIgnoreCase("true")) writeGameLogsToFile=true; // Command line selection

		// State
		boolean userWantsToQuit = false; // flag to check whether the user wants to quit the application
		
		System.out.print("\nWelcome to Top Trumps!\n");	
		StartGame game = new StartGame();
		int counter = 1;
		// Loop until the user wants to exit the game
		while ((!userWantsToQuit) || (counter < 3)) {
			StartRound startRound = new StartRound();
			EndRound endRound = new EndRound();
			counter++;
//			userWantsToQuit=true; // use this when the user wants to exit the game

		}


	}

}
