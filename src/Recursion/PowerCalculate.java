package Recursion;
import java.util.Scanner;
public class PowerCalculate {
    static int power_calculation(int p,int q){
        if(q==0){
            return 1;
        }
        return p * power_calculation(p,q-1);
    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();

        int q = sc.nextInt();
        int result = power_calculation(q,p);
        System.out.println(result);
    }
}
