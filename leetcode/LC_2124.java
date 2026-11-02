package leetcode;

public class LC_2124 {


        public boolean checkString(String s) {
            return !s.contains("ba");
        }

        public static void main(String[] args) {

            LC_2124 obj = new LC_2124();

            String s = "aaabbb";

            System.out.println(obj.checkString(s));
        }
    }

