package arrays.level1;

import java.util.Scanner;

// Program 1: Check whether each of 10 students can vote based on age
public class VoteCheck {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Define the number of students and an array to store their ages
        int studentCount = 10;
        int[] ages = new int[studentCount];

        // Take user input for the age of each student
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = input.nextInt();
        }

        // Loop through the array and check voting eligibility
        int votingAge = 18;
        for (int i = 0; i < ages.length; i++) {
            if (ages[i] < 0) {
                // Negative age is invalid
                System.out.println("Invalid age: " + ages[i]);
            } else if (ages[i] >= votingAge) {
                System.out.println("The student with the age " + ages[i] + " can vote.");
            } else {
                System.out.println("The student with the age " + ages[i] + " cannot vote.");
            }
        }

        // Close the Scanner Object
        input.close();
    }
}
