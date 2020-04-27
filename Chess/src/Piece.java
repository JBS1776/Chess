import java.awt.*;
import javax.swing.*;
import java.util.*;
public abstract class Piece implements java.io.Serializable{
 
 private int id;
 private Color color;
 private Position pos;
 private Tile tile;
 private ImageIcon image;
 private String name;
 ArrayList<TileButton> path = new ArrayList<TileButton>();
 ArrayList<TileButton> checkPath = new ArrayList<TileButton>();
 ArrayList<TileButton> allies = new ArrayList<TileButton>();
 Board board = new Board();
 Color highlight = Constants.HIGHLIGHTER;
 Color special = Constants.TURNHIGHLIGHT;
 Color[] colors = Constants.colors;
 boolean hasMovedYet;
 boolean isPinned = false;
 boolean causedCheck = false;
 Random random = new Random();
 public Piece() {
  this.id = id;
  this.color = color;
  this.pos = pos;
  this.image = image;
  this.hasMovedYet = hasMovedYet;
  this.path = new ArrayList<TileButton>();
  this.checkPath = new ArrayList<TileButton>();
  this.tile = tile;
  if (image != null)
  this.name = image.getDescription();
 }
 public Piece(int id, Color color, Position pos, ImageIcon image, String name, boolean hasMovedYet) {
  this.id = id;
  this.color = color;
  this.pos = pos;
  this.image = image;
  this.hasMovedYet = hasMovedYet;
  this.path = new ArrayList<TileButton>();
  this.checkPath = new ArrayList<TileButton>();
  this.tile = tile;
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
 public ArrayList<TileButton> getPath() {
  return this.path;
 }
 public void setPath(Game g, TileButton b) {
   if (b.getTile().getPiece() instanceof Pawn) {
     Pawn pawn = (Pawn) b.getTile().getPiece();
     pawn.setPath(g, b);
   }
   if (b.getTile().getPiece() instanceof Rook) {
     Rook rook = (Rook) b.getTile().getPiece();
     rook.setPath(g, b);
   }
   if (b.getTile().getPiece() instanceof Knight) {
     Knight knight = (Knight) b.getTile().getPiece();
     knight.setPath(g, b);
   }
   if (b.getTile().getPiece() instanceof Bishop) {
     Bishop bishop = (Bishop) b.getTile().getPiece();
     bishop.setPath(g, b);
   }
   if (b.getTile().getPiece() instanceof Queen) {
     Queen queen = (Queen) b.getTile().getPiece();
     queen.setPath(g, b);
   }
   if (b.getTile().getPiece() instanceof King) {
     King king = (King) b.getTile().getPiece();
     king.setPath(g, b);
   }
 }
 public void setPath(ArrayList<TileButton> lis) {
   System.out.println(lis.get(0));
   this.path = lis;
 }
 public TileButton getRandTile() {
	 int rand = random.nextInt(this.path.size());
	 if (this.path.get(rand) != null) {
	 while (this.path.get(rand).getTile().getPiece() == this) {
		 rand = random.nextInt(this.path.size());
		 if (this.path.get(rand) == null) {
			 break;
		 }
	 }
	 }
	 return this.path.get(rand);
 }
 public void furtherReducePath() {
   Piece p = this;
   if (p instanceof Rook) {
     Rook rook = (Rook) p;
     rook.furtherReducePath();
   }
   if (p instanceof Bishop) {
     Bishop bishop = (Bishop) p;
     bishop.furtherReducePath();
   }
   if (p instanceof Queen) {
     Queen queen = (Queen) p;
     queen.furtherReducePath();
   } 
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
 public void setHasMoved() {
  this.hasMovedYet = true;
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
 public static void main(String[] args) {
  Board board = new Board();
  board.fillTiles(0, 0);
  System.out.println(board.tiles[0][0]);
  Pawn p = new Pawn(0, Color.BLACK, new Position(0, 1), Constants.images[1][0], "Test", false);
  //p.setPath(board, board.tiles[0][0]);
  System.out.println(p.getPath().size());
 }

}
