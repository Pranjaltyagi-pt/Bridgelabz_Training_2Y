package strings.level3;

import java.util.Scanner;

// Program 1: BMI of a team of 10 members (weight in kg, height in cm)
public class BmiTeam {
    // Return {BMI, status} for each person
    public static String[][] findBmiAndStatus(double[][] data) {
        String[][] result = new String[data.length][2];
        for (int i = 0; i < data.length; i++) {
            double heightInMeter = data[i][1] / 100;
            double bmi = data[i][0] / (heightInMeter * heightInMeter);
            String status;
            if (bmi <= 18.4) {
                status = "Underweight";
            } else if (bmi <= 24.9) {
                status = "Normal";
            } else if (bmi <= 39.9) {
                status = "Overweight";
            } else {
                status = "Obese";
            }
            result[i][0] = String.format("%.2f", bmi);
            result[i][1] = status;
        }
        return result;
    }

    // Return {height, weight, BMI, status} for each person
    public static String[][] computeTable(double[][] data) {
        String[][] bmiAndStatus = findBmiAndStatus(data);
        String[][] table = new String[data.length][4];
        for (int i = 0; i < data.length; i++) {
            table[i][0] = String.valueOf(data[i][1]);
            table[i][1] = String.valueOf(data[i][0]);
            table[i][2] = bmiAndStatus[i][0];
            table[i][3] = bmiAndStatus[i][1];
        }
        return table;
    }

    public static void display(String[][] table) {
        System.out.println("Height(cm)\tWeight(kg)\tBMI\t\tStatus");
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t\t" + table[i][1] + "\t\t" + table[i][2] + "\t\t" + table[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int members = 10;
        double[][] data = new double[members][2];
        for (int i = 0; i < data.length; i++) {
            System.out.print("Enter weight (kg) and height (cm) of person " + (i + 1) + ": ");
            data[i][0] = input.nextDouble();
            data[i][1] = input.nextDouble();
            // Validate the input
            if (data[i][0] <= 0 || data[i][1] <= 0) {
                System.out.println("Invalid input. Enter again.");
                i--;
            }
        }
        input.close();
        display(computeTable(data));
    }
}
