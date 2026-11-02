package leetcode;

public class LC_541 {


        public String reverseStr(String s, int k) {

            char[] arr = s.toCharArray();

            for (int i = 0; i < arr.length; i = i + 2 * k) {

                int start = i;
                int end = Math.min(i + k - 1, arr.length - 1);

                while (start < end) {
                    char temp = arr[start];
                    arr[start] = arr[end];
                    arr[end] = temp;

                    start++;
                    end--;
                }
            }

            return new String(arr);
        }

        public static void main(String[] args) {

            LC_541 obj = new LC_541();

            String s = "abcdefg";
            int k = 2;

            String result = obj.reverseStr(s, k);

            System.out.println(result);
        }
    }

