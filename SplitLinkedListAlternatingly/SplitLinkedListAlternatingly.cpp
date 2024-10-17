/*
https://www.geeksforgeeks.org/problems/split-singly-linked-list-alternatingly/1
*/

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    struct Node* next;

    Node(int x) {
        data = x;
        next = NULL;
    }
};


// } Driver Code Ends
/*
struct Node
{
    int data;
    struct Node* next;

    Node(int x){
        data = x;
        next = NULL;
    }

};
*/

class Solution {
  public:
    // Function to split a linked list into two lists alternately
    vector<Node*> alternatingSplitList(struct Node* head) {
        vector<int>all;
        while(head!=nullptr){
            all.push_back(head->data);
            head=head->next;
        }
        vector<int>frst, sec;
        int sz=all.size();
        for(int i=0; i<sz; ++i){
            if(i%2==0) frst.push_back(all[i]);
            else sec.push_back(all[i]);
        }
        vector<Node*>res;
        Node *frstHead=new Node(frst[0]);
        Node *tailFrFrst=frstHead;
        for(int i=1; i<frst.size(); ++i){
            Node *nwNode=new Node(frst[i]);
            tailFrFrst->next=nwNode;
            tailFrFrst=tailFrFrst->next;
        }
        Node *secHead=new Node(sec[0]);
        Node *tailFrSec=secHead;
        for(int i=1; i<sec.size(); ++i){
            Node *nwNode=new Node(sec[i]);
            tailFrSec->next=nwNode;
            tailFrSec=tailFrSec->next;
        }
        res.push_back(frstHead);
        res.push_back(secHead);
        return res;
    }
};


//{ Driver Code Starts.

void printList(struct Node* node) {
    while (node != NULL) {
        cout << node->data << " ";
        node = node->next;
    }
    cout << endl;
}

int main() {
    int t;
    cin >> t;
    cin.ignore();

    while (t--) {
        vector<int> arr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;

        while (ss >> number) {
            arr.push_back(number);
        }

        struct Node* head = new Node(arr[0]);
        struct Node* tail = head;

        for (int i = 1; i < arr.size(); ++i) {
            tail->next = new Node(arr[i]);
            tail = tail->next;
        }

        Solution ob;
        vector<Node*> result = ob.alternatingSplitList(head);
        printList(result[0]);
        printList(result[1]);
    }

    return 0;
}

// } Driver Code Ends