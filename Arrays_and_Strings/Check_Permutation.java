package Arrays_and_Strings;

import java.util.Arrays;
import java.util.Scanner;

public class Check_Permutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        sc.close();

        System.out.println("Sorting==> TC: O(nlog n), SC: O(n+m): " + (Sorting(s1, s2) ? "true" : "false"));
        System.out.println("Extra Array Space==> TC: O(n), SC: O(1): " + (ArraySpace(s1, s2) ? "true" : "false"));
    }

    // Time Commplexity: O(nlogn) SC: O(n) ==> Sorting
    public static boolean Sorting(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);

        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i])
                return false;
        }

        return true;
    }

    // Time Commplexity: O(n) SC: O(n) ==> Array Space
    public static boolean ArraySpace(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        int[] letters = new int[256]; // Assumption ASCII
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i)]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            letters[s2.charAt(i)]--;
            if (letters[s2.charAt(i)] < 0)
                return false;
        }

        return true;
    }
}
