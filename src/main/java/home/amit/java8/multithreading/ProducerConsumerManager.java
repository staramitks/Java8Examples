/**
 * 
 */
package home.amit.java8.multithreading;

/**
 * @author amit singh
 *
 */
public class ProducerConsumerManager {
	
	private ProducerDataHolder producerDataHolder;
	Integer val= new Integer(2);
	
	public ProducerConsumerManager(ProducerDataHolder producerDataHolder)
	{
		this.producerDataHolder=producerDataHolder;
	}
	
	
	
	public synchronized void produceNumber()
	{
		while (true)
		{
			if (!producerDataHolder.getDataHolder().isEmpty())
			{
				try {
					this.wait(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Breaking now after waiting for 3 seconds");
					break;
				}
			}
			else
			{
				Integer addNum=val++;
				producerDataHolder.getDataHolder().add(addNum);
				System.out.println("Produced Number "+addNum);
				notify();
				if (addNum==10)
				{
					System.out.println("Breaking now after producing 10 number ");
					break;
				}
			}
			
			try {
				//System.out.println("Sleeping for 1 seconds before next iteration");
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * 
	 */
	public synchronized void  consumeNumber() {
		while (true)
		{
			if (producerDataHolder.getDataHolder().isEmpty())
			{
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				Integer consumeNumber=producerDataHolder.getDataHolder().poll();
				System.out.println("Consumed Number "+consumeNumber);
				if (consumeNumber==10)
				{
					System.out.println("Breaking now after consuming 10th number");
					break;
				}
				notify();
			}
			
			try {
				//System.out.println("Sleeping for 1 seconds before next consumption");
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
