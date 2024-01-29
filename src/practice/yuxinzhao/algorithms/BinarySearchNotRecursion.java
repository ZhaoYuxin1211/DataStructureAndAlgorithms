package practice.yuxinzhao.algorithms;

public class BinarySearchNotRecursion {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 10, 11, 67, 100};
        int index = binarySearch(arr, 1);
        System.out.println(index);
    }

    /**
     * Performs a binary search on a sorted array to find the index of the target element.
     *
     * @param arr    The sorted array to be searched.
     * @param target The target element to be found in the array.
     * @return The index of the target element if found; otherwise, returns -1.
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        // Loop until the search range is valid
        while (left <= right) {
            // Calculate the middle index of the current search range
            int mid = (left + right) / 2;

            // Check if the middle element is the target
            if (arr[mid] == target) {
                return mid; // Target found, return the index
            } else if (arr[mid] > target) {
                right = mid - 1; // Adjust the search range to the left half
            } else {
                left = mid + 1; // Adjust the search range to the right half
            }
        }

        return -1; // Target not found in the array
    }
}
