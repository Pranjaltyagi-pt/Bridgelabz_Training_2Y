package Stack;

public class Main {

        static void main(String[] args) {
            StackOps st = new StackOps();
            StackOps2 st1 = new StackOps2();
            st.push(10);
            st.push(20);
            st.push(30);
            st.push(40);
            st.push(50);
            st.display();
            

            st1.push(10);
            st1.push(20);
            st1.push(30);
            st1.push(40);
            st1.push(50);
            st1.push(60);
            st1.display();

            st1.pop();
            st1.pop();
            st1.pop();
            st1.pop();
            st1.pop();
            st1.pop();

    }
}
