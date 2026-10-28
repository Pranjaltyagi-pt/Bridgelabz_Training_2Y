package PracticeProblem;

public class ReplaceCharacter {
            public static String replace(String s, int i) {
            if (i == s.length()) {
                return "";
            }

            char ch = s.charAt(i);

            if (ch == 'a') {
                ch = 'b';
            }

            return ch + replace(s, i + 1);
        }

        public static void main(String[] args) {
            String s = "banana";
            System.out.println(replace(s, 0));
            }
}