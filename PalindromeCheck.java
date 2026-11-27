package strings.level3;

import java.util.Scanner;

// Program 7: Palindrome check using three logics
public class PalindromeCheck {
    // Logic 1: compare from start and end using a loop
    public static boolean isPalindromeLoop(String text) {
        int start = 0;
        int end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: recursion
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Logic 3: reverse using charAt() and compare character arrays
    public static char[] reverseString(String text) {
        char[] reversed = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            reversed[i] = text.charAt(text.length() - 1 - i);
        }
        return reversed;
    }

    public static boolean isPalindromeArrays(String text) {
        char[] original = text.toCharArray();
        char[] reversed = reverseString(text);
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = input.next();
        input.close();

        System.out.println("Logic 1 (loop): " + isPalindromeLoop(text));
        System.out.println("Logic 2 (recursion): " + isPalindromeRecursive(text, 0, text.length() - 1));
        System.out.println("Logic 3 (char arrays): " + isPalindromeArrays(text));
    }
}
