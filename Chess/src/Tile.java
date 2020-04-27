import java.awt.*;
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
  Pawn p = new Pawn(0, Color.BLACK, new Position(0, 0), Constants.images[1][8], "test", false);
  Tile t = new Tile(Constants.TILEWIDTH, Constants.TILEWIDTH, 0, Constants.TILEWIDTH, Constants.TILEWIDTH, Color.WHITE, p);
  System.out.println(t);
 }
 }
