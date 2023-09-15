package DailyChallenges;

import java.util.*;

public class PermutationsOfAString {
    public static void main(String[] args) {
        permute("ABB");
    }

    private static void permute(String str){
        Set<String> set = new HashSet<>();
        char[] c = str.toCharArray();
        permute(set, c, 0);
        List<String> l = new ArrayList<>(set);
        Collections.sort(l);
        for(String s : l){
            System.out.println(s);
        }
    }

    private static void permute(Set<String> set, char[] c, int index){
        if(index == c.length - 1){
            String str = new String(c);
            set.add(str);
            return;
        }

        for(int i=index; i<c.length; i++){
            swap(c, i, index);
            permute(set, c, index+1);
            swap(c, i, index);
        }
    }

    private static void swap(char[] c, int i, int index){
        char temp = c[i];
        c[i] = c[index];
        c[index] = temp;
    }
}
