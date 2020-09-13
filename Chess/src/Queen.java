import java.awt.Color;
import javax.swing.ImageIcon;

public class Queen extends Piece implements java.io.Serializable{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int whitenewId = 1;
 private int blacknewId = 1;
 private int kingDirection = -1;
 public Queen(int id, Color color, Position pos, ImageIcon image) {
	 super(id, color, pos, image);
 }
 public void setPath(Game g, Tile t) {
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
	       this.kingDirection = 7;
	     }
	     else {
	       if (!foundKing) {
	         this.getCheckPath().clear();
	       }
	     }
	     break;
	    }
	    else {
	       if (!foundKing) {
	         this.getCheckPath().clear();
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
	       this.kingDirection = 1;
	     }
	     else {
	       if (!foundKing) {
	         this.getCheckPath().clear();
	       }
	     }
	     break;
	    }
	    else {
	       if (!foundKing) {
	         this.getCheckPath().clear();
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
	       this.kingDirection = 5;
	     }
	     else {
	       if (!foundKing) {
	         this.getCheckPath().clear();
	       }
	     }
	     break;
	    }
	    else {
	       if (!foundKing) {
	         this.getCheckPath().clear();
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
	       this.kingDirection = 3;
	     }
	     else {
	       if (!foundKing) {
	         this.getCheckPath().clear();
	       }
	     }
	     break;
	    }
	    else {
	       if (!foundKing) {
	         this.getCheckPath().clear();
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
	  y = t.getPosition().getY();
	  x = t.getPosition().getX();
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
	       this.kingDirection = 0;
	     }
	     else {
	       if (!foundKing) {
	         this.getCheckPath().clear();
	       }
	     }
	     break;
	    }
	    else {
	       if (!foundKing) {
	         this.getCheckPath().clear();
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
	       this.kingDirection = 2;
	     }
	     else {
	       if (!foundKing) {
	         this.getCheckPath().clear();
	       }
	     }
	     break;
	    }
	    else {
	       if (!foundKing) {
	         this.getCheckPath().clear();
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
	       this.kingDirection = 4;
	     }
	     else {
	       if (!foundKing) {
	         this.getCheckPath().clear();
	       }
	     }
	     break;
	    }
	    else {
	       if (!foundKing) {
	         this.getCheckPath().clear();
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
	       this.kingDirection = 6;
	     }
	     else {
	       if (!foundKing) {
	         this.getCheckPath().clear();
	       }
	     }
	     break;
	    }
	    else {
	       if (!foundKing) {
	         this.getCheckPath().clear();
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
	    int x = g.getBoard().getKingButton()[colindex].getPosition().getX();
	    int y = g.getBoard().getKingButton()[colindex].getPosition().getY();
	    switch(kingDirection) {
	      case 0 : {
	        if (y - 1 >= 0) {
	          if (g.getBoard().getKingButton()[colindex].getPiece().getPath().contains(g.getBoard().getTiles()[y - 1][x])) {
	            g.getBoard().getKingButton()[colindex].getPiece().getPath().remove(g.getBoard().getTiles()[y - 1][x]);
	          }
	        }
	        break;
	      }
	      case 1 : {
	        if (x + 1 < 8 && y - 1 >= 0) {
	          if (g.getBoard().getKingButton()[colindex].getPiece().getPath().contains(g.getBoard().getTiles()[y - 1][x + 1])) {
	            g.getBoard().getKingButton()[colindex].getPiece().getPath().remove(g.getBoard().getTiles()[y - 1][x + 1]);
	          }
	        }
	        break;
	      }
	      case 2 : {
	        if (x + 1 < 8) {
	          if (g.getBoard().getKingButton()[colindex].getPiece().getPath().contains(g.getBoard().getTiles()[y][x + 1])) {
	            g.getBoard().getKingButton()[colindex].getPiece().getPath().remove(g.getBoard().getTiles()[y][x + 1]);
	          }
	        }
	        break;
	      }
	      case 3 : {
	        if (y + 1 < 8 && x + 1 < 8) {
	          if (g.getBoard().getKingButton()[colindex].getPiece().getPath().contains(g.getBoard().getTiles()[y + 1][x + 1])) {
	            g.getBoard().getKingButton()[colindex].getPiece().getPath().remove(g.getBoard().getTiles()[y + 1][x + 1]);
	          }
	        }
	        break;
	      }
	      case 4 : {
	        if (y + 1 < 8) {
	          if (g.getBoard().getKingButton()[colindex].getPiece().getPath().contains(g.getBoard().getTiles()[y + 1][x])) {
	            g.getBoard().getKingButton()[colindex].getPiece().getPath().remove(g.getBoard().getTiles()[y + 1][x]);
	          }
	        }
	        break;
	      }
	      case 5 : {
	        if (y + 1 < 8 && x - 1 >= 0) {
	          if (g.getBoard().getKingButton()[colindex].getPiece().getPath().contains(g.getBoard().getTiles()[y + 1][x - 1])) {
	            g.getBoard().getKingButton()[colindex].getPiece().getPath().remove(g.getBoard().getTiles()[y + 1][x - 1]);
	          }
	        }
	        break;
	      }
	      case 6 : {
	        if (x - 1 >= 0) {
	          if (g.getBoard().getKingButton()[colindex].getPiece().getPath().contains(g.getBoard().getTiles()[y][x - 1])) {
	            g.getBoard().getKingButton()[colindex].getPiece().getPath().remove(g.getBoard().getTiles()[y][x - 1]);
	          }
	        }
	        break;
	      }
	      case 7 : {
	        if (y - 1 >= 0 && x - 1 >= 0) {
	          if (g.getBoard().getKingButton()[colindex].getPiece().getPath().contains(g.getBoard().getTiles()[y - 1][x - 1])) {
	            g.getBoard().getKingButton()[colindex].getPiece().getPath().remove(g.getBoard().getTiles()[y - 1][x - 1]);
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