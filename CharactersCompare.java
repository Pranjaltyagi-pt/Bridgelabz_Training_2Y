package strings.level1;

import java.util.Scanner;

// Program 3: Return characters of a string without toCharArray() and compare
public class CharactersCompare {
    // Return the characters of the text using charAt()
    public static char[] getCharacters(String text) {
        char[] characters = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            characters[i] = text.charAt(i);
        }
        return characters;
    }

    // Compare two character arrays
    public static boolean compareArrays(char[] first, char[] second) {
        if (first.length != second.length) {
            return false;
        }
        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take input
        System.out.print("Enter a text: ");
        String text = input.next();

        // Get characters using both methods
        char[] userArray = getCharacters(text);
        char[] builtInArray = text.toCharArray();

        // Compare and display
        boolean same = compareArrays(userArray, builtInArray);
        System.out.println("User defined characters: " + java.util.Arrays.toString(userArray));
        System.out.println("toCharArray() characters: " + java.util.Arrays.toString(builtInArray));
        System.out.println("Both arrays are the same: " + same);

        input.close();
    }
}
