import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;

public class Rook extends Piece{
	static int whitenewId = 2;
	static int blacknewId = 2;
	public Rook(int id, Color color, Position pos, ImageIcon image, String name) {
		setId(id);
		setColor(color);
		setPosition(pos);
		setImage(image);
		setName(name);
	}
	public void setPath(TileButton[][] board, TileButton t) {
		List<TileButton> pLus = new ArrayList<TileButton>();
		Color c = this.getColor();
		int x = t.getTile().getX() / n;
		int y = t.getTile().getY() / n;
		t.setBackground(highlight);
		pLus.add(t);
		while(y > 0) {
			y -= 1;
			TileButton til = board[y][x];
			if (til.getTile().getPiece() != null) {
				Color otherCol = til.getTile().getPiece().getColor();
				if (!c.equals(otherCol)) {
					til.setBackground(highlight);
					pLus.add(til);
					break;
				}
				else {
					break;
				}
			}
			else {
				til.setBackground(highlight);
				pLus.add(til);
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
					pLus.add(til);
					break;
				}
				else {
					break;
				}
			}
			else {
				til.setBackground(highlight);
				pLus.add(til);
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
					pLus.add(til);
					break;
				}
				else {
					break;
				}
			}
			else {
				til.setBackground(highlight);
				pLus.add(til);
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
					pLus.add(til);
					break;
				}
				else {
					break;
				}
			}
			else {
				til.setBackground(highlight);
				pLus.add(til);
			}
		}
		this.path = (ArrayList<TileButton>) pLus;
	}
	public static void main(String[] args) {
		TileButton[][] board = Board.tiles;
		TileButton t = board[7][0];
		int n = Constants.TILESIZE;
		Piece p = t.getTile().getPiece();
		System.out.println(p);
		Rook q = (Rook) p;
		q.setPath(board, t);
		for (TileButton til : p.path)
		System.out.println(til.getTile().getX() / n + ", " + til.getTile().getY() / n);
	}
}
