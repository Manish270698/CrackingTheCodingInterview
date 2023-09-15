package Recursion;

import java.util.Scanner;

public class NthFibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(nthFibonacci(n));
    }

    public static int nthFibonacci(int n) {
        if (n <= 1)
            return n;

        return nthFibonacci(n - 1) + nthFibonacci(n - 2);
    }
}
