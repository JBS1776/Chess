import java.awt.*;
import java.awt.List;
//import java.io.FileFilter;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.JFileChooser;
public class Gamewindow extends JFrame implements Runnable, java.io.Serializable {
  //private Gamewindow frame;
  private Game game;
  static Timer timer = null;
  Random rand = new Random();
  ButtonGroup group = new ButtonGroup();
  ButtonGroup aigroup = new ButtonGroup();
  ButtonGroup aicolor = new ButtonGroup();
  JColorChooser colorChooser = new JColorChooser();
  public Gamewindow(ArrayList<Piece>[] start, int turns, boolean kingCheck, boolean castle, boolean endGame, boolean timeEnd, boolean takeMe, int time, int pieceLook, int ailevel, int aiColor, ArrayList<LinkedList<Piece>> caps, ArrayList<String> moves, Piece enPass) {
	//game.setTime(time);
    try {
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              try {
              //game.setTime(time);
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
 public void initializeMenu(Game g) {
 Gamewindow window = this;
 JButton button = new JButton("Moves");
 button.setBounds(1100, 30, 75, 30);
 button.setVisible(true);
 button.addActionListener(new ActionListener() {
 	@Override
 	public void actionPerformed(ActionEvent e) {
 		JFrame fr = new JFrame("Move list");
 		//DefaultListModel listmodel = new DefaultListModel();
 		Object[] moves = g.moveList.toArray();
 		JList lis = new JList(moves);
 		fr.add(new JScrollPane(lis));
 		fr.setSize(500, 500);
 		fr.setVisible(true);
 	}
 });
 this.add(button);
 JMenuBar menu = new JMenuBar();
 JMenu menu1 = new JMenu("File");
 JMenu menu2 = new JMenu("Settings");
 JMenu menu3 = new JMenu("Instructions");
 JMenu menu4 = new JMenu("Graveyard");
 JMenuItem stuff = new JMenuItem("Who reads them these days?");
 JMenuItem save = new JMenuItem("save: It's always good to save");
 JMenuItem open = new JMenuItem("open: Load a saved game");
 JMenuItem reset = new JMenuItem("surrender ONLY LOSERS SURRENDER!!");
 JMenuItem appearance = new JMenuItem("Change background color");
 JMenu AIsettings = new JMenu("Change AI settings");
 JMenu piecechange = new JMenu("Change piece style");
 piecechange.setMnemonic(KeyEvent.VK_D); //VK_O
 JMenuItem setTime = new JMenuItem("Change rules");
 JRadioButtonMenuItem initial = new JRadioButtonMenuItem("Default");
 initial.addActionListener(new ActionListener() {
	 @Override
	 public void actionPerformed(ActionEvent e) {
		 Constants.SETTING = 0;
		 setImages(Constants.SETTING, g);
	 }
 });
 initial.setMnemonic(KeyEvent.VK_D); //VK_I
 piecechange.add(initial);
 group.add(initial);
 JRadioButtonMenuItem classic = new JRadioButtonMenuItem("Classic");
 classic.addActionListener(new ActionListener() {
	 @Override
	 public void actionPerformed(ActionEvent e) {
		 Constants.SETTING = 1;
		 setImages(Constants.SETTING, g);
	 }
 });
 classic.setMnemonic(KeyEvent.VK_D); // VK_D
 piecechange.add(classic);
 group.add(classic);
 JRadioButtonMenuItem mario = new JRadioButtonMenuItem("Mario");
 mario.addActionListener(new ActionListener() {
	 @Override
	 public void actionPerformed(ActionEvent e) {
		 Constants.SETTING = 2;
		 setImages(Constants.SETTING, g);
	 }
 });
 mario.setMnemonic(KeyEvent.VK_D); //VK_D
 //this.setSelectedButton(g);
 piecechange.add(mario);
 group.add(mario);
 /*JRadioButtonMenuItem none = new JRadioButtonMenuItem("None");
 AIsettings.add(none);
 aigroup.add(none);
 JRadioButtonMenuItem easy = new JRadioButtonMenuItem("Easy");
 AIsettings.add(easy);
 aigroup.add(easy);
 JRadioButtonMenuItem medium = new JRadioButtonMenuItem("Medium");
 AIsettings.add(medium);
 aigroup.add(medium);
 JRadioButtonMenuItem hard = new JRadioButtonMenuItem("Hard");
 AIsettings.add(hard);
 aigroup.add(hard);
 JRadioButtonMenuItem whitecomputer = new JRadioButtonMenuItem("Computer is white");
 AIsettings.add(whitecomputer);
 aicolor.add(whitecomputer);
 JRadioButtonMenuItem blackcomputer = new JRadioButtonMenuItem("Computer is black");
 AIsettings.add(blackcomputer);
 aicolor.add(blackcomputer);*/
 this.setSelectedButton(g);
 menu1.add(open);
 menu1.add(save);
 menu1.add(reset);
 menu2.add(appearance);
 menu2.add(piecechange);
 menu2.add(setTime);
 //menu2.add(AIsettings);
 menu3.add(stuff);
 menu.add(menu1);
 menu.add(menu2);
 menu.add(menu3);
 //menu.add(menu4);
 setTime.addActionListener(new ActionListener() {
  @Override
  public void actionPerformed(ActionEvent e) {
    JFrame frame = new JFrame("Frame");
    int multiplyer = 10;
    int index = 0;
    //frame.add(isEnabled);
    frame.setLayout(null);
    frame.setResizable(false);
    JCheckBox enableTime = new JCheckBox("Enable time", Constants.isEnabled);
    enableTime.setBounds(0, 10, 500, 20);
    frame.add(enableTime);
    Constants.isEnabled = enableTime.isSelected();
    boolean oldEnabled = Constants.isEnabled;
    boolean oldTakeMe = Constants.takeMeChess;
    enableTime.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        Constants.isEnabled = enableTime.isSelected();
      }
    });
    JRadioButton[] buttons = new JRadioButton[2];
    buttons[0] = new JRadioButton("Regular Chess");
    buttons[0].setBounds(0, 50, 200, 20);
    frame.add(buttons[0]);
    buttons[0].setSelected(!Constants.takeMeChess);
    buttons[1] = new JRadioButton("Take-me Chess");
    buttons[1].setBounds(0, 70, 200, 20);
    frame.add(buttons[1]);
    buttons[1].setSelected(Constants.takeMeChess);
    for (JRadioButton buts : buttons) {
      buts.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          Object o = e.getSource();
          if (o instanceof JRadioButton) {
            JRadioButton curr = (JRadioButton) o;
            for (int i = 0; i < buttons.length; i++) {
              if (buttons[i].equals(curr)) {
                if (!buttons[i].isSelected()) {
                  buttons[i].setSelected(true);
                  buttons[(i + 1) % 2].setSelected(false);
                }
                else {
                  buttons[(i + 1) % 2].setSelected(false);
                  buttons[i].setSelected(true);
                }
              }
            }
            Constants.takeMeChess = buttons[1].isSelected();
        }
        }
      });
    }
    JRadioButton[] aiButtons = new JRadioButton[4];
    aiButtons[0] = new JRadioButton("No computer");
    aiButtons[0].setBounds(0, 110, 200, 20);
    frame.add(aiButtons[0]);
    aiButtons[1] = new JRadioButton("Easy computer");
    aiButtons[1].setBounds(0, 130, 200, 20);
    frame.add(aiButtons[1]);
    aiButtons[2] = new JRadioButton("Hard computer");
    aiButtons[2].setBounds(0, 150, 200, 20);
    frame.add(aiButtons[2]);
    aiButtons[3] = new JRadioButton("Computer vs Computer");
    aiButtons[3].setBounds(0, 170, 200, 20);
    frame.add(aiButtons[3]);
    aiButtons[Constants.aiLevel].setSelected(true);
    for (JRadioButton but : aiButtons) {
    	but.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			Object o = e.getSource();
    			if (o instanceof JRadioButton) {
    				JRadioButton curr = (JRadioButton) o;
    				for (int i = 0; i < aiButtons.length; i++) {
    					if (aiButtons[i].equals(curr)) {
    						aiButtons[i].setSelected(true);
    						Constants.aiLevel = i;
    						g.setAilevel(Constants.aiLevel);
    					}
    					else
    						aiButtons[i].setSelected(false);
    				}
    			}
    		}
    	});
    }
    JButton aiPlayer = new JButton();
    aiPlayer.setBounds(10, 200, 30, 30);
    aiPlayer.setBackground(Constants.colors[Constants.aiColor]);
    aiPlayer.addActionListener(new ActionListener() {
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		if (aiPlayer.getBackground().equals(Constants.colors[0])) {
    			aiPlayer.setBackground(Constants.colors[1]);
    			Constants.aiColor = 1;
    		}
    		else {
    			aiPlayer.setBackground(Constants.colors[0]);
    			Constants.aiColor = 0;
    		}
    		g.setAiColor(Constants.aiColor);
    	}
    });
    frame.add(aiPlayer);
    JButton cancel = new JButton("Cancel");
    cancel.setBounds(200, 350, 100, 20);
    cancel.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Constants.takeMeChess = oldTakeMe;
        Constants.isEnabled = oldEnabled;
        frame.dispose();
      }
    });
    frame.add(cancel);
    JButton apply = new JButton("Apply");
    frame.add(apply);
    apply.setBounds(350, 350, 100, 20);
    apply.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.dispose();
        game.setTimeEnabled(Constants.isEnabled);
        game.setTakeMeEnabled(Constants.takeMeChess);
        game.setAilevel(Constants.aiLevel);
        game.setAiColor(Constants.aiColor);
        newGame(game);
   }
  });
    JLabel label = new JLabel();
    label.setText("Hitting Apply will start a new game with the applied settings.");
    label.setBounds(20, 260, 400, 20);
    JLabel label2 = new JLabel();
    label2.setText("Hitting Cancel will revert to default settings.");
    label2.setBounds(20, 290, 400, 20);
    JLabel label3 = new JLabel();
    label3.setText("When time is enabled, 15 minutes are alloted for each move.");
    label3.setBounds(20, 35, 400, 10);
    JLabel label4 = new JLabel();
    label4.setText("Set CPU color with the box's color");
    label4.setBounds(45, 208, 400, 10);
  frame.add(label);
  frame.add(label2);
  frame.add(label3);
  frame.add(label4);
  frame.setSize(500, 400);
  frame.setVisible(true);
  frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
  }
 });
 appearance.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
     Color color=colorChooser.showDialog(game,"Select a color",game.getBackground());
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
     g.setTimeEnabled(Constants.isEnabled);
     newGame(game);
     //Gamewindow.main(null);
   }
 });
 save.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
	 JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
	 int returnVal = fc.showSaveDialog(null);
     File fil = fc.getSelectedFile();
     // Border gets re-enabled here for some reason requiring the borders to be set to null again
     try {
     Game g = window.state();
     FileOutputStream file = new FileOutputStream(fil);
     ObjectOutputStream obj = new ObjectOutputStream(file);
     obj.writeObject(g);
     obj.close();
     file.close();
     g.label.setBorder(null);
     g.turnLabel.setBorder(null);
     g.turnCountLabel.setBorder(null);
   }
     catch (FileNotFoundException ex) {
         g.label.setBorder(null);
         g.turnLabel.setBorder(null);
         g.turnCountLabel.setBorder(null);
         ex.printStackTrace();
         int imgSize = Constants.images[g.getTurnCount() % 2].length;
    	 JOptionPane.showMessageDialog(null, "File Not found!", "File not found!", JOptionPane.ERROR_MESSAGE, Constants.images[g.getTurnCount() % 2][rand.nextInt(Constants.images[g.getTurnCount() % 2].length)]);
     }
     catch (IOException ex) {
         g.label.setBorder(null);
         g.turnLabel.setBorder(null);
         g.turnCountLabel.setBorder(null);
         ex.printStackTrace();
         int imgSize = Constants.images[g.getTurnCount() % 2].length;
    	 JOptionPane.showMessageDialog(null, "This save file is not valid", "Choose another save file!", JOptionPane.ERROR_MESSAGE, Constants.images[g.getTurnCount() % 2][rand.nextInt(Constants.images[g.getTurnCount() % 2].length)]);
	}
     catch (NullPointerException ex) {
    	 // Occurs when user hits cancel
         g.label.setBorder(null);
         g.turnLabel.setBorder(null);
         g.turnCountLabel.setBorder(null);
    	 ex.printStackTrace();
   }
   }
 });
 open.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
	 JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
	 int returnVal = fc.showOpenDialog(null);
	 File fil = fc.getSelectedFile();
	// Prevents null pointer exception when hitting cancel
     try {
     FileInputStream file = new FileInputStream(fil);
     ObjectInputStream obj = new ObjectInputStream(file);
     Game g = (Game) obj.readObject();
     //System.out.println(g.getTurnCount());
     obj.close();
     file.close();
     if (!g.getGameEnded())
     newSavedGame(g);
     else {
       JOptionPane.showMessageDialog(null, "This game has already ended!", "Choose another save file!", JOptionPane.ERROR_MESSAGE, Constants.images[g.getTurnCount() % 2][rand.nextInt(Constants.images[g.getTurnCount() % 2].length)]);
     }
     }
     catch (FileNotFoundException ex) {
    	 ex.printStackTrace();
    	 JOptionPane.showMessageDialog(null, "File Not found!", "File not found!", JOptionPane.ERROR_MESSAGE, Constants.images[g.getTurnCount() % 2][rand.nextInt(Constants.images[g.getTurnCount() % 2].length)]);
     }
     catch (IOException ex) {
    	 ex.printStackTrace();
    	 JOptionPane.showMessageDialog(null, "This save file is not valid", "Choose another save file!", JOptionPane.ERROR_MESSAGE, Constants.images[g.getTurnCount() % 2][rand.nextInt(Constants.images[g.getTurnCount() % 2].length)]);
	} catch (ClassNotFoundException ex) {
		ex.printStackTrace();
		JOptionPane.showMessageDialog(null, "There was a problem opening this save file.  Please open another one.", "Error opening file!", JOptionPane.ERROR_MESSAGE, Constants.images[g.getTurnCount() % 2][rand.nextInt(Constants.images[g.getTurnCount() % 2].length)]);
	}
     catch (ClassCastException ex) {
    	 ex.printStackTrace();
    	 JOptionPane.showMessageDialog(null, "There was a problem opening this save file.  Please open another one.", "Error opening file!", JOptionPane.ERROR_MESSAGE, Constants.images[g.getTurnCount() % 2][rand.nextInt(Constants.images[g.getTurnCount() % 2].length)]);
     }
     catch (NullPointerException ex) {
    	 // Occurs when the user hits cancel
    	 ex.printStackTrace();
     }
   }
 });
 stuff.addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent e) {
		File file = new File("help.txt");
		// https://stackoverflow.com/questions/6273221/open-a-text-file-in-the-default-text-editor-via-java
		// Solution obtained from above link and it accounts for glitches that may occur in Windows for Java desktop
		if (System.getProperty("os.name").toLowerCase().contains("windows")) {
			String cmd;
			try {
				cmd = "rundll32 url.dll,FileProtocolHandler " + file.getCanonicalPath();
				Runtime.getRuntime().exec(cmd);
			} catch (IOException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "You may have deleted the help file!  No help for you!", "Hey!", JOptionPane.ERROR_MESSAGE, Constants.images[g.getTurnCount() % 2][rand.nextInt(Constants.images[g.getTurnCount() % 2].length)]);
			}
			catch (IllegalArgumentException ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "You may have deleted the help file!  No help for you!", "Hey!", JOptionPane.ERROR_MESSAGE, Constants.images[g.getTurnCount() % 2][rand.nextInt(Constants.images[g.getTurnCount() % 2].length)]);
			}
		}
		else {
		try {
			Desktop.getDesktop().open(file);
		} catch (IOException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "You may have deleted the help file!  No help for you!", "Hey!", JOptionPane.ERROR_MESSAGE, Constants.images[g.getTurnCount() % 2][rand.nextInt(Constants.images[g.getTurnCount() % 2].length)]);
		}
		catch (IllegalArgumentException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "You may have deleted the help file!  No help for you!", "Hey!", JOptionPane.ERROR_MESSAGE, Constants.images[g.getTurnCount() % 2][rand.nextInt(Constants.images[g.getTurnCount() % 2].length)]);
		}
		}
	}
	 
 });
 menu4.addMenuListener(new MenuListener() {

	@Override
	public void menuSelected(MenuEvent e) {
		//System.out.println(g.getBoard().pieceCount[0].length);
		Graveyard gy = new Graveyard(g.capturedpieces);
	}

	@Override
	public void menuDeselected(MenuEvent e) {

	}

	@Override
	public void menuCanceled(MenuEvent e) {
	
	}	 
 });
 menu.add(menu4);
  this.setJMenuBar(menu);
  }
 @Override
 public void run() {

 }
 public void newSavedGame(Game g) {
   //Gamewindow.timer.stop();
   //Game state = this.state();
   //System.out.println(state.getTurnCount());
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
  Constants.SETTING = g.getSetting();
  setImages(Constants.SETTING, g);
  //this.setSelectedButton(g);
  //group.setSelected((ButtonModel) lis.get(g.getSetting()), true);
  SwingUtilities.invokeLater(new Gamewindow(g.board.pieces, g.getTurnCount(), g.getcurrKingCheck(), g.getCastling(), g.getGameEnded(), g.getTimeEnabled(), g.getTakeMeEnabled(), g.getTime(), g.getSetting(), g.getAilevel(), g.getAiColor(), g.capturedpieces, g.moveList, g.getEnPass()));
 }
 public void newGame(Game g) {
   //Gamewindow.timer.stop();
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
  Constants.SETTING = 0;
  setImages(Constants.SETTING, g);
  SwingUtilities.invokeLater(new Gamewindow(null, 0, false, false, false, g.getTimeEnabled(), g.getTakeMeEnabled(), Constants.TIME, 0, g.getAilevel(), g.getAiColor(), null, null, null));
 }
 public void setImages(int setting, Game g) {
	 for (int i = 0; i < 2; i++) {
		 for (Piece p : g.getBoard().pieces[i]) {
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
			 ImageIcon set = new ImageIcon(Constants.names[setting][c.equals(Color.black) ? val : val + 6], p.getName());
			 p.setImage(set);
		 }
	 }
	 Constants.SETTING = setting;
	 g.setSetting(setting);
	 for (TileButton[] tils : g.getBoard().tiles) {
		 for (TileButton tb : tils) {
			 if (tb.getTile().getPiece() != null) {
				 tb.getTile().setImage(tb.getTile().getPiece().getImage());
				 tb.setIcon(tb.getTile().getImage());
			 }
			 if (g.pieceLook == 1) {
				 if (tb.getTile().getColor().equals(Color.BLACK)) {
					 if (!tb.equals(g.getBoard().kingsButton[g.getTurnCount() % 2])) {
					 tb.setBackground(Constants.GRAY);
					 tb.getTile().setColor(tb.getBackground());
					 }
					 else {
						 tb.getTile().setColor(Constants.GRAY);
					 }
				 }
			 }
			 else {
				 if (tb.getTile().getColor().equals(Constants.GRAY)) {
					 if (!tb.equals(g.getBoard().kingsButton[g.getTurnCount() % 2])) {
					 tb.setBackground(Color.BLACK);
					 tb.getTile().setColor(tb.getBackground());
					 }
					 else {
						 tb.getTile().setColor(Color.BLACK);
					 }
				 }
			 }
		 }
	 }
	 //System.out.println(g.getSetting());
	 this.setSelectedButton(this.game);
 }
 public ArrayList<AbstractButton> butToLis() {
	 ArrayList<AbstractButton> lis = Collections.list(group.getElements());
	 return lis;
 }
 public void setSelectedButton(Game g) {
	 int index = 0;
	 this.group.clearSelection();
	 Enumeration<AbstractButton> buttons = this.group.getElements();
	 /*Enumeration<AbstractButton> aibuttons = this.aigroup.getElements();
	 Enumeration<AbstractButton> aicolors = this.aicolor.getElements();*/
	 while (buttons.hasMoreElements()) {
		 AbstractButton but = buttons.nextElement();
		 if (index == g.getSetting()) {
			 //System.out.println("Gogeta and Trunks!\n" + but.getModel());
		 group.setSelected(but.getModel(), true);
		 }
		 index++;
	 }
	 /*index = 0;
	 while (aibuttons.hasMoreElements()) {
		 AbstractButton but = aibuttons.nextElement();
		 if (index == g.getAilevel()) {
			 aigroup.setSelected(but.getModel(), true);
		 }
		 index++;
	 }
	 index = 0;
	 while (aicolors.hasMoreElements()) {
		 AbstractButton but = aicolors.nextElement();
		 if (index == g.getAilevel()) {
			 aicolor.setSelected(but.getModel(), true);
		 }
		 index++;
	 }*/
 }
 public Game state() {
   return this.game;
 }
  public static void main(String[] args) {
    try {
   //System.setProperty("apple.laf.useScreenMenuBar", "true");
   //System.setProperty("com.apple.mrj.application.apple.menu.about.name", "WikiTeX");
   UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      //UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
  } catch (Exception ex) {
      System.err.println("Cannot set LookAndFeel");
  }
  SwingUtilities.invokeLater(new Gamewindow(null, 0, false, false, false, false, false, Constants.TIME, 0, Constants.aiLevel, Constants.aiColor, null, null, null));
  }
}
