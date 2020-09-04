import java.awt.Color;

import javax.swing.ImageIcon;

public class King extends Piece implements java.io.Serializable{
 
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 private int whitenewId = 1;
 private int blacknewId = 1;
 public King(int id, Color color, Position pos, ImageIcon image, String name, boolean hasMovedYet) {
  setId(id);
  setColor(color);
  setPosition(pos);
  setImage(image);
  setName(name);
  this.hasMovedYet = hasMovedYet;
 }
 public void setPath(Game g, Tile t) {
	  Board board = g.getBoard();
	  Color c = this.getColor();
	  this.path.clear();
	  int x = t.getPosition().getX();
	  int y = t.getPosition().getY();
	  this.path.add(t);
	  this.allies.clear();
	  if (x - 1 >= 0 && y - 1 >= 0) {
	   Tile til = board.tiles[y - 1][x - 1];
	   if (til.getPiece() != null) {
	    Color colOther = til.getPiece().getColor();
	    if (!c.equals(colOther)) {
	     this.path.add(til);
	    }
	    else {
	      this.allies.add(til);
	    }
	   }
	   else {
	    this.path.add(til);
	   }
	  }
	  if (y - 1 >= 0) {
	   Tile til = board.tiles[y - 1][x];
	   if (til.getPiece() != null) {
	    Color colOther = til.getPiece().getColor();
	    if (!c.equals(colOther)) {
	     this.path.add(til);
	    }
	    else {
	      this.allies.add(til);
	    }
	   }
	   else {
	    this.path.add(til);
	   }
	  }
	  if (x + 1 < 8 && y - 1 >= 0) {
	   Tile til = board.tiles[y - 1][x + 1];
	   if (til.getPiece() != null) {
	    Color colOther = til.getPiece().getColor();
	    if (!c.equals(colOther)) {
	     this.path.add(til);
	    }
	    else {
	      this.allies.add(til);
	    }
	   }
	   else {
	    this.path.add(til);
	   }
	  }
	  if (x - 1 >= 0) {
	   Tile til = board.tiles[y][x - 1];
	   if (til.getPiece() != null) {
	    Color colOther = til.getPiece().getColor();
	    if (!c.equals(colOther)) {
	     this.path.add(til);
	    }
	    else {
	      this.allies.add(til);
	    }
	   }
	   else {
	    this.path.add(til);
	   }
	  }
	  if (x + 1 < 8) {
	   Tile til = board.tiles[y][x + 1];
	   if (til.getPiece() != null) {
	    Color colOther = til.getPiece().getColor();
	    if (!c.equals(colOther)) {
	     this.path.add(til);
	    }
	    else {
	      this.allies.add(til);
	    }
	   }
	   else {
	    this.path.add(til);
	   }
	  }
	  if (x - 1 >= 0 && y + 1 < 8) {
	   Tile til = board.tiles[y + 1][x - 1];
	   if (til.getPiece() != null) {
	    Color colOther = til.getPiece().getColor();
	    if (!c.equals(colOther)) {
	     this.path.add(til);
	    }
	    else {
	      this.allies.add(til);
	    }
	   }
	   else {
	    this.path.add(til);
	   }
	  }
	  if (y + 1 < 8) {
	   Tile til = board.tiles[y + 1][x];
	   if (til.getPiece() != null) {
	    Color colOther = til.getPiece().getColor();
	    if (!c.equals(colOther)) {
	     this.path.add(til);
	    }
	    else {
	      this.allies.add(til);
	    }
	   }
	   else {
	    this.path.add(til);
	   }
	  }
	  if (x + 1 < 8 && y + 1 < 8) {
	   Tile til = board.tiles[y + 1][x + 1];
	   if (til.getPiece() != null) {
	    Color colOther = til.getPiece().getColor();
	    if (!c.equals(colOther)) {
	     this.path.add(til);
	    }
	    else {
	      this.allies.add(til);
	    }
	   }
	   else {
	    this.path.add(til);
	   }
	  }
	  if (!this.hasMovedYet) {
	    if (x + 3 < 8 && y >= 0 && y < 8) {
	   if (board.tiles[y][x + 1].getPiece() == null && 
	     board.tiles[y][x + 2].getPiece() == null &&
	     board.tiles[y][x + 3].getPiece() != null) {
	    Piece p = board.tiles[y][x + 3].getPiece();
	    if (p.getId() == 2 && !p.hasMovedYet) {
	     this.path.add(board.tiles[y][x + 2]);
	    }
	   }
	    }
	    if (x - 4 >= 0 && y >= 0 && y < 8) {
	   if (board.tiles[y][x - 1].getPiece() == null && 
	     board.tiles[y][x - 2].getPiece() == null &&
	     board.tiles[y][x - 3].getPiece() == null &&
	     board.tiles[y][x - 4].getPiece() != null) {
	    Piece p = board.tiles[y][x - 4].getPiece();
	    if (p.getId() == 1 && !p.hasMovedYet) {
	     this.path.add(board.tiles[y][x - 2]);
	    }
	   }    
	  }
	  }
	 }
 public int getWhiteNewId() {
   return this.whitenewId;
 }
 public int getBlackNewId() {
   return this.blacknewId;
 }
 public void setWhiteNewId(int val) {
   this.whitenewId = val;
 }
 public void setBlackNewId(int val) {
   this.blacknewId = val;
 }
 public static void main(String[] args) {

 }
}