package fr.excilys.formation.bowliwood;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
	static final int NUMBEROFTURN = 21;
	static ArrayList<Player> players;

	public Game(int nb_player) {
		players = new ArrayList<Player>(nb_player) ;
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
		if(turnNumber%2==0)
		{
			temp=0;
		}
		else
		{
			temp=player.getScore(turnNumber-1);
		}
		int score = getScore(temp);
		player.updateScore(score, turnNumber);
	}

	public static int getScore(int previousScore) {
		int score = (int)( Math.random() * (11-previousScore));
		return score;
	}

	public static void printState(int turnNumber) {
		int sum;
		for (Player player : players) {
			sum=0;
			System.out.print(player.getName() + "	");
			for (int i = 0; i < player.getScore().length; i++) {
//				if(i%2==0)
//				{
//					if(i==0)
//					{
//						sum+=player.getScore(i);
//					}
//					else
//					{
//						if(player.getScore(i)==10)
//						{
//							sum+=player.getScore()[i]+player.getScore()[i+1]+player.getScore()[i+2];
//						}
//						else
//						{
//							sum+=player.getScore()[i];
//						}
//					}
//				}
//				else
//				{
//					if(player.getScore(i)==10)
//					{
//						sum+=player.getScore()[i]+player.getScore()[i+1];
//					}
//					else
//					{
//						sum+=player.getScore()[i];
//					}
//				}
				sum+=player.getScore()[i];
				if(i<=turnNumber)
				{
					System.out.print(player.getScore()[i]);
				}
				else 
				{
					System.out.print("-");
				}
				System.out.print(" | ");
			}
			System.out.println("   ||  "+sum);
		}

	}

	 public static void main (String[] args){
		// init
		System.out.println("Enter nb of players");
		Scanner sc = new Scanner(System.in) ;
		int nbPlayer = 0 ;
		nbPlayer = sc.nextInt() ;
		Game g = new Game(nbPlayer) ;
		
		int choice = Affichage.splashScreen();
		if (choice == 1) {

			for (int i = 0; i < NUMBEROFTURN; i++) {
				for (Player player : players) {
					g.playTurn(player, i);
				}
				printState(i); 
			}
		} else {
			Affichage.printHelp();
		}
	}

}
