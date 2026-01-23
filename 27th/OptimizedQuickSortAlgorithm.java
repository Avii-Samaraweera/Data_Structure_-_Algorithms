public class OptimizedQuickSort {

    private static final int INSERTION_SORT_THRESHOLD = 10;


    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
   
    private static void quickSort(int[] arr, int low, int high) {
        while (low < high) {

    
            if (high - low < INSERTION_SORT_THRESHOLD) {
                insertionSort(arr, low, high);
                break;
            }

      
            int pivotIndex = partition(arr, low, high);

          
            if (pivotIndex - low < high - pivotIndex) {
                quickSort(arr, low, pivotIndex - 1);
                low = pivotIndex + 1;
            } else {
                quickSort(arr, pivotIndex + 1, high);
                high = pivotIndex - 1;
            }
        }
    }

   
    private static int partition(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;

        if (arr[low] > arr[mid]) swap(arr, low, mid);
        if (arr[low] > arr[high]) swap(arr, low, high);
        if (arr[mid] > arr[high]) swap(arr, mid, high);

        
        swap(arr, mid, high - 1);
        int pivot = arr[high - 1];

        int i = low;
        int j = high - 1;

        while (true) {
            while (arr[++i] < pivot) {}
            while (arr[--j] > pivot) {}
            if (i >= j) break;
            swap(arr, i, j);
        }

        swap(arr, i, high - 1);
        return i;
    }

    
    private static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {34, 7, 23, 32, 5, 62, 32, 2};
        quickSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
