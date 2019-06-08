package home.amit.java8.multithreading;

//Java code to illustrate Reentrant Locks 


/*
 * 
 * Lock: This is the base interface for Lock API. It provides all the features 
 * of synchronized keyword with additional ways to create different Conditions for 
 * locking, providing timeout for thread to wait for lock. Some of the important methods are lock() to acquire the lock, unlock() to release the lock, tryLock() to wait for lock for a certain period of time, newCondition() to create the Condition etc.
Condition: Condition objects are similar to Object wait-notify model 
with additional feature to create different sets of wait.
 A Condition object is always created by Lock object.
  Some of the important methods are await() that is similar to wait() and signal(), 
  signalAll() that is similar to notify() and notifyAll() methods.
ReadWriteLock: It contains a pair of associated locks, one for read-only operations 
and another one for writing. The read lock may be held simultaneously by multiple 
reader threads as long as there are no writer threads. 
The write lock is exclusive.
ReentrantLock: This is the most widely used implementation class of Lock interface. This class implements the Lock interface in similar way as synchronized keyword. Apart from Lock interface implementation, ReentrantLock contains some utility methods to get the thread holding the lock, threads waiting to acquire the lock etc.
synchronized block are reentrant in nature i.e if a thread has lock on the monitor object and if another synchronized block requires to have the lock on the same monitor object then thread can enter that code block. I think this is the reason for the class name to be ReentrantLock
 * 
 * 
 * public interface Lock {
  void lock();

  Condition newCondition();

  void lockInterruptibly() throws InterruptedException;

  boolean tryLock();

  boolean tryLock(long time, TimeUnit unit) throws InterruptedException;

  void unlock();
}
 */
import java.text.SimpleDateFormat; 
import java.util.Date; 
import java.util.concurrent.ExecutorService; 
import java.util.concurrent.Executors; 
import java.util.concurrent.locks.ReentrantLock; 

class worker implements Runnable 
{ 
String name; 
ReentrantLock re; 
public worker(ReentrantLock rl, String n) 
{ 
	re = rl; 
	name = n; 
} 
public void run() 
{ 
	boolean done = false; 
	while (!done) 
	{ 
	//Getting Outer Lock 
	boolean ans = re.tryLock(); 

	// Returns True if lock is free 
	if(ans) 
	{ 
		try
		{ 
		Date d = new Date(); 
		SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss"); 
		System.out.println("task name - "+ name 
					+ " outer lock acquired at "
					+ ft.format(d) 
					+ " Doing outer work"); 
		Thread.sleep(1500); 

		// Getting Inner Lock 
		re.lock(); 
		try
		{ 
			d = new Date(); 
			ft = new SimpleDateFormat("hh:mm:ss"); 
			System.out.println("task name - "+ name 
					+ " inner lock acquired at "
					+ ft.format(d) 
					+ " Doing inner work"); 
			System.out.println("Lock Hold Count - "+ re.getHoldCount()); 
			Thread.sleep(1500); 
		} 
		catch(InterruptedException e) 
		{ 
			e.printStackTrace(); 
		} 
		finally
		{ 
			//Inner lock release 
			System.out.println("task name - " + name + 
					" releasing inner lock"); 

			re.unlock(); 
		} 
		System.out.println("Lock Hold Count - " + re.getHoldCount()); 
		System.out.println("task name - " + name + " work done"); 

		done = true; 
		} 
		catch(InterruptedException e) 
		{ 
		e.printStackTrace(); 
		} 
		finally
		{ 
		//Outer lock release 
		System.out.println("task name - " + name + 
					" releasing outer lock"); 

		re.unlock(); 
		System.out.println("Lock Hold Count - " + 
					re.getHoldCount()); 
		} 
	} 
	else
	{ 
		System.out.println("task name - " + name + 
					" waiting for lock"); 
		try
		{ 
		Thread.sleep(1000); 
		} 
		catch(InterruptedException e) 
		{ 
		e.printStackTrace(); 
		} 
	} 
	} 
} 
} 

public class ReEntrantLockExample 
{ 
static final int MAX_T = 2; 
public static void main(String[] args) 
{ 
	ReentrantLock rel = new ReentrantLock(); 
	ExecutorService pool = Executors.newFixedThreadPool(MAX_T); 
	Runnable w1 = new worker(rel, "Job1"); 
	Runnable w2 = new worker(rel, "Job2"); 
	Runnable w3 = new worker(rel, "Job3"); 
	Runnable w4 = new worker(rel, "Job4"); 
	pool.execute(w1); 
	pool.execute(w2); 
	pool.execute(w3); 
	pool.execute(w4); 
	pool.shutdown(); 
} 
} 
