import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;

class TileButton extends JButton implements java.io.Serializable{  
    private Tile tile;
    private Board board = new Board();
    public TileButton(Tile tile) {
      this.tile = tile;
    }
    public void select(ArrayList<TileButton> tiles) {
      for (TileButton t : tiles) {
        t.setBackground(Constants.HIGHLIGHTER);
      }
    }
    public void deSelect(ArrayList<TileButton> tiles, Game g) {
      if (g.getTakeMeEnabled()) {
        Color turnColor = g.getTurnColor();
        Color oppColor = turnColor.equals(Constants.colors[0]) ? Constants.colors[1] : Constants.colors[0];
        System.out.println(g.takeCyan);
        for (TileButton t : tiles) {
            t.setBackground(t.getTile().getColor());
        }
        for (TileButton t : g.takeRed) {
          t.setBackground(Color.RED);
        }
        if (g.takeCyan != null)
          g.takeCyan.setBackground(Color.CYAN);
      }
      else {
      for (TileButton t : tiles) {
        t.setBackground(t.getTile().getColor());
      }
      if (!Constants.takeMeChess) {
      if (g.getcurrKingCheck())
      g.getBoard().kingsButton[g.getTurnCount() % 2].setBackground(Constants.CHECKHIGHLIGHT);
      else
        g.getBoard().kingsButton[g.getTurnCount() % 2].setBackground(Color.GREEN);
    }
      }
    }
    public static void clearPaint(Game g) {
      for (TileButton[] tis : g.getBoard().tiles)
        for (TileButton but : tis)
        but.setBackground(but.getTile().getColor());
    }
      public Tile getTile() {
       return this.tile;
      }
      public static ArrayList<TileButton> intersection(ArrayList<TileButton> a, ArrayList<TileButton> b) {
        ArrayList<TileButton> lis = new ArrayList<TileButton>();
        for (int i = 0; i < a.size(); i++) {
          for (int j = 0; j < b.size(); j++) {
            if (a.get(i).equals(b.get(j)) && !lis.contains(a.get(i))) {
              lis.add(a.get(i));
              break;
            }
          }
        }
        return lis;
      }
    }
