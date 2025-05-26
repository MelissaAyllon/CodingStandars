import java.util.*;

class Student {
    String id;
    String name;
    List<Double> gradez;
    String pass = "unknown";
    String honor;
    String avg;
    String honorRoll;

    public Student(String id, String name){
        this.id = id;
        this.name = name;
        gradez = new ArrayList<>();
    }

    public void addG(Double grade) {
        if (grade != null && grade >= 0 && grade <= 100) {
            gradez.add(grade);
        } else {
            throw new IllegalArgumentException("Grade must be between 0 and 100.");
        }
    }
    

    public double average() {
        double total = 0;
        for (Double grade : gradez) {
            total += grade;
        }
        if (gradez.isEmpty()) {
            return 0; // Avoid division by zero
        }
        return total / gradez.size();
    }
    
    public String getLetterGrade() {
        double average = average();
        if (average >= 90) {
            this.avg = "A";
        } else if (average >= 80) {
            this.avg = "B";
        } else if (average >= 70) {
            this.avg = "C";
        } else if (average >= 60) {
            this.avg = "D";
        } else {
            this.avg = "F";
        }
        return this.avg;
    }

    public String determinePassFail() {
        double average = average();
        if (average >= 60) {
            return "Passed";
        } else {
            return "Failed";
        }
    }
    

    public void checkHonorStatus(){
        if (average() > 90){
            honor = "yes";
        }
    }

    public String isOnHonorRoll() {
        this.honorRoll = average() >= 90 ? "Yes" : "No";
        return this.honorRoll;
    }

    public boolean removeGrade(int i) {
        if (i >= 0 && i < gradez.size()) {
            gradez.remove(i);
            return true;
        } else {
            System.out.println("Invalid index: " + i);
            return false;
        }
    }
    
    
    public boolean removeGradeByValue(double value) {
        boolean removed = gradez.remove(value);
        if (!removed) {
            System.out.println("Grade value not found: " + value);
        }
        return removed;
    }
    
    public void reportCard(){

        System.out.println("===== Student Summary Report =====");
        System.out.println("Student: " + this.name);
        System.out.println("ID: " + this.id);
        System.out.println("Grades #: " + this.gradez.size());
        System.out.println("Average: " + average());
        System.out.println("Letter Grade  : " + this.avg);
        System.out.println("Honor Roll: " + honorRoll);
    }
}
public class Main {
    public static void main(String[] args){
        Student student = new Student("0001", "Melissa");
        student.addG(100.0);
        student.addG(90.0);
        student.average();
        student.checkHonorStatus();
        student.removeGrade(9);
        student.reportCard();
    }
}