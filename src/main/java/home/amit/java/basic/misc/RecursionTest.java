package home.amit.java.basic.misc;

public class RecursionTest {
	
	public static void main (String args[])
	{
		
		RecursionTest recursionTest= new RecursionTest();
		Integer finalDelay = recursionTest.getDelay(0,2);
		System.out.println("Final Delay is "+finalDelay);
		
		
	}

	
	private Integer getDelay(Integer delay, Integer counter)
	{
		System.out.println("Counter is "+counter);
		if (delay>=300)
		{
			return delay;
		}
		else
		{
			delay=delay+60;
			System.out.println("Calling for "+delay + " and counter "+counter);
			return this.getDelay(delay, counter--);
		}
		
	}
}
