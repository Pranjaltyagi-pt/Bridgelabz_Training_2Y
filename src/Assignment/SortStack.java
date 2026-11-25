package Assignment;
import java.util.Stack;
public class SortStack {
        static void insertSorted(Stack<Integer> st, int x) {

            if (st.isEmpty() || st.peek() <= x) {
                st.push(x);
                return;
            }

            int temp = st.pop();

            insertSorted(st, x);

            st.push(temp);
        }


        static void sortStack(Stack<Integer> st) {

            if (st.isEmpty()) {
                return;
            }

            int x = st.pop();

            sortStack(st);

            insertSorted(st, x);
        }

        public static void main(String[] args) {

            Stack<Integer> st = new Stack<>();

            st.push(2);
            st.push(4);
            st.push(1);
            st.push(3);

            sortStack(st);

            System.out.println("Sorted Stack: " + st);
        }
    }
