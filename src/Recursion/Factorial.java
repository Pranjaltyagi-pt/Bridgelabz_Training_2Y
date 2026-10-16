package Recursion;

public class Factorial {
    public static int fact(int n ) {
        if (n == 1) {
            return n;
        }
        int small = fact(n-1);
        return n*small;
    }

    static void main(String[] args) {
        int result=fact(10);
        System.out.print(result);
    }
}