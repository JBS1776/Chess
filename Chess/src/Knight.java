import java.awt.Color;

import javax.swing.ImageIcon;

public class Knight extends Piece implements java.io.Serializable{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 private int whitenewId = 2;
 private int blacknewId = 2;
 public Knight(int id, Color color, Position pos, ImageIcon image) {
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
	   if (y - 2 >= 0 && x + 1 < 8) {
	    Tile tile = board.getTiles()[y - 2][x + 1];
	    if (tile.getPiece() != null) {
	     Color otherCol = tile.getPiece().getColor();
	     if (!c.equals(otherCol)) {
	      this.getPath().add(tile);
	      if (tile.getPiece() instanceof King) {
	        this.getCheckPath().add(tile);
	        foundKing = true;
	      }
	      else {
	        if (!foundKing) {
	          this.getCheckPath().clear();
	          this.getCheckPath().add(t);
	        }
	      }
	     }
	     else {
	       this.getAllies().add(tile);
	     }
	    }
	    else  {
	        if (!foundKing) {
	          this.getCheckPath().clear();
	          this.getCheckPath().add(t);
	        }
	    this.getPath().add(tile);
	    }
	   }
	    if (!foundKing) {
	      this.getCheckPath().clear();
	      this.getCheckPath().add(t);
	    }
	   if (y - 1 >= 0 && x + 2 < 8) {
	    Tile tile = board.getTiles()[y - 1][x + 2];
	    if (tile.getPiece() != null) {
	     Color otherCol = tile.getPiece().getColor();
	     if (!c.equals(otherCol)) {
	      this.getPath().add(tile);
	      if (tile.getPiece() instanceof King) {
	        this.getCheckPath().add(tile);
	        foundKing = true;
	      }
	      else {
	        if (!foundKing) {
	          this.getCheckPath().clear();
	          this.getCheckPath().add(t);
	        }
	      }
	     }
	     else {
	       this.getAllies().add(tile);
	     }
	    }
	    else {
	        if (!foundKing) {
	          this.getCheckPath().clear();
	          this.getCheckPath().add(t);
	        }
	    this.getPath().add(tile);
	    }
	   }
	    if (!foundKing) {
	      this.getCheckPath().clear();
	      this.getCheckPath().add(t);
	    }
	   if (y + 1 < 8 && x + 2 < 8) {
	    Tile tile = board.getTiles()[y + 1][x + 2];
	    if (tile.getPiece() != null) {
	     Color otherCol = tile.getPiece().getColor();
	     if (!c.equals(otherCol)) {
	      this.getPath().add(tile);
	      if (tile.getPiece() instanceof King) {
	        this.getCheckPath().add(tile);
	        foundKing = true;
	      }
	      else {
	        if (!foundKing) {
	          this.getCheckPath().clear();
	          this.getCheckPath().add(t);
	        }
	      }
	     }
	     else {
	       this.getAllies().add(tile);
	     }
	    }
	    else {
	     if (!foundKing) {
	        this.getCheckPath().clear();
	        this.getCheckPath().add(t);
	     }
	    this.getPath().add(tile);
	    }
	   }
	    if (!foundKing) {
	      this.getCheckPath().clear();
	      this.getCheckPath().add(t);
	    }
	   if (y + 2 < 8 && x + 1 < 8) {
	    Tile tile = board.getTiles()[y + 2][x + 1];
	    if (tile.getPiece() != null) {
	     Color otherCol = tile.getPiece().getColor();
	     if (!c.equals(otherCol)) {
	      this.getPath().add(tile);
	      if (tile.getPiece() instanceof King) {
	        this.getCheckPath().add(tile);
	        foundKing = true;
	      }
	      else {
	        if (!foundKing) {
	          this.getCheckPath().clear();
	          this.getCheckPath().add(t);
	        }
	      }
	     }
	     else {
	       this.getAllies().add(tile);
	     }
	    }
	    else {
	        if (!foundKing) {
	          this.getCheckPath().clear();
	          this.getCheckPath().add(t);
	        }
	    this.getPath().add(tile);
	    }
	   }
	    if (!foundKing) {
	      this.getCheckPath().clear();
	      this.getCheckPath().add(t);
	    }
	   if (y + 2 < 8 && x - 1 >= 0) {
	    Tile tile = board.getTiles()[y + 2][x - 1];
	    if (tile.getPiece() != null) {
	     Color otherCol = tile.getPiece().getColor();
	     if (!c.equals(otherCol)) {
	      this.getPath().add(tile);
	      if (tile.getPiece() instanceof King) {
	        this.getCheckPath().add(tile);
	        foundKing = true;
	      }
	      else {
	        if (!foundKing) {
	          this.getCheckPath().clear();
	          this.getCheckPath().add(t);
	        }
	      }
	     }
	     else {
	       this.getAllies().add(tile);
	     }
	    }
	    else {
	        if (!foundKing) {
	          this.getCheckPath().clear();
	          this.getCheckPath().add(t);
	        }
	    this.getPath().add(tile);
	    }
	   }
	    if (!foundKing) {
	      this.getCheckPath().clear();
	      this.getCheckPath().add(t);
	    }
	   if (y + 1 < 8 && x - 2 >= 0) {
	    Tile tile = board.getTiles()[y + 1][x - 2];
	    if (tile.getPiece() != null) {
	     Color otherCol = tile.getPiece().getColor();
	     if (!c.equals(otherCol)) {
	      this.getPath().add(tile);
	      if (tile.getPiece() instanceof King) {
	        this.getCheckPath().add(tile);
	        foundKing = true;
	      }
	      else {
	        if (!foundKing) {
	          this.getCheckPath().clear();
	          this.getCheckPath().add(t);
	        }
	      }
	     }
	     else {
	       this.getAllies().add(tile);
	     }
	    }
	    else {
	     if (!foundKing) {
	       this.getCheckPath().clear();
	       this.getCheckPath().add(t);
	     }
	    this.getPath().add(tile);
	    }
	   }
	    if (!foundKing) {
	      this.getCheckPath().clear();
	      this.getCheckPath().add(t);
	    }
	   if (y - 1 >= 0 && x - 2 >= 0) {
	    Tile tile = board.getTiles()[y - 1][x - 2];
	    if (tile.getPiece() != null) {
	     Color otherCol = tile.getPiece().getColor();
	     if (!c.equals(otherCol)) {
	      this.getPath().add(tile);
	      if (tile.getPiece() instanceof King) {
	        this.getCheckPath().add(tile);
	        foundKing = true;
	      }
	      else {
	        if (!foundKing) {
	          this.getCheckPath().clear();
	          this.getCheckPath().add(t);
	        }
	      }
	     }
	     else {
	       this.getAllies().add(tile);
	     }
	    }
	    else {
	        if (!foundKing) {
	          this.getCheckPath().clear();
	          this.getCheckPath().add(t);
	        }
	    this.getPath().add(tile);
	    }
	   }
	    if (!foundKing) {
	      this.getCheckPath().clear();
	      this.getCheckPath().add(t);
	    }
	   if (y - 2 >= 0 && x - 1 >= 0) {
	    Tile tile = board.getTiles()[y - 2][x - 1];
	    if (tile.getPiece() != null) {
	     Color otherCol = tile.getPiece().getColor();
	     if (!c.equals(otherCol)) {
	      this.getPath().add(tile);
	      if (tile.getPiece() instanceof King) {
	        this.getCheckPath().add(tile);
	        foundKing = true;
	      }
	      else {
	        if (!foundKing) {
	          this.getCheckPath().clear();
	          this.getCheckPath().add(t);
	        }
	      }
	     }
	     else {
	       this.getAllies().add(tile);
	     }
	    }
	    else {
	        if (!foundKing) {
	          this.getCheckPath().clear();
	          this.getCheckPath().add(t);
	        }
	    this.getPath().add(tile);
	    }
	   }
	    if (!foundKing) {
	      this.getCheckPath().clear();
	     }
	    board.getCheckPaths().put(this, this.getCheckPath());
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