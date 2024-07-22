package Revision1;

public class JosephusProblem {
    public static void main(String[] args) {
        int n = 100, k = 4;
        System.out.println(josephus(n, k));
    }

    private static int josephus(int n, int k){
        if(n==1) return 0;
        return (josephus(n-1, k) + k) % n;
    }
}
