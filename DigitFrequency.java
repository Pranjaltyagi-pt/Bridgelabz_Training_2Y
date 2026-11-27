package arrays.level2;

import java.util.Scanner;

// Program 10: Frequency of each digit in a number
public class DigitFrequency {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take input and validate
        System.out.print("Enter a number: ");
        long number = input.nextLong();
        if (number < 0) {
            System.out.println("Invalid number.");
            input.close();
            return;
        }

        // Find the count of digits
        int count = 0;
        long temp = number;
        while (temp > 0) {
            count++;
            temp /= 10;
        }
        if (count == 0) {
            count = 1; // the number 0 has one digit
        }

        // Save the digits in an array
        int[] digits = new int[count];
        temp = number;
        for (int i = 0; i < digits.length; i++) {
            digits[i] = (int) (temp % 10);
            temp /= 10;
        }

        // Frequency array of size 10 (digits 0 to 9)
        int[] frequency = new int[10];
        for (int i = 0; i < digits.length; i++) {
            frequency[digits[i]]++;
        }

        // Display the frequency of each digit that appears
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                System.out.println("Frequency of digit " + i + " = " + frequency[i]);
            }
        }

        // Close the Scanner Object
        input.close();
    }
}
