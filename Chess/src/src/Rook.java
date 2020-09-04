import java.awt.Color;

import javax.swing.ImageIcon;

public class Rook extends Piece implements java.io.Serializable{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 private int whitenewId = 2;
 private int blacknewId = 2;
 private int kingDirection = -1;
 public Rook(int id, Color color, Position pos, ImageIcon image, String name, boolean hasMovedYet) {
  setId(id);
  setColor(color);
  setPosition(pos);
  setImage(image);
  setName(name);
  this.hasMovedYet = hasMovedYet;
 }
 public void setPath(Game g, Tile t) {
	  Board board = g.getBoard();
	  this.path.clear();
	  Color c = this.getColor();
	  int x = t.getPosition().getX();
	  int y = t.getPosition().getY();
	  this.path.add(t);
	  this.checkPath.clear();
	  this.checkPath.add(t);
	  this.allies.clear();
	  boolean foundKing = false;
	  while(y > 0) {
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
	  y = t.getPosition().getY();
	  while(x < 7) {
	   x += 1;
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
	    this.checkPath.add(t);
	  }
	  x = t.getPosition().getX();
	  while(y < 7) {
	   y += 1;
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
	  while (x > 0) {
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
	  }
	  board.checkPaths.put(this, this.checkPath);
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
 public void furtherReducePath(Game g) {
	   int colindex = g.getTurnCount() % 2;
	  if (kingDirection >= 0) {
	    int x = g.getBoard().kingsButton[colindex].getPosition().getX();
	    int y = g.getBoard().kingsButton[colindex].getPosition().getY();
	    switch(kingDirection) {
	      case 0 : {
	        if (y - 1 >= 0) {
	          if (g.getBoard().kingsButton[colindex].getPiece().getPath().contains(g.getBoard().tiles[y - 1][x])) {
	            g.getBoard().kingsButton[colindex].getPiece().getPath().remove(g.getBoard().tiles[y - 1][x]);
	          }
	        }
	        break;
	      }
	      case 1 : {
	        if (x + 1 < 8) {
	          if (g.getBoard().kingsButton[colindex].getPiece().getPath().contains(g.getBoard().tiles[y][x + 1])) {
	            g.getBoard().kingsButton[colindex].getPiece().getPath().remove(g.getBoard().tiles[y][x + 1]);
	          }
	        }
	        break;
	      }
	      case 2 : {
	        if (y + 1 < 8) {
	          if (g.getBoard().kingsButton[colindex].getPiece().getPath().contains(g.getBoard().tiles[y + 1][x])) {
	            g.getBoard().kingsButton[colindex].getPiece().getPath().remove(g.getBoard().tiles[y + 1][x]);
	          }
	        }
	        break;
	      }
	      case 3 : {
	        if (x - 1 >= 0) {
	          if (g.getBoard().kingsButton[colindex].getPiece().getPath().contains(g.getBoard().tiles[y][x - 1])) {
	            g.getBoard().kingsButton[colindex].getPiece().getPath().remove(g.getBoard().tiles[y][x - 1]);
	          }
	        }
	        break;
	      }
	    }
	  }
	 }
 public static void main(String[] args) {

 }
}
