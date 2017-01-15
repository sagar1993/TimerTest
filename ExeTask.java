import java.util.TimerTask;

public class ExeTask extends TimerTask {

	int value = 1;
	Singleton singleton = Singleton.getInstance();

	static final int CREATED = 0;
	static final int RUNNING = 1;
	static final int EXECUTED = 2;

	int status = CREATED;

	int _start;
	int _end;
	
	volatile boolean shutdown = false;

	/*
	 * ExeTask(int x){ this.value = x; }
	 */
	@Override
	public void run() {
		try {
			status = RUNNING;
			if(!shutdown){
				System.out.println("Thread");

				Thread.sleep(10 * 1000);

				System.out.println(_start + " " + _end);

				System.out.println("Thread END");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			status = EXECUTED;
		}
	}

}
