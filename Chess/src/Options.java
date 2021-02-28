import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
public class Options extends JFrame implements Runnable, java.io.Serializable {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Options(Gamewindow gw, Game g) {
		gw.setEnabled(false);
	    try {
	    	   //System.setProperty("apple.laf.useScreenMenuBar", "true");
	    	   //System.setProperty("com.apple.mrj.application.apple.menu.about.name", "WikiTeX");
	    	   //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
	    	   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    	      //UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
	    	  } catch (Exception ex) {
	    	      System.err.println("Cannot set LookAndFeel");
	    	  }
	    this.setLayout(null);
	    this.setResizable(false);
	    JCheckBox enableTime = new JCheckBox("Enable time", g.getTimeEnabled());
	    enableTime.setBounds(0, 10, 500, 20);
	    this.add(enableTime);
	    JRadioButton[] buttons = new JRadioButton[2];
	    buttons[0] = new JRadioButton("Regular Chess");
	    buttons[0].setBounds(0, 50, 200, 20);
	    this.add(buttons[0]);
	    buttons[0].setSelected(!g.getTakeMeEnabled());
	    buttons[1] = new JRadioButton("Take-me Chess");
	    buttons[1].setBounds(0, 70, 200, 20);
	    this.add(buttons[1]);
	    buttons[1].setSelected(g.getTakeMeEnabled());
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
	        }
	        }
	      });
	    }
	    JRadioButton[] aiButtons = new JRadioButton[4];
	    aiButtons[0] = new JRadioButton("No computer");
	    aiButtons[0].setBounds(0, 110, 200, 20);
	    this.add(aiButtons[0]);
	    aiButtons[1] = new JRadioButton("Easy computer");
	    aiButtons[1].setBounds(0, 130, 200, 20);
	    this.add(aiButtons[1]);
	    aiButtons[2] = new JRadioButton("Hard computer");
	    aiButtons[2].setBounds(0, 150, 200, 20);
	    this.add(aiButtons[2]);
	    aiButtons[3] = new JRadioButton("Computer vs Computer");
	    aiButtons[3].setBounds(0, 170, 200, 20);
	    this.add(aiButtons[3]);
	    int prevSelection = g.getAilevel();
	    aiButtons[g.getAilevel()].setSelected(true);
	    for (JRadioButton but : aiButtons) {
	    	but.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < aiButtons.length; i++) {
						if (e.getSource().equals(aiButtons[i])) {
							aiButtons[i].setSelected(true);
							g.setAilevel(i);
						}
						else {
							aiButtons[i].setSelected(false);
						}
					}
				}   		
	    	});
	    }
	    JButton aiPlayer = new JButton();
	    aiPlayer.setOpaque(true);
	    aiPlayer.setBorderPainted(false);
	    aiPlayer.setBounds(10, 200, 30, 30);
	    aiPlayer.setBackground(Constants.colors[Constants.aiColor]);
	    aiPlayer.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		if (aiPlayer.getBackground().equals(Constants.colors[0])) {
	    			aiPlayer.setBackground(Constants.colors[1]);
	    			//g.setAilevel(1);
	    		}
	    		else {
	    			aiPlayer.setBackground(Constants.colors[0]);
	    			//g.setAilevel(0);
	    		}
	    		//g.setAiColor(Constants.aiColor);
	    	}
	    });
	    this.add(aiPlayer);
	    JButton cancel = new JButton("Cancel");
	    cancel.setBounds(200, 350, 100, 20);
	    cancel.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	  	    try {
		    	   //System.setProperty("apple.laf.useScreenMenuBar", "true");
		    	   //System.setProperty("com.apple.mrj.application.apple.menu.about.name", "WikiTeX");
		    	   UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		    	   g.setAilevel(prevSelection);
		    	   //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    	      //UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
		    	  } catch (Exception ex) {
		    	      System.err.println("Cannot set LookAndFeel");
		    	  }
	        dispose();
	        gw.setEnabled(true);
	      }
	    });
	    this.add(cancel);
	    JButton apply = new JButton("Apply");
	    this.add(apply);
	    apply.setBounds(350, 350, 100, 20);
	    apply.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	        dispose();
	        gw.getG().setTimeEnabled(enableTime.isSelected());
	        gw.getG().setTakeMeEnabled(buttons[1].isSelected());
	        gw.getG().setAiColor(aiPlayer.getBackground().equals(Constants.colors[0]) ? 0 : 1);
	        gw.newGame(gw.getG());
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
	  this.add(label);
	  this.add(label2);
	  this.add(label3);
	  this.add(label4);
	  this.addWindowListener(new WindowListener () {

		@Override
		public void windowOpened(WindowEvent e) {
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			dispose();
			gw.setEnabled(true);
		}

		@Override
		public void windowClosed(WindowEvent e) {
	
		}

		@Override
		public void windowIconified(WindowEvent e) {
	
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
	
		}

		@Override
		public void windowActivated(WindowEvent e) {
	
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
	
		}
		  
	  });
	  this.setSize(500, 400);
	  this.setVisible(true);
	  this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
@Override
public void run() {
	
}
}
