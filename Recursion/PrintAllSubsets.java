package Recursion;

public class PrintAllSubsets {
    public static void main(String[] args) {
        String s = "abc";
        allSubsets(s);
//        allSubsets2(s, new StringBuilder(), 0);
    }


    static void allSubsets(String s) {
        allSubsets(s, 0, "");
    }

    //Fails if duplicates exist. Requires sorting at end if we want sorted output
    static void allSubsets(String s, int i, String curr) {
        if (i == s.length()) {
            System.out.println(curr);
            return;
        }
        allSubsets(s, i + 1, curr);
        allSubsets(s, i + 1, curr + s.charAt(i));
    }

    // Works for duplicates as well, but requires input in sorted order
    private static void allSubsets2(String s, StringBuilder curr, int index){
        if(!(curr.toString().equals(""))){
            System.out.println(curr);
        }

        for(int i=index; i<s.length(); i++){
            if(i>index && s.charAt(i)==s.charAt(i-1)){
                continue;
            }
            curr.append(s.charAt(i));
            allSubsets2(s, curr, i+1);
            curr.deleteCharAt(curr.length()-1);
        }
    }

}
