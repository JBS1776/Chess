import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class Promotion extends JDialog implements java.io.Serializable{
//ImageIcon[] whiteimages = Constants.whiteimages;
//ImageIcon[] blackimages = Constants.blackimages;
ImageIcon[][] images = Constants.images;
Board board = new Board();
TileButton[][] tiles = board.tiles;
private Color c;
private TileButton t;
private Random rand = new Random();
 public Promotion(Color c, TileButton t, Game g, Gamewindow gw) {
  this.c = c;
  this.t = t;
  Tile tile = t.getTile();
  Position pos = tile.getPosition();
  int row = g.getTurnCount() % 2;
  if (g.getAilevel() == 3 || (c.equals(Constants.colors[g.getAiColor()]) && g.getAilevel() > 0)) {
	  //this.dispose();
	  row = g.getAilevel() == 3 ? g.getTurnCount() % 2 : g.getAiColor();
	  Rook rook = new Rook(3, c, pos, images[row][0], images[row][0].getDescription(), false);
	  Knight knight = new Knight(3, c, pos, images[row][1], images[row][1].getDescription());
	  Bishop bishop = new Bishop(3, c, pos, images[row][2], images[row][2].getDescription());
	  Queen queen = new Queen(2, c, pos, images[row][3], images[row][3].getDescription());
	  King king = new King(2, c, pos, images[row][4], images[row][4].getDescription(), false);
	  //Piece[] pieces = {rook, knight, bishop, queen, king};
	  int rand100 = rand.nextInt(100);
	  int random = g.getTakeMeEnabled() ? rand.nextInt(5) : rand.nextInt(4);
	  if (rand100 < 95)
		  random = g.getTakeMeEnabled() ? 4 : 3;
	  Piece piece = null;
	  switch(random) {
	  case 0:
		  piece = (Rook) rook;
		  if (c.equals(Constants.colors[0])) {
			  rook.setWhiteNewId(rook.getWhiteNewId() + 1);
			  rook.setId(rook.getWhiteNewId());
		  }
		  else {
		  rook.setBlackNewId(rook.getBlackNewId() + 1);
		  rook.setId(rook.getBlackNewId());
		  }
		  break;
	  case 1:
		  piece = (Knight) knight;
		  if (c.equals(Constants.colors[0])) {
			  knight.setWhiteNewId(knight.getWhiteNewId() + 1);
			  knight.setId(knight.getWhiteNewId());
		  }
		  else {
		  knight.setBlackNewId(knight.getBlackNewId() + 1);
		  knight.setId(knight.getBlackNewId());
		  }
		  break;
	  case 2:
		  piece = (Bishop) bishop;
		  if (c.equals(Constants.colors[0])) {
			  bishop.setWhiteNewId(bishop.getWhiteNewId() + 1);
			  bishop.setId(bishop.getWhiteNewId());
		  }
		  else {
		  bishop.setBlackNewId(bishop.getBlackNewId() + 1);
		  bishop.setId(bishop.getBlackNewId());
		  }
		  break;
	  case 4:
		  piece = (King) king;
		  if (c.equals(Constants.colors[0])) {
			  king.setWhiteNewId(king.getWhiteNewId() + 1);
			  king.setId(king.getWhiteNewId());
		  }
		  else {
		  king.setBlackNewId(king.getBlackNewId() + 1);
		  king.setId(king.getBlackNewId());
		  }
		  break;
	  default:
		  piece = (Queen) queen;
		  if (c.equals(Constants.colors[0])) {
			  queen.setWhiteNewId(queen.getWhiteNewId() + 1);
			  queen.setId(queen.getWhiteNewId());
		  }
		  else {
		  queen.setBlackNewId(queen.getBlackNewId() + 1);
		  queen.setId(queen.getBlackNewId());
		  }
		  break;
	  }
	  gw.setEnabled(true);
      String promMove = "" + (g.getTurnCount() + 1) + ". " + tile.getPiece().getName() + " promoted to " + piece.getName() + ".";
      g.getBoard().pieces[g.getAiColor()].remove(tile.getPiece());
      //g.getBoard().decTypeCount(tile.getPiece(), 1);
      g.capturedpieces.get(Graveyard.findIndex(tile.getPiece(), Constants.colors[g.getAiColor()])).add(tile.getPiece());
      //System.out.println("Pawn Removed: " + g.getBoard().pieces[g.getAiColor()].size());
      tile.setPiece(null);
      tile.setImage(null);
      t.setIcon(null);
      tile.setPiece(piece);
      tile.setImage(piece.getImage());
      t.setIcon(tile.getImage());
      g.getBoard().pieces[g.getAiColor()].add(piece);
      String str = g.moveList.get(g.moveList.size() - 1);
      g.moveList.set(g.moveList.size() - 1, str + " " + piece.getName() + piece.getId() + " promotion complete!");
      //g.capturedpieces.get(Graveyard.findIndex(piece, piece.getColor())).add(piece);
      //g.getBoard().decTypeCount(piece, -1);
      //System.out.println("Queen added: " + g.getBoard().pieces[g.getAiColor()].size());
        /*for (Piece p : g.getBoard().pieces[g.getAiColor()]) {
        	//System.out.println();
       System.out.println(p);
        }*/
      g.getBoard().setPieces(g);
      if (!Constants.takeMeChess) {
        g.getBoard().kingsButton[g.getTurnCount() % 2].setBackground(Constants.TURNHIGHLIGHT);
               if (g.getBoard().isKingInCheck(g.getTurnColor(), g)) {
                 g.getBoard().kingsButton[g.getTurnCount() % 2].setBackground(Constants.CHECKHIGHLIGHT);
               }
      g.getBoard().reducePath(g.getTurnColor(), g);
      g.getBoard().pinnedPieces(g.getTurnColor());
      //System.out.println("Choosing promotion!");
      /*for (Piece p : g.getBoard().pieces[g.getAiColor()]) {
      	//System.out.println();
     System.out.println(p);
      }*/
      //System.out.println();
      }
      else
        g.getBoard().takeMePath(g.getTurnColor(), g);
      g.getBoard().checkMate(g.getTurnColor(), g);
      dispose();
      Constants.isPromotionEnabled = false;
  }
  else {
  /*PieceButton button1 = null;
  PieceButton button2 = null;
  PieceButton button3 = null;
  PieceButton button4 = null;
  PieceButton button5 = null;*/
  PieceButton[] buttons = new PieceButton[5];
  Constants.isPromotionEnabled = true;
  setLayout(null);
  row = g.getTurnCount() % 2;
  Rook newWhiteRook = new Rook(3, c, pos, images[row][0], images[row][0].getDescription(), false);
  Knight newWhiteKnight = new Knight(3, c, pos, images[row][1], images[row][1].getDescription());
  Bishop newWhiteBishop = new Bishop(3, c, pos, images[row][2], images[row][2].getDescription());
  Queen newWhiteQueen = new Queen(3, c, pos, images[row][3], images[row][3].getDescription());
  King newWhiteKing = new King(2, c, pos, images[row][4], images[row][4].getDescription(), false);
  Piece[] pieces = {newWhiteRook, newWhiteKnight, newWhiteBishop, newWhiteQueen, newWhiteKing};
  for (int i = 0; i < pieces.length; i++) {
	  ImageIcon set = new ImageIcon(Constants.names[Constants.SETTING][c.equals(Color.black) ? i : i + 6], pieces[i].getName());
	  pieces[i].setImage(set);
  }
  buttons[0] = new PieceButton(newWhiteRook);
  buttons[0].setOpaque(true);
  buttons[0].setBounds(25, 10, 150, 150);
  //buttons[0].setIcon(images[row][0]);
  buttons[0].setIcon(pieces[0].getImage());
  buttons[0].setFocusable(false);
  add(buttons[0]);
  buttons[1] = new PieceButton(newWhiteKnight);
  buttons[1].setOpaque(true);
  buttons[1].setBounds(225, 10, 150, 150);
  buttons[1].setIcon(pieces[1].getImage());
  buttons[1].setFocusable(false);
  add(buttons[1]);
  buttons[2] = new PieceButton(newWhiteBishop);
  buttons[2].setOpaque(true);
  buttons[2].setBounds(425, 10, 150, 150);
  buttons[2].setIcon(pieces[2].getImage());
  buttons[2].setFocusable(false);
  add(buttons[2]);
  buttons[3] = new PieceButton(newWhiteQueen);
  buttons[3].setOpaque(true);
  buttons[3].setBounds(625, 10, 150, 150);
  buttons[3].setIcon(pieces[3].getImage());
  buttons[3].setFocusable(false);
  add(buttons[3]);
  if (Constants.takeMeChess) {
    buttons[4] = new PieceButton(newWhiteKing);
    buttons[4].setOpaque(true);
    buttons[4].setBounds(825, 10, 150, 150);
    buttons[4].setIcon(pieces[4].getImage());
    buttons[4].setFocusable(false);
    add(buttons[4]);
  }
   ActionListener listener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
     Object source = e.getSource();
     if (source instanceof PieceButton) {
      Piece piece = ((PieceButton)source).getPiece();
      Color col = piece.getColor();
      if (piece instanceof Rook) {
        Rook rook = (Rook) piece;
       if (col.equals(Constants.colors[0])) {
        rook.setWhiteNewId(rook.getWhiteNewId() + 1);
        rook.setId(rook.getWhiteNewId());
       }
       else {
        rook.setBlackNewId(rook.getBlackNewId() + 1);
        rook.setId(rook.getBlackNewId());
       }
       gw.setEnabled(true);
      }
      if (piece instanceof Knight) {
       Knight knight = (Knight) piece;
       if (col.equals(Constants.colors[0])) {
        knight.setWhiteNewId(knight.getWhiteNewId() + 1);
        knight.setId(knight.getWhiteNewId());
       }
       else {
        knight.setBlackNewId(knight.getBlackNewId() + 1);
        knight.setId(knight.getBlackNewId());
       }
       gw.setEnabled(true);
      }
      if (piece instanceof Bishop) {
        Bishop bishop = (Bishop) piece;
       if (col.equals(Constants.colors[0])) {
        bishop.setWhiteNewId(bishop.getWhiteNewId() + 1);
        bishop.setId(bishop.getWhiteNewId());
       }
       else {
        bishop.setBlackNewId(bishop.getBlackNewId() + 1);
        bishop.setBlackNewId(bishop.getBlackNewId());
       }
       gw.setEnabled(true);
      }
      if (piece instanceof Queen) {
       Queen queen = (Queen) piece;
       if (col.equals(Constants.colors[0])) {
        queen.setWhiteNewId(queen.getWhiteNewId() + 1);
        queen.setId(queen.getWhiteNewId());
       }
       else {
        queen.setBlackNewId(queen.getBlackNewId() + 1);
        queen.setId(queen.getBlackNewId());
       }
       gw.setEnabled(true);
      }
      if (piece instanceof King) {
       King king = (King) piece;
       if (col.equals(Constants.colors[0])) {
        king.setWhiteNewId(king.getWhiteNewId() + 1);
        king.setId(king.getWhiteNewId());
       }
       else {
        king.setBlackNewId(king.getBlackNewId() + 1);
        king.setId(king.getBlackNewId());
       }
       gw.setEnabled(true);
      }
      String promMove = "" + (g.getTurnCount() + 1) + ". " + tile.getPiece().getName() + " promoted to " + piece.getName() + ".";
      g.getBoard().pieces[(g.getTurnCount() + 1) % 2].remove(tile.getPiece());
      //g.getBoard().decTypeCount(tile.getPiece(), 1);
      g.capturedpieces.get(Graveyard.findIndex(tile.getPiece(), Constants.colors[(g.getTurnCount() + 1) % 2])).add(tile.getPiece());
      tile.setPiece(null);
      tile.setImage(null);
      t.setIcon(null);
      Piece promPiece = ((PieceButton)source).getPiece();
      tile.setPiece(promPiece);
      tile.setImage(promPiece.getImage());
      t.setIcon(tile.getImage());
      g.getBoard().pieces[(g.getTurnCount() + 1) % 2].add(promPiece);
      String str = g.moveList.get(g.moveList.size() - 1);
      g.moveList.set(g.moveList.size() - 1, str + " " + promPiece.getName() + promPiece.getId() + " promotion complete!");
      //System.out.println(g.moveList.get(g.moveList.size() - 1));
      //System.out.println("Before: " + g.getBoard().pieceCount[0][3]);
      //g.getBoard().decTypeCount(((PieceButton)source).getPiece(), -1);
      //System.out.println("After: " + g.getBoard().pieceCount[0][3]);
        /*for (Piece p : g.getBoard().pieces[(g.getTurnCount() + 1) % 2])
       System.out.println(p);*/
      g.getBoard().setPieces(g);
      if (!Constants.takeMeChess) {
        g.getBoard().kingsButton[g.getTurnCount() % 2].setBackground(Constants.TURNHIGHLIGHT);
               if (g.getBoard().isKingInCheck(g.getTurnColor(), g)) {
                 g.getBoard().kingsButton[g.getTurnCount() % 2].setBackground(Constants.CHECKHIGHLIGHT);
               }
      g.getBoard().reducePath(g.getTurnColor(), g);
      g.getBoard().pinnedPieces(g.getTurnColor());
      System.out.println("Choosing promotion!");
      }
      else
        g.getBoard().takeMePath(g.getTurnColor(), g);
      g.getBoard().checkMate(g.getTurnColor(), g);
      dispose();
      Constants.isPromotionEnabled = false;
    }
    }
   };
   buttons[0].addActionListener(listener);
   //buttons[0].setIcon(buttons[0].getPiece().getImage());
   buttons[1].addActionListener(listener);
   buttons[2].addActionListener(listener);
   buttons[3].addActionListener(listener);
   if (Constants.takeMeChess)
     buttons[4].addActionListener(listener);
  
  this.setTitle("Choose a piece.  You can't close this window without selecting a piece.");
  setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
     if (Constants.takeMeChess)
       this.setSize(1025, 200);
     else
     this.setSize(825, 200);
     setVisible(true);
 }
 }
 public TileButton getTile() {
  return this.t;
 }
private class PieceButton extends JButton {
	private static final long serialVersionUID = 1L;
	private Piece piece;
	PieceButton(Piece piece) {
		this.piece = piece;
  }
  public Piece getPiece() {
   return this.piece;
  }
 }
 public static void main(String[] args) {
   Board board = new Board();
   board.fillTiles(Constants.SCREENPOSX, Constants.SCREENPOSY);
   //Promotion p = new Promotion(Color.WHITE, board.tiles[0][0]);
 }

}
