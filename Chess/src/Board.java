import javax.swing.JOptionPane;
import java.awt.*;
import java.io.Serializable;
import java.util.*;
public class Board implements Serializable{
Random rand = new Random();
ArrayList<Piece>[] pieces = new ArrayList[2];
ArrayList<Piece> blackPieces = new ArrayList<Piece>();
ArrayList<Piece> whitePieces = new ArrayList<Piece>();
ArrayList<Piece> causedCheck = new ArrayList<Piece>();
HashMap<Piece, ArrayList<TileButton>> checkPaths = new HashMap<Piece, ArrayList<TileButton>>();
HashMap<Piece, ArrayList<TileButton>> take = new HashMap<Piece, ArrayList<TileButton>>();
ArrayList<Piece>[] removedPieces = new ArrayList[2];
TileButton[] kingsButton = new TileButton[2];
TileButton[][] tiles = new TileButton[8][8];
//int[][] pieceCount = new int[2][6];
public Board() {
  for (int i = 0; i < 2; i++)
    pieces[i] = new ArrayList<Piece>();
  //this.tiles = this.fillTiles(0, 0);
  /*for (int i = 0; i < this.pieces.length; i++) {
    this.pieces[i] = new ArrayList<Piece>();
    for ()
  }*/
}
class Duple {
  TileButton button;
  boolean isRemoved;
  public Duple(TileButton button, boolean isRemoved) {
    this.button = button;
    this.isRemoved = isRemoved;
  }
}
public TileButton[][] fillTiles(int startX, int startY) {
  //for (int i = 0; i < 2; i++)
    //this.pieces[i] = new ArrayList<Piece>();
 TileButton[][] tis = this.tiles;
 int x = startX;
 int y = startY;
 int n = Constants.TILEWIDTH;
 int m = Constants.TILEHEIGHT;
 int index = 0;
 Constants.colors[1] = (Constants.SETTING == 1) ? new Color(60, 60, 60) : Color.BLACK;
 for (int i = 0; i < 8; i++) {
  for (int j = 0; j < 8; j++) {
   int colIndex = (i + j) % 2;
   int idNum = index % 64;
   Tile t = new Tile(n, m, idNum, x, y, Constants.colors[colIndex]);
   t.setPosition(j, i);
   TileButton b = new TileButton(t);
   Tile tile = b.getTile();
   Position fromCoord = new Position(j, i);
   if (i == 0) {
      tile.setImage(Constants.images[1][j]);
      int identification = 1;
      if (j <= 4)
       identification = 1;
      else
       identification = 2;
      switch(j) {
      case (0) : {
       tile.setPiece(new Rook(identification, Constants.colors[1], new Position(j, i), 
            tile.getImage(), tile.getImage().getDescription(), false));
       tile.hasPiece = true;
       //System.out.println(pieces[0].size());
       pieces[1].add(tile.getPiece());
       //pieceCount[1][j] += 1;
       break;
      }
      case (1) : {
       tile.setPiece(new Knight(identification, Constants.colors[1], new Position(j, i), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;
       pieces[1].add(tile.getPiece());
       //pieceCount[1][j] += 1;
       break;
      }
      case (2) : {
       tile.setPiece(new Bishop(identification, Constants.colors[1], new Position(j, i), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;
       pieces[1].add(tile.getPiece());
       //pieceCount[1][j] += 1;
       break;
      }
      case (3) : {
       tile.setPiece(new Queen(identification, Constants.colors[1], new Position(j, i), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;
       pieces[1].add(tile.getPiece());
       //pieceCount[1][j] += 1;
       break;
      }
      case (4) : {
       tile.setPiece(new King(identification, Constants.colors[1], new Position(j, i), 
         tile.getImage(), tile.getImage().getDescription(), false));
       tile.hasPiece = true;
       pieces[1].add(tile.getPiece());
       //pieceCount[1][j] += 1;
       kingsButton[1] = b;
       break;
      }
      case (5) : {
       tile.setPiece(new Bishop(identification, Constants.colors[1], new Position(j, i), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;
       pieces[1].add(tile.getPiece());
       //pieceCount[1][2] += 1;
       break;
      }
      case (6) : {
       tile.setPiece(new Knight(identification, Constants.colors[1], new Position(j, i), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;  
       pieces[1].add(tile.getPiece());
       //pieceCount[1][1] += 1;
       break;
      }
      case (7) : {
       tile.setPiece(new Rook(identification, Constants.colors[1], new Position(j, i), 
            tile.getImage(), tile.getImage().getDescription(), false));
       tile.hasPiece = true;      
       pieces[1].add(tile.getPiece());
       //pieceCount[1][0] += 1;
       break;
      }
      }
     }
     if (i == 1) {
      tile.setImage(Constants.images[1][Constants.images[1].length - 1]);
      tile.setPiece(new Pawn(j + 1, Constants.colors[1], new Position(j, i), 
         tile.getImage(), tile.getImage().getDescription(), false));
      tile.hasPiece = true;      
      pieces[1].add(tile.getPiece());
      //pieceCount[1][5] += 1;
     }
     if (i == 6) {
      tile.setImage(Constants.images[0][Constants.images[0].length - 1]);
      tile.setPiece(new Pawn(j + 1, Constants.colors[0], new Position(j, i), 
         tile.getImage(), tile.getImage().getDescription(), false));
      tile.hasPiece = true;     
      pieces[0].add(tile.getPiece());
      //pieceCount[0][5] += 1;
     }
     if (i == 7) {
      tile.setImage(Constants.images[0][j]);
      int identification = 1;
      if (j <= 4)
       identification = 1;
      else
       identification = 2;
      switch(j) {
      case (0) : {
       tile.setPiece(new Rook(identification, Constants.colors[0], new Position(j, i), 
            tile.getImage(), tile.getImage().getDescription(), false));
       tile.hasPiece = true;       
       pieces[0].add(tile.getPiece());
       //pieceCount[0][j] += 1;
       break;
      }
      case (1) : {
       tile.setPiece(new Knight(identification, Constants.colors[0], new Position(j, i), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;      
       pieces[0].add(tile.getPiece());
       //pieceCount[0][j] += 1;
       break;
      }
      case (2) : {
       tile.setPiece(new Bishop(identification, Constants.colors[0], new Position(j, i), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;       
       pieces[0].add(tile.getPiece());
       //pieceCount[0][j] += 1;
       break;
      }
      case (3) : {
       tile.setPiece(new Queen(identification, Constants.colors[0], new Position(j, i), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;       
       pieces[0].add(tile.getPiece());
       //pieceCount[0][j] += 1;
       break;
      }
      case (4) : {
       tile.setPiece(new King(identification, Constants.colors[0], new Position(j, i), 
         tile.getImage(), tile.getImage().getDescription(), false));
       tile.hasPiece = true;       
       pieces[0].add(tile.getPiece());
       //pieceCount[0][j] += 1;
       kingsButton[0] = b;
       break;
      }
      case (5) : {
       tile.setPiece(new Bishop(identification, Constants.colors[0], new Position(j, i), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;       
       pieces[0].add(tile.getPiece());
       //pieceCount[0][2] += 1;
       break;
      }
      case (6) : {
       tile.setPiece(new Knight(identification, Constants.colors[0], new Position(j, i), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;       
       pieces[0].add(tile.getPiece());
       //pieceCount[0][1] += 1;
       break;
      }
      case (7) : {
       tile.setPiece(new Rook(identification, Constants.colors[0], new Position(j, i), 
            tile.getImage(), tile.getImage().getDescription(), false));
       tile.hasPiece = true;
       pieces[0].add(tile.getPiece());
       //pieceCount[0][0] += 1;
       break;
      }
      }
     }
     tis[i][j] = b;
     x += n;
     index++;
     if (j % 8 == 7) {
      x = startX;
      y += m;
     }
  }
  }
 return tis;
}
public TileButton[][] fillTiles2(int startX, int startY, ArrayList<Piece>[] lis) {
 TileButton[][] tis = this.tiles;
 int x = startX;
 int y = startY;
 int n = Constants.TILEWIDTH;
 int m = Constants.TILEHEIGHT;
 Constants.colors[1] = (Constants.SETTING == 1) ? new Color(60, 60, 60) : Color.BLACK;
 int index = 0;
 for (int i = 0; i < 8; i++) {
  for (int j = 0; j < 8; j++) {
   int colIndex = (i + j) % 2;
   int idNum = index % 64;
   Tile t = new Tile(n, m, idNum, x, y, Constants.colors[colIndex]);
   t.setPosition(j, i);
   TileButton b = new TileButton(t);
   tis[i][j] = b;
   index++;
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
       if (p instanceof King) {
       this.kingsButton[i] = tis[y][x];
       /*this.pieceCount[i][4] += 1;
       if (Constants.maxFreqs[4] > 1)
       Constants.maxFreqs[4] += 1;*/
       }
       tis[y][x].getTile().setPiece(p);
       tis[y][x].getTile().hasPiece = true;
       tis[y][x].getTile().setImage(p.getImage());
       /*if (p instanceof Rook) {
    	   this.pieceCount[i][0] += 1;
    	   if (this.pieceCount[i][0] > 2)
    	   Constants.maxFreqs[0] += 1;
       }
       if (p instanceof Knight) {
    	   this.pieceCount[i][1] += 1;
    	   if (this.pieceCount[i][1] > 2)
    	   Constants.maxFreqs[1] += 1;
       }
       if (p instanceof Bishop) {
    	   this.pieceCount[i][2] += 1;
    	   if (this.pieceCount[i][2] > 2)
    	   Constants.maxFreqs[2] += 1;
       }
       if (p instanceof Queen) {
    	   this.pieceCount[i][3] += 1;
    	   if (this.pieceCount[i][3] > 1)
    	   Constants.maxFreqs[3] += 1;
       }
       if (p instanceof Pawn) {
    	   this.pieceCount[i][5] += 1;
       }*/
 }
}
  return tis;
}
public void clearBoard() {
  this.pieces[0].clear();
  this.pieces[1].clear();
  for (TileButton[] b : this.tiles) {
    for (TileButton c : b) {
      if (c.getTile().getPiece() != null)
        c.getTile().getPiece().setImage(null);
      c.getTile().setPiece(null);
      c.getTile().hasPiece = false;
      c.getTile().setImage(null);
      c.setIcon(null);
    }
  }
  //this.pieceCount = new int[2][6];
}
public void setPieces(Game g) {
  for (int i = 0; i < this.pieces.length; i++) {
  for (Piece p : this.pieces[i]) {
    p.checkPath.clear();
    p.getPath().clear();
    Position pos = p.getPosition();
    int x = pos.getX();
    int y = pos.getY();
    //System.out.println(p);
    p.setPath(g, g.board.tiles[y][x]);
  }
  }
  }
/*public int pieceTypeCount(Piece piece) {
	int index = piece.getColor().equals(Constants.colors[0]) ? 0 : 1;
	int type = 0;
	if (piece instanceof Knight)
		type = 1;
	if (piece instanceof Bishop)
		type = 2;
	if (piece instanceof Queen)
		type = 3;
	if (piece instanceof King)
		type = 4;
	if (piece instanceof Pawn)
		type = 5;
	return this.pieceCount[index][type];
}
public void decTypeCount(Piece piece, int val) {
	int index = piece.getColor().equals(Constants.colors[0]) ? 0 : 1;
	int type = 0;
	if (piece instanceof Knight)
		type = 1;
	if (piece instanceof Bishop)
		type = 2;
	if (piece instanceof Queen)
		type = 3;
	if (piece instanceof King)
		type = 4;
	if (piece instanceof Pawn)
		type = 5;
	this.pieceCount[index][type] -= val;
}*/
public void move(TileButton prev, TileButton next, Game g) {
  int currTurn = g.getTurnCount();
  Piece p = prev.getTile().getPiece();
  Piece q = next.getTile().getPiece();
  Position posPrev = prev.getTile().getPosition();
  Position pos = next.getTile().getPosition();
  if (q != null) {
	g.moveList.add((g.moveList.size() + 1) + ". " + p.getName() + ": " + posPrev + " -> " + pos);
	System.out.println(g.moveList.get(g.moveList.size() - 1));
    g.setEnPass(null);
    p.setHasMoved();
    next.setIcon(prev.getTile().getImage());
    next.getTile().setPiece(p);
    next.getTile().setHasPiece();
    next.getTile().setImage(prev.getTile().getImage());
    next.getTile().getPiece().setImage(prev.getTile().getImage());
    next.getTile().getPiece().setPosition(pos);
    prev.setIcon(null);
    prev.getTile().setPiece(null);
    prev.getTile().setHasPiece();
    prev.getTile().setImage(null);
    this.pieces[(currTurn + 1) % 2].remove(q);
    //this.decTypeCount(q, 1);
    //System.out.println(g.getBoard().pieceCount[1][5]);
    g.capturedpieces.get(Graveyard.findIndex(q, Constants.colors[(currTurn + 1) % 2])).add(q);
  }
  else {
    if (p instanceof Pawn) {
      int posDiff = Math.abs(pos.getY() - posPrev.getY());
      Pawn pawn = (Pawn) p;
      if (posDiff == 2) {
        g.setEnPass(pawn);
      }
      else {
        int posDiffx = Math.abs(pos.getX() - posPrev.getX());
        int posDiffy = Math.abs(pos.getY() - posPrev.getY());
        if (posDiffx == 1 && posDiffy == 1) {
          TileButton tb1 = this.tiles[pos.getY() - 1][pos.getX()];
          TileButton tb2 = this.tiles[pos.getY() + 1][pos.getX()];
          TileButton[] tils = {tb1, tb2};
          for (TileButton but : tils) {
          but.setIcon(null);
          but.getTile().setPiece(null);
          but.getTile().setHasPiece();
          but.getTile().setImage(null);
          }
          this.pieces[(currTurn + 1) % 2].remove(g.getEnPass());
          //this.decTypeCount(g.getEnPass(), 1);
          g.capturedpieces.get(Graveyard.findIndex(g.getEnPass(), Constants.colors[(currTurn + 1) % 2])).add(g.getEnPass());
          System.out.println("Enpass success!!");
          //this.removedPieces[(Game.turnCount + 1) % 2].add(Game.enPassant);
        }
        g.setEnPass(null);
      }
    }
    else {
      if (p instanceof King && !Constants.takeMeChess) {
        this.kingsButton[currTurn % 2].setBackground(this.kingsButton[currTurn % 2].getTile().getColor());
        kingsButton[currTurn % 2] = next;
      }
      g.setEnPass(null);
    }
    //if (p instanceof King)
      //System.out.println(p);
	g.moveList.add((g.moveList.size() + 1) + ". " + p.getName() + ": " + posPrev + " -> " + pos);
	System.out.println(g.moveList.get(g.moveList.size() - 1));
    p.setHasMoved();
    next.setIcon(prev.getTile().getImage());
    next.getTile().setPiece(p);
    next.getTile().setHasPiece();
    next.getTile().setImage(prev.getTile().getImage());
    next.getTile().getPiece().setImage(prev.getTile().getImage());
    next.getTile().getPiece().setPosition(pos);
    prev.setIcon(null);
    prev.getTile().setPiece(null);
    prev.getTile().setHasPiece();
    prev.getTile().setImage(null);
    //if (p instanceof King)
      //System.out.println(p);
  }
}
public boolean isTileInDanger(TileButton b, Game g) {
  //int currTurn = g.getTurnCount() % 2;
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
public boolean isKingInCheck(Color color, Game g) {
  //int currTurn = g.getTurnCount();
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
public void reducePath(Color color, Game g) {
  int colIndex = g.getTurnCount() % 2;
  int oppositeColor = (colIndex + 1) % 2;
  Color c = g.getTurnColor();
  boolean isCheck = this.isKingInCheck(c, g);
  int x = g.board.kingsButton[colIndex].getTile().getPosition().getX();
  int y = g.board.kingsButton[colIndex].getTile().getPosition().getY();
  if (isCheck) {
    Duple[] buts = new Duple[8];
    for (int i = 0; i < 8; i++)
      buts[i] = new Duple(null, false);
    if (y - 1 >= 0) {
      buts[0].button = g.board.tiles[y - 1][x];
      if (x + 1 < 8)
        buts[1].button = g.board.tiles[y - 1][x + 1];
      if (x - 1 >= 0)
        buts[7].button = g.board.tiles[y - 1][x - 1];
    }
    if (x + 1 < 8)
      buts[2].button = g.board.tiles[y][x + 1];
    if (y + 1 < 8) {
      if (x + 1 < 8)
        buts[3].button = g.board.tiles[y + 1][x + 1];
      buts[4].button = g.board.tiles[y + 1][x];
      if (x - 1 >= 0)
        buts[5].button = g.board.tiles[y + 1][x - 1];
    }
    if (x - 1 >= 0)
      buts[6].button = g.board.tiles[y][x - 1];
    for (int i = 0; i < 8; i++) {
        if (buts[i].button != null) {
          for (Piece p : g.board.causedCheck) {
            if (p.getPath().contains(buts[i].button) && g.board.kingsButton[colIndex].getTile().getPiece().getPath().contains(buts[(i + 4) % 8].button)) {
              g.board.kingsButton[colIndex].getTile().getPiece().getPath().remove(buts[(i + 4) % 8].button);
              buts[(i + 4) % 8].isRemoved = true;
            }
          }
        }
    }
    for (Piece p : g.board.causedCheck) {
    	System.out.println(p);
    	for (TileButton but : p.getPath()) {
    		System.out.println("Knight Path: " + but.getTile());
    	}
      for (Piece q : g.board.pieces[colIndex]) {
        if (!(q instanceof King)) {
        	if (q instanceof Queen) {
        		for (TileButton but : q.getPath()) {
        			System.out.println("Queen Path: " + but.getTile());
        		}
        	}
        	// If knight caused check, King MUST move unless allied piece can capture it
        if (p instanceof Knight) {
        	TileButton potentialCapture = null;
        	if (q.getPath().contains(g.getBoard().tiles[p.getPosition().getY()][p.getPosition().getX()]))
        		potentialCapture = g.getBoard().tiles[p.getPosition().getY()][p.getPosition().getX()];
            q.getPath().clear();
            q.getPath().add(g.board.tiles[q.getPosition().getY()][q.getPosition().getX()]);
            if (potentialCapture != null)
            	q.getPath().add(potentialCapture);
        }
        else {
        ArrayList<TileButton> lis = TileButton.intersection(p.getPath(), q.getPath());
        //System.out.println("lis: " + lis.size());
        /*for (TileButton but : lis) {
        	System.out.println(but.getTile().getPosition());
        }*/
        if (!lis.isEmpty()) {
          ArrayList<TileButton> toAdd = g.board.checkPaths(c, isCheck, buts, g);
          //System.out.println("AddSize: " + toAdd.size());
          // Fixes glitch where can't capture during check
          toAdd.add(g.board.tiles[p.getPosition().getY()][p.getPosition().getX()]);
          if (q instanceof Queen) {
          for (TileButton but : toAdd) {
        	  System.out.println("Queen tils toReduce: " + but.getTile());
          }
          }
          Iterator<TileButton> iter = q.getPath().iterator();
          while (iter.hasNext()) {
            TileButton but = iter.next();
            if (!toAdd.contains(but)) {
            	//System.out.println("Removed");
              iter.remove();
            }
          }
          if (q instanceof Queen) {
          System.out.println(q.getPath().size());
          for (TileButton but : q.getPath()) {
        	  System.out.println("Queen's reduced path: " + but.getTile());
          }
          }
          /*if (q instanceof Queen)
          System.out.println("Post: " + q.getPath().size());*/
          // Path should be cut when opposing piece isn't threatening the king when he isn't in check
          //Iterator<TileButton> iter2 = toAdd.iterator();
          /*while (iter2.hasNext()) {
            TileButton but = iter2.next();
            if (but.getTile().getPiece() != null) {
              if (!but.getTile().getPiece().getColor().equals(Constants.colors[colIndex])) {
                if (!but.getTile().getPiece().getPath().contains(this.kingsButton[colIndex])) {
                  q.getPath().remove(but);
                }
              }
            }
          }*/
          if (!q.getPath().contains(g.board.tiles[q.getPosition().getY()][q.getPosition().getX()]))
          q.getPath().add(g.board.tiles[q.getPosition().getY()][q.getPosition().getX()]);
          //if (q instanceof Pawn && q.getId() == 5)
          //System.out.println(q.getPath().size());
        }
        else {
          q.getPath().clear();
          q.getPath().add(g.board.tiles[q.getPosition().getY()][q.getPosition().getX()]);
        }
      }
        }
        else {
          g.board.checkPaths(c, isCheck, buts, g);
        }
      }
    }
  }
  Iterator<TileButton> iter = g.board.kingsButton[colIndex].getTile().getPiece().getPath().iterator();
  while (iter.hasNext()) {
    TileButton but = iter.next();
    if (but.getTile().getPiece() != null) {
      Piece p = but.getTile().getPiece();
      //System.out.println("passed2");
      if (!(p instanceof King) && p.getColor().equals(Constants.colors[oppositeColor])) {
      //System.out.println("Ghoulsrfun");
    	  //System.out.println(but.getTile().getPiece().getName().equals(p.getName()));
      but.getTile().setPiece(null);
      g.board.pieces[oppositeColor].remove(p);
      //System.out.println("Piece removed? " + (g.board.tiles[6][6].getTile().getPiece() == null));
      for (Piece q : g.board.pieces[oppositeColor]) {
        /*if (q instanceof Knight) {
        	System.out.println("Knight Found");
        }*/
        q.setPath(g, g.board.tiles[q.getPosition().getY()][q.getPosition().getX()]);
        //System.out.println(q.getName() + ": " + q.getPos());
        //System.out.println(q.getPath().size());
        //if (q instanceof Pawn) {
        /*for (TileButton but2 : q.getPath()) {
        	System.out.println(but2.getTile().getPosition());
        }*/
       // }
      }
      if (g.board.isTileInDanger(but, g) && g.board.kingsButton[colIndex].getTile().getPiece().getPath().contains(but)) {
        iter.remove();
      }
      //System.out.println("NREm: " + g.board.kingsButton[colIndex].getTile().getPiece().getPath().contains(g.board.tiles[6][6]));
      but.getTile().setPiece(p);
      g.board.pieces[oppositeColor].add(p);
      for (Piece q : g.board.pieces[oppositeColor]) {
        q.setPath(g, g.board.tiles[q.getPosition().getY()][q.getPosition().getX()]);
      }
    }
    }
    else {
      if (g.board.isTileInDanger(but, g) && g.board.kingsButton[colIndex].getTile().getPiece().getPath().contains(but)) {
        iter.remove();
      }
    }
  }
  if (y >= 0 && y < 8) {
    if (x + 2 < 8) {
      if (g.board.kingsButton[colIndex].getTile().getPiece().getPath().contains(g.board.tiles[y][x + 2])) {
        if (!g.board.kingsButton[colIndex].getTile().getPiece().getPath().contains(g.board.tiles[y][x + 1]) || isCheck) {
          g.board.kingsButton[colIndex].getTile().getPiece().getPath().remove(g.board.tiles[y][x + 2]);
        }
      }
  }
    if (x - 2 >= 0) {
      if (g.board.kingsButton[colIndex].getTile().getPiece().getPath().contains(g.board.tiles[y][x - 2])) {
        if (!g.board.kingsButton[colIndex].getTile().getPiece().getPath().contains(g.board.tiles[y][x - 1]) || isCheck) {
          g.board.kingsButton[colIndex].getTile().getPiece().getPath().remove(g.board.tiles[y][x - 2]);
        }
      }
    }
  }
}
public void takeMePath(Color turnColor, Game g) {
  int colIndex = g.getTurnCount() % 2;
  int oppositeCol = (colIndex + 1) % 2;
  g.getBoard().take.clear();
  ArrayList<Piece> takeMe = new ArrayList<Piece>();
  Piece enPass = null;
  for (Piece p : this.pieces[colIndex]) {
    for (Piece q : this.pieces[oppositeCol]) {
      if (p.getPath().contains(this.tiles[q.getPosition().getY()][q.getPosition().getX()])) {
        g.takeRed.add(this.tiles[q.getPosition().getY()][q.getPosition().getX()]);
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
            TileButton but = this.tiles[y - 1][x - 1];
            if (p.getPath().contains(but) && but.getTile().getPiece() == null && enPass == null) {
              enPass = p;
              g.getBoard().take.put(enPass, enPass.getPath());
              takeMe.add(enPass);
              g.takeCyan = but;
              but.setBackground(Color.CYAN);
              g.takeRed.add(this.tiles[y][x - 1]);
              this.tiles[y][x - 1].setBackground(Color.RED);
            }
          }
          if (x + 1 < 8) {
            TileButton but = this.tiles[y - 1][x + 1];
            if (p.getPath().contains(but) && but.getTile().getPiece() == null && enPass == null) {
              enPass = p;
              g.getBoard().take.put(enPass, enPass.getPath());
              takeMe.add(enPass);
              g.takeCyan = but;
              but.setBackground(Color.CYAN);
              g.takeRed.add(this.tiles[y][x + 1]);
              this.tiles[y][x + 1].setBackground(Color.RED);
            }
          }
        }
      }
      else {
        if (y + 1 < 8) {
          if (x - 1 >= 0) {
            TileButton but = this.tiles[y + 1][x - 1];
            if (p.getPath().contains(but) && but.getTile().getPiece() == null && enPass == null) {
              enPass = p;
              g.getBoard().take.put(enPass, enPass.getPath());
              takeMe.add(enPass);
              g.takeCyan = but;
              but.setBackground(Color.CYAN);
              g.takeRed.add(this.tiles[y][x - 1]);
              this.tiles[y][x - 1].setBackground(Color.RED);
            }
          }
          if (x + 1 < 8) {
            TileButton but = this.tiles[y + 1][x + 1];
            if (p.getPath().contains(but) && but.getTile().getPiece() == null && enPass == null) {
              enPass = p;
              g.getBoard().take.put(enPass, enPass.getPath());
              takeMe.add(enPass);
              g.takeCyan = but;
              but.setBackground(Color.CYAN);
              g.takeRed.add(this.tiles[y][x + 1]);
              this.tiles[y][x + 1].setBackground(Color.RED);
            }
          }
        }
      }
    }
  }
  if (!takeMe.isEmpty()) {
    //System.out.println("Takeme" + this.pieces[1].size());
  for (Piece p : this.pieces[colIndex]) {
    if (p != enPass) {
    if (g.getBoard().take.get(p) != null) {
      g.takeCyan = this.tiles[p.getPosition().getY()][p.getPosition().getX()];
      this.tiles[p.getPosition().getY()][p.getPosition().getX()].setBackground(Color.CYAN);
      Iterator<TileButton> iter = g.getBoard().take.get(p).iterator();
      while (iter.hasNext()) {
        TileButton but = iter.next();
        if (but.getTile().getPiece() == null)
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
    g.takeCyan = this.tiles[y][x];
    this.tiles[y][x].setBackground(Color.CYAN);
    if (enPass.getColor().equals(Constants.colors[0])) {
      g.getBoard().take.get(enPass).remove(this.tiles[y - 1][x]);
    }
    else {
      g.getBoard().take.get(enPass).remove(this.tiles[y + 1][x]);
    }
  }
}
public ArrayList<TileButton> checkPaths(Color color, boolean check, Duple[] buttons, Game g) {
  ArrayList<TileButton> lis = new ArrayList<TileButton>();
  int colIndex = g.getTurnCount() % 2;
  Color c = g.getTurnColor();
  if (check) {
    int kingX = this.kingsButton[colIndex].getTile().getPosition().getX();
    int kingY = this.kingsButton[colIndex].getTile().getPosition().getY();
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
            Piece p = this.tiles[y - 1][x].getTile().getPiece();
            if (p != null) {
              Color col = this.tiles[y - 1][x].getTile().getPiece().getColor();
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
            Piece p = this.tiles[y - 1][x + 1].getTile().getPiece();
            if (p != null) {
              Color col = this.tiles[y - 1][x + 1].getTile().getPiece().getColor();
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
            Piece p = this.tiles[y][x + 1].getTile().getPiece();
            if (p != null) {
              Color col = this.tiles[y][x + 1].getTile().getPiece().getColor();
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
            Piece p = this.tiles[y + 1][x + 1].getTile().getPiece();
            if (p != null) {
              Color col = this.tiles[y + 1][x + 1].getTile().getPiece().getColor();
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
            Piece p = this.tiles[y + 1][x].getTile().getPiece();
            if (p != null) {
              Color col = this.tiles[y + 1][x].getTile().getPiece().getColor();
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
            Piece p = this.tiles[y + 1][x - 1].getTile().getPiece();
            if (p != null) {
              Color col = this.tiles[y + 1][x - 1].getTile().getPiece().getColor();
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
            Piece p = this.tiles[y][x - 1].getTile().getPiece();
            if (p != null) {
              Color col = this.tiles[y][x - 1].getTile().getPiece().getColor();
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
            Piece p = this.tiles[y - 1][x - 1].getTile().getPiece();
            if (p != null) {
              Color col = this.tiles[y - 1][x - 1].getTile().getPiece().getColor();
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
              this.kingsButton[colIndex].getTile().getPiece().getPath().add(buttons[(i + 4) % 8].button);
            }
          }
    }
  }
  return lis;
    }
public void checkMate(Color color, Game g) {
  if (!Constants.takeMeChess) {
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
      JOptionPane.showMessageDialog(null, "The game has ended in stalemate!", "STALEMATE!", JOptionPane.ERROR_MESSAGE, Constants.images[oppositeColor][rand.nextInt(Constants.images[oppositeColor].length)]);
      g.setGameEnded(true);
      //Gamewindow.timer.stop();
    }
    else {
      JOptionPane.showMessageDialog(null, "Checkmate!  " + ((oppositeColor == 0) ? "White" : "Black")  + " wins!", "Long live the King!", JOptionPane.ERROR_MESSAGE, Constants.images[oppositeColor][rand.nextInt(Constants.images[oppositeColor].length)]);
      g.setGameEnded(true);
      //Gamewindow.timer.stop();
    }
  }
  if (!isCheckPossible(g) && !g.getGameEnded()) {
    JOptionPane.showMessageDialog(null, "Checkmate is very hard or impossible to acieve with this board.  Start a new game to declare a draw!", "Very few pieces left!", JOptionPane.ERROR_MESSAGE, Constants.images[oppositeColor][rand.nextInt(Constants.images[oppositeColor].length)]);
    g.setGameEnded(true);
    //Gamewindow.timer.stop();
  }
  }
  else {
      if (this.pieces[g.getTurnCount() % 2].isEmpty()) {
        JOptionPane.showMessageDialog(null, "No pieces left!  " + ((g.getTurnCount() % 2 == 0) ? "White ": "Black ") + "wins!", "Ran out of pieces!", JOptionPane.ERROR_MESSAGE, Constants.images[g.getTurnCount() % 2][rand.nextInt(Constants.images[g.getTurnCount() % 2].length)]);
        g.setGameEnded(true);
        //Gamewindow.timer.stop();
      }
  }
}
public boolean containsInstance(ArrayList<Piece> pieces, Class clazz) {
  for (Piece p : pieces) {
    if (p.getClass().equals(clazz)) {
      return true;
    }
  }
  return false;
}
public boolean isCheckPossible(Game g) {
  int colIndex = g.getTurnCount() % 2;
  int oppositeCol = (g.getTurnCount() + 1) % 2;
  int turnSize = this.pieces[colIndex].size();
  int otherSize = this.pieces[oppositeCol].size();
  if (turnSize <= 3 || otherSize <= 3) {
    if (turnSize == 1 && otherSize == 1) {
      return false;
    }
    if (turnSize == 1) {
        if (!this.containsInstance(this.pieces[oppositeCol], Queen.class) && !this.containsInstance(this.pieces[oppositeCol], Bishop.class) 
              && !this.containsInstance(this.pieces[oppositeCol], Rook.class) && !this.containsInstance(this.pieces[oppositeCol], Pawn.class)) {
          return false;
        }
        if (!this.containsInstance(this.pieces[oppositeCol], Queen.class) && !this.containsInstance(this.pieces[oppositeCol], Knight.class) 
              && !this.containsInstance(this.pieces[oppositeCol], Rook.class) && !this.containsInstance(this.pieces[oppositeCol], Pawn.class)) {
          return false;
        }
    }
    if (otherSize == 1) {
        if (!this.containsInstance(this.pieces[colIndex], Queen.class) && !this.containsInstance(this.pieces[colIndex], Bishop.class) 
              && !this.containsInstance(this.pieces[colIndex], Rook.class) && !this.containsInstance(this.pieces[colIndex], Pawn.class)) {
          return false;
        }
        if (!this.containsInstance(this.pieces[colIndex], Queen.class) && !this.containsInstance(this.pieces[colIndex], Knight.class) 
              && !this.containsInstance(this.pieces[colIndex], Rook.class) && !this.containsInstance(this.pieces[colIndex], Pawn.class)) {
          return false;
        }
    }
    if (turnSize == 2 && otherSize == 2) {
        if (!this.containsInstance(this.pieces[colIndex], Queen.class) && !this.containsInstance(this.pieces[colIndex], Knight.class) 
              && !this.containsInstance(this.pieces[colIndex], Rook.class) && !this.containsInstance(this.pieces[colIndex], Pawn.class)) {
        if (!this.containsInstance(this.pieces[oppositeCol], Queen.class) && !this.containsInstance(this.pieces[oppositeCol], Knight.class) 
              && !this.containsInstance(this.pieces[oppositeCol], Rook.class) && !this.containsInstance(this.pieces[oppositeCol], Pawn.class)) {
            return false;
          }
        }
    }
  }
  return true;
}
public void pinnedPieces(Color color) {
  int colIndex = color.equals(Constants.colors[0]) ? 0 : 1;
  int oppositeColor = (colIndex + 1) % 2;
  TileButton kingSpace = this.kingsButton[colIndex]; 
  int kingX = kingSpace.getTile().getPosition().getX();
  int kingY = kingSpace.getTile().getPosition().getY();
  int i = kingY;
  int j = kingX;
  ArrayList<TileButton> newPath = new ArrayList<TileButton>();
  int pinnedCount = 0;
  for (int k = 0; k < 8; k++) {
    int counter = 0;
    Piece potentialPin = null;
    i = kingSpace.getTile().getPosition().getX();
    j = kingSpace.getTile().getPosition().getY();
    newPath.clear();
    switch(k) {
      case 0: {
        // North
        while (j > 0) {
          if (this.tiles[j - 1][i].getTile().getPiece() != null) { 
            if (this.tiles[j - 1][i].getTile().getPiece().getColor().equals(color)) {
              if (counter == 0)
              potentialPin = this.tiles[j - 1][i].getTile().getPiece();
              //System.out.println(potentialPin == null);
            }
            else {
              if (this.tiles[j - 1][i].getTile().getPiece() instanceof Rook || this.tiles[j - 1][i].getTile().getPiece() instanceof Queen) {
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
          if (counter <= 1 && !(this.tiles[j - 1][i].getTile().getPiece() instanceof King)) {
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
        	  //System.out.println("j: " + j + ", i:" + i);
          if (this.tiles[j][i].getTile().getPiece() != null) {
            if (this.tiles[j][i].getTile().getPiece().getColor().equals(color) && !(this.tiles[j][i].getTile().getPiece() instanceof King)) {
              potentialPin = this.tiles[j][i].getTile().getPiece();
              counter+=1;
              //System.out.println("rytufyift8r6d57fy" + newPath.size());
            }
            if ((this.tiles[j][i].getTile().getPiece() instanceof Bishop || this.tiles[j][i].getTile().getPiece() instanceof Queen) 
                  && counter == 1 && !this.tiles[j][i].getTile().getPiece().getColor().equals(color)) {
              //System.out.println("jhuiog" + newPath.size());
              for (TileButton but : newPath) {
            	  //System.out.println(but.getTile().getPosition());
              }
              newPath.add(this.tiles[j][i]);
              potentialPin.getPath().clear();
              //System.out.println(newPath.size());
              if (potentialPin instanceof Bishop || potentialPin instanceof Queen) {
              potentialPin.getPath().addAll(newPath);
              }
              else {
                if (potentialPin instanceof Pawn) {
                  int ex = potentialPin.getPosition().getX();
                  int why = potentialPin.getPosition().getY();
                  if (why - 1 >= 0 && ex + 1 < 8) {
                    if (this.tiles[why - 1][ex + 1].getTile().getPiece() != null) {
                      if (!this.tiles[why - 1][ex + 1].getTile().getPiece().getColor().equals(potentialPin.getColor())) {
                        potentialPin.getPath().add(this.tiles[why - 1][ex + 1]);
                      }
                    }
                  }
                }
                potentialPin.getPath().add(this.tiles[potentialPin.getPosition().getY()][potentialPin.getPosition().getX()]);
              }
              pinnedCount++;
              break;
            }
            else {
            	//System.out.println("goig78 " + counter);
            	if (this.tiles[j][i].getTile().getPiece() instanceof Pawn || this.tiles[j][i].getTile().getPiece() instanceof Rook || this.tiles[j][i].getTile().getPiece() instanceof Knight)
            	break;
            }
          }
          else {
        	  //System.out.println("None met");
          }
          if (counter <= 1 && !(this.tiles[j][i].getTile().getPiece() instanceof King)) {
        	  //System.out.println("Last met");
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
          if (this.tiles[j][i + 1].getTile().getPiece() != null) {
            if (this.tiles[j][i + 1].getTile().getPiece().getColor().equals(color)) {
              if (counter == 0)
              potentialPin = this.tiles[j][i + 1].getTile().getPiece();
            }
            else {
              if (this.tiles[j][i + 1].getTile().getPiece() instanceof Rook || this.tiles[j][i + 1].getTile().getPiece() instanceof Queen) {
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
          if (counter <= 1 && !(this.tiles[j][i + 1].getTile().getPiece() instanceof King)) {
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
          if (this.tiles[j][i].getTile().getPiece() != null) {
            if (this.tiles[j][i].getTile().getPiece().getColor().equals(color) && !(this.tiles[j][i].getTile().getPiece() instanceof King)) {
              potentialPin = this.tiles[j][i].getTile().getPiece();
              counter+=1;
            }
            if ((this.tiles[j][i].getTile().getPiece() instanceof Bishop || this.tiles[j][i].getTile().getPiece() instanceof Queen) 
                  && counter == 1 && !this.tiles[j][i].getTile().getPiece().getColor().equals(color)) {
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
                    if (this.tiles[why + 1][ex + 1].getTile().getPiece() != null) {
                      if (!this.tiles[why + 1][ex + 1].getTile().getPiece().getColor().equals(potentialPin.getColor())) {
                        potentialPin.getPath().add(this.tiles[why + 1][ex + 1]);
                      }
                    }
                  }
                }
                potentialPin.getPath().add(this.tiles[potentialPin.getPosition().getY()][potentialPin.getPosition().getX()]);
              }
              pinnedCount++;
              break;
            }
            else {
            	//System.out.println("goig78 " + counter);
            	if (this.tiles[j][i].getTile().getPiece() instanceof Pawn || this.tiles[j][i].getTile().getPiece() instanceof Rook || this.tiles[j][i].getTile().getPiece() instanceof Knight)
            	break;
            }
          }
          if (counter <= 1 && !(this.tiles[j][i].getTile().getPiece() instanceof King)) {
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
          if (this.tiles[j + 1][i].getTile().getPiece() != null) {
            if (this.tiles[j + 1][i].getTile().getPiece().getColor().equals(color)) {
              if (counter == 0)
              potentialPin = this.tiles[j + 1][i].getTile().getPiece();
            }
            else {
              if (this.tiles[j + 1][i].getTile().getPiece() instanceof Rook || this.tiles[j + 1][i].getTile().getPiece() instanceof Queen) {
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
          if (counter <= 1 && !(this.tiles[j + 1][i].getTile().getPiece() instanceof King)) {
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
          if (this.tiles[j][i].getTile().getPiece() != null) {
            if (this.tiles[j][i].getTile().getPiece().getColor().equals(color) && !(this.tiles[j][i].getTile().getPiece() instanceof King)) {
              potentialPin = this.tiles[j][i].getTile().getPiece();
              counter+=1;
            }
            if ((this.tiles[j][i].getTile().getPiece() instanceof Bishop || this.tiles[j][i].getTile().getPiece() instanceof Queen) 
                  && counter == 1 && !this.tiles[j][i].getTile().getPiece().getColor().equals(color)) {
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
                    if (this.tiles[why + 1][ex - 1].getTile().getPiece() != null) {
                      if (!this.tiles[why + 1][ex - 1].getTile().getPiece().getColor().equals(potentialPin.getColor())) {
                        potentialPin.getPath().add(this.tiles[why + 1][ex - 1]);
                      }
                    }
                  }
                }
                potentialPin.getPath().add(this.tiles[potentialPin.getPosition().getY()][potentialPin.getPosition().getX()]);
              }
              pinnedCount++;
              break;
            }
            else {
            	//System.out.println("goig78 " + counter);
            	if (this.tiles[j][i].getTile().getPiece() instanceof Pawn || this.tiles[j][i].getTile().getPiece() instanceof Rook || this.tiles[j][i].getTile().getPiece() instanceof Knight)
            	break;
            }
          }
          if (counter <= 1 && !(this.tiles[j][i].getTile().getPiece() instanceof King)) {
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
          if (this.tiles[j][i - 1].getTile().getPiece() != null) {
            if (this.tiles[j][i - 1].getTile().getPiece().getColor().equals(color)) {
              if (counter == 0)
              potentialPin = this.tiles[j][i - 1].getTile().getPiece();
            }
            else {
              if (this.tiles[j][i - 1].getTile().getPiece() instanceof Rook || this.tiles[j][i - 1].getTile().getPiece() instanceof Queen) {
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
          if (counter <= 1 && !(this.tiles[j][i - 1].getTile().getPiece() instanceof King)) {
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
          if (this.tiles[j][i].getTile().getPiece() != null) {
            if (this.tiles[j][i].getTile().getPiece().getColor().equals(color) && !(this.tiles[j][i].getTile().getPiece() instanceof King)) {
              potentialPin = this.tiles[j][i].getTile().getPiece();
              counter+=1;
            }
            if ((this.tiles[j][i].getTile().getPiece() instanceof Bishop || this.tiles[j][i].getTile().getPiece() instanceof Queen) 
                  && counter == 1 && !this.tiles[j][i].getTile().getPiece().getColor().equals(color)) {
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
                    if (this.tiles[why - 1][ex - 1].getTile().getPiece() != null) {
                      if (!this.tiles[why - 1][ex - 1].getTile().getPiece().getColor().equals(potentialPin.getColor())) {
                        potentialPin.getPath().add(this.tiles[why - 1][ex - 1]);
                      }
                    }
                  }
                }
                potentialPin.getPath().add(this.tiles[potentialPin.getPosition().getY()][potentialPin.getPosition().getX()]);
              }
              pinnedCount++;
              break;
            }
            else {
            	//System.out.println("goig78 " + counter);
            	if (this.tiles[j][i].getTile().getPiece() instanceof Pawn || this.tiles[j][i].getTile().getPiece() instanceof Rook || this.tiles[j][i].getTile().getPiece() instanceof Knight)
            	break;
            }
          }
          if (counter <= 1 && !(this.tiles[j][i].getTile().getPiece() instanceof King)) {
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
public Piece getRandomPiece(Game g, Color c) {
	int index = c.equals(Constants.colors[0]) ? 0 : 1;
	int randPiece = rand.nextInt(g.getBoard().pieces[index].size());
	return g.getBoard().pieces[index].get(randPiece);
}
public HashMap<Piece, ArrayList<TileButton>> getCheckPaths() {
  return this.checkPaths;
}
public HashMap<Piece, ArrayList<TileButton>> getTake() {
  return this.take;
}
public static void main(String[] args) {
 Board board = new Board();
 board.fillTiles(0, 0);
 //ArrayList<Piece>[] pieces = new ArrayList[2];
 //ArrayList<Piece> whitePieces = new ArrayList<Piece>();
 /*whitePieces.add(new King(1, Color.WHITE, new Position(0, 0), Constants.whiteimages[4], "King", true));
 whitePieces.add(new Queen(1, Color.WHITE, new Position(1, 0), Constants.whiteimages[3], "Queen"));
 ArrayList<Piece> blackPieces = new ArrayList<Piece>();
  blackPieces.add(new King(1, Color.BLACK, new Position(2, 0), Constants.blackimages[4], "King", true));
  pieces[0] = whitePieces;
  pieces[1] = blackPieces;
  board.pieces = pieces;
 //System.out.println(board.tiles[i][j].getTile());
 //board.setPieces();
 //board.move(board.tiles[6][0], board.tiles[4][0]);*/
  /*for (TileButton[] buts : board.tiles) {
    for (TileButton but : buts) {
      //if (but.getTile().getPiece() != null)
      System.out.println(but.getTile());
    }
  }*/
 //System.out.println(board.pieces[0].get(0));
}
}
