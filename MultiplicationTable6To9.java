package arrays.level1;

import java.util.Scanner;

// Program 5: Multiplication table of a number from 6 to 9
public class MultiplicationTable6To9 {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take input for the number
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Range of multipliers
        int start = 6;
        int end = 9;

        // Array to store results for multipliers 6 to 9
        int[] multiplicationResult = new int[end - start + 1];

        // Calculate and store the results
        for (int i = start; i <= end; i++) {
            multiplicationResult[i - start] = number * i;
        }

        // Display the results
        for (int i = 0; i < multiplicationResult.length; i++) {
            System.out.println(number + " * " + (i + start) + " = " + multiplicationResult[i]);
        }

        // Close the Scanner Object
        input.close();
    }
}
