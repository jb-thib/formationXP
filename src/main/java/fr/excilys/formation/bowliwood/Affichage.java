package fr.excilys.formation.bowliwood;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;


public class Affichage {
	public static int splashScreen(){
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

		return 1;
	}
	
	public static void printHelp(){
		System.out.println("TOTO");
	}
	
}
