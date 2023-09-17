package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class SmartKeypad {
    public static void main(String[] args) {
        String digits = "23";
        for(String s: letterCombinations(digits)){
            System.out.println(s);
        }
    }

    private static List<String> letterCombinations(String digits){
        String[] map = {
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        List<String> ans = new ArrayList<>();
        letterCombinations(ans, map, digits, 0, new StringBuilder());
        return ans;
    }

    private static void letterCombinations(List<String> ans, String[] map, String digits, int index, StringBuilder cur){
        if(index == digits.length()){
            ans.add(cur.toString());
            return;
        }

        int buttonIndex = digits.charAt(index) - '0';
        String buttonString = map[buttonIndex];

//        for(int i=0; i<buttonString.length(); i++){
//            // No need for backtracking if we directly pass the string to the function instead of modifying it
//            letterCombinations(ans, map, digits, index+1, cur+buttonString.charAt(i));
//        }
        for(char c: buttonString.toCharArray()){
            // Backtracking is required if we use string builder
            cur.append(c);
            letterCombinations(ans, map, digits, index+1, cur);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
