package home.amit.java8.multithreading;

public class ConsumerThread implements Runnable {

	CubbyHole cubbyhole ;
	int num;
	public ConsumerThread(CubbyHole hole, int number)
	{
		this.cubbyhole=hole;
		this.num=number;
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int value=0;
		for (int i = 0; i < 10; i++) {
	         value = cubbyhole.get();
	         System.out.println("Consumer #" + this.num + " got: " + value);
	      }
		}

}
