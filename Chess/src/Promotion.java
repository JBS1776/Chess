import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
public class Promotion extends JDialog implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

private Tile t1;
public Promotion(Color c, Tile t1, Game g, Gamewindow gw) {
	  this.t1 = t1;
	  Tile tile = this.t1;
	  Position pos = tile.getPosition();
	  int row = g.getTurnCount() % 2;
	  if (g.getAilevel() == 3 || (c.equals(Constants.colors[g.getAiColor()]) && g.getAilevel() > 0)) {
		  row = g.getAilevel() == 3 ? g.getTurnCount() % 2 : g.getAiColor();
		  Rook rook = new Rook(g.getBoard().getMaxPieceIds()[row][0] + 1, c, pos, Constants.images[row][0], false);
		  Knight knight = new Knight(g.getBoard().getMaxPieceIds()[row][1] + 1, c, pos, Constants.images[row][1]);
		  Bishop bishop = new Bishop(g.getBoard().getMaxPieceIds()[row][2] + 1, c, pos, Constants.images[row][2]);
		  Queen queen = new Queen(g.getBoard().getMaxPieceIds()[row][3] + 1, c, pos, Constants.images[row][3]);
		  King king = new King(g.getBoard().getMaxPieceIds()[row][4] + 1, c, pos, Constants.images[row][4], false);
		  int rand100 = Constants.rand.nextInt(100);
		  int random = g.getTakeMeEnabled() ? Constants.rand.nextInt(5) : Constants.rand.nextInt(4);
		  if (rand100 < 95)
			  random = g.getTakeMeEnabled() ? 4 : 3;
		  Piece piece = null;
		  switch(random) {
		  case 0:
			  piece = (Rook) rook;
			  break;
		  case 1:
			  piece = (Knight) knight;
			  break;
		  case 2:
			  piece = (Bishop) bishop;
			  break;
		  case 4:
			  piece = (King) king;
			  break;
		  default:
			  piece = (Queen) queen;
			  break;
		  }
		  g.getBoard().setMaxPieceIds(row, random, piece.getId());
		  gw.setEnabled(true);
	      g.getBoard().getPieces()[g.getAiColor()].remove(tile.getPiece());
	      g.getCapturedPieces().get(tile.getPiece().findIndex(Constants.colors[g.getAiColor()])).add(tile.getPiece());
	      tile.setPiece(null);
	      tile.setImage(null);
	      t1.setIcon(null);
	      tile.setPiece(piece);
	      tile.setImage(piece.getImage());
	      t1.setIcon(tile.getImage());
	      g.getBoard().getPieces()[g.getAiColor()].add(piece);
	      String str = g.getMoveList().get(g.getMoveList().size() - 1);
	      g.getMoveList().set(g.getMoveList().size() - 1, str + " " + piece.getName() + piece.getId() + " promotion complete!");
	      g.getBoard().setPieces(g);
	      if (!g.getTakeMeEnabled()) {
	        g.getBoard().getKingButton()[g.getTurnCount() % 2].setBackground(Constants.TURNHIGHLIGHT);
	               if (g.getBoard().isKingInCheck(g.getTurnColor(), g)) {
	                 g.getBoard().getKingButton()[g.getTurnCount() % 2].setBackground(Constants.CHECKHIGHLIGHT);
	               }
	      g.getBoard().reducePath(g.getTurnColor(), g);
	      g.getBoard().pinnedPieces(g.getTurnColor());
	      }
	      else
	        g.getBoard().takeMePath(g.getTurnColor(), g);
	      g.getBoard().checkMate(g.getTurnColor(), g);
	      this.dispose();
	  }
	  else {
	  PieceButton[] buttons = new PieceButton[5];
	  setLayout(null);
	  row = g.getTurnCount() % 2;
	  Rook newWhiteRook = new Rook(g.getBoard().getMaxPieceIds()[row][0] + 1, c, pos, Constants.images[row][0], false);
	  Knight newWhiteKnight = new Knight(g.getBoard().getMaxPieceIds()[row][1] + 1, c, pos, Constants.images[row][1]);
	  Bishop newWhiteBishop = new Bishop(g.getBoard().getMaxPieceIds()[row][2] + 1, c, pos, Constants.images[row][2]);
	  Queen newWhiteQueen = new Queen(g.getBoard().getMaxPieceIds()[row][3] + 1, c, pos, Constants.images[row][3]);
	  King newWhiteKing = new King(g.getBoard().getMaxPieceIds()[row][4] + 1, c, pos, Constants.images[row][4], false);
	  Piece[] pieces = {newWhiteRook, newWhiteKnight, newWhiteBishop, newWhiteQueen, newWhiteKing};
	  for (int i = 0; i < pieces.length; i++) {
		  ImageIcon set = new ImageIcon(Constants.names[g.getSetting()][c.equals(Color.black) ? i : i + 6], pieces[i].getName());
		  pieces[i].setImage(set);
	  }
	  buttons[0] = new PieceButton(newWhiteRook);
	  buttons[0].setOpaque(true);
	  buttons[0].setBounds(25, 10, 150, 150);
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
	  if (g.getTakeMeEnabled()) {
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
	      if (piece instanceof Rook) {
	        Rook rook = (Rook) piece;
	       g.getBoard().setMaxPieceIds(g.getTurnCount() % 2, 0, rook.getId());
	       gw.setEnabled(true);
	      }
	      if (piece instanceof Knight) {
	       Knight knight = (Knight) piece;
	       g.getBoard().setMaxPieceIds(g.getTurnCount() % 2, 1, knight.getId());
	       gw.setEnabled(true);
	      }
	      if (piece instanceof Bishop) {
	        Bishop bishop = (Bishop) piece;
	       g.getBoard().setMaxPieceIds(g.getTurnCount() % 2, 2, bishop.getId());
	       gw.setEnabled(true);
	      }
	      if (piece instanceof Queen) {
	       Queen queen = (Queen) piece;
	       g.getBoard().setMaxPieceIds(g.getTurnCount() % 2, 3, queen.getId());
	       gw.setEnabled(true);
	      }
	      if (piece instanceof King) {
	       King king = (King) piece;
	       g.getBoard().setMaxPieceIds(g.getTurnCount() % 2, 4, king.getId());
	       gw.setEnabled(true);
	      }
	      g.getBoard().getPieces()[(g.getTurnCount() + 1) % 2].remove(tile.getPiece());
	      g.getCapturedPieces().get(tile.getPiece().findIndex(Constants.colors[(g.getTurnCount() + 1) % 2])).add(tile.getPiece());
	      tile.setPiece(null);
	      tile.setImage(null);
	      t1.setIcon(null);
	      Piece promPiece = ((PieceButton)source).getPiece();
	      tile.setPiece(promPiece);
	      tile.setImage(promPiece.getImage());
	      t1.setIcon(tile.getImage());
	      g.getBoard().getPieces()[(g.getTurnCount() + 1) % 2].add(promPiece);
	      String str = g.getMoveList().get(g.getMoveList().size() - 1);
	      g.getMoveList().set(g.getMoveList().size() - 1, str + " " + promPiece.getName() + promPiece.getId() + " promotion complete!");
	      g.getBoard().setPieces(g);
	      if (!g.getTakeMeEnabled()) {
	        g.getBoard().getKingButton()[g.getTurnCount() % 2].setBackground(Constants.TURNHIGHLIGHT);
	               if (g.getBoard().isKingInCheck(g.getTurnColor(), g)) {
	                 g.getBoard().getKingButton()[g.getTurnCount() % 2].setBackground(Constants.CHECKHIGHLIGHT);
	               }
	      g.getBoard().reducePath(g.getTurnColor(), g);
	      g.getBoard().pinnedPieces(g.getTurnColor());
	      }
	      else
	        g.getBoard().takeMePath(g.getTurnColor(), g);
	      g.getBoard().checkMate(g.getTurnColor(), g);
	      dispose();
	    }
	    }
	   };
	   buttons[0].addActionListener(listener);
	   buttons[1].addActionListener(listener);
	   buttons[2].addActionListener(listener);
	   buttons[3].addActionListener(listener);
	   if (g.getTakeMeEnabled())
	     buttons[4].addActionListener(listener);	  
	  this.setTitle("Choose a piece.  You can't close this window without selecting a piece.");
	  setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	     if (g.getTakeMeEnabled())
	       this.setSize(1025, 200);
	     else
	     this.setSize(825, 200);
	     setVisible(true);
	 }
	 }
 public Tile getTile() {
	 return this.t1;
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
}
