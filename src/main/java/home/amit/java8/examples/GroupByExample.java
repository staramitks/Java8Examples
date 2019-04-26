package home.amit.java8.examples;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.groupingByConcurrent;

public class GroupByExample {
	
	public static void main (String... args)
	{
		
		EmployeeDTO emp= new EmployeeDTO();
		List<EmployeeDTO> employeesList = emp.getEmployeesList();
		
		Map<String,List<EmployeeDTO>> cityGroupMap= new HashMap<>();
		
		cityGroupMap=employeesList.stream().collect(Collectors.groupingBy(EmployeeDTO::getCity));
		cityGroupMap.keySet().stream().forEach(System.out::println);
		
		
		System.out.println("Parallel Stream");
		Map<String,List<EmployeeDTO>> cityGroupConcurrentMap= employeesList.parallelStream().collect(Collectors.groupingByConcurrent(EmployeeDTO::getCity));;
		cityGroupConcurrentMap.keySet().stream().forEach(System.out::println);
		
		
		System.out.println("Gourping by average age");
		
				ConcurrentMap<String, Double> collectDblMap = employeesList.parallelStream().collect(groupingByConcurrent(EmployeeDTO::getCity,averagingInt(EmployeeDTO::getAge)));
				collectDblMap.keySet().stream().forEach(System.out::println);
				collectDblMap.values().stream().forEach(System.out::println);
		
		System.out.println("Sum of age by city ");
		
		ConcurrentMap<String, Integer> cityAgeSumMap = employeesList.parallelStream().collect(groupingByConcurrent(EmployeeDTO::getCity,Collectors.summingInt(EmployeeDTO::getAge)));
		
		cityAgeSumMap.values().stream().forEach(System.out::println);

	}

}
