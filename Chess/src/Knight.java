import java.awt.Color;

import javax.swing.ImageIcon;

public class Knight extends Piece implements java.io.Serializable{
 private int whitenewId = 2;
 private int blacknewId = 2;
 public Knight(int id, Color color, Position pos, ImageIcon image, String name) {
  setId(id);
  setColor(color);
  setPosition(pos);
  setImage(image);
  setName(name);
 }
 public void setPath(Game g, TileButton t) {
  Board board = g.getBoard();
  Color c = this.getColor();
  this.path.clear();
  int x = t.getTile().getPosition().getX();
  int y = t.getTile().getPosition().getY();
  this.path.add(t);
  this.checkPath.clear();
  this.checkPath.add(t);
  this.allies.clear();
  boolean foundKing = false;
   if (y - 2 >= 0 && x + 1 < 8) {
    TileButton tile = board.tiles[y - 2][x + 1];
    if (tile.getTile().getPiece() != null) {
     Color otherCol = tile.getTile().getPiece().getColor();
     if (!c.equals(otherCol)) {
      this.path.add(tile);
      if (tile.getTile().getPiece() instanceof King) {
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
    TileButton tile = board.tiles[y - 1][x + 2];
    if (tile.getTile().getPiece() != null) {
     Color otherCol = tile.getTile().getPiece().getColor();
     if (!c.equals(otherCol)) {
      this.path.add(tile);
      if (tile.getTile().getPiece() instanceof King) {
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
    TileButton tile = board.tiles[y + 1][x + 2];
    if (tile.getTile().getPiece() != null) {
     Color otherCol = tile.getTile().getPiece().getColor();
     if (!c.equals(otherCol)) {
      this.path.add(tile);
      if (tile.getTile().getPiece() instanceof King) {
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
    TileButton tile = board.tiles[y + 2][x + 1];
    if (tile.getTile().getPiece() != null) {
     Color otherCol = tile.getTile().getPiece().getColor();
     if (!c.equals(otherCol)) {
      this.path.add(tile);
      if (tile.getTile().getPiece() instanceof King) {
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
    TileButton tile = board.tiles[y + 2][x - 1];
    if (tile.getTile().getPiece() != null) {
     Color otherCol = tile.getTile().getPiece().getColor();
     if (!c.equals(otherCol)) {
      this.path.add(tile);
      if (tile.getTile().getPiece() instanceof King) {
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
    TileButton tile = board.tiles[y + 1][x - 2];
    if (tile.getTile().getPiece() != null) {
     Color otherCol = tile.getTile().getPiece().getColor();
     if (!c.equals(otherCol)) {
      this.path.add(tile);
      if (tile.getTile().getPiece() instanceof King) {
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
    TileButton tile = board.tiles[y - 1][x - 2];
    if (tile.getTile().getPiece() != null) {
     Color otherCol = tile.getTile().getPiece().getColor();
     if (!c.equals(otherCol)) {
      this.path.add(tile);
      if (tile.getTile().getPiece() instanceof King) {
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
    TileButton tile = board.tiles[y - 2][x - 1];
    if (tile.getTile().getPiece() != null) {
     Color otherCol = tile.getTile().getPiece().getColor();
     if (!c.equals(otherCol)) {
      this.path.add(tile);
      if (tile.getTile().getPiece() instanceof King) {
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
   Board board = new Board();
  TileButton[][] tiles = board.tiles;
  TileButton t = tiles[0][1];
  int n = Constants.TILEWIDTH;
  Piece p = t.getTile().getPiece();
  System.out.println(p);
  //Knight q = (Knight) p;
  //p.setPath(board, t);
  for (TileButton til : p.path)
  System.out.println(til.getTile().getX() / n + ", " + til.getTile().getY() / n);
 }
}