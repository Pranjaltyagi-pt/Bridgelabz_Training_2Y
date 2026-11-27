package arrays.level1;

import java.util.Scanner;

// Program 2: Check positive/negative/zero for 5 numbers, even/odd for positives,
// and compare first and last elements
public class NumberCheck {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Define an array of 5 integers and take input
        int[] numbers = new int[5];
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        // Check each number
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                // Positive number: check even or odd
                if (numbers[i] % 2 == 0) {
                    System.out.println(numbers[i] + " is positive and even");
                } else {
                    System.out.println(numbers[i] + " is positive and odd");
                }
            } else if (numbers[i] < 0) {
                System.out.println(numbers[i] + " is negative");
            } else {
                System.out.println(numbers[i] + " is zero");
            }
        }

        // Compare the first and last elements
        int first = numbers[0];
        int last = numbers[numbers.length - 1];
        if (first == last) {
            System.out.println("First and last elements are equal");
        } else if (first > last) {
            System.out.println("First element is greater than the last element");
        } else {
            System.out.println("First element is less than the last element");
        }

        // Close the Scanner Object
        input.close();
    }
}
