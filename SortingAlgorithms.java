import java.util.Arrays;

public class SortingAlgorithms {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1] > arr[i]) {
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
            System.out.println("Array: " + Arrays.toString(arr));
        } while (swapped);
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
            System.out.println("Array: " + Arrays.toString(arr));
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int left = low + 1;
        int right = high;

        while (left <= right) {
            while (left <= right && arr[left] <= pivot) {
                left++;
            }
            while (left <= right && arr[right] > pivot) {
                right--;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        int temp = arr[low];
        arr[low] = arr[right];
        arr[right] = temp;

        return right;
    }

    public static void main(String[] args) {
        int[] inputArray = {49, 15, 40, 27, 20, 19, 50, 2, 12, 28, 49, 44, 9, 59, 18, 5, 30, 6, 7, 28};

        System.out.println("Bubble Sort:");
        int[] bubbleSortedArray = Arrays.copyOf(inputArray, inputArray.length);
        bubbleSort(bubbleSortedArray);

        System.out.println("\nInsertion Sort:");
        int[] insertionSortedArray = Arrays.copyOf(inputArray, inputArray.length);
        insertionSort(insertionSortedArray);

        System.out.println("\nQuick Sort:");
        int[] quickSortedArray = Arrays.copyOf(inputArray, inputArray.length);
        quickSort(quickSortedArray, 0, quickSortedArray.length - 1);

        System.out.println("\nFinal Sorted Array (Bubble Sort): " + Arrays.toString(bubbleSortedArray));
        System.out.println("Final Sorted Array (Insertion Sort): " + Arrays.toString(insertionSortedArray));
        System.out.println("Final Sorted Array (Quick Sort): " + Arrays.toString(quickSortedArray));
    }
}