package Backtracking;

import java.util.ArrayList;

public class RatInAMaze {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 1 },
                { 0, 1, 1, 1 }
        };

        ArrayList<String> al = new ArrayList<>();
        int m = arr.length;
        int n = arr[0].length;
        if (arr[0][0] != 0) {
            boolean[][] flag = new boolean[m][n];

            findPaths(arr, m, n, new String(), al, flag, 0, 0);
        }
        for (String s : al) {
            System.out.print(s + " ");
        }
    }

    static void findPaths(int[][] arr, int m, int n, String s, ArrayList<String> al, boolean[][] flag, int i,
            int j) {

        if (i == m - 1 && j == n - 1) {
            al.add(s.toString());
            return;
        }
        flag[i][j] = true;
        // Down
        if (isValid(arr, m, n, flag, i + 1, j)) {
            s += 'D';
            findPaths(arr, m, n, s, al, flag, i + 1, j);
            s = s.substring(0, s.length() - 1);
        }

        // Left
        if (isValid(arr, m, n, flag, i, j - 1)) {
            s += 'L';
            findPaths(arr, m, n, s, al, flag, i, j - 1);
            s = s.substring(0, s.length() - 1);
        }

        // Up
        if (isValid(arr, m, n, flag, i - 1, j)) {
            s += 'U';
            findPaths(arr, m, n, s, al, flag, i - 1, j);
            s = s.substring(0, s.length() - 1);
        }

        // Right
        if (isValid(arr, m, n, flag, i, j + 1)) {
            s += 'R';
            findPaths(arr, m, n, s, al, flag, i, j + 1);
            s = s.substring(0, s.length() - 1);
        }

        flag[i][j] = false;
    }

    static boolean isValid(int[][] arr, int m, int n, boolean[][] flag, int i, int j) {
        if (i >= 0 && i < m && j >= 0 && j < n && arr[i][j] == 1 && flag[i][j] == false) {
            return true;
        }
        return false;
    }
}
