package Arrays_and_Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Palindrome_Permutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        System.out.println("Using O(n^2) time: " + (UsingHashMap(s) ? "true" : "false"));
        System.out.println("Using O(n^2) time: " + (UsingCountArray(s) ? "true" : "false"));
        // System.out.println("Using O(n^2) time: " + (UsingBitVector(s) ? "true" :
        // "false"));
    }

    // Time Commplexity: O(n) SC: O(n) ==> HashMap
    public static boolean UsingHashMap(String s) {
        Map<Character, Integer> m = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (Character.getNumericValue(c) >= Character.getNumericValue('a')) {
                m.put(c, m.getOrDefault(c, 0) + 1);
            }
        }
        int oddValues = 0;
        for (Integer f : m.values()) {
            if (f % 2 == 1)
                oddValues++;
        }

        return oddValues > 1 ? false : true;
    }

    // Time Commplexity: O(n) SC: O(1) ==> Count Array
    public static boolean UsingCountArray(String s) {
        int[] counter = new int[26]; // assumtion: only alphabets between a-z are used

        for (char c : s.toCharArray()) {
            // if (Character.getNumericValue(c) >= Character.getNumericValue('a')
            // && Character.getNumericValue(c) <= Character.getNumericValue('z'))
            if (c >= 'a'
                    && c <= 'z') {
                // int x = Character.getNumericValue(c) - Character.getNumericValue('a');
                int x = c - 'a';
                counter[x]++;
            }
        }

        int oddValues = 0;
        for (int i : counter) {
            if (i % 2 == 1)
                oddValues++;
        }
        return oddValues > 1 ? false : true;
    }

    // Time Commplexity: O(n) SC: O(1) ==> Bit Vector
    // public static boolean UsingBitVector(String s){
    // return true;
    // }
}
