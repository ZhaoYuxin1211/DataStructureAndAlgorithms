package practice.yuxinzhao.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        // Create an array of integers
        int[] arr = {101, 1, 98, 35};

        // Call the insertionSort function to sort the array
        insertionSort(arr);

        // Print the sorted array
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        // Iterate through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];       // Store the current element to be inserted
            int insertIndex = i - 1;      // Initialize the index to the left of the current element

            // Move elements greater than the current element to the right
            // until the correct position for the current element is found
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            // Place the current element in its correct position
            if (insertIndex != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }

}
