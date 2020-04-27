import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

//import Promotion.PieceButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Graveyard extends JFrame{
	//private Map<Piece, Integer> pieces = new HashMap<Piece, Integer>();
	private Dimension dim = new Dimension(500, 500);
	private Rectangle vertical = new Rectangle(240, 5, 10, 105);
	private Rectangle horizontal = new Rectangle(200, 25, 90, 10);
	private Color background = Color.red;
	public Graveyard(ArrayList<LinkedList<Piece>> caps) {
	    //JFrame jframe = new JFrame("The Graveyard");
	    //Graveyard jframe = new Graveyard();
		this.setTitle("The Graveyard");
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    this.setPreferredSize(dim);
	    //Piece p = null;
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
	    /*JButton reload = new JButton("Reload");
	    reload.setBounds(20, 10, 85, 20);
	    this.add(reload);*/
	    int initX = 118;
	    int tempX = initX;
	    int initY = 60;
	    for (int i = 0; i < pbs.length; i++) {
	    pbs[i] = new PieceButton(ps[i], 0);
	    pbs[i].setOpaque(true);
	    /*if (i <= 3) {
	    	initX += 68;
	    }
	    else {
	    	if (i % 2 == 0)
	    	initX = 135;
	    	else
	    		initX = 203;
	    }
	    if (i % 2 == 0 && i > 3)
	    	initY += 60;*/
	    System.out.println(i);
	    pbs[i].setBounds(initX, initY, 50, 50);
	    //pbs[i].setIcon(Constants.images[ps[i].getColor().equals(Color.WHITE) ? 0 : 1][ps[i].getId()]);
	    pbs[i].setIcon(ps[i].getImage());
	    pbs[i].setFocusable(false);
	    pbs[i].setBackground(Color.GREEN);
	    pbs[i].setBorder(null);
	    //pbs[i].setFreq(0);
	    freqs[i] = new JTextArea("" + pbs[i].getFreq());
	    //freqs[i] = new JTextArea("16");
	    freqs[i].setBounds(initX + 20, initY - 20, 20, 15);
	    //freqs[i].setLayout(null);
	    freqs[i].setBackground(background);
	    freqs[i].setFocusable(false);
	    int ith = i; // to Access i for ActionListener
	    /*pbs[i].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pbs[ith].setFreq(pbs[ith].getFreq() + 1);
				freqs[ith].setText("" + pbs[ith].getFreq());
			}	    	
	    });*/
	    int size = Constants.maxFreqs.length;
	    /*int odd = 9 - i;
	    if (i % 2 == 1)
	    	odd += 1;
	    if (i < 10) {
	    	//System.out.println("Odd: " + odd + "vals: " + vals[i % 2][odd / 2]);
	    pbs[i].setFreq(Constants.maxFreqs[odd / 2] - vals[i % 2][odd / 2]);
	    //System.out.println(pbs[i].getPiece().getName() + ", " + pbs[i].getFreq());
	    }
	    else {
	    	pbs[i].setFreq(Constants.maxFreqs[5] - vals[i % 2][5]);
	    	//System.out.println(vals[i % 2][5]);
	    }*/
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
	    //pb.setIcon(Constants.images[0][8]);
	    this.add(new PaintComponent());
	    //this.add(pb);
	    this.getContentPane().setBackground(background);

	    // set the jframe size and location, and make it visible
	    this.pack();
	    this.setLocationRelativeTo(null);
	    this.setVisible(true);
	}
	private class PaintComponent extends Component {
		public void paint(Graphics g) {
			//g.drawRect(190, 20, 10, 90);
			g.fillRect((int) vertical.getX(), (int) vertical.getY(), (int) vertical.getWidth(), (int) vertical.getHeight());
			//g.drawRect(150, 40, 90, 10);
			g.fillRect((int) horizontal.getX(), (int) horizontal.getY(), (int) horizontal.getWidth(), (int) horizontal.getHeight());
			//g.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer)
		}
	}
	private class PieceButton extends JButton{
		private Piece piece;
		private int freq;
		public PieceButton(Piece piece, int freq) {
			this.piece = piece;
			this.freq = freq;
		}
		public Piece getPiece() {
			return this.piece;
		}
		public void setPiece(Piece p) {
			this.piece = p;
		}
		public int getFreq() {
			return this.freq;
		}
		public void setFreq(int val) {
			this.freq = val;
		}
	}
	public static int findIndex(Piece p, Color color) {
		//int index = 0;
		int adder = color.equals(Constants.colors[0]) ? 0 : 1;
		if (p instanceof King) {
			return adder;
		}
		if (p instanceof Queen) {
			return 2 + adder;
		}
		if (p instanceof Bishop) {
			return 4 + adder;
		}
		if (p instanceof Knight) {
			return 6 + adder;
		}
		if (p instanceof Rook) {
			return 8 + adder;
		}
		return 10 + adder;
	}
	public static void main(String[] args) {
		//Graveyard gy = new Graveyard();
	}

}
