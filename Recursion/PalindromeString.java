package Recursion;

import java.util.Scanner;

public class PalindromeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        sc.close();
        System.out.println(isPalindrome(s, 0, s.length() - 1));
    }

    // T.C: O(n)
    public static boolean isPalindrome(String s, int l, int r) {
        if (l >= r)
            return true;
        if (s.charAt(l) != s.charAt(r))
            return false;
        else
            return isPalindrome(s, l + 1, r - 1);
    }
}
