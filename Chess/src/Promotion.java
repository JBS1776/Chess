import javax.swing.JFrame;


import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.*;
import javax.swing.SwingUtilities;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;
public class Promotion extends JFrame{
ImageIcon[] whiteimages = Constants.whiteimages;
ImageIcon[] blackimages = Constants.blackimages;
TileButton[][] tiles = Board.tiles;
private Color c;
private TileButton t;
 public Promotion(Color c, TileButton t) {
  this.c = c;
  this.t = t;
  Tile tile = t.getTile();
  Position pos = tile.toPosition(tile.getX(), tile.getY());
  PieceButton button1 = null;
  PieceButton button2 = null;
  PieceButton button3 = null;
  PieceButton button4 = null;
  if (c.equals(Constants.colors[0])) {
  setLayout(null);
  Rook newWhiteRook = new Rook(3, c, pos, whiteimages[0], whiteimages[0].getDescription());
  Knight newWhiteKnight = new Knight(3, c, pos, whiteimages[1], whiteimages[1].getDescription());
  Bishop newWhiteBishop = new Bishop(3, c, pos, whiteimages[2], whiteimages[2].getDescription());
  Queen newWhiteQueen = new Queen(3, c, pos, whiteimages[3], whiteimages[3].getDescription());
  button1 = new PieceButton(newWhiteRook);
  button1.setOpaque(true);
  button1.setBounds(25, 10, 150, 150);
  button1.setIcon(whiteimages[0]);
  button1.setFocusable(false);
  add(button1);
  button2 = new PieceButton(newWhiteKnight);
  button2.setOpaque(true);
  button2.setBounds(225, 10, 150, 150);
  button2.setIcon(whiteimages[1]);
  button2.setFocusable(false);
  add(button2);
  button3 = new PieceButton(newWhiteBishop);
  button3.setOpaque(true);
  button3.setBounds(425, 10, 150, 150);
  button3.setIcon(whiteimages[2]);
  button3.setFocusable(false);
  add(button3);
  button4 = new PieceButton(newWhiteQueen);
  button4.setOpaque(true);
  button4.setBounds(625, 10, 150, 150);
  button4.setIcon(whiteimages[3]);
  button4.setFocusable(false);
  add(button4);
  }
  if (c.equals(Constants.colors[1])) {
   setLayout(null);
   Rook newBlackRook = new Rook(3, c, pos, blackimages[0], blackimages[0].getDescription());
   Knight newBlackKnight = new Knight(3, c, pos, blackimages[1], blackimages[1].getDescription());
   Bishop newBlackBishop = new Bishop(3, c, pos, blackimages[2], blackimages[2].getDescription());
   Queen newBlackQueen = new Queen(3, c, pos, blackimages[3], blackimages[3].getDescription());
   button1 = new PieceButton(newBlackRook);
   add(button1);
   button1.setBounds(25, 10, 150, 150);
   button1.setOpaque(true);
   button1.setIcon(blackimages[0]);
   button1.setFocusable(false);
   button2 = new PieceButton(newBlackKnight);
   add(button2);
   button2.setBounds(225, 10, 150, 150);
   button2.setOpaque(true);
   button2.setIcon(blackimages[1]);
   button2.setFocusable(false);
   button3 = new PieceButton(newBlackBishop);
   add(button3);
   button3.setBounds(425, 10, 150, 150);
   button3.setOpaque(true);
   button3.setIcon(blackimages[2]);
   button3.setFocusable(false);
   button4 = new PieceButton(newBlackQueen);
   add(button4);
   button4.setBounds(625, 10, 150, 150);
   button4.setOpaque(true);
   button4.setIcon(blackimages[3]);
   button4.setFocusable(false);
  }
   ActionListener listener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
     Object source = e.getSource();
     if (source instanceof PieceButton) {
      Piece piece = ((PieceButton)source).getPiece();
      Color col = piece.getColor();
      if (piece instanceof Rook) {
       if (col.equals(Constants.colors[0])) {
        Rook.whitenewId += 1;
        piece.setId(Rook.whitenewId);
       }
       if (col.equals(Constants.colors[1])) {
        Rook.blacknewId += 1;
        piece.setId(Rook.blacknewId);
       }
      }
      if (piece instanceof Knight) {
       if (col.equals(Constants.colors[0])) {
        Knight.whitenewId += 1;
        piece.setId(Knight.whitenewId);
       }
       if (col.equals(Constants.colors[1])) {
        Knight.blacknewId += 1;
        piece.setId(Knight.blacknewId);
       }
      }
      if (piece instanceof Bishop) {
       if (col.equals(Constants.colors[0])) {
        Bishop.whitenewId += 1;
        piece.setId(Bishop.whitenewId);
       }
       if (col.equals(Constants.colors[1])) {
        Bishop.blacknewId += 1;
        piece.setId(Bishop.blacknewId);
       }
      }
      if (piece instanceof Queen) {
       if (col.equals(Constants.colors[0])) {
        Queen.whitenewId += 1;
        piece.setId(Queen.whitenewId);
       }
       if (col.equals(Constants.colors[1])) {
        Queen.blacknewId += 1;
        piece.setId(Queen.blacknewId);
       }
      }
      String promMove = "" + (Game.turnCount + 1) + ". " + tile.getPiece().getName() + " promoted to " + piece.getName() + ".";
      //turn += promMove;
      int lastIndex = Game.moveLog.size() - 1;
      String turn = Game.moveLog.get(lastIndex) + "\n";
      Game.moveLog.set(lastIndex, turn + promMove);
      System.out.println(Game.moveLog.get(Game.moveLog.size() - 1));
      tile.setPiece(null);
      tile.setImage(null);
      t.setIcon(null);
      tile.setPiece(((PieceButton)source).getPiece());
      tile.setImage(((PieceButton)source).getPiece().getImage());
      t.setIcon(tile.getImage());
      dispose();
      Game.enableFrame = !Game.enableFrame;
      new Game().enableTheFrame(Game.enableFrame);
      //Game.setEnabled(true);
    }
    }
    
   };
   button1.addActionListener(listener);
   button2.addActionListener(listener);
   button3.addActionListener(listener);
   button4.addActionListener(listener);
  
  this.setTitle("Choose a piece.  You can't close this window without selecting a piece.");
  setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  
     this.setSize(825, 200);
     setVisible(true);
 }
 public TileButton getTile() {
  return this.t;
 }
 class PieceButton extends JButton {
  private Piece piece;
  PieceButton(Piece piece) {
   this.piece = piece;
  }
  public Piece getPiece() {
   return this.piece;
  }
 }
 public static void main(String[] args) {
  //Promotion p = new Promotion(Color.WHITE, new Rook(3, c, pos, blackimages[0], blackimages[0].getDescription()));
 }

}
