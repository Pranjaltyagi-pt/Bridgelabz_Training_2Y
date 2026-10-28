package PracticeProblem;

public class RemoveDuplicates {
    public static String remove(String s, int i, String result) {
            if (i == s.length()) {
                return result;
            }

            char ch = s.charAt(i);

            if (result.indexOf(ch) == -1) {
                result = result + ch;
            }

            return remove(s, i + 1, result);
        }

        public static void main(String[] args) {
            String s = "programming";
            System.out.println(remove(s, 0, ""));
    }
}