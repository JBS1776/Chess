
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

 public static int FULLSCREENWIDTH = 1280;
 
 public static int FULLSCREENHEIGHT = 800;
 
 public static final int BOARDWIDTH = 600; // Height
 
 public static final int BOARDHEIGHT = 600; // Width, If JMenu set to (BOARDWIDTH + 26) otherwise BOARDWIDTH
 
 public static int SCREENPOSX = (FULLSCREENWIDTH - BOARDWIDTH) / 2;
 
 public static int SCREENPOSY = (FULLSCREENHEIGHT - BOARDHEIGHT) / 4;
 
 public static final int TILEWIDTH = BOARDWIDTH / 8;
 
 public static final int TILEHEIGHT = BOARDHEIGHT / 8;
 
 public static final Color[] colors = {Color.WHITE, Color.BLACK};
 
 public static final Color GRAY = new Color(60, 60, 60);
 
 public static final Color HIGHLIGHTER = Color.PINK;
 
 public static final Color CHECKHIGHLIGHT = Color.RED;
 
 public static final Color TURNHIGHLIGHT = Color.GREEN;
 
 public static final Color CAUTIONCOLOR = Color.YELLOW;
 
 public static final Color BACKGROUNDCOL = new Color(127, 127, 127);
 
 public static final int MAXKINGCOUNT = 1;
 
 public static final int MAXQUEENCOUNT = 1;
 
 public static final int MAXBISHOPCOUNT = 2;
 
 public static final int MAXKNIGHTCOUNT = 2;
 
 public static final int MAXROOKCOUNT = 2;
 
 public static final int MAXPAWNCOUNT = 8;
 
 public static final int[] maxFreqs = {MAXROOKCOUNT, MAXKNIGHTCOUNT, MAXBISHOPCOUNT, MAXQUEENCOUNT, MAXKINGCOUNT, MAXPAWNCOUNT};
 
 public static int SETTING = 0;
 
 public static boolean isPromotionEnabled = false;
 
 public static ArrayList<Piece>[] STARTCONFIG = null;
 
 public static int STARTTURNCOUNT = 0;
 
 public static boolean isKingInCheck = false;
 
 public static boolean startCastle = false;
 
 public static boolean isEndGame = false;
 
 public static boolean isTimeEnabled = false;
 
 public static boolean takeMeChess = false;
 
 public static int TIME = 900;
 
 public static int PieceLook = 0;
 
 public static int aiLevel = 0;
 
 public static int aiColor = 1;
 
 public static ArrayList<LinkedList<Piece>> CAPTUREDPIECES = null;
 
 public static ArrayList<String> MOVELIST = null;
 
 public static Piece ENPASS = null;
 
 public static Random rand = new Random();
 
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
 
 public static ImageIcon[][] images = {{new ImageIcon(names[SETTING][6], "WhiteRook"),
	        new ImageIcon(names[SETTING][7], "WhiteKnight"), 
	        new ImageIcon(names[SETTING][8], "WhiteBishop"),
	        new ImageIcon(names[SETTING][9], "WhiteQueen"),
	        new ImageIcon(names[SETTING][10], "WhiteKing"),
	        new ImageIcon(names[SETTING][8], "WhiteBishop"),
	        new ImageIcon(names[SETTING][7], "WhiteKnight"),
	        new ImageIcon(names[SETTING][6], "WhiteRook"),
	        new ImageIcon(names[SETTING][11], "WhitePawn")}, {new ImageIcon(names[SETTING][0], "BlackRook"),
	    	    new ImageIcon(names[SETTING][1], "BlackKnight"), 
	    	    new ImageIcon(names[SETTING][2], "BlackBishop"),
	    	    new ImageIcon(names[SETTING][3], "BlackQueen"),
	    	    new ImageIcon(names[SETTING][4], "BlackKing"),
	    	    new ImageIcon(names[SETTING][2], "BlackBishop"),
	    	    new ImageIcon(names[SETTING][1], "BlackKnight"),
	    	    new ImageIcon(names[SETTING][0], "BlackRook"),
	    	    new ImageIcon(names[SETTING][5], "BlackPawn")}};
 
 public static boolean isColorBright(Color c) {
	 // https://tech.chitgoks.com/2010/07/27/check-if-color-is-dark-or-light-using-java/
	 double red = c.getRed() * c.getRed() * 0.241;
	 double green = c.getGreen() * c.getGreen() * 0.691;
	 double blue = c.getBlue() * c.getBlue() * 0.068;
	 double sum = red + green + blue;
	 int result = (int) Math.sqrt(sum);
	 return result < 128;
 }
 
 public static void main(String[] args) {
	 
 }
}
