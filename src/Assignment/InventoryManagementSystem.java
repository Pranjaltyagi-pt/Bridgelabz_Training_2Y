package Assignment;
import java.util.Scanner;
public class InventoryManagementSystem {

        static class Node {
            String name;
            int id, quantity;
            double price;
            Node next;

            Node(String name, int id, int quantity, double price) {
                this.name = name;
                this.id = id;
                this.quantity = quantity;
                this.price = price;
            }
        }

        static Node head = null;
        static Scanner sc = new Scanner(System.in);


        static Node createItem() {
            sc.nextLine();
            String name = sc.nextLine();
            int id = sc.nextInt();
            int qty = sc.nextInt();
            double price = sc.nextDouble();

            return new Node(name, id, qty, price);
        }
        static void insertBeginning() {
            Node n = createItem();
            n.next = head;
            head = n;
        }
        static void insertEnd() {
            Node n = createItem();

            if (head == null) {
                head = n;
                return;
            }

            Node temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = n;
        }
        static void insertPosition() {
            System.out.print("Enter Position: ");
            int pos = sc.nextInt();

            if (pos < 1) {
                System.out.println("Invalid Position!");
                return;
            }

            if (pos == 1) {
                insertBeginning();
                return;
            }

            Node temp = head;

            for (int i = 1; i < pos - 1 && temp != null; i++)
                temp = temp.next;

            if (temp == null) {
                System.out.println("Invalid Position!");
                return;
            }

            Node n = createItem();
            n.next = temp.next;
            temp.next = n;
        }
        static void removeItem() {
            int id = sc.nextInt();

            if (head != null && head.id == id) {
                head = head.next;
                System.out.println("Item Removed!");
                return;
            }

            Node temp = head;

            while (temp != null && temp.next != null &&
                    temp.next.id != id)
                temp = temp.next;

            if (temp == null || temp.next == null) {
                System.out.println("Item Not Found!");
            } else {
                temp.next = temp.next.next;
                System.out.println("Item Removed!");
            }
        }

        // Update Quantity
        static void updateQuantity() {
            System.out.print("Enter Item ID: ");
            int id = sc.nextInt();

            Node temp = head;

            while (temp != null) {
                if (temp.id == id) {
                    temp.quantity = sc.nextInt();
                    System.out.println("Quantity Updated!");
                    return;
                }
                temp = temp.next;
            }
            System.out.println("Item Not Found!");
        }
        static void searchItem() {
            System.out.println("1. Search by ID");
            System.out.println("2. Search by Name");
            int choice = sc.nextInt();
            sc.nextLine();
            Node temp = head;
            boolean found = false;
            if (choice == 1) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                while (temp != null) {
                    if (temp.id == id) {
                        display(temp);
                        found = true;
                    }
                    temp = temp.next;
                }
            } else {
                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                while (temp != null) {
                    if (temp.name.equalsIgnoreCase(name)) {
                        display(temp);
                        found = true;
                    }
                    temp = temp.next;
                }
            }

            if (!found)
                System.out.println("Item Not Found!");
        }
        static void display(Node n) {
            System.out.println(n.id + " " + n.name + " "
                    + n.quantity + " " + n.price);
        }
        static void totalValue() {
            double total = 0;
            Node temp = head;

            while (temp != null) {
                total += temp.price * temp.quantity;
                temp = temp.next;
            }

            System.out.println("Total Inventory Value: " + total);
        }

        // Sort by Name or Price
        static void sortInventory() {
            System.out.println("1. Sort by Name");
            System.out.println("2. Sort by Price");
            int choice = sc.nextInt();

            System.out.println("1. Ascending");
            System.out.println("2. Descending");
            int order = sc.nextInt();

            for (Node i = head; i != null; i = i.next) {
                for (Node j = i.next; j != null; j = j.next) {

                    boolean swap = false;

                    if (choice == 1) {
                        int cmp = i.name.compareToIgnoreCase(j.name);
                        swap = (order == 1) ? cmp > 0 : cmp < 0;
                    } else {
                        swap = (order == 1)
                                ? i.price > j.price
                                : i.price < j.price;
                    }

                    if (swap) {
                        String name = i.name;
                        i.name = j.name;
                        j.name = name;

                        int id = i.id;
                        i.id = j.id;
                        j.id = id;

                        int qty = i.quantity;
                        i.quantity = j.quantity;
                        j.quantity = qty;

                        double price = i.price;
                        i.price = j.price;
                        j.price = price;
                    }
                }
            }

            System.out.println("Inventory Sorted!");
        }
        static void displayAll() {
            Node temp = head;

            if (head == null) {
                System.out.println("Inventory Empty!");
                return;
            }

            while (temp != null) {
                display(temp);
                temp = temp.next;
            }
        }

        public static void main(String[] args) {

            while (true) {
                System.out.println("\n1. Add Beginning");
                System.out.println("2. Add End");
                System.out.println("3. Add Position");
                System.out.println("4. Remove Item");
                System.out.println("5. Update Quantity");
                System.out.println("6. Search Item");
                System.out.println("7. Total Value");
                System.out.println("8. Sort Inventory");
                System.out.println("9. Display All");
                System.out.println("10. Exit");

                System.out.print("Enter Choice: ");
                int ch = sc.nextInt();

                switch (ch) {
                    case 1: insertBeginning(); break;
                    case 2: insertEnd(); break;
                    case 3: insertPosition(); break;
                    case 4: removeItem(); break;
                    case 5: updateQuantity(); break;
                    case 6: searchItem(); break;
                    case 7: totalValue(); break;
                    case 8: sortInventory(); break;
                    case 9: displayAll(); break;
                    case 10: return;
                    default: System.out.println("Invalid Choice!");
                }
            }
        }
}