package arrays.level2;

import java.util.Scanner;

// Program 6: BMI of persons using 1D arrays
public class BmiArrays {
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

        // Arrays for weight (kg), height (m), BMI and status
        double[] weight = new double[number];
        double[] height = new double[number];
        double[] bmi = new double[number];
        String[] status = new String[number];

        // Take input for weight and height
        for (int i = 0; i < number; i++) {
            System.out.print("Enter weight (kg) of person " + (i + 1) + ": ");
            weight[i] = input.nextDouble();
            System.out.print("Enter height (m) of person " + (i + 1) + ": ");
            height[i] = input.nextDouble();
            if (weight[i] <= 0 || height[i] <= 0) {
                System.out.println("Invalid input. Please enter again.");
                i--;
            }
        }

        // Calculate BMI and weight status
        for (int i = 0; i < number; i++) {
            bmi[i] = weight[i] / (height[i] * height[i]);
            if (bmi[i] <= 18.4) {
                status[i] = "Underweight";
            } else if (bmi[i] <= 24.9) {
                status[i] = "Normal";
            } else if (bmi[i] <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        // Display the details
        System.out.println("Height(m)\tWeight(kg)\tBMI\t\tStatus");
        for (int i = 0; i < number; i++) {
            System.out.printf("%.2f\t\t%.2f\t\t%.2f\t\t%s%n", height[i], weight[i], bmi[i], status[i]);
        }

        // Close the Scanner Object
        input.close();
    }
}
