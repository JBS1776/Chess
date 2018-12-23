import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
              pieces[1].add(new Rook(identification, Constants.colors[1], new Position(j, i), Constants.blackimages[j], "blackRook", false));
          if (j == 1 || j == 6)
              pieces[1].add(new Knight(identification, Constants.colors[1], new Position(j, i), Constants.blackimages[j], "blackKnight"));
          if (j == 2 || j == 5)
              pieces[1].add(new Bishop(identification, Constants.colors[1], new Position(j, i), Constants.blackimages[j], "blackBishop"));
          if (j == 3)
              pieces[1].add(new Queen(identification, Constants.colors[1], new Position(j, i), Constants.blackimages[j], "blackQueen"));
          if (j == 4)
              pieces[1].add(new King(identification, Constants.colors[1], new Position(j, i), Constants.blackimages[j], "blackKing", false));
          }
        else {
          pieces[1].add(new Pawn(j + 1, Constants.colors[1], new Position(j, i), Constants.blackimages[8], "blackPawn", false));
        }
        }
    }
    for (int i = 6; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (i == 6) {
          pieces[0].add(new Pawn(j + 1, Constants.colors[0], new Position(j, i), Constants.whiteimages[8], "whitePawn", false));
          }
        else {
          int identification = 1;
          if (j <= 4)
            identification = 1;
          else
            identification = 2;
          if (j == 0 || j == 7)
              pieces[0].add(new Rook(identification, Constants.colors[0], new Position(j, i), Constants.whiteimages[j], "whiteRook", false));
          if (j == 1 || j == 6)
              pieces[0].add(new Knight(identification, Constants.colors[0], new Position(j, i), Constants.whiteimages[j], "whiteKnight"));
          if (j == 2 || j == 5)
              pieces[0].add(new Bishop(identification, Constants.colors[0], new Position(j, i), Constants.whiteimages[j], "whiteBishop"));
          if (j == 3)
              pieces[0].add(new Queen(identification, Constants.colors[0], new Position(j, i), Constants.whiteimages[j], "whiteQueen"));
          if (j == 4)
              pieces[0].add(new King(identification, Constants.colors[0], new Position(j, i), Constants.whiteimages[j], "whiteKing", false));
        }
        }
      }
    return pieces;
  }
  public static ArrayList<Piece>[] test1() {
 //Board board = new Board();
 ArrayList<Piece>[] pieces = new ArrayList[2];
 ArrayList<Piece> whitePieces = new ArrayList<Piece>();
 Piece whiteKing = new King(1, Color.WHITE, new Position(6, 2), Constants.whiteimages[4], "King", true);
 Piece blackKing = new King(1, Color.BLACK, new Position(6, 0), Constants.blackimages[4], "King", true);
 whitePieces.add(whiteKing);
 whitePieces.add(new Queen(1, Color.WHITE, new Position(4, 1), Constants.whiteimages[3], "Queen"));
 ArrayList<Piece> blackPieces = new ArrayList<Piece>();
  blackPieces.add(blackKing);
  blackPieces.add(new Bishop(1, Color.BLACK, new Position(1, 1), Constants.blackimages[2], "Bishop"));
  pieces[0] = whitePieces;
  pieces[1] = blackPieces;
  return pieces;
  }
  public static ArrayList<Piece>[] test2() {
 ArrayList<Piece>[] pieces = new ArrayList[2];
 ArrayList<Piece> whitePieces = new ArrayList<Piece>();
 Piece whiteKing = new King(1, Color.WHITE, new Position(5, 0), Constants.whiteimages[4], "whiteKing", true);
 Piece blackKing = new King(1, Color.BLACK, new Position(3, 1), Constants.blackimages[4], "blackKing", true);
 whitePieces.add(whiteKing);
 whitePieces.add(new Rook(1, Color.WHITE, new Position(0, 7), Constants.whiteimages[0], "whiteRook", false));
 whitePieces.add(new Pawn(1, Color.WHITE, new Position(1, 1), Constants.whiteimages[8], "whitePawn", true));
 whitePieces.add(new Knight(1, Color.WHITE, new Position(1, 7), Constants.whiteimages[1], "whiteKnight"));
 whitePieces.add(new Pawn(2, Color.WHITE, new Position(3, 6), Constants.whiteimages[8], "whitePawn", false));
 ArrayList<Piece> blackPieces = new ArrayList<Piece>();
  blackPieces.add(blackKing);
  blackPieces.add(new Pawn(1, Color.BLACK, new Position(2, 4), Constants.blackimages[8], "blackPawn", true));
  pieces[0] = whitePieces;
  pieces[1] = blackPieces;
  return pieces;
  }
  public static ArrayList<Piece>[] test3() { // For TakeMe Chess only
    ArrayList<Piece>[] pieces = new ArrayList[2];
    for (int i = 0; i < 2; i++)
      pieces[i] = new ArrayList<Piece>();
    pieces[0].add(new Rook(1, Color.WHITE, new Position(0, 7), Constants.whiteimages[0], "Rook", false));
    pieces[0].add(new Knight(1, Color.WHITE, new Position(1, 7), Constants.whiteimages[1], "Knight"));
    pieces[1].add(new King(1, Color.BLACK, new Position(2, 0), Constants.blackimages[4], "King", true));
    return pieces;
  }
}