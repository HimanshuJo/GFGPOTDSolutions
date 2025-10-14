/*
https://www.geeksforgeeks.org/problems/range-sum-of-bst/1
*/

/*
class Node {
  public:
    int data;
    Node* left;
    Node* right;

    // Constructor to initialize a new node
    Node(int val) {
        data = val;
        left = NULL;
        right = NULL;
    }
};
*/

class Solution {
  public:
  
    void dfs(Node *root, int l, int r, int &res){
        if(root==nullptr) return;
        if(root->data>=l&&root->data<=r){
            res+=root->data;
        }
        dfs(root->left, l, r, res);
        dfs(root->right, l, r, res);
        return;
    }
  
    void preOrderTraversal(Node *root, int l, int r, int &res){
        dfs(root, l, r, res);
    }
  
    int nodeSum(Node* root, int l, int r) {
        int res=0;
        preOrderTraversal(root, l, r, res);
        return res;
    }
};

