package home.amit.java8.multithreading;

import java.util.Scanner;

public class InputThread implements Runnable{

	private QueueDataThreadCoordinator queueDataHolder;
	private Scanner scan=null;
	String inputString;
	
	public InputThread(QueueDataThreadCoordinator queueDataHolder) {
		
		this.queueDataHolder=queueDataHolder;
	}
	
	@Override
	public void run() {
		
		while (true)
		{
			scan= new Scanner(System.in);
				if (scan.hasNext() )
				{
					inputString=scan.next();
					queueDataHolder.addElement(inputString);
				}
				
				if (inputString.equalsIgnoreCase("EOF"))
				{
					System.out.println("Exiting "+Thread.currentThread().getName());
					break;
				}
		}
		
	}

}
