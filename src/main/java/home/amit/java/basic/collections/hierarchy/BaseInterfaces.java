package home.amit.java.basic.collections.hierarchy;

public class BaseInterfaces {

}


interface Collection<E> extends Iterable<E>
{
	
}

interface Set<E> extends Collection<E>
{
	//unique objects only do not allow duplication
	
}

interface List<E> extends Collection<E>
{
	//List of things
	//if element is added without specifying position then it is added at the end of list
	// Index Based
	// Retrieval etc is faster due to indexing of position
}

interface Queue<E> extends Collection<E>
{

		//Usually arranged in order - like some todo list
		//if element is added without specifying position then it is added at the end of list
		// Index Based
		// Retrieval etc is faster due to indexing of position

	
}

interface Map<K,V> {
	
//	Key Value based
}
