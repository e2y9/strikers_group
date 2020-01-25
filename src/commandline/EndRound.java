package commandline;

public class EndRound extends StartGame {
	boolean commonPileRequired;
	
	public EndRound() {
		super();
		
	}
	
	public Player getCurrentWinner() {
		return currentWinner;
	}
	
	public void setCurrentWinner(Player p) {
		currentWinner = p;
	}
	
	public void findWinner() {
		Player chooser = getDeck().getCategoryChooser();
		int chosenCategory = 5; // initialised with 5 (out of bounds) to test the if statements below for errors
		// check who chooser is
		if (chooser == human) {
			chosenCategory = getHuman().chooseCategory(); // this will trigger a System.in user input request
		} else if (chooser == comp1) {
			chosenCategory = getComp1().chooseCategory(); // all comps trigger the comp category chooser method
		} else if (chooser == comp2) {
			chosenCategory = getComp2().chooseCategory();
		} else if (chooser == comp3) {
			chosenCategory = getComp3().chooseCategory();
		} else if (chooser == comp4) {
			chosenCategory = getComp4().chooseCategory();
		} 
		
//		assign chosen category values to each player
		int humanValue = getHuman().getCurrentCard().getValues()[chosenCategory];
		int comp1Value = getComp1().getCurrentCard().getValues()[chosenCategory];
		int comp2Value = getComp2().getCurrentCard().getValues()[chosenCategory];
		int comp3Value = getComp3().getCurrentCard().getValues()[chosenCategory];
		int comp4Value = getComp4().getCurrentCard().getValues()[chosenCategory];
		
		
		// check which player has the highest value and return that player
		// also update who the currentChooser is based on who wins the round
		if ((humanValue > comp1Value) && (humanValue > comp2Value) 
				&& (humanValue > comp3Value) && (humanValue > comp4Value)) {
			commonPileRequired = false;
			deck.setCategoryChooser(human);
			setCurrentWinner(human);
		} else if ((comp1Value > humanValue) && (comp1Value > comp2Value) 
				&& (comp1Value > comp3Value) && (comp1Value > comp4Value)) {
			commonPileRequired = false;
			deck.setCategoryChooser(comp1);
			setCurrentWinner(comp1);
		} else if ((comp2Value > humanValue) && (comp2Value > comp1Value) 
				&& (comp2Value > comp3Value) && (comp2Value > comp4Value)) {
			commonPileRequired = false;
			deck.setCategoryChooser(comp2);
			setCurrentWinner(comp2);
		} else if ((comp3Value > humanValue) && (comp3Value > comp1Value) 
				&& (comp3Value > comp2Value) && (comp3Value > comp4Value)) {
			commonPileRequired = false;
			deck.setCategoryChooser(comp3);
			setCurrentWinner(comp3);
		} else if ((comp4Value > humanValue) && (comp4Value > comp1Value) 
				&& (comp4Value > comp2Value) && (comp4Value > comp3Value)) {
			commonPileRequired = false;
			deck.setCategoryChooser(comp4);
			setCurrentWinner(comp4);
		} else { commonPileRequired = true; setCurrentWinner(dealer);}
	}
	
	public void assignDealerCards() {
		
//		same but with dealer cards loaded into an array and then loaded into new array
	}
	
	public void assignRoundCards() {
		int arrayPos = 100; // 100 set as it is out of bounds (testing if stmnt)
		if (getCurrentWinner() == dealer) {
			arrayPos = dealer.findArrayPosition();
			dealer.getPlayerCards()[arrayPos] = human.getCurrentCard();
			arrayPos++;
			dealer.getPlayerCards()[arrayPos] = comp1.getCurrentCard();
			arrayPos++;
			dealer.getPlayerCards()[arrayPos] = comp2.getCurrentCard();
			arrayPos++;
			dealer.getPlayerCards()[arrayPos] = comp3.getCurrentCard();
			arrayPos++;
			dealer.getPlayerCards()[arrayPos] = comp4.getCurrentCard();
			} else if (getCurrentWinner() == human) {
				arrayPos = human.findArrayPosition();
				human.getPlayerCards()[arrayPos] = comp1.getCurrentCard();
				arrayPos++;
				human.getPlayerCards()[arrayPos] = comp2.getCurrentCard();
				arrayPos++;
				human.getPlayerCards()[arrayPos] = comp3.getCurrentCard();
				arrayPos++;
				human.getPlayerCards()[arrayPos] = comp4.getCurrentCard();
				arrayPos++;
				} else if (getCurrentWinner() == comp1) {
					arrayPos = comp1.findArrayPosition();
					comp1.getPlayerCards()[arrayPos] = human.getCurrentCard();
					arrayPos++;
					comp1.getPlayerCards()[arrayPos] = comp2.getCurrentCard();
					arrayPos++;
					comp1.getPlayerCards()[arrayPos] = comp3.getCurrentCard();
					arrayPos++;
					comp1.getPlayerCards()[arrayPos] = comp4.getCurrentCard();
					arrayPos++;
				} else if (getCurrentWinner() == comp2) {
						arrayPos = comp2.findArrayPosition();
						comp2.getPlayerCards()[arrayPos] = human.getCurrentCard();
						arrayPos++;
						comp2.getPlayerCards()[arrayPos] = comp1.getCurrentCard();
						arrayPos++;
						comp2.getPlayerCards()[arrayPos] = comp3.getCurrentCard();
						arrayPos++;
						comp2.getPlayerCards()[arrayPos] = comp4.getCurrentCard();
						arrayPos++;
						} else if (getCurrentWinner() == comp3) {
							arrayPos = comp3.findArrayPosition();
							comp3.getPlayerCards()[arrayPos] = human.getCurrentCard();
							arrayPos++;
							comp3.getPlayerCards()[arrayPos] = comp1.getCurrentCard();
							arrayPos++;
							comp3.getPlayerCards()[arrayPos] = comp2.getCurrentCard();
							arrayPos++;
							comp3.getPlayerCards()[arrayPos] = comp4.getCurrentCard();
							arrayPos++;
							} else if (getCurrentWinner() == comp4) {
								arrayPos = comp4.findArrayPosition();
								comp4.getPlayerCards()[arrayPos] = human.getCurrentCard();
								arrayPos++;
								comp4.getPlayerCards()[arrayPos] = comp1.getCurrentCard();
								arrayPos++;
								comp4.getPlayerCards()[arrayPos] = comp2.getCurrentCard();
								arrayPos++;
								comp4.getPlayerCards()[arrayPos] = comp3.getCurrentCard();
								arrayPos++;
							}
		
		if ((!commonPileRequired) && (dealer.getPlayerCards()[0] != null)) {
			int startPos = getCurrentWinner().findArrayPosition();
			for (int i = 0; i < dealer.findArrayPosition(); i++) {
				getCurrentWinner().getPlayerCards()[startPos] = dealer.getPlayerCards()[i];
				startPos++;
				}
			}
		}
	
    public Player getHuman() {
    	return human;
    }
    
    public Player getComp1() {
    	return comp1;
    }
    
    public Player getComp2() {
    	return comp2;
    }
    
    public Player getComp3() {
    	return comp3;
    }
    
    public Player getComp4() {
    	return comp4;
    }
    
    public Player getDealer() {
    	return dealer;
    }
    
    public Deck getDeck() {
    	return deck;
    }

}
