package leetcode;

public class LC_3110 {


        public int scoreOfString(String s) {

            int sum = 0;

            for (int i = 0; i < s.length() - 1; i++) {

                sum += Math.abs(s.charAt(i) - s.charAt(i + 1));

            }

            return sum;
        }

        public static void main(String[] args) {

            LC_3110 obj = new LC_3110();

            String s = "hello";

            System.out.println(obj.scoreOfString(s));
        }
    }

