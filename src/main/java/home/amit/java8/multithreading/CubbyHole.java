package home.amit.java8.multithreading;

public class CubbyHole {
	private int contents;
	private boolean slotAvailable=true;
	
	public synchronized void put (int value)
	{
		while (slotAvailable==false)
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		slotAvailable=false;
		contents=value;
		System.out.println("Put values "+value);
		notifyAll();
		
	}

	public synchronized int get()
	{
		while (slotAvailable==true)
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		slotAvailable=true;
		notifyAll();
		System.out.println("Contents got is "+contents);
		return contents;
		
	}
}
