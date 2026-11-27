package arrays.level1;

import java.util.Scanner;

// Program 10: FizzBuzz using a String array
public class FizzBuzz {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take input and validate for a positive integer
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        if (number <= 0) {
            System.out.println("Invalid number. Enter a positive integer.");
            input.close();
            return;
        }

        // String array to save the results (positions 1 to number, index 0 unused)
        String[] results = new String[number + 1];

        // Fill the array
        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                results[i] = "FizzBuzz";
            } else if (i % 3 == 0) {
                results[i] = "Fizz";
            } else if (i % 5 == 0) {
                results[i] = "Buzz";
            } else {
                results[i] = String.valueOf(i);
            }
        }

        // Display the results by index position
        for (int i = 1; i < results.length; i++) {
            System.out.println("Position " + i + " = " + results[i]);
        }

        // Close the Scanner Object
        input.close();
    }
}
