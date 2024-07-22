package Revision1;

public class OccurenceOfAString {
    public static void main(String[] args) {
        String s = "shManishKumarsh";
        String t = "shd";
        System.out.println(occurenceCount(s, t, 0));
    }

    private static int occurenceCount(String s, String t, int i){
        if(i+t.length() > s.length()) return 0;

        if(s.substring(i, i+t.length()).equals(t)) return 1 + occurenceCount(s, t, i+1);

        return occurenceCount(s, t, i+1);
    }
}
