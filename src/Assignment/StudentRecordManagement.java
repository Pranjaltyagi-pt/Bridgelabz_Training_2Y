package Assignment;
import java.util.Scanner;
public class StudentRecordManagement {
            static class Student {
            int rollNo;
            String name;
            int age;
            String grade;
            Student next;

            Student(int rollNo, String name, int age, String grade) {
                this.rollNo = rollNo;
                this.name = name;
                this.age = age;
                this.grade = grade;
                this.next = null;
            }
        }

        static Student head = null;
        static Scanner sc = new Scanner(System.in);


        static void insertAtBeginning() {
            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Grade: ");
            String grade = sc.nextLine();

            Student newNode = new Student(roll, name, age, grade);

            newNode.next = head;
            head = newNode;

            System.out.println("Student added successfully!");
        }


        static void insertAtEnd() {
            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Grade: ");
            String grade = sc.nextLine();

            Student newNode = new Student(roll, name, age, grade);

            if (head == null) {
                head = newNode;
                return;
            }

            Student temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;

            System.out.println("Student added successfully!");
        }


        static void insertAtPosition() {
            System.out.print("Enter Position: ");
            int pos = sc.nextInt();

            if (pos < 1) {
                System.out.println("Invalid Position!");
                return;
            }

            if (pos == 1) {
                insertAtBeginning();
                return;
            }

            Student temp = head;

            for (int i = 1; i < pos - 1 && temp != null; i++) {
                temp = temp.next;
            }

            if (temp == null) {
                System.out.println("Invalid Position!");
                return;
            }

            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Grade: ");
            String grade = sc.nextLine();

            Student newNode = new Student(roll, name, age, grade);

            newNode.next = temp.next;
            temp.next = newNode;

            System.out.println("Student added successfully!");
        }


        static void deleteStudent() {
            System.out.print("Enter Roll Number to Delete: ");
            int roll = sc.nextInt();

            if (head == null) {
                System.out.println("List is Empty!");
                return;
            }

            if (head.rollNo == roll) {
                head = head.next;
                System.out.println("Student Deleted!");
                return;
            }

            Student temp = head;

            while (temp.next != null && temp.next.rollNo != roll) {
                temp = temp.next;
            }

            if (temp.next == null) {
                System.out.println("Student Not Found!");
            } else {
                temp.next = temp.next.next;
                System.out.println("Student Deleted!");
            }
        }

        static void searchStudent() {
            System.out.print("Enter Roll Number to Search: ");
            int roll = sc.nextInt();

            Student temp = head;

            while (temp != null) {
                if (temp.rollNo == roll) {
                    System.out.println("Student Found!");
                    System.out.println("Roll No: " + temp.rollNo);
                    System.out.println("Name: " + temp.name);
                    System.out.println("Age: " + temp.age);
                    System.out.println("Grade: " + temp.grade);
                    return;
                }

                temp = temp.next;
            }

            System.out.println("Student Not Found!");
        }


        static void displayStudents() {
            if (head == null) {
                System.out.println("No Student Records Found!");
                return;
            }

            Student temp = head;

            System.out.println("\n--- Student Records ---");

            while (temp != null) {
                System.out.println("Roll No: " + temp.rollNo);
                System.out.println("Name: " + temp.name);
                System.out.println("Age: " + temp.age);
                System.out.println("Grade: " + temp.grade);
                System.out.println("--------------------");

                temp = temp.next;
            }
        }


        static void updateGrade() {
            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine();

            Student temp = head;

            while (temp != null) {
                if (temp.rollNo == roll) {
                    System.out.print("Enter New Grade: ");
                    temp.grade = sc.nextLine();

                    System.out.println("Grade Updated Successfully!");
                    return;
                }

                temp = temp.next;
            }

            System.out.println("Student Not Found!");
        }


        public static void main(String[] args) {

            while (true) {
                System.out.println("\n===== Student Record Management =====");
                System.out.println("1. Insert at Beginning");
                System.out.println("2. Insert at End");
                System.out.println("3. Insert at Position");
                System.out.println("4. Delete Student");
                System.out.println("5. Search Student");
                System.out.println("6. Display Students");
                System.out.println("7. Update Grade");
                System.out.println("8. Exit");

                System.out.print("Enter Your Choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        insertAtBeginning();
                        break;

                    case 2:
                        insertAtEnd();
                        break;

                    case 3:
                        insertAtPosition();
                        break;

                    case 4:
                        deleteStudent();
                        break;

                    case 5:
                        searchStudent();
                        break;

                    case 6:
                        displayStudents();
                        break;

                    case 7:
                        updateGrade();
                        break;

                    case 8:
                        System.out.println("Program Exited!");
                        return;

                    default:
                        System.out.println("Invalid Choice!");
                }
            }
        }
    }
