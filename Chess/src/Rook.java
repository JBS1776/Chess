import java.awt.Color;

import javax.swing.ImageIcon;

public class Rook extends Piece implements java.io.Serializable{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 public Rook(int id, Color color, Position pos, ImageIcon image, boolean hasMovedYet) {
  super(id, color, pos, image, hasMovedYet);
	 this.setBalance(color.equals(Constants.colors[0]) ? 5 * Constants.balanceFactor : 
		 Constants.balanceFactor * -5);
 }
void setPath(Game g, Tile t) {
	  Board board = g.getBoard();
	  this.getPath().clear();
	  Color c = this.getColor();
	  int x = t.getPosition().getX();
	  int y = t.getPosition().getY();
	  this.getPath().add(t);
	  this.getCheckPath().clear();
	  this.getCheckPath().add(t);
	  this.getAllies().clear();
	  boolean foundKing = false;
	  while(y > 0) {
	   y -= 1;
	   Tile til = board.getTiles()[y][x];
	   if (til.getPiece() != null) {
	    Color otherCol = til.getPiece().getColor();
	    if (!c.equals(otherCol)) {
	     this.getPath().add(til);
	     if (til.getPiece() instanceof King) {
	       this.getCheckPath().add(til);
	       foundKing = true;
	       this.setKingDirection(0);
	     }
	     else {
	       if (!foundKing) {
	       this.getCheckPath().clear();
	       this.getCheckPath().add(t);
	       }
	     }
	     break;
	    }
	    else {
	      if (!foundKing) {
	     this.getCheckPath().clear();
	     this.getCheckPath().add(t);
	      }
	     this.getAllies().add(til);
	     break;
	    }
	   }
	   else {
	     if (!foundKing) {
	       this.getCheckPath().add(til);
	     }
	    this.getPath().add(til);
	   }
	  }
	  if (!foundKing) {
	    this.getCheckPath().clear();
	    this.getCheckPath().add(t);
	  }
	  y = t.getPosition().getY();
	  while(x < 7) {
	   x += 1;
	   Tile til = board.getTiles()[y][x];
	   if (til.getPiece() != null) {
	    Color otherCol = til.getPiece().getColor();
	    if (!c.equals(otherCol)) {
	     this.getPath().add(til);
	     if (til.getPiece() instanceof King) {
	       this.getCheckPath().add(til);
	       foundKing = true;
	       this.setKingDirection(1);
	     }
	     else {
	       if (!foundKing) {
	         this.getCheckPath().clear();
	         this.getCheckPath().add(t);
	       }
	     }
	     break;
	    }
	    else {
	       if (!foundKing) {
	         this.getCheckPath().clear();
	         this.getCheckPath().add(t);
	       }
	     this.getAllies().add(til);
	     break;
	    }
	   }
	   else {
	     if (!foundKing) {
	       this.getCheckPath().add(til);
	     }
	    this.getPath().add(til);
	   }
	  }
	    if (!foundKing) {
	    this.getCheckPath().clear();
	    this.getCheckPath().add(t);
	  }
	  x = t.getPosition().getX();
	  while(y < 7) {
	   y += 1;
	   Tile til = board.getTiles()[y][x];
	   if (til.getPiece() != null) {
	    Color otherCol = til.getPiece().getColor();
	    if (!c.equals(otherCol)) {
	     this.getPath().add(til);
	     if (til.getPiece() instanceof King) {
	       this.getCheckPath().add(til);
	       foundKing = true;
	       this.setKingDirection(2);
	     }
	     else {
	       if (!foundKing) {
	         this.getCheckPath().clear();
	         this.getCheckPath().add(t);
	       }
	     }
	     break;
	    }
	    else {
	       if (!foundKing) {
	         this.getCheckPath().clear();
	         this.getCheckPath().add(t);
	       }
	     this.getAllies().add(til);
	     break;
	    }
	   }
	   else {
	       if (!foundKing) {
	         this.getCheckPath().add(til);
	       }
	    this.getPath().add(til);
	   }
	  }
	    if (!foundKing) {
	    this.getCheckPath().clear();
	    this.getCheckPath().add(t);
	  }
	  y = t.getPosition().getY();
	  while (x > 0) {
	   x -= 1;
	   Tile til = board.getTiles()[y][x];
	   if (til.getPiece() != null) {
	    Color otherCol = til.getPiece().getColor();
	    if (!c.equals(otherCol)) {
	     this.getPath().add(til);
	     if (til.getPiece() instanceof King) {
	       this.getCheckPath().add(til);
	       foundKing = true;
	       this.setKingDirection(3);
	     }
	     else {
	       if (!foundKing) {
	         this.getCheckPath().clear();
	         this.getCheckPath().add(t);
	       }
	     }
	     break;
	    }
	    else {
	       if (!foundKing) {
	         this.getCheckPath().clear();
	         this.getCheckPath().add(t);
	       }
	     this.getAllies().add(til);
	     break;
	    }
	   }
	   else {
	       if (!foundKing) {
	         this.getCheckPath().add(til);
	       }
	    this.getPath().add(til);
	   }
	  }
	  if (!foundKing) {
	    this.getCheckPath().clear();
	  }
	  board.getCheckPaths().put(this, this.getCheckPath());
	 }
 public void furtherReducePath(Game g) {
	   int colindex = g.getTurnCount() % 2;
	  if (this.getKingDirection() >= 0) {
	    int x = g.getBoard().getKingButton()[colindex].getPosition().getX();
	    int y = g.getBoard().getKingButton()[colindex].getPosition().getY();
	    switch(this.getKingDirection()) {
	      case 0 : {
	        if (y - 1 >= 0) {
	          if (g.getBoard().getKingButton()[colindex].getPiece().getPath().contains(g.getBoard().getTiles()[y - 1][x])) {
	            g.getBoard().getKingButton()[colindex].getPiece().getPath().remove(g.getBoard().getTiles()[y - 1][x]);
	          }
	        }
	        break;
	      }
	      case 1 : {
	        if (x + 1 < 8) {
	          if (g.getBoard().getKingButton()[colindex].getPiece().getPath().contains(g.getBoard().getTiles()[y][x + 1])) {
	            g.getBoard().getKingButton()[colindex].getPiece().getPath().remove(g.getBoard().getTiles()[y][x + 1]);
	          }
	        }
	        break;
	      }
	      case 2 : {
	        if (y + 1 < 8) {
	          if (g.getBoard().getKingButton()[colindex].getPiece().getPath().contains(g.getBoard().getTiles()[y + 1][x])) {
	            g.getBoard().getKingButton()[colindex].getPiece().getPath().remove(g.getBoard().getTiles()[y + 1][x]);
	          }
	        }
	        break;
	      }
	      case 3 : {
	        if (x - 1 >= 0) {
	          if (g.getBoard().getKingButton()[colindex].getPiece().getPath().contains(g.getBoard().getTiles()[y][x - 1])) {
	            g.getBoard().getKingButton()[colindex].getPiece().getPath().remove(g.getBoard().getTiles()[y][x - 1]);
	          }
	        }
	        break;
	      }
	    }
	  }
	 }
}
