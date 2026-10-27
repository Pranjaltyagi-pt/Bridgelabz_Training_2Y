package PracticeProblem;

public class PrintEachCharacter {
    public static void print(String s, int i) {
            if (i == s.length()) {
                return;
            }

            System.out.println(s.charAt(i));

            print(s, i + 1);
        }

        public static void main(String[] args) {
            String s = "JAVA";
            print(s, 0);
    }
}