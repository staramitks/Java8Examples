package home.amit.java8.defaultexamples;

public interface A {
	
	default void hello()
	{
		System.out.println("Hello from A");
	}

}
