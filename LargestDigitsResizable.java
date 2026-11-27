package arrays.level2;

import java.util.Scanner;

// Program 4: Largest and second largest digit, array grows by 10 when full
public class LargestDigitsResizable {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Read the number as text so that very long numbers are accepted
        System.out.print("Enter a number: ");
        String text = input.next();
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i))) {
                System.out.println("Invalid number.");
                input.close();
                return;
            }
        }

        // Array to store digits; grows by 10 when full
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        // Store digits starting from the last digit
        for (int pos = text.length() - 1; pos >= 0; pos--) {
            // If the array is full, increase its size by 10
            if (index == maxDigit) {
                maxDigit += 10;
                int[] temp = new int[maxDigit];
                for (int j = 0; j < digits.length; j++) {
                    temp[j] = digits[j];
                }
                digits = temp;
            }
            digits[index++] = text.charAt(pos) - '0';
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
