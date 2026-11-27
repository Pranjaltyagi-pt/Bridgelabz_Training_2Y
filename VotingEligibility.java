package strings.level2;

import java.util.Scanner;

// Program 8: Voting eligibility of students using random 2-digit ages
public class VotingEligibility {
    // Generate n random 2-digit ages (10 to 99)
    public static int[] generateAges(int n) {
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = (int) (Math.random() * 90) + 10;
        }
        return ages;
    }

    // Return 2D array of age and whether the student can vote
    public static String[][] checkVoting(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) {
                result[i][1] = "false";
            } else {
                result[i][1] = String.valueOf(ages[i] >= 18);
            }
        }
        return result;
    }

    // Display in tabular format
    public static void display(String[][] table) {
        System.out.println("Student\tAge\tCan Vote");
        for (int i = 0; i < table.length; i++) {
            System.out.println((i + 1) + "\t" + table[i][0] + "\t" + table[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = input.nextInt();
        input.close();
        if (n <= 0) {
            System.out.println("Invalid number of students.");
            return;
        }

        display(checkVoting(generateAges(n)));
    }
}
