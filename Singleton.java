import java.util.Timer;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Singleton {

   private static Singleton singleton = new Singleton( );

   Object lock = new Object();
   
   Timer timer = new Timer();
   
   ExeTask [] taskqueue = new ExeTask[16];
   int current = 0;
   int _start;
   
   protected static int _end = 1;
   private Singleton() { }

   /* Static 'instance' method */
   public static Singleton getInstance( ) {
      return singleton;
   }
   
   synchronized protected void increment_x(int val){
	   _end = val;
	   
	   ExeTask task = new ExeTask();
	   /*
	   timer.schedule(task, 5 * 1000);*/
	   scheduleTask(_end, task);
   }

   /* Other methods protected by singleton-ness */
   private void scheduleTask(int _end, ExeTask task) {
      // task not present
	  task._end = _end; 
	//task present not running
	  if(taskqueue[current] != null){
		  ExeTask currentTask = taskqueue[current];
		  
		  if(currentTask.status < ExeTask.RUNNING){
			  task._start = currentTask._start;
			  currentTask.shutdown = true;
			  currentTask.cancel();
			  taskqueue[current] = task;
			  timer.schedule(task, 5 * 1000);
		  }
		  else{
			  task._start = _end;
	    	  taskqueue[++current] = task;
	    	  timer.schedule(task, 5 * 1000);
		  }
      }
	  
	  if(taskqueue[current] == null){
		  task._start = _end;
    	  taskqueue[current] = task;
    	  timer.schedule(task, 5 * 1000);
      }
	  
	 fixQueue();
   }

private void fixQueue() {
	// TODO Auto-generated method stub
	
	int i = 0;
	int status;
	for(int j = 0 ; j < 16; j++){
		if(taskqueue[j] == null)
			continue;
		status = taskqueue[j].status;
		if(status == ExeTask.EXECUTED){
			taskqueue[j] = null;
		}
		else{
			/*if((status == ExeTask.CREATED) || (status == ExeTask.RUNNING))*/
			if(i == j)
				continue;
			ExeTask task = taskqueue[j];
			current = i;
			taskqueue[i++] = task;
			taskqueue[j] = null;
		}
			
	}
}
}