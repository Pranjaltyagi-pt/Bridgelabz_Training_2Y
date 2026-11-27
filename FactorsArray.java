package arrays.level1;

import java.util.Scanner;

// Program 8: Find factors of a number and store them in a resizable array
public class FactorsArray {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take input and validate
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        if (number <= 0) {
            System.out.println("Invalid number. Enter a positive number.");
            input.close();
            return;
        }

        // Initial size of the factors array and the index
        int maxFactor = 10;
        int[] factors = new int[maxFactor];
        int index = 0;

        // Loop through 1 to number and find the factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                // If the array is full, double its size
                if (index == maxFactor) {
                    maxFactor = maxFactor * 2;
                    int[] temp = new int[maxFactor];
                    for (int j = 0; j < factors.length; j++) {
                        temp[j] = factors[j];
                    }
                    factors = temp;
                }
                factors[index++] = i;
            }
        }

        // Display the factors
        System.out.print("Factors of " + number + ": ");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }
        System.out.println();

        // Close the Scanner Object
        input.close();
    }
}
