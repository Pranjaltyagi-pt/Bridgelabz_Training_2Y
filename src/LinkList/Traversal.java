package LinkList;

public class Traversal {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
    public static Node head;
    public static Node tail;

    public static void InsertAtEnd(int value){
        Node temp = new Node(value);
        if(head == null){
            head = temp;
            tail = temp;
        }
        else{
            tail.next = temp;
            tail = temp;
        }
    }
    public static void InsertAtStart(int value){
        Node temp = new Node(value);
        if(head==null){
            head=temp;
            tail=temp;
        }else{
            temp.next = head;
            head=temp;
        }
    }
    public static void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
    }
    public static int countNodes() {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }
    static void main(String[] args){
        InsertAtStart(5);
        InsertAtEnd(10);
        InsertAtEnd(20);
        InsertAtEnd(30);
        InsertAtEnd(40);
        display();

        System.out.println("\nTotal Nodes: " + countNodes());
    }
}