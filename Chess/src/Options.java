import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
public class Options extends JFrame implements java.io.Serializable{
 boolean isEnabled = false;
 boolean toClose = false;
 //int seconds = new Date().getSeconds();
 int multiplyer = 10;
 JRadioButton prev = null;
 int index = 0;
 public Options(Game g) {
  setLayout(null);
  this.setResizable(false);
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
       g.setMaxSeconds(Integer.MAX_VALUE);
       tracker = 0;
       break;
      }
      tracker += 1;
     }
     if (tracker != 0) {
     g.setMaxSeconds(Integer.parseInt(s));
     }
     else {
      g.setMaxSeconds(Integer.MAX_VALUE);
     }
     }
     else {
      g.setMaxSeconds(Integer.MAX_VALUE);
     }
    }
    else {
     g.setMaxSeconds(Integer.MAX_VALUE);
    }
    char c = prev.getText().charAt(0);
    int num = c - '0';
    if (num < 0 || num > 9) {
     g.setMaxTurns(Integer.MAX_VALUE);
    }
    else {
     g.setMaxTurns(num * 10);
    }
    dispose();
   }
  });
  this.setSize(500, 400);
  this.setVisible(true);
  this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
 }

 public static void main(String[] args) {

 }

}
