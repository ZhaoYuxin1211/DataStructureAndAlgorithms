package practice.yuxinzhao.search;

public class BinarySearch {
    public static void main(String[] args) {
        // Create a sorted integer array to search within
        int[] arr = {0, 1, 2, 3, 5, 8, 9};

        // Call the binarySearch function to search for the target element (4) in the array
        System.out.println(binarySearch(arr, 0, arr.length - 1, 4));
    }

    /**
     * Recursive binary search algorithm to find the target element in a sorted array.
     *
     * @param arr    The sorted array to search within
     * @param left   The left pointer (start index of the search range)
     * @param right  The right pointer (end index of the search range)
     * @param target The element to search for
     * @return The index of the target element if found, or -1 if not found
     */
    public static int binarySearch(int[] arr, int left, int right, int target) {
        // Calculate the middle index and value
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        // Check if the left pointer has crossed the right pointer (base case for termination)
        if (left > right) {
            return -1; // Target element not found
        }

        // Compare the target with the middle value
        if (target > midVal) {
            // If the target is greater, search the right half of the array
            return binarySearch(arr, mid + 1, right, target);
        } else if (target < midVal) {
            // If the target is smaller, search the left half of the array
            return binarySearch(arr, left, mid - 1, target);
        } else {
            // If the target is equal to the middle value, return its index
            return mid;
        }
    }
}

