package leetcode;
import java.util.Scanner;
public class LC_2176 {



        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter size of array: ");
            int n = sc.nextInt();

            int[] nums = new int[n];

            System.out.println("Enter array elements:");
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            System.out.print("Enter k: ");
            int k = sc.nextInt();

            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {

                    if (nums[i] == nums[j] && (i * j) % k == 0) {
                        count++;
                    }
                }
            }

            System.out.println("Answer: " + count);

            sc.close();
        }
    }


