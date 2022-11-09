import java.util.List;
import java.util.Scanner;

import dto.Student;
import service.StudentService;
import service.StudentServiceImp;

public class App {
    public static void main(String[] args) throws Exception {
        showMenu();
    }

    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        StudentService studentService = new StudentServiceImp();
        String userChoice = "";

        do {
            System.out.println("=============================");
            System.out.println("1. Register");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Get all Students");
            System.out.println("5. Exit");
            System.out.println("=============================");

            userChoice = scanner.nextLine();

            switch (userChoice) {
                case "1":
                    System.out.print("Enter the student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter the student email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter the student id: ");
                    int studentId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter the student row: ");
                    int studentRow = Integer.parseInt(scanner.nextLine());

                    Student student = new Student(name, email, studentId, studentRow);
                    studentService.insert(student);

                    break;
                case "2":
                    System.out.println("=============================");
                    displayStudents(studentService.getAll());
                    System.out.println("=============================");

                    System.out.println("Enter the student ID: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    Student student1 = studentService.getStudentById(id);

                    if (student1 != null) {
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new email: ");
                        String newEmail = scanner.nextLine();
                        System.out.print("Enter new student id: ");
                        int newStudentId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter new student row: ");
                        int newStudentRow = Integer.parseInt(scanner.nextLine());

                        student1.setName(newName);
                        student1.setEmail(newEmail);
                        student1.setStudentid(newStudentId);
                        student1.setStudentrow(newStudentRow);

                        studentService.update(student1);
                    } else {
                        System.out.println("User not found.");
                    }

                    break;
                case "3":
                    System.out.println("=============================");
                    displayStudents(studentService.getAll());
                    System.out.println("=============================");

                    System.out.println("Enter the student ID: ");
                    id = Integer.parseInt(scanner.nextLine());

                    studentService.delete(id);

                    break;
                case "4":
                    System.out.println("=============================");
                    displayStudents(studentService.getAll());
                    System.out.println("=============================");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (!userChoice.equals("5"));

        scanner.close();
    }

    public static void displayStudents(List<Student> students) {
        System.out.println("ID\tNAME\t\tEMAIL\t\t\t\tSTUDENTID\tSTUDENTROW");

        for (Student student : students) {
            System.out.print(student.getId() + "\t");
            System.out.print(student.getName() + "\t\t");
            System.out.print(student.getEmail() + "\t");
            System.out.print(student.getStudentid() + "\t");
            System.out.print(student.getStudentrow() + "\t");
            System.out.println("\n");
        }
    }
}
