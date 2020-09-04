import java.awt.Color;

import javax.swing.ImageIcon;

public class Knight extends Piece implements java.io.Serializable{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 private int whitenewId = 2;
 private int blacknewId = 2;
 public Knight(int id, Color color, Position pos, ImageIcon image, String name) {
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
	   if (y - 2 >= 0 && x + 1 < 8) {
	    Tile tile = board.tiles[y - 2][x + 1];
	    if (tile.getPiece() != null) {
	     Color otherCol = tile.getPiece().getColor();
	     if (!c.equals(otherCol)) {
	      this.path.add(tile);
	      if (tile.getPiece() instanceof King) {
	        this.checkPath.add(tile);
	        foundKing = true;
	      }
	      else {
	        if (!foundKing) {
	          this.checkPath.clear();
	          this.checkPath.add(t);
	        }
	      }
	     }
	     else {
	       this.allies.add(tile);
	     }
	    }
	    else  {
	        if (!foundKing) {
	          this.checkPath.clear();
	          this.checkPath.add(t);
	        }
	    this.path.add(tile);
	    }
	   }
	    if (!foundKing) {
	      this.checkPath.clear();
	      this.checkPath.add(t);
	    }
	   if (y - 1 >= 0 && x + 2 < 8) {
	    Tile tile = board.tiles[y - 1][x + 2];
	    if (tile.getPiece() != null) {
	     Color otherCol = tile.getPiece().getColor();
	     if (!c.equals(otherCol)) {
	      this.path.add(tile);
	      if (tile.getPiece() instanceof King) {
	        this.checkPath.add(tile);
	        foundKing = true;
	      }
	      else {
	        if (!foundKing) {
	          this.checkPath.clear();
	          this.checkPath.add(t);
	        }
	      }
	     }
	     else {
	       this.allies.add(tile);
	     }
	    }
	    else {
	        if (!foundKing) {
	          this.checkPath.clear();
	          this.checkPath.add(t);
	        }
	    this.path.add(tile);
	    }
	   }
	    if (!foundKing) {
	      this.checkPath.clear();
	      this.checkPath.add(t);
	    }
	   if (y + 1 < 8 && x + 2 < 8) {
	    Tile tile = board.tiles[y + 1][x + 2];
	    if (tile.getPiece() != null) {
	     Color otherCol = tile.getPiece().getColor();
	     if (!c.equals(otherCol)) {
	      this.path.add(tile);
	      if (tile.getPiece() instanceof King) {
	        this.checkPath.add(tile);
	        foundKing = true;
	      }
	      else {
	        if (!foundKing) {
	          this.checkPath.clear();
	          this.checkPath.add(t);
	        }
	      }
	     }
	     else {
	       this.allies.add(tile);
	     }
	    }
	    else {
	     if (!foundKing) {
	        this.checkPath.clear();
	        this.checkPath.add(t);
	     }
	    this.path.add(tile);
	    }
	   }
	    if (!foundKing) {
	      this.checkPath.clear();
	      this.checkPath.add(t);
	    }
	   if (y + 2 < 8 && x + 1 < 8) {
	    Tile tile = board.tiles[y + 2][x + 1];
	    if (tile.getPiece() != null) {
	     Color otherCol = tile.getPiece().getColor();
	     if (!c.equals(otherCol)) {
	      this.path.add(tile);
	      if (tile.getPiece() instanceof King) {
	        this.checkPath.add(tile);
	        foundKing = true;
	      }
	      else {
	        if (!foundKing) {
	          this.checkPath.clear();
	          this.checkPath.add(t);
	        }
	      }
	     }
	     else {
	       this.allies.add(tile);
	     }
	    }
	    else {
	        if (!foundKing) {
	          this.checkPath.clear();
	          this.checkPath.add(t);
	        }
	    this.path.add(tile);
	    }
	   }
	    if (!foundKing) {
	      this.checkPath.clear();
	      this.checkPath.add(t);
	    }
	   if (y + 2 < 8 && x - 1 >= 0) {
	    Tile tile = board.tiles[y + 2][x - 1];
	    if (tile.getPiece() != null) {
	     Color otherCol = tile.getPiece().getColor();
	     if (!c.equals(otherCol)) {
	      this.path.add(tile);
	      if (tile.getPiece() instanceof King) {
	        this.checkPath.add(tile);
	        foundKing = true;
	      }
	      else {
	        if (!foundKing) {
	          this.checkPath.clear();
	          this.checkPath.add(t);
	        }
	      }
	     }
	     else {
	       this.allies.add(tile);
	     }
	    }
	    else {
	        if (!foundKing) {
	          this.checkPath.clear();
	          this.checkPath.add(t);
	        }
	    this.path.add(tile);
	    }
	   }
	    if (!foundKing) {
	      this.checkPath.clear();
	      this.checkPath.add(t);
	    }
	   if (y + 1 < 8 && x - 2 >= 0) {
	    Tile tile = board.tiles[y + 1][x - 2];
	    if (tile.getPiece() != null) {
	     Color otherCol = tile.getPiece().getColor();
	     if (!c.equals(otherCol)) {
	      this.path.add(tile);
	      if (tile.getPiece() instanceof King) {
	        this.checkPath.add(tile);
	        foundKing = true;
	      }
	      else {
	        if (!foundKing) {
	          this.checkPath.clear();
	          this.checkPath.add(t);
	        }
	      }
	     }
	     else {
	       this.allies.add(tile);
	     }
	    }
	    else {
	     if (!foundKing) {
	       this.checkPath.clear();
	       this.checkPath.add(t);
	     }
	    this.path.add(tile);
	    }
	   }
	    if (!foundKing) {
	      this.checkPath.clear();
	      this.checkPath.add(t);
	    }
	   if (y - 1 >= 0 && x - 2 >= 0) {
	    Tile tile = board.tiles[y - 1][x - 2];
	    if (tile.getPiece() != null) {
	     Color otherCol = tile.getPiece().getColor();
	     if (!c.equals(otherCol)) {
	      this.path.add(tile);
	      if (tile.getPiece() instanceof King) {
	        this.checkPath.add(tile);
	        foundKing = true;
	      }
	      else {
	        if (!foundKing) {
	          this.checkPath.clear();
	          this.checkPath.add(t);
	        }
	      }
	     }
	     else {
	       this.allies.add(tile);
	     }
	    }
	    else {
	        if (!foundKing) {
	          this.checkPath.clear();
	          this.checkPath.add(t);
	        }
	    this.path.add(tile);
	    }
	   }
	    if (!foundKing) {
	      this.checkPath.clear();
	      this.checkPath.add(t);
	    }
	   if (y - 2 >= 0 && x - 1 >= 0) {
	    Tile tile = board.tiles[y - 2][x - 1];
	    if (tile.getPiece() != null) {
	     Color otherCol = tile.getPiece().getColor();
	     if (!c.equals(otherCol)) {
	      this.path.add(tile);
	      if (tile.getPiece() instanceof King) {
	        this.checkPath.add(tile);
	        foundKing = true;
	      }
	      else {
	        if (!foundKing) {
	          this.checkPath.clear();
	          this.checkPath.add(t);
	        }
	      }
	     }
	     else {
	       this.allies.add(tile);
	     }
	    }
	    else {
	        if (!foundKing) {
	          this.checkPath.clear();
	          this.checkPath.add(t);
	        }
	    this.path.add(tile);
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
 public static void main(String[] args) {

 }
}