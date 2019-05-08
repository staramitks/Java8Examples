package home.amit.java.basic.dataprovider;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
	
	public static List<Employee> getEmployees()
	{
		List<Employee> empList= new ArrayList<>();
		Employee emp1= new Employee();
		emp1.setAge(20);
		emp1.setName("Amit");
		emp1.setCity("Mumbai");
		emp1.setSalary(20000);
		emp1.setCompany("MSCI");
		
		Employee emp2= new Employee();
		emp2.setAge(21);
		emp2.setName("Amit1");
		emp2.setCity("Mumbai1");
		emp2.setSalary(210000);
		emp2.setCompany("MSCI");
		
		Employee emp3= new Employee();
		emp3.setAge(22);
		emp3.setName("Singh");
		emp3.setCity("Mumbai2");
		emp3.setSalary(220000);
		emp3.setCompany("BlackRock");
	
		Employee emp4= new Employee();
		emp4.setAge(23);
		emp4.setName("Kamal");
		emp4.setCity("Noida");
		emp4.setSalary(330000);
		emp4.setCompany("Greaves");
		
		Employee emp5= new Employee();
		emp5.setAge(28);
		emp5.setName("Shah");
		emp5.setCity("Mumbai");
		emp5.setSalary(205000);
		emp5.setCompany("Citi");
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		empList.add(emp4);
		empList.add(emp5);
		return empList;
	}
	
	public static List<Person> getPersons()
	{
		List<Person> personList= new ArrayList<>();
		Person emp1= new Person();
		emp1.setAge(20);
		emp1.setName("Amit");
		emp1.setCity("Mumbai");
		
		
		Person emp2= new Person();
		emp2.setAge(21);
		emp2.setName("Amit1");
		emp2.setCity("Mumbai1");
		
		
		Person emp3= new Person();
		emp3.setAge(22);
		emp3.setName("Singh");
		emp3.setCity("Mumbai2");
		
		Person emp4= new Person();
		emp4.setAge(23);
		emp4.setName("Kamal");
		emp4.setCity("Noida");
		
		Employee emp5= new Employee();
		emp5.setAge(28);
		emp5.setName("Shah");
		emp5.setCity("Mumbai");
		
		personList.add(emp1);
		personList.add(emp2);
		personList.add(emp3);
		personList.add(emp4);
		personList.add(emp5);
		return personList;
		
		
	}
	

}
