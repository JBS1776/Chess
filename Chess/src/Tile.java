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
 private ImageIcon image;
 private Piece piece;
 private Position pos;
 public Tile(int width, int height, int x, int y, Color color, Piece piece) {
  this.width = width;
  this.height = height;
  this.x = x;
  this.y = y;
  this.color = color;
  this.piece = piece;
  if (piece != null) {
   this.piece = piece;
  }
  this.pos = new Position(x, y);
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
void select(ArrayList<Tile> tiles) {
     for (Tile t : tiles) {
       t.setBackground(Constants.HIGHLIGHTER);
     }
   }
void deSelect(ArrayList<Tile> tiles, Game g) {
    for (Tile t : tiles) {
        t.setBackground(t.getColor());
      }
     if (g.getTakeMeEnabled()) {
       for (Tile t : g.getTakeRed()) {
         t.setBackground(Color.RED);
       }
       for (Tile t : g.getTakeCyan()) {
         t.setBackground(Color.CYAN);
       }
       	if (!g.getTakeCyan().contains(g.getBoard().getKingButton()[g.getTurnCount() % 2]))
       		g.getBoard().getKingButton()[g.getTurnCount() % 2].setBackground(Constants.TURNHIGHLIGHT);
     }
     else {
    	 if (g.getcurrKingCheck())
    		 g.getBoard().getKingButton()[g.getTurnCount() % 2].setBackground(Constants.CHECKHIGHLIGHT);
    	 else
    		 g.getBoard().getKingButton()[g.getTurnCount() % 2].setBackground(Constants.TURNHIGHLIGHT);
     }
   }
 }
