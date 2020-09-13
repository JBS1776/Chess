import java.awt.*;
import javax.swing.*;
import java.util.*;
public abstract class Piece implements java.io.Serializable{
 
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 private int id;
 private Color color;
 private Position pos;
 private Tile tile;
 private ImageIcon image;
 private String name;
 private ArrayList<Tile> path = new ArrayList<Tile>();
 private ArrayList<Tile> checkPath = new ArrayList<Tile>();
 private ArrayList<Tile> allies = new ArrayList<Tile>();
 private boolean hasMovedYet;
 public Piece(int id, Color color, Position pos, ImageIcon image) {
	 this.id = id;
	 this.color = color;
	 this.pos = pos;
	 this.image = image;
	 if (image != null)
		 this.name = image.getDescription();
	 }
 public Piece(int id, Color color, Position pos, ImageIcon image, boolean hasMovedYet) {
  this.id = id;
  this.color = color;
  this.pos = pos;
  this.image = image;
  this.hasMovedYet = hasMovedYet;
  this.path = new ArrayList<Tile>();
  this.checkPath = new ArrayList<Tile>();
  if (image != null)
	  this.name = image.getDescription();
 }
 public int getId() {
  return this.id;
 }
 public void setIdNum(Piece p, int i) {
  this.id = i;
 }
 public Color getColor() {
  return this.color;
 }
 public ImageIcon getImage() {
  return this.image;
 }
 public String getName() {
  return this.name;
 }
 public Tile getTile() {
  return this.tile;
 }
 public ArrayList<Tile> getPath() {
	  return this.path;
 }
 void setPath(Game g, Tile b) {
	   if (b.getPiece() instanceof Pawn) {
	     Pawn pawn = (Pawn) b.getPiece();
	     pawn.setPath(g, b);
	   }
	   if (b.getPiece() instanceof Rook) {
	     Rook rook = (Rook) b.getPiece();
	     rook.setPath(g, b);
	   }
	   if (b.getPiece() instanceof Knight) {
	     Knight knight = (Knight) b.getPiece();
	     knight.setPath(g, b);
	   }
	   if (b.getPiece() instanceof Bishop) {
	     Bishop bishop = (Bishop) b.getPiece();
	     bishop.setPath(g, b);
	   }
	   if (b.getPiece() instanceof Queen) {
	     Queen queen = (Queen) b.getPiece();
	     queen.setPath(g, b);
	   }
	   if (b.getPiece() instanceof King) {
	     King king = (King) b.getPiece();
	     king.setPath(g, b);
	   }
	 }
 public ArrayList<Tile> getCheckPath() {
	 return this.checkPath;
 }
 public ArrayList<Tile> getAllies() {
	 return this.allies;
 }
 Tile getRandTile() {
	 int rand = Constants.rand.nextInt(this.path.size());
	 if (this.path.get(rand) != null) {
	 while (this.path.get(rand).getPiece() == this) {
		 rand = Constants.rand.nextInt(this.path.size());
		 if (this.path.get(rand) == null) {
			 break;
		 }
	 }
	 }
	 return this.path.get(rand);
 }
 void furtherReducePath() {
	   if (this instanceof Rook) {
	     Rook rook = (Rook) this;
	     rook.furtherReducePath();
	   }
	   if (this instanceof Bishop) {
	     Bishop bishop = (Bishop) this;
	     bishop.furtherReducePath();
	   }
	   if (this instanceof Queen) {
	     Queen queen = (Queen) this;
	     queen.furtherReducePath();
	   } 
	 }
	int findIndex(Color color) {
		int adder = color.equals(Constants.colors[0]) ? 0 : 1;
		if (this instanceof King) {
			return adder;
		}
		if (this instanceof Queen) {
			return 2 + adder;
		}
		if (this instanceof Bishop) {
			return 4 + adder;
		}
		if (this instanceof Knight) {
			return 6 + adder;
		}
		if (this instanceof Rook) {
			return 8 + adder;
		}
		return 10 + adder;
	}
 public void setId(int i) {
  this.id = i;
 }
 public void setColor(Color c) {
  this.color = c;
 }
 public void setPosition(Position p) {
  this.pos = p;
 }
 public Position getPosition() {
   return this.pos;
 }
 public boolean getHasMoved() {
	 return this.hasMovedYet;
 }
 public void setHasMoved() {
  this.hasMovedYet = true;
 }
 public void setHasMoved(boolean val) {
	 this.hasMovedYet = val;
 }
 public void setImage(ImageIcon i) {
  this.image = i;
 }
 public void setName(String s) {
  this.name = s;
 }
 public String toString() {
  return "" + this.hasMovedYet + ", " + this.id + ", " + this.color + ", " + this.pos + ", " + this.name;
 }
}
