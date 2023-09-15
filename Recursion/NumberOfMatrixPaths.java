package Recursion;

import java.util.Scanner;

public class NumberOfMatrixPaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.close();
        System.out.println(paths(m,n));
    }

    // T.C: O(2^n) S.C:O(n) , when n is bigger
    static int paths(int m, int n){
        if(m==1 || n==1) return 1;

        return paths(m-1, n) + paths(m, n-1);
    }
}
