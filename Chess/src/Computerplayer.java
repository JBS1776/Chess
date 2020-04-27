import java.awt.Color;
import java.util.*;

public class Computerplayer implements java.io.Serializable{
	private Random rand = new Random();
	private Piece computerpiece;
	private TileButton tile;
	public Computerplayer() {
		
	}
	public void randomMove(Board b) {
		int whichPiece = rand.nextInt(b.pieces[1].size());
		Piece p = b.pieces[1].get(whichPiece);
		Position pos = p.getPosition();
		System.out.println(p);
		System.out.println(p.getPath().size());
		ArrayList<TileButton> tbs = p.getPath();
		TileButton tb = b.tiles[pos.getY()][pos.getX()];
		tbs.remove(tb);
		int whichMove = rand.nextInt(tbs.size());
		System.out.println(pos + "->" + tbs.get(whichMove).getTile().getPosition());
	}
	// Easy difficulty, does completely random move
	public Computerplayer cpuMoveEasy(Game g, Color c) {
		Piece piece = g.getBoard().getRandomPiece(g, c);
		while (piece.path.size() <= 1) {
			piece = g.getBoard().getRandomPiece(g, c);
		}
		int x = piece.getPosition().getX();
		int y = piece.getPosition().getY();
		TileButton til = g.getBoard().tiles[y][x];
		this.computerpiece = piece;
		this.tile = til;
		return this;
	}
	public Piece getPiece() {
		return this.computerpiece;
	}
	public TileButton getTile() {
		return this.tile;
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//ArrayList<Piece>[] pieces = TestBoards.original();
		Computerplayer cp = new Computerplayer();
		Board b = new Board();
		// ArrayList<Piece>[] ps, int turnInc, boolean kingCheck, boolean castle, boolean endGame, boolean timeEnable, boolean takeMe, int newTime, Piece enpass, int pieceLook, Gamewindow gw
		//Game g = new Game(null, 0, false, false, false, false, false, Constants.TIME, null, 0, null);
		b.fillTiles(0, 0);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (b.tiles[i][j].getTile().getPiece() != null)
				System.out.println(b.tiles[i][j].getTile().getPiece());
				//b.tiles[i][j].getTile().getPiece().setPath(g, b.tiles[i][j]);
			}
		}
		System.out.println("Random Piece: ");
		cp.randomMove(b);
	}

}
