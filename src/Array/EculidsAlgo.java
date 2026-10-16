package Array;
import java.util.*;
public class EculidsAlgo {
    static int gcd(int a, int b){
        if(b==0){
            return a;
        }
        int small = gcd(b,a%b);
        return small;
    }

    public static int lcm(int a,int b) {
        return (a/gcd(a,b))*b;
    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a = ");
        int a = sc.nextInt();
        System.out.print("Enter b = ");
        int b = sc.nextInt();
        System.out.println("gcd = " + gcd(a, b));
        System.out.println("lcm = " + lcm(a, b));
    }
}
