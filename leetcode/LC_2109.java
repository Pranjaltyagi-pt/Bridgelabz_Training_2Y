package leetcode;

public class LC_2109 {


        public String addSpaces(String s, int[] spaces) {

            StringBuilder result = new StringBuilder();

            int j = 0;

            for (int i = 0; i < s.length(); i++) {

                if (j < spaces.length && i == spaces[j]) {
                    result.append(" ");
                    j++;
                }

                result.append(s.charAt(i));
            }

            return result.toString();
        }

        public static void main(String[] args) {

            LC_2109 obj = new LC_2109();

            String s = "LeetcodeHelpsMeLearn";
            int[] spaces = {8, 13, 15};

            String result = obj.addSpaces(s, spaces);

            System.out.println(result);
        }
    }

