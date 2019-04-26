package home.amit.java.basic.misc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import javafx.scene.shape.Path;

public class ReadBigFile {
	
	public static void main (String args[])
	{
		
		String path="C:\\Amit\\Project\\TestFile.txt.txt";
		
		
		FileInputStream inputStream = null;
		Scanner sc = null;
		Runtime.getRuntime().freeMemory();
		System.out.println("Free Memory is "+Runtime.getRuntime().freeMemory());
		try {
		    try {
				inputStream = new FileInputStream(path);
				List<String> readAllLines = Files.readAllLines(Paths.get(path), Charset.defaultCharset());
				int size=readAllLines.size();
				System.out.println("Total lines is "+size);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    sc = new Scanner(inputStream, "UTF-8");
		    while (sc.hasNextLine()) {
		        String line = sc.nextLine();
		       //  System.out.println(line);
		    }
		    // note that Scanner suppresses exceptions
		    if (sc.ioException() != null) {
		        throw sc.ioException();
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    if (inputStream != null) {
		        try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		    if (sc != null) {
		        sc.close();
		    }
		}
		
		
		System.out.println("Free Memory After is "+Runtime.getRuntime().freeMemory());
	}

}
