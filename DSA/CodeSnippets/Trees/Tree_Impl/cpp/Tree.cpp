#include <iostream>
using namespace std;

class TreeNode {
public:                // make members public
    int data;
    TreeNode* left;
    TreeNode* right;

    TreeNode(int data) {
        this->data = data;
        this->left = NULL;
        this->right = NULL;
    }
};

class BinaryTree {
    TreeNode* root;

public:
    BinaryTree() {
        this->root = NULL;
    }

    // set the root node
    void setRoot(int data) {
        root = new TreeNode(data);
    }

    // getter for root (read-only outside class)
    TreeNode* getRoot() {
        return root;
    }

    void insertNode(TreeNode* parent, int data, char direction) {
        TreeNode* newNode = new TreeNode(data);
        if (parent == NULL) {
            cout << "Parent is NULL, cannot insert " << data << endl;
            return;
        }
        if (direction == 'L') {
            parent->left = newNode;
        } else if (direction == 'R') {
            parent->right = newNode;
        }
    }

    void inOrderTraversal(TreeNode* root) {
        if (root == NULL) return;
        inOrderTraversal(root->left);
        cout << root->data << " ";
        inOrderTraversal(root->right);
    }

    void preOrderTraversal(TreeNode* root) {
        if (root == NULL) return;
        cout << root->data << " ";
        preOrderTraversal(root->left);
        preOrderTraversal(root->right);
    }

    void postOrderTraversal(TreeNode* root) {
        if (root == NULL) return;
        postOrderTraversal(root->left);
        postOrderTraversal(root->right);
        cout << root->data << " ";
    }
};

int main() {
    BinaryTree bt;

    // Set root
    bt.setRoot(1);

    // build tree
    bt.insertNode(bt.getRoot(), 2, 'L');
    bt.insertNode(bt.getRoot(), 3, 'R');
    bt.insertNode(bt.getRoot()->left, 4, 'L');
    bt.insertNode(bt.getRoot()->left, 5, 'R');
    bt.insertNode(bt.getRoot()->right, 6, 'R');

    cout << "InOrder Traversal : ";
    bt.inOrderTraversal(bt.getRoot());
    cout << endl;

    cout << "PreOrder Traversal : ";
    bt.preOrderTraversal(bt.getRoot());
    cout << endl;

    cout << "PostOrder Traversal : ";
    bt.postOrderTraversal(bt.getRoot());
    cout << endl;

    return 0;
}
