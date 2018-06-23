import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;

class TileButton extends JButton {  
    private Tile tile;
    private Board board = new Board();
    private ArrayList<TileButton> pinkTiles;
    public TileButton(Tile tile) {
      this.tile = tile;
    }
      //LinkedHashMap<Position, TileButton> tiles = board.getTilemap();
  	//setLayout(null);
    /*ImageIcon[] whiteimages = Constants.whiteimages;
    ImageIcon[] blackimages = Constants.blackimages;
  	ArrayList<TileButton> pinkTiles = new ArrayList<TileButton>();
  	int n = Constants.TILESIZE;
  	this.setBounds(this.tile.getX(), this.tile.getY(), n, n);
	this.setOpaque(true);
	this.setBackground(this.tile.getColor());
	//Piece p = new Piece(1, Color.BLACK, new Position('A', 1), Constants.blackimages[Constants.blackimages.length - 1], Constants.blackimages[Constants.blackimages.length - 1].getDescription());
	this.tile.setPiece(this.tile.getPiece());
	this.setIcon(this.tile.getImage());
	this.setFocusable(false);
      ActionListener listener = new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            Object source = e.getSource();
	            if (source instanceof TileButton) {
	            	TileButton button = ((TileButton)source);
	            	Tile til = button.tile;
	            	//System.out.println(til.getImage());
	            	if (til.getPiece() != null) {
	            		if (!button.getBackground().equals(Color.PINK)) {
	            			if (pinkTiles.isEmpty()) {
	            				//pinkTiles.add((TileButton)source);
	            				button.setBackground(Color.PINK);
	            				System.out.println("Gamma");
	            			}
	            			else {
	            				Color curr = til.getPiece().getColor();
	            				TileButton pinky = pinkTiles.get(0);
	            				Color pre = pinky.tile.getPiece().getColor();
	            				System.out.println("Bete");
	            				System.out.println(curr);
	            				System.out.println(pre);
	            				if (curr == pre) {
	            					System.out.println("Alpha");
	            				pinky.setBackground(pinky.getTile().getColor());
	            				button.setBackground(Color.PINK);
	            				pinkTiles.set(0, button);
	            				}
	            			}
	            		}
	            	}
	            }
	        }
	    };
	    this.addActionListener(listener);
	}*/
      public Tile getTile() {
    	  return this.tile;
      }/*
      public ArrayList<TileButton> getPinkTiles() {
    	  for (Position p : this.board.getTilemap().keySet()) {
    		  if (this.board.get(p).getColor() == Color.PINK)
    			  pinkTiles.add(this.board.getTilemap().get(p));
    	  }
    	  return pinkTiles;
      }
      
     /* public class Listener implements ActionListener {
    	  ActionListener listener = new ActionListener() {
  	        @Override
  	        public void actionPerformed(ActionEvent e) {
  	            Object source = e.getSource();
  	            if (source instanceof TileButton) {
  	            	System.out.println(((TileButton)source).tile.getImage());
  	            	if (((TileButton)source).tile.getPiece() != null) {
  	            		((TileButton)source).tile.setHasPiece();
  	              if (((TileButton)source).getBackground() != Color.PINK) {
  	            	  if (pinkTiles.isEmpty()) {
  		                	pinkTiles.add((TileButton) source);
  		                	int i = 0;
  		                	for (TileButton t : board.pawnPath(((TileButton)source).tile.getPiece())) {
  		                		Tile til = t.tile;
  		                		Tile oriTile = ((TileButton)source).tile;
  		                		int tulnum = til.toPosition(til.getX(), til.getY()).toNumber();
  		                		int orinum = oriTile.toPosition(oriTile.getX(), oriTile.getY()).toNumber();
  		                		if (tulnum != orinum) {
  		                		pinkTiles.add(t);
  		                		//System.out.println(t.tile.hasPiece);
  		                		}
  		                		i++;
  		                	}
  		                	int lastIndex = pinkTiles.size() - 1;
  		                	if (pinkTiles.get(lastIndex).tile.left() != null) {
  		                		if (pinkTiles.get(lastIndex).tile.left().hasPiece) {
  		                			Color c = pinkTiles.get(lastIndex).tile.left().getPiece().getColor();
  		                			Color d = ((TileButton) source).tile.getPiece().getColor();
  		                			if (!c.equals(d)) {
  		                				Tile t = pinkTiles.get(lastIndex).tile.left();
  		                				pinkTiles.add(board.getTilemap().get(t.toPosition(t.getX(), t.getY())));
  		                			}
  		                		}
  		                	}
  		                		
  		                }
  	            	  else {
  	            		  for (TileButton t : pinkTiles) {
  	            		  TileButton b = t;
  	            		  Color col = b.tile.getColor();
  	            		  b.setBackground(col);
  	            		  }
  	            	  }
  	            	  Color colPinkTile = pinkTiles.get(0).tile.getPiece().getColor();
  	            	  Color clickedTile = ((TileButton)source).tile.getPiece().getColor();
  	            	  Tile tile = ((TileButton)source).tile;
  	            	  TileButton button = ((TileButton)source);
  	            	  if (!colPinkTile.equals(clickedTile)) {
  	            		  tile.setPiece(null);
  	            		  tile.setImage(null);
  	            		  button.setIcon(null);
  	            		  button.setFocusable(false);
  	            		  //tile.setHasPiece();
  	            		  Piece piece = pinkTiles.get(0).tile.getPiece();
  	            		  ImageIcon image = pinkTiles.get(0).tile.getImage();
  	            		  tile.setPiece(piece);
  	            		  tile.setImage(image);
  	            		  button.setIcon(image);
  	            		  //pinkTiles.get(0).getTile().setHasPiece();
  	            		  Piece oripiece = tile.getPiece();
  	            		  Position pos = tile.toPosition(tile.getX(), tile.getY());
  	            		  oripiece.setPosition(pos);
  	            		  button.setFocusable(false);
  	            		  Tile oritile = pinkTiles.get(0).tile;
  	            		  oritile.setPiece(null);
  	            		  oritile.setImage(null);
  	            		  TileButton b = pinkTiles.get(0);
  	            		  b.setIcon(null);
  	            		  b.setFocusable(false);
  	            		  //oritile.setHasPiece();
  	            		  pinkTiles.clear();
  		            	}
  	            	  else {
  	            	  ((TileButton)source).setBackground(Color.PINK);
  		                pinkTiles.set(0, (TileButton) source);
  		                //System.out.println("PP");
  	            	  }
  	                //System.out.println(((TileButton)source).getTile().getPiece());
  	              }
  	              else {
  	            	TileButton b = pinkTiles.get(0);
            		Color color = b.tile.getColor();
            		b.setBackground(color);
  	            	//System.out.println(((TileButton)source).getTile().getPiece());
  	            	pinkTiles.clear();
  	              }
  	              if (((TileButton)source).getTile().getPiece().getName().equals("WhitePawn")) {
  	            	  //System.out.println("PP");
  	            		int ex = ((TileButton)source).tile.getX();
  	            		int why = ((TileButton)source).tile.getY();
  	            		Position p = ((TileButton)source).tile.toPosition(ex, why);
  	            		if (p.getY() == 1) {
  	            			((TileButton)source).tile.setPiece(null);
  		            		  ((TileButton)source).tile.setImage(null);
  		            		  ((TileButton)source).setIcon(null);
  		            		  ((TileButton)source).setFocusable(false);
  		            		  ((TileButton)source).tile.setHasPiece();
  		            		  Piece queen = new Piece(2, Color.WHITE, p, whiteimages[3], whiteimages[3].getDescription());
  		            		  ((TileButton)source).tile.setPiece(queen);
  		            		  ((TileButton)source).tile.setImage(queen.getImage());
  		            		  ((TileButton)source).setIcon(queen.getImage());
  		            		  ((TileButton)source).tile.setHasPiece();
  	            		}
  	            	}
  	            	if (((TileButton)source).tile.getPiece().getName().equals("BlackPawn")) {
  	            		int ex = ((TileButton)source).tile.getX();
  	            		int why = ((TileButton)source).tile.getY();
  	            		Position p = ((TileButton)source).tile.toPosition(ex, why);
  	            		if (p.getY() == 8) {
  	            			((TileButton)source).tile.setPiece(null);
  		            		  ((TileButton)source).tile.setImage(null);
  		            		  ((TileButton)source).setIcon(null);
  		            		  ((TileButton)source).setFocusable(false);
  		            		  ((TileButton)source).tile.setHasPiece();
  		            		  Piece queen = new Piece(2, Color.BLACK, p, blackimages[3], blackimages[3].getDescription());
  		            		  ((TileButton)source).tile.setPiece(queen);
  		            		  ((TileButton)source).tile.setImage(queen.getImage());
  		            		  ((TileButton)source).setIcon(queen.getImage());
  		            		  ((TileButton)source).tile.setHasPiece();
  	            		}
  	            	}
  	            }
  	            	else {
  	            		((TileButton)source).tile.setHasPiece();
  	            		if (!pinkTiles.isEmpty()) {
  	            			TileButton b = pinkTiles.get(0);
  	            			Color color = b.tile.getColor();
  	            			b.setBackground(color);
  	            			b.tile.getPiece().hasMovedYet = true;
  		            	((TileButton)source).setIcon(pinkTiles.get(0).tile.getPiece().getImage());
  		            	((TileButton)source).getTile().setPiece(pinkTiles.get(0).tile.getPiece());
  		            	((TileButton)source).getTile().setImage(pinkTiles.get(0).tile.getPiece().getImage());
  		            	((TileButton)source).setFocusable(false);

  		            	((TileButton)source).tile.getPiece().setPosition(((TileButton)source).tile.
  		            			toPosition(((TileButton)source).tile.getX(), ((TileButton)source).tile.getY()));
  		            	pinkTiles.get(0).tile.setPiece(null);
  		            	pinkTiles.get(0).tile.setImage(null);
  		            	pinkTiles.get(0).setIcon(null);
  		            	pinkTiles.get(0).setFocusable(false);
  		            	//((TileButton)source).getTile().hasPiece = true;
  		            	pinkTiles.clear();
  		            	Game.whiteTurn = !Game.whiteTurn;
  		            	Game.blackTurn = !Game.blackTurn;
  		            	//System.out.println(((TileButton)source).getTile().getPiece());
  	            		}
  		            }
  	            	Tile tile = ((TileButton)source).tile;
  	            	System.out.println(tile);
  	            	//if (tile.getPiece() != null)
  	            	//for (TileButton t : pinkTiles)
  	            	//System.out.println(t.getTile().toPosition(t.getTile().getX(), t.getTile().getY()));
  	            }
  	        }
  	    };
      }*/
      
    }
