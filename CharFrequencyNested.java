package strings.level3;

import java.util.Scanner;

// Program 6: Frequency of characters using nested loops
public class CharFrequencyNested {
    // Return a 1D String array of "character : frequency"
    public static String[] findFrequency(String text) {
        char[] characters = text.toCharArray();
        int[] frequency = new int[characters.length];

        // Outer loop: each character; inner loop: look for duplicates
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == '0') {
                continue; // already counted
            }
            frequency[i] = 1;
            for (int j = i + 1; j < characters.length; j++) {
                if (characters[i] == characters[j]) {
                    frequency[i]++;
                    characters[j] = '0'; // mark duplicate so it is not counted again
                }
            }
        }

        // Count the entries to store
        int count = 0;
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                count++;
            }
        }

        // Store the character and its frequency
        String[] result = new String[count];
        int index = 0;
        for (int i = 0; i < characters.length; i++) {
            if (frequency[i] > 0) {
                result[index++] = characters[i] + " : " + frequency[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = input.nextLine();
        input.close();

        String[] result = findFrequency(text);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
