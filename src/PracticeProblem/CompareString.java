package PracticeProblem;

public class CompareString {
    public static boolean check(String s1, String s2, int i) {
            if (s1.length() != s2.length()) {
                return false;
            }

            if (i == s1.length()) {
                return true;
            }

            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }

            return check(s1, s2, i + 1);
        }

        public static void main(String[] args) {
            String s1 = "hello";
            String s2 = "hello";

            System.out.println(check(s1, s2, 0));
    }
}