package home.amit.java8.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SquaringIntegerLambda {
	
	public static void main (String... args)
	{
		List<Integer> intList= new ArrayList<>();
		intList.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,12,13,1,4,15,16,17,18,19,20));
		
		List<Integer> sqrdList=intList.parallelStream()
									  .map(x->x*x)
									  .collect(Collectors.toList());
		System.out.println("Initial List");
		intList.forEach(x->System.out.print(x+","));
		System.out.println("Squared List");
		sqrdList.forEach(x->System.out.print(x+","));
		
		
		System.out.println("Converted  List");
		Function<Integer,String> converterFunction=x->String.valueOf(x);       
		List<String> collectStrList = intList.stream().map(converterFunction)
		.collect(Collectors.toList());
		
		collectStrList.forEach(x->System.out.print(x+","));
		
		
		
		
		
	}

}
