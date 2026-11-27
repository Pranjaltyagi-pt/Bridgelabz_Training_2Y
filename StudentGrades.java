package arrays.level2;

import java.util.Scanner;

// Program 8: Percentage and grade of students (1D arrays)
public class StudentGrades {
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

        // Arrays for marks, percentage and grade
        double[] physics = new double[number];
        double[] chemistry = new double[number];
        double[] maths = new double[number];
        double[] percentage = new double[number];
        char[] grade = new char[number];

        // Take input; for negative marks ask again (decrement index)
        for (int i = 0; i < number; i++) {
            System.out.print("Enter Physics, Chemistry, Maths marks of student " + (i + 1) + ": ");
            physics[i] = input.nextDouble();
            chemistry[i] = input.nextDouble();
            maths[i] = input.nextDouble();
            if (physics[i] < 0 || chemistry[i] < 0 || maths[i] < 0) {
                System.out.println("Marks cannot be negative. Enter again.");
                i--;
            }
        }

        // Calculate percentage and grade
        for (int i = 0; i < number; i++) {
            percentage[i] = (physics[i] + chemistry[i] + maths[i]) / 3;
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
        for (int i = 0; i < number; i++) {
            System.out.printf("%d\t%.0f\t%.0f\t%.0f\t%.2f\t%c%n", i + 1, physics[i], chemistry[i],
                    maths[i], percentage[i], grade[i]);
        }

        // Close the Scanner Object
        input.close();
    }
}
