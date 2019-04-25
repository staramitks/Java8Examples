package home.amit.java.basic.immutable;

/*
 * If returning List of objects then 
 * return unmodifiableCollection from Collections.unmodifiableCollection(List) 
 * or use new ArrayList<>(list);
 * 
 *  //Default version of clone() method. It creates shallow copy of an object.
 

 * 
 * 
 */


public final class CorrectImmutableStudent {
    private final int id;
    private final String name;
    private final Age age;
    public CorrectImmutableStudent(int id, String name, Age age) {
    this.name = name;
    this.id = id;
    Age clonedAge= new Age();
    clonedAge.setDay(age.getDay());
    clonedAge.setMonth(age.getMonth());
    clonedAge.setYear(age.getYear());
    this.age = clonedAge;
    }
    public int getId() {
    return id;
    }
    public String getName() {
    return name;
    }
    public Age getAge() {
    	Age clonedAge= new Age();
        clonedAge.setDay(this.age.getDay());
        clonedAge.setMonth(this.age.getMonth());
        clonedAge.setYear(this.age.getYear());

    	
    	return clonedAge;
    }
    
    public static void main(String[] args) {
        Age age = new Age();
        age.setDay(1);
        age.setMonth(1);
        age.setYear(1992);
        CorrectImmutableStudent student = new CorrectImmutableStudent(1, "Alex", age);
        System.out.println("Alex age year before modification = " + student.getAge().getYear());
        age.setYear(1993);
        
        student.getAge().setYear(1994);
        System.out.println("Alex age year after modification = " + student.getAge().getYear());
    }
}