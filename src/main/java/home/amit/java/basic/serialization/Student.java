package home.amit.java.basic.serialization;

import java.io.Serializable;

public class Student implements Serializable{  
	 /**
	 * 
	 */
	private static final long serialVersionUID = 5018160971934285428L;
	int id;  
	 String name;  
	 static String city="Agra";
	 transient String placeOfWork="Mumbai";
	 public Student(int id, String name,String placeOfWork) {  
	  this.id = id;  
	  this.name = name;  
	  this.placeOfWork=placeOfWork;
	 }  
	}