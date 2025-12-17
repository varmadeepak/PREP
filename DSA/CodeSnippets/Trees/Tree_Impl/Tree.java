package Trees.Tree_Impl;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    // Insert node under a given parent
    void insertNode(TreeNode parent, int data, char direction) {
        TreeNode newNode = new TreeNode(data);
        if (parent == null) {
            System.out.println("Parent is null, cannot insert " + data);
            return;
        }
        if (direction == 'L') {
            parent.left = newNode;
        } else if (direction == 'R') {
            parent.right = newNode;
        }
    }

    // Inorder Traversal (Left, Root, Right)
    void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    // Preorder Traversal (Root, Left, Right)
    void preOrderTraversal(TreeNode root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // Postorder Traversal (Left, Right, Root)
    void postOrderTraversal(TreeNode root) {
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }
}

public class Tree {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        // Build tree manually
        bt.root = new TreeNode(1);                     // root
        bt.insertNode(bt.root, 2, 'L');                // 2 as left of 1
        bt.insertNode(bt.root, 3, 'R');                // 3 as right of 1
        bt.insertNode(bt.root.left, 4, 'L');           // 4 as left of 2
        bt.insertNode(bt.root.left, 5, 'R');           // 5 as right of 2
        bt.insertNode(bt.root.right, 6, 'R');          // 6 as right of 3

        System.out.println("In Order Traversal: ");
        bt.inOrderTraversal(bt.root);
        System.out.println();

        System.out.println("Pre Order Traversal: ");
        bt.preOrderTraversal(bt.root);
        System.out.println();

        System.out.println("Post Order Traversal: ");
        bt.postOrderTraversal(bt.root);
        System.out.println();
    }
}
