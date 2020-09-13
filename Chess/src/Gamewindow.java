import java.awt.Color;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
public class Gamewindow extends JFrame implements Runnable, java.io.Serializable {
  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;
  private Game game;
  private static Timer timer = null;
  private ButtonGroup group = new ButtonGroup();
  public Gamewindow(ArrayList<Piece>[] start, int turns, boolean kingCheck, boolean castle, boolean endGame, boolean timeEnd, boolean takeMe, int time, int pieceLook, int ailevel, int aiColor, ArrayList<LinkedList<Piece>> caps, ArrayList<String> moves, Piece enPass) {
    try {
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              try {
              game.setTime();
              }
              catch (InterruptedException ex) {
            	  ex.printStackTrace();
              }
        }
          });
    game = new Game(start, turns, kingCheck, castle, endGame, timeEnd, takeMe, time, enPass, pieceLook, ailevel, aiColor, caps, moves, this);
    this.initializeMenu(game);
    this.add(game);
    this.setVisible(true);
    this.setSize(new Dimension(Constants.FULLSCREENWIDTH, Constants.FULLSCREENHEIGHT));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    timer.start();
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
 private void initializeMenu(Game g) {
 Gamewindow window = this;
 JMenuBar menu = new JMenuBar();
 JMenu menu1 = new JMenu("File");
 JMenu menu2 = new JMenu("Settings");
 JMenu menu4 = new JMenu("Graveyard");
 JMenuItem save = new JMenuItem("save: It's always good to save");
 JMenuItem open = new JMenuItem("open: Load a saved game");
 JMenuItem reset = new JMenuItem("surrender ONLY LOSERS SURRENDER!!");
 JMenuItem appearance = new JMenuItem("Change background color");
 JMenu piecechange = new JMenu("Change piece style");
 piecechange.setMnemonic(KeyEvent.VK_D); //VK_O
 JMenuItem setTime = new JMenuItem("Change rules");
 JRadioButtonMenuItem initial = new JRadioButtonMenuItem("Default");
 initial.addActionListener(new ActionListener() {
	 @Override
	 public void actionPerformed(ActionEvent e) {
		 g.setSetting(0);
		 setImages(g);
	 }
 });
 initial.setMnemonic(KeyEvent.VK_D);
 piecechange.add(initial);
 group.add(initial);
 JRadioButtonMenuItem classic = new JRadioButtonMenuItem("Classic");
 classic.addActionListener(new ActionListener() {
	 @Override
	 public void actionPerformed(ActionEvent e) {
		 g.setSetting(1);
		 setImages(g);
	 }
 });
 classic.setMnemonic(KeyEvent.VK_D);
 piecechange.add(classic);
 group.add(classic);
 JRadioButtonMenuItem mario = new JRadioButtonMenuItem("Mario");
 mario.addActionListener(new ActionListener() {
	 @Override
	 public void actionPerformed(ActionEvent e) {
		 g.setSetting(2);
		 setImages(g);
	 }
 });
 mario.setMnemonic(KeyEvent.VK_D);
 piecechange.add(mario);
 group.add(mario);
 this.setSelectedButton(g);
 menu1.add(open);
 menu1.add(save);
 menu1.add(reset);
 menu2.add(appearance);
 menu2.add(piecechange);
 menu2.add(setTime);
 menu.add(menu1);
 menu.add(menu2);
 setTime.addActionListener(new ActionListener() {
  @Override
  public void actionPerformed(ActionEvent e) {
	  SwingUtilities.invokeLater(new Options(window, g));
  }
  });
 appearance.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
     Color color= JColorChooser.showDialog(game,"Select a color",game.getBackground());
     if (color == null)
    	 game.setBackground(game.getBackground());
     else
     game.setBackground(color);
     boolean lightness = Constants.isColorBright(game.getBackground());
     if (lightness)
    	 game.setForeground(Constants.colors[1]);
     else
    	 game.setForeground(Constants.colors[0]);
   }
 });
 reset.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
     g.setTimeEnabled(!g.getTimeEnabled() ? true : false);
     newGame(game);
   }
 });
 save.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
	 JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
	 fc.showSaveDialog(null);
     File fil = fc.getSelectedFile();
     // Border gets re-enabled here for some reason requiring the borders to be set to null again
     try {
     Game g = window.getG();
     FileOutputStream file = new FileOutputStream(fil);
     ObjectOutputStream obj = new ObjectOutputStream(file);
     obj.writeObject(g);
     obj.close();
     file.close();
     g.getLabel().setBorder(null);
     g.getTurnLabel().setBorder(null);
     g.getTurnCountLabel().setBorder(null);
   }
     catch (FileNotFoundException ex) {
         g.getLabel().setBorder(null);
         g.getTurnLabel().setBorder(null);
         g.getTurnCountLabel().setBorder(null);
         ex.printStackTrace();
    	 JOptionPane.showMessageDialog(null, "File Not found!", "File not found!", JOptionPane.ERROR_MESSAGE, Constants.images[g.getTurnCount() % 2][Constants.rand.nextInt(Constants.images[g.getTurnCount() % 2].length)]);
     }
     catch (IOException ex) {
         g.getLabel().setBorder(null);
         g.getTurnLabel().setBorder(null);
         g.getTurnCountLabel().setBorder(null);
         ex.printStackTrace();
    	 JOptionPane.showMessageDialog(null, "This save file is not valid", "Choose another save file!", JOptionPane.ERROR_MESSAGE, Constants.images[g.getTurnCount() % 2][Constants.rand.nextInt(Constants.images[g.getTurnCount() % 2].length)]);
	}
     catch (NullPointerException ex) {
    	 // Occurs when user hits cancel
         g.getLabel().setBorder(null);
         g.getTurnLabel().setBorder(null);
         g.getTurnCountLabel().setBorder(null);
    	 ex.printStackTrace();
   }
   }
 });
 open.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
	 JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
	 fc.showOpenDialog(null);
	 File fil = fc.getSelectedFile();
	// Prevents null pointer exception when hitting cancel
     try {
     FileInputStream file = new FileInputStream(fil);
     ObjectInputStream obj = new ObjectInputStream(file);
     Game g = (Game) obj.readObject();
     obj.close();
     file.close();
     if (!g.getGameEnded())
     newSavedGame(g);
     else {
       JOptionPane.showMessageDialog(null, "This game has already ended!", "Choose another save file!", JOptionPane.ERROR_MESSAGE, Constants.images[g.getTurnCount() % 2][Constants.rand.nextInt(Constants.images[g.getTurnCount() % 2].length)]);
     }
     }
     catch (FileNotFoundException ex) {
    	 ex.printStackTrace();
    	 JOptionPane.showMessageDialog(null, "File Not found!", "File not found!", JOptionPane.ERROR_MESSAGE, Constants.images[g.getTurnCount() % 2][Constants.rand.nextInt(Constants.images[g.getTurnCount() % 2].length)]);
     }
     catch (IOException ex) {
    	 ex.printStackTrace();
    	 JOptionPane.showMessageDialog(null, "This save file is not valid", "Choose another save file!", JOptionPane.ERROR_MESSAGE, Constants.images[g.getTurnCount() % 2][Constants.rand.nextInt(Constants.images[g.getTurnCount() % 2].length)]);
	} catch (ClassNotFoundException ex) {
		ex.printStackTrace();
		JOptionPane.showMessageDialog(null, "There was a problem opening this save file.  Please open another one.", "Error opening file!", JOptionPane.ERROR_MESSAGE, Constants.images[g.getTurnCount() % 2][Constants.rand.nextInt(Constants.images[g.getTurnCount() % 2].length)]);
	}
     catch (ClassCastException ex) {
    	 ex.printStackTrace();
    	 JOptionPane.showMessageDialog(null, "There was a problem opening this save file.  Please open another one.", "Error opening file!", JOptionPane.ERROR_MESSAGE, Constants.images[g.getTurnCount() % 2][Constants.rand.nextInt(Constants.images[g.getTurnCount() % 2].length)]);
     }
     catch (NullPointerException ex) {
    	 // Occurs when the user hits cancel
    	 ex.printStackTrace();
     }
   }
 });
 menu4.addMouseListener(new MouseAdapter() {
	 @Override
	 public void mouseClicked(MouseEvent e) {
		 SwingUtilities.invokeLater(new Graveyard(g.getCapturedPieces(), window));
	 }
 });
 menu.add(menu4);
  this.setJMenuBar(menu);
  }
 private void newSavedGame(Game g) {
	 g.setTime(g.getTime());
   dispose();
     try {
   //System.setProperty("apple.laf.useScreenMenuBar", "true");
   //System.setProperty("com.apple.mrj.application.apple.menu.about.name", "WikiTeX");
   UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      //UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
  } catch (Exception ex) {
      System.err.println("Cannot set LookAndFeel");
  }
  setImages(g);
  SwingUtilities.invokeLater(new Gamewindow(g.getBoard().getPieces(), g.getTurnCount(), g.getcurrKingCheck(), g.getCastling(), g.getGameEnded(), g.getTimeEnabled(), g.getTakeMeEnabled(), g.getTime(), g.getSetting(), g.getAilevel(), g.getAiColor(), g.getCapturedPieces(), g.getMoveList(), g.getEnPass()));
 }
 void newGame(Game g) {
   g.setTime(Constants.TIME);
   // Above line fixes a glitch where the timer won't reset itself after hitting apply for settings, better alternative than timer.stop()
   dispose();
     try {
   //System.setProperty("apple.laf.useScreenMenuBar", "true");
   //System.setProperty("com.apple.mrj.application.apple.menu.about.name", "WikiTeX");
   UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      //UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
  } catch (Exception ex) {
      System.err.println("Cannot set LookAndFeel");
  }
  setImages(g);
  SwingUtilities.invokeLater(new Gamewindow(Constants.STARTCONFIG, Constants.STARTTURNCOUNT, 
		  Constants.isKingInCheck, Constants.startCastle, 
		  Constants.isEndGame, g.getTimeEnabled(), 
		  g.getTakeMeEnabled(), Constants.TIME, 
		  g.getSetting(), g.getAilevel(), 
		  g.getAiColor(), Constants.CAPTUREDPIECES, 
		  Constants.MOVELIST, Constants.ENPASS));
 }
 private void setImages(Game g) {
	 for (int i = 0; i < 2; i++) {
		 for (Piece p : g.getBoard().getPieces()[i]) {
			 int val = 0;
			 Color c = p.getColor();
			 if (p instanceof Pawn) {
				 val = 5;
			 }
			 if (p instanceof Rook) {
				 val = 0;
			 }
			 if (p instanceof Knight) {
				 val = 1;
			 }
			 if (p instanceof Bishop) {
				 val = 2;
			 }
			 if (p instanceof Queen) {
				 val = 3;
			 }
			 if (p instanceof King) {
				 val = 4;
			 }
			 ImageIcon set = new ImageIcon(Constants.names[g.getSetting()][c.equals(Color.black) ? val : val + 6], p.getName());
			 p.setImage(set);
		 }
	 }
	 for (Tile[] tils : g.getBoard().getTiles()) {
		 for (Tile tb : tils) {
			 if (tb.getPiece() != null) {
				 tb.setImage(tb.getPiece().getImage());
				 tb.setIcon(tb.getImage());
			 }
			 if (g.getSetting() == 1) {
				 if (tb.getColor().equals(Color.BLACK)) {
					 if (!tb.equals(g.getBoard().getKingButton()[g.getTurnCount() % 2])) {
					 tb.setBackground(Constants.GRAY);
					 tb.setColor(tb.getBackground());
					 }
					 else {
						 tb.setColor(Constants.GRAY);
					 }
				 }
			 }
			 else {
				 if (tb.getColor().equals(Constants.GRAY)) {
					 if (!tb.equals(g.getBoard().getKingButton()[g.getTurnCount() % 2])) {
					 tb.setBackground(Color.BLACK);
					 tb.setColor(tb.getBackground());
					 }
					 else {
						 tb.setColor(Color.BLACK);
					 }
				 }
			 }
		 }
	 }
	 this.setSelectedButton(this.game);
 }
private void setSelectedButton(Game g) {
	 int index = 0;
	 this.group.clearSelection();
	 Enumeration<AbstractButton> buttons = this.group.getElements();
	 while (buttons.hasMoreElements()) {
		 AbstractButton but = buttons.nextElement();
		 if (index == g.getSetting()) {
			 group.setSelected(but.getModel(), true);
		 }
		 index++;
	 }
 }
 public Game getG() {
   return this.game;
 }
  public static void main(String[] args) {
    try {
   //System.setProperty("apple.laf.useScreenMenuBar", "true");
   //System.setProperty("com.apple.mrj.application.apple.menu.about.name", "WikiTeX");
   UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
   //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      //UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
  } catch (Exception ex) {
      System.err.println("Cannot set LookAndFeel");
  }
  SwingUtilities.invokeLater(new Gamewindow(Constants.STARTCONFIG, Constants.STARTTURNCOUNT, Constants.isKingInCheck, 
		  Constants.startCastle, Constants.isEndGame, 
		  Constants.isTimeEnabled, Constants.takeMeChess, 
		  Constants.TIME, Constants.PieceAppearance, 
		  Constants.aiLevel, Constants.aiColor, Constants.CAPTUREDPIECES, 
		  Constants.MOVELIST, Constants.ENPASS));
  }
  @Override
  public void run() {

  }
}
