package Recursion;

public class PrintAllSubsets {
    public static void main(String[] args) {
        String s = "abc";
        allSubsets(s);
    }

    static void allSubsets(String s) {
        allSubsets(s, 0, "");
    }

    static void allSubsets(String s, int i, String curr) {
        if (i == s.length()) {
            System.out.println(curr);
            return;
        }
        allSubsets(s, i + 1, curr);
        allSubsets(s, i + 1, curr + s.charAt(i));
    }

}
