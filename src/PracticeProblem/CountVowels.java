package PracticeProblem;

public class CountVowels {
    public static int count(String s, int i) {
            if (i == s.length()) {
                return 0;
            }

            int n = 0;
            char ch = s.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i'
                    || ch == 'o' || ch == 'u') {
                n = 1;
            }

            return n + count(s, i + 1);
        }

        public static void main(String[] args) {
            String s = "education";
            System.out.println(count(s, 0));
    }
}