package home.amit.java.basic.immutable;

public final class CorrectAge implements Cloneable {
    private final int day;
    private final int month;
    private final int year;
    
    public CorrectAge(int day,int month,int year)
    {
    	this.day=day;
    	this.month=month;
    	this.year=year;
    	
    }
    public int getDay() {
        return day;
    }
    
    public int getMonth() {
    return month;
    }
    
    public int getYear() {
    return year;
    }
    public Object clone() throws CloneNotSupportedException{  
    	return (CorrectAge)super.clone();  
       }
}