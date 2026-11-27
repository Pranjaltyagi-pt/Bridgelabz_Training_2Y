package strings.level2;

import java.util.Scanner;

// Program 5: Count vowels and consonants in a string
public class VowelConsonantCount {
    // Return "Vowel", "Consonant" or "Not a Letter"
    public static String checkCharacter(char ch) {
        // Convert uppercase to lowercase using ASCII values
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

    // Return {vowel count, consonant count}
    public static int[] countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < text.length(); i++) {
            String type = checkCharacter(text.charAt(i));
            if (type.equals("Vowel")) {
                vowels++;
            } else if (type.equals("Consonant")) {
                consonants++;
            }
        }
        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = input.nextLine();
        input.close();

        int[] counts = countVowelsAndConsonants(text);
        System.out.println("Vowels = " + counts[0]);
        System.out.println("Consonants = " + counts[1]);
    }
}
