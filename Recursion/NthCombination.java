package Recursion;

import java.util.Scanner;

public class NthCombination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        System.out.println(nCr(a, b));
    }

    public static int nCr(int n, int r) {
        if (n == r || r == 0)
            return 1;

        return nCr(n - 1, r - 1) + nCr(n - 1, r);
    }
}
