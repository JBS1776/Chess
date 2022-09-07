
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.ImageIcon;
import java.net.URL;
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
 
 public static final int PieceAppearance = 0;
 
 public static final Random rand = new Random();
 
 public static final URL[][] names = {{Gamewindow.class.getResource("sprites/BlackRook.png"), Gamewindow.class.getResource("sprites/BlackKnight.png"), 
	Gamewindow.class.getResource("sprites/BlackBishop.png"), Gamewindow.class.getResource("sprites/BlackQueen.png"), Gamewindow.class.getResource("sprites/BlackKing.png"), 
	Gamewindow.class.getResource("sprites/BlackPawn.png"), Gamewindow.class.getResource("sprites/WhiteRook.png"), Gamewindow.class.getResource("sprites/WhiteKnight.png"), 
	Gamewindow.class.getResource("sprites/WhiteBishop.png"), Gamewindow.class.getResource("sprites/WhiteQueen.png"), Gamewindow.class.getResource("sprites/WhiteKing.png"), 
	Gamewindow.class.getResource("sprites/WhitePawn.png")}, {Gamewindow.class.getResource("sprites2/BlackRook.png"), Gamewindow.class.getResource("sprites2/BlackKnight.png"), 
	Gamewindow.class.getResource("sprites2/BlackBishop.png"), Gamewindow.class.getResource("sprites2/BlackQueen.png"), Gamewindow.class.getResource("sprites2/BlackKing.png"), 
	Gamewindow.class.getResource("sprites2/BlackPawn.png"), Gamewindow.class.getResource("sprites2/WhiteRook.png"), Gamewindow.class.getResource("sprites2/WhiteKnight.png"), 
	Gamewindow.class.getResource("sprites2/WhiteBishop.png"), Gamewindow.class.getResource("sprites2/WhiteQueen.png"), Gamewindow.class.getResource("sprites2/WhiteKing.png"), 
	Gamewindow.class.getResource("sprites2/WhitePawn.png")}, {Gamewindow.class.getResource("sprites3/BlackRook.png"), Gamewindow.class.getResource("sprites3/BlackKnight.png"), 
	Gamewindow.class.getResource("sprites3/BlackBishop.png"), Gamewindow.class.getResource("sprites3/BlackQueen.png"), Gamewindow.class.getResource("sprites3/BlackKing.png"), 
	Gamewindow.class.getResource("sprites3/BlackPawn.png"), Gamewindow.class.getResource("sprites3/WhiteRook.png"), Gamewindow.class.getResource("sprites3/WhiteKnight.png"), 
	Gamewindow.class.getResource("sprites3/WhiteBishop.png"), Gamewindow.class.getResource("sprites3/WhiteQueen.png"), Gamewindow.class.getResource("sprites3/WhiteKing.png"), 
	Gamewindow.class.getResource("sprites3/WhitePawn.png")}};
 
 public static String[] customFiles = {"", "", "", "", "", "", "", "", "", "", "", ""};
 
 public static final ImageIcon[][] images = {{new ImageIcon(names[PieceAppearance][6], "WhiteRook"),
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
 
 public static final int aiLevel = 0;
 
 public static final int aiColor = 1;
 
 public static final int balanceFactor = 10;
 
 public static final ArrayList<LinkedList<Piece>> CAPTUREDPIECES = null;
 
 public static final ArrayList<String> MOVELIST = null;
 
 public static final Piece ENPASS = null;
 
 public static final boolean isPromotionEnabled = false;
 
 public static final ArrayList<Piece>[] STARTCONFIG = null;
 
 public static final int STARTTURNCOUNT = 0;
 
 public static final boolean isKingInCheck = false;
 
 public static final boolean startCastle = false;
 
 public static final boolean isEndGame = false;
 
 public static final boolean isTimeEnabled = false;
 
 public static final boolean takeMeChess = false;
 
 public static final int TIME = 900;
 
 public static void main(String[] args) {
	 //System.out.println(Gamewindow.class.getResource(""));
 }
}
