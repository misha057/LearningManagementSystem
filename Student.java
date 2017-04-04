import java.util.ArrayList;
import java.util.Collection;

public class Student {
    private int ID;
    private String firstName;
    private String lastName;
    private int age;
    private Collection<Integer> enrollment;

    public Student(){
        enrollment = new ArrayList<>();
    }

    public void clearEnrollment() {
        this.enrollment.clear();
    }

    public void addEnrollment(Integer enrollment) {
        this.enrollment.add(enrollment);
    }

//    public Collection<Integer> getEnrollment() {
//        return enrollment;
//    } //TODO encapsulation

//    public String getFirstName() {
//        return firstName;
//    }

//    public String getLastName() {
//        return lastName;
//    }

//    public int getAge() {
//        return age;
//    }

    public void setID(int ID){
        this.ID = ID;
    }

//    public int getID() {
//        return ID;
//    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ID " + ID + ": " + firstName + " " + lastName + ", " +
                "age " + age + ", " + "enrollment " + enrollment + ".\n";
    }
}
