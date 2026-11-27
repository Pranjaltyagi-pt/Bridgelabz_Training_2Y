package strings.level3;

import java.util.Scanner;

// Program 4: Frequency of characters using an ASCII frequency array
public class CharFrequencyAscii {
    // Return a 2D array of {character, frequency}
    public static String[][] findFrequency(String text) {
        int[] frequency = new int[256];
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        // Count distinct characters
        int distinct = 0;
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                distinct++;
            }
        }

        // Store characters and frequencies in order of first appearance
        String[][] result = new String[distinct][2];
        int index = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequency[ch] > 0) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(frequency[ch]);
                frequency[ch] = 0; // mark as already added
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = input.nextLine();
        input.close();

        String[][] result = findFrequency(text);
        System.out.println("Character\tFrequency");
        for (int i = 0; i < result.length; i++) {
            System.out.println("'" + result[i][0] + "'\t\t" + result[i][1]);
        }
    }
}
