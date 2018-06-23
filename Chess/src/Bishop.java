import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;

public class Bishop extends Piece{
	static int whitenewId = 2;
	static int blacknewId = 2;
	public Bishop(int id, Color color, Position pos, ImageIcon image, String name) {
		setId(id);
		setColor(color);
		setPosition(pos);
		setImage(image);
		setName(name);
	}
	public void setPath(TileButton[][] board, TileButton t) {
		List<TileButton> cRoss = new ArrayList<TileButton>();
		Color c = this.getColor();
		int x = t.getTile().getX() / n;
		int y = t.getTile().getY() / n;
		t.setBackground(highlight);
		cRoss.add(t);
		while(y > 0 && x > 0) {
			y -= 1;
			x -= 1;
			TileButton til = board[y][x];
			if (til.getTile().getPiece() != null) {
				Color otherCol = til.getTile().getPiece().getColor();
				if (!c.equals(otherCol)) {
					til.setBackground(highlight);
					cRoss.add(til);
					break;
				}
				else {
					break;
				}
			}
			else {
				til.setBackground(highlight);
				cRoss.add(til);
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
					cRoss.add(til);
					break;
				}
				else {
					break;
				}
			}
			else {
				til.setBackground(highlight);
				cRoss.add(til);
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
					cRoss.add(til);
					break;
				}
				else {
					break;
				}
			}
			else {
				til.setBackground(highlight);
				cRoss.add(til);
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
					cRoss.add(til);
					break;
				}
				else {
					break;
				}
			}
			else {
				til.setBackground(highlight);
				cRoss.add(til);
			}
		}
		this.path = (ArrayList<TileButton>) cRoss;
	}
	public static void main(String[] args) {
		TileButton[][] board = Board.tiles;
		TileButton t = board[0][2];
		int n = Constants.TILESIZE;
		Piece p = t.getTile().getPiece();
		System.out.println(p);
		Bishop q = (Bishop) p;
		q.setPath(board, t);
		for (TileButton til : p.path)
		System.out.println(til.getTile().getX() / n + ", " + til.getTile().getY() / n);
	}
}