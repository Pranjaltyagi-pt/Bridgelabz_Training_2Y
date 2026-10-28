package PracticeProblem;

public class StringLength {
    public static int findLength(String s, int i) {
            if (i == s.length()) {
                return 0;
            }

            return 1 + findLength(s, i + 1);
        }

        public static void main(String[] args) {
            String s = "hello";
            System.out.println(findLength(s, 0));
    }
}