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
public class Tile implements java.io.Serializable{
 
 private int width;
 private int height;
 private int num;
 private Color color;
 private int x;
 private int y;
 boolean hasPiece;
 boolean isSelected;
 ImageIcon image;
 Piece piece;
 Board board = new Board();
 TileButton[][] tiles = board.tiles;
 static int n = Constants.TILEWIDTH;
 static int m = Constants.TILEHEIGHT;
 Position pos = new Position(x, y);
 public Tile() {
  this.width = width;
  this.height = height;
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
  this.pos = pos;
 }
 
 public Tile(int width, int height) {
  this.width = width;
  this.height = height;
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
  this.pos = pos;
 }
 public Tile(Color color) {
  this.width = width;
  this.height = height;
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
  this.pos = pos;
 }
 public Tile(int width, int height, int num, int x, int y, Color color) {
  this.width = width;
  this.height = height;
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
  this.pos = pos;
 }
 public Tile(int width, int height, int num, int x, int y, Color color, Piece piece) {
  this.width = width;
  this.height = height;
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
  this.pos = pos;
 }
 public int getWidth() {
  return this.width;
 }
 public int getHeight() {
   return this.height;
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
  if (x >= 0 && x < (Constants.BOARDWIDTH + Constants.SCREENPOSX) && y >= 0 && y < (Constants.BOARDHEIGHT + Constants.SCREENPOSY))
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
 public void capturePiece(Piece p) {
  if (this.piece != null) {
   if (this.piece.getColor() != p.getColor()) {
    
   }
  }
 }
 public void draw(Graphics g, int x, int y, int width, int height, Color color) {
  g.drawRect(x, y, width, height);
  g.setColor(color);
  g.fillRect(x, y, width, height);
 }
 public String toString() {
  return "" + this.num + ", " + x + ", " + y + ", " + "Pos: " + this.pos + ", " + this.color + ", " + this.hasPiece + ", (" + this.piece + ")";
 }

 public static void main(String[] args) {

  Tile t = new Tile(Constants.TILEWIDTH, Constants.TILEWIDTH, 0, Constants.TILEWIDTH, Constants.TILEWIDTH, Color.WHITE, null);
 }
 }
