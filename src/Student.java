import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;
public class Student {

    String name;
    int grade;

    private static ArrayList<Student> students = new ArrayList<>();

    public Student(String name, int grade){

        this.name = name;
        this.grade = grade;

    }

    public static void readStudentFile(){

        try {
            File myFile = new File("studentInfo.txt");
            Scanner scan = new Scanner(myFile);
            String nameOutput ="";
            int gradeOutput = 0;
            while(scan.hasNextLine()) {
                nameOutput = scan.next();
                gradeOutput = Integer.parseInt(scan.next());
                students.add(new Student(nameOutput, gradeOutput));
            }

            scan.close();
        }catch(IOException e){
            System.out.println("error");
        }catch(InputMismatchException e){
            System.out.println("Input mismatch!");
        }catch(NoSuchElementException e){
            System.out.println(e);
        }

    }


    public static void printStudentFile(){
        for(Student s : students){
            System.out.println(students.indexOf(s)+") "+s.name+" "+s.grade);

        }
    }

    public static void editStudentFile(int index){
        System.out.println("you are editing the student "+ students.get(index).name +" grades");
        System.out.println("The students current grade is: "+students.get(index).grade);
        System.out.println("What grade should the student have?");

        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        students.get(index).grade = input;
        System.out.println("The student "+students.get(index).name +" grade is now "+ students.get(index).grade);

        try {
            FileWriter writer = new FileWriter("newStudentInfo.txt");
            for(Student s: students){
                writer.write(s.name + " "+Integer.toString(s.grade)+"\n");
            }
            writer.close();
            System.out.println("The new file is now written. Display it from them menu");
        }catch(IOException e){
            System.out.println("Error in printing");
        }
    }

    public static void printNewStudentFile(){

        try {
            File newMyFile = new File("newStudentInfo.txt");
            Scanner scan = new Scanner(newMyFile);
            String nameOutput ="";
            int gradeOutput = 0;
            students.clear();
            while(scan.hasNextLine()) {
                nameOutput = scan.next();
                gradeOutput = Integer.parseInt(scan.next());
                students.add(new Student(nameOutput, gradeOutput));
            }

            scan.close();
        }catch(IOException e){
            System.out.println("error");
        }catch(InputMismatchException e){
            System.out.println("Input mismatch!");
        }catch(NoSuchElementException e){
            System.out.println("");
        }

    }
}


