package Recursion;

import java.util.Scanner;

public class OccurenceOfAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String t = sc.nextLine();
        sc.close();

        System.out.println(timesPresent(s, t , 0));
        
    }

    public static int timesPresent(String s, String t, int i){
        // if(i+t.length()>s.length()) return 0
        if(i>s.length()-t.length()) return 0;

        if(s.substring(i, i+t.length()).equals(t)){
            return 1+ timesPresent(s, t, i+1);
        }
        else{
            return timesPresent(s, t, i+1);
        }
    }
}
