/*
https://www.geeksforgeeks.org/problems/sum-of-the-longest-bloodline-of-a-tree/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

struct Node
{
    int data;
    struct Node *left;
    struct Node *right;

    Node(int x)
    {
        data = x;
        left = NULL;
        right = NULL;
    }
};

void printInorder(Node *node)
{
    if (node == NULL)
    {
        return;
    }
    printInorder(node->left);
    cout << node->data << " ";
    printInorder(node->right);
}
Node *buildTree(string str)
{
    // Corner Case
    if (str.length() == 0 || str[0] == 'N')
        return NULL;

    // Creating vector of strings from input
    // string after spliting by space
    vector<string> ip;

    istringstream iss(str);
    for (string str; iss >> str;)
        ip.push_back(str);

    // Create the root of the tree
    Node *root = new Node(stoi(ip[0]));

    // Push the root to the queue
    queue<Node *> queue;
    queue.push(root);

    // Starting from the second element
    int i = 1;
    while (!queue.empty() && i < ip.size())
    {

        // Get and remove the front of the queue
        Node *currNode = queue.front();
        queue.pop();

        // Get the current node's value from the string
        string currVal = ip[i];

        // If the left child is not null
        if (currVal != "N")
        {

            // Create the left child for the current Node
            currNode->left = new Node(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->left);
        }

        // For the right child
        i++;
        if (i >= ip.size())
            break;
        currVal = ip[i];

        // If the right child is not null
        if (currVal != "N")
        {

            // Create the right child for the current node
            currNode->right = new Node(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->right);
        }
        i++;
    }

    return root;
}


// } Driver Code Ends
//User function Template for C++

/*
structure of the node of the binary tree is as
struct Node
{
    int data;
    struct Node *left;
    struct Node *right;

    Node(int x)
    {
        data = x;
        left = NULL;
        right = NULL;
    }
};
*/
class Solution
{
public:

    int bfs(Node *root){
        queue<Node*>q;
        q.push(root);
        map<Node*, Node*>parent;
        map<int, vector<Node*>>lvslevel;
        parent[root]=nullptr;
        int curlevel=1;
        while(!q.empty()){
            int sz=q.size();
            while(sz--){
                Node *curr=q.front();
                q.pop();
                if(curr->left==nullptr&&curr->right==nullptr){
                    lvslevel[curlevel].push_back(curr);
                }
                if(curr->left!=nullptr){
                    q.push(curr->left);
                    parent[curr->left]=curr;
                }
                if(curr->right!=nullptr){
                    q.push(curr->right);
                    parent[curr->right]=curr;
                }
            }
            curlevel++;
        }
        auto itr=lvslevel.end();
        itr--;
        auto &vecentries=itr->second;
        int res=INT_MIN;
        for(auto &vals: vecentries){
            int cursm=0;
            Node *curval=vals;
            while(true){
                if(curval==nullptr) break;
                cursm+=curval->data;
                curval=parent[curval];
                if(curval==nullptr) break;
            }
            res=max(res, cursm);
        }
        return res;
    }
    
    int sumOfLongRootToLeafPath(Node *root)
    {
        return bfs(root);
    }
};

//{ Driver Code Starts.

int main()
{

    int t;
    scanf("%d", &t);
    cin.ignore();
    while (t--)
    {
        string treeString;
        getline(cin, treeString);
        Node *root = buildTree(treeString);
        Solution obj;
        int res = obj.sumOfLongRootToLeafPath(root);
        cout << res << "\n";
    }
    return 0;
}
// } Driver Code Ends