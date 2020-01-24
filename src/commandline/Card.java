package commandline;

public class Card {

	  // attributes for each card
	  String name;
	  String[] cardCategories;
	  int[] cardValues;
	  
	  
	  public Card() {
		  cardCategories = new String[5];
		  cardCategories[0] = "Intelligence";
		  cardCategories[1] = "Speed";
		  cardCategories[2] = "Strength";
		  cardCategories[3] = "Agility";
		  cardCategories[4] = "Fighting";
		  cardValues = new int[5];
	  }

	  public String toString() {
	    String card = String.format("%s : %s %s %s %s %s", getName(),
	    getIntelligence(), getSpeed(), getStrength(), getAgility(), getFighting());
	    return card;
	  }

	  public String getName() {
	    return this.name;
	  }

	  public int getIntelligence() {
	    return this.cardValues[0];
	  }

	  public int getSpeed() {
	    return this.cardValues[1];
	  }

	  public int getStrength() {
	    return this.cardValues[2];
	  }

	  public int getAgility() {
	    return this.cardValues[3];
	  }

	  public int getFighting() {
	    return this.cardValues[4];
	  }

	  public void fillCard(String name, int i, int sp, int st, int a, int f) {
	    this.name = name;
	    this.cardValues[0] = i;
	    this.cardValues[1] = sp;
	    this.cardValues[2] = st;
	    this.cardValues[3] = a;
	    this.cardValues[4] = f;
	  }


	  public String[] getCategories() {
	    return cardCategories;
	  }

	  public int[] getValues() {
	    return cardValues;
	  }


	}

