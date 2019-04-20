package home.amit.java8.multithreading;

public class ProducerThread implements Runnable {

	CubbyHole cubbyhole ;
	int num;
	public ProducerThread(CubbyHole hole, int number)
	{
		this.cubbyhole=hole;
		this.num=number;
		
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
	         cubbyhole.put(i);
	         System.out.println("Producer #" + this.num + " put: " + i);
	         try {
	            Thread.sleep((int)(Math.random() * 100));
	         } catch (InterruptedException e) { }
	      } 
	}

}
