package home.amit.java8.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapFlatMapExample {
	
	public static void main (String args[])
	{
		
		List<Integer> a = Arrays.asList(1,2,3);
		List<Integer> b = Arrays.asList(4,5);
		List<Integer> c = Arrays.asList(10,20);
		
		List<List<Integer>> allLists=Arrays.asList(a,b,c);
		
		System.out.println("Before Flatenning "+allLists);
		
		List<Integer> allInts=allLists.stream().flatMap(list->list.stream()).collect(Collectors.toList());
		
		System.out.println("After "+allInts);
	}

}
