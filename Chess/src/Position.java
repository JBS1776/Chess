public class Position implements java.io.Serializable{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 private int x;
 private int y;
 public Position(int x, int y) {
  this.x = x;
  this.y = y;
 }
 public void setX(int x) {
  this.x = x;
 }
 public void setY(int y) {
  this.y = y;
 }
 public int getX() {
  return this.x;
 }
 public int getY() {
  return this.y;
 }
 public String toString() {
  return "" + "(" + this.x + ", " + this.y + ")";
 }
}
