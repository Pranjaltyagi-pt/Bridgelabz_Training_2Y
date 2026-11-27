package strings.level2;

import java.util.Scanner;

// Program 7: Trim leading and trailing spaces using charAt()
public class TrimUsingCharAt {
    // Return {start, end} of the text without leading/trailing spaces (end is exclusive)
    public static int[] findTrimPoints(String text) {
        int start = 0;
        int end = text.length();
        while (start < end && text.charAt(start) == ' ') {
            start++;
        }
        while (end > start && text.charAt(end - 1) == ' ') {
            end--;
        }
        return new int[]{start, end};
    }

    public static String createSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

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
        System.out.print("Enter a text with spaces at the start and end: ");
        String text = input.nextLine();
        input.close();

        int[] points = findTrimPoints(text);
        String userTrimmed = createSubstring(text, points[0], points[1]);
        String builtInTrimmed = text.trim();

        System.out.println("User defined trim: [" + userTrimmed + "]");
        System.out.println("Built-in trim(): [" + builtInTrimmed + "]");
        System.out.println("Both results are the same: " + compareUsingCharAt(userTrimmed, builtInTrimmed));
    }
}
