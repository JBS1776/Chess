import javax.swing.JOptionPane;
import java.awt.*;
import java.io.Serializable;
import java.util.*;
public class Board implements Serializable{
	private static final long serialVersionUID = 1L;


private ArrayList<Piece>[] pieces = new ArrayList[2];
private ArrayList<Piece> causedCheck = new ArrayList<Piece>();
private HashMap<Piece, ArrayList<Tile>> checkPaths = new HashMap<Piece, ArrayList<Tile>>();
private HashMap<Piece, ArrayList<Tile>> take = new HashMap<Piece, ArrayList<Tile>>();
private ArrayList<Piece>[] removedPieces = new ArrayList[2];
private Tile[] kingsButton = new Tile[2];
private Tile[][] tiles = new Tile[8][8];
private int[][] maxPieceIds = new int[2][6];
private boolean windowDisplayed = false;
public Board() {
  for (int i = 0; i < 2; i++) {
    pieces[i] = new ArrayList<Piece>();
  }
}
private class Duple {
	  Tile button;
	  boolean isRemoved;
	  public Duple(Tile button, boolean isRemoved) {
	    this.button = button;
	    this.isRemoved = isRemoved;
	  }
}
Tile[][] fillTiles(int startX, int startY, int setting) {
Tile[][] tis = this.tiles;
int x = startX;
int y = startY;
int n = Constants.TILEWIDTH;
int m = Constants.TILEHEIGHT;
Constants.colors[1] = (setting == 1) ? Constants.GRAY : Color.black;
for (int i = 0; i < 8; i++) {
 for (int j = 0; j < 8; j++) {
  int colIndex = (i + j) % 2;
  Tile t = new Tile(n, m, x, y, Constants.colors[colIndex], null);
  t.setPosition(j, i);
  if (i == 0) {
     t.setImage(Constants.images[1][j]);
     int identification = (j > 4) ? 2 : 1;
     switch(j) {
     case (0) : {
      t.setPiece(new Rook(identification, Constants.colors[1], new Position(j, i), 
           t.getImage(), false));
      pieces[1].add(t.getPiece());
      break;
     }
     case (1) : {
      t.setPiece(new Knight(identification, Constants.colors[1], new Position(j, i), 
        t.getImage()));
      pieces[1].add(t.getPiece());
      break;
     }
     case (2) : {
      t.setPiece(new Bishop(identification, Constants.colors[1], new Position(j, i), 
        t.getImage()));
      pieces[1].add(t.getPiece());
      break;
     }
     case (3) : {
      t.setPiece(new Queen(identification, Constants.colors[1], new Position(j, i), 
        t.getImage()));
      pieces[1].add(t.getPiece());;
      break;
     }
     case (4) : {
      t.setPiece(new King(identification, Constants.colors[1], new Position(j, i), 
        t.getImage(), false));
      pieces[1].add(t.getPiece());
      kingsButton[1] = t;
      break;
     }
     case (5) : {
      t.setPiece(new Bishop(identification, Constants.colors[1], new Position(j, i), 
        t.getImage()));
      pieces[1].add(t.getPiece());
      break;
     }
     case (6) : {
      t.setPiece(new Knight(identification, Constants.colors[1], new Position(j, i), 
        t.getImage()));
      pieces[1].add(t.getPiece());
      break;
     }
     case (7) : {
      t.setPiece(new Rook(identification, Constants.colors[1], new Position(j, i), 
           t.getImage(), false));     
      pieces[1].add(t.getPiece());
      break;
     }
     }
    }
    if (i == 1) {
     t.setImage(Constants.images[1][Constants.images[1].length - 1]);
     t.setPiece(new Pawn(j + 1, Constants.colors[1], new Position(j, i), 
        t.getImage(), false));    
     pieces[1].add(t.getPiece());
    }
    if (i == 6) {
     t.setImage(Constants.images[0][Constants.images[0].length - 1]);
     t.setPiece(new Pawn(j + 1, Constants.colors[0], new Position(j, i), 
        t.getImage(), false));     
     pieces[0].add(t.getPiece());
    }
    if (i == 7) {
     t.setImage(Constants.images[0][j]);
     int identification = (j > 4) ? 2 : 1;
     switch(j) {
     case (0) : {
      t.setPiece(new Rook(identification, Constants.colors[0], new Position(j, i), 
           t.getImage(), false));      
      pieces[0].add(t.getPiece());
      break;
     }
     case (1) : {
      t.setPiece(new Knight(identification, Constants.colors[0], new Position(j, i), 
        t.getImage()));     
      pieces[0].add(t.getPiece());
      break;
     }
     case (2) : {
      t.setPiece(new Bishop(identification, Constants.colors[0], new Position(j, i), 
        t.getImage()));      
      pieces[0].add(t.getPiece());
      break;
     }
     case (3) : {
      t.setPiece(new Queen(identification, Constants.colors[0], new Position(j, i), 
        t.getImage()));      
      pieces[0].add(t.getPiece());
      break;
     }
     case (4) : {
      t.setPiece(new King(identification, Constants.colors[0], new Position(j, i), 
        t.getImage(), false));       
      pieces[0].add(t.getPiece());
      kingsButton[0] = t;
      break;
     }
     case (5) : {
      t.setPiece(new Bishop(identification, Constants.colors[0], new Position(j, i), 
        t.getImage()));      
      pieces[0].add(t.getPiece());
      break;
     }
     case (6) : {
      t.setPiece(new Knight(identification, Constants.colors[0], new Position(j, i), 
        t.getImage()));       
      pieces[0].add(t.getPiece());
      break;
     }
     case (7) : {
      t.setPiece(new Rook(identification, Constants.colors[0], new Position(j, i), 
           t.getImage(), false));
      pieces[0].add(t.getPiece());
      break;
     }
     }
    }
    tis[i][j] = t;
    x += n;
    if (j % 8 == 7) {
     x = startX;
     y += m;
    }
 }
 }
return tis;
}
Tile[][] fillTiles2(int startX, int startY, int setting, ArrayList<Piece>[] lis) {
	 Tile[][] tis = this.tiles;
	 int x = startX;
	 int y = startY;
	 int n = Constants.TILEWIDTH;
	 int m = Constants.TILEHEIGHT;
	 Constants.colors[1] = (setting == 1) ? Constants.GRAY : Color.black;
	 for (int i = 0; i < 8; i++) {
	  for (int j = 0; j < 8; j++) {
	   int colIndex = (i + j) % 2;
	   Tile t = new Tile(n, m, x, y, Constants.colors[colIndex], null);
	   t.setPosition(j, i);
	   tis[i][j] = t;
	   x += n;
	   if (j % 8 == 7) {
	     x = startX;
	     y += m;
	   }
	}
	 }
	 this.pieces = lis;
	 for (int i = 0; i < 2; i++) {
	   for (Piece p : this.pieces[i]) {
	       Position pos = p.getPosition();
	       x = pos.getX();
	       y = pos.getY();
	       if (p instanceof King)
	    	   this.kingsButton[i] = tis[y][x];
	       tis[y][x].setPiece(p);
	       tis[y][x].setImage(p.getImage());
	 }
	}
	  return tis;
	}
void setPieces(Game g) {
	  for (int i = 0; i < this.pieces.length; i++) {
	  for (Piece p : this.pieces[i]) {
		  if (p instanceof Rook)
			  this.maxPieceIds[i][0] = Math.max(this.maxPieceIds[i][0], p.getId());
		  if (p instanceof Knight)
			  this.maxPieceIds[i][1] = Math.max(this.maxPieceIds[i][1], p.getId());
		  if (p instanceof Bishop)
			  this.maxPieceIds[i][2] = Math.max(this.maxPieceIds[i][2], p.getId());
		  if (p instanceof Queen)
			  this.maxPieceIds[i][3] = Math.max(this.maxPieceIds[i][3], p.getId());
		  if (p instanceof King)
			  this.maxPieceIds[i][4] = Math.max(this.maxPieceIds[i][4], p.getId());
		  if (p instanceof Pawn)
			  this.maxPieceIds[i][5] = Math.max(this.maxPieceIds[i][5], p.getId());
	    p.getCheckPath().clear();
	    p.getPath().clear();
	    Position pos = p.getPosition();
	    int x = pos.getX();
	    int y = pos.getY();
	    p.setPath(g, g.getBoard().tiles[y][x]);
	  }
	  }
	  }
void move(Tile prev, Tile next, Game g) {
	  int currTurn = g.getTurnCount();
	  Piece p = prev.getPiece();
	  Piece q = next.getPiece();
	  Position posPrev = prev.getPosition();
	  Position pos = next.getPosition();
	  boolean enpassSuccess = false;
	  if (q != null) {
		g.getMoveList().add((g.getMoveList().size() + 1) + ". " + p.getName() + p.getId() + ": " + posPrev + " X " + pos);
	    g.setEnPass(null);
	    p.setHasMoved(true);
	    next.setIcon(prev.getImage());
	    next.setPiece(p);
	    next.setImage(prev.getImage());
	    next.getPiece().setPosition(pos);
	    prev.setIcon(null);
	    prev.setPiece(null);
	    prev.setImage(null);
	    this.pieces[(currTurn + 1) % 2].remove(q);
	    g.getCapturedPieces().get(q.findIndex(Constants.colors[(currTurn + 1) % 2])).add(q);
	  }
	  else {
	    if (p instanceof Pawn) {
	      int posDiff = Math.abs(pos.getY() - posPrev.getY());
	      if (posDiff == 2) {
	        g.setEnPass(p);
	      }
	      else {
	        int posDiffx = Math.abs(pos.getX() - posPrev.getX());
	        int posDiffy = Math.abs(pos.getY() - posPrev.getY());
	        if (posDiffx == 1 && posDiffy == 1) {
	          Tile tb1 = this.tiles[pos.getY() - 1][pos.getX()];
	          Tile tb2 = this.tiles[pos.getY() + 1][pos.getX()];
	          Tile[] tils = {tb1, tb2};
	          for (Tile but : tils) {
	          but.setIcon(null);
	          but.setPiece(null);
	          but.setImage(null);
	          }
	          this.pieces[(currTurn + 1) % 2].remove(g.getEnPass());
	          g.getCapturedPieces().get(g.getEnPass().findIndex(Constants.colors[(currTurn + 1) % 2])).add(g.getEnPass());
	          enpassSuccess = true;
	        }
	        g.setEnPass(null);
	      }
	    }
	    else {
	      if (p instanceof King && !g.getTakeMeEnabled()) {
	        this.kingsButton[currTurn % 2].setBackground(this.kingsButton[currTurn % 2].getColor());
	        kingsButton[currTurn % 2] = next;
	      }
	      g.setEnPass(null);
	    }
		g.getMoveList().add((g.getMoveList().size() + 1) + ". " + p.getName() + p.getId() + ": " + posPrev + (enpassSuccess ? " X " : " -> ") + pos + (enpassSuccess ? " enpassant capture!" : ""));
	    p.setHasMoved(true);
	    next.setIcon(prev.getImage());
	    next.setPiece(p);
	    next.setImage(prev.getImage());
	    next.getPiece().setPosition(pos);
	    prev.setIcon(null);
	    prev.setPiece(null);
	    prev.setImage(null);
	  }
	}
void clearPaint(Game g) {
    for (Tile[] tis : g.getBoard().tiles)
      for (Tile but : tis)
    	  but.setBackground(but.getColor());
}
private ArrayList<Tile> intersection(ArrayList<Tile> a, ArrayList<Tile> b) {
    ArrayList<Tile> lis = new ArrayList<Tile>();
    for (int i = 0; i < a.size(); i++) {
      for (int j = 0; j < b.size(); j++) {
        if (a.get(i).equals(b.get(j)) && !lis.contains(a.get(i))) {
          lis.add(a.get(i));
          break;
        }
      }
    }
    return lis;
  }
boolean isTileInDanger(Tile b, Game g) {
	  int oppositeColor = (g.getTurnCount() + 1) % 2;
	  for (Piece p : this.pieces[oppositeColor]) {
	    if (!(p instanceof Pawn)) {
	      if (p.getPath().contains(b)) {
	        return true;
	      }
	    }
	    else {
	      Color color = p.getColor();
	      int tileX = p.getPosition().getX();
	      int tileY = p.getPosition().getY();
	      if (color.equals(Constants.colors[0])) {
	        if (tileY - 1 >= 0) {
	          if (tileX - 1 >= 0) {
	            if (this.tiles[tileY - 1][tileX - 1].equals(b)) {
	              return true;
	            }
	          }
	          if (tileX + 1 < 8) {
	            if (this.tiles[tileY - 1][tileX + 1].equals(b)) {
	              return true;
	            }
	          }
	        }
	      }
	      else {
	        if (tileY + 1 < 8) {
	          if (tileX - 1 >= 0) {
	            if (this.tiles[tileY + 1][tileX - 1].equals(b)) {
	              return true;
	            }
	          }
	          if (tileX + 1 < 8) {
	            if (this.tiles[tileY + 1][tileX + 1].equals(b)) {
	              return true;
	            }
	          }
	        }
	      }
	    }
	  }
	  return false;
	}
boolean isKingInCheck(Color color, Game g) {
	  g.setcurrKingCheck(false);
	  this.causedCheck.clear();
	  for (Piece p : this.pieces[(g.getTurnCount() + 1) % 2]) {
	    if (p.getPath().contains(this.kingsButton[g.getTurnCount() % 2])) {
	      this.causedCheck.add(p);
	    }
	  }
	  if (!this.causedCheck.isEmpty()) {
	    g.setcurrKingCheck(true);
	  }
	  return !this.causedCheck.isEmpty();
	}
ArrayList<Tile> checkPaths(Color color, boolean check, Duple[] buttons, Game g) {
	  ArrayList<Tile> lis = new ArrayList<Tile>();
	  int colIndex = g.getTurnCount() % 2;
	  Color c = g.getTurnColor();
	  if (check) {
	    int kingX = this.kingsButton[colIndex].getPosition().getX();
	    int kingY = this.kingsButton[colIndex].getPosition().getY();
	    boolean pathFound = false;
	    boolean kingPathFound = false;
	    for (int i = 0; i < 8; i++) {
	      int x = kingX;
	      int y = kingY;
	      kingPathFound = false;
	      switch(i) {
	        case 0 : {
	          if (!pathFound) {
	            lis.clear();
	          }
	          while (y - 1 >= 0) {
	            Piece p = this.tiles[y - 1][x].getPiece();
	            if (p != null) {
	              Color col = this.tiles[y - 1][x].getPiece().getColor();
	              if (!c.equals(col)) {
	                if ((p instanceof Rook || p instanceof Queen) && !pathFound) {
	                  lis.add(this.tiles[y - 1][x]);
	                  pathFound = true;
	                  kingPathFound = true;
	                }
	              }
	              break;
	            }
	            if (!pathFound) {
	            	lis.add(this.tiles[y - 1][x]);
	            }
	            y--;
	          }
	          break;
	        }
	        case 1 : {
	          if (!pathFound) {
	            lis.clear();
	          }
	          while (y - 1 >= 0 && x + 1 < 8) {
	            Piece p = this.tiles[y - 1][x + 1].getPiece();
	            if (p != null) {
	              Color col = this.tiles[y - 1][x + 1].getPiece().getColor();
	              if (!c.equals(col)) {
	                if ((p instanceof Bishop || p instanceof Queen) && !pathFound) {
	                  lis.add(this.tiles[y - 1][x + 1]);
	                  pathFound = true;
	                  kingPathFound = true;
	                }
	              }
	              break;
	            }
	            if (!pathFound)
	            lis.add(this.tiles[y - 1][x + 1]);
	            y--;
	            x++;
	          }
	          break;
	        }
	        case 2 : {
	          if (!pathFound) {
	            lis.clear();
	          }
	          while (x + 1 < 8) {
	            Piece p = this.tiles[y][x + 1].getPiece();
	            if (p != null) {
	              Color col = this.tiles[y][x + 1].getPiece().getColor();
	              if (!c.equals(col)) {
	                if ((p instanceof Rook || p instanceof Queen) && !pathFound) {
	                  lis.add(this.tiles[y][x + 1]);
	                  pathFound = true;
	                  kingPathFound = true;
	                }
	              }
	              break;
	            }
	            if (!pathFound)
	            lis.add(this.tiles[y][x + 1]);
	            x++;
	          }
	          break;
	        }
	        case 3 : {
	          if (!pathFound) {
	            lis.clear();
	          }
	          while (y + 1 < 8 && x + 1 < 8) {
	            Piece p = this.tiles[y + 1][x + 1].getPiece();
	            if (p != null) {
	              Color col = this.tiles[y + 1][x + 1].getPiece().getColor();
	              if (!c.equals(col)) {
	                if ((p instanceof Bishop || p instanceof Queen) && !pathFound) {
	                  lis.add(this.tiles[y + 1][x + 1]);
	                  pathFound = true;
	                  kingPathFound = true;
	                }
	              }
	              break;
	            }
	            if (!pathFound)
	            lis.add(this.tiles[y + 1][x + 1]);
	            y++;
	            x++;
	          }
	          break;
	        }
	        case 4 : {
	          if (!pathFound) {
	            lis.clear();
	          }
	          while (y + 1 < 8) {
	            Piece p = this.tiles[y + 1][x].getPiece();
	            if (p != null) {
	              Color col = this.tiles[y + 1][x].getPiece().getColor();
	              if (!c.equals(col)) {
	                if ((p instanceof Rook || p instanceof Queen) && !pathFound) {
	                  lis.add(this.tiles[y + 1][x]);
	                  pathFound = true;
	                  kingPathFound = true;
	                }
	              }
	              break;
	            }
	            if (!pathFound)
	            lis.add(this.tiles[y + 1][x]);
	            y++;
	          }
	          break;
	        }
	        case 5 : {
	          if (!pathFound) {
	            lis.clear();
	          }
	          while (y + 1 < 8 && x - 1 >= 0) {
	            Piece p = this.tiles[y + 1][x - 1].getPiece();
	            if (p != null) {
	              Color col = this.tiles[y + 1][x - 1].getPiece().getColor();
	              if (!c.equals(col)) {
	                if ((p instanceof Bishop || p instanceof Queen) && !pathFound) {
	                  lis.add(this.tiles[y + 1][x - 1]);
	                  pathFound = true;
	                  kingPathFound = true;
	                }
	              }
	              break;
	            }
	            if (!pathFound)
	            lis.add(this.tiles[y + 1][x - 1]);
	            y++;
	            x--;
	          }
	          break;
	        }
	        case 6 : {
	          if (!pathFound) {
	            lis.clear();
	          }
	          while (x - 1 >= 0) {
	            Piece p = this.tiles[y][x - 1].getPiece();
	            if (p != null) {
	              Color col = this.tiles[y][x - 1].getPiece().getColor();
	              if (!c.equals(col)) {
	                if ((p instanceof Rook || p instanceof Queen) && !pathFound) {
	                  lis.add(this.tiles[y][x - 1]);
	                  pathFound = true;
	                  kingPathFound = true;
	                }
	              }
	              break;
	            }
	            if (!pathFound)
	            lis.add(this.tiles[y][x - 1]);
	            x--;
	          }
	          break;
	        }
	        default : {
	          if (!pathFound) {
	            lis.clear();
	          }
	          while (y - 1 >= 0 && x - 1 >= 0) {
	            Piece p = this.tiles[y - 1][x - 1].getPiece();
	            if (p != null) {
	              Color col = this.tiles[y - 1][x - 1].getPiece().getColor();
	              if (!c.equals(col)) {
	                if ((p instanceof Rook || p instanceof Queen) && !pathFound) {
	                  lis.add(this.tiles[y - 1][x - 1]);
	                  pathFound = true;
	                  kingPathFound = true;
	                }
	              }
	              break;
	            }
	            if (!pathFound)
	            lis.add(this.tiles[y - 1][x - 1]);
	            y--;
	            x--;
	          }
	          break;
	        }
	      }
	          if (buttons[(i + 4) % 8].button != null && !kingPathFound) {
	            if (buttons[(i + 4) % 8].isRemoved) {
	              this.kingsButton[colIndex].getPiece().getPath().add(buttons[(i + 4) % 8].button);
	            }
	          }
	    }
	  }
	  return lis;
	    }
void reducePath(Color color, Game g) {
	  int colIndex = g.getTurnCount() % 2;
	  int oppositeColor = (colIndex + 1) % 2;
	  Color c = g.getTurnColor();
	  boolean isCheck = this.isKingInCheck(c, g);
	  int x = g.getBoard().kingsButton[colIndex].getPosition().getX();
	  int y = g.getBoard().kingsButton[colIndex].getPosition().getY();
	  if (isCheck) {
	    Duple[] buts = new Duple[8];
	    for (int i = 0; i < 8; i++)
	      buts[i] = new Duple(null, false);
	    if (y - 1 >= 0) {
	      buts[0].button = g.getBoard().tiles[y - 1][x];
	      if (x + 1 < 8)
	        buts[1].button = g.getBoard().tiles[y - 1][x + 1];
	      if (x - 1 >= 0)
	        buts[7].button = g.getBoard().tiles[y - 1][x - 1];
	    }
	    if (x + 1 < 8)
	      buts[2].button = g.getBoard().tiles[y][x + 1];
	    if (y + 1 < 8) {
	      if (x + 1 < 8)
	        buts[3].button = g.getBoard().tiles[y + 1][x + 1];
	      buts[4].button = g.getBoard().tiles[y + 1][x];
	      if (x - 1 >= 0)
	        buts[5].button = g.getBoard().tiles[y + 1][x - 1];
	    }
	    if (x - 1 >= 0)
	      buts[6].button = g.getBoard().tiles[y][x - 1];
	    for (int i = 0; i < 8; i++) {
	        if (buts[i].button != null) {
	          for (Piece p : g.getBoard().causedCheck) {
	            if (p.getPath().contains(buts[i].button) && g.getBoard().kingsButton[colIndex].getPiece().getPath().contains(buts[(i + 4) % 8].button)) {
	              g.getBoard().kingsButton[colIndex].getPiece().getPath().remove(buts[(i + 4) % 8].button);
	              buts[(i + 4) % 8].isRemoved = true;
	            }
	          }
	        }
	    }
	    for (Piece p : g.getBoard().causedCheck) {
	      for (Piece q : g.getBoard().pieces[colIndex]) {
	        if (!(q instanceof King)) {
	        	// If knight caused check, King MUST move unless allied piece can capture it
	        if (p instanceof Knight) {
	        	Tile potentialCapture = null;
	        	if (q.getPath().contains(g.getBoard().tiles[p.getPosition().getY()][p.getPosition().getX()]))
	        		potentialCapture = g.getBoard().tiles[p.getPosition().getY()][p.getPosition().getX()];
	            q.getPath().clear();
	            q.getPath().add(g.getBoard().tiles[q.getPosition().getY()][q.getPosition().getX()]);
	            if (potentialCapture != null)
	            	q.getPath().add(potentialCapture);
	        }
	        else {
	        ArrayList<Tile> lis = this.intersection(p.getPath(), q.getPath());
	        if (!lis.isEmpty()) {
	          ArrayList<Tile> toAdd = g.getBoard().checkPaths(c, isCheck, buts, g);
	          toAdd.add(g.getBoard().tiles[p.getPosition().getY()][p.getPosition().getX()]);
	          Iterator<Tile> iter = q.getPath().iterator();
	          while (iter.hasNext()) {
	            Tile but = iter.next();
	            if (!toAdd.contains(but)) {
	              iter.remove();
	            }
	          }
	          if (!q.getPath().contains(g.getBoard().tiles[q.getPosition().getY()][q.getPosition().getX()]))
	          q.getPath().add(g.getBoard().tiles[q.getPosition().getY()][q.getPosition().getX()]);
	        }
	        else {
	          q.getPath().clear();
	          q.getPath().add(g.getBoard().tiles[q.getPosition().getY()][q.getPosition().getX()]);
	        }
	      }
	        }
	        else {
	          g.getBoard().checkPaths(c, isCheck, buts, g);
	        }
	      }
	    }
	  }
	  Iterator<Tile> iter = g.getBoard().kingsButton[colIndex].getPiece().getPath().iterator();
	  while (iter.hasNext()) {
	    Tile but = iter.next();
	    if (but.getPiece() != null) {
	      Piece p = but.getPiece();
	      if (!(p instanceof King) && p.getColor().equals(Constants.colors[oppositeColor])) {
	      but.setPiece(null);
	      g.getBoard().pieces[oppositeColor].remove(p);
	      for (Piece q : g.getBoard().pieces[oppositeColor]) {
	        q.setPath(g, g.getBoard().tiles[q.getPosition().getY()][q.getPosition().getX()]);
	      }
	      if (g.getBoard().isTileInDanger(but, g) && g.getBoard().kingsButton[colIndex].getPiece().getPath().contains(but)) {
	        iter.remove();
	      }
	      but.setPiece(p);
	      g.getBoard().pieces[oppositeColor].add(p);
	      for (Piece q : g.getBoard().pieces[oppositeColor]) {
	        q.setPath(g, g.getBoard().tiles[q.getPosition().getY()][q.getPosition().getX()]);
	      }
	    }
	    }
	    else {
	      if (g.getBoard().isTileInDanger(but, g) && g.getBoard().kingsButton[colIndex].getPiece().getPath().contains(but)) {
	        iter.remove();
	      }
	    }
	  }
	  if (y >= 0 && y < 8) {
	    if (x + 2 < 8) {
	      if (g.getBoard().kingsButton[colIndex].getPiece().getPath().contains(g.getBoard().tiles[y][x + 2])) {
	        if (!g.getBoard().kingsButton[colIndex].getPiece().getPath().contains(g.getBoard().tiles[y][x + 1]) || isCheck) {
	          g.getBoard().kingsButton[colIndex].getPiece().getPath().remove(g.getBoard().tiles[y][x + 2]);
	        }
	      }
	  }
	    if (x - 2 >= 0) {
	      if (g.getBoard().kingsButton[colIndex].getPiece().getPath().contains(g.getBoard().tiles[y][x - 2])) {
	        if (!g.getBoard().kingsButton[colIndex].getPiece().getPath().contains(g.getBoard().tiles[y][x - 1]) || isCheck) {
	          g.getBoard().kingsButton[colIndex].getPiece().getPath().remove(g.getBoard().tiles[y][x - 2]);
	        }
	      }
	    }
	  }
	}
void takeMePath(Color turnColor, Game g) {
	  int colIndex = g.getTurnCount() % 2;
	  int oppositeCol = (colIndex + 1) % 2;
	  g.getBoard().take.clear();
	  ArrayList<Piece> takeMe = new ArrayList<Piece>();
	  Piece enPass = null;
	  for (Piece p : this.pieces[colIndex]) {
	    for (Piece q : this.pieces[oppositeCol]) {
	      if (p.getPath().contains(this.tiles[q.getPosition().getY()][q.getPosition().getX()])) {
	        g.getTakeRed().add(this.tiles[q.getPosition().getY()][q.getPosition().getX()]);
	        this.tiles[q.getPosition().getY()][q.getPosition().getX()].setBackground(Color.RED);
	        g.getBoard().take.put(p, p.getPath());
	        takeMe.add(q);
	      }
	    }
	  }
	  for (Piece p : this.pieces[colIndex]) {
	    if (p instanceof Pawn) {
	      int x = p.getPosition().getX();
	      int y = p.getPosition().getY();
	      if (p.getColor().equals(Constants.colors[0])) {
	        if (y - 1 >= 0) {
	          if (x - 1 >= 0) {
	            Tile but = this.tiles[y - 1][x - 1];
	            if (p.getPath().contains(but) && but.getPiece() == null && enPass == null) {
	              enPass = p;
	              g.getBoard().take.put(enPass, enPass.getPath());
	              takeMe.add(enPass);
	              g.setTakeCyan(but);
	              but.setBackground(Color.CYAN);
	              g.getTakeRed().add(this.tiles[y][x - 1]);
	              this.tiles[y][x - 1].setBackground(Color.RED);
	            }
	          }
	          if (x + 1 < 8) {
	            Tile but = this.tiles[y - 1][x + 1];
	            if (p.getPath().contains(but) && but.getPiece() == null && enPass == null) {
	              enPass = p;
	              g.getBoard().take.put(enPass, enPass.getPath());
	              takeMe.add(enPass);
	              g.setTakeCyan(but);
	              but.setBackground(Color.CYAN);
	              g.getTakeRed().add(this.tiles[y][x + 1]);
	              this.tiles[y][x + 1].setBackground(Color.RED);
	            }
	          }
	        }
	      }
	      else {
	        if (y + 1 < 8) {
	          if (x - 1 >= 0) {
	            Tile but = this.tiles[y + 1][x - 1];
	            if (p.getPath().contains(but) && but.getPiece() == null && enPass == null) {
	              enPass = p;
	              g.getBoard().take.put(enPass, enPass.getPath());
	              takeMe.add(enPass);
	              g.setTakeCyan(but);
	              but.setBackground(Color.CYAN);
	              g.getTakeRed().add(this.tiles[y][x - 1]);
	              this.tiles[y][x - 1].setBackground(Color.RED);
	            }
	          }
	          if (x + 1 < 8) {
	            Tile but = this.tiles[y + 1][x + 1];
	            if (p.getPath().contains(but) && but.getPiece() == null && enPass == null) {
	              enPass = p;
	              g.getBoard().take.put(enPass, enPass.getPath());
	              takeMe.add(enPass);
	              g.setTakeCyan(but);
	              but.setBackground(Color.CYAN);
	              g.getTakeRed().add(this.tiles[y][x + 1]);
	              this.tiles[y][x + 1].setBackground(Color.RED);
	            }
	          }
	        }
	      }
	    }
	  }
	  if (!takeMe.isEmpty()) {
	  for (Piece p : this.pieces[colIndex]) {
	    if (p != enPass) {
	    if (g.getBoard().take.get(p) != null) {
	      g.setTakeCyan(this.tiles[p.getPosition().getY()][p.getPosition().getX()]);
	      this.tiles[p.getPosition().getY()][p.getPosition().getX()].setBackground(Color.CYAN);
	      Iterator<Tile> iter = g.getBoard().take.get(p).iterator();
	      while (iter.hasNext()) {
	        Tile but = iter.next();
	        if (but.getPiece() == null)
	          iter.remove();
	      }
	    }
	    else {
	      p.getPath().clear();
	      p.getPath().add(this.tiles[p.getPosition().getY()][p.getPosition().getX()]);
	    }
	  }
	  }
	  }
	  if (g.getBoard().take.get(enPass) != null) {
	    int x = enPass.getPosition().getX();
	    int y = enPass.getPosition().getY();
	    g.setTakeCyan(this.tiles[y][x]);
	    this.tiles[y][x].setBackground(Color.CYAN);
	    if (enPass.getColor().equals(Constants.colors[0])) {
	      g.getBoard().take.get(enPass).remove(this.tiles[y - 1][x]);
	    }
	    else {
	      g.getBoard().take.get(enPass).remove(this.tiles[y + 1][x]);
	    }
	  }
	}
void checkMate(Color color, Game g) {
	  if (!g.getTakeMeEnabled()) {
	  int colIndex = (color.equals(Constants.colors[0])) ? 0 : 1;
	  int oppositeColor = (colIndex + 1) % 2;
	  int largestPath = 0;
	  for (Piece p : this.pieces[colIndex]) {
	    if (p.getPath().size() > largestPath) {
	      largestPath = p.getPath().size();
	    }
	  }
	  if (largestPath == 1) {
	    if (!g.getcurrKingCheck()) {
	      g.getMoveList().add("Stalemate!");
	      JOptionPane.showMessageDialog(null, "The game has ended in stalemate!", "STALEMATE!", JOptionPane.ERROR_MESSAGE, Constants.images[oppositeColor][Constants.rand.nextInt(Constants.images[oppositeColor].length)]);
	      g.setGameEnded(true);
	    }
	    else {
	      g.getMoveList().add("Checkmate!");
	      JOptionPane.showMessageDialog(null, "Checkmate!  " + ((oppositeColor == 0) ? "White" : "Black")  + " wins!", "Long live the King!", JOptionPane.ERROR_MESSAGE, Constants.images[oppositeColor][Constants.rand.nextInt(Constants.images[oppositeColor].length)]);
	      g.setGameEnded(true);
	    }
	  }
	  if (!isCheckPossible(g) && !g.getGameEnded()) {
	    JOptionPane.showMessageDialog(null, "Checkmate is very hard or impossible to acieve with this board.  Start a new game to declare a draw!", "Very few pieces left!", JOptionPane.ERROR_MESSAGE, Constants.images[oppositeColor][Constants.rand.nextInt(Constants.images[oppositeColor].length)]);
	    g.setGameEnded(true);
	  }
	  }
	  else {
	      if (this.pieces[g.getTurnCount() % 2].isEmpty()) {
	    	g.getMoveList().add("Game ended!");
	        JOptionPane.showMessageDialog(null, "No pieces left!  " + ((g.getTurnCount() % 2 == 0) ? "White ": "Black ") + "wins!", "Ran out of pieces!", JOptionPane.ERROR_MESSAGE, Constants.images[g.getTurnCount() % 2][Constants.rand.nextInt(Constants.images[g.getTurnCount() % 2].length)]);
	        g.setGameEnded(true);
	      }
	  }
	}
boolean isCheckPossible(Game g) {
  int colIndex = g.getTurnCount() % 2;
  int oppositeCol = (g.getTurnCount() + 1) % 2;
  int turnSize = this.pieces[colIndex].size();
  int otherSize = this.pieces[oppositeCol].size();
  if (turnSize <= 3 || otherSize <= 3) {
    if (turnSize == 1 && otherSize == 1) {
      return false;
    }
	int queenCount = 0;
	int bishopCount = 0;
	int rookCount = 0;
	int pawnCount = 0;
    if (turnSize == 1 || otherSize == 1) {
    	for (Piece p : this.pieces[turnSize == 1 ? oppositeCol : colIndex]) {
    		if (p instanceof Queen)
    			queenCount++;
    		if (p instanceof Bishop)
    			bishopCount++;
    		if (p instanceof Rook)
    			rookCount++;
    		if (p instanceof Pawn)
    			pawnCount++;
    	}
    	if (queenCount == 0 && rookCount == 0 && !this.windowDisplayed) {
    		this.windowDisplayed = true;
    		return (pawnCount == 1 && bishopCount == 0) || (pawnCount == 0 && bishopCount > 1);
    	}
    }
  }
  return true;
}
void pinnedPieces(Color color) {
	  int colIndex = color.equals(Constants.colors[0]) ? 0 : 1;
	  Tile kingSpace = this.kingsButton[colIndex]; 
	  int kingX = kingSpace.getPosition().getX();
	  int kingY = kingSpace.getPosition().getY();
	  int i = kingY;
	  int j = kingX;
	  ArrayList<Tile> newPath = new ArrayList<Tile>();
	  for (int k = 0; k < 8; k++) {
	    int counter = 0;
	    Piece potentialPin = null;
	    i = kingSpace.getPosition().getX();
	    j = kingSpace.getPosition().getY();
	    newPath.clear();
	    switch(k) {
	      case 0: {
	        // North
	        while (j > 0) {
	          if (this.tiles[j - 1][i].getPiece() != null) { 
	            if (this.tiles[j - 1][i].getPiece().getColor().equals(color)) {
	              if (counter == 0)
	            	  potentialPin = this.tiles[j - 1][i].getPiece();
	            }
	            else {
	              if (this.tiles[j - 1][i].getPiece() instanceof Rook || this.tiles[j - 1][i].getPiece() instanceof Queen) {
	                if (potentialPin != null) {
	                  if (potentialPin instanceof Pawn) {
	                  int pawnX = potentialPin.getPosition().getX();
	                  int pawnY = potentialPin.getPosition().getY();
	                    if (pawnY - 1 >= 0) {
	                      if (pawnX - 1 >= 0) {
	                        if (potentialPin.getPath().contains(this.tiles[pawnY - 1][pawnX - 1])) {
	                          potentialPin.getPath().remove(this.tiles[pawnY - 1][pawnX - 1]);
	                        }
	                      }
	                      if (pawnX + 1 < 8) {
	                        if (potentialPin.getPath().contains(this.tiles[pawnY - 1][pawnX + 1])) {
	                          potentialPin.getPath().remove(this.tiles[pawnY - 1][pawnX + 1]);
	                        }
	                      }
	                   }
	                }
	                  else {
	                    if (potentialPin instanceof Rook || potentialPin instanceof Queen) {
	                      newPath.add(this.tiles[j - 1][i]);
	                      potentialPin.getPath().clear();
	                      potentialPin.getPath().addAll(newPath);
	                    }
	                    else {
	                      potentialPin.getPath().clear();
	                      potentialPin.getPath().add(this.tiles[potentialPin.getPosition().getY()][potentialPin.getPosition().getX()]);
	                    }
	                  }
	              }
	            }
	          }
	           counter+=1;
	        }
	          if (counter <= 1 && !(this.tiles[j - 1][i].getPiece() instanceof King)) {
	            newPath.add(this.tiles[j - 1][i]);
	          }
	          if (counter > 1) {
	            break;
	          }
	          j--;
	      }
	        break;
	      }
	      case 1: {
	        // Northeast
	          while (j >= 0 && i < 8) {
	          if (this.tiles[j][i].getPiece() != null) {
	            if (this.tiles[j][i].getPiece().getColor().equals(color) && !(this.tiles[j][i].getPiece() instanceof King)) {
	              potentialPin = this.tiles[j][i].getPiece();
	              counter+=1;
	            }
	            if ((this.tiles[j][i].getPiece() instanceof Bishop || this.tiles[j][i].getPiece() instanceof Queen) 
	                  && counter == 1 && !this.tiles[j][i].getPiece().getColor().equals(color)) {
	              newPath.add(this.tiles[j][i]);
	              potentialPin.getPath().clear();
	              if (potentialPin instanceof Bishop || potentialPin instanceof Queen) {
	              potentialPin.getPath().addAll(newPath);
	              }
	              else {
	                if (potentialPin instanceof Pawn) {
	                  int ex = potentialPin.getPosition().getX();
	                  int why = potentialPin.getPosition().getY();
	                  if (why - 1 >= 0 && ex + 1 < 8) {
	                    if (this.tiles[why - 1][ex + 1].getPiece() != null) {
	                      if (!this.tiles[why - 1][ex + 1].getPiece().getColor().equals(potentialPin.getColor())) {
	                        potentialPin.getPath().add(this.tiles[why - 1][ex + 1]);
	                      }
	                    }
	                  }
	                }
	                potentialPin.getPath().add(this.tiles[potentialPin.getPosition().getY()][potentialPin.getPosition().getX()]);
	              }
	              break;
	            }
	          }
	          else {
	          }
	          if (counter <= 1 && !(this.tiles[j][i].getPiece() instanceof King)) {
	            newPath.add(this.tiles[j][i]);
	          }
	          i++;
	          j--;
	        }
	        break;
	      }
	      case 2: {
	        // east
	          while (i < 7) {
	          if (this.tiles[j][i + 1].getPiece() != null) {
	            if (this.tiles[j][i + 1].getPiece().getColor().equals(color)) {
	              if (counter == 0)
	              potentialPin = this.tiles[j][i + 1].getPiece();
	            }
	            else {
	              if (this.tiles[j][i + 1].getPiece() instanceof Rook || this.tiles[j][i + 1].getPiece() instanceof Queen) {
	                if (potentialPin != null) {
	                    if (potentialPin instanceof Rook || potentialPin instanceof Queen) {
	                      newPath.add(this.tiles[j][i + 1]);
	                      potentialPin.getPath().clear();
	                      potentialPin.getPath().addAll(newPath);
	                    }
	                    else {
	                      potentialPin.getPath().clear();
	                      potentialPin.getPath().add(this.tiles[potentialPin.getPosition().getY()][potentialPin.getPosition().getX()]);
	                  }
	              }
	            }
	          }
	           counter+=1;
	        }
	          if (counter <= 1 && !(this.tiles[j][i + 1].getPiece() instanceof King)) {
	            newPath.add(this.tiles[j][i + 1]);
	          }
	          if (counter > 1) {
	            break;
	          }
	          i++;
	        }
	        break;
	      }
	      case 3: {
	        // SouthEast
	          while (j < 8 && i < 8) {
	          if (this.tiles[j][i].getPiece() != null) {
	            if (this.tiles[j][i].getPiece().getColor().equals(color) && !(this.tiles[j][i].getPiece() instanceof King)) {
	              potentialPin = this.tiles[j][i].getPiece();
	              counter+=1;
	            }
	            if ((this.tiles[j][i].getPiece() instanceof Bishop || this.tiles[j][i].getPiece() instanceof Queen) 
	                  && counter == 1 && !this.tiles[j][i].getPiece().getColor().equals(color)) {
	              newPath.add(this.tiles[j][i]);
	              potentialPin.getPath().clear();
	              if (potentialPin instanceof Bishop || potentialPin instanceof Queen) {
	              potentialPin.getPath().addAll(newPath);
	              }
	              else {
	                if (potentialPin instanceof Pawn) {
	                  int ex = potentialPin.getPosition().getX();
	                  int why = potentialPin.getPosition().getY();
	                  if (why + 1 < 8 && ex + 1 < 8) {
	                    if (this.tiles[why + 1][ex + 1].getPiece() != null) {
	                      if (!this.tiles[why + 1][ex + 1].getPiece().getColor().equals(potentialPin.getColor())) {
	                        potentialPin.getPath().add(this.tiles[why + 1][ex + 1]);
	                      }
	                    }
	                  }
	                }
	                potentialPin.getPath().add(this.tiles[potentialPin.getPosition().getY()][potentialPin.getPosition().getX()]);
	              }
	              break;
	            }
	          }
	          if (counter <= 1 && !(this.tiles[j][i].getPiece() instanceof King)) {
	            newPath.add(this.tiles[j][i]);
	          }
	          i++;
	          j++;
	        }
	        break;
	      }
	      case 4: {
	        // South
	          while (j < 7) {
	          if (this.tiles[j + 1][i].getPiece() != null) {
	            if (this.tiles[j + 1][i].getPiece().getColor().equals(color)) {
	              if (counter == 0)
	              potentialPin = this.tiles[j + 1][i].getPiece();
	            }
	            else {
	              if (this.tiles[j + 1][i].getPiece() instanceof Rook || this.tiles[j + 1][i].getPiece() instanceof Queen) {
	                if (potentialPin != null) {
	                  if (potentialPin instanceof Pawn) {
	                  int pawnX = potentialPin.getPosition().getX();
	                  int pawnY = potentialPin.getPosition().getY();
	                    if (pawnY + 1 < 8) {
	                      if (pawnX - 1 >= 0) {
	                        if (potentialPin.getPath().contains(this.tiles[pawnY + 1][pawnX - 1])) {
	                          potentialPin.getPath().remove(this.tiles[pawnY + 1][pawnX - 1]);
	                        }
	                      }
	                      if (pawnX + 1 < 8) {
	                        if (potentialPin.getPath().contains(this.tiles[pawnY + 1][pawnX + 1])) {
	                          potentialPin.getPath().remove(this.tiles[pawnY + 1][pawnX + 1]);
	                        }
	                      }
	                   }
	                }
	                  else {
	                    if (potentialPin instanceof Rook || potentialPin instanceof Queen) {
	                      newPath.add(this.tiles[j + 1][i]);
	                      potentialPin.getPath().clear();
	                      potentialPin.getPath().addAll(newPath);
	                    }
	                    else {
	                      potentialPin.getPath().clear();
	                      potentialPin.getPath().add(this.tiles[potentialPin.getPosition().getY()][potentialPin.getPosition().getX()]);
	                    }
	                  }
	              }
	            }
	          }
	           counter+=1;
	        }
	          if (counter <= 1 && !(this.tiles[j + 1][i].getPiece() instanceof King)) {
	            newPath.add(this.tiles[j + 1][i]);
	          }
	          if (counter > 1) {
	            break;
	          }
	          j++;
	        }
	        break;
	      }
	      case 5 : {
	        // SouthWest
	          while (j < 8 && i >= 0) {
	          if (this.tiles[j][i].getPiece() != null) {
	            if (this.tiles[j][i].getPiece().getColor().equals(color) && !(this.tiles[j][i].getPiece() instanceof King)) {
	              potentialPin = this.tiles[j][i].getPiece();
	              counter+=1;
	            }
	            if ((this.tiles[j][i].getPiece() instanceof Bishop || this.tiles[j][i].getPiece() instanceof Queen) 
	                  && counter == 1 && !this.tiles[j][i].getPiece().getColor().equals(color)) {
	              newPath.add(this.tiles[j][i]);
	              potentialPin.getPath().clear();
	              if (potentialPin instanceof Bishop || potentialPin instanceof Queen) {
	              potentialPin.getPath().addAll(newPath);
	              }
	              else {
	                if (potentialPin instanceof Pawn) {
	                  int ex = potentialPin.getPosition().getX();
	                  int why = potentialPin.getPosition().getY();
	                  if (why + 1 < 8 && ex - 1 >= 0) {
	                    if (this.tiles[why + 1][ex - 1].getPiece() != null) {
	                      if (!this.tiles[why + 1][ex - 1].getPiece().getColor().equals(potentialPin.getColor())) {
	                        potentialPin.getPath().add(this.tiles[why + 1][ex - 1]);
	                      }
	                    }
	                  }
	                }
	                potentialPin.getPath().add(this.tiles[potentialPin.getPosition().getY()][potentialPin.getPosition().getX()]);
	              }
	              break;
	            }
	          }
	          if (counter <= 1 && !(this.tiles[j][i].getPiece() instanceof King)) {
	            newPath.add(this.tiles[j][i]);
	          }
	          i--;
	          j++;
	        }
	        break;
	      }
	      case 6: {
	        // West
	          while (i > 0) {
	          if (this.tiles[j][i - 1].getPiece() != null) {
	            if (this.tiles[j][i - 1].getPiece().getColor().equals(color)) {
	              if (counter == 0)
	              potentialPin = this.tiles[j][i - 1].getPiece();
	            }
	            else {
	              if (this.tiles[j][i - 1].getPiece() instanceof Rook || this.tiles[j][i - 1].getPiece() instanceof Queen) {
	                if (potentialPin != null) {
	                    if (potentialPin instanceof Rook || potentialPin instanceof Queen) {
	                      newPath.add(this.tiles[j][i - 1]);
	                      potentialPin.getPath().clear();
	                      potentialPin.getPath().addAll(newPath);
	                    }
	                    else {
	                      potentialPin.getPath().clear();
	                      potentialPin.getPath().add(this.tiles[potentialPin.getPosition().getY()][potentialPin.getPosition().getX()]);
	                   }
	              }
	            }
	          }
	           counter+=1;
	        }
	          if (counter <= 1 && !(this.tiles[j][i - 1].getPiece() instanceof King)) {
	            newPath.add(this.tiles[j][i - 1]);
	          }
	          if (counter > 1) {
	            break;
	          }
	          i--;
	        }
	        break;
	      }
	      default : {
	        // NorthWest
	          while (j >= 0 && i >= 0) {
	          if (this.tiles[j][i].getPiece() != null) {
	            if (this.tiles[j][i].getPiece().getColor().equals(color) && !(this.tiles[j][i].getPiece() instanceof King)) {
	              potentialPin = this.tiles[j][i].getPiece();
	              counter+=1;
	            }
	            if ((this.tiles[j][i].getPiece() instanceof Bishop || this.tiles[j][i].getPiece() instanceof Queen) 
	                  && counter == 1 && !this.tiles[j][i].getPiece().getColor().equals(color)) {
	              newPath.add(this.tiles[j][i]);
	              potentialPin.getPath().clear();
	              if (potentialPin instanceof Bishop || potentialPin instanceof Queen) {
	              potentialPin.getPath().addAll(newPath);
	              }
	              else {
	                if (potentialPin instanceof Pawn) {
	                  int ex = potentialPin.getPosition().getX();
	                  int why = potentialPin.getPosition().getY();
	                  if (why - 1 >= 0 && ex - 1 >= 0) {
	                    if (this.tiles[why - 1][ex - 1].getPiece() != null) {
	                      if (!this.tiles[why - 1][ex - 1].getPiece().getColor().equals(potentialPin.getColor())) {
	                        potentialPin.getPath().add(this.tiles[why - 1][ex - 1]);
	                      }
	                    }
	                  }
	                }
	                potentialPin.getPath().add(this.tiles[potentialPin.getPosition().getY()][potentialPin.getPosition().getX()]);
	              }
	              break;
	            }
	          }
	          if (counter <= 1 && !(this.tiles[j][i].getPiece() instanceof King)) {
	            newPath.add(this.tiles[j][i]);
	          }
	          i--;
	          j--;
	        }
	        break;
	      }
	    }
	  }
	}
Piece getRandomPiece(Game g, Color c) {
	int index = c.equals(Constants.colors[0]) ? 0 : 1;
	int randPiece = Constants.rand.nextInt(g.getBoard().pieces[index].size());
	return g.getBoard().pieces[index].get(randPiece);
}
public Tile[][] getTiles() {
	return this.tiles;
}
public ArrayList<Piece>[] getPieces() {
	return this.pieces;
}
public Tile[] getKingButton() {
	return this.kingsButton;
}
public HashMap<Piece, ArrayList<Tile>> getCheckPaths() {
  return this.checkPaths;
}
public HashMap<Piece, ArrayList<Tile>> getTake() {
  return this.take;
}
public int[][] getMaxPieceIds() {
	return this.maxPieceIds;
}
public void setMaxPieceIds(int i, int j, int val) {
	this.maxPieceIds[i][j] = val;
}
}