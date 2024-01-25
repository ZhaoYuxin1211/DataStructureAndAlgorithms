package practice.yuxinzhao.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};

        // Step 1: Create Huffman Tree
        HuffmanNode huffmanTree = createHuffmanTree(arr);

        // Step 2: Traverse the Huffman Tree using Pre-order traversal
        huffmanTree.preOrderTra();
    }

    /**
     * This method creates a Huffman Tree based on the given array of frequencies.
     *
     * @param arr An array representing the frequencies of characters.
     * @return The root node of the constructed Huffman Tree.
     */
    public static HuffmanNode createHuffmanTree(int[] arr) {
        // Step 1: Create a list of HuffmanNodes for each frequency value
        List<HuffmanNode> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new HuffmanNode(value));
        }

        // Continue constructing the Huffman Tree until only one node remains
        while (nodes.size() > 1) {
            // Step 2: Sort the list of HuffmanNodes based on their frequencies
            Collections.sort(nodes);

            // Step 3: Take the two nodes with the lowest frequencies
            HuffmanNode left = nodes.get(0);
            HuffmanNode right = nodes.get(1);

            // Step 4: Create a new parent node with a frequency equal to the sum of the two nodes
            HuffmanNode parent = new HuffmanNode(left.value + right.value);

            // Step 5: Set the left and right children of the parent node
            parent.leftChild = left;
            parent.rightChild = right;

            // Step 6: Remove the processed nodes and add the new parent node to the list
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }

        // The remaining node is the root of the Huffman Tree
        return nodes.get(0);
    }
}

/**
 * Represents a node in the Huffman Tree.
 */
class HuffmanNode implements Comparable<HuffmanNode> {
    int value;
    HuffmanNode leftChild;
    HuffmanNode rightChild;

    /**
     * Performs pre-order traversal starting from this node.
     */
    public void preOrderTra() {
        System.out.println(this);
        if (this.leftChild != null) {
            this.leftChild.preOrderTra();
        }
        if (this.rightChild != null) {
            this.rightChild.preOrderTra();
        }
    }

    /**
     * Constructs a HuffmanNode with the specified frequency value.
     *
     * @param value The frequency value associated with the node.
     */
    public HuffmanNode(int value) {
        this.value = value;
    }

    /**
     * Returns a string representation of the HuffmanNode.
     *
     * @return A string containing the value of the HuffmanNode.
     */
    @Override
    public String toString() {
        return "HuffmanNode{" +
                "value=" + value +
                '}';
    }

    /**
     * Compares two HuffmanNodes based on their frequency values.
     *
     * @param o The HuffmanNode to be compared.
     * @return The difference in frequency values between this node and the specified node.
     */
    @Override
    public int compareTo(HuffmanNode o) {
        return this.value - o.value;
    }
}
