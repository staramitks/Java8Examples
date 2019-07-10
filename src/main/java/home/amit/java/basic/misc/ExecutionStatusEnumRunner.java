package home.amit.java.basic.misc;

public class ExecutionStatusEnumRunner {
	
	public static void  main (String args[])
	{
		
		
		String status="TBD";
		
		if (status.equalsIgnoreCase(ExecutionStatus.RESOLVED_MANUALLY.getStatus()))
		{
			
			System.out.println("Matched");
		}
		
		if (status.equalsIgnoreCase(ScriptExecutionStatus.TBD.toString()))
		{
			System.out.println("THis worked as well");
		}
	}
	

}
