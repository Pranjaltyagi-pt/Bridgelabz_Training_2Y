package strings.level3;

import java.util.Scanner;

// Program 10: Deck of cards - initialize, shuffle and distribute to players
public class DeckOfCards {
    // Initialize the deck with "rank of suit"
    public static String[] initializeDeck(String[] suits, String[] ranks) {
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];
        int index = 0;
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index++] = ranks[j] + " of " + suits[i];
            }
        }
        return deck;
    }

    // Shuffle by swapping each card with a random card from the remaining deck
    public static String[] shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int) (Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }

    // Distribute n cards to x players; return null if not possible
    public static String[][] distributeCards(String[] deck, int n, int x) {
        if (x <= 0 || n <= 0 || n > deck.length || n % x != 0) {
            return null;
        }
        int cardsPerPlayer = n / x;
        String[][] players = new String[x][cardsPerPlayer];
        int index = 0;
        for (int i = 0; i < cardsPerPlayer; i++) {
            for (int j = 0; j < x; j++) {
                players[j][i] = deck[index++];
            }
        }
        return players;
    }

    // Print the players and their cards
    public static void printPlayers(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + ":");
            for (int j = 0; j < players[i].length; j++) {
                System.out.println("   " + players[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of cards to distribute: ");
        int n = input.nextInt();
        System.out.print("Enter number of players: ");
        int x = input.nextInt();
        input.close();

        String[] deck = shuffleDeck(initializeDeck(suits, ranks));
        String[][] players = distributeCards(deck, n, x);
        if (players == null) {
            System.out.println("Cards cannot be distributed equally among the players.");
        } else {
            printPlayers(players);
        }
    }
}
