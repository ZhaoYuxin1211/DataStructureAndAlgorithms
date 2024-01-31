package practice.yuxinzhao.algorithms.KMP;

/**
 * Implementation of the Knuth-Morris-Pratt (KMP) string matching algorithm.
 */
public class KMPAlgorithm {
    public static void main(String[] args) {
        String str1 = "BBC ABCDEFF ABC ABCDEFGH";
        String str2 = "ABCDEFG";

        // Calculate the next array using the KMP algorithm
        int[] next = kmpNext(str2);

        // Search for the pattern in the text using KMP algorithm
        int index = kmpSearch(str1, str2, next);

        // Print the index where the pattern is found in the text
        System.out.println(index);
    }

    /**
     * Searches for a pattern in a text using the Knuth-Morris-Pratt (KMP) algorithm.
     *
     * @param str1 The text to be searched.
     * @param str2 The pattern to be found in the text.
     * @param next The precomputed "next" array for the pattern.
     * @return The index in the text where the pattern is found, or -1 if not found.
     */
    public static int kmpSearch(String str1, String str2, int[] next) {
        for (int i = 0, j = 0; i < str1.length(); i++) {
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1]; // Backtrack in the pattern until a matching prefix is found
            }

            if (str1.charAt(i) == str2.charAt(j)) {
                j++; // Move to the next character in the pattern
            }

            if (j == str2.length()) {
                return i - j + 1; // Pattern found, return the starting index in the text
            }
        }
        return -1; // Pattern not found in the text
    }

    /**
     * Computes the "next" array for the KMP algorithm.
     *
     * @param dest The pattern for which the "next" array is computed.
     * @return The computed "next" array.
     */
    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0; // Base case: the first character has no proper prefix

        for (int i = 1, j = 0; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1]; // Backtrack to find the longest proper prefix that is also a suffix
            }

            if (dest.charAt(i) == dest.charAt(j)) {
                j++; // Increment the length of the current proper prefix
            }

            next[i] = j; // Store the length of the proper prefix in the "next" array
        }
        return next;
    }
}

