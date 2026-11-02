package leetcode;

public class LC_1470 {


        public int[] shuffle(int[] nums, int n) {

            int[] result = new int[nums.length];
            int j = 0;

            for (int i = 0; i < n; i++) {
                result[j++] = nums[i];
                result[j++] = nums[i + n];
            }

            return result;
        }

        public static void main(String[] args) {

            LC_1470 obj = new LC_1470();

            int[] nums = {2, 5, 1, 3, 4, 7};
            int n = 3;

            int[] result = obj.shuffle(nums, n);

            for (int num : result) {
                System.out.print(num + " ");
            }
        }

}
