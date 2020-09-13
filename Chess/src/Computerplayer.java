import java.awt.Color;

public class Computerplayer implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Piece computerpiece;
	private Tile tile;
	// Easy difficulty, does completely random move
	public Computerplayer cpuMoveEasy(Game g, Color c) {
		Piece piece = g.getBoard().getRandomPiece(g, c);
		while (piece.getPath().size() <= 1) {
			piece = g.getBoard().getRandomPiece(g, c);
		}
		int x = piece.getPosition().getX();
		int y = piece.getPosition().getY();
		Tile til = g.getBoard().getTiles()[y][x];
		this.computerpiece = piece;
		this.tile = til;
		return this;
	}
	public Piece getPiece() {
		return this.computerpiece;
	}
	public Tile getTile() {
		return this.tile;
	}
	public static void main(String[] args) {
	}

}
