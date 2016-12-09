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
	private String name ;
	
	Player(String name){
		this.name = name ;
		score = new int[21] ;
	}
	
	public void updateScore(int score, int turn){
		this.score[turn] = score ;
	}
	
	
}
