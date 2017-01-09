import java.util.Timer;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Singleton {

   private static Singleton singleton = new Singleton( );

   Timer timer = new Timer();
   
   ScheduledExecutorService _pool = new ScheduledThreadPoolExecutor(4);
   /* A private Constructor prevents any other
    * class from instantiating.
    */
   protected static int _x = 1;
   private Singleton() { }

   /* Static 'instance' method */
   public static Singleton getInstance( ) {
      return singleton;
   }
   
   protected void increment_x(int val){
	   _x = val;
	   
	   timer.cancel();
	   timer.purge();
	   timer = new Timer();
	   timer.schedule(new ExeTask(_x), 5 * 1000);
   }

   /* Other methods protected by singleton-ness */
   protected static void demoMethod( ) {
      System.out.println("demoMethod for singleton");
   }
}