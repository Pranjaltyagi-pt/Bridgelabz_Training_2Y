package arrays.level2;

import java.util.Scanner;

// Program 7: BMI of persons using a 2D array [weight, height, BMI]
public class Bmi2DArray {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Take input for the number of persons
        System.out.print("Enter number of persons: ");
        int number = input.nextInt();
        if (number <= 0) {
            System.out.println("Invalid number of persons.");
            input.close();
            return;
        }

        // 2D array: column 0 = weight, column 1 = height, column 2 = BMI
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        // Take input; for negative values ask again
        for (int i = 0; i < personData.length; i++) {
            System.out.print("Enter weight (kg) of person " + (i + 1) + ": ");
            personData[i][0] = input.nextDouble();
            System.out.print("Enter height (m) of person " + (i + 1) + ": ");
            personData[i][1] = input.nextDouble();
            if (personData[i][0] <= 0 || personData[i][1] <= 0) {
                System.out.println("Please enter positive values.");
                i--;
            }
        }

        // Calculate BMI and status
        for (int i = 0; i < personData.length; i++) {
            personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]);
            if (personData[i][2] <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Display the details
        System.out.println("Height(m)\tWeight(kg)\tBMI\t\tStatus");
        for (int i = 0; i < personData.length; i++) {
            System.out.printf("%.2f\t\t%.2f\t\t%.2f\t\t%s%n",
                    personData[i][1], personData[i][0], personData[i][2], weightStatus[i]);
        }

        // Close the Scanner Object
        input.close();
    }
}
