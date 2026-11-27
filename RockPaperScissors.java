package strings.level2;

import java.util.Scanner;

// Program 9: Rock Paper Scissors between user and computer
public class RockPaperScissors {
    // Computer choice using Math.random()
    public static String getComputerChoice() {
        int value = (int) (Math.random() * 3);
        if (value == 0) {
            return "rock";
        } else if (value == 1) {
            return "paper";
        }
        return "scissors";
    }

    // Return "user", "computer" or "draw"
    public static String findWinner(String user, String computer) {
        if (user.equals(computer)) {
            return "draw";
        }
        if ((user.equals("rock") && computer.equals("scissors"))
                || (user.equals("paper") && computer.equals("rock"))
                || (user.equals("scissors") && computer.equals("paper"))) {
            return "user";
        }
        return "computer";
    }

    // Return 2D array: {player, wins, percentage}
    public static String[][] findStats(int userWins, int computerWins, int games) {
        String[][] stats = new String[2][3];
        stats[0][0] = "Player";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.format("%.2f%%", userWins * 100.0 / games);
        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.format("%.2f%%", computerWins * 100.0 / games);
        return stats;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int games = input.nextInt();
        if (games <= 0) {
            System.out.println("Invalid number of games.");
            input.close();
            return;
        }

        int userWins = 0;
        int computerWins = 0;
        System.out.println("Game\tPlayer\t\tComputer\tWinner");
        for (int i = 1; i <= games; i++) {
            System.out.print("Game " + i + " - enter rock, paper or scissors: ");
            String user = input.next().toLowerCase();
            // Validate the choice
            if (!user.equals("rock") && !user.equals("paper") && !user.equals("scissors")) {
                System.out.println("Invalid choice. Try again.");
                i--;
                continue;
            }
            String computer = getComputerChoice();
            String winner = findWinner(user, computer);
            if (winner.equals("user")) {
                userWins++;
            } else if (winner.equals("computer")) {
                computerWins++;
            }
            System.out.println(i + "\t" + user + "\t\t" + computer + "\t\t" + winner);
        }
        input.close();

        // Display the stats
        String[][] stats = findStats(userWins, computerWins, games);
        System.out.println("\nPlayer\t\tWins\tWin %");
        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t\t" + stats[i][1] + "\t" + stats[i][2]);
        }
    }
}
