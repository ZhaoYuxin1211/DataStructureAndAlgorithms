package practice.yuxinzhao.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        // Create an array of integers
        int[] arr = {101, 34, 99, 1};

        // Call the selectionSort function to sort the array
        selectionSort(arr);
    }

    public static void selectionSort(int[] arr) {
        // Iterate through the array elements
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int minNum = arr[i];

            // Find the minimum element in the unsorted part of the array
            for (int j = i + 1; j < arr.length; j++) {
                if (minNum > arr[j]) {
                    minNum = arr[j];
                    minIndex = j;
                }
            }

            // Swap the minimum element with the current element (if needed)
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = minNum;
            }
        }

        // Print the sorted array
        System.out.println(Arrays.toString(arr));
    }

}
