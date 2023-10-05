package Backtracking;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] ans = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(ans, 0, 0);

        for(char[] a: ans){
            for(char c: a){
                System.out.print(c +" ");
            }
            System.out.println();
        }
    }

    // T.C: 0(9^(n^2)), S.C: O(2*n^2)
    private static boolean solveSudoku(char[][] ans, int row, int col){
        if(row == 9){
            return true;
        }
        if(col == 9){
            return solveSudoku(ans, row+1, 0);
        }
        if(ans[row][col] != '.'){
            return solveSudoku(ans, row, col+1);
        }

        for(char c = '1'; c <= '9'; c++){
            if(isSafe(ans, row, col, c)){
                ans[row][col] = c;
                if(solveSudoku(ans, row, col+1)){
                    return true;// will return when row reaches 9
                }
            }
            ans[row][col] = '.'; //backtracking
        }
        return false;
    }

    private static boolean isSafe(char[][]ans, int row, int col, char n){
        // Check row, column, and 3x3 subgrid for duplicate 'ch'
//        for (int i = 0; i < 9; i++) {
//            if (ans[i][col] == ch || ans[row][i] == ch || ans[row - row % 3 + i / 3][col - col % 3 + i % 3] == ch) {
//                return false;
//            }
//        }
//        return true;
        for(int i=0; i<9; i++){
            if(ans[i][col] == n){
                return false;
            }
        }
        for(int i=0; i<9; i++){
            if(ans[row][i] == n){
                return false;
            }
        }

        int r = row - row % 3;
        int c = col - col % 3;

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(ans[i+r][j+c] == n){
                    return false;
                }
            }
        }

        return true;
    }
}


