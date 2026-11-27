package arrays.level2;

import java.util.Scanner;

// Program 1: Bonus of 10 employees of Zara based on years of service
public class EmployeeBonus {
    public static void main(String[] args) {
        // Create a Scanner Object
        Scanner input = new Scanner(System.in);

        // Constants and arrays
        int employeeCount = 10;
        double[] salary = new double[employeeCount];
        double[] yearsOfService = new double[employeeCount];
        double[] newSalary = new double[employeeCount];
        double[] bonus = new double[employeeCount];
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        // Take input; if invalid, ask again by decrementing the index
        for (int i = 0; i < salary.length; i++) {
            System.out.print("Enter salary of employee " + (i + 1) + ": ");
            double s = input.nextDouble();
            System.out.print("Enter years of service of employee " + (i + 1) + ": ");
            double y = input.nextDouble();
            if (s <= 0 || y < 0) {
                System.out.println("Invalid input. Please enter again.");
                i--;
                continue;
            }
            salary[i] = s;
            yearsOfService[i] = y;
        }

        // Calculate bonus: 5% if service is more than 5 years, otherwise 2%
        for (int i = 0; i < salary.length; i++) {
            if (yearsOfService[i] > 5) {
                bonus[i] = salary[i] * 0.05;
            } else {
                bonus[i] = salary[i] * 0.02;
            }
            newSalary[i] = salary[i] + bonus[i];
            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        // Display the details
        for (int i = 0; i < salary.length; i++) {
            System.out.printf("Employee %d: Old Salary = %.2f, Bonus = %.2f, New Salary = %.2f%n",
                    i + 1, salary[i], bonus[i], newSalary[i]);
        }
        System.out.printf("Total Bonus Payout = %.2f%n", totalBonus);
        System.out.printf("Total Old Salary = %.2f%n", totalOldSalary);
        System.out.printf("Total New Salary = %.2f%n", totalNewSalary);

        // Close the Scanner Object
        input.close();
    }
}
