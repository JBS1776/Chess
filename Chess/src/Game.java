import javax.swing.JOptionPane;


import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Game extends JPanel implements java.io.Serializable{
 private static final long serialVersionUID = 1L;
 Board board;
 /*ImageIcon[] blackimages = Constants.blackimages;
 ImageIcon[] whiteimages = Constants.whiteimages;*/
 ImageIcon[][] images = Constants.images;
 Color[] colors = Constants.colors;
 TileButton previouslySelected = null;
 TileButton takeCyan = null;
 Piece enPassant = null;
 ArrayList<TileButton> takeRed = new ArrayList<TileButton>();
 ArrayList<String> moveList = new ArrayList<String>();
 ArrayList<LinkedList<Piece>> capturedpieces = new ArrayList<LinkedList<Piece>>();
 int turnCount = 0; // different save
 int maxTurns = 50;
 int maxSeconds = Integer.MAX_VALUE;
 String extraString = "";
 Color turnColor = Constants.colors[this.getTurnCount() % 2];
 boolean currKingCheck = false; // different save
 boolean castleProcessing = false; // different save
 int time = Constants.TIME; // 15 * 60
 int minutes = this.getTime() / 60;
 int seconds = this.getTime() % 60;
 long delay = this.getTime() * 1000;
 boolean gameEnded = false; // different save
 boolean timeEnabled = false; // different save
 boolean takeMeEnabled = false; // different save
 Random rand = new Random();
 JTextField label = new JTextField("", JLabel.LEFT);
 JTextField turnLabel = new JTextField("", JLabel.LEFT);
 JTextField turnCountLabel = new JTextField("", JLabel.LEFT);
 int pieceLook = 0;
 int ailevel = 0;
 int aiColor = 0;
 Computerplayer cp = new Computerplayer();
 public Game(ArrayList<Piece>[] ps, int turnInc, boolean kingCheck, boolean castle, boolean endGame, boolean timeEnable, boolean takeMe, int newTime, Piece enpass, int pieceLook, int ailevel, int aiColor, ArrayList<LinkedList<Piece>> caps, ArrayList<String> movs, Gamewindow gw) throws InterruptedException {
 //caps = this.getBoard().pieceCount;
 //this.capturedpieces.addAll(new ArrayList<Piece>());
	 // this.capturedpieces and this.moveList always starts as empty list
	 if (caps == null) {
		 caps = this.capturedpieces;
 for (int i = 0; i < 12; i++) {
	 this.capturedpieces.add(new LinkedList<Piece>());
 }
	 }
	 else
		 this.capturedpieces.addAll(caps);
	 if (movs == null)
		 movs = this.moveList;
	 else
		 this.moveList.addAll(movs);
 cp = new Computerplayer();
 turnCount = turnInc;
 currKingCheck = kingCheck;
 castleProcessing = castle;
 gameEnded = endGame;
 timeEnabled = timeEnable;
 takeMeEnabled = takeMe;
 //System.out.println(takeMeEnabled);
 Constants.isEnabled = timeEnabled;
 Constants.takeMeChess = takeMeEnabled;
 this.setTime(newTime);
 //System.out.println(this.getTime());
 //System.out.println("Newtime: " + this.getTime());
 label.setBounds(1200, 20, 200, 30);
 label.setEditable(false);
 label.setBackground(null);
 label.setBorder(null);
 label.setFont(new Font(label.getText(), Font.BOLD, label.getFont().getSize()));
 turnLabel.setBounds(100, 20, 200, 30);
 turnLabel.setEditable(false);
 turnLabel.setBackground(null);
 turnLabel.setBorder(null);
 turnLabel.setFont(new Font(turnLabel.getText(), Font.BOLD, turnLabel.getFont().getSize()));
 turnCountLabel.setBounds(100, 40, 200, 30);
 turnCountLabel.setEditable(false);
 turnCountLabel.setBackground(null);
 turnCountLabel.setBorder(null);
 turnCountLabel.setFont(new Font(turnCountLabel.getText(), Font.BOLD, turnCountLabel.getFont().getSize()));
 setLayout(null);
 add(label);
 add(turnLabel);
 add(turnCountLabel);
 turnLabel.setText(((turnCount % 2 == 0) ? "White's" : "Black's") + " turn to move!");
 //System.out.println(turnCount);
 turnCountLabel.setText("Turns passed: " + turnCount);
 this.turnColor = Constants.colors[turnCount % 2];
 this.previouslySelected = null;
 this.enPassant = enpass;
 this.pieceLook = pieceLook;
 this.ailevel = ailevel;
 this.aiColor = aiColor;
 board = new Board();
 //System.out.println("Step 1");
 TileButton[][] tiles = board.tiles;
 if (ps == null)
 board.fillTiles(Constants.SCREENPOSX, Constants.SCREENPOSY);
 else
   board.fillTiles2(Constants.SCREENPOSX, Constants.SCREENPOSY, ps);
 //System.out.println(board.tiles[0][0].getTile().getPiece());
 board.setPieces(this);
 if (!Constants.takeMeChess) {
 board.reducePath(turnColor, this);
 board.pinnedPieces(turnColor);
 //board.reducePath(turnColor, this);
 board.checkMate(turnColor, this);
 }
 this.setBackground(Constants.BACKGROUNDCOL);
 int n = Constants.TILEWIDTH;
 int m = Constants.TILEHEIGHT;
 this.setGameEnded(false);
 this.setTimeEnabled(timeEnable);
 this.setTakeMeEnabled(takeMe);
 this.pieceLook = pieceLook;
 //System.out.println("Round2: " + this.getTakeMeEnabled());
 Game g = this;
 for (TileButton[] til : tiles) {
  for (TileButton s : til) {
  add(s);
  s.setIcon(s.getTile().getImage());
  TileButton b = s;
  Tile t = s.getTile();
  add(b);
  b.setBounds(t.getX(), t.getY(), n, m);
  b.setOpaque(true);
  b.setBackground(t.getColor());
  b.setIcon(t.getImage());
  b.setFocusable(false);
  if (!Constants.takeMeChess)
    board.kingsButton[turnCount % 2].setBackground(Constants.TURNHIGHLIGHT);
  if (board.isKingInCheck(turnColor, g) && !Constants.takeMeChess)
    board.kingsButton[turnCount % 2].setBackground(Constants.CHECKHIGHLIGHT);
  if (Constants.takeMeChess)
    board.takeMePath(turnColor, g);
  ActionListener listener = new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               Object source = e.getSource();
               String colorName = "white";
               if (turnCount % 2 == 0) {
         colorName = "white";
               }
               else {
         colorName = "black";
               }
               if (source instanceof TileButton) {
                 // Pauses the game to let player choose a pawn promotion
                 if (Constants.isPromotionEnabled) {
                   //System.out.println("PROMOTION!!");
                 //gw.setEnabled(false);
                	 //if (turnCount % 2 == 0)
                 JOptionPane.showMessageDialog(null, "Choose a promotion before continuing!", "NO CHEATING!", JOptionPane.ERROR_MESSAGE, Constants.images[turnCount % 2][rand.nextInt(Constants.images[turnCount % 2].length)]);
               }
                 else {
                TileButton b = ((TileButton)source);
                if (ailevel > 0 && !g.getGameEnded()) {
                	/*Piece randPiece = board.getRandomPiece(g, Constants.colors[aiColor]);
                	while (randPiece.path.size() <= 1) {
                		randPiece = board.getRandomPiece(g, Constants.colors[aiColor]);
                	}
                	previouslySelected = board.tiles[randPiece.getPosition().getY()][randPiece.getPosition().getX()];
                	b = randPiece.getRandTile();*/
                	if (ailevel == 3 || turnCount % 2 == aiColor) {
                	cp = cp.cpuMoveEasy(g, Constants.colors[turnCount % 2]);
                	Piece randPiece = cp.getPiece();
                	previouslySelected = cp.getTile();
                	b = randPiece.getRandTile();
                	}
                }
                //System.out.println(b.getTile().getPosition());
                Tile tile = b.getTile();
                if (tile.getPiece() != null) {
                  if (previouslySelected != null) {
                    System.out.println("piece deselecting");
                    previouslySelected.deSelect(previouslySelected.getTile().getPiece().getPath(), g);
                    if (!previouslySelected.equals(b)) {
                    	System.out.println("You didn't click on the same piece");
                      if (tile.getPiece() != null && previouslySelected.getTile().getPiece().getPath().contains(b)) {
                        Piece piece = previouslySelected.getTile().getPiece();
                        Piece q = tile.getPiece();
                        boolean moved = piece.hasMovedYet;
                        String initialPos = piece.getName() + " " + piece.getId() + " " + piece.getPosition() + "->";
                        //System.out.print(initialPos);
                        System.out.println("Piece Captured");
                        board.move(previouslySelected, b, g);
                        String movPos = tile.getPiece().getName() + " " + tile.getPiece().getId() + " " + piece.getPosition();
                        //System.out.println(movPos);
                        board.setPieces(g);
                        if (tile.getPiece() instanceof King && !Constants.takeMeChess) {
                        board.kingsButton[turnCount % 2].setBackground(board.kingsButton[turnCount % 2].getTile().getColor());
                        board.kingsButton[turnCount % 2] = b;
                        }
                        if (tile.getPiece() instanceof Pawn) {
                          Position pos = b.getTile().getPosition();
                          int x = pos.getX();
                          int y = pos.getY();
                          if (y == 0 || y == 7) {
                            gw.setEnabled(false);
                            //System.out.println("Testing123");
                            Promotion p = new Promotion(tile.getPiece().getColor(), b, g, gw);
                            if (g.getAilevel() > 0)
                            	p.setVisible(turnCount % 2 != aiColor);
                            else
                            	p.setVisible(true);
                   }
                 }
                        if (!Constants.takeMeChess)
                        board.kingsButton[turnCount % 2].setBackground(board.kingsButton[turnCount % 2].getTile().getColor());
                        else
                          TileButton.clearPaint(g);
                        turnCount += 1;
                        turnColor = Constants.colors[turnCount % 2];
                        takeCyan = null;
                        takeRed.clear();
                        if (!Constants.takeMeChess) {
                          if (!Constants.isPromotionEnabled) {
                        board.kingsButton[turnCount % 2].setBackground(Constants.TURNHIGHLIGHT);
               if (board.isKingInCheck(turnColor, g)) {
                 board.kingsButton[turnCount % 2].setBackground(Constants.CHECKHIGHLIGHT);
               }
               board.pinnedPieces(turnColor);
               board.reducePath(turnColor, g);
               //board.pinnedPieces(turnColor);
                          }
               }
               else
               board.takeMePath(turnColor, g);
               board.checkMate(turnColor, g);
               turnLabel.setText(((turnCount % 2 == 0) ? "White's" : "Black's") + " turn to move!");
               turnCountLabel.setText("Turns passed: " + turnCount);
               g.setTime(Constants.TIME);
               g.setDelay(g.getTime() * 1000);
                        previouslySelected = null;
                      }
                      else {
                        if (tile.getPiece().getColor().equals(turnColor)) {
                      b.select(tile.getPiece().getPath());
                      previouslySelected = b;
                        }
                        else {
                          previouslySelected = null;
                        }
                      }
                    }
                    else {
                    	System.out.println("You clicked on the same piece");
                      previouslySelected = null;
                    }
                  }
                  else {
                    if (tile.getPiece().getColor().equals(turnColor)) {
                      b.select(b.getTile().getPiece().getPath());
                      previouslySelected = b;
                    }
                  } 
                }
                else {
                  if (previouslySelected != null) {
                    Piece p = previouslySelected.getTile().getPiece();
                    previouslySelected.deSelect(p.getPath(), g);
                    System.out.println("DEST");
                    if (previouslySelected.getTile().getPiece().getPath().contains(b)) {
                    // For Castling
                      System.out.println("YELLSDDSD");
                      Position posPrev = previouslySelected.getTile().getPosition();
                      Position pos = b.getTile().getPosition();
                      int posDiff = pos.getX() - posPrev.getX();
                      TileButton but1 = null;
                      TileButton but2 = null;
                      String castlingComplete = "";
                    if (p instanceof King && !p.hasMovedYet) {
                        if (posDiff == 2 || posDiff == -2) {
                          if (posDiff == 2) {
                            but1 = board.tiles[pos.getY()][pos.getX() + 1];
                            but2 = board.tiles[pos.getY()][pos.getX() - 1];
                            Piece rookinitial = but1.getTile().getPiece();
                            board.move(but1, but2, g);
                            Tile rookNew = but2.getTile();
                            //System.out.println(rookNew == null);
                          }
                          if (posDiff == -2) {
                            but1 = board.tiles[pos.getY()][pos.getX() - 2];
                            but2 = board.tiles[pos.getY()][pos.getX() + 1];
                            board.move(but1, but2, g);
                          }
                          board.setPieces(g);
                          //System.out.println("Castling Complete");
                          board.kingsButton[turnCount % 2].setBackground(board.kingsButton[turnCount % 2].getTile().getColor());
                          board.kingsButton[turnCount % 2] = b;
                          System.out.println(p.getName() + p.getId());
                          // Pop Rook's move from list
                          g.moveList.remove(g.moveList.size() - 1);
                          castlingComplete = " Castling comptele!";
                        }
                        }
                    boolean hasPieceMovedYet = previouslySelected.getTile().getPiece().hasMovedYet;
                    Piece ploginitial = previouslySelected.getTile().getPiece();
                    //System.out.print(ploginitial.getName() + " " + ploginitial.getId() + " " + ploginitial.getPosition() + " -> ");
                    board.move(previouslySelected, b, g);
                    g.moveList.set(g.moveList.size() - 1, g.moveList.get(g.moveList.size() - 1) + castlingComplete);
                    board.setPieces(g);
                    Piece plognew = b.getTile().getPiece();
                    //System.out.println(plognew.getName() + " " + plognew.getId() + " " + plognew.getPosition());
                    if (tile.getPiece() instanceof King) {
                      if (!Constants.takeMeChess) {
                        board.kingsButton[turnCount % 2].setBackground(board.kingsButton[turnCount % 2].getTile().getColor());
                        board.kingsButton[turnCount % 2] = b;
                      }
                      else
                        TileButton.clearPaint(g);
                        turnCount += 1;
                        turnColor = Constants.colors[turnCount % 2];
                        takeCyan = null;
                        takeRed.clear();
                        if (!Constants.takeMeChess) {
                          if (!Constants.isPromotionEnabled) {
                        board.kingsButton[turnCount % 2].setBackground(Constants.TURNHIGHLIGHT);
               if (board.isKingInCheck(turnColor, g)) {
                 board.kingsButton[turnCount % 2].setBackground(Constants.CHECKHIGHLIGHT);
               }
               board.pinnedPieces(turnColor);
               board.reducePath(turnColor, g);
               //board.pinnedPieces(turnColor);
                          }
               }
               else
               board.takeMePath(turnColor, g);              
               board.checkMate(turnColor, g);
               turnLabel.setText(((turnCount % 2 == 0) ? "White's" : "Black's") + " turn to move!");
               turnCountLabel.setText("Turns passed: " + turnCount);
               g.setTime(Constants.TIME);
               g.setTime(g.getTime() * 1000);
                    }
                    else {
                      if (tile.getPiece() instanceof Pawn) {
                          pos = tile.getPosition();
                          int x = pos.getX();
                          int y = pos.getY();
                          //System.out.println(x + ", " + y);
                          if (y == 0 || y == 7) {
                            gw.setEnabled(false);
                            //System.out.println("Testing12");
                            Promotion prom = new Promotion(tile.getPiece().getColor(), b, g, gw);
                            if (g.getAilevel() > 0)
                            prom.setVisible(turnCount % 2 != aiColor);
                            else
                            	prom.setVisible(true);
                   }
                      }
                      if (!Constants.takeMeChess)
                    board.kingsButton[turnCount % 2].setBackground(board.kingsButton[turnCount % 2].getTile().getColor());
                      else
                        TileButton.clearPaint(g);
                    turnCount += 1;
                    turnColor = Constants.colors[turnCount % 2];
                    takeCyan = null;
                    takeRed.clear();
                    if (!Constants.takeMeChess) {
                      if (!Constants.isPromotionEnabled) {
                    board.kingsButton[turnCount % 2].setBackground(Constants.TURNHIGHLIGHT);
               if (board.isKingInCheck(turnColor, g)) {
                 board.kingsButton[turnCount % 2].setBackground(Constants.CHECKHIGHLIGHT);
               }
               board.pinnedPieces(turnColor);
               board.reducePath(turnColor, g);
               //board.pinnedPieces(turnColor);
                      }
                    }
               else
               board.takeMePath(turnColor, g);
               board.checkMate(turnColor, g);
               turnLabel.setText(((turnCount % 2 == 0) ? "White's" : "Black's") + " turn to move!");
               turnCountLabel.setText("Turns passed: " + turnCount);
               g.setTime(Constants.TIME);
               g.setDelay(g.getTime() * 1000);
                    }
                    previouslySelected = null;
                  }
                    else {
                      // Fixes a glitch where piece can move when it is deselected
                      previouslySelected = null;
                    }
                }
                 }
               }
               }
               /*for (Piece p : board.pieces[1]) {
            	   System.out.println("Black piece: " + p.getName() + p.getPath().size());
               }*/
 }
  };
  b.addActionListener(listener);
 }
     }
  }
 public void setTime() throws InterruptedException {
   this.minutes = time / 60;
   this.seconds = time % 60;
   if (this.getTimeEnabled()) {
   if (minutes < 10 || seconds < 10) {
     if (minutes < 10 && seconds < 10) {
       label.setText("0" + minutes + ":0" + seconds);
     }
     else {
       if (minutes < 10)
         label.setText("0" + minutes + ":" + seconds);
       if (seconds < 10)
         label.setText(minutes + ":0" + seconds);
     }
   }
   else {
 label.setText(minutes + ":" + seconds);
   }
   }
   // Now you can't cheat by running the clock for the AI!!
   if (this.time == 0 && this.getTimeEnabled() && turnCount % 2 != aiColor)  {
   if (!this.getGameEnded()) {
   JOptionPane.showMessageDialog(null, "You ran out of time!  " + ((turnCount % 2 == 1) ? "White" : "Black")  + " wins!", "Time up!", JOptionPane.ERROR_MESSAGE, Constants.images[turnCount % 2][rand.nextInt(Constants.images[turnCount % 2].length)]);
     for (TileButton[] tils : this.board.tiles) {
       for (TileButton t : tils) {
         t.setBackground(t.getTile().getColor());
       }
     }
     if (!Constants.takeMeChess)
     this.board.kingsButton[this.turnCount % 2].setBackground(Constants.TURNHIGHLIGHT);
   for (int i = 0; i < 2; i++) {
     for (Piece p : this.board.pieces[i]) {
       p.getPath().clear();
       p.getPath().add(this.board.tiles[p.getPosition().getY()][p.getPosition().getX()]);
     }
   }
   this.setGameEnded(true);
   //Gamewindow.timer.stop();
 }
   }
   if (delay > 0) {
   this.time -= 1;
   this.delay -= 1000;
   }
 }
  public int getTurnCount() {
   return this.turnCount;
 }
  public Color getTurnColor() {
    return this.turnColor;
  }
  public Board getBoard() {
    return this.board;
  }
  public void setEnPass(Piece p) {
    this.enPassant = p;
  }
  public Piece getEnPass() {
    return this.enPassant;
  }
  public int getMaxTurns() {
    return this.maxTurns;
  }
  public void setMaxTurns(int val) {
    this.maxTurns = val;
  }
  public int getMaxSeconds() {
    return this.maxSeconds;
  }
  public void setMaxSeconds(int val) {
    this.maxSeconds = val;
  }
  public boolean getcurrKingCheck() {
    return this.currKingCheck;
  }
  public void setcurrKingCheck(boolean val) {
    this.currKingCheck = val;
  }
  public boolean getCastling() {
    return this.castleProcessing;
  }
  public int getTime() {
    return this.time;
  }
  public void setTime(int val) {
    this.time = val;
  }
  public long getDelay() {
    return this.delay;
  }
  public void setDelay(long val) {
    this.delay = val;
  }
  public boolean getGameEnded() {
    return this.gameEnded;
  }
  public void setGameEnded(boolean val) {
    this.gameEnded = val;
  }
  public boolean getTimeEnabled() {
    return this.timeEnabled;
  }
  public void setTimeEnabled(boolean val) {
    this.timeEnabled = val;
  }
  public boolean getTakeMeEnabled() {
    return this.takeMeEnabled;
  }
  public void setTakeMeEnabled(boolean val) {
    this.takeMeEnabled = val;
  }
  public int getSetting() {
	  return this.pieceLook;
  }
  public void setSetting(int val) {
	  this.pieceLook = val;
  }
  public int getAilevel() {
	  return this.ailevel;
  }
  public void setAilevel(int val) {
	  this.ailevel = val;
  }
  public int getAiColor() {
	  return this.aiColor;
  }
  public void setAiColor(int val) {
	  this.aiColor = val;
  }
 public static void main(String[] args) throws InterruptedException {
   //Game g = new Game(null, 0, false, false, false, false, false, null);
   //System.out.println(g.board.tiles.length);
   /*for (int i = 0; i < 8; i++) {
     for (int j = 0; j < 8; j++) {
       //if (g.board.tiles[i][j].getTile()!= null)
   System.out.println(g.board.tiles[i][j].getTile());
     }
   }*/
	 
 }
}