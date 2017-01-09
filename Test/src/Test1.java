
public class Test1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Singleton singleton = Singleton.getInstance();	
		singleton.increment_x(2);
		singleton.increment_x(3);
		
		Thread.sleep(4 * 1000);
		singleton.increment_x(4);
		
		Thread.sleep(10 * 1000);
		singleton.increment_x(5);
		singleton.increment_x(6);
		
		Thread.sleep(10 * 1000);
		singleton.increment_x(7);
		singleton.increment_x(8);
	}
}
