/*
https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1
*/

/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node segregate(Node head) {
        ArrayList<Integer>nodesValsList=new ArrayList<>();
        while(head!=null){
            nodesValsList.add(head.data);
            head=head.next;
        }
        Collections.sort(nodesValsList);
        Node resultantList=new Node(nodesValsList.get(0));
        Node tailForResultantList=resultantList;
        for(int i=1; i<nodesValsList.size(); ++i){
            Node newNode=new Node(nodesValsList.get(i));
            tailForResultantList.next=newNode;
            tailForResultantList=tailForResultantList.next;
        }
        return resultantList;
    }
}