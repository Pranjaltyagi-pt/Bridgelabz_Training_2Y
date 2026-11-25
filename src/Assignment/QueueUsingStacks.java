package Assignment;
import java.util.Stack;
public class QueueUsingStacks {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();


        void enqueue(int x) {
            stack1.push(x);
        }


        int dequeue() {

            if (stack2.isEmpty()) {

                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }

            if (stack2.isEmpty()) {
                return -1;
            }

            return stack2.pop();
        }


        int peek() {

            if (stack2.isEmpty()) {

                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }

            if (stack2.isEmpty()) {
                return -1;
            }

            return stack2.peek();
        }

        public static void main(String[] args) {

            QueueUsingStacks q = new QueueUsingStacks();

            q.enqueue(10);
            q.enqueue(20);
            q.enqueue(30);

            System.out.println("Dequeue: " + q.dequeue());
            System.out.println("Dequeue: " + q.dequeue());

            q.enqueue(40);

            System.out.println("Peek: " + q.peek());
            System.out.println("Dequeue: " + q.dequeue());
            System.out.println("Dequeue: " + q.dequeue());
        }
}