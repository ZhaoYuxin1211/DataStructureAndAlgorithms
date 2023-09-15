package practice.yuxinzhao.search;

public class InterpolationSearch {
    public static void main(String[] args) {
        // Create a sorted integer array to search within
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        // Call the interpolationSearch function to search for the target element (2) in the array
        System.out.println(interpolationSearch(arr, 0, arr.length - 1, 2));
    }

    /**
     * Interpolation Search algorithm to find the target element in a sorted array.
     *
     * @param arr    The sorted array to search within
     * @param left   The left pointer (start index of the search range)
     * @param right  The right pointer (end index of the search range)
     * @param target The element to search for
     * @return The index of the target element if found, or -1 if not found
     */
    public static int interpolationSearch(int[] arr, int left, int right, int target) {
        // Check for invalid search conditions (base cases)
        if (left > right || target < arr[0] || target > arr[arr.length - 1]) {
            return -1; // Target element not found
        }

        // Calculate the midpoint index using the interpolation formula
        int mid = left + ((target - arr[left]) * (right - left)) / (arr[right] - arr[left]);

        int midVal = arr[mid];

        if (midVal > target) {
            // If the middle value is greater, search the left half of the array
            return interpolationSearch(arr, left, mid - 1, target);
        } else if (midVal < target) {
            // If the middle value is smaller, search the right half of the array
            return interpolationSearch(arr, mid + 1, right, target);
        } else {
            // If the target is equal to the middle value, return its index
            return mid;
        }
    }
}
