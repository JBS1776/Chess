import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Game extends JPanel implements java.io.Serializable{
 private static final long serialVersionUID = 1L;
 
 
 Board board;
 Tile previouslySelected;
 Tile takeCyan;
 Piece enPassant;
 ArrayList<Tile> takeRed = new ArrayList<Tile>();
 ArrayList<String> moveList = new ArrayList<String>();
 ArrayList<LinkedList<Piece>> capturedpieces = new ArrayList<LinkedList<Piece>>();
 int turnCount; // different save
 int maxSeconds = Integer.MAX_VALUE;
 Color turnColor = Constants.colors[this.getTurnCount() % 2];
 boolean currKingCheck; // different save
 boolean castleProcessing; // different save
 int time = Constants.TIME; // 15 * 60 = 900
 int minutes;
 int seconds;
 long delay;
 boolean gameEnded; // different save
 boolean timeEnabled; // different save
 boolean takeMeEnabled; // different save
 JTextField label = new JTextField("", JLabel.LEFT);
 JTextField turnLabel = new JTextField("", JLabel.LEFT);
 JTextField turnCountLabel = new JTextField("", JLabel.LEFT);
 int pieceLook;
 int ailevel;
 int aiColor;
 Computerplayer cp;
 public Game(ArrayList<Piece>[] ps, int turnInc, boolean kingCheck, boolean castle, boolean endGame, boolean timeEnable, boolean takeMe, int newTime, Piece enpass, int pieceLook, int ailevel, int aiColor, ArrayList<LinkedList<Piece>> caps, ArrayList<String> movs, Gamewindow gw) throws InterruptedException {
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
 Constants.isEnabled = timeEnabled;
 Constants.takeMeChess = takeMeEnabled;
 this.setTime(newTime);
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
 turnCountLabel.setText("Turns passed: " + turnCount);
 this.turnColor = Constants.colors[turnCount % 2];
 this.previouslySelected = null;
 this.enPassant = enpass;
 this.pieceLook = pieceLook;
 this.ailevel = ailevel;
 this.aiColor = aiColor;
 board = new Board();
 if (ps == null)
 board.fillTiles(Constants.SCREENPOSX, Constants.SCREENPOSY);
 else
   board.fillTiles2(Constants.SCREENPOSX, Constants.SCREENPOSY, ps);
 board.setPieces(this);
 if (!Constants.takeMeChess) {
 board.reducePath(turnColor, this);
 board.pinnedPieces(turnColor);
 board.checkMate(turnColor, this);
 }
 this.setBackground(Constants.BACKGROUNDCOL);
 int n = Constants.TILEWIDTH;
 int m = Constants.TILEHEIGHT;
 this.setGameEnded(false);
 this.setTimeEnabled(timeEnable);
 this.setTakeMeEnabled(takeMe);
 this.pieceLook = pieceLook;
 Game g = this;
 JButton button = new JButton("Moves");
 button.setBounds(1100, 30, 75, 30);
 button.addActionListener(new ActionListener() {
 	@Override
 	public void actionPerformed(ActionEvent e) {
 		JFrame fr = new JFrame("Move list");
 		Object[] moves = g.moveList.toArray();
 		fr.add(new JScrollPane(new JList<Object>(moves)));
 		fr.setSize(500, 500);
 		fr.setVisible(true);
 		fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 		gw.setEnabled(false);
 		fr.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				fr.dispose();
				gw.setEnabled(true);
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
 			
 		});
 	}
 });
 this.add(button);
 for (Tile[] til : board.tiles) {
  for (Tile s : til) {
  add(s);
  s.setIcon(s.getImage());
  Tile b = s;
  add(b);
  b.setBounds(b.getX(), b.getY(), n, m);
  b.setOpaque(true);
  //b.setBorderPainted(false);
  b.setBackground(b.getColor());
  b.setIcon(b.getImage());
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
               if (source instanceof Tile) {
                 // Pauses the game to let player choose a pawn promotion
                 if (Constants.isPromotionEnabled) {
                 JOptionPane.showMessageDialog(null, "Choose a promotion before continuing!", "NO CHEATING!", JOptionPane.ERROR_MESSAGE, Constants.images[turnCount % 2][Constants.rand.nextInt(Constants.images[turnCount % 2].length)]);
               }
                 else {
                Tile b = ((Tile)source);
                if (ailevel > 0 && !g.getGameEnded()) {
                	if (ailevel == 3 || turnCount % 2 == aiColor) {
                	cp = cp.cpuMoveEasy(g, Constants.colors[turnCount % 2]);
                	Piece randPiece = cp.getPiece();
                	previouslySelected = cp.getTile();
                	b = randPiece.getRandTile();
                	}
                }
                Tile tile = b;
                if (tile.getPiece() != null) {
                  if (previouslySelected != null) {
                    previouslySelected.deSelect(previouslySelected.getPiece().getPath(), g);
                    if (!previouslySelected.equals(b)) {
                      if (tile.getPiece() != null && previouslySelected.getPiece().getPath().contains(b)) {
                        board.move(previouslySelected, b, g);
                        board.setPieces(g);
                        if (tile.getPiece() instanceof King && !Constants.takeMeChess) {
                        board.kingsButton[turnCount % 2].setBackground(board.kingsButton[turnCount % 2].getColor());
                        board.kingsButton[turnCount % 2] = b;
                        }
                        if (tile.getPiece() instanceof Pawn) {
                          Position pos = b.getPosition();
                          int y = pos.getY();
                          if (y == 0 || y == 7) {
                            gw.setEnabled(false);
                            Promotion p = new Promotion(tile.getPiece().getColor(), b, g, gw);
                            if (g.getAilevel() > 0)
                            	p.setVisible(turnCount % 2 != aiColor);
                            else
                            	p.setVisible(true);
                   }
                 }
                        if (!Constants.takeMeChess)
                        board.kingsButton[turnCount % 2].setBackground(board.kingsButton[turnCount % 2].getColor());
                        else
                          board.clearPaint(g);
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
                      previouslySelected = null;
                    }
                  }
                  else {
                    if (tile.getPiece().getColor().equals(turnColor)) {
                      b.select(b.getPiece().getPath());
                      previouslySelected = b;
                    }
                  } 
                }
                else {
                  if (previouslySelected != null) {
                    Piece p = previouslySelected.getPiece();
                    previouslySelected.deSelect(p.getPath(), g);
                    if (previouslySelected.getPiece().getPath().contains(b)) {
                    // For Castling
                      Position posPrev = previouslySelected.getPosition();
                      Position pos = b.getPosition();
                      int posDiff = pos.getX() - posPrev.getX();
                      Tile but1 = null;
                      Tile but2 = null;
                      String castlingComplete = "";
                    if (p instanceof King && !p.hasMovedYet) {
                        if (posDiff == 2 || posDiff == -2) {
                          if (posDiff == 2) {
                            but1 = board.tiles[pos.getY()][pos.getX() + 1];
                            but2 = board.tiles[pos.getY()][pos.getX() - 1];
                            board.move(but1, but2, g);
                          }
                          if (posDiff == -2) {
                            but1 = board.tiles[pos.getY()][pos.getX() - 2];
                            but2 = board.tiles[pos.getY()][pos.getX() + 1];
                            board.move(but1, but2, g);
                          }
                          board.setPieces(g);
                          board.kingsButton[turnCount % 2].setBackground(board.kingsButton[turnCount % 2].getColor());
                          board.kingsButton[turnCount % 2] = b;
                          // Pop Rook's move from list
                          g.moveList.remove(g.moveList.size() - 1);
                          castlingComplete = " Castling comptele!";
                        }
                        }
                    board.move(previouslySelected, b, g);
                    g.moveList.set(g.moveList.size() - 1, g.moveList.get(g.moveList.size() - 1) + castlingComplete);
                    board.setPieces(g);
                    if (tile.getPiece() instanceof King) {
                      if (!Constants.takeMeChess) {
                        board.kingsButton[turnCount % 2].setBackground(board.kingsButton[turnCount % 2].getColor());
                        board.kingsButton[turnCount % 2] = b;
                      }
                      else
                        board.clearPaint(g);
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
                          int y = pos.getY();
                          if (y == 0 || y == 7) {
                            gw.setEnabled(false);
                            Promotion prom = new Promotion(tile.getPiece().getColor(), b, g, gw);
                            if (g.getAilevel() > 0)
                            prom.setVisible(turnCount % 2 != aiColor);
                            else
                            	prom.setVisible(true);
                   }
                      }
                      if (!Constants.takeMeChess)
                    board.kingsButton[turnCount % 2].setBackground(board.kingsButton[turnCount % 2].getColor());
                      else
                        board.clearPaint(g);
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
	   JOptionPane.showMessageDialog(null, "You ran out of time!  " + ((turnCount % 2 == 1) ? "White" : "Black")  + " wins!", "Time up!", JOptionPane.ERROR_MESSAGE, Constants.images[turnCount % 2][Constants.rand.nextInt(Constants.images[turnCount % 2].length)]);
	     for (Tile[] tils : this.board.tiles) {
	       for (Tile t : tils) {
	         t.setBackground(t.getColor());
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
 
 }
}