package home.amit.java.basic.misc;

public enum ScriptExecutionStatus {
	
	TBD ,OK,NOK,RESOLVED_MANUALLY,EXITED;
	
	public String toString()
	{
		switch (this) {
		case TBD : return "TBD";
		case OK : return "OK";
		case NOK : return "NOK";
		case RESOLVED_MANUALLY : return "Manualy Resolved";
		case EXITED : return "EXITED";
		default : return "Unspecified";
		}
	}

}
