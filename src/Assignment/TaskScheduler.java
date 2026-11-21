package Assignment;
import java.util.Scanner;
public class TaskScheduler {
    static class Node {
            int taskId;
            String taskName;
            int priority;
            String dueDate;
            Node next;

            Node(int taskId, String taskName, int priority, String dueDate) {
                this.taskId = taskId;
                this.taskName = taskName;
                this.priority = priority;
                this.dueDate = dueDate;
            }
        }

        static Node head = null;
        static Node tail = null;
        static Node current = null;

        // Add task at beginning
        static void addBeginning(int id, String name, int priority, String date) {
            Node newNode = new Node(id, name, priority, date);

            if (head == null) {
                head = tail = newNode;
                tail.next = head;
            } else {
                newNode.next = head;
                head = newNode;
                tail.next = head;
            }

            if (current == null) {
                current = head;
            }

            System.out.println("Task added successfully!");
        }

        // Add task at end
        static void addEnd(int id, String name, int priority, String date) {
            Node newNode = new Node(id, name, priority, date);

            if (head == null) {
                head = tail = newNode;
                tail.next = head;
            } else {
                tail.next = newNode;
                tail = newNode;
                tail.next = head;
            }

            if (current == null) {
                current = head;
            }

            System.out.println("Task added successfully!");
        }

        // Add task at specific position
        static void addPosition(int id, String name, int priority,
                                String date, int pos) {

            if (pos < 1) {
                System.out.println("Invalid position!");
                return;
            }

            if (pos == 1) {
                addBeginning(id, name, priority, date);
                return;
            }

            if (head == null) {
                System.out.println("Invalid position!");
                return;
            }

            Node temp = head;
            int count = 1;

            while (count < pos - 1 && temp != tail) {
                temp = temp.next;
                count++;
            }

            if (count != pos - 1) {
                System.out.println("Invalid position!");
                return;
            }

            Node newNode = new Node(id, name, priority, date);

            newNode.next = temp.next;
            temp.next = newNode;

            if (temp == tail) {
                tail = newNode;
            }

            tail.next = head;

            System.out.println("Task added successfully!");
        }

        // Remove task by ID
        static void removeTask(int id) {

            if (head == null) {
                System.out.println("No tasks available!");
                return;
            }

            Node temp = head;
            Node prev = tail;

            do {
                if (temp.taskId == id) {

                    if (head == tail) {
                        head = tail = current = null;
                    } else {
                        prev.next = temp.next;

                        if (temp == head) {
                            head = temp.next;
                        }

                        if (temp == tail) {
                            tail = prev;
                        }

                        tail.next = head;

                        if (current == temp) {
                            current = temp.next;
                        }
                    }

                    System.out.println("Task removed successfully!");
                    return;
                }

                prev = temp;
                temp = temp.next;

            } while (temp != head);

            System.out.println("Task not found!");
        }

        // Display one task
        static void displayTask(Node temp) {
            System.out.println("Task ID: " + temp.taskId);
            System.out.println("Task Name: " + temp.taskName);
            System.out.println("Priority: " + temp.priority);
            System.out.println("Due Date: " + temp.dueDate);
            System.out.println("-------------------------");
        }

        // View current task
        static void viewCurrentTask() {

            if (current == null) {
                System.out.println("No tasks available!");
                return;
            }

            System.out.println("\nCurrent Task:");
            displayTask(current);
        }

        // Move to next task
        static void nextTask() {

            if (current == null) {
                System.out.println("No tasks available!");
                return;
            }

            current = current.next;

            System.out.println("\nNext Task:");
            displayTask(current);
        }

        // Display all tasks
        static void displayAll() {

            if (head == null) {
                System.out.println("No tasks available!");
                return;
            }

            Node temp = head;

            System.out.println("\nAll Tasks:");

            do {
                displayTask(temp);
                temp = temp.next;
            } while (temp != head);
        }

        // Search task by priority
        static void searchPriority(int priority) {

            if (head == null) {
                System.out.println("No tasks available!");
                return;
            }

            Node temp = head;
            boolean found = false;

            do {
                if (temp.priority == priority) {
                    displayTask(temp);
                    found = true;
                }

                temp = temp.next;

            } while (temp != head);

            if (!found) {
                System.out.println("Task not found!");
            }
        }

        // Main method
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            while (true) {

                System.out.println("\n===== TASK SCHEDULER =====");
                System.out.println("1. Add Task at Beginning");
                System.out.println("2. Add Task at End");
                System.out.println("3. Add Task at Position");
                System.out.println("4. Remove Task by ID");
                System.out.println("5. View Current Task");
                System.out.println("6. Move to Next Task");
                System.out.println("7. Display All Tasks");
                System.out.println("8. Search by Priority");
                System.out.println("9. Exit");

                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                    case 2:
                    case 3:

                        System.out.print("Enter Task ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Task Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Priority: ");
                        int priority = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Due Date: ");
                        String date = sc.nextLine();

                        if (choice == 1) {
                            addBeginning(id, name, priority, date);
                        } else if (choice == 2) {
                            addEnd(id, name, priority, date);
                        } else {
                            System.out.print("Enter Position: ");
                            int pos = sc.nextInt();

                            addPosition(id, name, priority, date, pos);
                        }

                        break;

                    case 4:
                        System.out.print("Enter Task ID: ");
                        removeTask(sc.nextInt());
                        break;

                    case 5:
                        viewCurrentTask();
                        break;

                    case 6:
                        nextTask();
                        break;

                    case 7:
                        displayAll();
                        break;

                    case 8:
                        System.out.print("Enter Priority: ");
                        searchPriority(sc.nextInt());
                        break;

                    case 9:
                        System.out.println("Program Ended!");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid Choice!");
                }
            }
        }
    }
