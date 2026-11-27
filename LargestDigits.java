package arrays.level2;

import java.util.Scanner;

// Program 3: Largest and second largest digit (array capped at maxDigit = 10)
public class LargestDigits {
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

        // Array to store the digits, size is maxDigit
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        // Extract digits until the number becomes 0
        while (number != 0) {
            digits[index] = (int) (number % 10);
            number = number / 10;
            index++;
            // Stop if the array is full; remaining digits are not added
            if (index == maxDigit) {
                break;
            }
        }

        // Find the largest and second largest
        int largest = 0;
        int secondLargest = 0;
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        // Display the result
        System.out.println("Largest digit = " + largest);
        System.out.println("Second largest digit = " + secondLargest);

        // Close the Scanner Object
        input.close();
    }
}
