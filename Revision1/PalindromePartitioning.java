package Revision1;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "racecar";
        System.out.println(palindrome(s, 0,  s.length()-1));
    }

    private static boolean palindrome(String s, int left, int right){
        if(left >= right) return true;

        if(s.charAt(left) == s.charAt(right))
            return palindrome(s, left+1, right-1);

        return false;
    }
}
