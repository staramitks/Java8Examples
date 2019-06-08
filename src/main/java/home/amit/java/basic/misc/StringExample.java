package home.amit.java.basic.misc;


/*
 * 
 * intern will create string object in the pool if it doesn not exist
 * If already exists then it will return reference of matching string
 * 
 * 
 */
public class StringExample {
	
	public static void main (String args[])
	{
		
		String s1= new String ("Java");
		
		String s2=s1.intern();
		String s3="Java";
		
		if (s1==s2)
		{
			System.out.println("Addresses matched");
		}
		else
		{
			System.out.println("Addresses failed to match");
		}
		
		if (s2==s3)
		{
			System.out.println("s2 and s3 matched");
		}
		
		
	}

}
