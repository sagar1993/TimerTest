import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

public class Test {
  Toolkit toolkit;

  static Timer timer;

  /*public void ReminderBeep(int seconds) {
    toolkit = Toolkit.getDefaultToolkit();
    
  }*/


  public static void main(String args[]) {
    
	  int k =9;
	  System.out.println( k >> 1);
	  /*System.out.println("About to schedule task.");
    timer = new Timer();
    timer.cancel();
    
    timer = new Timer();
    timer.schedule(new RemindTask(), 5 * 1000);
    System.out.println("Task scheduled.");*/
  }
  
  static class RemindTask extends TimerTask {
	    public void run() {
	      System.out.println("Time's up!");
	    }
	  }
}