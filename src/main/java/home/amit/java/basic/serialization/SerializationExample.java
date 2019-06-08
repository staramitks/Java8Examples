package home.amit.java.basic.serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializationExample{  
	 public static void main(String args[])throws Exception{  
	  Student s1 =new Student(211,"ravi","Bharat");  
	  
	  FileOutputStream fout=new FileOutputStream("C:\\Amit\\Project\\f.txt");  
	  ObjectOutputStream out=new ObjectOutputStream(fout);  
	  
	  out.writeObject(s1);  
	  out.flush();  
	  System.out.println("success");  
	 }  
	} 