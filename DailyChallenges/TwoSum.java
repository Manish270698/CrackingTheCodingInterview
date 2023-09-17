package DailyChallenges;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {-1, -7, -9, -3, -5};
        int target = -4;

        int[] ans = new int[2];
        get2Sum(arr, target, ans);

        for(int i: ans){
            System.out.print(i +" ");
        }
    }

    private static void get2Sum(int[] arr, int target, int[] ans){
        Map<Integer, Integer> m = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            if(m.containsKey(target - arr[i])){
                ans[0] = m.get(target - arr[i]);
                ans[1] = i;
                break;
            }
            else{
                m.put(arr[i], i);
            }
        }
        return;
    }
}
