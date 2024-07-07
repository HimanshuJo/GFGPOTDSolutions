/*
https://www.geeksforgeeks.org/problems/remove-all-occurences-of-duplicates-in-a-linked-list/1
*/

//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

/* Link list node */
struct Node {
    int data;
    struct Node *next;

    Node(int x) {
        data = x;
        next = NULL;
    }
};


// } Driver Code Ends
// User function Template for C++

/* Linked List node structure

struct Node {
    int data;
    struct Node *next;
};

*/

class Solution {
  public:
    Node* removeAllDuplicates(struct Node* head) {
        vector<int>tmp;
        map<int, int>mp;
        while(head!=nullptr){
            int curval=head->data;
            mp[curval]++;
            head=head->next;
        }
        for(auto &entries: mp){
            if(entries.second==1){
                tmp.push_back(entries.first);
            }
        }
        if(tmp.size()>=1){
            Node *res=new Node(tmp[0]);
            Node *tail=res;
            for(int i=1; i<tmp.size(); ++i){
                Node *nwNode=new Node(tmp[i]);
                tail->next=nwNode;
                tail=tail->next;
            }
            return res;   
        }
        return nullptr;
    }
};

//{ Driver Code Starts.
/* Function to print linked list */
void printList(struct Node *head) {
    struct Node *temp = head;
    while (temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
}

// Driver program to test above functions
int main() {
    int T;
    cin >> T;

    while (T--) {
        int N;

        cin >> N;

        Node *head = NULL;
        Node *temp = head;

        for (int i = 0; i < N; i++) {
            int data;
            cin >> data;
            if (head == NULL)
                head = temp = new Node(data);
            else {
                temp->next = new Node(data);
                temp = temp->next;
            }
        }

        Solution ob;
        head = ob.removeAllDuplicates(head);
        printList(head);

        cout << "\n";
    }
    return 0;
}

// } Driver Code Ends