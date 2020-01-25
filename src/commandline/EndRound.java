package commandline;

public class EndRound extends StartGame {
	boolean commonPileRequired;
	int roundNumber;
	
	public EndRound() {
		super();
		findWinner();
		displayWinningCard();
		assignRoundCards();
		updateAllCurrentCards();
	}
	
	public Player getCurrentWinner() {
		return currentWinner;
	}
	
	public void setCurrentWinner(Player p) {
		currentWinner = p;
	}
	
	@Override
	public boolean equals(Object o) {
		return (this == o);
	}

	
	public void findWinner() {
		Player chooser = getDeck().getCategoryChooser();
		System.out.println(getDeck().getCategoryChooser().getName());
		int chosenCategory = chooser.chooseCategory();
		
//		assign chosen category values to separate player ints
		int humanValue = getHuman().getCurrentCard().getValues()[chosenCategory];
		int comp1Value = getComp1().getCurrentCard().getValues()[chosenCategory];
		int comp2Value = getComp2().getCurrentCard().getValues()[chosenCategory];
		int comp3Value = getComp3().getCurrentCard().getValues()[chosenCategory];
		int comp4Value = getComp4().getCurrentCard().getValues()[chosenCategory];
		
		System.out.println(humanValue);
		System.out.println(comp1Value);
		System.out.println(comp2Value);
		System.out.println(comp3Value);
		System.out.println(comp4Value);
		
		// check which player has the highest value 
		// also update who the currentChooser is based on who wins the round
		// keep track of whether the commonPile was req. for the end of the assignRoundCards method
		if ((humanValue > comp1Value) && (humanValue > comp2Value) 
				&& (humanValue > comp3Value) && (humanValue > comp4Value)) {
			System.out.print("human");
			commonPileRequired = false;
			deck.setCategoryChooser(getHuman());
			setCurrentWinner(getHuman());
		} else if ((comp1Value > humanValue) && (comp1Value > comp2Value) 
				&& (comp1Value > comp3Value) && (comp1Value > comp4Value)) {
			System.out.print("comp1");
			commonPileRequired = false;
			deck.setCategoryChooser(getComp1());
			setCurrentWinner(getComp1());
		} else if ((comp2Value > humanValue) && (comp2Value > comp1Value) 
				&& (comp2Value > comp3Value) && (comp2Value > comp4Value)) {
			System.out.print("comp2");
			commonPileRequired = false;
			deck.setCategoryChooser(getComp2());
			setCurrentWinner(getComp2());
		} else if ((comp3Value > humanValue) && (comp3Value > comp1Value) 
				&& (comp3Value > comp2Value) && (comp3Value > comp4Value)) {
			System.out.print("comp3");
			commonPileRequired = false;
			deck.setCategoryChooser(getComp3());
			setCurrentWinner(getComp3());
		} else if ((comp4Value > humanValue) && (comp4Value > comp1Value) 
				&& (comp4Value > comp2Value) && (comp4Value > comp3Value)) {
			System.out.print("comp4");
			commonPileRequired = false;
			deck.setCategoryChooser(getComp4());
			setCurrentWinner(getComp4());
		} else { commonPileRequired = true; setCurrentWinner(dealer);}
	}
	
	// DISPLAY showing incorrect card
	// TESTING REQUIRED
	public void displayWinningCard() {
		if (!commonPileRequired) {
			System.out.println(getCurrentWinner().getName() + "\n\n");
			System.out.printf("%nWinning card:%n" + getCurrentWinner().getCurrentCard().toString());
		} else { System.out.println("The round was a draw. Cards added to the common pile.");
			}
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
	
	public void updateAllCurrentCards() {
		human.updateCurrentCard();
		comp1.updateCurrentCard();
		comp2.updateCurrentCard();
		comp3.updateCurrentCard();
		comp4.updateCurrentCard();
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
