package Arrays_and_Strings;

import java.util.Scanner;

public class String_Compression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        sc.close();

        // Don't use string concatenation as it takes O(n^2) time
        System.out.println("Using String: O(n + k^2) time and SC: O(n): " + compress1(s));
        System.out.println("Using String Builder: O(n) time and SC: O(n): " + compress2(s));
        System.out.println("Better: O(n) time and SC: O(n): " + compress3(s));

    }

    // Time Commplexity: O(n) SC: O(n): Worst using String
    public static String compress1(String s) {
        String s1 = new String();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count++;
            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                s1 += "" + s.charAt(i) + count;
                count = 0;
            }
        }
        return s1.length() > s.length() ? s : s1;
    }

    // Time Commplexity: O(n + k^2) SC: O(n) ==> using StringBuilder
    public static String compress2(String s) {
        StringBuilder s1 = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count++;

            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                s1.append(s.charAt(i));
                s1.append(count);
                count = 0;
            }
        }

        return s1.length() > s.length() ? s : s1.toString();
    }

    // Time Commplexity: O(n) SC: O(n) ==> check for final string length in
    // beginning
    // if compressed_string_length > original_string_length then no need to use
    // space to create the final string
    // Downside: some duplicate code and extra loop
    public static String compress3(String s) {
        int compressedLength = findCompressedLength(s);
        if (compressedLength > s.length()) {
            return s;
        }

        // compressedLength helps to define the size of StringBuilder to the necessary
        // capacity up-front
        StringBuilder s1 = new StringBuilder(compressedLength);

        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            counter++;
            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                s1.append(s.charAt(i));
                s1.append(counter);
                counter = 0;
            }
        }
        return s1.toString();
    }

    public static int findCompressedLength(String s) {
        int compressedLength = 0;
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            counter++;
            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                compressedLength += 1 + Integer.toString(counter).length(); // because length > 1 when counter > 9
                counter = 0;
            }
        }
        return compressedLength;
    }
}
