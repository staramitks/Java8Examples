/**
 * 
 */
package home.amit.java.basic.abstractInterface;

/**
 * @author Amit Singh
 * 
 * Abstract class is almost like a any other java class with key differences are
 * 1- It cannot be instantiated
 * 2- Its name contains abstract before class key word like public abstract class testAbstractClass
 * 3- It can extend other classes and implement other interfaces - 
 * However it is  not required to implementation of functions in interfaces
 *
 */
public abstract class TestAbstract extends TestClass implements TestInterface,InterfaceB{
	
	
	
	private int privateId;
	private String name;
	
	
//	private TestAbstract() {}
//	
	public TestAbstract() {}
	
	public abstract void sayHello() ;
	
	public void sayHello(String str)
	{
		System.out.println("Hello World for "+str);
	}
	
	private int getResult(int in)
	{
		int i =10;
		return i;
	}
	
	
	public final void setProcess()
	{
		this.getResult(20);
		System.out.println("Inside set process");
	}
	
	

}
