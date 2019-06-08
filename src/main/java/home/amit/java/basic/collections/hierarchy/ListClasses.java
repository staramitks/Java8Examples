package home.amit.java.basic.collections.hierarchy;

class ArrayList{ // implements List<E> , RandomAccess {

//RandomAccess is marker interface - supports fast constant access time
//insertion and deletion are slower compared to linked list
	
//	public class ArrayList<E> extends AbstractList<E>
  //  implements List<E>, RandomAccess, Cloneable, java.io.Serializable

}


class Vector { //implements List<E> , Random Access
	
//Thread safe 
//random access
	
	
//	public class Vector<E>
//    extends AbstractList<E>
//    implements List<E>, RandomAccess, Cloneable, java.io.Serializable
}

class LinkedList { //implements List<E>, DeQueue, Cloneable, Serializable
	
//Elements are doubly linked forward and backward
	//iteration slower than arrayList
	// insertion and deltion faster
	//supports queue operation like peek , poll etc
	//unsynchronized 
	//public class LinkedList<E>
  //  extends AbstractSequentialList<E>
  //  implements List<E>, Deque<E>, Cloneable, java.io.Serializable
	
	
	//fail fast iterator gives concurrentmodificationexception
}