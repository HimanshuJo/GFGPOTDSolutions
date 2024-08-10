/*
https://www.geeksforgeeks.org/problems/rotate-a-linked-list/1
*/

//{ Driver Code Starts
// Initial Template for C++
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

void printList(Node* node) {
    while (node != NULL) {
        cout << node->data << " ";
        node = node->next;
    }
    cout << "\n";
}


// } Driver Code Ends
/*

struct Node {
    int data;
    struct Node *next;
    Node(int x) {
        data = x;
        next = NULL;
    }
};

*/

class Solution {
  public:
    // Function to rotate a linked list.
    Node* rotate(Node* head, int k) {
        vector<int>others;
        Node *toad=head;
        Node *toadTail=toad;
        while(true){
            others.push_back(toadTail->data);
            if(toadTail->next==nullptr&&k!=0) return toad;
            toadTail=toadTail->next;
            k--;
            if(k==0) break;
        }
        Node *tmphead=toadTail;
        Node *tailtmphead=tmphead;
        while(true){
            if(tailtmphead->next==nullptr) break;
            tailtmphead=tailtmphead->next;
        }
        for(auto &vals: others){
            Node *nwNode=new Node(vals);
            tailtmphead->next=nwNode;
            tailtmphead=tailtmphead->next;
        }
        return tmphead;
    }
};


//{ Driver Code Starts.

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

        // Read numbers from the input line
        while (ss >> number) {
            arr.push_back(number);
        }

        Node* head = nullptr;

        // Check if the array is empty
        if (!arr.empty()) {
            head = new Node(arr[0]);
            Node* tail = head;
            for (size_t i = 1; i < arr.size(); ++i) {
                tail->next = new Node(arr[i]);
                tail = tail->next;
            }
        }
        int k;
        cin >> k;
        cin.ignore();

        Solution ob;
        head = ob.rotate(head, k);
        printList(head);
    }
    return 1;
}

// } Driver Code Ends