package Backtracking;

import java.util.ArrayList;
import java.util.List;

//T.C: O(N^N) , S.C(N+N^2)
public class NQueensProblem {
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> ans = new ArrayList<>();
        char[][] paths = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                paths[i][j] = '.';
            }
        }
        queensPath(ans, paths, n, 0);

        for(List<String> s: ans){
            System.out.println(s);
        }

    }

    private static void queensPath(List<List<String>> ans, char[][] paths, int n, int row){
        if(row==n){
            copyArr(ans, paths);
            return;
        }

        for(int i=0; i<n; i++){
            if(isSafe(paths, n, row, i)){
                paths[row][i] = 'Q';
                queensPath(ans, paths, n, row+1);
                paths[row][i] = '.'; //Backtracking
            }
        }
    }

    private static void copyArr(List<List<String>> ans, char[][] paths){
        List<String> l = new ArrayList<>();
        for(char[] arr: paths){
            l.add(new String(arr));
        }
        ans.add(l);
    }


    private static boolean isSafe(char[][] paths, int n, int row, int col){
        int a = 1;
        for(int i=row-1; i>=0; i--){
            if(paths[i][col] == 'Q'){
                return false;
            }
            if((col+a) < n && paths[i][col+a] == 'Q'){
                return false;
            }
            if((col-a) >=0 && paths[i][col-a] == 'Q'){
                return  false;
            }
            a++;
        }

        return true;
    }
}
