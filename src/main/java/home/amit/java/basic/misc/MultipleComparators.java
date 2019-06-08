package home.amit.java.basic.misc;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import home.amit.java.basic.dataprovider.DataProvider;
import home.amit.java.basic.dataprovider.Employee;

public class MultipleComparators {
	
	public static void main (String args[])
	{
		
		 List<Employee> employees = DataProvider.getEmployees();
		 
		 
		 Collections.sort(employees,Comparator.comparing(Employee::getAge).thenComparing(Employee::getName));
		 //or 
		 List<Employee> sorted = employees.stream().sorted(Comparator.comparing(Employee::getAge).thenComparing(Employee::getName)).collect(Collectors.toList());
		 
		 sorted.forEach(e->System.out.println(e.getName() +" "+e.getAge()));
		 
		 
		
		
	}

}
