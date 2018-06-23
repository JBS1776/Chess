import javax.swing.JFrame;

import javax.swing.JOptionPane;


import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.*;
import javax.swing.SwingUtilities;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;
import java.time.Clock;
import java.time.Duration;
import java.time.ZoneId;
import java.util.Date;
public class Options extends JFrame{
 boolean isEnabled = false;
 int seconds = new Date().getSeconds();
 int multiplyer = 10;
 JRadioButton prev = null;
 int index = 0;
 public Options() {
  setLayout(null);
  JCheckBox enableTime = new JCheckBox("EnableTime in seconds (Time will be set to unlimited if this is disabled)", false);
  enableTime.setBounds(0, 10, 500, 20);
  add(enableTime);
  JTextArea setTime = new JTextArea("SetTime", 1, 1);
  setTime.setEnabled(isEnabled);
  setTime.setBounds(5, 30, 50, 20);
  add(setTime);
  enableTime.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
    Object o = e.getSource();
    int curSecs = new Date().getSeconds();
    if (o instanceof JCheckBox) {
     isEnabled = !isEnabled;
     setTime.setEnabled(isEnabled);
     //System.out.println(Math.abs((curSecs - seconds) % 60));
    }
   }
  });
  JRadioButton[] buttons = new JRadioButton[6];
  int[] assoc = new int[buttons.length];
  for (int i = 60; i <= 100; i+=10) {
   int moveCount = i;
   int posY = i + multiplyer;
   JRadioButton b = new JRadioButton((moveCount - 10) + " total moves");
   b.setBounds(0, posY, 200, 20);
   buttons[index] = b;
   assoc[index] = moveCount - 10;
   add(b);
   multiplyer += 10;
   index += 1;
  }
  JRadioButton last = new JRadioButton("Unlimited moves");
  last.setBounds(0, 170, 200, 20);
  buttons[buttons.length - 1] = last;
  add(last);
  buttons[0].setSelected(true);
  prev = buttons[0];
  for (JRadioButton buts : buttons) {
   buts.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
     Object o = e.getSource();
     if (o instanceof JRadioButton) {
      if (prev == null) {
      ((JRadioButton) o).setSelected(true);
      prev = ((JRadioButton) o);
     }
      else {
       prev.setSelected(false);
       ((JRadioButton) o).setSelected(true);
       prev = ((JRadioButton)o);
      }
     }
    }
   });
  }
  JButton cancel = new JButton("Cancel");
  cancel.setBounds(200, 350, 100, 20);
  cancel.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
    dispose();
   }
  });
  add(cancel);
  JButton apply = new JButton("Apply");
  add(apply);
  apply.setBounds(350, 350, 100, 20);
  apply.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
    if (setTime.isEnabled()) {
     String s = setTime.getText();
     if (s.length() <= 5) {
      int tracker = 0;
     for (int i = 0; i < s.length(); i++) {
      boolean isNumber = Character.isDigit(s.charAt(i));
      if (!isNumber) {
       Game.maxSeconds = Integer.MAX_VALUE;
       tracker = 0;
       break;
      }
      tracker += 1;
     }
     if (tracker != 0) {
     Game.maxSeconds = Integer.parseInt(s);
     }
     else {
      Game.maxSeconds = Integer.MAX_VALUE;
     }
     }
     else {
      Game.maxSeconds = Integer.MAX_VALUE;
     }
    }
    else {
     Game.maxSeconds = Integer.MAX_VALUE;
    }
    char c = prev.getText().charAt(0);
    int num = c - '0';
    if (num < 0 || num > 9) {
     Game.maxTurns = Integer.MAX_VALUE;
    }
    else {
     Game.maxTurns = num * 10;
    }
    System.out.println(Game.maxTurns);
    System.out.println(Game.maxSeconds);
    //dispose();
   }
  });
  this.setSize(500, 400);
  this.setVisible(true);
  this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
 }

 public static void main(String[] args) {
  Options o = new Options() {
   @Override
   public void paint(Graphics g) {
    super.paint(g);
    g.drawString("Input a positive integer with less than five digits.", 60, 67);
    g.drawString("Time will be set to unlimited otherwise.", 5, 85);
    g.drawString("Hello!  Hope these are the settings you want!", 5, 230);
    g.drawString("Remember: the game doesn't tell you when your king is in check yet.", 5, 250);
    g.drawString("This means that the game ends when the King is captured like any other piece.", 5, 270);
    g.drawString("This results in checkmate of course.", 5, 290);
    g.drawString("We Americans hate stalemates.  GET USED TO IT!!", 5, 310);
   }
  };

 }

}
