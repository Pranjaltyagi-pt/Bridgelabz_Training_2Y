package String;
import java.util.*;
public class Palindrom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String result= new StringBuilder(str).reverse().toString();
        if(result.equals(str)){
            System.out.println(str +" is palindrom");
        }else{
            System.out.println(str +" is not palindrom");
        }
    }
}
