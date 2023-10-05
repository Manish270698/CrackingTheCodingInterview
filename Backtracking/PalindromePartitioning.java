package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "nnwesipil";
        List<List<String>> ans = new ArrayList<>();
        findPartition(ans, new ArrayList<>(), s, 0);
        for(List<String> l : ans){
            System.out.println(l);
        }
        System.out.println(ans);
    }

    // T.C: O(2^n) , S.C: O(n)
    private static void findPartition(List<List<String>> ans, List<String> arr, String s, int index){
        if(index == s.length()){
            List<String> l = new ArrayList<>(arr);
            ans.add(l);
            return;
        }

        for(int i=index; i<s.length(); i++){
            if(isPalindrome(s, index, i)){
                arr.add(s.substring(index, i+1));
                findPartition(ans, arr, s, i+1);
                arr.remove(arr.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String s, int left, int right){
        while(left<= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
