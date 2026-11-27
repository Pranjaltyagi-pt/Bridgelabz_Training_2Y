package strings.level1;

import java.util.Scanner;

// Program 1: Compare two strings using charAt() and check with equals()
public class CompareStrings {
    // Compare two strings character by character
    public static boolean compareUsingCharAt(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take input for two strings
        System.out.print("Enter first string: ");
        String first = input.next();
        System.out.print("Enter second string: ");
        String second = input.next();

        // Compare using both methods
        boolean charAtResult = compareUsingCharAt(first, second);
        boolean equalsResult = first.equals(second);

        // Display the results
        System.out.println("Result using charAt(): " + charAtResult);
        System.out.println("Result using equals(): " + equalsResult);
        System.out.println("Both results are the same: " + (charAtResult == equalsResult));

        input.close();
    }
}
