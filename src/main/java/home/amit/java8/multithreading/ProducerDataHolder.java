package home.amit.java8.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author singami2
 *
 */
public class ProducerDataHolder {
	
	
	private BlockingQueue<Integer> dataHolder= new ArrayBlockingQueue<>(1);
	
	
	public ProducerDataHolder(BlockingQueue<Integer> blockingQueue)
	{
		this.setDataHolder(blockingQueue);
	}


	public BlockingQueue<Integer> getDataHolder() {
		return dataHolder;
	}


	public void setDataHolder(BlockingQueue<Integer> dataHolder) {
		this.dataHolder = dataHolder;
	}

}
