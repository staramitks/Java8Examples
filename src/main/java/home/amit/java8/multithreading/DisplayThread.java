package home.amit.java8.multithreading;

public class DisplayThread implements Runnable{

	private QueueDataThreadCoordinator queueDataHolder;
	
	
	public DisplayThread(QueueDataThreadCoordinator queueDataHolder) {
		
		this.queueDataHolder=queueDataHolder;
	}
	
	@Override
	public void run() {
	
		while (true)
		{
			boolean endFlag=false;
			if ((queueDataHolder.getDataObjectDTO().getDataQueue().peek()!=null) && (queueDataHolder.getDataObjectDTO().getDataQueue().peek().equalsIgnoreCase("FOE")))
			{
				endFlag=true;
			}
			
			queueDataHolder.displayElement();
			
			if (endFlag)
			{
				System.out.println("Exiting "+Thread.currentThread().getName());
				break;
			}
		}
	}

}
