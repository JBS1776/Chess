import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;

public class Queen extends Piece{
	static int whitenewId = 1;
	static int blacknewId = 1;
	public Queen(int id, Color color, Position pos, ImageIcon image, String name) {
		setId(id);
		setColor(color);
		setPosition(pos);
		setImage(image);
		setName(name);
	}
	public void setPath(TileButton[][] board, TileButton t) {
		List<TileButton> sTar = new ArrayList<TileButton>();
		Color c = this.getColor();
		int x = t.getTile().getX() / n;
		int y = t.getTile().getY() / n;
		t.setBackground(highlight);
		sTar.add(t);
		while(y > 0 && x > 0) {
			y -= 1;
			x -= 1;
			TileButton til = board[y][x];
			if (til.getTile().getPiece() != null) {
				Color otherCol = til.getTile().getPiece().getColor();
				if (!c.equals(otherCol)) {
					til.setBackground(highlight);
					sTar.add(til);
					break;
				}
				else {
					break;
				}
			}
			else {
				til.setBackground(highlight);
				sTar.add(til);
			}
		}
		y = t.getTile().getY() / n;
		x = t.getTile().getX() / n;
		while(x < 7 && y > 0) {
			x += 1;
			y -= 1;
			TileButton til = board[y][x];
			if (til.getTile().getPiece() != null) {
				Color otherCol = til.getTile().getPiece().getColor();
				if (!c.equals(otherCol)) {
					til.setBackground(highlight);
					sTar.add(til);
					break;
				}
				else {
					break;
				}
			}
			else {
				til.setBackground(highlight);
				sTar.add(til);
			}
		}
		x = t.getTile().getX() / n;
		y = t.getTile().getY() / n;
		while(y < 7 && x > 0) {
			y += 1;
			x -= 1;
			TileButton til = board[y][x];
			if (til.getTile().getPiece() != null) {
				Color otherCol = til.getTile().getPiece().getColor();
				if (!c.equals(otherCol)) {
					til.setBackground(highlight);
					sTar.add(til);
					break;
				}
				else {
					break;
				}
			}
			else {
				til.setBackground(highlight);
				sTar.add(til);
			}
		}
		y = t.getTile().getY() / n;
		x = t.getTile().getX() / n;
		while (x < 7 && y < 7) {
			x += 1;
			y += 1;
			TileButton til = board[y][x];
			if (til.getTile().getPiece() != null) {
				Color otherCol = til.getTile().getPiece().getColor();
				if (!c.equals(otherCol)) {
					til.setBackground(highlight);
					sTar.add(til);
					break;
				}
				else {
					break;
				}
			}
			else {
				til.setBackground(highlight);
				sTar.add(til);
			}
		}
		y = t.getTile().getY() / n;
		x = t.getTile().getX() / n;
		while(y > 0) {
			y -= 1;
			TileButton til = board[y][x];
			if (til.getTile().getPiece() != null) {
				Color otherCol = til.getTile().getPiece().getColor();
				if (!c.equals(otherCol)) {
					til.setBackground(highlight);
					sTar.add(til);
					break;
				}
				else {
					break;
				}
			}
			else {
				til.setBackground(highlight);
				sTar.add(til);
			}
		}
		y = t.getTile().getY() / n;
		while(x < 7) {
			x += 1;
			TileButton til = board[y][x];
			if (til.getTile().getPiece() != null) {
				Color otherCol = til.getTile().getPiece().getColor();
				if (!c.equals(otherCol)) {
					til.setBackground(highlight);
					sTar.add(til);
					break;
				}
				else {
					break;
				}
			}
			else {
				til.setBackground(highlight);
				sTar.add(til);
			}
		}
		x = t.getTile().getX() / n;
		while(y < 7) {
			y += 1;
			TileButton til = board[y][x];
			if (til.getTile().getPiece() != null) {
				Color otherCol = til.getTile().getPiece().getColor();
				if (!c.equals(otherCol)) {
					til.setBackground(highlight);
					sTar.add(til);
					break;
				}
				else {
					break;
				}
			}
			else {
				til.setBackground(highlight);
				sTar.add(til);
			}
		}
		y = t.getTile().getY() / n;
		while (x > 0) {
			x -= 1;
			TileButton til = board[y][x];
			if (til.getTile().getPiece() != null) {
				Color otherCol = til.getTile().getPiece().getColor();
				if (!c.equals(otherCol)) {
					til.setBackground(highlight);
					sTar.add(til);
					break;
				}
				else {
					break;
				}
			}
			else {
				til.setBackground(highlight);
				sTar.add(til);
			}
		}
		this.path = (ArrayList<TileButton>) sTar;
	}
	public static void main(String[] args) {
		TileButton[][] board = Board.tiles;
		TileButton t = board[0][3];
		int n = Constants.TILESIZE;
		Piece p = t.getTile().getPiece();
		System.out.println(p);
		Queen q = (Queen) p;
		q.setPath(board, t);
		for (TileButton til : p.path)
		System.out.println(til.getTile().getX() / n + ", " + til.getTile().getY() / n);
	}
}