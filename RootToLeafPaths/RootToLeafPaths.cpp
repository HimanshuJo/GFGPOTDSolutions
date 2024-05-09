/*
https://www.geeksforgeeks.org/problems/root-to-leaf-paths/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


struct Node
{
    int data;
    struct Node *left;
    struct Node *right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};

// Function to Build Tree
Node* buildTree(string str)
{
    // Corner Case
    if(str.length() == 0 || str[0] == 'N')
            return NULL;

    // Creating vector of strings from input
    // string after spliting by space
    vector<string> ip;

    istringstream iss(str);
    for(string str; iss >> str; )
        ip.push_back(str);

    // Create the root of the tree
    Node *root = new Node(stoi(ip[0]));

    // Push the root to the queue
    queue<Node*> queue;
    queue.push(root);

    // Starting from the second element
    int i = 1;
    while(!queue.empty() && i < ip.size()) {

        // Get and remove the front of the queue
        Node* currNode = queue.front();
        queue.pop();

        // Get the current node's value from the string
        string currVal = ip[i];

        // If the left child is not null
        if(currVal != "N") {

            // Create the left child for the current Node
            currNode->left = new Node(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->left);
        }

        // For the right child
        i++;
        if(i >= ip.size())
            break;
        currVal = ip[i];

        // If the right child is not null
        if(currVal != "N") {

            // Create the right child for the current node
            currNode->right = new Node(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->right);
        }
        i++;
    }

    return root;
}

Node* inputTree(){
    string treeString;
    getline(cin,treeString);
    Node* root = buildTree(treeString);
    return root;
}
void inorder(Node *root)
{
    if (root == NULL)
       return;
    inorder(root->left);
    cout << root->data << " ";
    inorder(root->right);
}


class Matrix
{
public:
    template <class T>
    static void input(vector<vector<T>> &A,int n,int m)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                scanf("%d ",&A[i][j]);
            }
        }
    }

    template <class T>
    static void print(vector<vector<T>> &A)
    {
        for (int i = 0; i < A.size(); i++)
        {
            for (int j = 0; j < A[i].size(); j++)
            {
                cout << A[i][j] << " ";
            }
            cout << endl;
        }
    }
};


// } Driver Code Ends
/*

Definition for Binary Tree Node
struct Node
{
    int data;
    struct Node* left;
    struct Node* right;

    Node(int x){
        data = x;
        left = right = NULL;
    }
};
*/

class Solution {
  public:
  
    vector<vector<int>> bfs(Node *root){
        vector<vector<Node*>>q;
        vector<Node*>bgn{root};
        vector<vector<int>>res;
        q.push_back(bgn);
        while(!q.empty()){
            int sz=q.size();
            while(sz--){
                auto curr=q.back();
                q.pop_back();
                Node *lstnode=curr.back();
                if(lstnode->left==nullptr&&lstnode->right==nullptr){
                    vector<int>nw;
                    for(auto &vals: curr){
                        nw.push_back(vals->data);
                    }
                    res.push_back(nw);
                } else{
                    if(lstnode->left!=nullptr){
                        vector<Node*>nwfrlft=curr;
                        nwfrlft.push_back(lstnode->left);
                        q.push_back(nwfrlft);
                    }
                    if(lstnode->right!=nullptr){
                        vector<Node*>nwfrrght=curr;
                        nwfrrght.push_back(lstnode->right);
                        q.push_back(nwfrrght);
                    }
                }
            }
        }
        reverse(res.begin(), res.end());
        return res;
    }
  
    vector<vector<int>> Paths(Node* root) {
        return bfs(root);
    }
};



//{ Driver Code Starts.

int main(){
    int t;
    scanf("%d ",&t);
    while(t--){
        
        Node* root = inputTree();
        
        Solution obj;
        vector<vector<int>> res = obj.Paths(root);
        
        Matrix::print(res);
        
    }
}

// } Driver Code Ends