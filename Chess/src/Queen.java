import java.awt.Color;
import javax.swing.ImageIcon;

public class Queen extends Piece implements java.io.Serializable{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 public Queen(int id, Color color, Position pos, ImageIcon image) {
	 super(id, color, pos, image);
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
	       this.setKingDirection(7);
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
	       this.setKingDirection(1);
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
	       this.setKingDirection(5);
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
	       this.setKingDirection(3);
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
	       this.setKingDirection(0);
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
	       this.setKingDirection(2);
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
	       this.setKingDirection(4);
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
	       this.setKingDirection(6);
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
}