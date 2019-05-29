package home.amit.java8.defaultexamples;


/*
 * 
 * Resolution Rules
 * 1- Classes always win- Method declared in class takes priority over others
 * 2- Subinterfaces win , if B extends A then B wins
 * 3- If choice is till ambiguous then class inheriting from multiple interfaces has to 
 * explicitl tell which default method implementation to use for overriding
 */
public interface B extends A {
	default void hello()
	{
		System.out.println("Hello from B");
	}
}
