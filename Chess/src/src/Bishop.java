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
 public Bishop(int id, Color color, Position pos, ImageIcon image, String name) {
  setId(id);
  setColor(color);
  setPosition(pos);
  setImage(image);
  setName(name);
 }
 public void setPath(Game g, Tile t) {
	  Board board = g.getBoard();
	  Color c = this.getColor();
	  this.path.clear();
	  int x = t.getPosition().getX();
	  int y = t.getPosition().getY();
	  this.path.add(t);
	  this.checkPath.clear();
	  this.checkPath.add(t);
	  this.allies.clear();
	  boolean foundKing = false;
	  this.kingDirection = -1;
	  while(y > 0 && x > 0) {
	   y -= 1;
	   x -= 1;
	   Tile til = board.tiles[y][x];
	   if (til.getPiece() != null) {
	    Color otherCol = til.getPiece().getColor();
	    if (!c.equals(otherCol)) {
	     this.path.add(til);
	     if (til.getPiece() instanceof King) {
	       this.checkPath.add(til);
	       foundKing = true;
	       this.kingDirection = 3;
	     }
	     else {
	       if (!foundKing) {
	         this.checkPath.clear();
	         this.checkPath.add(t);
	       }
	     }
	     break;
	    }
	    else {
	       if (!foundKing) {
	         this.checkPath.clear();
	         this.checkPath.add(t);
	       }
	       this.allies.add(til);
	     break;
	    }
	   }
	   else {
	       if (!foundKing) {
	         this.checkPath.add(til);
	       }
	    this.path.add(til);
	   }
	  }
	    if (!foundKing) {
	       this.checkPath.clear();
	       this.checkPath.add(t);
	    }
	  y = t.getPosition().getY();
	  x = t.getPosition().getX();
	  while(x < 7 && y > 0) {
	   x += 1;
	   y -= 1;
	   Tile til = board.tiles[y][x];
	   if (til.getPiece() != null) {
	    Color otherCol = til.getPiece().getColor();
	    if (!c.equals(otherCol)) {
	     this.path.add(til);
	     if (til.getPiece() instanceof King) {
	       this.checkPath.add(til);
	       foundKing = true;
	       this.kingDirection = 0;
	     }
	     else {
	       if (!foundKing) {
	         this.checkPath.clear();
	         this.checkPath.add(t);
	       }
	     }
	     break;
	    }
	    else {
	       if (!foundKing) {
	         this.checkPath.clear();
	         this.checkPath.add(t);
	       }
	     this.allies.add(til);
	     break;
	    }
	   }
	   else {
	       if (!foundKing) {
	         this.checkPath.add(til);
	       }
	    this.path.add(til);
	   }
	  }
	    if (!foundKing) {
	       this.checkPath.clear();
	       this.checkPath.add(t);
	    }
	  x = t.getPosition().getX();
	  y = t.getPosition().getY();
	  while(y < 7 && x > 0) {
	   y += 1;
	   x -= 1;
	   Tile til = board.tiles[y][x];
	   if (til.getPiece() != null) {
	    Color otherCol = til.getPiece().getColor();
	    if (!c.equals(otherCol)) {
	     this.path.add(til);
	     if (til.getPiece() instanceof King) {
	       this.checkPath.add(til);
	       foundKing = true;
	       this.kingDirection = 2;
	     }
	     else {
	       if (!foundKing) {
	         this.checkPath.clear();
	         this.checkPath.add(t);
	       }
	     }
	     break;
	    }
	    else {
	       if (!foundKing) {
	         this.checkPath.clear();
	         this.checkPath.add(t);
	       }
	     this.allies.add(til);
	     break;
	    }
	   }
	   else {
	       if (!foundKing) {
	         this.checkPath.add(til);
	       }
	    this.path.add(til);
	   }
	  }
	    if (!foundKing) {
	       this.checkPath.clear();
	       this.checkPath.add(t);
	    }
	  y = t.getPosition().getY();
	  x = t.getPosition().getX();
	  while (x < 7 && y < 7) {
	   x += 1;
	   y += 1;
	   Tile til = board.tiles[y][x];
	   if (til.getPiece() != null) {
	    Color otherCol = til.getPiece().getColor();
	    if (!c.equals(otherCol)) {
	     this.path.add(til);
	     if (til.getPiece() instanceof King) {
	       this.checkPath.add(til);
	       foundKing = true;
	       this.kingDirection = 1;
	     }
	     else {
	       if (!foundKing) {
	         this.checkPath.clear();
	         this.checkPath.add(t);
	       }
	     }
	     break;
	    }
	    else {
	       if (!foundKing) {
	         this.checkPath.clear();
	         this.checkPath.add(t);
	       }
	     this.allies.add(til);
	     break;
	    }
	   }
	   else {
	     if (!foundKing) {
	       this.checkPath.add(til);
	     }
	    this.path.add(til);
	   }
	  }
	  if (!foundKing) {
	    this.checkPath.clear();
	  }
	  board.checkPaths.put(this, this.checkPath);
	 }
 public void furtherReducePath(Game g) {
	   int currTurn = g.getTurnCount() % 2;
	   Board currBoard = g.getBoard();
	  if (kingDirection >= 0) {
	    int x = currBoard.kingsButton[currTurn].getPosition().getX();
	    int y = currBoard.kingsButton[currTurn].getPosition().getY();
	    switch(kingDirection) {
	      case 0 : {
	        if (x + 1 < 8 && y - 1 >= 0) {
	          if (currBoard.kingsButton[currTurn].getPiece().getPath().contains(currBoard.tiles[y - 1][x + 1])) {
	            currBoard.kingsButton[currTurn].getPiece().getPath().remove(currBoard.tiles[y - 1][x + 1]);
	          }
	        }
	        break;
	      }
	      case 1 : {
	        if (x + 1 < 8 && y + 1 < 8) {
	          if (currBoard.kingsButton[currTurn].getPiece().getPath().contains(currBoard.tiles[y + 1][x + 1])) {
	            currBoard.kingsButton[currTurn].getPiece().getPath().remove(currBoard.tiles[y + 1][x + 1]);
	          }
	        }
	        break;
	      }
	      case 2 : {
	        if (x - 1 >= 0 && y + 1 < 8)
	          if (currBoard.kingsButton[currTurn].getPiece().getPath().contains(currBoard.tiles[y + 1][x - 1])) {
	            currBoard.kingsButton[currTurn].getPiece().getPath().remove(currBoard.tiles[y + 1][x - 1]);
	          }
	        break;
	      }
	      case 3 : {
	        if (x - 1 >= 0 && y - 1 >= 0) {
	          if (currBoard.kingsButton[currTurn].getPiece().getPath().contains(currBoard.tiles[y - 1][x - 1])) {
	            currBoard.kingsButton[currTurn].getPiece().getPath().remove(currBoard.tiles[y - 1][x - 1]);
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