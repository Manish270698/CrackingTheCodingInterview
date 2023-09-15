package Arrays_and_Strings;

public class Rotate_Matrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4, 5 },
                { 5, 6, 7, 8, 9 },
                { 9, 10, 11, 12, 13 },
                { 13, 14, 15, 16, 17 },
                { 18, 19, 20, 21, 22 }
        };

        int[][] ans1 = rotate1(matrix);
        System.out.println("TC: O(n^2) SC: O(n^2) : Using extra matrix space: ");

        for (int[] i : ans1) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        int[][] ans2 = rotate2(matrix);
        System.out.println("TC: O(n^2) SC: O(1) : Transpose and In place: ");

        for (int[] i : ans2) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }

    // TC: O(n^2) SC: O(n^2) ==> Extra matrix space
    public static int[][] rotate1(int[][] m) {
        int[][] matrix = new int[m.length][m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                matrix[j][m.length - 1 - i] = m[i][j];
            }
        }
        return matrix;
    }

    // TC: O(n^2) SC: O(1) ==> In place
    public static int[][] rotate2(int[][] m) {
        // transpose
        for (int i = 0; i <= m.length - 2; i++) {
            for (int j = i + 1; j <= m.length - 1; j++) {
                int temp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = temp;
            }
        }
        // reverse each row
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length / 2; j++) {
                int temp = m[i][j];
                m[i][j] = m[i][m.length - 1 - j];
                m[i][m.length - 1 - j] = temp;
            }
        }

        return m;
    }

}
