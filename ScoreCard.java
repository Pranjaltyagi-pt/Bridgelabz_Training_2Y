package strings.level2;

import java.util.Scanner;

// Program 10: Scorecard of students with random PCM marks, percentage and grade
public class ScoreCard {
    // Generate random 2-digit PCM scores for n students
    public static int[][] generateScores(int n) {
        int[][] scores = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = (int) (Math.random() * 90) + 10;
            }
        }
        return scores;
    }

    // Return {total, average, percentage} for each student rounded to 2 digits
    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = total * 100.0 / 300;
            results[i][0] = total;
            results[i][1] = Math.round(average * 100) / 100.0;
            results[i][2] = Math.round(percentage * 100) / 100.0;
        }
        return results;
    }

    // Return grade for each student from the percentage
    public static String[] calculateGrades(double[][] results) {
        String[] grades = new String[results.length];
        for (int i = 0; i < results.length; i++) {
            double percentage = results[i][2];
            if (percentage >= 80) {
                grades[i] = "A";
            } else if (percentage >= 70) {
                grades[i] = "B";
            } else if (percentage >= 60) {
                grades[i] = "C";
            } else if (percentage >= 50) {
                grades[i] = "D";
            } else if (percentage >= 40) {
                grades[i] = "E";
            } else {
                grades[i] = "R";
            }
        }
        return grades;
    }

    // Display the scorecard
    public static void display(int[][] scores, double[][] results, String[] grades) {
        System.out.println("Student\tPhysics\tChem\tMaths\tTotal\tAverage\tPercent\tGrade");
        for (int i = 0; i < scores.length; i++) {
            System.out.println((i + 1) + "\t" + scores[i][0] + "\t" + scores[i][1] + "\t" + scores[i][2]
                    + "\t" + (int) results[i][0] + "\t" + results[i][1] + "\t" + results[i][2] + "\t" + grades[i]);
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

        int[][] scores = generateScores(n);
        double[][] results = calculateResults(scores);
        display(scores, results, calculateGrades(results));
    }
}
