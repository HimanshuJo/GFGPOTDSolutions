/*
https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1
*/

/* Node is defined as
  class Node {
  public:
    int data;
    Node* next;

    Node(int x) {
        data = x;
        next = nullptr;
    }
};
*/
class Solution {
  public:
    Node* segregate(Node* head) {
        vector<int>tmp;
        Node *tmpHead=head;
        while(tmpHead!=nullptr){
            tmp.push_back(tmpHead->data);
            tmpHead=tmpHead->next;
        }
        sort(tmp.begin(), tmp.end());
        Node *res=new Node(tmp[0]);
        Node *tail=res;
        for(int i=1; i<tmp.size(); ++i){
            Node *nwNode=new Node(tmp[i]);
            tail->next=nwNode;
            tail=tail->next;
        }
        return res;
    }
};