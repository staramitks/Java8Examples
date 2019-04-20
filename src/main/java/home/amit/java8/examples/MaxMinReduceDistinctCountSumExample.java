package home.amit.java8.examples;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MaxMinReduceDistinctCountSumExample {
	
	private List<Integer> testList= Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,1,2,3,4,5,1,2,3,45);
	public int getMax()
	{
		Optional<Integer> maxVal = testList.stream().reduce(Integer::max);
		System.out.println("Max Val is "+maxVal.get());
		return maxVal.get();
	}

	public int getMin()
	{
		Optional<Integer> minVal = testList.stream().reduce(Integer::min);
		System.out.println("Min Val is "+minVal.get());
		return 0;
	}

	public int getReduce()
	{
		Optional<Integer> sumVal = testList.stream().reduce(Integer::sum);
		System.out.println("Sum Val is "+sumVal.get());
		return 0;
	}

	public int getDistinct()
	{
		long count = testList.parallelStream()
				.distinct()
				.count();
		
		System.out.println("Distinct Count is "+count);
		return 0;
	}

	public int getCount()
	{
		long count = testList.parallelStream()
				.count();
		System.out.println("total Count is "+count);
		
		return 0;
	}

	public int getSum()
	{
		return 0;
	}

	
	public static void main (String... args)
	{
		MaxMinReduceDistinctCountSumExample lMaxMinReduceDistinctCountSumExample= new MaxMinReduceDistinctCountSumExample();
		lMaxMinReduceDistinctCountSumExample.getCount();
		lMaxMinReduceDistinctCountSumExample.getMax();
		lMaxMinReduceDistinctCountSumExample.getMin();
		lMaxMinReduceDistinctCountSumExample.getSum();
		lMaxMinReduceDistinctCountSumExample.getDistinct();
		lMaxMinReduceDistinctCountSumExample.getReduce();
	}
}
