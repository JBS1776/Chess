import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;
import java.util.List;
public abstract class Piece {
	
	private int id;
	private Color color;
	private Position pos;
	private Tile tile;
	private ImageIcon image;
	private String name;
	protected ArrayList<TileButton> path;
	private Board board = new Board();
	private HashMap<Position, TileButton> tiles;
	protected Color highlight = Constants.HIGHLIGHTER;
	protected Color special = Constants.SPECIALMOVECOL;
	protected Color[] colors = Constants.colors;
	protected boolean hasMovedYet;
	protected boolean isPinned = false;
	protected boolean causedCheck = false;
	protected static int n = Constants.TILESIZE;
	public Piece() {
		this.id = id;
		this.color = color;
		this.pos = pos;
		this.image = image;
		this.hasMovedYet = hasMovedYet;
		this.path = path;
		this.tile = tile;
		if (image != null)
		this.name = image.getDescription();
	}
	public Piece(int id, Color color, Position pos, ImageIcon image, String name) {
		this.id = id;
		this.color = color;
		this.pos = pos;
		this.image = image;
		this.hasMovedYet = hasMovedYet;
		this.path = path;
		this.tile = tile;
		if (image != null)
		this.name = image.getDescription();
	}
	public int getId() {
		return this.id;
	}
	public void setIdNum(Piece p, int i) {
		this.id = i;
	}
	public Color getColor() {
		return this.color;
	}
	
	public Position getPos() {
		return this.pos;
	}
	public ImageIcon getImage() {
		return this.image;
	}
	public String getName() {
		return this.name;
	}
	public Tile getTile() {
		/*Tile t = this.tile;
		tiles = this.board.getTilemap();
		for (Position p : this.tiles.keySet()) {
			if (this.tiles.get(p).equals(t)) {
				t = this.tiles.get(p).getTile();
			}
		}*/
		return this.tile;
	}
	public List<TileButton> getPath() {
		return this.path;
	}
	public void setId(int i) {
		this.id = i;
	}
	public void setColor(Color c) {
		this.color = c;
	}
	public void setPosition(Position p) {
		this.pos = p;
	}
	public void setHasMoved() {
		this.hasMovedYet = true;
	}
	public void setImage(ImageIcon i) {
		this.image = i;
	}
	public void setPath(List<TileButton> p) {
		this.path = (ArrayList<TileButton>) p;
	}
	public void setName(String s) {
		this.name = s;
	}
	public String toString() {
		return "" + this.hasMovedYet + ", " + this.id + ", " + this.color + ", " + this.pos + ", " + this.name;
	}
	public static void main(String[] args) {
		Board board = new Board();
		//System.out.println(tiles.get(p).getPiece().pawnPath());

	}

}
