package Arrays_and_Strings;

public class BasicSorts {
    public static void main(String[] args) {
        int[] arr = { 1, 20, 3, 4, 5, 0 };
        // bubbleSort(arr); // O(n^2)
        // selectionSort(arr); // O(n^2)
        insertionSort(arr); // O(n^2)
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean didISwap = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    didISwap = true;
                }
            }
            if (!didISwap) {
                break;
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }

        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int swapIndex = i;
            int j = i - 1;
            while (j >= 0 && arr[swapIndex] < arr[j]) {
                int temp = arr[swapIndex];
                arr[swapIndex] = arr[j];
                arr[j] = temp;
                swapIndex = j;
                j--;
            }
        }
    }

}
