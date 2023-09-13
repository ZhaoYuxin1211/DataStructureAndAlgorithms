package practice.yuxinzhao.sort;

import java.util.Arrays;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        // Create an integer array to be sorted
        int[] arr = {8, 4, 5, 3, 2, 6, 7, 1};

        // Create a temporary array to assist in the sorting process
        int[] temp = new int[arr.length];

        // Call the mergeSort function to sort the array
        mergeSort(arr, 0, arr.length - 1, temp);

        // Print the sorted array
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Recursive merge sort function.
     *
     * @param arr   The array to be sorted
     * @param left  The left index of the current subarray
     * @param right The right index of the current subarray
     * @param temp  A temporary array for merging
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // Recursively sort the left and right halves
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            // Merge the sorted halves
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * Merge two subarrays into a sorted array.
     *
     * @param arr   The array to be sorted
     * @param left  Pointer to the left of the subarray
     * @param mid   Pointer to the middle of the subarray
     * @param right Pointer to the right of the subarray
     * @param temp  Temporary array for merging
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right) {
            // Compare elements from both halves and merge them in sorted order
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        // Copy any remaining elements from the left half
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }

        // Copy any remaining elements from the right half
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }

        t = 0;
        int tempLeft = left;

        // Copy the sorted values from the temporary array back into the original array
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
