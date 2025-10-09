/*
https://www.geeksforgeeks.org/problems/postorder-traversal/1
*/

/*
class Node {
  public:
    int data;
    Node* left;
    Node* right;

    Node(int val) {
        data = val;
        left = NULL;
        right = NULL;
    }
};
*/

class Solution {
  public:
  
    void dfs(Node *root, vector<int>&res){
        if(root==nullptr) return;
        dfs(root->left, res);
        dfs(root->right, res);
        res.push_back(root->data);
    }
  
    vector<int> postOrder(Node* root) {
        vector<int>res;
        dfs(root, res);
        return res;
    }
};