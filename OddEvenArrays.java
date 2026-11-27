package arrays.level1;

import java.util.Scanner;

// Program 7: Save odd and even numbers from 1 to N in separate arrays
public class OddEvenArrays {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take input and check for a natural number
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        if (number < 1) {
            System.out.println("Error: " + number + " is not a natural number.");
            input.close();
            return;
        }

        // Arrays for even and odd numbers, with size = number / 2 + 1
        int[] evenNumbers = new int[number / 2 + 1];
        int[] oddNumbers = new int[number / 2 + 1];
        int evenIndex = 0;
        int oddIndex = 0;

        // Save each number in the proper array
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex++] = i;
            } else {
                oddNumbers[oddIndex++] = i;
            }
        }

        // Print the odd numbers
        System.out.print("Odd numbers: ");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i] + " ");
        }

        // Print the even numbers
        System.out.print("\nEven numbers: ");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + " ");
        }
        System.out.println();

        // Close the Scanner Object
        input.close();
    }
}
