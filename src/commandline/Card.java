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
	    String card = String.format("%n%nName: %s %n%s : %d %n%s : %d %n%s : %d %n%s : %d %n%s : %d", 
	    		getName(), getCategoryIntelligence(), getIntelligence(),
	    		getCategorySpeed(), getSpeed(), getCategoryStrength(), getStrength(),
	    		getCategoryAgility(), getAgility(), getCategoryFighting(), getFighting());
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
	  
	  public String getCategoryIntelligence() {
	    return this.cardCategories[0];
	  }

	  public String getCategorySpeed() {
	    return this.cardCategories[1];
	  }

	  public String getCategoryStrength() {
	    return this.cardCategories[2];
	  }

	  public String getCategoryAgility() {
	    return this.cardCategories[3];
	  }

	  public String getCategoryFighting() {
	    return this.cardCategories[4];
	  }

	  public void fillCard(String name, int intelligence, int speed, int strength, int agility, int fighting) {
	    this.name = name;
	    this.cardValues[0] = intelligence;
	    this.cardValues[1] = speed;
	    this.cardValues[2] = strength;
	    this.cardValues[3] = agility;
	    this.cardValues[4] = fighting;
	  }


	  public String[] getCategories() {
	    return cardCategories;
	  }

	  public int[] getValues() {
	    return cardValues;
	  }


	}

