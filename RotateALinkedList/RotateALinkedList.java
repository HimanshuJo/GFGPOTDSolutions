/*
https://www.geeksforgeeks.org/problems/rotate-a-linked-list/1
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


// } Driver Code Ends
/* node of linked list:

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

*/

class Solution {
    // Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        ArrayList<Integer>listNodesAfterLeftShift=new ArrayList<>();
        Node temporaryHead=head;
        Node tailForTemporaryHead=temporaryHead;
        while(true){
            listNodesAfterLeftShift.add(tailForTemporaryHead.data);
            if(tailForTemporaryHead.next==null&&k!=0) return temporaryHead;
            tailForTemporaryHead=tailForTemporaryHead.next;
            k--;
            if(k==0) break;
        }
        Node newHeadForTemporaryTail=tailForTemporaryHead;
        Node tailForNewHead=newHeadForTemporaryTail;
        while(true){
            if(tailForNewHead.next==null) break;
            tailForNewHead=tailForNewHead.next;
        }
        for(int i=0; i<listNodesAfterLeftShift.size(); ++i){
            Node newNode=new Node(listNodesAfterLeftShift.get(i));
            tailForNewHead.next=newNode;
            tailForNewHead=tailForNewHead.next;
        }
        return newHeadForTemporaryTail;
    }
}


//{ Driver Code Starts.

public class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            if (!input.isEmpty()) {
                String[] numbers = input.split("\\s+");
                for (String num : numbers) {
                    if (!num.isEmpty()) {
                        arr.add(Integer.parseInt(num));
                    }
                }
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); ++i) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            head = ob.rotate(head, k);
            printList(head);
        }
    }
}

// } Driver Code Ends