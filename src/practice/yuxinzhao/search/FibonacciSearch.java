package practice.yuxinzhao.search;

import java.util.Arrays;

public class FibonacciSearch {
    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 66, 189, 200};
        System.out.println(fibSearch(arr, 0));
    }

    /**
     * Generate an array of Fibonacci numbers.
     *
     * @return An array containing Fibonacci numbers.
     */
    public static int[] fib() {
        int[] fib = new int[maxSize];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

    /**
     * Search for a target element in a sorted array using Fibonacci search.
     *
     * @param arr    The sorted array to search within.
     * @param target The element to search for.
     * @return The index of the target element if found, or -1 if not found.
     */
    public static int fibSearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0; // index of Fibonacci array
        int mid;
        int[] fib = fib();

        // Determine the value of k for the Fibonacci series
        while (high > fib[k] - 1) {
            k++;
        }

        // Extend the array to match the Fibonacci series length
        int[] temp = Arrays.copyOf(arr, fib[k]);
        for (int i = high; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        // Perform the Fibonacci search
        while (low <= high) {
            mid = low + fib[k - 1] - 1;
            if (target < temp[mid]) {
                // If target is smaller, search the left subarray
                high = mid - 1;
                k--;
            } else if (target > temp[mid]) {
                // If target is larger, search the right subarray
                low = mid + 1;
                k -= 2; // Move two steps back in the Fibonacci series
            } else {
                // Target found, return the index
                if (mid <= high) {
                    return mid;
                } else {
                    // The target index is outside the extended array
                    return high;
                }
            }
        }

        // Target not found in the array
        return -1;
    }

}
