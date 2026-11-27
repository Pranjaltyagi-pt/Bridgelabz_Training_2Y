package strings.level2;

import java.util.Scanner;

// Program 4: Find the shortest and longest words in a text
public class ShortestLongestWord {
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

    public static String[] splitText(String text) {
        int length = findLength(text);
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

    public static String[][] wordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }

    // Return {index of shortest, index of longest} in a 1D int array
    public static int[] findShortestAndLongest(String[][] table) {
        int shortest = 0;
        int longest = 0;
        for (int i = 1; i < table.length; i++) {
            int length = Integer.parseInt(table[i][1]);
            if (length < Integer.parseInt(table[shortest][1])) {
                shortest = i;
            }
            if (length > Integer.parseInt(table[longest][1])) {
                longest = i;
            }
        }
        return new int[]{shortest, longest};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = input.nextLine();
        input.close();

        String[][] table = wordsWithLengths(splitText(text));
        int[] result = findShortestAndLongest(table);

        System.out.println("Shortest word: " + table[result[0]][0] + " (length " + table[result[0]][1] + ")");
        System.out.println("Longest word: " + table[result[1]][0] + " (length " + table[result[1]][1] + ")");
    }
}
