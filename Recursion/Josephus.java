package Recursion;

import java.util.Scanner;

public class Josephus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();
        System.out.println(josephus(n, k));
    }
    public static int josephus(int n, int k)
    {
       if(n==1) return 1;

      return ((josephus((n-1), k )-1 + k ) % n) + 1;
    }
}
