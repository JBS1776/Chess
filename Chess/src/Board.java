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
import java.util.List;
public class Board {
public static TileButton[][] fillTiles() {
 TileButton[][] tis = new TileButton[8][8];
 int x = 0;
 int y = 0;
 int n = Constants.TILESIZE;
 int index = 0;
 for (int i = 0; i < 8; i++) {
  for (int j = 0; j < 8; j++) {
   int colIndex = (i + j) % 2;
   int idNum = index % 64;
   Tile t = new Tile(n, idNum, x, y, Constants.colors[colIndex]);
   TileButton b = new TileButton(t);
   Tile tile = b.getTile();
   Position fromCoord = tile.toPosition(tile.getX(), tile.getY());
   int ex = fromCoord.getX() - 1;
   if (fromCoord.getY() == 1) {
      tile.setImage(Constants.blackimages[ex]);
      int identification = 1;
      if (ex <= 4)
       identification = 1;
      else
       identification = 2;
      switch(ex) {
      case (0) : {
       tile.setPiece(new Rook(identification, Color.BLACK, tile.toPosition(x, y), 
            tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;
       break;
      }
      case (1) : {
       tile.setPiece(new Knight(identification, Color.BLACK, tile.toPosition(x, y), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;
       break;
      }
      case (2) : {
       tile.setPiece(new Bishop(identification, Color.BLACK, tile.toPosition(x, y), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;
       break;
      }
      case (3) : {
       tile.setPiece(new Queen(identification, Color.BLACK, tile.toPosition(x, y), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;
       break;
      }
      case (4) : {
       tile.setPiece(new King(identification, Color.BLACK, tile.toPosition(x, y), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;
       break;
      }
      case (5) : {
       tile.setPiece(new Bishop(identification, Color.BLACK, tile.toPosition(x, y), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;
       break;
      }
      case (6) : {
       tile.setPiece(new Knight(identification, Color.BLACK, tile.toPosition(x, y), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;
       break;
      }
      case (7) : {
       tile.setPiece(new Rook(identification, Color.BLACK, tile.toPosition(x, y), 
            tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;
       break;
      }
      }
      
     }
     if (fromCoord.getY() == 2) {
      tile.setImage(Constants.blackimages[Constants.blackimages.length - 1]);
      tile.setPiece(new Pawn(ex + 1, Color.BLACK, tile.toPosition(x, y), 
         tile.getImage(), tile.getImage().getDescription()));
      tile.hasPiece = true;
     }
     if (fromCoord.getY() == 7) {
      tile.setImage(Constants.whiteimages[Constants.whiteimages.length - 1]);
      tile.setPiece(new Pawn(ex + 1, Color.WHITE, tile.toPosition(x, y), 
         tile.getImage(), tile.getImage().getDescription()));
      tile.hasPiece = true;
     }
     if (fromCoord.getY() == 8) {
      tile.setImage(Constants.whiteimages[ex]);
      int identification = 1;
      if (ex <= 4)
       identification = 1;
      else
       identification = 2;
      switch(ex) {
      case (0) : {
       tile.setPiece(new Rook(identification, Color.WHITE, tile.toPosition(x, y), 
            tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;
       break;
      }
      case (1) : {
       tile.setPiece(new Knight(identification, Color.WHITE, tile.toPosition(x, y), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;
       break;
      }
      case (2) : {
       tile.setPiece(new Bishop(identification, Color.WHITE, tile.toPosition(x, y), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;
       break;
      }
      case (3) : {
       tile.setPiece(new Queen(identification, Color.WHITE, tile.toPosition(x, y), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;
       break;
      }
      case (4) : {
       tile.setPiece(new King(identification, Color.WHITE, tile.toPosition(x, y), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;
       break;
      }
      case (5) : {
       tile.setPiece(new Bishop(identification, Color.WHITE, tile.toPosition(x, y), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;
       break;
      }
      case (6) : {
       tile.setPiece(new Knight(identification, Color.WHITE, tile.toPosition(x, y), 
         tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;
       break;
      }
      case (7) : {
       tile.setPiece(new Rook(identification, Color.WHITE, tile.toPosition(x, y), 
            tile.getImage(), tile.getImage().getDescription()));
       tile.hasPiece = true;
       break;
      }
      }
      
     }
     tis[i][j] = b;
     x += n;
     index++;
     if (ex % 8 == 7) {
      x = 0;
      y += n;
     }
  }
  }
 return tis;
}
public static TileButton[][] tiles = fillTiles();
public static void main(String[] args) {
 //TileButton[][] tiles = Board.getTiles();
  for (int i = 0; i < 8; i++)
    for (int j = 0; j < 8; j++)
 System.out.println(tiles[i][j].getTile());
}
}
