import java.util.Scanner;
public class Main {


    public static void main(String[] args) {
        Student.readStudentFile();
        startProgram();

    }

    public static void startProgram(){

        System.out.println("Please choose an action:");
        System.out.println("[1] Display original students and their grades");
        System.out.println("[2] Edit students and their grades");
        System.out.println("[3] Display new students and their grades");
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        switch(input){
            case 1:
                System.out.println("Displaying the current list:");
                Student.printStudentFile();
                System.out.println("---------------------------------------------------");
                startProgram();
                break;
            case 2:
                System.out.println("Which student would you like to edit?");
                Student.printStudentFile();
                Student.editStudentFile(scan.nextInt());
                startProgram();
                break;
            case 3:
                System.out.println("Display the new list:");
                System.out.println("---------------------------------------------------");
                Student.printNewStudentFile();
                Student.printStudentFile();
                startProgram();
                break;
            default:
                break;


        }
    }
}