package strings.level2;

import java.util.Scanner;

// Program 1: Find the length of a string without using length()
public class StringLengthWithoutLength {
    // Count characters until charAt() throws an exception
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // End of string reached
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = input.next();
        input.close();

        System.out.println("Length without length(): " + findLength(text));
        System.out.println("Length using length(): " + text.length());
    }
}
