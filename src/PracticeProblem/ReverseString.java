package PracticeProblem;

import java.util.Scanner;

public class ReverseString {
    public static void print(String S1,int index){
        if(index==S1.length()){
            return;
        }

        print(S1,index+1);
        System.out.print(S1.charAt(index));

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        print(s, 0);
    }
}
