package Arrays_and_Strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Is_Unique {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        sc.close();

        System.out.println("Using O(n^2) time: " + (MaxTime(s) ? "true" : "false"));
        System.out.println("Using O(nlog n) time and SC: O(n): Sorting: " + (Sorted(s) ? "true" : "false"));
        System.out.println("Using O(n) time and SC: O(n): HashSet: " + (HashingSet(s) ? "true" : "false"));
        System.out.println("Using O(n) time and SC: O(n): BitVector: " + (BitVector(s) ? "true" : "false"));
        System.out.println("Using O(n) time and SC: O(1): Right/left shift: " + (Shift(s) ? "true" : "false"));
    }

    // Time Commplexity: O(n^2)
    public static boolean MaxTime(String s) {
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == a)
                    return false;
            }
        }
        return true;
    }

    // Time Commplexity: O(nlogn) SC: O(n) ==> Sorting
    public static boolean Sorted(String s) {
        char a[] = s.toCharArray();
        Arrays.sort(a);

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == a[i + 1])
                return false;
        }

        return true;
    }

    // Time Commplexity: O(n) SC: O(n) ==> HashSet
    public static boolean HashingSet(String s) {
        Set<Character> hs = new HashSet<Character>();

        for (char c : s.toCharArray()) {
            if (hs.contains(c))
                return false;
            hs.add(c);
        }
        return true;
    }

    // Time Commplexity: O(n) SC: O(n) ==> boolean array
    public static boolean BitVector(String s) {
        boolean[] ch = new boolean[256];

        if (s.length() > 256)
            return false;

        for (char c : s.toCharArray()) {
            if (ch[c] == true)
                return false;
            ch[c] = true;
        }

        return true;
    }

    // Time Commplexity: O(n) SC: O(1) ==> BitVector Right/left shift
    // assumes only a-z are used
    public static boolean Shift(String s) {
        int check = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((check & 1 << (s.charAt(i) - 'a')) > 0) {
                return false;
            }
            check = check | 1 << (s.charAt(i) - 'a');
        }
        System.out.println(check);
        return true;
    }
}
