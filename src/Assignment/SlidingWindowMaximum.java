package Assignment;
import java.util.*;
public class SlidingWindowMaximum {

        static int[] maxSlidingWindow(int[] arr, int k) {

            int n = arr.length;

            if (k <= 0 || k > n) {
                return new int[0];
            }

            int[] result = new int[n - k + 1];

            Deque<Integer> dq = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {

                while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                    dq.pollFirst();
                }

                while (!dq.isEmpty() &&
                        arr[dq.peekLast()] <= arr[i]) {
                    dq.pollLast();
                }

                // Insert current index
                dq.offerLast(i);

                // Store maximum of current window
                if (i >= k - 1) {
                    result[i - k + 1] = arr[dq.peekFirst()];
                }
            }

            return result;
        }

        public static void main(String[] args) {

            int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};

            int k = 3;

            int[] ans = maxSlidingWindow(arr, k);

            System.out.println(Arrays.toString(ans));
        }
    }
