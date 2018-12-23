import java.io.*;
import java.util.*;
public class ExampleSave implements java.io.Serializable{
  public ArrayList<Piece>[] savedpieces = new ArrayList[2];
  public int turnCount;
  
  public static ArrayList<Piece>[] test() {
    ExampleSave ex = new ExampleSave();
    Board board = new Board();
    board.fillTiles(Constants.SCREENPOSX, Constants.SCREENPOSY);
    //System.out.println(board.pieces[0].size());
    ex.savedpieces[0] = board.pieces[0];
    ex.savedpieces[1] = board.pieces[1];
    System.out.println(ex.savedpieces[0].size());
    ex.turnCount = 43;
    try {
         FileOutputStream fileOut =
         new FileOutputStream("/Users/jeremysommers/Desktop/example.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(ex);
         out.close();
         fileOut.close();
         System.out.println("Serialized data is saved in /Users/jeremysommers/Desktop/example.ser");
      } catch (IOException i) {
         i.printStackTrace();
      }
      try {
         FileInputStream fileIn = new FileInputStream("/Users/jeremysommers/Desktop/example.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         ex = (ExampleSave) in.readObject();
         in.close();
         fileIn.close();
      } catch (IOException i) {
         i.printStackTrace();
         //return;
      } catch (ClassNotFoundException c) {
         System.out.println("Example class not found");
         c.printStackTrace();
         //return;
      }
      return ex.savedpieces;
  }
  
  public static void main(String[] args) {
    /*ExampleSave ex = new ExampleSave();
    Board board = new Board();
    board.fillTiles(Constants.SCREENPOSX, Constants.SCREENPOSY);
    System.out.println(board.pieces[0].size());
    ex.savedpieces[0] = board.pieces[0];
    ex.savedpieces[1] = board.pieces[1];
    System.out.println(ex.savedpieces[0].size());
    ex.turnCount = 43;
    try {
         FileOutputStream fileOut =
         new FileOutputStream("/Users/jeremysommers/Desktop/example.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(ex);
         out.close();
         fileOut.close();
         System.out.println("Serialized data is saved in /Users/jeremysommers/Desktop/example.ser");
      } catch (IOException i) {
         i.printStackTrace();
      }
      try {
         FileInputStream fileIn = new FileInputStream("/Users/jeremysommers/Desktop/example.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         ex = (ExampleSave) in.readObject();
         in.close();
         fileIn.close();
      } catch (IOException i) {
         i.printStackTrace();
         return;
      } catch (ClassNotFoundException c) {
         System.out.println("Example class not found");
         c.printStackTrace();
         return;
      }
      for (int i = 0; i < 2; i++) {
        for (Piece p : ex.savedpieces[i]) {
      System.out.println(p);
        }
      }
      System.out.println(ex.turnCount);*/
  }
}