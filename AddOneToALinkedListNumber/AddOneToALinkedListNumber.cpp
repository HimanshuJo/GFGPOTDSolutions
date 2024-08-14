/*
https://www.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1
*/

//{ Driver Code Starts
// Initial template for C++

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
        cout << node->data % 10;
        node = node->next;
    }
    cout << "\n";
}


// } Driver Code Ends
// User function template for C++

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
    Node* addOne(Node* head) {
        string all="";
        vector<int>sec;
        while(head!=nullptr){
            all+=to_string(head->data);
            head=head->next;
        }
        int sz=all.size();
        for(int i=0; i<all.size(); ++i){
            sec.push_back(all[i]-'0');
        }
        int sz2=sec.size(), carry=1;
        for(int i=sz2-1; i>=0; --i){
            int nwnm=sec[i]+carry;
            carry=nwnm/10;
            if(i!=0){
                nwnm%=10;   
            }
            sec[i]=nwnm;
        }
        string tofrm="";
        for(auto &vals: sec){
            tofrm+=to_string(vals);
        }
        Node *res=new Node(tofrm[0]-'0');
        Node *tail=res;
        int sz3=tofrm.size();
        for(int i=1; i<sz3; ++i){
            Node *nwNode=new Node(tofrm[i]-'0');
            tail->next=nwNode;
            tail=tail->next;
        }
        return res;
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
        while (ss >> number) {
            arr.push_back(number);
        }

        if (arr.empty()) {
            cout << -1 << endl;
            continue;
        }

        int data = arr[0];
        struct Node* head = new Node(data);
        struct Node* tail = head;
        for (int i = 1; i < arr.size(); ++i) {
            data = arr[i];
            tail->next = new Node(data);
            tail = tail->next;
        }
        Solution ob;
        head = ob.addOne(head);
        printList(head);
    }
    return 0;
}

// } Driver Code Ends