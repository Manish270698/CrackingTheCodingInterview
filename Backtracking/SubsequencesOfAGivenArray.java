package Backtracking;

import java.util.*;

public class SubsequencesOfAGivenArray {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(1);

        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        subsequenceFinder(ans, arr, new ArrayList<>(), 0);

        for(ArrayList<Integer> a : ans){
            System.out.println(a);
        }
    }

    private static void subsequenceFinder(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> arr, ArrayList<Integer> cur, int index){
        ArrayList<Integer> al = new ArrayList<>(cur);
        ans.add(al);


        for(int i=index; i<arr.size(); i++){
            // Logic to not run more than once for duplicate elements
            if(i>index && arr.get(i)==arr.get(i - 1)){
                continue;
            }
            cur.add(arr.get(i));
            subsequenceFinder(ans, arr, cur, i+1);
            cur.remove(cur.size()-1); // Backtracking
        }
    }
}
