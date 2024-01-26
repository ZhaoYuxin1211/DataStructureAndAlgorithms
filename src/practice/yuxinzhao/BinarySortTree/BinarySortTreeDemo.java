package practice.yuxinzhao.BinarySortTree;

import com.sun.xml.internal.ws.policy.sourcemodel.ModelNode;

/**
 * A demo class demonstrating the usage of Binary Search Tree (BST) to build and traverse a tree.
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};

        // Create a Binary Search Tree and add nodes to it
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.addNode(new Node(arr[i]));
        }

        // Traverse the Binary Search Tree in-order and print the nodes
        binarySortTree.inOrderTra();

        // Delete certain node;
        System.out.println();
        binarySortTree.delNode(7);

        binarySortTree.inOrderTra();
    }
}

/**
 * Represents a Binary Search Tree (BST).
 */
class BinarySortTree {
    private Node root;

    /**
     * Searches for a node with the specified value in the Binary Search Tree.
     *
     * @param value The value to be searched for.
     * @return The node with the specified value, or null if not found.
     */
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    /**
     * Searches for the parent node of a node with the specified value in the Binary Search Tree.
     *
     * @param value The value of the node whose parent is to be found.
     * @return The parent node of the node with the specified value, or null if not found.
     */
    public Node searchParentNode(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParentNode(value);
        }
    }

    /**
     * Deletes the node with the minimum value in the right subtree of the given node.
     *
     * @param node The node whose right subtree is considered for finding the minimum value.
     * @return The minimum value found and deleted.
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        while (target.left != null) {
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }

    /**
     * Deletes the node with the specified value from the Binary Search Tree.
     *
     * @param value The value of the node to be deleted.
     */
    public void delNode(int value) {
        if (root == null) {
            return; // If the tree is empty, nothing to delete.
        } else {
            // Step 1: Search for the node to be deleted and its parent node
            Node targetNode = search(value);
            if (targetNode == null) {
                return; // Node not found, nothing to delete.
            }

            // Step 2: Handle various deletion cases
            if (root.left == null && root.right == null) {
                // Case 1: If the tree has only one node, delete the root
                root = null;
                return;
            }
            Node parentNode = searchParentNode(value);
            // Case 2: Node to be deleted is a leaf node
            if (targetNode.left == null && targetNode.right == null) {
                root = null;
                if (parentNode.left != null && parentNode.left.value == value) {
                    parentNode.left = null;
                } else if (parentNode.right != null && parentNode.right.value == value) {
                    parentNode.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {
                // Case 3: Node to be deleted has both left and right children
                // Find the minimum value in the right subtree, replace target node's value, and delete the replacement node
                int minValueInRightChild = delRightTreeMin(targetNode.right);
                targetNode.value = minValueInRightChild;
            } else {
                // Case 4: Node to be deleted has only one child
                if (targetNode.left != null) {
                    // If the left child exists, link parent to the left child
                    if (parentNode.left.value == value) {
                        parentNode.left = targetNode.left;
                    } else {
                        parentNode.right = targetNode.left;
                    }
                } else {
                    // If the right child exists, link parent to the right child
                    if (parentNode.left.value == value) {
                        parentNode.left = targetNode.right;
                    } else {
                        parentNode.right = targetNode.right;
                    }
                }
            }

        }
    }

    /**
     * Adds a node to the Binary Search Tree.
     *
     * @param node The node to be added to the tree.
     */
    public void addNode(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.addNode(node);
        }
    }

    /**
     * Performs in-order traversal starting from the root of the Binary Search Tree.
     * Prints the nodes in sorted order.
     */
    public void inOrderTra() {
        if (root != null) {
            root.inOrderTra();
        } else {
            System.out.println("This tree is null.");
        }
    }
}

/**
 * Represents a node in the Binary Search Tree (BST).
 */
class Node {
    int value;
    Node left;
    Node right;

    /**
     * Constructs a node with the specified value.
     *
     * @param value The value associated with the node.
     */
    public Node(int value) {
        this.value = value;
    }

    /**
     * Searches for a node with the specified value in the current node's subtree.
     *
     * @param value The value to be searched for.
     * @return The node with the specified value, or null if not found.
     */
    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    /**
     * Searches for the parent node of the node with the specified value in the current node's subtree.
     *
     * @param value The value of the node whose parent is to be found.
     * @return The parent node of the node with the specified value, or null if not found.
     */
    public Node searchParentNode(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (value < this.value && this.left != null) {
                return this.left.searchParentNode(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParentNode(value);
            } else {
                return null;
            }
        }
    }

    /**
     * Adds a node to the current node's subtree based on the BST property.
     *
     * @param node The node to be added to the subtree.
     */
    public void addNode(Node node) {
        if (node == null) {
            return;
        }

        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.addNode(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.addNode(node);
            }
        }
    }

    /**
     * Performs in-order traversal starting from this node.
     * Prints the nodes in sorted order.
     */
    public void inOrderTra() {
        if (this.left != null) {
            this.left.inOrderTra();
        }

        System.out.println(this);

        if (this.right != null) {
            this.right.inOrderTra();
        }
    }

    /**
     * Returns a string representation of the node.
     *
     * @return A string containing the value of the node.
     */
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
