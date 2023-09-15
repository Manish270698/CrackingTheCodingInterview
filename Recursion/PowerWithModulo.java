package Recursion;

import java.util.Scanner;

public class PowerWithModulo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        int b = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        System.out.println(fastPower(a, b, m));
    }

    // T.C: (log b)
    static double fastPower(double a, int b, int m) {
        if (b == 0)
            return 1;

        if (b < 0)
            return fastPower(1 / a, Math.abs(b), m);

        if (b % 2 == 0) {
            return (fastPower((a % m * a % m) % m, b / 2, m)) % m;
        } else {
            return (a % m * fastPower(a, b - 1, m) % m) % m;
        }

    }
}
