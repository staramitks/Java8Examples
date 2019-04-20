package home.amit.java8.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class DataHolder {
	
	private BlockingQueue<Integer> queue= new ArrayBlockingQueue<Integer>(1);
	private volatile boolean exitFlag=false;
	public DataHolder( BlockingQueue<Integer> queue )
	{
		this.queue=queue;
	}
	
	public  int getOddNumber()
	{
		int value=0;
		synchronized(this)
		{
		while ( queue.peek() !=null && queue.peek()%2==1)
		{
			
			System.out.println( "Thread Name is "+Thread.currentThread().getName() +" and must poll odd number "+queue.peek());
			value=queue.poll();
			if (value==99)
			{
				notifyAll();
				break;
			}
			notifyAll();
			
		 }
		if (value<99)
		 {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		}
		
		return value;
	}


	public  int getEvenNumber()
	{
		int value=0;
		synchronized(this)
		{
		while ( queue.peek() !=null && queue.peek()%2==0)
		{
			
			System.out.println( "Thread Name is "+Thread.currentThread().getName() +" and must poll  even  number "+queue.peek());
			value=queue.poll();
			if (value==100)
			{
				break;
			}
			notifyAll();
			
		}
		if (value<100)
		{
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		}		
		
		}
		
		return value;
	}

   
	public  void addNumber(int num)
	{
		if (num>100)
		{
			return ;
		}
		synchronized(this)
		{
			while (this.queue.isEmpty())
			{
			System.out.println("Adding number "+num);
			this.queue.add(num);
			notifyAll();
			if (num==100)
			{
				break;
			}
			
			}
			if (num<100)
			{
			
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notifyAll();

		}
		}
	
	}
	

}
