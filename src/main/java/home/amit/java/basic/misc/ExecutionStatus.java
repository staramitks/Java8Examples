package home.amit.java.basic.misc;

public enum ExecutionStatus {
	
	TBD ("TBD"),
	OK("OK"),
	NOK("NOK"),
	RESOLVED_MANUALLY("Resolved Manually"),
	EXITED("EXITED");
	
	private String status;
	
	ExecutionStatus(String stat)
	{
	 status=stat;	
	}

	public String getStatus() {
		return status;
	}

}
