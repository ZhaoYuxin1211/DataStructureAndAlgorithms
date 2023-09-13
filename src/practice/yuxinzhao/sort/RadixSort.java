package practice.yuxinzhao.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        // Create an integer array to be sorted
        int[] arr = {53, 8, 32, 58, 962, 14, 215};

        // Call the radixSort function to sort the array
        radixSort(arr);

        // Print the sorted array
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Radix Sort algorithm to sort an integer array.
     *
     * @param arr The array to be sorted
     */
    public static void radixSort(int[] arr) {
        // Find the maximum number in the array to determine the maximum number of digits
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();

        // Create buckets for each digit (0-9)
        int[][] bucket = new int[10][arr.length];

        // Keep track of the number of elements in each bucket
        int[] bucketElementCounts = new int[10];

        // Iterate through each digit place (from least significant to most significant)
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            // Distribute elements into buckets based on the current digit
            for (int value : arr) {
                int digitOfElement = value / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = value;
                bucketElementCounts[digitOfElement]++;
            }

            // Reconstruct the array by taking elements from buckets
            int index = 0;
            for (int j = 0; j < bucketElementCounts.length; j++) {
                if (bucketElementCounts[j] != 0) {
                    for (int k = 0; k < bucketElementCounts[j]; k++) {
                        arr[index] = bucket[j][k];
                        index++;
                    }
                }
                // Reset the bucket element count
                bucketElementCounts[j] = 0;
            }
        }
    }
}

