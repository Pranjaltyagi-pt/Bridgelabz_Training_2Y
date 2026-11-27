package arrays.level2;

import java.util.Scanner;

// Program 9: Percentage and grade of students using a 2D marks array
public class StudentGrades2D {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take input for the number of students
        System.out.print("Enter number of students: ");
        int number = input.nextInt();
        if (number <= 0) {
            System.out.println("Invalid number of students.");
            input.close();
            return;
        }

        // 2D array: columns are Physics, Chemistry, Maths
        double[][] marks = new double[number][3];
        double[] percentage = new double[number];
        char[] grade = new char[number];

        // Take input; for negative marks ask again (decrement index)
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter Physics, Chemistry, Maths marks of student " + (i + 1) + ": ");
            for (int j = 0; j < marks[i].length; j++) {
                marks[i][j] = input.nextDouble();
            }
            if (marks[i][0] < 0 || marks[i][1] < 0 || marks[i][2] < 0) {
                System.out.println("Marks cannot be negative. Enter again.");
                i--;
            }
        }

        // Calculate percentage and grade
        for (int i = 0; i < marks.length; i++) {
            double total = 0;
            for (int j = 0; j < marks[i].length; j++) {
                total += marks[i][j];
            }
            percentage[i] = total / marks[i].length;
            if (percentage[i] >= 80) {
                grade[i] = 'A';
            } else if (percentage[i] >= 70) {
                grade[i] = 'B';
            } else if (percentage[i] >= 60) {
                grade[i] = 'C';
            } else if (percentage[i] >= 50) {
                grade[i] = 'D';
            } else if (percentage[i] >= 40) {
                grade[i] = 'E';
            } else {
                grade[i] = 'R';
            }
        }

        // Display the details
        System.out.println("Student\tPhysics\tChem\tMaths\tPercent\tGrade");
        for (int i = 0; i < marks.length; i++) {
            System.out.printf("%d\t%.0f\t%.0f\t%.0f\t%.2f\t%c%n", i + 1, marks[i][0], marks[i][1],
                    marks[i][2], percentage[i], grade[i]);
        }

        // Close the Scanner Object
        input.close();
    }
}
