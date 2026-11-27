package arrays.level2;

import java.util.Scanner;

// Program 5: Reverse a number using arrays
public class ReverseNumberArray {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take input and validate
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        if (number < 0) {
            System.out.println("Invalid number.");
            input.close();
            return;
        }

        // Find the count of digits
        int count = 0;
        int temp = number;
        while (temp > 0) {
            count++;
            temp /= 10;
        }
        if (count == 0) {
            count = 1; // the number 0 has one digit
        }

        // Save the digits in an array (last digit first)
        int[] digits = new int[count];
        temp = number;
        for (int i = 0; i < digits.length; i++) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        // Digits are already in reversed order of the number. Store them in
        // another array in the original order to show the reversal clearly
        int[] reversed = new int[count];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }

        // Display the reversed number: digits array read from the start
        System.out.print("Reversed number (digits array): ");
        for (int i = 0; i < digits.length; i++) {
            System.out.print(digits[i]);
        }
        System.out.print("\nReversed array printed in reverse order (original number): ");
        for (int i = 0; i < reversed.length; i++) {
            System.out.print(reversed[i]);
        }
        System.out.println();

        // Close the Scanner Object
        input.close();
    }
}
