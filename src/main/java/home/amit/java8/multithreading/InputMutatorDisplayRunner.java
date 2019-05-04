package home.amit.java8.multithreading;
 import java.util.concurrent.ArrayBlockingQueue;

public class InputMutatorDisplayRunner {
	
	public static void main (String args[])
	{
		
		QueueDataThreadCoordinator queueDataHolder= new QueueDataThreadCoordinator(new DataObjectDTO(new ArrayBlockingQueue<String>(1), false));
		
		Thread inputThread= new Thread(new InputThread(queueDataHolder), "Input");
		Thread reverseThread= new Thread(new MutatorThread(queueDataHolder), "Mutator");
		Thread displayThread= new Thread(new DisplayThread(queueDataHolder), "Display");
		inputThread.start();
		reverseThread.start();
		displayThread.start();
		
		
	}

}
