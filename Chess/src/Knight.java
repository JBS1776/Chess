import java.awt.Color;
import java.util.*;

import javax.swing.ImageIcon;

public class Knight extends Piece{
	static int whitenewId = 2;
	static int blacknewId = 2;
	public Knight(int id, Color color, Position pos, ImageIcon image, String name) {
		setId(id);
		setColor(color);
		setPosition(pos);
		setImage(image);
		setName(name);
	}
	public void setPath(TileButton[][] board, TileButton t) {
		List<TileButton> elShapes = new ArrayList<TileButton>();
		Color c = this.getColor();
		int x = t.getTile().getX() / n;
		int y = t.getTile().getY() / n;
		t.setBackground(highlight);
		elShapes.add(t);
			if (y - 2 >= 0 && x + 1 < 8) {
				TileButton tile = board[y - 2][x + 1];
				if (tile.getTile().getPiece() != null) {
					Color otherCol = tile.getTile().getPiece().getColor();
					if (!c.equals(otherCol)) {
						tile.setBackground(highlight);
						elShapes.add(tile);
					}
				}
				else  {
					tile.setBackground(highlight);
				elShapes.add(tile);
				}
			}
			if (y - 1 >= 0 && x + 2 < 8) {
				TileButton tile = board[y - 1][x + 2];
				if (tile.getTile().getPiece() != null) {
					Color otherCol = tile.getTile().getPiece().getColor();
					if (!c.equals(otherCol)) {
						tile.setBackground(highlight);
						elShapes.add(tile);
					}
				}
				else {
					tile.setBackground(highlight);
				elShapes.add(tile);
				}
			}
			if (y + 1 < 8 && x + 2 < 8) {
				TileButton tile = board[y + 1][x + 2];
				if (tile.getTile().getPiece() != null) {
					Color otherCol = tile.getTile().getPiece().getColor();
					if (!c.equals(otherCol)) {
						tile.setBackground(highlight);
						elShapes.add(tile);
					}
				}
				else {
					tile.setBackground(highlight);
				elShapes.add(tile);
				}
			}
			if (y + 2 < 8 && x + 1 < 8) {
				TileButton tile = board[y + 2][x + 1];
				if (tile.getTile().getPiece() != null) {
					Color otherCol = tile.getTile().getPiece().getColor();
					if (!c.equals(otherCol)) {
						tile.setBackground(highlight);
						elShapes.add(tile);
					}
				}
				else {
					tile.setBackground(highlight);
				elShapes.add(tile);
				}
			}
			if (y + 2 < 8 && x - 1 >= 0) {
				TileButton tile = board[y + 2][x - 1];
				if (tile.getTile().getPiece() != null) {
					Color otherCol = tile.getTile().getPiece().getColor();
					if (!c.equals(otherCol)) {
						tile.setBackground(highlight);
						elShapes.add(tile);
					}
				}
				else {
					tile.setBackground(highlight);
				elShapes.add(tile);
				}
			}
			if (y + 1 < 8 && x - 2 >= 0) {
				TileButton tile = board[y + 1][x - 2];
				if (tile.getTile().getPiece() != null) {
					Color otherCol = tile.getTile().getPiece().getColor();
					if (!c.equals(otherCol)) {
						tile.setBackground(highlight);
						elShapes.add(tile);
					}
				}
				else {
					tile.setBackground(highlight);
				elShapes.add(tile);
				}
			}
			if (y - 1 >= 0 && x - 2 >= 0) {
				TileButton tile = board[y - 1][x - 2];
				if (tile.getTile().getPiece() != null) {
					Color otherCol = tile.getTile().getPiece().getColor();
					if (!c.equals(otherCol)) {
						tile.setBackground(highlight);
						elShapes.add(tile);
					}
				}
				else {
					tile.setBackground(highlight);
				elShapes.add(tile);
				}
			}
			if (y - 2 >= 0 && x - 1 >= 0) {
				TileButton tile = board[y - 2][x - 1];
				if (tile.getTile().getPiece() != null) {
					Color otherCol = tile.getTile().getPiece().getColor();
					if (!c.equals(otherCol)) {
						tile.setBackground(highlight);
						elShapes.add(tile);
					}
				}
				else {
					tile.setBackground(highlight);
				elShapes.add(tile);
				}
			}
			this.path = (ArrayList<TileButton>) elShapes;
	}
	public static void main(String[] args) {
		TileButton[][] board = Board.tiles;
		TileButton t = board[0][1];
		int n = Constants.TILESIZE;
		Piece p = t.getTile().getPiece();
		System.out.println(p);
		Knight q = (Knight) p;
		q.setPath(board, t);
		for (TileButton til : p.path)
		System.out.println(til.getTile().getX() / n + ", " + til.getTile().getY() / n);
	}
}