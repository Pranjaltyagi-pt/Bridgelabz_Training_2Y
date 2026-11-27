package strings.level3;

import java.util.Scanner;

// Program 8: Check whether two texts are anagrams
public class AnagramCheck {
    public static boolean isAnagram(String first, String second) {
        // Lengths must be equal
        if (first.length() != second.length()) {
            return false;
        }

        // Frequency arrays for both texts (256 ASCII characters)
        int[] frequencyFirst = new int[256];
        int[] frequencySecond = new int[256];
        for (int i = 0; i < first.length(); i++) {
            frequencyFirst[first.charAt(i)]++;
            frequencySecond[second.charAt(i)]++;
        }

        // Compare the frequencies
        for (int i = 0; i < frequencyFirst.length; i++) {
            if (frequencyFirst[i] != frequencySecond[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first text: ");
        String first = input.nextLine();
        System.out.print("Enter second text: ");
        String second = input.nextLine();
        input.close();

        if (isAnagram(first, second)) {
            System.out.println("The two texts are anagrams.");
        } else {
            System.out.println("The two texts are not anagrams.");
        }
    }
}
