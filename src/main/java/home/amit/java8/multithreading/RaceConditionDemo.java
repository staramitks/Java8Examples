package home.amit.java8.multithreading;
/*
 * 
 * Drawback of using synchronization in java
 * it can introdue thread contention, it can occur when two or more threads try to 
 * access the same resource simultaneously 
 * and cause java runtime to execute one or more threads slowly 
 * Thread Starvation and livelock are forms of thead contention
 * 
 * 
 * 
 */
class Counter  implements Runnable{
    private int c = 0;

    public void increment() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        c++;
    }

    public void decrement() {    
        c--;
    }

    public int getValue() {
        return c;
    }
    
    @Override
    public void run() {
        //incrementing
    	synchronized(this)
    	{
        this.increment();
        System.out.println("Value for Thread After increment " 
        + Thread.currentThread().getName() + " " + this.getValue());
        //decrementing
        this.decrement();
        System.out.println("Value for Thread at last " 
        + Thread.currentThread().getName() + " " + this.getValue());      
    	}
    }
}

public class RaceConditionDemo{
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(counter, "Thread-1");
        Thread t2 = new Thread(counter, "Thread-2");
        Thread t3 = new Thread(counter, "Thread-3");
        t1.start();
        t2.start();
        t3.start();
    }    
}