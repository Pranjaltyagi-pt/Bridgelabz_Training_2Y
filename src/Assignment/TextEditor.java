package Assignment;
import java.util.Scanner;
public class TextEditor {





        static class Node {
            String text;
            Node next, prev;

            Node(String text) {
                this.text = text;
            }
        }

        static Node head = null;
        static Node tail = null;
        static Node current = null;

        static final int MAX_HISTORY = 10;
        static int size = 0;

        // Add new text state
        static void addState(String text) {

            Node newNode = new Node(text);

            if (head == null) {
                head = tail = current = newNode;
                size++;
            } else {

                // Remove redo history
                Node temp = current.next;

                while (temp != null) {
                    size--;
                    temp = temp.next;
                }

                current.next = null;
                tail = current;

                // Add new state
                newNode.prev = current;
                current.next = newNode;
                tail = newNode;
                current = newNode;
                size++;
            }

            // Limit history to last 10 states
            while (size > MAX_HISTORY) {
                head = head.next;
                head.prev = null;
                size--;
            }

            System.out.println("Text updated successfully!");
        }

        // Undo operation
        static void undo() {

            if (current == null || current.prev == null) {
                System.out.println("Nothing to undo!");
                return;
            }

            current = current.prev;

            System.out.println("Undo successful!");
        }

        // Redo operation
        static void redo() {

            if (current == null || current.next == null) {
                System.out.println("Nothing to redo!");
                return;
            }

            current = current.next;

            System.out.println("Redo successful!");
        }

        // Display current text
        static void displayCurrent() {

            if (current == null) {
                System.out.println("Editor is empty!");
                return;
            }

            System.out.println("\nCurrent Text:");
            System.out.println(current.text);
        }

        // Display history
        static void displayHistory() {

            if (head == null) {
                System.out.println("No history available!");
                return;
            }

            Node temp = head;

            System.out.println("\n===== TEXT HISTORY =====");

            while (temp != null) {

                if (temp == current) {
                    System.out.println("-> " + temp.text + " [CURRENT]");
                } else {
                    System.out.println("   " + temp.text);
                }

                temp = temp.next;
            }
        }

        // Main method
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            while (true) {

                System.out.println("\n===== TEXT EDITOR =====");
                System.out.println("1. Type New Text");
                System.out.println("2. Undo");
                System.out.println("3. Redo");
                System.out.println("4. Display Current Text");
                System.out.println("5. Display History");
                System.out.println("6. Exit");

                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        System.out.print("Enter Text: ");
                        String text = sc.nextLine();

                        addState(text);
                        break;

                    case 2:
                        undo();
                        break;

                    case 3:
                        redo();
                        break;

                    case 4:
                        displayCurrent();
                        break;

                    case 5:
                        displayHistory();
                        break;

                    case 6:
                        System.out.println("Text Editor Closed!");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid Choice!");
                }
            }
        }
    }
