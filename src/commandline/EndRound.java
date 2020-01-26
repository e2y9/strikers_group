package commandline;

public class EndRound extends StartGame {
	boolean commonPileRequired;
	boolean humanLastWinner;
	boolean comp1LastWinner;
	boolean comp2LastWinner;
	boolean comp3LastWinner;
	boolean comp4LastWinner;
	boolean dealerLastWinner;
	boolean isRoundOne;
	int chosenCategory;
	
	public EndRound() {
		super();
		setAWinner();
		chooseCategory();
		findWinner();
		assignRoundCards();
		updateAllCurrentCards();
	}
	
	public boolean getHumanLastWinner() {
		return humanLastWinner;
	}
	

	
	public Player getCategoryChooser() {
		return categoryChooser;
		}

	public void setCategoryChooser(Player p) {
		categoryChooser = p;
		}
	
	public void setAWinner() {
//		if (this.chosenCategory == 99) {
		this.comp1LastWinner = true;
//		}
	}

	
	public void chooseCategory() {
		// choose a category
		if (humanLastWinner = true) {
//			this.chosenCategory = getHuman().chooseCategory();
			System.out.print("test");
		} else if (comp1LastWinner = true) {
			this.chosenCategory = getComp1().chooseCompCategory();
		} else if (comp2LastWinner = true) {
			this.chosenCategory = getComp2().chooseCompCategory();
		} else if (comp3LastWinner = true) {
			this.chosenCategory = getComp3().chooseCompCategory();
		} else if (comp4LastWinner = true) {
			this.chosenCategory = getComp4().chooseCompCategory();
		}
	}

	
	public void findWinner() {
//		assign chosen category values to separate player ints
		int humanValue = getHuman().getCurrentCard().getValues()[this.chosenCategory];
		int comp1Value = getComp1().getCurrentCard().getValues()[this.chosenCategory];
		int comp2Value = getComp2().getCurrentCard().getValues()[this.chosenCategory];
		int comp3Value = getComp3().getCurrentCard().getValues()[this.chosenCategory];
		int comp4Value = getComp4().getCurrentCard().getValues()[this.chosenCategory];
		
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
			System.out.printf("%nWinning card:%n" + getHuman().getCurrentCard().toString());
			commonPileRequired = false;
			humanLastWinner = true;
			comp1LastWinner = false;
			comp2LastWinner = false;
			comp3LastWinner = false;
			comp4LastWinner = false;
			dealerLastWinner = false;
			
		} else if ((comp1Value > humanValue) && (comp1Value > comp2Value) 
				&& (comp1Value > comp3Value) && (comp1Value > comp4Value)) {
			System.out.printf("%nWinning card:%n" + getComp1().getCurrentCard().toString());
			commonPileRequired = false;
			humanLastWinner = false;
			comp1LastWinner = true;
			comp2LastWinner = false;
			comp3LastWinner = false;
			comp4LastWinner = false;
			dealerLastWinner = false;
			
		} else if ((comp2Value > humanValue) && (comp2Value > comp1Value) 
				&& (comp2Value > comp3Value) && (comp2Value > comp4Value)) {
			System.out.printf("%nWinning card:%n" + getComp2().getCurrentCard().toString());
			commonPileRequired = false;
			humanLastWinner = false;
			comp1LastWinner = false;
			comp2LastWinner = true;
			comp3LastWinner = false;
			comp4LastWinner = false;
			dealerLastWinner = false;
			
		} else if ((comp3Value > humanValue) && (comp3Value > comp1Value) 
				&& (comp3Value > comp2Value) && (comp3Value > comp4Value)) {
			System.out.printf("%nWinning card:%n" + getComp3().getCurrentCard().toString());
			commonPileRequired = false;
			humanLastWinner = false;
			comp1LastWinner = false;
			comp2LastWinner = false;
			comp3LastWinner = true;
			comp4LastWinner = false;
			
		} else if ((comp4Value > humanValue) && (comp4Value > comp1Value) 
				&& (comp4Value > comp2Value) && (comp4Value > comp3Value)) {
			System.out.printf("%nWinning card:%n" + getComp4().getCurrentCard().toString());
			commonPileRequired = false;
			humanLastWinner = false;
			comp1LastWinner = false;
			comp2LastWinner = false;
			comp3LastWinner = false;
			comp4LastWinner = true;
			dealerLastWinner = false;
			
		} else { System.out.println("The round was a draw. Cards added to the common pile.");
		commonPileRequired = true;
		humanLastWinner = false;
		comp1LastWinner = false;
		comp2LastWinner = false;
		comp3LastWinner = false;
		comp4LastWinner = false;
		dealerLastWinner = true;
		}
	}
	
	
	public void assignRoundCards() {
		int arrayPos = 100; // 100 set as it is out of bounds (testing if stmnt)
		if (dealerLastWinner) {
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
			} else if (humanLastWinner) {
				arrayPos = human.findArrayPosition();
				human.getPlayerCards()[arrayPos] = comp1.getCurrentCard();
				arrayPos++;
				human.getPlayerCards()[arrayPos] = comp2.getCurrentCard();
				arrayPos++;
				human.getPlayerCards()[arrayPos] = comp3.getCurrentCard();
				arrayPos++;
				human.getPlayerCards()[arrayPos] = comp4.getCurrentCard();
				arrayPos++;
				} else if (comp1LastWinner) {
					arrayPos = comp1.findArrayPosition();
					comp1.getPlayerCards()[arrayPos] = human.getCurrentCard();
					arrayPos++;
					comp1.getPlayerCards()[arrayPos] = comp2.getCurrentCard();
					arrayPos++;
					comp1.getPlayerCards()[arrayPos] = comp3.getCurrentCard();
					arrayPos++;
					comp1.getPlayerCards()[arrayPos] = comp4.getCurrentCard();
					arrayPos++;
				} else if (comp2LastWinner) {
						arrayPos = comp2.findArrayPosition();
						comp2.getPlayerCards()[arrayPos] = human.getCurrentCard();
						arrayPos++;
						comp2.getPlayerCards()[arrayPos] = comp1.getCurrentCard();
						arrayPos++;
						comp2.getPlayerCards()[arrayPos] = comp3.getCurrentCard();
						arrayPos++;
						comp2.getPlayerCards()[arrayPos] = comp4.getCurrentCard();
						arrayPos++;
						} else if (comp3LastWinner) {
							arrayPos = comp3.findArrayPosition();
							comp3.getPlayerCards()[arrayPos] = human.getCurrentCard();
							arrayPos++;
							comp3.getPlayerCards()[arrayPos] = comp1.getCurrentCard();
							arrayPos++;
							comp3.getPlayerCards()[arrayPos] = comp2.getCurrentCard();
							arrayPos++;
							comp3.getPlayerCards()[arrayPos] = comp4.getCurrentCard();
							arrayPos++;
							} else if (comp4LastWinner) {
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
			int startPos = 99;
			if (humanLastWinner) {
				startPos = getHuman().findArrayPosition();
				for (int i = 0; i < dealer.findArrayPosition(); i++) {
					getHuman().getPlayerCards()[startPos] = dealer.getPlayerCards()[i];
					startPos++;
					}
			} else if (comp1LastWinner) {
				startPos = getComp1().findArrayPosition();
				for (int i = 0; i < dealer.findArrayPosition(); i++) {
					getComp1().getPlayerCards()[startPos] = dealer.getPlayerCards()[i];
					startPos++;}
			} else if (comp2LastWinner) {
				startPos = getComp2().findArrayPosition();
				for (int i = 0; i < dealer.findArrayPosition(); i++) {
					getComp2().getPlayerCards()[startPos] = dealer.getPlayerCards()[i];
					startPos++;}
			} else if (comp3LastWinner) {
				startPos = getComp3().findArrayPosition();
				for (int i = 0; i < dealer.findArrayPosition(); i++) {
					getComp3().getPlayerCards()[startPos] = dealer.getPlayerCards()[i];
					startPos++;}
			} else if (comp4LastWinner) {
				startPos = getComp4().findArrayPosition();
				for (int i = 0; i < dealer.findArrayPosition(); i++) {
					getComp4().getPlayerCards()[startPos] = dealer.getPlayerCards()[i];
					startPos++;}
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
