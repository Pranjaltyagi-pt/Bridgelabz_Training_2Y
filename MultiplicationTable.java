package arrays.level1;

import java.util.Scanner;

// Program 3: Multiplication table of a number (1 to 10) stored in an array
public class MultiplicationTable {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take input for the number
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Array to store the multiplication results from 1 to 10
        int[] table = new int[10];

        // Store the results in the array
        for (int i = 1; i <= 10; i++) {
            table[i - 1] = number * i;
        }

        // Display the results in the format number * i = result
        for (int i = 0; i < table.length; i++) {
            System.out.println(number + " * " + (i + 1) + " = " + table[i]);
        }

        // Close the Scanner Object
        input.close();
    }
}
