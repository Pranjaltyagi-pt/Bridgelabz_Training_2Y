package String;

public class moveZeroes {


        public void moveZeroes(int[] nums) {

            int insertPos = 0;

            for (int num : nums) {
                if (num != 0) {
                    nums[insertPos++] = num;
                }
            }

            while (insertPos < nums.length) {
                nums[insertPos++] = 0;
            }
        }

        public static void main(String[] args) {

            moveZeroes obj = new moveZeroes();

            int[] nums = {0, 1, 0, 3, 12};

            obj.moveZeroes(nums);

            for (int num : nums) {
                System.out.print(num + " ");
            }
        }
    }

