package arrays.level1;

import java.util.Scanner;

// Program 4: Store up to 10 numbers, stop on 0 or negative, show numbers and total
public class SumUntilZero {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Array of 10 doubles, total and index
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;

        // Infinite loop to take input
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double value = input.nextDouble();

            // Break if the user enters 0 or a negative number
            if (value <= 0) {
                break;
            }

            // Store the number and move to the next index
            numbers[index] = value;
            index++;

            // Stop after the 10th number has been stored
            if (index == numbers.length) {
                break;
            }
        }

        // Add up all the stored values and display them
        System.out.println("Numbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
            total += numbers[i];
        }

        // Display the total
        System.out.println("Total = " + total);

        // Close the Scanner Object
        input.close();
    }
}
