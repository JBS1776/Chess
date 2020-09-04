import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
public class Graveyard extends JFrame implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Rectangle vertical = new Rectangle(240, 5, 10, 105);
	private Rectangle horizontal = new Rectangle(200, 25, 90, 10);
	private Color background = Color.red;
	public Graveyard(ArrayList<LinkedList<Piece>> caps, Gamewindow gw) {
		gw.setEnabled(false);
		this.setTitle("The Graveyard");
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    this.setPreferredSize(new Dimension(500, 500));
	    Pawn whitepawn = new Pawn(8, Color.WHITE, null, Constants.images[0][8], "Wpawn", false);
	    Pawn blackpawn = new Pawn(8, Color.BLACK, null, Constants.images[1][8], "Bpawn", false);
	    Rook whiterook = new Rook(0, Color.WHITE, null, Constants.images[0][0], "Wrook", false);
	    Rook blackrook = new Rook(0, Color.BLACK, null, Constants.images[1][0], "Brook", false);
	    Knight whiteknight = new Knight(1, Color.WHITE, null, Constants.images[0][1], "Wknight");
	    Knight blackknight = new Knight(1, Color.BLACK, null, Constants.images[1][1], "Bknight");
	    Bishop whitebishop = new Bishop(2, Color.WHITE, null, Constants.images[0][2], "Wbishop");
	    Bishop blackbishop = new Bishop(2, Color.BLACK, null, Constants.images[1][2], "Bbishop");
	    Queen whitequeen = new Queen(3, Color.WHITE, null, Constants.images[0][3], "Wqueen");
	    Queen blackqueen = new Queen(3, Color.BLACK, null, Constants.images[1][3], "Bqueen");
	    King whiteking = new King(4, Color.WHITE, null, Constants.images[0][4], "Wking", false);
	    King blackking = new King(4, Color.BLACK, null, Constants.images[1][4], "Bking", false);
	    Piece[] ps = {whiteking, blackking, whitequeen, blackqueen, whitebishop, blackbishop, whiteknight, blackknight, whiterook, blackrook, whitepawn, blackpawn};
	    for (int i = 0; i < 12; i++) {
	    	if (i >= 10)
	    		ps[i].setImage(new ImageIcon(Constants.names[Constants.SETTING][ps[i].getColor().equals(Color.black) ? 5 : 11], ps[i].getName()));
	    	else
	    	ps[i].setImage(new ImageIcon(Constants.names[Constants.SETTING][ps[i].getColor().equals(Color.black) ? ps[i].getId() : ps[i].getId() + 6], ps[i].getName()));
	    }
	    PieceButton[] pbs = new PieceButton[12];
	    JTextArea[] freqs = new JTextArea[12];
	    int initX = 118;
	    int initY = 60;
	    for (int i = 0; i < pbs.length; i++) {
	    pbs[i] = new PieceButton(ps[i], 0);
	    pbs[i].setOpaque(true);
	    pbs[i].setBounds(initX, initY, 50, 50);
	    pbs[i].setIcon(ps[i].getImage());
	    pbs[i].setFocusable(false);
	    pbs[i].setBackground(Color.GREEN);
	    pbs[i].setBorder(null);
	    freqs[i] = new JTextArea("" + pbs[i].getFreq());
	    freqs[i].setBounds(initX + 20, initY - 20, 20, 15);
	    freqs[i].setBackground(background);
	    freqs[i].setFocusable(false);
	    pbs[i].setFreq(caps.get(i).size());
	    freqs[i].setText("" + pbs[i].getFreq());
	    this.add(pbs[i]);
	    this.add(freqs[i]);
	    if (i < 3) {
    	initX += 68;
	    }
	    else {
	    	if (i % 2 == 1) {
	    		initX = 186;
	    		initY += 80;
	    	}
	    	else {
	    		initX = 256;
	    	}
	    }
	    }
	    this.add(new PaintComponent());
	    this.getContentPane().setBackground(background);

	    // set the jframe size and location, and make it visible
	    this.pack();
	    this.setLocationRelativeTo(null);
	    this.setVisible(true);
	    Graveyard g = this;
	    this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				g.dispose();
				gw.setEnabled(true);
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
	    	
	    });
	}
	private class PaintComponent extends Component {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
			g.fillRect((int) vertical.getX(), (int) vertical.getY(), (int) vertical.getWidth(), (int) vertical.getHeight());
			g.fillRect((int) horizontal.getX(), (int) horizontal.getY(), (int) horizontal.getWidth(), (int) horizontal.getHeight());
		}
	}
	private class PieceButton extends JButton{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int freq;
		public PieceButton(Piece piece, int freq) {
			this.freq = freq;
		}
		public int getFreq() {
			return this.freq;
		}
		public void setFreq(int val) {
			this.freq = val;
		}
	}
	public static void main(String[] args) {
	}
	@Override
	public void run() {
		
	}

}
