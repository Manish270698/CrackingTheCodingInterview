package DailyChallenges;

import java.util.Arrays;

public class MultipleLeftRotationOfTheArray {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        int[] B = {2, 4};

        int[][] m = new int[B.length][A.length];
        int pos = 0;
        for(int i=0; i<B.length; i++){
            rotateNTimes(A, B[i]%A.length, m, pos);
            pos++;
        }

        for(int[] a : m){
            for(int i: a){
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    private static void rotateNTimes(int[] a, int n, int[][] m, int pos){
        int[] copy = Arrays.copyOf(a, a.length);
        int[] tempArray = Arrays.copyOf(a, n);

        int j=0;
        for(int i=n; i< copy.length; i++){
            copy[j] = copy[i];
            j++;
        }

        int index = 0;
        for(int i=a.length-n; i<copy.length; i++){
            copy[i] = tempArray[index];
            index++;
        }
        m[pos] = copy;
    }
}
