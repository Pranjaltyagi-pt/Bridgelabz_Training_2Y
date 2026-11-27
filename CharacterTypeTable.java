package strings.level2;

import java.util.Scanner;

// Program 6: Display character type (Vowel, Consonant, Not a Letter) in a table
public class CharacterTypeTable {
    public static String checkCharacter(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            }
            return "Consonant";
        }
        return "Not a Letter";
    }

    // Return a 2D array of character and its type
    public static String[][] findCharacterTypes(String text) {
        String[][] result = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            result[i][0] = String.valueOf(text.charAt(i));
            result[i][1] = checkCharacter(text.charAt(i));
        }
        return result;
    }

    // Display the 2D array in tabular format
    public static void display(String[][] table) {
        System.out.println("Character\tType");
        for (int i = 0; i < table.length; i++) {
            System.out.println("'" + table[i][0] + "'\t\t" + table[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = input.nextLine();
        input.close();

        display(findCharacterTypes(text));
    }
}
