package practice.yuxinzhao.sort;

import java.util.Arrays;


public class QuickSort {
    public static void main(String[] args) {
        // Create an integer array
        int[] arr = {98, 0, 5, -9, 132, 3, -7, 0};

        // Call the quickSort function to sort the array
        quickSort(arr, 0, arr.length - 1);

        // Print the sorted array
        System.out.println(Arrays.toString(arr));
    }

    // Quick Sort function
    public static void quickSort(int[] arr, int left, int right) {
        // Define pointers and choose a pivot element
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];

        int temp;

        // Partitioning loop
        while (l <= r) {
            // Find elements on the left that are greater than the pivot
            while (arr[l] < pivot) {
                l++;
            }
            // Find elements on the right that are smaller than the pivot
            while (arr[r] > pivot) {
                r--;
            }

            if (l <= r) {
                // Swap the elements at l and r
                temp = arr[r];
                arr[r] = arr[l];
                arr[l] = temp;

                // Move the pointers
                l++;
                r--;
            }
        }

        // Recursively sort the left and right sub arrays
        if (left < r) {
            quickSort(arr, left, r);
        }

        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}
