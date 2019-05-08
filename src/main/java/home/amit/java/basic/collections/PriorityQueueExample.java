package home.amit.java.basic.collections;

import java.util.List;
import java.util.PriorityQueue;

import home.amit.java.basic.dataprovider.DataProvider;
import home.amit.java.basic.dataprovider.Employee;


/*
 * 
 * A PriorityQueue is used when the objects are supposed to be processed based on the priority. 
 * It is known that a queue follows First-In-First-Out algorithm, 
 * but sometimes the elements of the queue are needed to be processed according to the priority,
 * that’s when the PriorityQueue comes into play. 
 * The PriorityQueue is based on the priority heap. 
 * The elements of the priority queue are ordered according to the natural ordering,
 * or by a Comparator provided at queue construction time, 
 * depending on which constructor is used
 * 
 * 
 */

public class PriorityQueueExample {
	
	public static void main (String... args)
	{
		
		PriorityQueue<Employee> empPriorityQueue= new PriorityQueue<Employee>((e1, e2)->e2.getAge()-e1.getAge());
		List<Employee> employees = DataProvider.getEmployees();
		employees.stream().forEach(e->empPriorityQueue.add(e));
		System.out.println("Length is "+empPriorityQueue.size());
		System.out.println("Top element is "+empPriorityQueue.peek().getAge());
		empPriorityQueue.poll();
		System.out.println("Second element is "+empPriorityQueue.peek().getAge());
		
		
		
		
	}

}
