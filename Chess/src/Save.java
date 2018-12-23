import java.util.*;
public class Save
{
  public static void main(String[] args) throws InterruptedException
  {
    Scanner scan = new Scanner(System.in);
    System.out.println("How much time (In Minutes) ?");
    int timet = scan.nextInt(); // Convert to seconds
    long delay = timet * 1000;

    do
    {
      int minutes = timet / 60;
      int seconds = timet % 60;
      if (minutes < 10 || seconds < 10) {
        if (minutes < 10 && seconds < 10) {
          System.out.println("0" + minutes + ":0" + seconds);
        }
        else {
        if (minutes < 10)
          System.out.println("0" + minutes + ":" + seconds);
        if (seconds < 10)
          System.out.println(minutes + ":0" + seconds);
        }
      }
      else {
        System.out.println(minutes + ":" + seconds);
      }
      Thread.sleep(1000);
      timet = timet - 1;
      delay = delay - 1000;

    }
    while (delay != 0);
    System.out.println("Time's Up!");
  }
}