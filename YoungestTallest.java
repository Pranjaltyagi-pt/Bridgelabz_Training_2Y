package arrays.level2;

import java.util.Scanner;

// Program 2: Youngest and tallest among Amar, Akbar and Anthony
public class YoungestTallest {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Names, ages and heights arrays
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[names.length];
        double[] heights = new double[names.length];

        // Take input for age and height
        for (int i = 0; i < names.length; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            ages[i] = input.nextInt();
            System.out.print("Enter height of " + names[i] + " (cm): ");
            heights[i] = input.nextDouble();
            if (ages[i] <= 0 || heights[i] <= 0) {
                System.out.println("Invalid input. Exiting.");
                input.close();
                return;
            }
        }

        // Find the youngest and tallest
        int youngestIndex = 0;
        int tallestIndex = 0;
        for (int i = 1; i < names.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        // Display the result
        System.out.println("Youngest friend: " + names[youngestIndex] + " (age " + ages[youngestIndex] + ")");
        System.out.println("Tallest friend: " + names[tallestIndex] + " (height " + heights[tallestIndex] + " cm)");

        // Close the Scanner Object
        input.close();
    }
}
