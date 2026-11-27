package strings.level2;

import java.util.Scanner;

// Program 2: Split text into words without split() and compare with split()
public class SplitTextCompare {
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

    // Split the text into words using charAt()
    public static String[] splitText(String text) {
        int length = findLength(text);

        // Count the words (number of spaces + 1) and store the space indexes
        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }
        int[] spaceIndexes = new int[wordCount + 1];
        int k = 0;
        spaceIndexes[k++] = -1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[k++] = i;
            }
        }
        spaceIndexes[k] = length;

        // Extract the words using the stored indexes
        String[] words = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            String word = "";
            for (int j = spaceIndexes[i] + 1; j < spaceIndexes[i + 1]; j++) {
                word += text.charAt(j);
            }
            words[i] = word;
        }
        return words;
    }

    // Compare two string arrays
    public static boolean compareArrays(String[] first, String[] second) {
        if (first.length != second.length) {
            return false;
        }
        for (int i = 0; i < first.length; i++) {
            if (!first[i].equals(second[i])) {
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

        String[] userWords = splitText(text);
        String[] builtInWords = text.split(" ");

        System.out.println("User defined split: " + java.util.Arrays.toString(userWords));
        System.out.println("Built-in split(): " + java.util.Arrays.toString(builtInWords));
        System.out.println("Both results are the same: " + compareArrays(userWords, builtInWords));
    }
}
