package PracticeProblem;

public class RemoveCharacter {
    public static String remove(String s, char ch, int i) {
            if (i == s.length()) {
                return "";
            }

            if (s.charAt(i) == ch) {
                return remove(s, ch, i + 1);
            }

            return s.charAt(i) + remove(s, ch, i + 1);
        }

        public static void main(String[] args) {
            String s = "banana";
            System.out.println(remove(s, 'a', 0));
    }
}