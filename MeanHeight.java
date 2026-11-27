package arrays.level1;

import java.util.Scanner;

// Program 6: Mean height of the players of a football team
public class MeanHeight {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Football team has 11 players
        int playerCount = 11;
        double[] heights = new double[playerCount];
        double sum = 0;

        // Take input for the height of each player
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height of player " + (i + 1) + ": ");
            heights[i] = input.nextDouble();
            // Validate the height
            if (heights[i] <= 0) {
                System.out.println("Invalid height. Exiting.");
                input.close();
                return;
            }
        }

        // Find the sum of all heights
        for (int i = 0; i < heights.length; i++) {
            sum += heights[i];
        }

        // Calculate and display the mean height
        double mean = sum / heights.length;
        System.out.println("Mean height of the football team = " + mean);

        // Close the Scanner Object
        input.close();
    }
}
