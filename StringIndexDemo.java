package strings.level1;

import java.util.Scanner;

// Program 5: Demonstrate StringIndexOutOfBoundsException
public class StringIndexDemo {
    // Generates the exception
    public static void generateException(String text) {
        System.out.println(text.charAt(text.length())); // index beyond the length
    }

    // Handles the exception
    public static void handleException(String text) {
        try {
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Handled StringIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Handled RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = input.next();
        input.close();

        System.out.println("--- Handling the exception ---");
        handleException(text);

        System.out.println("--- Generating the exception ---");
        generateException(text);
        System.out.println("This line is never reached.");
    }
}
