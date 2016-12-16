package fr.excilys.formation.bowliwood;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;


public class Affichage {
	public static int splashScreen(){
		Scanner sc = new Scanner(System.in) ;
		BufferedImage image = new BufferedImage(144, 32, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setFont(new Font("Dialog", Font.PLAIN, 16));
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
		        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.drawString("!-> BowliW00d <-!", 6, 24);

		for (int y = 0; y < 32; y++) {
		    StringBuilder sb = new StringBuilder();
		    for (int x = 0; x < 144; x++)
		        sb.append(image.getRGB(x, y) == -16777216 ? " " : image.getRGB(x, y) == -1 ? "#" : "*");
		    if (sb.toString().trim().isEmpty()) continue;
		    System.out.println(sb);
		}
		System.out.println("\n\n     1) Jouer\n\n     2)Afficher les règles\n\n     3)Quitter\n\n Choix :\n");
		return sc.nextInt() ;
	}
	public static void printHelp(){
		Scanner sc = new Scanner(System.in) ;
		System.out.println("Règles :\n\nLe bowling est un jeu simple. Il consiste à renverser les 10 quilles en faisant rouler la boule sur une piste de 20 m de long.\nChaque partie comprend 10 jeux ou frames. Les participants jouent chacun leur tour. Le joueur lance 2 boules à chaque jeu et marque le nombre de points correspondant au nombre de quilles tombées.\nSi les 10 quilles tombent en deux lancers, le joueur a fait un SPARE(/); il marque 10 points plus les points du lancer suivant.\nSi les 10 Quilles tombent au premier lancer, le joueur a fait un STRIKE (X); Il marque 10 points plus les points des 2 lancés suivants.\nAu dixième jeu, si le joueur réalise un Spare ou un Strike, il bénéficie d'1 ou 2 lancer(s) supplementaire(s)\nCompte tenu de ces bonifications, le maximum de points par partie est de 300, mais un joueur débutant s’estime satisfait avec 100 points.\nUne boule pèse entre 3 à 7 kg, et l’on effectue de 13 à 21 lancers.\nBon score = 130 pour un joueur débutant, 180 pour un joueur confirmé.");
		
	}
	public static void printAnimation(String in){
		BufferedImage image = new BufferedImage(144, 32, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setFont(new Font("Dialog", Font.PLAIN, 12));
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
		        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.drawString("!->" +  in + "<-!", 6, 24);
		for (int y = 0; y < 32; y++) {
		    StringBuilder sb = new StringBuilder();
		    for (int x = 0; x < 144; x++)
		        sb.append(image.getRGB(x, y) == -16777216 ? " " : image.getRGB(x, y) == -1 ? "#" : "*");
		    if (sb.toString().trim().isEmpty()) continue;
		    System.out.println(sb);
		}
	}
}
