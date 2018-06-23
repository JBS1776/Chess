import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;

public class King extends Piece{
	
	boolean inCheck = false;
	Color check = Constants.CHECKHIGHLIGHT;
	public King(int id, Color color, Position pos, ImageIcon image, String name) {
		setId(id);
		setColor(color);
		setPosition(pos);
		setImage(image);
		setName(name);
	}
	public void setPath(TileButton[][] board, TileButton t) {
		List<TileButton> sQuare = new ArrayList<TileButton>();
		Color c = this.getColor();
		int x = t.getTile().getX() / n;
		int y = t.getTile().getY() / n;
		t.setBackground(highlight);
		sQuare.add(t);
		if (x - 1 >= 0 && y - 1 >= 0) {
			TileButton til = board[y - 1][x - 1];
			if (til.getTile().getPiece() != null) {
				Color colOther = til.getTile().getPiece().getColor();
				if (!c.equals(colOther)) {
					til.setBackground(highlight);
					sQuare.add(til);
				}
			}
			else {
				til.setBackground(highlight);
				sQuare.add(til);
			}
		}
		if (y - 1 >= 0) {
			TileButton til = board[y - 1][x];
			if (til.getTile().getPiece() != null) {
				Color colOther = til.getTile().getPiece().getColor();
				if (!c.equals(colOther)) {
					til.setBackground(highlight);
					sQuare.add(til);
				}
			}
			else {
				til.setBackground(highlight);
				sQuare.add(til);
			}
		}
		if (x + 1 < 8 && y - 1 >= 0) {
			TileButton til = board[y - 1][x + 1];
			if (til.getTile().getPiece() != null) {
				Color colOther = til.getTile().getPiece().getColor();
				if (!c.equals(colOther)) {
					til.setBackground(highlight);
					sQuare.add(til);
				}
			}
			else {
				til.setBackground(highlight);
				sQuare.add(til);
			}
		}
		if (x - 1 >= 0) {
			TileButton til = board[y][x - 1];
			if (til.getTile().getPiece() != null) {
				Color colOther = til.getTile().getPiece().getColor();
				if (!c.equals(colOther)) {
					til.setBackground(highlight);
					sQuare.add(til);
				}
			}
			else {
				til.setBackground(highlight);
				sQuare.add(til);
			}
		}
		if (x + 1 < 8) {
			TileButton til = board[y][x + 1];
			if (til.getTile().getPiece() != null) {
				Color colOther = til.getTile().getPiece().getColor();
				if (!c.equals(colOther)) {
					til.setBackground(highlight);
					sQuare.add(til);
				}
			}
			else {
				til.setBackground(highlight);
				sQuare.add(til);
			}
		}
		if (x - 1 >= 0 && y + 1 < 8) {
			TileButton til = board[y + 1][x - 1];
			if (til.getTile().getPiece() != null) {
				Color colOther = til.getTile().getPiece().getColor();
				if (!c.equals(colOther)) {
					til.setBackground(highlight);
					sQuare.add(til);
				}
			}
			else {
				til.setBackground(highlight);
				sQuare.add(til);
			}
		}
		if (y + 1 < 8) {
			TileButton til = board[y + 1][x];
			if (til.getTile().getPiece() != null) {
				Color colOther = til.getTile().getPiece().getColor();
				if (!c.equals(colOther)) {
					til.setBackground(highlight);
					sQuare.add(til);
				}
			}
			else {
				til.setBackground(highlight);
				sQuare.add(til);
			}
		}
		if (x + 1 < 8 && y + 1 < 8) {
			TileButton til = board[y + 1][x + 1];
			if (til.getTile().getPiece() != null) {
				Color colOther = til.getTile().getPiece().getColor();
				if (!c.equals(colOther)) {
					til.setBackground(highlight);
					sQuare.add(til);
				}
			}
			else {
				til.setBackground(highlight);
				sQuare.add(til);
			}
		}
		if (!this.hasMovedYet) {
			if (board[y][x + 1].getTile().getPiece() == null && 
					board[y][x + 2].getTile().getPiece() == null &&
					board[y][x + 3].getTile().getPiece() != null) {
				Piece p = board[y][x + 3].getTile().getPiece();
				if (p.getId() == 2 && !p.hasMovedYet) {
					board[y][x + 2].setBackground(special);
					Game.extraString = "(King-side castling!)";
					sQuare.add(board[y][x + 2]);
				}
			}
			if (board[y][x - 1].getTile().getPiece() == null && 
					board[y][x - 2].getTile().getPiece() == null &&
					board[y][x - 3].getTile().getPiece() == null &&
					board[y][x - 4].getTile().getPiece() != null) {
				Piece p = board[y][x - 4].getTile().getPiece();
				if (p.getId() == 1 && !p.hasMovedYet) {
					board[y][x - 2].setBackground(special);
					Game.extraString = "(Queen-side castling!)";
					sQuare.add(board[y][x - 2]);
				}
			}
				
		}
		this.path = (ArrayList<TileButton>) sQuare;
	}
	public static void main(String[] args) {
		TileButton[][] board = Board.tiles;
		TileButton t = board[0][4];
		int n = Constants.TILESIZE;
		Piece p = t.getTile().getPiece();
		System.out.println(p);
		King q = (King) p;
		q.setPath(board, t);
		for (TileButton til : p.path)
		System.out.println(til.getTile().getX() / n + ", " + til.getTile().getY() / n);
	}
}