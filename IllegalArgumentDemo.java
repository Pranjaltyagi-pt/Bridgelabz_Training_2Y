package strings.level1;

import java.util.Scanner;

// Program 6: Demonstrate IllegalArgumentException (start index > end index)
// Note: older Java versions throw IllegalArgumentException for substring(5, 2).
// Newer Java versions (like JDK 26) throw StringIndexOutOfBoundsException instead,
// so both are caught below.
public class IllegalArgumentDemo {
    // Generates the exception
    public static void generateException(String text) {
        System.out.println(text.substring(5, 2)); // start index is greater than end index
    }

    // Handles the exception
    public static void handleException(String text) {
        try {
            System.out.println(text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Handled IllegalArgumentException: " + e.getMessage());
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Handled StringIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Handled RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a text (at least 6 characters): ");
        String text = input.next();
        input.close();

        System.out.println("--- Handling the exception ---");
        handleException(text);

        System.out.println("--- Generating the exception ---");
        generateException(text);
        System.out.println("This line is never reached.");
    }
}
