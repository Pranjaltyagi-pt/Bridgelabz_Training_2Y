package leetcode;

public class LC_2535 {


        public int differenceOfSum(int[] nums) {

            int elementSum = 0;
            int digitSum = 0;

            for (int num : nums) {
                elementSum += num;

                while (num > 0) {
                    digitSum += num % 10;
                    num = num / 10;
                }
            }

            return Math.abs(elementSum - digitSum);
        }

        public static void main(String[] args) {

            LC_2535 obj = new LC_2535();

            int[] nums = {1, 15, 6, 3};

            System.out.println(obj.differenceOfSum(nums));
        }
    }

