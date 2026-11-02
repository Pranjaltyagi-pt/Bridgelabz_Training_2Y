package leetcode;

public class LC_11 {


        public int maxArea(int[] height) {

            int start = 0;
            int end = height.length - 1;
            int maxval = 0;

            while (start < end) {

                int area = Math.min(height[start], height[end]) * (end - start);

                maxval = Math.max(maxval, area);

                if (height[start] < height[end]) {
                    start++;
                } else {
                    end--;
                }
            }

            return maxval;
        }

        public static void main(String[] args) {

            LC_11 obj = new LC_11();

            int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

            int result = obj.maxArea(height);

            System.out.println("Maximum Area = " + result);
        }
    }

