package practice.yuxinzhao.tree;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {4, 6, 8, 5, 9};
        heapSort(arr);
    }

    /**
     * This method initiates the heap sort algorithm.
     *
     * @param arr The array to be sorted using heap sort.
     */
    public static void heapSort(int[] arr) {
        int temp;
        System.out.println("Heap Sort:");

        // Step 1: Build the max heap
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        // Step 2: Swap the root (maximum element) with the last element and adjust the heap
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;

            // Re-adjust the heap for the remaining unsorted part of the array
            adjustHeap(arr, 0, j);
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * This method performs the heap adjustment on a given subtree.
     *
     * @param arr    The array representing the heap.
     * @param i      The root index of the subtree to be adjusted.
     * @param length The size of the subtree to be adjusted.
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];

        // Traverse down the subtree and find the largest child to swap with the current node
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }

            // If the largest child is greater than the current node, swap them
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }

            // Set the current node to the temporary value
            arr[i] = temp;
        }
    }
}
