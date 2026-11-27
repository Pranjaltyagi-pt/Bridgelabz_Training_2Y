package strings.level1;

import java.util.Scanner;

// Program 2: Create a substring using charAt() and compare with substring()
public class SubstringCompare {
    // Create a substring using charAt()
    public static String createSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    // Compare two strings using charAt()
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

        // Take input for text, start and end index
        System.out.print("Enter a string: ");
        String text = input.next();
        System.out.print("Enter start index: ");
        int start = input.nextInt();
        System.out.print("Enter end index: ");
        int end = input.nextInt();

        // Validate the indexes
        if (start < 0 || end > text.length() || start > end) {
            System.out.println("Invalid start or end index.");
            input.close();
            return;
        }

        // Create the substrings and compare
        String userSubstring = createSubstring(text, start, end);
        String builtInSubstring = text.substring(start, end);
        boolean same = compareUsingCharAt(userSubstring, builtInSubstring);

        // Display the results
        System.out.println("Substring using charAt(): " + userSubstring);
        System.out.println("Substring using substring(): " + builtInSubstring);
        System.out.println("Both substrings are the same: " + same);

        input.close();
    }
}
