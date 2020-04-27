import java.awt.Color;

import javax.swing.ImageIcon;
import java.util.*;
public class Pawn extends Piece implements java.io.Serializable{
 TileButton[][] buttons = board.tiles;
 boolean enPassent_elegible = false;
 public Pawn(int id, Color color, Position pos, ImageIcon image, String name, boolean hasMovedYet) {
  setId(id);
  setColor(color);
  setPosition(pos);
  setImage(image);
  setName(name);
  this.hasMovedYet = hasMovedYet;
 }
 public void setPath(Game g, TileButton t) {
  Board board = g.getBoard();
  Color c = this.getColor();
  Position p = t.getTile().getPosition();
  this.path.clear();
  boolean foundKing = false;
  int x = p.getX();
  int y = p.getY();
  this.path.add(t);
  this.checkPath.clear();
  this.allies.clear();
  if (c.equals(colors[0])) {
    // Pawns that haven't moved yet can move two spaces forward given in range
   if (!this.hasMovedYet) {
    ArrayList<TileButton> potentialPath = new ArrayList<TileButton>();
    if (y - 1 >= 0) {
     potentialPath.add(board.tiles[y - 1][x]);
    }
    if (y - 2 >= 0) {
     potentialPath.add(board.tiles[y - 2][x]);
    }
    // Check if pieces are in the way
    for (TileButton til : potentialPath) {
      if (til == null)
        break;
     if (til.getTile().getPiece() != null)
      break;
     this.path.add(til);
    }
     if (x - 1 >= 0) {
      TileButton tb1 = board.tiles[y - 1][x - 1];
      Tile t1 = tb1.getTile();
      if (t1.getPiece() != null) {
       Color color = t1.getPiece().getColor();
       if (!color.equals(c)) {
        this.path.add(tb1);
        if (t1.getPiece() instanceof King) {
          this.checkPath.add(tb1);
        }
       }
       else {
         this.allies.add(tb1);
       }
      }
     }
     if (x + 1 < 8) {
      TileButton tb2 = board.tiles[y - 1][x + 1];
      Tile t2 = tb2.getTile();
      if (t2.getPiece() != null) {
       Color color = t2.getPiece().getColor();
       if (!color.equals(c)) {
        this.path.add(tb2);
          if (t2.getPiece() instanceof King) {
          this.checkPath.add(tb2);
        }
       }
       else {
         this.allies.add(tb2);
       }
      }
    }
   }
   // If this pawn has already moved
   else {
    if (y - 1 >= 0) {
     TileButton potentialPath = board.tiles[y - 1][x];
     if (potentialPath.getTile().getPiece() == null) {
       this.path.add(potentialPath);
     }
      if (x - 1 >= 0) {
       TileButton tb1 = board.tiles[y - 1][x - 1];
       TileButton tb2 = board.tiles[y][x - 1];
       Tile t1 = tb1.getTile();
       Tile t2 = tb2.getTile();
       if (t1.getPiece() != null) {
        Color color = t1.getPiece().getColor();
        if (!color.equals(c)) {
         this.path.add(tb1);
         if (t1.getPiece() instanceof King) {
          this.checkPath.add(tb1);
        }
        }
       else {
         this.allies.add(tb1);
       }
       }
       if (t2.getPiece() != null) {
        Piece curr = board.tiles[y][x].getTile().getPiece();
        Piece piece = t2.getPiece();
        if (piece instanceof Pawn) {
        Pawn piece2 = (Pawn) piece;
        if (g.getEnPass() != null) {
        if (g.getEnPass().equals(piece2)) {
         this.path.add(tb1);
        }
        }
        }
       }
      }
      if (x + 1 < 8) {
       TileButton tb1 = board.tiles[y - 1][x + 1];
       TileButton tb2 = board.tiles[y][x + 1];
       Tile t1 = tb1.getTile();
       Tile t2 = tb2.getTile();
       if (t1.getPiece() != null) {
        Color color = t1.getPiece().getColor();
        if (!color.equals(c)) {
         this.path.add(tb1);
        if (t1.getPiece() instanceof King) {
          this.checkPath.add(tb1);
        }
        }
       else {
         this.allies.add(tb1);
       }
       }
       if (t2.getPiece() != null) {
        Piece curr = board.tiles[y][x].getTile().getPiece();
        Piece piece = t2.getPiece();
        if (piece instanceof Pawn) {
         Color color = piece.getColor();
         Pawn piece2 = (Pawn) piece;
         if (g.getEnPass() != null) {
         if (g.getEnPass().equals(piece2)) {
          //Game.extraString = "(En-passent Capture!)";
          this.path.add(tb1);
         }
        }
        }
       }
     }
   }
   }
  }
  else {
   if (!this.hasMovedYet) {
    ArrayList<TileButton> potentialPath = new ArrayList<TileButton>();
    if (y + 1 < 8) {
     potentialPath.add(board.tiles[y + 1][x]);
    }
    if (y + 2 < 8) {
     potentialPath.add(board.tiles[y + 2][x]);
    }
    
    for (TileButton til : potentialPath) {
     if (til == null)
       break;
     if (til.getTile().getPiece() != null)
      break;
     this.path.add(til);
    }
     if (x - 1 >= 0) {
      TileButton tb1 = board.tiles[y + 1][x - 1];
      Tile t1 = tb1.getTile();
      if (t1.getPiece() != null) {
       Color color = t1.getPiece().getColor();
       if (!color.equals(c)) {
        this.path.add(tb1);
        if (t1.getPiece() instanceof King) {
          this.checkPath.add(tb1);
        }
       }
       else {
         this.allies.add(tb1);
       }
      }
     }
     if (x + 1 < 8) {
      TileButton tb2 = board.tiles[y + 1][x + 1];
      Tile t2 = tb2.getTile();
      if (t2.getPiece() != null) {
       Color color = t2.getPiece().getColor();
       if (!color.equals(c)) {
        this.path.add(tb2);
        if (t2.getPiece() instanceof King) {
          this.checkPath.add(tb2);
        }
       }
       else {
         this.allies.add(tb2);
       }
      }
    }
   }
   else {
    if (y + 1 < 8) {
     TileButton potentialPath = board.tiles[y + 1][x];
     if (potentialPath.getTile().getPiece() == null) {
       this.path.add(potentialPath);
     }
      if (x - 1 >= 0) {
       TileButton tb1 = board.tiles[y + 1][x - 1];
       TileButton tb2 = board.tiles[y][x - 1];
       Tile t1 = tb1.getTile();
       Tile t2 = tb2.getTile();
       if (t1.getPiece() != null) {
        Color color = t1.getPiece().getColor();
        if (!color.equals(c)) {
         this.path.add(tb1);
        if (t1.getPiece() instanceof King) {
          this.checkPath.add(tb1);
        }
        }
       else {
         this.allies.add(tb1);
       }
       }
       if (t2.getPiece() != null) {
        Piece curr = board.tiles[y][x].getTile().getPiece();
        Piece piece = t2.getPiece();
        if ((Object) piece instanceof Pawn) {
         Pawn piece2 = (Pawn) piece;
         if (g.getEnPass() != null) {
         if (g.getEnPass().equals(piece2)) {
          this.path.add(tb1);
         }
        }
        }
       }
      }
      if (x + 1 < 8) {
       TileButton tb1 = board.tiles[y + 1][x + 1];
       TileButton tb2 = board.tiles[y][x + 1];
       Tile t1 = tb1.getTile();
       Tile t2 = tb2.getTile();
       if (t1.getPiece() != null) {
        Color color = t1.getPiece().getColor();
        if (!color.equals(c)) {
         this.path.add(tb1);
        if (t1.getPiece() instanceof King) {
          this.checkPath.add(tb1);
        }
        }
       else {
         this.allies.add(tb1);
       }
       }
       if (t2.getPiece() != null) {
        Piece piece = t2.getPiece();
        if ((Object) piece instanceof Pawn) {
         Piece curr = board.tiles[y][x].getTile().getPiece();
         Pawn piece2 = (Pawn) piece;
         if (g.getEnPass() != null) {
         if (g.getEnPass().equals(piece2)) {
          this.path.add(tb1);
         }
        }
        }
       }
     }
    }
   }
  }
  board.checkPaths.put(this, this.checkPath);
 }
 public static void main(String[] args) {
   Board board = new Board();
   board.fillTiles(0, 0);
  TileButton[][] tiles = board.tiles;
  //Piece p = new Piece();
  Pawn pawn = new Pawn(0, Color.BLACK, new Position(0, 0), Constants.images[1][8], "test", false);
  System.out.println(pawn); 
 }
}
