import java.awt.Color;
import javax.swing.ImageIcon;

public class Queen extends Piece implements java.io.Serializable{
 private int whitenewId = 1;
 private int blacknewId = 1;
 int kingDirection = -1;
 public Queen(int id, Color color, Position pos, ImageIcon image, String name) {
  setId(id);
  setColor(color);
  setPosition(pos);
  setImage(image);
  setName(name);
 }
 public void setPath(Game g, TileButton t) {
  Board board = g.getBoard();
  this.path.clear();
  Color c = this.getColor();
  int x = t.getTile().getPosition().getX();
  int y = t.getTile().getPosition().getY();
  this.path.add(t);
  this.checkPath.clear();
  this.allies.clear();
  boolean foundKing = false;
  this.kingDirection = -1;
  TileButton theKing = null;
  while(y > 0 && x > 0) {
   y -= 1;
   x -= 1;
   TileButton til = board.tiles[y][x];
   if (til.getTile().getPiece() != null) {
    Color otherCol = til.getTile().getPiece().getColor();
    if (!c.equals(otherCol)) {
     this.path.add(til);
     if (til.getTile().getPiece() instanceof King) {
       this.checkPath.add(til);
       foundKing = true;
       this.kingDirection = 7;
       theKing = til;
     }
     else {
       if (!foundKing) {
         this.checkPath.clear();
         //this.checkPath.add(t);
       }
     }
     break;
    }
    else {
       if (!foundKing) {
         this.checkPath.clear();
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
  y = t.getTile().getPosition().getY();
  x = t.getTile().getPosition().getX();
  while(x < 7 && y > 0) {
   x += 1;
   y -= 1;
   TileButton til = board.tiles[y][x];
   if (til.getTile().getPiece() != null) {
    Color otherCol = til.getTile().getPiece().getColor();
    if (!c.equals(otherCol)) {
     this.path.add(til);
     if (til.getTile().getPiece() instanceof King) {
       this.checkPath.add(til);
       foundKing = true;
       this.kingDirection = 1;
       theKing = til;
     }
     else {
       if (!foundKing) {
         this.checkPath.clear();
       }
     }
     break;
    }
    else {
       if (!foundKing) {
         this.checkPath.clear();
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
  x = t.getTile().getPosition().getX();
  y = t.getTile().getPosition().getY();
  while(y < 7 && x > 0) {
   y += 1;
   x -= 1;
   TileButton til = board.tiles[y][x];
   if (til.getTile().getPiece() != null) {
    Color otherCol = til.getTile().getPiece().getColor();
    if (!c.equals(otherCol)) {
     this.path.add(til);
     if (til.getTile().getPiece() instanceof King) {
       this.checkPath.add(til);
       foundKing = true;
       this.kingDirection = 5;
       theKing = til;
     }
     else {
       if (!foundKing) {
         this.checkPath.clear();
       }
     }
     break;
    }
    else {
       if (!foundKing) {
         this.checkPath.clear();
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
  y = t.getTile().getPosition().getY();
  x = t.getTile().getPosition().getX();
  while (x < 7 && y < 7) {
   x += 1;
   y += 1;
   TileButton til = board.tiles[y][x];
   if (til.getTile().getPiece() != null) {
    Color otherCol = til.getTile().getPiece().getColor();
    if (!c.equals(otherCol)) {
     this.path.add(til);
     if (til.getTile().getPiece() instanceof King) {
       this.checkPath.add(til);
       foundKing = true;
       this.kingDirection = 3;
       theKing = til;
     }
     else {
       if (!foundKing) {
         this.checkPath.clear();
       }
     }
     break;
    }
    else {
       if (!foundKing) {
         this.checkPath.clear();
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
  y = t.getTile().getPosition().getY();
  x = t.getTile().getPosition().getX();
  while(y > 0) {
   y -= 1;
   TileButton til = board.tiles[y][x];
   if (til.getTile().getPiece() != null) {
    Color otherCol = til.getTile().getPiece().getColor();
    if (!c.equals(otherCol)) {
     this.path.add(til);
     if (til.getTile().getPiece() instanceof King) {
       this.checkPath.add(til);
       foundKing = true;
       this.kingDirection = 0;
       theKing = til;
     }
     else {
       if (!foundKing) {
         this.checkPath.clear();
       }
     }
     break;
    }
    else {
       if (!foundKing) {
         this.checkPath.clear();
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
  y = t.getTile().getPosition().getY();
  while(x < 7) {
   x += 1;
   TileButton til = board.tiles[y][x];
   if (til.getTile().getPiece() != null) {
    Color otherCol = til.getTile().getPiece().getColor();
    if (!c.equals(otherCol)) {
     this.path.add(til);
     if (til.getTile().getPiece() instanceof King) {
       this.checkPath.add(til);
       foundKing = true;
       this.kingDirection = 2;
       theKing = til;
     }
     else {
       if (!foundKing) {
         this.checkPath.clear();
       }
     }
     break;
    }
    else {
       if (!foundKing) {
         this.checkPath.clear();
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
  x = t.getTile().getPosition().getX();
  while(y < 7) {
   y += 1;
   TileButton til = board.tiles[y][x];
   if (til.getTile().getPiece() != null) {
    Color otherCol = til.getTile().getPiece().getColor();
    if (!c.equals(otherCol)) {
     this.path.add(til);
     if (til.getTile().getPiece() instanceof King) {
       this.checkPath.add(til);
       foundKing = true;
       this.kingDirection = 4;
       theKing = til;
     }
     else {
       if (!foundKing) {
         this.checkPath.clear();
       }
     }
     break;
    }
    else {
       if (!foundKing) {
         this.checkPath.clear();
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
  y = t.getTile().getPosition().getY();
  while (x > 0) {
   x -= 1;
   TileButton til = board.tiles[y][x];
   if (til.getTile().getPiece() != null) {
    Color otherCol = til.getTile().getPiece().getColor();
    if (!c.equals(otherCol)) {
     this.path.add(til);
     if (til.getTile().getPiece() instanceof King) {
       this.checkPath.add(til);
       foundKing = true;
       this.kingDirection = 6;
       theKing = til;
     }
     else {
       if (!foundKing) {
         this.checkPath.clear();
       }
     }
     break;
    }
    else {
       if (!foundKing) {
         this.checkPath.clear();
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
    System.out.println("RECHECK: " + this.kingDirection);
    int x = g.getBoard().kingsButton[colindex].getTile().getPosition().getX();
    int y = g.getBoard().kingsButton[colindex].getTile().getPosition().getY();
    switch(kingDirection) {
      case 0 : {
        if (y - 1 >= 0) {
          if (g.getBoard().kingsButton[colindex].getTile().getPiece().getPath().contains(g.getBoard().tiles[y - 1][x])) {
            g.getBoard().kingsButton[colindex].getTile().getPiece().getPath().remove(g.getBoard().tiles[y - 1][x]);
          }
        }
        break;
      }
      case 1 : {
        if (x + 1 < 8 && y - 1 >= 0) {
          if (g.getBoard().kingsButton[colindex].getTile().getPiece().getPath().contains(g.getBoard().tiles[y - 1][x + 1])) {
            g.getBoard().kingsButton[colindex].getTile().getPiece().getPath().remove(g.getBoard().tiles[y - 1][x + 1]);
          }
        }
        break;
      }
      case 2 : {
        if (x + 1 < 8) {
          if (g.getBoard().kingsButton[colindex].getTile().getPiece().getPath().contains(g.getBoard().tiles[y][x + 1])) {
            g.getBoard().kingsButton[colindex].getTile().getPiece().getPath().remove(g.getBoard().tiles[y][x + 1]);
          }
        }
        break;
      }
      case 3 : {
        if (y + 1 < 8 && x + 1 < 8) {
          if (g.getBoard().kingsButton[colindex].getTile().getPiece().getPath().contains(g.getBoard().tiles[y + 1][x + 1])) {
            g.getBoard().kingsButton[colindex].getTile().getPiece().getPath().remove(g.getBoard().tiles[y + 1][x + 1]);
          }
        }
        break;
      }
      case 4 : {
        if (y + 1 < 8) {
          if (g.getBoard().kingsButton[colindex].getTile().getPiece().getPath().contains(g.getBoard().tiles[y + 1][x])) {
            g.getBoard().kingsButton[colindex].getTile().getPiece().getPath().remove(g.getBoard().tiles[y + 1][x]);
          }
        }
        break;
      }
      case 5 : {
        if (y + 1 < 8 && x - 1 >= 0) {
          if (g.getBoard().kingsButton[colindex].getTile().getPiece().getPath().contains(g.getBoard().tiles[y + 1][x - 1])) {
            g.getBoard().kingsButton[colindex].getTile().getPiece().getPath().remove(g.getBoard().tiles[y + 1][x - 1]);
          }
        }
        break;
      }
      case 6 : {
        if (x - 1 >= 0) {
          if (g.getBoard().kingsButton[colindex].getTile().getPiece().getPath().contains(g.getBoard().tiles[y][x - 1])) {
            g.getBoard().kingsButton[colindex].getTile().getPiece().getPath().remove(g.getBoard().tiles[y][x - 1]);
          }
        }
        break;
      }
      case 7 : {
        if (y - 1 >= 0 && x - 1 >= 0) {
          if (g.getBoard().kingsButton[colindex].getTile().getPiece().getPath().contains(g.getBoard().tiles[y - 1][x - 1])) {
            g.getBoard().kingsButton[colindex].getTile().getPiece().getPath().remove(g.getBoard().tiles[y - 1][x - 1]);
          }
        }
        break;
      }
    }
  }
  }
 public static void main(String[] args) {
   Board board = new Board();
  TileButton[][] tiles = board.tiles;
  TileButton t = tiles[0][3];
  int n = Constants.TILEWIDTH;
  Piece p = t.getTile().getPiece();
  System.out.println(p);
  Queen q = (Queen) p;
  //q.setPath(board, t);
  for (TileButton til : p.path)
  System.out.println(til.getTile().getX() / n + ", " + til.getTile().getY() / n);
 }
}