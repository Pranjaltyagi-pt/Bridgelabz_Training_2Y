package strings.level1;

import java.util.Scanner;

// Program 8: Demonstrate ArrayIndexOutOfBoundsException
public class ArrayIndexDemo {
    // Generates the exception
    public static void generateException(String[] names) {
        System.out.println(names[names.length]); // index larger than the last valid index
    }

    // Handles the exception
    public static void handleException(String[] names) {
        try {
            System.out.println(names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Handled ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Handled RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take input for the names
        System.out.print("How many names? ");
        int count = input.nextInt();
        if (count <= 0) {
            System.out.println("Invalid count.");
            input.close();
            return;
        }
        String[] names = new String[count];
        for (int i = 0; i < names.length; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = input.next();
        }
        input.close();

        System.out.println("--- Handling the exception ---");
        handleException(names);

        System.out.println("--- Generating the exception ---");
        generateException(names);
        System.out.println("This line is never reached.");
    }
}
