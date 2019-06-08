package home.amit.java.basic.exceptionHandling;

public class CheckReturnType {
	
	public int checkReturnType() {
		
		
		try {
			return 1;
		}
		catch (Exception e)
		{
			return 2;
		}
		finally 
		{
			return 3;
		}
		//return 4;
	}
	
	public static void main (String args[])
	{
		CheckReturnType checkReturnType= new CheckReturnType();
		int val = checkReturnType.checkReturnType();
		System.out.println("Value is "+val);
	}
	

}
