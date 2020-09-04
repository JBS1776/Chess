import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
public class Tile extends JButton implements java.io.Serializable{
 
 /**
	 * 
	 */
 private static final long serialVersionUID = 1L;
 private int width;
 private int height;
 private Color color;
 private int x;
 private int y;
 private boolean hasPiece;
 private ImageIcon image;
 private Piece piece;
 private Position pos = new Position(x, y);
 public Tile(int width, int height, int x, int y, Color color, Piece piece) {
  this.width = width;
  this.height = height;
  this.x = x;
  this.y = y;
  this.color = color;
  this.hasPiece = false;
  //this.image = image;
  this.piece = piece;
  if (piece != null) {
   //this.image = image;
   this.piece = piece;
   this.hasPiece = true;
  }
  else {
   this.hasPiece = false;
  }
  //this.pos = pos;
 }
 public int getWidth() {
  return this.width;
 }
 public int getHeight() {
   return this.height;
 }
 public int getX() {
  return this.x;
 }
 public int getY() {
  return this.y;
 }
 public Color getColor() {
  return this.color;
 }
 public void setColor(Color c) {
  this.color = c;
 }
 public void setPiece(Piece p) {
  this.piece = p;
 }
 public void setHasPiece() {
  if (this.getPiece() == null)
  this.hasPiece = false;
  else
   this.hasPiece = true;
 }
 public void setPosition(int x, int y) {
   this.pos = new Position(x, y);
 }
 public Position getPosition() {
  return this.pos;
 }
 public void setImage(ImageIcon image) {
  this.image = image;
 }
 public ImageIcon getImage() {
  return this.image;
 }
 public Piece getPiece() {
  return this.piece;
 }
 public void select(ArrayList<Tile> tiles) {
     for (Tile t : tiles) {
       t.setBackground(Constants.HIGHLIGHTER);
     }
   }
 public void deSelect(ArrayList<Tile> tiles, Game g) {
     if (g.getTakeMeEnabled()) {
       for (Tile t : tiles) {
           t.setBackground(t.getColor());
       }
       for (Tile t : g.takeRed) {
         t.setBackground(Color.RED);
       }
       if (g.takeCyan != null)
         g.takeCyan.setBackground(Color.CYAN);
     }
     else {
     for (Tile t : tiles) {
       t.setBackground(t.getColor());
     }
     if (!Constants.takeMeChess) {
     if (g.getcurrKingCheck())
     g.getBoard().kingsButton[g.getTurnCount() % 2].setBackground(Constants.CHECKHIGHLIGHT);
     else
       g.getBoard().kingsButton[g.getTurnCount() % 2].setBackground(Color.GREEN);
   }
     }
   }
 public String toString() {
  return "" + x + ", " + y + ", " + "Pos: " + this.pos + ", " + this.color + ", " + this.hasPiece + ", (" + this.piece + ")";
 }

 public static void main(String[] args) {

 }
 }
