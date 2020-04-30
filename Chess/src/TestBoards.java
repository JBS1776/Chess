import java.awt.*;
import java.util.*;
public class TestBoards implements java.io.Serializable{
  public static ArrayList<Piece>[] original() {
    ArrayList<Piece>[] pieces = new ArrayList[2];
    pieces[0] = new ArrayList<Piece>();
    pieces[1] = new ArrayList<Piece>();
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 8; j++) {
        if (i == 0) {
          int identification = 1;
          if (j <= 4)
            identification = 1;
          else
            identification = 2;
          if (j == 0 || j == 7)
              pieces[1].add(new Rook(identification, Constants.colors[1], new Position(j, i), Constants.images[1][j], "blackRook", false));
          if (j == 1 || j == 6)
              pieces[1].add(new Knight(identification, Constants.colors[1], new Position(j, i), Constants.images[1][j], "blackKnight"));
          if (j == 2 || j == 5)
              pieces[1].add(new Bishop(identification, Constants.colors[1], new Position(j, i), Constants.images[1][j], "blackBishop"));
          if (j == 3)
              pieces[1].add(new Queen(identification, Constants.colors[1], new Position(j, i), Constants.images[1][j], "blackQueen"));
          if (j == 4)
              pieces[1].add(new King(identification, Constants.colors[1], new Position(j, i), Constants.images[1][j], "blackKing", false));
          }
        else {
          pieces[1].add(new Pawn(j + 1, Constants.colors[1], new Position(j, i), Constants.images[1][8], "blackPawn", false));
        }
        }
    }
    for (int i = 6; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (i == 6) {
          pieces[0].add(new Pawn(j + 1, Constants.colors[0], new Position(j, i), Constants.images[0][8], "whitePawn", false));
          }
        else {
          int identification = 1;
          if (j <= 4)
            identification = 1;
          else
            identification = 2;
          if (j == 0 || j == 7)
              pieces[0].add(new Rook(identification, Constants.colors[0], new Position(j, i), Constants.images[0][j], "whiteRook", false));
          if (j == 1 || j == 6)
              pieces[0].add(new Knight(identification, Constants.colors[0], new Position(j, i), Constants.images[0][j], "whiteKnight"));
          if (j == 2 || j == 5)
              pieces[0].add(new Bishop(identification, Constants.colors[0], new Position(j, i), Constants.images[0][j], "whiteBishop"));
          if (j == 3)
              pieces[0].add(new Queen(identification, Constants.colors[0], new Position(j, i), Constants.images[0][j], "whiteQueen"));
          if (j == 4)
              pieces[0].add(new King(identification, Constants.colors[0], new Position(j, i), Constants.images[0][j], "whiteKing", false));
        }
        }
      }
    return pieces;
  }
  public static ArrayList<Piece>[] test1() {
 //Board board = new Board();
 ArrayList<Piece>[] pieces = new ArrayList[2];
 ArrayList<Piece> whitePieces = new ArrayList<Piece>();
 Piece whiteKing = new King(1, Color.WHITE, new Position(6, 2), Constants.images[0][4], "King", true);
 Piece blackKing = new King(1, Color.BLACK, new Position(6, 0), Constants.images[1][4], "King", true);
 whitePieces.add(whiteKing);
 whitePieces.add(new Queen(1, Color.WHITE, new Position(4, 1), Constants.images[0][3], "Queen"));
 ArrayList<Piece> blackPieces = new ArrayList<Piece>();
  blackPieces.add(blackKing);
  blackPieces.add(new Bishop(1, Color.BLACK, new Position(1, 1), Constants.images[1][2], "Bishop"));
  pieces[0] = whitePieces;
  pieces[1] = blackPieces;
  return pieces;
  }
  public static ArrayList<Piece>[] test2() {
 ArrayList<Piece>[] pieces = new ArrayList[2];
 ArrayList<Piece> whitePieces = new ArrayList<Piece>();
 Piece whiteKing = new King(1, Color.WHITE, new Position(5, 0), Constants.images[0][4], "whiteKing", true);
 Piece blackKing = new King(1, Color.BLACK, new Position(3, 1), Constants.images[1][4], "blackKing", true);
 whitePieces.add(whiteKing);
 whitePieces.add(new Rook(1, Color.WHITE, new Position(0, 7), Constants.images[0][0], "whiteRook", false));
 whitePieces.add(new Pawn(1, Color.WHITE, new Position(1, 1), Constants.images[0][8], "whitePawn", true));
 whitePieces.add(new Knight(1, Color.WHITE, new Position(1, 7), Constants.images[0][1], "whiteKnight"));
 whitePieces.add(new Pawn(2, Color.WHITE, new Position(3, 6), Constants.images[0][8], "whitePawn", false));
 ArrayList<Piece> blackPieces = new ArrayList<Piece>();
  blackPieces.add(blackKing);
  blackPieces.add(new Pawn(1, Color.BLACK, new Position(2, 4), Constants.images[1][8], "blackPawn", true));
  pieces[0] = whitePieces;
  pieces[1] = blackPieces;
  return pieces;
  }
  public static ArrayList<Piece>[] test3() { // For TakeMe Chess only
    ArrayList<Piece>[] pieces = new ArrayList[2];
    for (int i = 0; i < 2; i++)
      pieces[i] = new ArrayList<Piece>();
    pieces[0].add(new Rook(1, Color.WHITE, new Position(0, 7), Constants.images[0][0], "Rook", false));
    pieces[0].add(new Knight(1, Color.WHITE, new Position(1, 7), Constants.images[0][1], "Knight"));
    pieces[1].add(new King(1, Color.BLACK, new Position(2, 0), Constants.images[1][4], "King", true));
    pieces[0].add(new King(1, Color.WHITE, new Position(5, 0), Constants.images[0][4], "King", true));
    return pieces;
  }
  public static ArrayList<Piece>[] test4() {
	  ArrayList<Piece>[] pieces = new ArrayList[2];
	  for (int i = 0; i < 2; i++)
		  pieces[i] = new ArrayList<Piece>();
	  pieces[1].add(new King(1, Color.BLACK, new Position(4, 0), Constants.images[1][4], "King", false));
	  pieces[1].add(new Queen(1, Color.BLACK, new Position(3, 1), Constants.images[1][3], "Queen"));
	  pieces[0].add(new Bishop(1, Color.WHITE, new Position(1, 3), Constants.images[0][2], "Bishop"));
	  pieces[0].add(new Knight(1, Color.WHITE, new Position(6, 1), Constants.images[0][1], "Knight"));
	  pieces[0].add(new King(1, Color.WHITE, new Position(4, 7), Constants.images[0][4], "King", false));
	  return pieces;
  }
  public static ArrayList<Piece>[] test5() {
	  ArrayList<Piece>[] pieces = new ArrayList[2];
	  for (int i = 0; i < 2; i++)
		  pieces[i] = new ArrayList<Piece>();
	  pieces[1].add(new King(1, Color.BLACK, new Position(4, 0), Constants.images[1][4], "King", false));
	  pieces[1].add(new Queen(1, Color.BLACK, new Position(7, 4), Constants.images[1][3], "Queen"));
	  pieces[0].add(new Bishop(1, Color.WHITE, new Position(5, 6), Constants.images[0][2], "Bishop"));
	  pieces[1].add(new Bishop(1, Color.BLACK, new Position(6, 5), Constants.images[1][2], "Bishop"));
	  pieces[0].add(new King(1, Color.WHITE, new Position(4, 7), Constants.images[0][4], "King", false));
	  return pieces;
  }
  public static ArrayList<Piece>[] test6() {
	  ArrayList<Piece>[] pieces = new ArrayList[2];
	  for (int i = 0; i < 2; i++)
		  pieces[i] = new ArrayList<Piece>();
	  pieces[1].add(new King(1, Color.BLACK, new Position(4, 0), Constants.images[1][4], "King", false));
	  pieces[1].add(new Queen(1, Color.BLACK, new Position(4, 4), Constants.images[1][3], "Queen"));
	  pieces[0].add(new Rook(1, Color.WHITE, new Position(4, 6), Constants.images[0][0], "Rook", false));
	  pieces[1].add(new Bishop(1, Color.BLACK, new Position(4, 5), Constants.images[1][2], "Bishop"));
	  pieces[0].add(new King(1, Color.WHITE, new Position(4, 7), Constants.images[0][4], "King", false));
	  return pieces;
  }
  public static ArrayList<Piece>[] test7() {
	  ArrayList<Piece>[] pieces = new ArrayList[2];
	  for (int i = 0; i < 2; i++)
		  pieces[i] = new ArrayList<Piece>();
	  pieces[1].add(new King(1, Color.BLACK, new Position(4, 0), Constants.images[1][4], "King", false));
	  pieces[1].add(new Knight(1, Color.BLACK, new Position(6, 6), Constants.images[1][1], "Knight"));
	  //pieces[1].add(new Rook(1, Color.BLACK, new Position(5, 6), Constants.blackimages[0], "Rook", true));
	  pieces[1].add(new Rook(1, Color.BLACK, new Position(4, 6), Constants.images[1][0], "Rook", true));
	  //pieces[1].add(new Bishop(1, Color.BLACK, new Position(4, 5), Constants.blackimages[2], "Bishop"));
	  pieces[0].add(new King(1, Color.WHITE, new Position(6, 5), Constants.images[0][4], "King", true));
	  return pieces;
  }
  public static ArrayList<Piece>[] test8() {
	  ArrayList<Piece>[] pieces = new ArrayList[2];
	  for (int i = 0; i < 2; i++)
		  pieces[i] = new ArrayList<Piece>();
	  pieces[1].add(new King(1, Color.BLACK, new Position(4, 0), Constants.images[1][4], "King", false));
	  pieces[1].add(new Queen(1, Color.BLACK, new Position(7, 4), Constants.images[1][3], "Queen"));
	  pieces[0].add(new Bishop(1, Color.WHITE, new Position(4, 7), Constants.images[0][2], "Bishop"));
	  pieces[1].add(new Bishop(1, Color.BLACK, new Position(6, 5), Constants.images[1][2], "Bishop"));
	  pieces[0].add(new King(1, Color.WHITE, new Position(5, 6), Constants.images[0][4], "King", false));
	  return pieces;
  }
  public static ArrayList<Piece>[] test9() {
	  ArrayList<Piece>[] pieces = new ArrayList[2];
	  for (int i = 0; i < 2; i++) {
		  pieces[i] = new ArrayList<Piece>();	  
	}
	  pieces[0].add(new King(1, Color.WHITE, new Position(0, 0), Constants.images[0][4], "King", true));
	  pieces[1].add(new King(1, Color.BLACK, new Position(2, 2), Constants.images[1][4], "King", true));
	  pieces[1].add(new Queen(1, Color.BLACK, new Position(1, 1), Constants.images[1][3], "Queen"));
	  return pieces;
  }
  public static ArrayList<Piece>[] test10() {
	  ArrayList<Piece>[] pieces = new ArrayList[2];
	  for (int i = 0; i < 2; i++) {
		  pieces[i] = new ArrayList<Piece>();	  
	}
	  pieces[0].add(new King(1, Color.WHITE, new Position(0, 0), Constants.images[0][4], "King", true));
	  pieces[1].add(new King(1, Color.BLACK, new Position(1, 2), Constants.images[1][4], "King", true));
	  pieces[1].add(new Queen(1, Color.BLACK, new Position(2, 1), Constants.images[1][3], "Queen"));
	  return pieces;
  }
  public static ArrayList<Piece>[] test11() {
	  ArrayList<Piece>[] pieces = new ArrayList[2];
	  for (int i = 0; i < 2; i++)
		  pieces[i] = new ArrayList<Piece>();
	  pieces[0].add(new King(1, Color.WHITE, new Position(0, 0), Constants.images[0][4], "King", true));
	  pieces[0].add(new Pawn(1, Color.WHITE, new Position(5, 1), Constants.images[0][8], "Pawn", true));
	  pieces[1].add(new Pawn(1, Color.BLACK, new Position(7, 6), Constants.images[1][8], "Pawn", true));
	  return pieces;
  }
  public static ArrayList<Piece>[] test12() {
	  ArrayList<Piece>[] pieces = new ArrayList[2];
	  for (int i = 0; i < 2; i++)
		  pieces[i] = new ArrayList<Piece>();
	  pieces[0].add(new King(1, Color.WHITE, new Position(4, 7), Constants.images[0][4], "King", false));
	  pieces[0].add(new Rook(1, Color.WHITE, new Position(7, 7), Constants.images[0][0], "Rook", false));
	  pieces[1].add(new King(1, Color.BLACK, new Position(4, 0), Constants.images[1][4], "King", false));
	  return pieces;
  }
  public static ArrayList<Piece>[] test13() {
	  ArrayList<Piece>[] pieces = new ArrayList[2];
	  for (int i = 0; i < 2; i++)
		  pieces[i] = new ArrayList<Piece>();
	  pieces[1].add(new Rook(1, Color.BLACK, new Position(0, 0), Constants.images[1][0], "Rook", false));
	  pieces[1].add(new Knight(1, Color.BLACK, new Position(1, 0), Constants.images[1][1], "Knight"));
	  pieces[1].add(new Bishop(1, Color.BLACK, new Position(2, 0), Constants.images[1][2], "Bishop"));
	  pieces[1].add(new Bishop(2, Color.BLACK, new Position(5, 0), Constants.images[1][2], "Bishop"));
	  pieces[1].add(new Queen(1, Color.BLACK, new Position(3, 0), Constants.images[1][3], "Queen"));
	  pieces[1].add(new Rook(2, Color.BLACK, new Position(7, 0), Constants.images[1][0], "Rook", false));
	  pieces[1].add(new Pawn(2, Color.BLACK, new Position(1, 2), Constants.images[1][8], "Pawn", true));
	  pieces[1].add(new Pawn(3, Color.BLACK, new Position(2, 1), Constants.images[1][8], "Pawn", false));
	  pieces[1].add(new King(1, Color.BLACK, new Position(4, 2), Constants.images[1][4], "King", true));
	  pieces[1].add(new Pawn(7, Color.BLACK, new Position(6, 1), Constants.images[1][8], "Pawn", false));
	  pieces[1].add(new Pawn(8, Color.BLACK, new Position(7, 2), Constants.images[1][8], "Pawn", true));
	  pieces[0].add(new Rook(1, Color.WHITE, new Position(0, 7), Constants.images[0][0], "Rook", false));
	  pieces[0].add(new Bishop(1, Color.WHITE, new Position(2, 7), Constants.images[0][2], "Bishop"));
	  pieces[0].add(new Queen(1, Color.WHITE, new Position(3, 7), Constants.images[0][3], "Queen"));
	  pieces[0].add(new Rook(2, Color.WHITE, new Position(5, 7), Constants.images[0][0], "Rook", true));
	  pieces[0].add(new King(1, Color.WHITE, new Position(6, 7), Constants.images[0][4], "King", true));
	  pieces[0].add(new Bishop(2, Color.WHITE, new Position(1, 3), Constants.images[0][2], "Bishop"));
	  pieces[0].add(new Knight(1, Color.WHITE, new Position(3, 5), Constants.images[0][1], "Knight"));
	  pieces[0].add(new Knight(2, Color.WHITE, new Position(5, 5), Constants.images[0][1], "Knight"));
	  for (int i = 0; i < 8; i++) {
		  if (i == 4)
			  pieces[0].add(new Pawn(5, Color.WHITE, new Position(5, 1), Constants.images[0][8], "Pawn", true));
		  else
		  pieces[0].add(new Pawn(i + 1, Color.WHITE, new Position(i, 6), Constants.images[0][8], "Pawn", false));
	  }
	  return pieces;
  }
  // Ran into this test case during computer random play, resulted in checkmate for white King even though move was available.
  // Running test as new game does not cause the issue, perhaps there is an issue with pieceID
  public static ArrayList<Piece>[] test14() {
	  ArrayList<Piece>[] pieces = new ArrayList[2];
	  for (int i = 0; i < 2; i++)
		  pieces[i] = new ArrayList<Piece>();
	  pieces[0].add(new King(1, Color.WHITE, new Position(0, 6), Constants.images[0][4], "WhiteKing", true));
	  pieces[0].add(new Rook(1, Color.WHITE, new Position(2, 1), Constants.images[0][0], "WhiteRook", true));
	  pieces[0].add(new Knight(1, Color.WHITE, new Position(1, 3), Constants.images[0][1], "WhiteKnight"));
	  pieces[0].add(new Knight(2, Color.WHITE, new Position(3, 6), Constants.images[0][1], "WhiteKnight"));
	  pieces[0].add(new Bishop(1, Color.WHITE, new Position(6, 1), Constants.images[0][2], "WhiteBishop"));
	  pieces[0].add(new Queen(1, Color.WHITE, new Position(7, 0), Constants.images[0][3], "WhiteQueen"));
	  pieces[1].add(new King(1, Color.BLACK, new Position(6, 3), Constants.images[1][4], "BlackKing", true));
	  pieces[1].add(new Queen(1, Color.BLACK, new Position(5, 7), Constants.images[1][3], "BlackQueen"));
	  pieces[1].add(new Queen(2, Color.BLACK, new Position(5, 5), Constants.images[1][3], "BlackQueen"));
	  return pieces;
  }
  // Test to ensure AI can perform Castling
  public static ArrayList<Piece>[] test15() {
	  ArrayList<Piece>[] pieces = new ArrayList[2];
	  for (int i = 0; i < 2; i++) {
		  pieces[i] = new ArrayList<Piece>();
	  }
	  pieces[0].add(new King(1, Color.WHITE, new Position(4, 7), Constants.images[0][4], "WhiteKing", false));
	  pieces[0].add(new Rook(2, Color.WHITE, new Position(7, 7), Constants.images[0][0], "WhiteRook", false));
	  pieces[1].add(new King(1, Color.BLACK, new Position(0, 0), Constants.images[1][4], "BlackKing", true));
	  for (int i = 1; i < 6; i++) {
		  for (int j = 0; j < 8; j++) {
			  pieces[1].add(new Pawn(j + 1, Color.BLACK, new Position(j, i), Constants.images[1][8], "BlackPawn", false));
		  }
	  }
	  for (int i = 0; i < 4; i++) {
		  pieces[1].add(new Rook(i + 1, Color.BLACK, new Position(i, 6), Constants.images[1][0], "BlackRook", true));
		  pieces[1].add(new Bishop(i + 1, Color.BLACK, new Position(i, 7), Constants.images[1][2], "BlackBishop"));
	  }
	  //Castling should not work when line below is not commented out
	  //pieces[1].add(new Bishop(5, Color.BLACK, new Position(4, 6), Constants.images[1][2], "BlackBishop"));
	  return pieces;
  }
  }