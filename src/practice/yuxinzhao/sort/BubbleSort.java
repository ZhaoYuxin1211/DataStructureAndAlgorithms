package practice.yuxinzhao.sort;


import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, 2};

        bubbleSort(arr);
    }

    public static void bubbleSort(int[] arr) {

        // Initialize a flag to track if any swaps were made
        boolean flag = false;

        // Temporary variable for swapping elements
        int temp = 0;

        // Loop through the array
        for (int i = 0; i < arr.length; i++) {
            // Iterate through the array up to the unsorted portion
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // Compare adjacent elements and swap if they are out of order
                if (arr[j] > arr[j + 1]) {
                    flag = true;    // Set the flag to indicate a swap
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            // If no swaps were made in this pass, the array is already sorted
            if (!flag) {
                break;
            } else {
                flag = false;  // Reset the flag for the next pass
            }
        }

        // Print the sorted array
        System.out.println(Arrays.toString(arr));

    }
}
