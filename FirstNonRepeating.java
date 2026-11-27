package strings.level3;

import java.util.Scanner;

// Program 3: First non-repeating character in a string
public class FirstNonRepeating {
    // Return the first non-repeating character, or '\0' if none
    public static char findFirstNonRepeating(String text) {
        // Frequency array indexed by ASCII value
        int[] frequency = new int[256];
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }
        for (int i = 0; i < text.length(); i++) {
            if (frequency[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = input.nextLine();
        input.close();

        char result = findFirstNonRepeating(text);
        if (result == '\0') {
            System.out.println("There is no non-repeating character.");
        } else {
            System.out.println("First non-repeating character: " + result);
        }
    }
}
