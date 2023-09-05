package practice.yuxinzhao.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        // Create an array of integers
        int[] arr = {98, 1, 5, 32, 58, 2, 15, 65};
        int[] arr1 = {98, 1, 5, 32, 58, 2, 15, 65};

        // Call the function to sort the array
        shellSortExchange(arr);
        shellSortShift(arr1);

        // Print the sorted array
        System.out.println("Exchange method: " + Arrays.toString(arr));
        System.out.println("Shift method: " + Arrays.toString(arr));
    }

    // Shell Sort using the Exchange (Swapping) Method
    public static void shellSortExchange(int[] arr) {
        int temp;

        // Start with a gap, and gradually reduce it
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // Iterate through the array
            for (int i = gap; i < arr.length; i++) {
                // Compare and swap elements with a gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    // Shell Sort using the Shifting (Insertion) Method
    public static void shellSortShift(int[] arr) {
        // Loop through different gap sizes, starting with half the array length
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // Iterate through the array elements
            for (int i = gap; i < arr.length; i++) {
                int j = i;                  // Store the current element's index
                int temp = arr[j];          // Store the current element's value

                // Compare the current element with elements at a specific gap
                if (arr[j] < arr[j - gap]) {
                    // Shift elements to the right within the gap until the correct position is found
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;  // Place the current element in its correct position
                }
            }
        }
    }

}

