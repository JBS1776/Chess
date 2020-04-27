import java.awt.Color;
import javax.swing.ImageIcon;

public class Rook extends Piece implements java.io.Serializable{
 private int whitenewId = 2;
 private int blacknewId = 2;
 int kingDirection = -1;
 public Rook(int id, Color color, Position pos, ImageIcon image, String name, boolean hasMovedYet) {
  setId(id);
  setColor(color);
  setPosition(pos);
  setImage(image);
  setName(name);
  this.hasMovedYet = hasMovedYet;
 }
 public void setPath(Game g, TileButton t) {
  Board board = g.getBoard();
  this.path.clear();
  Color c = this.getColor();
  int x = t.getTile().getPosition().getX();
  int y = t.getTile().getPosition().getY();
  this.path.add(t);
  this.checkPath.clear();
  this.checkPath.add(t);
  this.allies.clear();
  boolean foundKing = false;
  int kingDirection = -1;
  TileButton theKing = null;
  while(y > 0) {
   y -= 1;
   TileButton til = board.tiles[y][x];
   if (til.getTile().getPiece() != null) {
	   //System.out.println("RATS: " + til.getTile().getPiece().getName() + ":" + x + ", " + y);
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
  y = t.getTile().getPosition().getY();
  while(x < 7) {
   x += 1;
   TileButton til = board.tiles[y][x];
   if (til.getTile().getPiece() != null) {
	   if (x == 6 && y == 6)
		   System.out.println("FOUND SOMETHING: " + til.getTile().getPiece().getName());
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
       this.kingDirection = 2;
       theKing = til;
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
       this.kingDirection = 3;
       theKing = til;
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
        if (x + 1 < 8) {
          if (g.getBoard().kingsButton[colindex].getTile().getPiece().getPath().contains(g.getBoard().tiles[y][x + 1])) {
            g.getBoard().kingsButton[colindex].getTile().getPiece().getPath().remove(g.getBoard().tiles[y][x + 1]);
          }
        }
        break;
      }
      case 2 : {
        if (y + 1 < 8) {
          if (g.getBoard().kingsButton[colindex].getTile().getPiece().getPath().contains(g.getBoard().tiles[y + 1][x])) {
            g.getBoard().kingsButton[colindex].getTile().getPiece().getPath().remove(g.getBoard().tiles[y + 1][x]);
          }
        }
        break;
      }
      case 3 : {
        if (x - 1 >= 0) {
          if (g.getBoard().kingsButton[colindex].getTile().getPiece().getPath().contains(g.getBoard().tiles[y][x - 1])) {
            g.getBoard().kingsButton[colindex].getTile().getPiece().getPath().remove(g.getBoard().tiles[y][x - 1]);
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
  TileButton t = tiles[7][0];
  int n = Constants.TILEWIDTH;
  Piece p = t.getTile().getPiece();
  //System.out.println(p);
  Rook q = (Rook) p;
  //q.setPath(board, t);
 }
}
