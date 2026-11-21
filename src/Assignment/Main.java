package Assignment;
import java.util.Scanner;
public class Main {





        static class Node {
            String title, director;
            int year;
            double rating;
            Node next, prev;

            Node(String title, String director, int year, double rating) {
                this.title = title;
                this.director = director;
                this.year = year;
                this.rating = rating;
            }
        }

        static Node head = null;
        static Node tail = null;

        // Add at beginning
        static void addBeginning(String title, String director, int year, double rating) {
            Node newNode = new Node(title, director, year, rating);

            if (head == null) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }

            System.out.println("Movie added successfully!");
        }

        // Add at end
        static void addEnd(String title, String director, int year, double rating) {
            Node newNode = new Node(title, director, year, rating);

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }

            System.out.println("Movie added successfully!");
        }

        // Add at specific position (1-based)
        static void addPosition(String title, String director, int year,
                                double rating, int pos) {

            if (pos < 1) {
                System.out.println("Invalid position!");
                return;
            }

            if (pos == 1) {
                addBeginning(title, director, year, rating);
                return;
            }

            Node temp = head;

            for (int i = 1; i < pos - 1 && temp != null; i++) {
                temp = temp.next;
            }

            if (temp == null) {
                System.out.println("Invalid position!");
                return;
            }

            Node newNode = new Node(title, director, year, rating);

            newNode.next = temp.next;
            newNode.prev = temp;

            if (temp.next != null) {
                temp.next.prev = newNode;
            } else {
                tail = newNode;
            }

            temp.next = newNode;

            System.out.println("Movie added successfully!");
        }

        // Remove movie by title
        static void removeMovie(String title) {
            Node temp = head;

            while (temp != null &&
                    !temp.title.equalsIgnoreCase(title)) {
                temp = temp.next;
            }

            if (temp == null) {
                System.out.println("Movie not found!");
                return;
            }

            if (temp.prev != null) {
                temp.prev.next = temp.next;
            } else {
                head = temp.next;
            }

            if (temp.next != null) {
                temp.next.prev = temp.prev;
            } else {
                tail = temp.prev;
            }

            System.out.println("Movie removed successfully!");
        }

        // Search by director
        static void searchDirector(String director) {
            Node temp = head;
            boolean found = false;

            while (temp != null) {
                if (temp.director.equalsIgnoreCase(director)) {
                    displayMovie(temp);
                    found = true;
                }
                temp = temp.next;
            }

            if (!found) {
                System.out.println("Movie not found!");
            }
        }

        // Search by rating
        static void searchRating(double rating) {
            Node temp = head;
            boolean found = false;

            while (temp != null) {
                if (temp.rating == rating) {
                    displayMovie(temp);
                    found = true;
                }
                temp = temp.next;
            }

            if (!found) {
                System.out.println("Movie not found!");
            }
        }

        // Display single movie
        static void displayMovie(Node temp) {
            System.out.println("\nMovie Title: " + temp.title);
            System.out.println("Director: " + temp.director);
            System.out.println("Release Year: " + temp.year);
            System.out.println("Rating: " + temp.rating);
            System.out.println("-------------------------");
        }

        // Display forward
        static void displayForward() {
            if (head == null) {
                System.out.println("No movies available!");
                return;
            }

            Node temp = head;

            while (temp != null) {
                displayMovie(temp);
                temp = temp.next;
            }
        }

        // Display reverse
        static void displayReverse() {
            if (tail == null) {
                System.out.println("No movies available!");
                return;
            }

            Node temp = tail;

            while (temp != null) {
                displayMovie(temp);
                temp = temp.prev;
            }
        }

        // Update rating by title
        static void updateRating(String title, double rating) {
            Node temp = head;

            while (temp != null) {
                if (temp.title.equalsIgnoreCase(title)) {
                    temp.rating = rating;
                    System.out.println("Rating updated successfully!");
                    return;
                }
                temp = temp.next;
            }

            System.out.println("Movie not found!");
        }

        // Main method
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            while (true) {

                System.out.println("\n===== MOVIE MANAGEMENT SYSTEM =====");
                System.out.println("1. Add Movie at Beginning");
                System.out.println("2. Add Movie at End");
                System.out.println("3. Add Movie at Position");
                System.out.println("4. Remove Movie");
                System.out.println("5. Search by Director");
                System.out.println("6. Search by Rating");
                System.out.println("7. Display Forward");
                System.out.println("8. Display Reverse");
                System.out.println("9. Update Rating");
                System.out.println("10. Exit");

                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                    case 2:
                    case 3:
                        System.out.print("Enter Movie Title: ");
                        String title = sc.nextLine();

                        System.out.print("Enter Director: ");
                        String director = sc.nextLine();

                        System.out.print("Enter Release Year: ");
                        int year = sc.nextInt();

                        System.out.print("Enter Rating: ");
                        double rating = sc.nextDouble();

                        if (choice == 1) {
                            addBeginning(title, director, year, rating);
                        } else if (choice == 2) {
                            addEnd(title, director, year, rating);
                        } else {
                            System.out.print("Enter Position: ");
                            int pos = sc.nextInt();
                            addPosition(title, director, year, rating, pos);
                        }
                        break;

                    case 4:
                        System.out.print("Enter Movie Title: ");
                        removeMovie(sc.nextLine());
                        break;

                    case 5:
                        System.out.print("Enter Director: ");
                        searchDirector(sc.nextLine());
                        break;

                    case 6:
                        System.out.print("Enter Rating: ");
                        searchRating(sc.nextDouble());
                        break;

                    case 7:
                        displayForward();
                        break;

                    case 8:
                        displayReverse();
                        break;

                    case 9:
                        System.out.print("Enter Movie Title: ");
                        String movieTitle = sc.nextLine();

                        System.out.print("Enter New Rating: ");
                        double newRating = sc.nextDouble();

                        updateRating(movieTitle, newRating);
                        break;

                    case 10:
                        System.out.println("Program Ended!");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid Choice!");
                }
            }
        }
    }


