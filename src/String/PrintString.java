package String;
import java.util.*;
public class PrintString {
    public static void print(String S1,int index){
        if(index==S1.length()){
            return;
        }
        System.out.print(S1.charAt(index));
        print(S1,index+1);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        print(s, 0);
    }
}
