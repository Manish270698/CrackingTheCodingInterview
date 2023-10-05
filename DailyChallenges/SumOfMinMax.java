package DailyChallenges;

import java.util.ArrayList;
import java.util.List;

public class SumOfMinMax {
    public static void main(String[] args) {
        List<Long> nums = new ArrayList<>();
        nums.add(34L);
        nums.add(-9438L);
        nums.add(4511L);
        nums.add((long) 983);
        System.out.println(sumMinMax(nums));

    }

    private static long sumMinMax(List<Long> nums){
        long min = nums.get(0);
        long max = nums.get(0);

        for(long i : nums){
            if(i > max){
                max = i;
                continue;
            }
            if(i < min){
                min = i;
            }
        }
        return min + max;
    }
}
