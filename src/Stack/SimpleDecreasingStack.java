package Stack;
import java.util.*;
public class SimpleDecreasingStack {
    static void main(String[] args) {
        int[] nums = {5, 3, 4, 2, 6};
        Stack<Integer> stack = new Stack<>();

        for(int num : nums){
            while(!stack.isEmpty() && stack.peek() < num){
                stack.pop();
            }
            stack.push(num);
        }
        System.out.println("decreasing Stack: " + stack);
        System.out.println("minimum Element " + stack.peek());
    }
}
