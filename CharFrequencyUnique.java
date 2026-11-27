package strings.level3;

import java.util.Scanner;

// Program 5: Frequency of characters using unique characters
public class CharFrequencyUnique {
    // Unique characters using nested loops
    public static char[] uniqueCharacters(String text) {
        char[] temp = new char[text.length()];
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(i) == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                temp[count++] = text.charAt(i);
            }
        }
        char[] unique = new char[count];
        for (int i = 0; i < count; i++) {
            unique[i] = temp[i];
        }
        return unique;
    }

    // Return a 2D array of {character, frequency}
    public static String[][] findFrequency(String text) {
        int[] frequency = new int[256];
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }
        char[] unique = uniqueCharacters(text);
        String[][] result = new String[unique.length][2];
        for (int i = 0; i < unique.length; i++) {
            result[i][0] = String.valueOf(unique[i]);
            result[i][1] = String.valueOf(frequency[unique[i]]);
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
