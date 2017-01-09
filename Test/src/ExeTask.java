import java.util.TimerTask;

public class ExeTask extends TimerTask{

	int value = 1;
	Singleton singleton = Singleton.getInstance();
	
	ExeTask(int x){
		this.value = x;
	}
	@Override
	public void run() {
		System.out.println(this.value);
	}

}
