import java.awt.Color;

import javax.swing.ImageIcon;

public class Bishop extends Piece implements java.io.Serializable{
 /**
	 * 
	 */
 private static final long serialVersionUID = 1L;
 private int whitenewId = 2;
 private int blacknewId = 2;
 private int kingDirection = -1;
 public Bishop(int id, Color color, Position pos, ImageIcon image) {
	 super(id, color, pos, image);
 }
 public void setPath(Game g, Tile t) {
	  Board board = g.getBoard();
	  Color c = this.getColor();
	  this.getPath().clear();
	  int x = t.getPosition().getX();
	  int y = t.getPosition().getY();
	  this.getPath().add(t);
	  this.getCheckPath().clear();
	  this.getCheckPath().add(t);
	  this.getAllies().clear();
	  boolean foundKing = false;
	  this.kingDirection = -1;
	  while(y > 0 && x > 0) {
	   y -= 1;
	   x -= 1;
	   Tile til = board.getTiles()[y][x];
	   if (til.getPiece() != null) {
	    Color otherCol = til.getPiece().getColor();
	    if (!c.equals(otherCol)) {
	     this.getPath().add(til);
	     if (til.getPiece() instanceof King) {
	       this.getCheckPath().add(til);
	       foundKing = true;
	       this.kingDirection = 3;
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
	    this.getCheckPath().add(til);
	   }
	  }
	    if (!foundKing) {
	       this.getCheckPath().clear();
	       this.getCheckPath().add(t);
	    }
	  y = t.getPosition().getY();
	  x = t.getPosition().getX();
	  while(x < 7 && y > 0) {
	   x += 1;
	   y -= 1;
	   Tile til = board.getTiles()[y][x];
	   if (til.getPiece() != null) {
	    Color otherCol = til.getPiece().getColor();
	    if (!c.equals(otherCol)) {
	     this.getPath().add(til);
	     if (til.getPiece() instanceof King) {
	       this.getCheckPath().add(til);
	       foundKing = true;
	       this.kingDirection = 0;
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
	  y = t.getPosition().getY();
	  while(y < 7 && x > 0) {
	   y += 1;
	   x -= 1;
	   Tile til = board.getTiles()[y][x];
	   if (til.getPiece() != null) {
	    Color otherCol = til.getPiece().getColor();
	    if (!c.equals(otherCol)) {
	     this.getPath().add(til);
	     if (til.getPiece() instanceof King) {
	       this.getCheckPath().add(til);
	       foundKing = true;
	       this.kingDirection = 2;
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
	  x = t.getPosition().getX();
	  while (x < 7 && y < 7) {
	   x += 1;
	   y += 1;
	   Tile til = board.getTiles()[y][x];
	   if (til.getPiece() != null) {
	    Color otherCol = til.getPiece().getColor();
	    if (!c.equals(otherCol)) {
	     this.getPath().add(til);
	     if (til.getPiece() instanceof King) {
	       this.getCheckPath().add(til);
	       foundKing = true;
	       this.kingDirection = 1;
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
void furtherReducePath(Game g) {
	   int currTurn = g.getTurnCount() % 2;
	   Board currBoard = g.getBoard();
	  if (kingDirection >= 0) {
	    int x = currBoard.getKingButton()[currTurn].getPosition().getX();
	    int y = currBoard.getKingButton()[currTurn].getPosition().getY();
	    switch(kingDirection) {
	      case 0 : {
	        if (x + 1 < 8 && y - 1 >= 0) {
	          if (currBoard.getKingButton()[currTurn].getPiece().getPath().contains(currBoard.getTiles()[y - 1][x + 1])) {
	            currBoard.getKingButton()[currTurn].getPiece().getPath().remove(currBoard.getTiles()[y - 1][x + 1]);
	          }
	        }
	        break;
	      }
	      case 1 : {
	        if (x + 1 < 8 && y + 1 < 8) {
	          if (currBoard.getKingButton()[currTurn].getPiece().getPath().contains(currBoard.getTiles()[y + 1][x + 1])) {
	            currBoard.getKingButton()[currTurn].getPiece().getPath().remove(currBoard.getTiles()[y + 1][x + 1]);
	          }
	        }
	        break;
	      }
	      case 2 : {
	        if (x - 1 >= 0 && y + 1 < 8)
	          if (currBoard.getKingButton()[currTurn].getPiece().getPath().contains(currBoard.getTiles()[y + 1][x - 1])) {
	            currBoard.getKingButton()[currTurn].getPiece().getPath().remove(currBoard.getTiles()[y + 1][x - 1]);
	          }
	        break;
	      }
	      case 3 : {
	        if (x - 1 >= 0 && y - 1 >= 0) {
	          if (currBoard.getKingButton()[currTurn].getPiece().getPath().contains(currBoard.getTiles()[y - 1][x - 1])) {
	            currBoard.getKingButton()[currTurn].getPiece().getPath().remove(currBoard.getTiles()[y - 1][x - 1]);
	          }
	        }
	        break;
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