import java.awt.*;



import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
public class Vision {
	// Assumes piece in the tile is a King
	public static ArrayList<TileButton> pieceVision(TileButton[][] board, TileButton t) {
		int x = t.getTile().getX();
		int y = t.getTile().getY();
		Color col = t.getTile().getPiece().getColor();
		ArrayList<TileButton> vision = new ArrayList<TileButton>();
		Piece piece = t.getTile().getPiece();
		King king = (King) piece;
		int sameColCount = 0;
		int iterationCount = 0;
		t = board[y][x];
		while (y > 0) {
			y--;
			TileButton but = board[y][x];
			Tile til = board[y][x].getTile();
			if (til.getPiece() == null) {
				vision.add(but);
			}
			else {
				Piece p = til.getPiece();
				Piece sameCol = null;
				Color otherCol = p.getColor();
				if (!col.equals(otherCol)) {
					if (sameColCount == 0) {
					if ((Object) p instanceof Rook || (Object) p instanceof Queen) {
						king.inCheck = true;
						p.causedCheck = true;
					}
					break;
				}
					if (sameColCount == 1) {
						if ((Object) p instanceof Rook || (Object) p instanceof Queen) {
							if (!((Object) sameCol instanceof Rook) && 
								!((Object) sameCol instanceof Queen)) {
								sameCol.isPinned = true;
							}
								
						}
					}
				}
				else {
					sameColCount++;
					sameCol = p;
					if (sameColCount == 2) {
						break;
					}
				}
			}
		}
		x = t.getTile().getX();
		y = t.getTile().getY();
		col = t.getTile().getPiece().getColor();
		piece = t.getTile().getPiece();
		king = (King) piece;
		sameColCount = 0;
		t = board[y][x];
		while (y < 7) {
				y++;
				TileButton but = board[y][x];
				Tile til = board[y][x].getTile();
				if (til.getPiece() == null) {
					vision.add(but);
				}
				else {
					Piece p = til.getPiece();
					Piece sameCol = null;
					Color otherCol = p.getColor();
					if (!col.equals(otherCol)) {
						if (sameColCount == 0) {
						if ((Object) p instanceof Rook || (Object) p instanceof Queen) {
							king.inCheck = true;
							p.causedCheck = true;
						}
						break;
					}
						if (sameColCount == 1) {
							if ((Object) p instanceof Rook || (Object) p instanceof Queen) {
								if (!((Object) sameCol instanceof Rook) && 
									!((Object) sameCol instanceof Queen)) {
									sameCol.isPinned = true;
								}
									
							}
						}
					}
					else {
						sameColCount++;
						sameCol = p;
						if (sameColCount == 2) {
							break;
						}
					}
				}
		}
		x = t.getTile().getX();
		y = t.getTile().getY();
		col = t.getTile().getPiece().getColor();
		piece = t.getTile().getPiece();
		king = (King) piece;
		sameColCount = 0;
		t = board[y][x];
		while (x < 7) {
			x++;
			TileButton but = board[y][x];
			Tile til = board[y][x].getTile();
			if (til.getPiece() == null) {
				vision.add(but);
			}
			else {
				Piece p = til.getPiece();
				Piece sameCol = null;
				Color otherCol = p.getColor();
				if (!col.equals(otherCol)) {
					if (sameColCount == 0) {
					if ((Object) p instanceof Rook || (Object) p instanceof Queen) {
						king.inCheck = true;
						p.causedCheck = true;
					}
					break;
				}
					if (sameColCount == 1) {
						if ((Object) p instanceof Rook || (Object) p instanceof Queen) {
							if (!((Object) sameCol instanceof Rook) && 
								!((Object) sameCol instanceof Queen)) {
								sameCol.isPinned = true;
							}
								
						}
					}
				}
				else {
					sameColCount++;
					sameCol = p;
					if (sameColCount == 2) {
						break;
					}
				}
			}
	}
		x = t.getTile().getX();
		y = t.getTile().getY();
		col = t.getTile().getPiece().getColor();
		piece = t.getTile().getPiece();
		king = (King) piece;
		sameColCount = 0;
		t = board[y][x];
		while (x > 0) {
			x--;
			TileButton but = board[y][x];
			Tile til = board[y][x].getTile();
			if (til.getPiece() == null) {
				vision.add(but);
			}
			else {
				Piece p = til.getPiece();
				Piece sameCol = null;
				Color otherCol = p.getColor();
				if (!col.equals(otherCol)) {
					if (sameColCount == 0) {
					if ((Object) p instanceof Rook || (Object) p instanceof Queen) {
						king.inCheck = true;
						p.causedCheck = true;
					}
					break;
				}
					if (sameColCount == 1) {
						if ((Object) p instanceof Rook || (Object) p instanceof Queen) {
							if (!((Object) sameCol instanceof Rook) && 
								!((Object) sameCol instanceof Queen)) {
								sameCol.isPinned = true;
							}
								
						}
					}
				}
				else {
					sameColCount++;
					sameCol = p;
					if (sameColCount == 2) {
						break;
					}
				}
			}
	}
		x = t.getTile().getX();
		y = t.getTile().getY();
		col = t.getTile().getPiece().getColor();
		piece = t.getTile().getPiece();
		king = (King) piece;
		sameColCount = 0;
		t = board[y][x];
		while (x < 7 && y > 0) {
			x++;
			y--;
			TileButton but = board[y][x];
			Tile til = board[y][x].getTile();
			if (til.getPiece() == null) {
				vision.add(but);
			}
			else {
				Piece p = til.getPiece();
				Piece sameCol = null;
				Color otherCol = p.getColor();
				if (!col.equals(otherCol)) {
					if (sameColCount == 0) {
					if ((Object) p instanceof Pawn || (Object) p instanceof Queen ||
							(Object) p instanceof Bishop) {
						if ((Object) p instanceof Queen || (Object) p instanceof Bishop) {
							king.inCheck = true;
							p.causedCheck = true;
						}
						else {
							if (iterationCount == 0) {
						king.inCheck = true;
						p.causedCheck = true;
						}
						}
					}
					break;
				}
					if (sameColCount == 1) {
						if ((Object) p instanceof Queen || (Object) p instanceof Bishop) {
							if (!((Object) sameCol instanceof Queen) && 
								!((Object) sameCol instanceof Bishop) && 
								!((Object)sameCol instanceof Pawn)) {
								sameCol.isPinned = true;
							}
							else {
								if ((Object)sameCol instanceof Pawn) {
									if (x + 1 < 8 && y - 1 > 0) {
									TileButton button = board[y - 1][x + 1];
									if (button.getTile().getPiece() == null) {
										sameCol.isPinned = true;
									}
									}
								}
							}
								
						}
					}
				}
				else {
					sameColCount++;
					sameCol = p;
					if (sameColCount == 2) {
						break;
					}
				}
			}
			iterationCount++;
	}
		x = t.getTile().getX();
		y = t.getTile().getY();
		col = t.getTile().getPiece().getColor();
		piece = t.getTile().getPiece();
		king = (King) piece;
		sameColCount = 0;
		t = board[y][x];
		while (x < 7 && y < 7) {
			x++;
			y++;
			TileButton but = board[y][x];
			Tile til = board[y][x].getTile();
			if (til.getPiece() == null) {
				vision.add(but);
			}
			else {
				Piece p = til.getPiece();
				Piece sameCol = null;
				Color otherCol = p.getColor();
				if (!col.equals(otherCol)) {
					if (sameColCount == 0) {
					if ((Object) p instanceof Pawn || (Object) p instanceof Queen ||
							(Object) p instanceof Bishop) {
						if ((Object) p instanceof Queen || (Object) p instanceof Bishop) {
							king.inCheck = true;
							p.causedCheck = true;
						}
						else {
							if (iterationCount == 0) {
						king.inCheck = true;
						p.causedCheck = true;
						}
						}
					}
					break;
				}
					if (sameColCount == 1) {
						if ((Object) p instanceof Queen || (Object) p instanceof Bishop) {
							if (!((Object) sameCol instanceof Queen) && 
								!((Object) sameCol instanceof Bishop) && 
								!((Object)sameCol instanceof Pawn)) {
								sameCol.isPinned = true;
							}
							else {
								if ((Object)sameCol instanceof Pawn) {
									if (x + 1 < 8 && y + 1 < 8) {
									TileButton button = board[y + 1][x + 1];
									if (button.getTile().getPiece() == null) {
										sameCol.isPinned = true;
									}
									}
								}
							}
								
						}
					}
				}
				else {
					sameColCount++;
					sameCol = p;
					if (sameColCount == 2) {
						break;
					}
				}
			}
			iterationCount++;
	}
		x = t.getTile().getX();
		y = t.getTile().getY();
		col = t.getTile().getPiece().getColor();
		piece = t.getTile().getPiece();
		king = (King) piece;
		sameColCount = 0;
		t = board[y][x];
		while (x > 0 && y < 7) {
			x--;
			y++;
			TileButton but = board[y][x];
			Tile til = board[y][x].getTile();
			if (til.getPiece() == null) {
				vision.add(but);
			}
			else {
				Piece p = til.getPiece();
				Piece sameCol = null;
				Color otherCol = p.getColor();
				if (!col.equals(otherCol)) {
					if (sameColCount == 0) {
					if ((Object) p instanceof Pawn || (Object) p instanceof Queen ||
							(Object) p instanceof Bishop) {
						if ((Object) p instanceof Queen || (Object) p instanceof Bishop) {
							king.inCheck = true;
							p.causedCheck = true;
						}
						else {
							if (iterationCount == 0) {
						king.inCheck = true;
						p.causedCheck = true;
						}
						}
					}
					break;
				}
					if (sameColCount == 1) {
						if ((Object) p instanceof Queen || (Object) p instanceof Bishop) {
							if (!((Object) sameCol instanceof Queen) && 
								!((Object) sameCol instanceof Bishop) && 
								!((Object)sameCol instanceof Pawn)) {
								sameCol.isPinned = true;
							}
							else {
								if ((Object)sameCol instanceof Pawn) {
									if (x - 1 > 0 && y - 1 > 0) {
									TileButton button = board[y - 1][x - 1];
									if (button.getTile().getPiece() == null) {
										sameCol.isPinned = true;
									}
									}
								}
							}
								
						}
					}
				}
				else {
					sameColCount++;
					sameCol = p;
					if (sameColCount == 2) {
						break;
					}
				}
			}
			iterationCount++;
	}
		x = t.getTile().getX();
		y = t.getTile().getY();
		col = t.getTile().getPiece().getColor();
		piece = t.getTile().getPiece();
		king = (King) piece;
		sameColCount = 0;
		t = board[y][x];
		while (x > 0 && y > 0) {
			x--;
			y--;
			TileButton but = board[y][x];
			Tile til = board[y][x].getTile();
			if (til.getPiece() == null) {
				vision.add(but);
			}
			else {
				Piece p = til.getPiece();
				Piece sameCol = null;
				Color otherCol = p.getColor();
				if (!col.equals(otherCol)) {
					if (sameColCount == 0) {
					if ((Object) p instanceof Pawn || (Object) p instanceof Queen ||
							(Object) p instanceof Bishop) {
						if ((Object) p instanceof Queen || (Object) p instanceof Bishop) {
							king.inCheck = true;
							p.causedCheck = true;
						}
						else {
							if (iterationCount == 0) {
						king.inCheck = true;
						p.causedCheck = true;
						}
						}
					}
					break;
				}
					if (sameColCount == 1) {
						if ((Object) p instanceof Queen || (Object) p instanceof Bishop) {
							if (!((Object) sameCol instanceof Queen) && 
								!((Object) sameCol instanceof Bishop) && 
								!((Object)sameCol instanceof Pawn)) {
								sameCol.isPinned = true;
							}
							else {
								if ((Object)sameCol instanceof Pawn) {
									if (x - 1 > 0 && y - 1 > 0) {
									TileButton button = board[y - 1][x - 1];
									if (button.getTile().getPiece() == null) {
										sameCol.isPinned = true;
									}
									}
								}
							}
								
						}
					}
				}
				else {
					sameColCount++;
					sameCol = p;
					if (sameColCount == 2) {
						break;
					}
				}
			}
			iterationCount++;
	}
		
		return vision;
	}

}
