import java.awt.Color;

import javax.swing.ImageIcon;

public class King extends Piece implements java.io.Serializable{
 
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 public King(int id, Color color, Position pos, ImageIcon image, boolean hasMovedYet) {
	 super(id, color, pos, image, hasMovedYet);
	 this.setBalance(color.equals(Constants.colors[0]) ? 90 * Constants.balanceFactor : 
		 Constants.balanceFactor * -90);
 }
void setPath(Game g, Tile t) {
	  Board board = g.getBoard();
	  Color c = this.getColor();
	  this.getPath().clear();
	  int x = t.getPosition().getX();
	  int y = t.getPosition().getY();
	  this.getPath().add(t);
	  this.getAllies().clear();
	  if (x - 1 >= 0 && y - 1 >= 0) {
	   Tile til = board.getTiles()[y - 1][x - 1];
	   if (til.getPiece() != null) {
	    Color colOther = til.getPiece().getColor();
	    if (!c.equals(colOther)) {
	     this.getPath().add(til);
	    }
	    else {
	      this.getAllies().add(til);
	    }
	   }
	   else {
	    this.getPath().add(til);
	   }
	  }
	  if (y - 1 >= 0) {
	   Tile til = board.getTiles()[y - 1][x];
	   if (til.getPiece() != null) {
	    Color colOther = til.getPiece().getColor();
	    if (!c.equals(colOther)) {
	     this.getPath().add(til);
	    }
	    else {
	      this.getAllies().add(til);
	    }
	   }
	   else {
	    this.getPath().add(til);
	   }
	  }
	  if (x + 1 < 8 && y - 1 >= 0) {
	   Tile til = board.getTiles()[y - 1][x + 1];
	   if (til.getPiece() != null) {
	    Color colOther = til.getPiece().getColor();
	    if (!c.equals(colOther)) {
	     this.getPath().add(til);
	    }
	    else {
	      this.getAllies().add(til);
	    }
	   }
	   else {
	    this.getPath().add(til);
	   }
	  }
	  if (x - 1 >= 0) {
	   Tile til = board.getTiles()[y][x - 1];
	   if (til.getPiece() != null) {
	    Color colOther = til.getPiece().getColor();
	    if (!c.equals(colOther)) {
	     this.getPath().add(til);
	    }
	    else {
	      this.getAllies().add(til);
	    }
	   }
	   else {
	    this.getPath().add(til);
	   }
	  }
	  if (x + 1 < 8) {
	   Tile til = board.getTiles()[y][x + 1];
	   if (til.getPiece() != null) {
	    Color colOther = til.getPiece().getColor();
	    if (!c.equals(colOther)) {
	     this.getPath().add(til);
	    }
	    else {
	      this.getAllies().add(til);
	    }
	   }
	   else {
	    this.getPath().add(til);
	   }
	  }
	  if (x - 1 >= 0 && y + 1 < 8) {
	   Tile til = board.getTiles()[y + 1][x - 1];
	   if (til.getPiece() != null) {
	    Color colOther = til.getPiece().getColor();
	    if (!c.equals(colOther)) {
	     this.getPath().add(til);
	    }
	    else {
	      this.getAllies().add(til);
	    }
	   }
	   else {
	    this.getPath().add(til);
	   }
	  }
	  if (y + 1 < 8) {
	   Tile til = board.getTiles()[y + 1][x];
	   if (til.getPiece() != null) {
	    Color colOther = til.getPiece().getColor();
	    if (!c.equals(colOther)) {
	     this.getPath().add(til);
	    }
	    else {
	      this.getAllies().add(til);
	    }
	   }
	   else {
	    this.getPath().add(til);
	   }
	  }
	  if (x + 1 < 8 && y + 1 < 8) {
	   Tile til = board.getTiles()[y + 1][x + 1];
	   if (til.getPiece() != null) {
	    Color colOther = til.getPiece().getColor();
	    if (!c.equals(colOther)) {
	     this.getPath().add(til);
	    }
	    else {
	      this.getAllies().add(til);
	    }
	   }
	   else {
	    this.getPath().add(til);
	   }
	  }
	  if (!this.getHasMoved()) {
	    if (x + 3 < 8 && y >= 0 && y < 8) {
	   if (board.getTiles()[y][x + 1].getPiece() == null && 
	     board.getTiles()[y][x + 2].getPiece() == null &&
	     board.getTiles()[y][x + 3].getPiece() != null) {
	    Piece p = board.getTiles()[y][x + 3].getPiece();
	    if (p.getId() == 2 && !p.getHasMoved()) {
	     this.getPath().add(board.getTiles()[y][x + 2]);
	    }
	   }
	    }
	    if (x - 4 >= 0 && y >= 0 && y < 8) {
	   if (board.getTiles()[y][x - 1].getPiece() == null && 
	     board.getTiles()[y][x - 2].getPiece() == null &&
	     board.getTiles()[y][x - 3].getPiece() == null &&
	     board.getTiles()[y][x - 4].getPiece() != null) {
	    Piece p = board.getTiles()[y][x - 4].getPiece();
	    if (p.getId() == 1 && !p.getHasMoved()) {
	     this.getPath().add(board.getTiles()[y][x - 2]);
	    }
	   }    
	  }
	  }
	 }
}