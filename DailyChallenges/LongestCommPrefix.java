package DailyChallenges;

public class LongestCommPrefix {

    public static void main(String[] args) {
        String[] strs = {"prime","protect","promo"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {

        int minL = 201;
        for(int i=0; i< strs.length; i++){
            if(strs[i].length() < minL){
                minL = strs[i].length();
            }
        }

        StringBuilder s = new StringBuilder();
        for(int i=0; i<minL; i++){
            int j = 0 ;
            boolean isPresent = true;
            char c = strs[0].charAt(i);
            for(j=1; j<strs.length; j++){
                if(strs[j].charAt(i) != c){
                    isPresent = false;
                }
            }
            if(isPresent){
                s.append(c);
            }
            else{
                break;
            }
        }

        return s.toString();
    }
}
