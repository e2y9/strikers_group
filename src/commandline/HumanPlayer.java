package commandline;

import java.util.Scanner;

public class HumanPlayer implements Player {

	  String name;


	  public HumanPlayer() {		  
	  }
	  
	  
	  @Override
	  public int chooseCategory() {
		  int catNum = 0;
		  try {
			  System.out.printf("%n%nWhat category would you like to choose?%n");
			  System.out.println("0 - Intelligence");
			  System.out.println("1 - Speed");
			  System.out.println("2 - Strength");
			  System.out.println("3 - Agility");
			  System.out.println("4 - Combat");
			  System.out.println("");
			  Scanner s = new Scanner(System.in);
			  String category = s.nextLine();
			  catNum = Integer.parseInt(category);
			  // array starts at 0, above list starts at 1, so -1
		  } catch (Exception e) {
			  System.out.println("Please enter a number between 0 and 4.");
		  }
		  return catNum;
	  }


	public String getName() {
		  return name;
	  }
	


}