
import java.awt.*;
import javax.swing.*;
public class Constants {
	public static final int BOARDWIDTH = 600;
	public static final int BOARDHEIGHT = 623; // If JMenu set to 623 600 otherwise
	
	public static final int TILESIZE = BOARDWIDTH / 8;
	
	public static final Color[] colors = {Color.WHITE, Color.BLACK};
	
	public static final int[] xs = {1, 2, 3, 4, 5, 6, 7, 8};
	
	public static final int[] ys = {1, 2, 3, 4, 5, 6, 7, 8};
	
	public static final Color HIGHLIGHTER = Color.PINK;
	
	public static final Color CHECKHIGHLIGHT = Color.RED;
	
	public static final Color SPECIALMOVECOL = Color.GREEN;
	
	public static final String[] names = {"sprites/BlackRook.png", "sprites/BlackKnight.png", 
			"sprites/BlackBishop.png", "sprites/BlackQueen.png", "sprites/BlackKing.png", 
			"sprites/BlackPawn.png", "sprites/WhiteRook.png", "sprites/WhiteKnight.png", 
			"sprites/WhiteBishop.png", "sprites/WhiteQueen.png", "sprites/WhiteKing.png", 
			"sprites/WhitePawn.png"};
	
	public static final ImageIcon[] blackimages = {new ImageIcon(names[0], "BlackRook"),
			 new ImageIcon(names[1], "BlackKnight"), 
			 new ImageIcon(names[2], "BlackBishop"),
			 new ImageIcon(names[3], "BlackQueen"),
			 new ImageIcon(names[4], "BlackKing"),
			 new ImageIcon(names[2], "BlackBishop"),
			 new ImageIcon(names[1], "BlackKnight"),
			 new ImageIcon(names[0], "BlackRook"),
			 new ImageIcon(names[5], "BlackPawn")};
	public static final ImageIcon[] whiteimages = {new ImageIcon(names[6], "WhiteRook"),
			 new ImageIcon(names[7], "WhiteKnight"), 
			 new ImageIcon(names[8], "WhiteBishop"),
			 new ImageIcon(names[9], "WhiteQueen"),
			 new ImageIcon(names[10], "WhiteKing"),
			 new ImageIcon(names[8], "WhiteBishop"),
			 new ImageIcon(names[7], "WhiteKnight"),
			 new ImageIcon(names[6], "WhiteRook"),
			 new ImageIcon(names[11], "WhitePawn")};

}
