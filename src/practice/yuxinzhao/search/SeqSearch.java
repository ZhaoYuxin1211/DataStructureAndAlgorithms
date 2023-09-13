package practice.yuxinzhao.search;

public class SeqSearch {
    public static void main(String[] args) {
        // Create an integer array to search within
        int[] arr = {1, 9, 5, 77, 11, 3, 56};

        // Define the target element to search for
        int target = 11;

        // Call the seqSearch function to find the target element in the array
        int index = seqSearch(arr, target);

        // Print the index where the target element was found (or -1 if not found)
        System.out.println(index);
    }

    /**
     * Sequential search algorithm to find the target element in an array.
     *
     * @param arr    The array to search within
     * @param target The element to search for
     * @return The index of the target element if found, or -1 if not found
     */
    public static int seqSearch(int[] arr, int target) {
        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // Check if the current element is equal to the target
            if (arr[i] == target) {
                // Return the index where the target element was found
                return i;
            }
        }

        // If the target element is not found, return -1
        return -1;
    }
}
