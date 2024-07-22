package Backtracking;

import java.util.*;

public class CombinationSumProblem {
    public static void main(String[] args) {
        List<List<Integer>> al = new ArrayList<>();
        int sum = 12;
        int[] candidates = {8, 1, 3, 7, 2, 1, 5};

        Arrays.sort(candidates);
        CombinationSumProblem.combinationSum(al, candidates, new ArrayList<>(), 0, sum);
        for(List<Integer> a : al){
            System.out.println(a);
        }

    }

    // T.C: O(2^n), O(n)
    private static void combinationSum(List<List<Integer>> al, int[] candidates, List<Integer> curr, int index, int sum){
        if(sum==0){
            List<Integer> l = new ArrayList<>(curr);
            al.add(l);
        }

        for(int i=index; i<candidates.length; i++){
            // Handles duplicates
            if(i>index && Objects.equals(candidates[i], candidates[i-1])){
                continue;
            }

            if(candidates[i]>sum) return; // TO stop continuing in paths which won't give output

            curr.add(candidates[i]);
            combinationSum(al, candidates, curr, i+1, sum- candidates[i]);
            curr.remove(curr.size()-1); //Backtracking
        }
    }
}
