package home.amit.java8.multithreading;

public class ProducerConsumerExample {
public static void main (String... args)
{
	
	CubbyHole hole=new CubbyHole();
	ProducerThread prod=new ProducerThread(hole,1);
	ConsumerThread consumer=new ConsumerThread(hole,1);
	Thread producerThread=new Thread(prod);
	Thread consumerThread=new Thread(consumer);
	producerThread.start();
	consumerThread.start();
	
//	try {
//		producerThread.join();
//		consumerThread.join();
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
}
}
