package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        generateBrackets(l, "", 0, 3, 0, 0);
        for(String a : l){
            System.out.println(a);
        }
    }

    // T.C: O(2^n), S.C: O(n)
    private static void generateBrackets(List<String> l, String s, int index, int n, int open, int close) {
        if (index == 2*n) {
            l.add(s);
            return;
        }
        // if(open ==n && close == n){
        //     l.add(s);
        //     return;
        // }

        if (open < n) {
            generateBrackets(l, s + '(', index+1, n, open + 1, close);
            // s = s.substring(0, s.length() - 1); // Backtracking : no need if the string is passed directly in function
        }

        if (open > close) {
            generateBrackets(l, s+')', index+1, n, open, close + 1);
        }
    }
}
