package home.amit.java.basic.collections;

import java.util.ArrayList;

public class MyList<E> extends ArrayList<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4168656976239448163L;
	
	@Override
	public boolean add(E element)
	{
		boolean b=false;
		
		ensureCapacity(10);
		
		return b;
		
	}
}
