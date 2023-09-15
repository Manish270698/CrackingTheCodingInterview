package Backtracking;

public class KnightsTour {
    public static void main(String[] args) {
        int n = 4;
        int m= 5;

        int[][] arr = knightsTourGenerate(n, m);
        for(int[] a: arr){
            for(int i: a){
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    // T.C: O(8^(n^2)), S.C: O(n^2)
    private static int[][] knightsTourGenerate(int n, int m){
        int[] xpath = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] ypath = {1, 2, 2, 1, -1, -2, -2, -1};

        int[][] arr = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = -1;
            }
        }

        arr[0][0] = 0;

        if(knightsTourGenerate(arr, n, m, xpath, ypath, 0 ,0, 0)){
            return arr;
        }
        else{
            arr[0][0] = -1;
        }
        return arr;
    }

    private static boolean knightsTourGenerate(int[][] arr, int n, int m, int[] xpath, int[] ypath, int curX, int curY, int count){
        if(count == (n*m)-1){
            return true;
        }
        for(int i=0; i<8; i++){
            int newX = curX + xpath[i];
            int newY = curY + ypath[i];
            if(isValid(arr, n, m, newX, newY)){
                arr[newX][newY] = count + 1;
                if((knightsTourGenerate(arr, n, m, xpath, ypath, newX, newY, count + 1))){
                    return true;
                }
                else{
                    arr[newX][newY] = -1; //Backtracking
                }
            }
        }

        return false;
    }

    private static boolean isValid(int[][] arr,int n, int m, int x, int y){
        return x < n && x >= 0 && y < m && y >= 0 && arr[x][y] == -1;
    }
}
