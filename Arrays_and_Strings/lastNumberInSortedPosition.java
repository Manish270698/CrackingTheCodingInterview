package Arrays_and_Strings;

public class lastNumberInSortedPosition {
    public static void main(String[] args) {
        int[] a = { 2, 4, 6, 8, 9, 1 };

        solution(a);

        for (int b : a) {
            System.out.print(b + " ");
        }
    }

    public static void solution(int[] a){
        int last = a[a.length-1];
        int index = a.length-2;
    
        while(index >=0 && a[index]>last){
            a[index+1] = a[index];
            index--;
        }

        a[index+1] = last;
    }

}
