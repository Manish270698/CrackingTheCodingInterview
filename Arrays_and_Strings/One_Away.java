package Arrays_and_Strings;

import java.util.Scanner;

public class One_Away {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.nextLine();
        String second = sc.nextLine();
        sc.close();

        System.out.println("Using O(n) time and SC: O(1): Separate for replacement and insertion/deletion: "
                + (separate(first, second) ? "true" : "false"));
        System.out.println("Using O(n) time and SC: O(1): Common for replacement and insertion/deletion: "
                + (common(first, second) ? "true" : "false"));
    }

    // Separate for replacement and insertion/deletion
    public static boolean separate(String first, String second) {
        if (first.length() == second.length())
            return oneEditReplace(first, second);
        else if (first.length() + 1 == second.length())
            return oneEditInsert(first, second);
        else if (first.length() - 1 == second.length())
            return oneEditInsert(second, first);

        return false;
    }

    public static boolean oneEditReplace(String s1, String s2) {
        boolean foundDiff = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDiff) {
                    return false;
                }
                foundDiff = true;
            }
        }
        return true;
    }

    public static boolean oneEditInsert(String s1, String s2) {
        int i = 0;
        int j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) != s2.charAt(j)) {
                if (i != j) {
                    return false;
                }
                j++;
            } else {
                i++;
                j++;
            }
        }
        return true;
    }

    // Common for replacement and insertion/deletion
    public static boolean common(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        return oneEditAway(s1, s2);

    }

    public static boolean oneEditAway(String s1, String s2) {
        int i = 0;
        int j = 0;
        boolean foundDiff = false;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) != s2.charAt(j)) {
                // make sure this is the first difference found
                if (foundDiff) {
                    return false;
                }
                foundDiff = true;
                // when characters are diff and length same, move shorter index
                if (s1.length() == s2.length()) {
                    i++;
                }
            }
            // if matching, move shorter index
            else {
                i++;
            }
            // bigger index will move evrytime
            j++;
        }
        return true;
    }
}
