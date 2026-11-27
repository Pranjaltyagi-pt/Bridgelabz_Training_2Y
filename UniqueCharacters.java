package strings.level3;

import java.util.Scanner;

// Program 2: Find unique characters in a string using charAt()
public class UniqueCharacters {
    // Length without using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // End of string
        }
        return count;
    }

    // Return unique characters as a 1D array
    public static char[] findUniqueCharacters(String text) {
        int length = findLength(text);
        char[] temp = new char[length];
        int uniqueCount = 0;
        for (int i = 0; i < length; i++) {
            boolean isUnique = true;
            // Compare with previous characters
            for (int j = 0; j < i; j++) {
                if (text.charAt(i) == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                temp[uniqueCount++] = text.charAt(i);
            }
        }
        // Copy into an array of the exact size
        char[] unique = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            unique[i] = temp[i];
        }
        return unique;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = input.nextLine();
        input.close();

        char[] unique = findUniqueCharacters(text);
        System.out.print("Unique characters: ");
        for (int i = 0; i < unique.length; i++) {
            System.out.print(unique[i] + " ");
        }
        System.out.println();
    }
}
