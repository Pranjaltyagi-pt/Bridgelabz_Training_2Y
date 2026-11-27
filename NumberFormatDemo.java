package strings.level1;

import java.util.Scanner;

// Program 7: Demonstrate NumberFormatException
public class NumberFormatDemo {
    // Generates the exception
    public static void generateException(String text) {
        int number = Integer.parseInt(text);
        System.out.println("Number: " + number);
    }

    // Handles the exception
    public static void handleException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Handled NumberFormatException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Handled RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a text (try letters like abc): ");
        String text = input.next();
        input.close();

        System.out.println("--- Handling the exception ---");
        handleException(text);

        System.out.println("--- Generating the exception ---");
        generateException(text);
        System.out.println("This line is reached only if the text was a valid number.");
    }
}
