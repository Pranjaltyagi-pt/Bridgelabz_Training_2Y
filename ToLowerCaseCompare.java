package strings.level1;

import java.util.Scanner;

// Program 10: Convert text to lowercase using ASCII logic and compare
public class ToLowerCaseCompare {
    // Convert to lowercase using ASCII values (difference of 32)
    public static String toLowerCaseUsingCharAt(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            }
            result += ch;
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
        System.out.print("Enter a text: ");
        String text = input.nextLine();
        input.close();

        String userResult = toLowerCaseUsingCharAt(text);
        String builtInResult = text.toLowerCase();

        System.out.println("User defined lowercase: " + userResult);
        System.out.println("toLowerCase(): " + builtInResult);
        System.out.println("Both results are the same: " + compareUsingCharAt(userResult, builtInResult));
    }
}
