import java.awt.Color;

import javax.swing.ImageIcon;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;
import java.util.List;
public class Pawn extends Piece{
	TileButton[][] buttons = Board.tiles;
	boolean enPassent_elegible = false;
	public Pawn(int id, Color color, Position pos, ImageIcon image, String name) {
		setId(id);
		setColor(color);
		setPosition(pos);
		setImage(image);
		setName(name);
	}
	public void setPath(TileButton board[][], TileButton t) {
		List<TileButton> finalPath = new ArrayList<TileButton>();
		Color c = this.getColor();
		//Position p = t.toPosition(t.getX(), t.getY());
		int x = t.getTile().getX() / n;
		int y = t.getTile().getY() / n;
		t.setBackground(highlight);
		finalPath.add(t);
		//System.out.println(tiles[0][0].getTile());
		if (c.equals(colors[0])) {
			if (!this.hasMovedYet) {
				//System.out.println(tiles[y - 1][x]);
				List<TileButton> potentialPath = new LinkedList<TileButton>();
				if (y - 1 >= 0) {
					potentialPath.add(board[y - 1][x]);
				}
				if (y - 2 >= 0) {
					potentialPath.add(board[y - 2][x]);
				}
				
				for (TileButton til : potentialPath) {
					if (til.getTile().getPiece() != null) {
						break;
					}
					til.setBackground(highlight);
					finalPath.add(til);
				}
					if (x - 1 >= 0) {
						TileButton tb1 = board[y - 1][x - 1];
						Tile t1 = tb1.getTile();
						if (t1.getPiece() != null) {
							Color color = t1.getPiece().getColor();
							if (!color.equals(c)) {
								tb1.setBackground(highlight);
								finalPath.add(tb1);
							}
						}
					}
					if (x + 1 < 8) {
						TileButton tb2 = board[y - 1][x + 1];
						Tile t2 = tb2.getTile();
						if (t2.getPiece() != null) {
							Color color = t2.getPiece().getColor();
							if (!color.equals(c)) {
								tb2.setBackground(highlight);
								finalPath.add(tb2);
							}
						}
				}
			}
			else {
				if (y - 1 >= 0) {
					TileButton[] potentialPath = {board[y - 1][x]};
					for (TileButton til : potentialPath) {
						if (til.getTile().getPiece() != null) {
							break;
						}
						til.setBackground(highlight);
						finalPath.add(til);
					}
						if (x - 1 >= 0) {
							TileButton tb1 = board[y - 1][x - 1];
							TileButton tb2 = board[y][x - 1];
							Tile t1 = tb1.getTile();
							Tile t2 = tb2.getTile();
							if (t1.getPiece() != null) {
								Color color = t1.getPiece().getColor();
								if (!color.equals(c)) {
									tb1.setBackground(highlight);
									finalPath.add(tb1);
								}
							}
							if (t2.getPiece() != null) {
								Piece curr = board[y][x].getTile().getPiece();
								Piece piece = t2.getPiece();
								if (piece instanceof Pawn) {
								Color color = piece.getColor();
								Pawn piece2 = (Pawn) piece;
								if (piece2.enPassent_elegible && !piece2.getColor().equals(curr.getColor())) {
									tb1.setBackground(special);
									finalPath.add(tb1);
								}
								}
							}
						}
						if (x + 1 < 8) {
							TileButton tb1 = board[y - 1][x + 1];
							TileButton tb2 = board[y][x + 1];
							Tile t1 = tb1.getTile();
							Tile t2 = tb2.getTile();
							if (t1.getPiece() != null) {
								Color color = t1.getPiece().getColor();
								if (!color.equals(c)) {
									tb1.setBackground(highlight);
									finalPath.add(tb1);
								}
							}
							if (t2.getPiece() != null) {
								Piece curr = board[y][x].getTile().getPiece();
								Piece piece = t2.getPiece();
								if (piece instanceof Pawn) {
									Color color = piece.getColor();
									Pawn piece2 = (Pawn) piece;
									if (piece2.enPassent_elegible && !piece2.getColor().equals(curr.getColor())) {
										tb1.setBackground(special);
										Game.extraString = "(En-passent Capture!)";
										finalPath.add(tb1);
									}
								}
							}
					}
			}
			}
		}
		else {
			if (!this.hasMovedYet) {
				List<TileButton> potentialPath = new LinkedList<TileButton>();
				if (y + 1 < 8) {
					potentialPath.add(board[y + 1][x]);
				}
				if (y + 2 < 8) {
					potentialPath.add(board[y + 2][x]);
				}
				
				for (TileButton til : potentialPath) {
					if (til.getTile().getPiece() != null) {
						break;
					}
					til.setBackground(highlight);
					finalPath.add(til);
				}
					if (x - 1 >= 0) {
						TileButton tb1 = board[y + 1][x - 1];
						Tile t1 = tb1.getTile();
						if (t1.getPiece() != null) {
							Color color = t1.getPiece().getColor();
							if (!color.equals(c)) {
								tb1.setBackground(highlight);
								finalPath.add(tb1);
							}
						}
					}
					if (x + 1 < 8) {
						TileButton tb2 = board[y + 1][x + 1];
						Tile t2 = tb2.getTile();
						if (t2.getPiece() != null) {
							Color color = t2.getPiece().getColor();
							if (!color.equals(c)) {
								tb2.setBackground(highlight);
								finalPath.add(tb2);
							}
						}
				}
			}
			else {
				if (y + 1 < 8) {
					TileButton[] potentialPath = {board[y + 1][x]};
					for (TileButton til : potentialPath) {
						if (til.getTile().getPiece() != null) {
							break;
						}
						til.setBackground(highlight);
						finalPath.add(til);
					}
						if (x - 1 >= 0) {
							TileButton tb1 = board[y + 1][x - 1];
							TileButton tb2 = board[y][x - 1];
							Tile t1 = tb1.getTile();
							Tile t2 = tb2.getTile();
							if (t1.getPiece() != null) {
								Color color = t1.getPiece().getColor();
								if (!color.equals(c)) {
									tb1.setBackground(highlight);
									finalPath.add(tb1);
								}
							}
							if (t2.getPiece() != null) {
								Piece curr = board[y][x].getTile().getPiece();
								Piece piece = t2.getPiece();
								if ((Object) piece instanceof Pawn) {
									Pawn piece2 = (Pawn) piece;
									if (piece2.enPassent_elegible && !piece.getColor().equals(curr.getColor())) {
										tb1.setBackground(special);
										finalPath.add(tb1);
									}
								}
							}
						}
						if (x + 1 < 8) {
							TileButton tb1 = board[y + 1][x + 1];
							TileButton tb2 = board[y][x + 1];
							Tile t1 = tb1.getTile();
							Tile t2 = tb2.getTile();
							if (t1.getPiece() != null) {
								Color color = t1.getPiece().getColor();
								if (!color.equals(c)) {
									tb1.setBackground(highlight);
									finalPath.add(tb1);
								}
							}
							if (t2.getPiece() != null) {
								Piece piece = t2.getPiece();
								if ((Object) piece instanceof Pawn) {
									Piece curr = board[y][x].getTile().getPiece();
									Pawn piece2 = (Pawn) piece;
									if (piece2.enPassent_elegible && !piece.getColor().equals(curr.getColor())) {
										tb1.setBackground(special);
										finalPath.add(tb1);
									}
								}
							}
					}
				}
			}
		}
		this.path = (ArrayList<TileButton>) finalPath;
	}
	public static void main(String[] args) {
		TileButton[][] board = Board.tiles;
		TileButton t = board[6][0];
		System.out.println(t.getTile().getPiece());
		Piece p = t.getTile().getPiece();
		//System.out.println(p);
		Pawn q = (Pawn) p;
		q.setPath(board, t);
		for (TileButton til : p.path)
		System.out.println(til.getTile().getX() / Constants.TILESIZE + ", " + 
		(til.getTile().getY()/ Constants.TILESIZE));
		
	}
}
