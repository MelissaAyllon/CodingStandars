import java.util.*;

class Student {
    String id;
    String name;
    List<Double> gradez;
    String pass = "unknown";
    String honor;
    String avg;

    public Student(String id, String name){
        this.id = id;
        this.name = name;
        gradez = new ArrayList<>();
    }

    public void addG(Double g) {
        if (g != null && g >= 0 && g <= 100) {
            gradez.add(g);
        } else {
            throw new IllegalArgumentException("Grade must be between 0 and 100.");
        }
    }
    

    public double average() {
        double total = 0;
        for (Double g : gradez) {
            total += g;
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

    public void removeGrade(int i){
        gradez.remove(i);
    }
    
    public void reportCard(){
        System.out.println("Student: " + name);
        System.out.println("ID: " + id);
        System.out.println("Grades #: " + gradez.size());
        System.out.println("Average: " + avg);
        // System.out.println("Honor Roll: " + honorRoll);
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