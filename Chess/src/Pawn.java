import java.awt.Color;

import javax.swing.ImageIcon;
import java.util.*;
public class Pawn extends Piece implements java.io.Serializable{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 public Pawn(int id, Color color, Position pos, ImageIcon image, boolean hasMovedYet) {
	 super(id, color, pos, image, hasMovedYet);
 }
 void setPath(Game g, Tile t) {
	  Board board = g.getBoard();
	  Color c = this.getColor();
	  Position p = t.getPosition();
	  this.getPath().clear();
	  int x = p.getX();
	  int y = p.getY();
	  this.getPath().add(t);
	  this.getCheckPath().clear();
	  this.getCheckPath().add(t);
	  this.getAllies().clear();
	  if (c.equals(Constants.colors[0])) {
	    // Pawns that haven't moved yet can move two spaces forward given in range
	   if (!this.getHasMoved()) {
	    ArrayList<Tile> potentialPath = new ArrayList<Tile>();
	    if (y - 1 >= 0) {
	     potentialPath.add(board.getTiles()[y - 1][x]);
	    }
	    if (y - 2 >= 0) {
	     potentialPath.add(board.getTiles()[y - 2][x]);
	    }
	    // Check if pieces are in the way
	    for (Tile til : potentialPath) {
	      if (til == null)
	        break;
	     if (til.getPiece() != null)
	      break;
	     this.getPath().add(til);
	    }
	     if (x - 1 >= 0) {
	      Tile t1 = board.getTiles()[y - 1][x - 1];
	      if (t1.getPiece() != null) {
	       Color color = t1.getPiece().getColor();
	       if (!color.equals(c)) {
	        this.getPath().add(t1);
	        if (t1.getPiece() instanceof King) {
	          this.getCheckPath().add(t1);
	        }
	       }
	       else {
	         this.getAllies().add(t1);
	       }
	      }
	     }
	     if (x + 1 < 8) {
	      Tile t2 = board.getTiles()[y - 1][x + 1];
	      if (t2.getPiece() != null) {
	       Color color = t2.getPiece().getColor();
	       if (!color.equals(c)) {
	        this.getPath().add(t2);
	          if (t2.getPiece() instanceof King) {
	          this.getCheckPath().add(t2);
	        }
	       }
	       else {
	         this.getAllies().add(t2);
	       }
	      }
	    }
	   }
	   // If this pawn has already moved
	   else {
	    if (y - 1 >= 0) {
	     Tile potentialPath = board.getTiles()[y - 1][x];
	     if (potentialPath.getPiece() == null) {
	       this.getPath().add(potentialPath);
	     }
	      if (x - 1 >= 0) {
	       Tile t1 = board.getTiles()[y - 1][x - 1];
	       Tile t2 = board.getTiles()[y][x - 1];
	       if (t1.getPiece() != null) {
	        Color color = t1.getPiece().getColor();
	        if (!color.equals(c)) {
	         this.getPath().add(t1);
	         if (t1.getPiece() instanceof King) {
	          this.getCheckPath().add(t1);
	        }
	        }
	       else {
	         this.getAllies().add(t1);
	       }
	       }
	       if (t2.getPiece() != null) {
	        Piece piece = t2.getPiece();
	        if (piece instanceof Pawn) {
	        Pawn piece2 = (Pawn) piece;
	        if (g.getEnPass() != null) {
	        if (g.getEnPass().equals(piece2)) {
	         this.getPath().add(t1);
	        }
	        }
	        }
	       }
	      }
	      if (x + 1 < 8) {
	       Tile t1 = board.getTiles()[y - 1][x + 1];
	       Tile t2 = board.getTiles()[y][x + 1];
	       if (t1.getPiece() != null) {
	        Color color = t1.getPiece().getColor();
	        if (!color.equals(c)) {
	         this.getPath().add(t1);
	        if (t1.getPiece() instanceof King) {
	          this.getCheckPath().add(t1);
	        }
	        }
	       else {
	         this.getAllies().add(t1);
	       }
	       }
	       if (t2.getPiece() != null) {
	        Piece piece = t2.getPiece();
	        if (piece instanceof Pawn) {
	         Pawn piece2 = (Pawn) piece;
	         if (g.getEnPass() != null) {
	         if (g.getEnPass().equals(piece2)) {
	          this.getPath().add(t1);
	         }
	        }
	        }
	       }
	     }
	   }
	   }
	  }
	  else {
	   if (!this.getHasMoved()) {
	    ArrayList<Tile> potentialPath = new ArrayList<Tile>();
	    if (y + 1 < 8) {
	     potentialPath.add(board.getTiles()[y + 1][x]);
	    }
	    if (y + 2 < 8) {
	     potentialPath.add(board.getTiles()[y + 2][x]);
	    }
	    
	    for (Tile til : potentialPath) {
	     if (til == null)
	       break;
	     if (til.getPiece() != null)
	      break;
	     this.getPath().add(til);
	    }
	     if (x - 1 >= 0) {
	      Tile t1 = board.getTiles()[y + 1][x - 1];
	      if (t1.getPiece() != null) {
	       Color color = t1.getPiece().getColor();
	       if (!color.equals(c)) {
	        this.getPath().add(t1);
	        if (t1.getPiece() instanceof King) {
	          this.getCheckPath().add(t1);
	        }
	       }
	       else {
	         this.getAllies().add(t1);
	       }
	      }
	     }
	     if (x + 1 < 8) {
	      Tile t2 = board.getTiles()[y + 1][x + 1];
	      if (t2.getPiece() != null) {
	       Color color = t2.getPiece().getColor();
	       if (!color.equals(c)) {
	        this.getPath().add(t2);
	        if (t2.getPiece() instanceof King) {
	          this.getCheckPath().add(t2);
	        }
	       }
	       else {
	         this.getAllies().add(t2);
	       }
	      }
	    }
	   }
	   else {
	    if (y + 1 < 8) {
	     Tile potentialPath = board.getTiles()[y + 1][x];
	     if (potentialPath.getPiece() == null) {
	       this.getPath().add(potentialPath);
	     }
	      if (x - 1 >= 0) {
	       Tile t1 = board.getTiles()[y + 1][x - 1];
	       Tile t2 = board.getTiles()[y][x - 1];
	       if (t1.getPiece() != null) {
	        Color color = t1.getPiece().getColor();
	        if (!color.equals(c)) {
	         this.getPath().add(t1);
	        if (t1.getPiece() instanceof King) {
	          this.getCheckPath().add(t1);
	        }
	        }
	       else {
	         this.getAllies().add(t1);
	       }
	       }
	       if (t2.getPiece() != null) {
	        Piece piece = t2.getPiece();
	        if ((Object) piece instanceof Pawn) {
	         Pawn piece2 = (Pawn) piece;
	         if (g.getEnPass() != null) {
	         if (g.getEnPass().equals(piece2)) {
	          this.getPath().add(t1);
	         }
	        }
	        }
	       }
	      }
	      if (x + 1 < 8) {
	       Tile t1 = board.getTiles()[y + 1][x + 1];
	       Tile t2 = board.getTiles()[y][x + 1];
	       if (t1.getPiece() != null) {
	        Color color = t1.getPiece().getColor();
	        if (!color.equals(c)) {
	         this.getPath().add(t1);
	        if (t1.getPiece() instanceof King) {
	          this.getCheckPath().add(t1);
	        }
	        }
	       else {
	         this.getAllies().add(t1);
	       }
	       }
	       if (t2.getPiece() != null) {
	        Piece piece = t2.getPiece();
	        if ((Object) piece instanceof Pawn) {
	         Pawn piece2 = (Pawn) piece;
	         if (g.getEnPass() != null) {
	         if (g.getEnPass().equals(piece2)) {
	          this.getPath().add(t1);
	         }
	        }
	        }
	       }
	     }
	    }
	   }
	  }
	  board.getCheckPaths().put(this, this.getCheckPath());
	 }
}
