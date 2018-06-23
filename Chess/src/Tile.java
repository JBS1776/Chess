import java.awt.*;



import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
public class Tile {
 
 private int size;
 private int num;
 private Color color;
 private int x;
 private int y;
 boolean hasPiece;
 boolean isSelected;
 ImageIcon image;
 Piece piece;
 TileButton[][] tiles = Board.tiles;
 static int n = Constants.TILESIZE;
 public Tile() {
  this.size = size;
  this.num = num;
  this.color = color;
  this.x = x;
  this.y = y;
  this.hasPiece = false;
  this.piece = piece;
  if (piece != null) {
   this.image = image;
   this.piece = piece;
   this.hasPiece = true;
  }
 }
 
 public Tile(int size) {
  this.size = size;
  this.num = num;
  this.color = color;
  this.x = x;
  this.y = y;
  this.hasPiece = false;
  this.image = image;
  this.piece = piece;
  if (piece != null) {
   this.image = image;
   this.piece = piece;
   this.hasPiece = true;
  }
 }
 public Tile(Color color) {
  this.size = size;
  this.num = num;
  this.color = color;
  this.x = x;
  this.y = y;
  this.hasPiece = false;
  this.image = image;
  this.piece = piece;
  if (piece != null) {
   this.image = image;
   this.piece = piece;
   this.hasPiece = true;
  }
  else {
   this.hasPiece = false;
  }
 }
 public Tile(int size, int num, int x, int y, Color color) {
  this.size = size;
  this.num = num;
  this.x = x;
  this.y = y;
  this.color = color;
  this.hasPiece = false;
  this.image = image;
  this.piece = piece;
  if (piece != null) {
   this.image = image;
   this.piece = piece;
   this.hasPiece = true;
  }
  else {
   this.hasPiece = false;
  }
 }
 public Tile(int size, int num, int x, int y, Color color, Piece piece) {
  this.size = size;
  this.num = num;
  this.x = x;
  this.y = y;
  this.color = color;
  this.hasPiece = false;
  this.image = image;
  this.piece = piece;
  if (piece != null) {
   this.image = image;
   this.piece = piece;
   this.hasPiece = true;
  }
  else {
   this.hasPiece = false;
  }
 }
 public int getSize() {
  return this.size;
 }
 public int getNum() {
  return this.num;
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
 public boolean onBoard() {
  if (this.getX() >= 0 && this.getX() < Constants.BOARDWIDTH && this.getY() >= 0 && this.getY() < Constants.BOARDHEIGHT)
   return true;
  else
  return false;
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
 public boolean onBoard(int x, int y) {
  if (x >= 0 && x < Constants.BOARDWIDTH && y >= 0 && y < Constants.BOARDHEIGHT)
   return true;
  else
  return false;
 }
 public Tile upLeft() {
  if(this.getX() / n >= 1 && this.getY() / n >= 1) {
   return this.tiles[(this.getY() / n) - 1][(this.getX() / n) - 1].getTile();
  }
   return null;
 }
 public Tile up() {
  if(this.getX() / n >= 0 && this.getY() / n >= 1) {
   return this.tiles[(this.getY() / n) - 1][(this.getX() / n)].getTile();
  }
   return null;
  }
 public Tile upRight() {
  if(this.getX() / n <= 7 && this.getY() / n <= 7) {
   return this.tiles[(this.getY() / n) - 1][(this.getX() / n) + 1].getTile();
  }
   return null;
  }
 public Tile left() {
  if(this.getX() / n >= 1) {
   return this.tiles[(this.getY() / n)][(this.getX() / n) - 1].getTile();
  }
    return null;
 }
 public Tile right() {
  if(this.getX() / n <= 7) {
   return this.tiles[(this.getY() / n)][(this.getX() / n) + 1].getTile();
  }
  return null;  
 }
 public Tile downLeft() {
  if(this.getX() / n >= 1 && this.getY() / n <= 7) {
   return this.tiles[(this.getY() / n) + 1][(this.getX() / n) - 1].getTile();
  }
 return null;
 }
 public Tile down() {
  if(this.getY() / n <= 7) {
   return this.tiles[(this.getY() / n) + 1][(this.getX() / n)].getTile();
  }
 return null;
 }
 public Tile downRight() {
  if(this.getX() / n <= 7 && this.getY() / n <= 7) {
   return this.tiles[(this.getY() / n) + 1][(this.getX() / n) + 1].getTile();
  }
 return null;
 }
 
 public List<Tile> neighbors() {
  Tile[] nbors = {this.upLeft(), this.up(), this.upRight(), this.left(), this.right(), this.downLeft(), this.down(), this.downRight()};
  List<Tile> neighbors = new ArrayList<Tile>();
  for (Tile t : nbors) {
   if (t.onBoard()) {
    neighbors.add(t);
   }
  }
  return neighbors;
 }
 public Position toPosition(int x, int y) {
  if (onBoard(x, y)) {
  int divx = x / n;
  int divy = y / n;
  return new Position(Constants.xs[divx], Constants.ys[divy]);
  }
  return null;
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
 public void capturePiece(Piece p) {
  if (this.piece != null) {
   if (this.piece.getColor() != p.getColor()) {
    
   }
  }
 }
 public void draw(Graphics g, int x, int y, int size, Color color) {
  g.drawRect(x, y, size, size);
  g.setColor(color);
  g.fillRect(x, y, size, size);
 }
 public String toString() {
  return "" + this.num + ", " + x + ", " + y + ", " + this.color + this.hasPiece + ", (" + this.piece + ")";
 }

 public static void main(String[] args) {

  Tile t = new Tile(Constants.TILESIZE, 0, Constants.TILESIZE, Constants.TILESIZE, Color.WHITE, null);
  System.out.println(t.getPiece() == null);
  //System.out.println(t.upLeft());
 }
 }
