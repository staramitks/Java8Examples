package home.amit.java.basic.collections.hierarchy;

class HashMap {
	//unordered
	//unsynzhronized
	//allows null key as value
	//unsorted
	// implements Map , cloneable , serialiable
	//extends AbstractMap<K,V>
	
	//Treeify threshold if size of bins become too large or greater than treeify threshold - 8
	// untreeify threshold when size gets reduced to 6 
	// This guarantees O(logn)as search operation

}


class HashTable {
	//unordered
	//Synzhronized
	//does not allow null key as value
	//unsorted
	// implements extends Dictionary<K,V>, implements Map , cloneable , serialiable
	//extends AbstractMap<K,V>
	
	//Treeify threshold if size of bins become too large or greater than treeify threshold - 8
	// untreeify threshold when size gets reduced to 6 
	// This guarantees O(logn)as search operation

}

class IdentityHashMap{
	
//	This class implements the Map interface with a hash table, using reference-equality 
//	in place of object-equality when comparing keys (and values). In other words, in an 
//	IdentityHashMap, two keys k1 and k2 are considered equal if and only if (k1==k2). 
//	(In normal Map implementations (like HashMap) two keys k1 and k2 are considered equal 
//			if and only if (k1==null ? k2==null : k1.equals(k2)).)
//	This class is not a general-purpose Map implementation! While this class 
//	implements the Map interface, it intentionally violates Map's general
//	contract, which mandates the use of the equals method when comparing objects.
//	This class is designed for use only in the rare cases wherein reference-equality 
//	semantics are required.
//	
	
//	
//	public class IdentityHashMap<K,V>
//	extends AbstractMap<K,V>
//	implements Map<K,V>, Serializable, Cloneable
	
}



class WeakHaspMap{
	
//	public class WeakHashMap<K,V>
//	extends AbstractMap<K,V>
//	implements Map<K,V>
//	Hash table based implementation of the Map interface, with weak keys. 
//	An entry in a WeakHashMap will automatically be removed when its key is no longer 
//	in ordinary use. More precisely, the presence of a mapping for a given key will not 
//	prevent the key from being discarded by the garbage collector, that is, made finalizable,
//	finalized, and then reclaimed. When a key has been discarded its entry is effectively
//	
//	removed from the map, so this class behaves somewhat differently from other Map
//	implementations.
//	Both null values and the null key are supported. This class has performance characteristics
//	similar to those of the HashMap class, and has the same efficiency parameters of initial 
//	capacity and load factor.
//
//	Like most collection classes, this class is not synchronized. A synchronized WeakHashMap 
//	may be constructed using the Collections.synchronizedMap method.
//
//	This class is intended primarily for use with key objects whose equals methods test
//	for object identity using the == operator. Once such a key is discarded it can never be
//	recreated, so it is impossible to do a lookup of that key in a WeakHashMap at some 
//	later time and be surprised that its entry has been removed. 	
//	
	
}





class LinkedHashMap{
	
//	public class LinkedHashMap<K,V>
//	extends HashMap<K,V>
//	implements Map<K,V>
	
//	
//	java.lang.Object
//	 java.util.AbstractMap<K,V>
//	   java.util.HashMap<K,V>
//	      java.util.LinkedHashMap<K,V>
}

class TreeMap {
	//ordered by natural keys or by comparator interface implementation.
	//unsynzhronized
	//does not allow null key as value
	//unsorted
	// implements Map , cloneable , serialiable
	//extends AbstractMap<K,V>
	
	//Treeify threshold if size of bins become too large or greater than treeify threshold - 8
	// untreeify threshold when size gets reduced to 6 
	// This guarantees O(logn)as search operation

}
