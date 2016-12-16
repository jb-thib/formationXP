package fr.excilys.formation.bowliwood;

public class Player {
	public final int[] getScore() {
		return score;
	}
	public final int getScore(int i) {
		return score[i];
	}
	public final void setScore(int[] score) {
		this.score = score;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	private int[] score ;
	private boolean[] skippedScore ;
	private String name ;
	
	Player(String name){
		this.name = name ;
		this.skippedScore = new boolean[23];
		score = new int[23] ;
		for (int i = 0; i < score.length; i++) {
			score[i] = 0 ;
			skippedScore[i] = true;
		}
		skippedScore[0]=false;
	}
	
	public boolean getSkippedScore(int i) {
		return skippedScore[i];
	}
	public void setSkippedScore(boolean skippedScore, int i) {
		this.skippedScore[i] = skippedScore;
	}
	public void updateScore(int score, int turn){
		this.score[turn] = score ;
	}
	public int getNextTurn(int turnNumber){
		int i=turnNumber+1;
		while(i<skippedScore.length-1 && skippedScore[i])
		{
			i++;
		}
		return i;
	}
	public int getNextScore(int turnNumber){
		int i=turnNumber+1;
		while(i<skippedScore.length && skippedScore[i])
		{
			i++;
		}
		if(i==skippedScore.length)
			return 0;
		else
			return score[i];
	}
	public int getNextNextScore(int turnNumber){
		int i=getNextTurn(turnNumber)+1;
		while(i<skippedScore.length && skippedScore[i])
		{
			i++;
		}
		if(i==skippedScore.length)
			return 0;
		else
			return score[i];
	}
	public int getPreviousTurn(int turnNumber){
		int i=turnNumber-1;
		while( i>0 && skippedScore[i])
		{
			i--;
		}
		return i;
	}
	
}
