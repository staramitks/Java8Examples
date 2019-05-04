package home.amit.java8.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class DataObjectDTO {
	
	private BlockingQueue<String> dataQueue= new ArrayBlockingQueue<String>(1);
	private boolean reverseFlag=false;
	public DataObjectDTO(BlockingQueue<String> dataQueue,boolean reverseFlag )
	{
		this.dataQueue=dataQueue;
		this.reverseFlag=reverseFlag;
		
	}
	/**
	 * @return the dataQueue
	 */
	public BlockingQueue<String> getDataQueue() {
		return dataQueue;
	}
	/**
	 * @param dataQueue the dataQueue to set
	 */
	public void setDataQueue(BlockingQueue<String> dataQueue) {
		this.dataQueue = dataQueue;
	}
	/**
	 * @return the reverseFlag
	 */
	public boolean isReverseFlag() {
		return reverseFlag;
	}
	/**
	 * @param reverseFlag the reverseFlag to set
	 */
	public void setReverseFlag(boolean reverseFlag) {
		this.reverseFlag = reverseFlag;
	}

}
