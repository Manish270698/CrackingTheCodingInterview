package Backtracking;

import java.util.ArrayList;

// T.C: O(n*n!), S.C: O(n*n!)
public class PermutationsOfAnArrayOrString {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3 };
        ArrayList<int[]> al = new ArrayList<>();
        // permute(a, al, 0, a.length - 1);
        permute(a, al, 0);
        for (int[] arr : al) {
            printArray(arr);
            ;
        }
    }

    private static void permute(int[] a, ArrayList<int[]> al, int index) {
        if (index == a.length - 1) {
            int[] b = new int[a.length];
            copyArray(a, b);
            al.add(b);
            return;

        }
        for (int i = index; i <= a.length - 1; i++) {
            swap(a, i, index);
            permute(a, al, index + 1);
            swap(a, i, index); // Backtracking
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void printArray(int[] a) {
        for (int e : a) {
            System.out.print(e);
        }
        System.out.println();
    }

    private static void copyArray(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
    }

}
