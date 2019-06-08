/**
 * 
 */
package home.amit.java8.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author singami2
 *
 */
public class ProducerConsumerRunner {
	
	public static void main (String args[])
	{
		
		BlockingQueue<Integer> dataholder=new ArrayBlockingQueue<>(1);
		dataholder.add(1);
		ProducerDataHolder producerDataHolder= new ProducerDataHolder(dataholder);
		
		ProducerConsumerManager producerConsumerManager= new ProducerConsumerManager(producerDataHolder);
		
		Thread producerThread=new Thread( new Runnable(){
			@Override
			public void run() {
				producerConsumerManager.produceNumber();
			}
		}) ;
		Thread consumerThread=new Thread( new Runnable(){
			@Override
			public void run() {
				producerConsumerManager.consumeNumber();
			}
		}) ;
		
		callViaExecutorService(producerThread,consumerThread);
		
		callViaThreadInvocation(producerThread,consumerThread);
		
		callViaCompletableFuture(producerThread,consumerThread);
		
		//List<Future<String>> futures = executorService.invokeAll(callableTasks);
	
		
	}

	/**
	 * @param producerThread
	 * @param consumerThread
	 */
	private static void callViaCompletableFuture(Thread producerThread,Thread consumerThread) {
		// TODO Auto-generated method stub
		
		CompletableFuture<Void> producer= CompletableFuture.runAsync(producerThread);
		CompletableFuture<Void> consumer= CompletableFuture.runAsync(consumerThread);
		try {
			producer.get();
			consumer.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @param producerThread
	 * @param consumerThread
	 */
	private static void callViaThreadInvocation(Thread producerThread,Thread consumerThread) {
		producerThread.start();
		consumerThread.start();
		
		
	}

	/**
	 * @param producerThread
	 * @param consumerThread
	 */
	private static void callViaExecutorService(Thread producerThread,
			Thread consumerThread) {
		// TODO Auto-generated method stub
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		List<Runnable> runnableTasks=new ArrayList<>();
		
		Future<?> producer = executorService.submit(producerThread);
		Future<?> consumer = executorService.submit(consumerThread);
		executorService.shutdown();
		
	}
	
	

}
