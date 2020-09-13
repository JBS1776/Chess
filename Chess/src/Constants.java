
import java.awt.Color;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.ImageIcon;
public class Constants implements java.io.Serializable{
  
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 public static final int FULLSCREENWIDTH = 1280;
 
 public static final int FULLSCREENHEIGHT = 800;
 
 public static final int BOARDWIDTH = 600; // Height
 
 public static final int BOARDHEIGHT = 600; // Width, If JMenu set to (BOARDWIDTH + 26) otherwise BOARDWIDTH
 
 public static final int SCREENPOSX = (FULLSCREENWIDTH - BOARDWIDTH) / 2;
 
 public static final int SCREENPOSY = (FULLSCREENHEIGHT - BOARDHEIGHT) / 4;
 
 public static final int TILEWIDTH = BOARDWIDTH / 8;
 
 public static final int TILEHEIGHT = BOARDHEIGHT / 8;
 
 public static final Color[] colors = {Color.WHITE, Color.BLACK};
 
 public static final Color GRAY = new Color(60, 60, 60);
 
 public static final Color HIGHLIGHTER = Color.PINK;
 
 public static final Color CHECKHIGHLIGHT = Color.RED;
 
 public static final Color TURNHIGHLIGHT = Color.GREEN;
 
 public static final Color CAUTIONCOLOR = Color.YELLOW;
 
 public static final Color BACKGROUNDCOL = new Color(127, 127, 127);
 
 public static final boolean isPromotionEnabled = false;
 
 public static final ArrayList<Piece>[] STARTCONFIG = null;
 
 public static final int STARTTURNCOUNT = 0;
 
 public static final boolean isKingInCheck = false;
 
 public static final boolean startCastle = false;
 
 public static final boolean isEndGame = false;
 
 public static final boolean isTimeEnabled = false;
 
 public static final boolean takeMeChess = false;
 
 public static final int TIME = 900;
 
 public static final int PieceAppearance = 0;
 
 public static final int aiLevel = 0;
 
 public static final int aiColor = 1;
 
 public static final ArrayList<LinkedList<Piece>> CAPTUREDPIECES = null;
 
 public static final ArrayList<String> MOVELIST = null;
 
 public static final Piece ENPASS = null;
 
 public static final Random rand = new Random();
 
 public static final String[][] names = {{"sprites/BlackRook.png", "sprites/BlackKnight.png", 
   "sprites/BlackBishop.png", "sprites/BlackQueen.png", "sprites/BlackKing.png", 
   "sprites/BlackPawn.png", "sprites/WhiteRook.png", "sprites/WhiteKnight.png", 
   "sprites/WhiteBishop.png", "sprites/WhiteQueen.png", "sprites/WhiteKing.png", 
   "sprites/WhitePawn.png"}, {"sprites2/BlackRook.png", "sprites2/BlackKnight.png", 
   "sprites2/BlackBishop.png", "sprites2/BlackQueen.png", "sprites2/BlackKing.png", 
   "sprites2/BlackPawn.png", "sprites2/WhiteRook.png", "sprites2/WhiteKnight.png", 
   "sprites2/WhiteBishop.png", "sprites2/WhiteQueen.png", "sprites2/WhiteKing.png", 
   "sprites2/WhitePawn.png"}, {"sprites3/BlackRook.png", "sprites3/BlackKnight.png", 
   "sprites3/BlackBishop.png", "sprites3/BlackQueen.png", "sprites3/BlackKing.png", 
   "sprites3/BlackPawn.png", "sprites3/WhiteRook.png", "sprites3/WhiteKnight.png", 
   "sprites3/WhiteBishop.png", "sprites3/WhiteQueen.png", "sprites3/WhiteKing.png", 
   "sprites3/WhitePawn.png"}};
 
 public static ImageIcon[][] images = {{new ImageIcon(names[PieceAppearance][6], "WhiteRook"),
	        new ImageIcon(names[PieceAppearance][7], "WhiteKnight"), 
	        new ImageIcon(names[PieceAppearance][8], "WhiteBishop"),
	        new ImageIcon(names[PieceAppearance][9], "WhiteQueen"),
	        new ImageIcon(names[PieceAppearance][10], "WhiteKing"),
	        new ImageIcon(names[PieceAppearance][8], "WhiteBishop"),
	        new ImageIcon(names[PieceAppearance][7], "WhiteKnight"),
	        new ImageIcon(names[PieceAppearance][6], "WhiteRook"),
	        new ImageIcon(names[PieceAppearance][11], "WhitePawn")}, {new ImageIcon(names[PieceAppearance][0], "BlackRook"),
	    	    new ImageIcon(names[PieceAppearance][1], "BlackKnight"), 
	    	    new ImageIcon(names[PieceAppearance][2], "BlackBishop"),
	    	    new ImageIcon(names[PieceAppearance][3], "BlackQueen"),
	    	    new ImageIcon(names[PieceAppearance][4], "BlackKing"),
	    	    new ImageIcon(names[PieceAppearance][2], "BlackBishop"),
	    	    new ImageIcon(names[PieceAppearance][1], "BlackKnight"),
	    	    new ImageIcon(names[PieceAppearance][0], "BlackRook"),
	    	    new ImageIcon(names[PieceAppearance][5], "BlackPawn")}};
 
 public static boolean isColorBright(Color c) {
	 // https://tech.chitgoks.com/2010/07/27/check-if-color-is-dark-or-light-using-java/
	 double red = c.getRed() * c.getRed() * 0.241;
	 double green = c.getGreen() * c.getGreen() * 0.691;
	 double blue = c.getBlue() * c.getBlue() * 0.068;
	 double sum = red + green + blue;
	 int result = (int) Math.sqrt(sum);
	 return result < 128;
 }
}
