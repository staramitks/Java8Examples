package home.amit.java.basic.abstractInterface;

public interface TestInterface {
	public Integer id=0;
	//private int year;
	
	public void hello();
	
	default int getResult() {
		int i=10;
		return i;
	}
	
	
}
