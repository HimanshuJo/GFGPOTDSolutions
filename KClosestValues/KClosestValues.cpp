/*
https://www.geeksforgeeks.org/problems/k-closest-values/1
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

class CustomComparator{
  
  public:
  
  bool operator()(const pair<int, int>&A, const pair<int, int>&B){
      if(A.second==B.second) return A.first<B.first;
      return A.second<B.second;
  }
};

class Solution {
  public:
  
    void dfs(Node *root, int target, int k, vector<pair<int, int>>&absDiffs){
        if(root==nullptr) return;
        int curDiff=abs(root->data-target);
        absDiffs.push_back({root->data, curDiff});
        dfs(root->left, target, k, absDiffs);
        dfs(root->right, target, k, absDiffs);
    }
  
    void preOrder(Node *root, int target, int k, vector<pair<int, int>>&absDiffs){
        dfs(root, target, k, absDiffs);
    }
  
    vector<int> getKClosest(Node* root, int target, int k) {
        vector<pair<int, int>>absDiffs;
        preOrder(root, target, k, absDiffs);
        sort(absDiffs.begin(), absDiffs.end(), CustomComparator());
        vector<int>res;
        for(auto &vals: absDiffs){
            res.push_back(vals.first);
            k--;
            if(k==0) break;
        }
        return res;
    }
};