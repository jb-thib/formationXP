package fr.excilys.formation.bowliwood;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
	static final int NUMBEROFTURN = 23;
	static ArrayList<Player> players;

	public Game(int nb_player) {
		players = new ArrayList<Player>(nb_player);
		fillPlayers(nb_player);
	}

	public void fillPlayers(int nb_players) {
		Scanner sc = new Scanner(System.in);
		String str;
		for (int i = 0; i < nb_players; i++) {
			System.out.println("Player " + i + " name :");
			str = sc.nextLine();
			players.add(new Player(str));
		}
	}

	public void playTurn(Player player, int turnNumber) {
		// Scanner sc = new Scanner(System.in) ;
		// int score = 0 ;
		// score = sc.nextInt() ;
		int temp;
		if (turnNumber % 2 == 0 || (turnNumber == 21 && player.getScore(turnNumber - 1) == 10)) {
			temp = 0;
		} else {
			temp = player.getScore(turnNumber - 1);
		}
		int score = 0;
		if (!(player.getSkippedScore(turnNumber))) {
			score = getScore(temp);
			if (score != 10) {
				player.setSkippedScore(false, turnNumber + 1);
			} else {
				player.setSkippedScore(false, turnNumber + 2);
				player.setSkippedScore(true, turnNumber + 1);
			}
			if (turnNumber == 21 && score + player.getScore(turnNumber - 1) >= 10) {
				player.setSkippedScore(false, turnNumber + 1);
			}

		}

		player.updateScore(score, turnNumber);
	}

	public static int getScore(int previousScore) {
		Scanner sc = new Scanner(System.in) ;
		int score=0;
		do
		{
			System.out.println("Quel score avez vous obtenu au cours de votre lancer :");
			score = sc.nextInt() ;
		}
		while(score+previousScore>10&&score<0);
		
//		int score = (int)( Math.random() * (11-previousScore));
		return score;
	}

	public static void printState(int turnNumber) {
		int sum;
		for (Player player : players) {
			sum = 0;
			System.out.print(player.getName() + "	");

			for (int i = 0; i < player.getScore().length; i++) {
				if (i % 2 == 0) {
					if (i == 22) {
						sum += player.getScore(i);
					} else {
						if (player.getScore(i) == 10) {
							sum += player.getScore()[i] + player.getNextScore(i) + player.getNextNextScore(i);
						} else {
							sum += player.getScore()[i];
						}
					}
				} else {
					if (player.getScore(i) + player.getScore(player.getPreviousTurn(i)) == 10) {
						sum += player.getScore()[i] + player.getScore(player.getNextTurn(i));
					} else {
						sum += player.getScore()[i];
					}
				}

				if (i <= turnNumber) {
					int score = player.getScore()[i];
					if(player.getSkippedScore(i))
					{
						System.out.print("-");
					}
					else if (score == 10) {
						System.out.print("X");
					} else if(i%2==1 && player.getScore(i)+player.getScore(i-1)==10 )
					{
						System.out.print("/");
					}
					else{
						System.out.print(score);
					}
				} else {
					System.out.print("-");
				}
				System.out.print(" | ");
				// if(i>0 && i%2==0){
				// System.out.print("|");
				// }
			}
			System.out.println("   ||  " + sum);
		}

	}

	public static void main(String[] args) {
		boolean done = false;
		boolean new_game= false;
		int choice = 0;
		while (!done) {
			choice = Affichage.splashScreen();
			new_game=false;
			if (choice == 1) {
				System.out.println("Enter nb of players");
				Scanner sc = new Scanner(System.in);
				int nbPlayer = 0;
				nbPlayer = sc.nextInt();
				Game g = new Game(nbPlayer);
				for (int i = 0; i < NUMBEROFTURN && !new_game; i++) {
					for (Player player : players) {
						if (!player.getSkippedScore(i)) {
							System.out.println("Tour de "+player.getName()+" :");
							System.out.println("1) lancer - 2) Afficher les règles - 3) Annuler la partie");
							choice = sc.nextInt();
							if (i < 22 || (i == 22 && player.getScore(i - 1) == 10)) {
								g.playTurn(player, i);
							}
							if(player.getScore(i)==10)
							{
								Affichage.printAnimation("Strike");
							}
							if(i%2==1 && player.getScore(i)+player.getScore(i-1)==10)
							{
								Affichage.printAnimation("Spare");
							}
							
							if (choice == 2) {
								Affichage.printHelp();
							}
							if (choice ==3)
							{
								new_game=true;
								break;
							}
							
							printState(i);
						}
					}
				}
			} else if (choice==2){
				Affichage.printHelp();
			}
			else
			{
				done=true;
			}
		}
	}

}
