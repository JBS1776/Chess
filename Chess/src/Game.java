import javax.swing.JFrame;


import javax.swing.JOptionPane;


import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import javax.swing.SwingUtilities;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;

public class Game extends JFrame implements Runnable{
 
 /**
  * 
  */
 private static final long serialVersionUID = 1L;

 ImageIcon[] blackimages = Constants.blackimages;
 ImageIcon[] whiteimages = Constants.whiteimages;
 static boolean whiteTurn = true;
 static boolean blackTurn = false;
 Color[] colors = Constants.colors;
 TileButton previouslySelected = null;
 Piece enPassWhite = null;
 Piece enPassBlack = null;
 static ArrayList<String> moveLog = new ArrayList<String>();
 static int turnCount = -1;
 static int maxTurns = 50;
 static int maxSeconds = Integer.MAX_VALUE;
 static String extraString = "";
 static boolean enableFrame = true;
  public Game() {
     }

@Override
public void run() {
 initializeMenu();
 TileButton[][] tiles = Board.tiles;
 setLayout(null);
 ArrayList<TileButton> pinkTiles = new ArrayList<TileButton>();
 int n = Constants.TILESIZE;
 for (TileButton[] til : tiles) {
  for (TileButton s : til) {
  add(s);
  s.setIcon(s.getTile().getImage());
  TileButton b = s;
  Tile t = s.getTile();
  add(b);
  b.setBounds(t.getX(), t.getY(), n, n);
  b.setOpaque(true);
  b.setBackground(t.getColor());
  b.setIcon(t.getImage());
  b.setFocusable(false);
  ActionListener listener = new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               Object source = e.getSource();
               Color turnColor = colors[0];
               String colorName = "white";
               if (whiteTurn) {
         turnColor = colors[0];
         colorName = "white";
               }
               if (blackTurn) {
         turnColor = colors[1];
         colorName = "black";
               }
               if (source instanceof TileButton) {
                TileButton b = ((TileButton)source);
                Tile tile = b.getTile();
                // Does this tile have a piece?
                if (tile.getPiece() != null) {
                 // Has there been movement before?
                 if (previouslySelected == b) {
                  for (TileButton but : pinkTiles) {
                     but.setBackground(but.getTile().getColor());
                    }
                    pinkTiles.clear();
                    previouslySelected = null;
                 }
                 else {
                  if (previouslySelected != null) {
                   if (!tile.getPiece().getColor().equals(turnColor)) {
                   Color curr = tile.getPiece().getColor();
                   Color prev = previouslySelected.getTile().getPiece().getColor();
                   if (!curr.equals(prev)) {
                    //System.out.println("T");
                    if (pinkTiles.contains(b)) {
                     Piece current = tile.getPiece();
                     Piece piece = previouslySelected.getTile().getPiece();
                     if (current instanceof King) {
                      if (curr.equals(colors[0])) {
                       JOptionPane.showMessageDialog(null, "Checkmate!  Black wins!", "Long Live the King!", 1);
                      }
                      if (curr.equals(colors[1])) {
                       JOptionPane.showMessageDialog(null, "Checkmate!  White wins!", "Long Live the King!", 1);
                      }
                     }
                     if (piece instanceof Pawn) {
                      if (piece.getPos().getY() == 2 && piece.getColor().equals(colors[0])) {
                       //String move = piece.getName() + " number " + piece.getId() + "has promoted to a ";
                       Promotion p = new Promotion(piece.getColor(), b);
                       p.setVisible(true);
                       enableFrame = !enableFrame;
                       enableTheFrame(enableFrame);
                       //move += piece.getName() + " at " + piece.getPos();
                       //moveLog.add(move);
                       //System.out.println(move);
                      }
                      if (piece.getPos().getY() == 7 && piece.getColor().equals(colors[1])) {
                       //String move = piece.getName() + " number " + piece.getId() + "has promoted to a ";
                       Promotion p = new Promotion(piece.getColor(), b);
                       p.setVisible(true);
                       enableFrame = !enableFrame;
                       enableTheFrame(enableFrame);
                       //move += piece.getName() + " at " + piece.getPos();
                       //moveLog.add(move);
                       //System.out.println(move);
                      }
                     }
                    addMove(piece, previouslySelected.getTile(), tile, extraString, b.getTile().getPiece());
                    b.getTile().setPiece(null);
                    b.getTile().setImage(null);
                    b.setIcon(null);
                    b.getTile().setPiece(previouslySelected.getTile().getPiece());
                    Position p = b.getTile().toPosition(b.getTile().getX(), b.getTile().getY());
                    b.getTile().getPiece().setPosition(p);
                    b.getTile().setImage(b.getTile().getPiece().getImage());
                    b.setIcon(b.getTile().getImage());
                    previouslySelected.getTile().setPiece(null);
                    previouslySelected.getTile().setImage(null);
                    previouslySelected.setIcon(null);
                    for (TileButton but : pinkTiles) {
                     but.setBackground(but.getTile().getColor());
                    }
                    pinkTiles.clear();
                    previouslySelected = null;
                    whiteTurn = !whiteTurn;
                    blackTurn = !blackTurn;
                    turnCount++;
                    System.out.println((turnCount + 1) + ". " + moveLog.get(turnCount));
                    }
                    else {
                     System.out.println("It's " + colorName + "'s turn to move.");
                     for (TileButton but : pinkTiles) {
                      but.setBackground(but.getTile().getColor());
                     }
                     pinkTiles.clear();
                     previouslySelected = null;
                    }
                   }
                   else {
                    System.out.println("It's " + colorName + "'s turn to move.");
                    for (TileButton but : pinkTiles) {
                     but.setBackground(but.getTile().getColor());
                    }
                    pinkTiles.clear();
                    }
                  }
                   else {
                    for (TileButton but : pinkTiles) {
                     but.setBackground(but.getTile().getColor());
                    }
                    pinkTiles.clear();
                    Piece p = tile.getPiece();
                    if ((Object) p instanceof Pawn) {
                              Pawn q = (Pawn) p;
                              q.setPath(tiles, b);
                              for (TileButton but : p.getPath()) {
                              pinkTiles.add(but);
                              }
                             }
                              else {
                               if ((Object) p instanceof Rook) {
                                Rook q = (Rook) p;
                                   q.setPath(tiles, b);
                                   for (TileButton but : p.getPath()) {
                                   pinkTiles.add(but);
                                   }
                               }
                              else {
                               if ((Object) p instanceof Knight) {
                                Knight q = (Knight) p;
                                   q.setPath(tiles, b);
                                   for (TileButton but : p.getPath()) {
                                   pinkTiles.add(but);
                                   }
                               }
                               else {
                                if ((Object) p instanceof Bishop) {
                                 Bishop q = (Bishop) p;
                                      q.setPath(tiles, b);
                                      for (TileButton but : p.getPath()) {
                                      pinkTiles.add(but);
                                      }
                                }
                                else {
                                 if ((Object) p instanceof Queen) {
                                    Queen q = (Queen) p;
                                         q.setPath(tiles, b);
                                         for (TileButton but : p.getPath()) {
                                         pinkTiles.add(but);
                                         }
                                   }
                                 else {
                                  if ((Object) p instanceof King) {
                                       King q = (King) p;
                                            q.setPath(tiles, b);
                                            for (TileButton but : p.getPath()) {
                                            pinkTiles.add(but);
                                            }
                                      }
                                 }
                                }
                               }
                              }
                             }
                    previouslySelected = b;
                   }
                     }
                  
                  else {
                   if (tile.getPiece().getColor().equals(turnColor)) {
                 previouslySelected = b;
                 for (TileButton but : pinkTiles) {
                  but.setBackground(but.getTile().getColor());
                 }
                 pinkTiles.clear();
                 Piece p = tile.getPiece(); 
                 if ((Object) p instanceof Pawn) {
                 Pawn q = (Pawn) p;
                 q.setPath(tiles, b);
                 for (TileButton but : p.getPath()) {
                 pinkTiles.add(but);
                 }
                }
                 else {
                  if ((Object) p instanceof Rook) {
                   Rook q = (Rook) p;
                      q.setPath(tiles, b);
                      for (TileButton but : p.getPath()) {
                      pinkTiles.add(but);
                      }
                  }
                 else {
                  if ((Object) p instanceof Knight) {
                   Knight q = (Knight) p;
                      q.setPath(tiles, b);
                      for (TileButton but : p.getPath()) {
                      pinkTiles.add(but);
                      }
                  }
                  else {
                   if ((Object) p instanceof Bishop) {
                    Bishop q = (Bishop) p;
                         q.setPath(tiles, b);
                         for (TileButton but : p.getPath()) {
                         pinkTiles.add(but);
                         }
                   }
                   else {
                    if ((Object) p instanceof Queen) {
                       Queen q = (Queen) p;
                            q.setPath(tiles, b);
                            for (TileButton but : p.getPath()) {
                            pinkTiles.add(but);
                            }
                      }
                    else {
                     if ((Object) p instanceof King) {
                          King q = (King) p;
                               q.setPath(tiles, b);
                               for (TileButton but : p.getPath()) {
                               pinkTiles.add(but);
                               }
                         }
                    }
                   }
                  }
                 }
                }
                }
                   else {
                    if (!tile.getPiece().getColor().equals(turnColor)) {
                     System.out.println("It's " + colorName + "'s turn to move.");
                    for (TileButton but : pinkTiles) {
                     but.setBackground(but.getTile().getColor());
                    }
                    pinkTiles.clear();
                    previouslySelected = null;
                   }
                   }
                  //previouslySelected = b;
                 }
                 }
                }
                else {
                 if (pinkTiles.contains(b)) {
                  Tile prevTil = previouslySelected.getTile();
                  Piece p = previouslySelected.getTile().getPiece();
                  int x = b.getTile().getX() / n;
                  int y = b.getTile().getY() / n;
                  int ex = prevTil.getX() / n;
                int why = prevTil.getY() / n;
                  if ((Object) p instanceof King && !p.hasMovedYet &&
                   (b.equals(tiles[y][ex - 2]) || b.equals(tiles[y][ex + 2]))) {
                   if (b.equals(tiles[y][ex - 2])) {
                    Piece q = tiles[y][x - 2].getTile().getPiece();
                    q.hasMovedYet = true;
                    tiles[y][x + 1].getTile().setPiece(q);
                    Position pos = tiles[y][x + 1].getTile().toPosition(tiles[y][x + 1].getTile().getX(), 
                        tiles[y][x + 1].getTile().getY());
                    tiles[y][x + 1].getTile().getPiece().setPosition(pos);
                    tiles[y][x + 1].getTile().setImage(tiles[y][x - 2].getTile().getImage());
                    tiles[y][x + 1].setIcon(tiles[y][x - 2].getTile().getImage());
                    tiles[y][x - 2].getTile().setPiece(null);
                    tiles[y][x - 2].getTile().setImage(null);
                    tiles[y][x - 2].setIcon(null);
                   }
                   if (b.equals(tiles[y][ex + 2])) {
                   Piece q = tiles[y][x + 1].getTile().getPiece();
                   q.hasMovedYet = true;
                   tiles[y][x - 1].getTile().setPiece(q);
                   Position pos = tiles[y][x - 1].getTile().toPosition(tiles[y][x - 1].getTile().getX(), 
                     tiles[y][x - 1].getTile().getY());
                   tiles[y][x - 1].getTile().getPiece().setPosition(pos);
                   tiles[y][x - 1].getTile().setImage(tiles[y][x + 1].getTile().getImage());
                   tiles[y][x - 1].setIcon(tiles[y][x - 1].getTile().getImage());
                   tiles[y][x + 1].getTile().setPiece(null);
                   tiles[y][x + 1].getTile().setImage(null);
                   tiles[y][x + 1].setIcon(null);
                   }
                  }
                  if ((Object) p instanceof Pawn) {
                   Pawn q = (Pawn) p;
                   if (p.getPos().getY() == 2 && p.getColor().equals(colors[0])) {
              Promotion prom = new Promotion(p.getColor(), b);
              prom.setVisible(true);
             }
             if (p.getPos().getY() == 7 && p.getColor().equals(colors[1])) {
              Promotion prom = new Promotion(p.getColor(), b);
              prom.setVisible(true);
             }
                   if (!p.hasMovedYet && (y == why + 2 || y == why - 2)) {
                    q.enPassent_elegible = true;
                    if (p.getColor().equals(colors[0])) {
                    enPassWhite = q;
                    }
                    else {
                     if (p.getColor().equals(colors[1]))
                     enPassBlack = q;
                    }
                     
                   }
                   else {
                    q.enPassent_elegible = false;
                   }
                   if (ex != x && b.getTile().getPiece() == null) {
                    if (x > ex) {
                     Tile ti = tiles[why][ex + 1].getTile();
                     ti.setPiece(null);
                     ti.setImage(null);
                     tiles[why][ex + 1].setIcon(null);
                    }
                    if (x < ex) {
                     Tile ti = tiles[why][ex - 1].getTile();
                     ti.setPiece(null);
                     ti.setImage(null);
                     tiles[why][ex - 1].setIcon(null);
                    }
                   }
                  }
                  Tile prevtil = previouslySelected.getTile();
                  Tile curTil = b.getTile();
                  curTil.setPiece(prevtil.getPiece());
                  Position pos = curTil.toPosition(curTil.getX(), curTil.getY());
                  curTil.getPiece().setPosition(pos);
                  addMove(p, prevtil, curTil, extraString);
                  curTil.setImage(prevtil.getImage());
                  b.setIcon(previouslySelected.getIcon());
                  curTil.getPiece().hasMovedYet = true;
                  prevtil.setPiece(null);
                  previouslySelected.setIcon(null);
                  whiteTurn = !whiteTurn;
                blackTurn = !blackTurn;
                turnCount++;
                System.out.println((turnCount + 1) + ". " + moveLog.get(turnCount));
                if (enPassBlack != null && blackTurn) {
                 Pawn pawn = (Pawn) enPassBlack;
                 pawn.enPassent_elegible = false;
                }
                else {
                 if (enPassWhite != null && whiteTurn) {
                  Pawn pawn = (Pawn) enPassWhite;
                     pawn.enPassent_elegible = false;
                 }
                }
                 }
                 for (TileButton but : pinkTiles) {
                  but.setBackground(but.getTile().getColor());
                 }
                 previouslySelected = null;
                 pinkTiles.clear();
                 extraString = "";
                }
               }
           }
 };
 b.addActionListener(listener);
  }
 }
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
     this.setSize(Constants.BOARDWIDTH, Constants.BOARDHEIGHT + 20);
     setVisible(true);
}
void enableTheFrame(boolean b) {
 setEnabled(b);
}
private void addMove(Piece p, Tile a, Tile b) {
 String name = p.getName();
 Position startPos = a.toPosition(a.getX(), a.getY());
 Position endPos = b.toPosition(b.getX(), b.getY());
 this.moveLog.add(name + " at " + startPos + " moved to " + endPos + ".");
}
private void addMove(Piece p, Tile a, Tile b, String extraMessage) {
 String name = p.getName();
 Position startPos = a.toPosition(a.getX(), a.getY());
 Position endPos = b.toPosition(b.getX(), b.getY());
 this.moveLog.add(name + " at " + startPos + " moved to " + endPos + "." + extraMessage);
}
private void addMove(Piece p, Tile a, Tile b, String extraMessage, Piece other) {
 String name = p.getName();
 String otherName = other.getName();
 Position startPos = a.toPosition(a.getX(), a.getY());
 Position endPos = b.toPosition(b.getX(), b.getY());
 this.moveLog.add(name + " at " + startPos + " captured " + otherName + " at " + endPos + "." + extraMessage);
}
private void addMove(Piece p, Tile a, Piece other) {
 String name = p.getName();
 Position startPos = a.toPosition(a.getX(), a.getY());
 //Position endPos = b.toPosition(b.getX(), b.getY());
 this.moveLog.add(name + " at " + startPos + " promoted to " + other.getName() + ".");
}
public void initializeMenu() {
 JMenuBar menuBar = new JMenuBar();
 JMenu menu1 = new JMenu("File");
 JMenu menu2 = new JMenu("Settings");
 JMenu menu3 = new JMenu("Instructions");
 JMenuItem stuff = new JMenuItem("Who reads them these days?");
 //JMenuItem hint = new JMenuItem("Suggest a move: Only works when your King is in check");
 JMenuItem reset = new JMenuItem("surrender ONLY LOSERS SURRENDER!!");
 JMenuItem save = new JMenuItem("save: It's always good to save");
 JMenuItem open = new JMenuItem("open: Load a saved game");
 JMenuItem setTime = new JMenuItem("other options: set time limit per move, etc.");
 menu1.add(open);
 menu1.add(save);
 menu2.add(reset);
 menu2.add(setTime);
 menu3.add(stuff);
 //menu3.add(hint);
 menuBar.add(menu1);
 menuBar.add(menu2);
 menuBar.add(menu3);
 setTime.addActionListener(new ActionListener() {
  @Override
  public void actionPerformed(ActionEvent e) {
   Options o = new Options() {
    @Override
    public void paint(Graphics g) {
     super.paint(g);
     g.drawString("Input a positive integer with less than five digits.", 60, 67);
     g.drawString("Time will be set to unlimited otherwise.", 5, 85);
     g.drawString("Hello!  Hope these are the settings you want!", 5, 230);
     g.drawString("Remember: the game doesn't tell you when your king is in check", 5, 250);
     g.drawString("This means that the game ends when the King is captured like any other piece", 5, 270);
     g.drawString("^ resulting in checkmate of course.", 5, 290);
     g.drawString("We Americans hate stalemates.  GET USED TO IT!!", 5, 310);
    }
   };
  }
 });
 this.setJMenuBar(menuBar);
}
public static void main(String[] args) {
  try {
   //System.setProperty("apple.laf.useScreenMenuBar", "true");
   //System.setProperty("com.apple.mrj.application.apple.menu.about.name", "WikiTeX");
   UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      //UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
  } catch (Exception e) {
      System.err.println("Cannot set LookAndFeel");
  }
  SwingUtilities.invokeLater(new Game());
 }
}