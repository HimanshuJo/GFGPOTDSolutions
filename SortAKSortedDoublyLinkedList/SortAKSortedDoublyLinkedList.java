/*
https://www.geeksforgeeks.org/problems/sort-a-k-sorted-doubly-linked-list/1
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        next = null;
        prev = null;
    }
}

public class Main {
    public static void push(DLLNode tail, int new_data) {
        DLLNode newNode = new DLLNode(new_data);
        newNode.next = null;
        newNode.prev = tail;

        if (tail != null) {
            tail.next = newNode;
        }
    }

    public static void printList(DLLNode head) {
        if (head == null) {
            return;
        }

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String[] arr = br.readLine().trim().split(" ");
            int k = Integer.parseInt(br.readLine().trim());

            DLLNode head = new DLLNode(Integer.parseInt(arr[0]));
            DLLNode tail = head;

            for (int i = 1; i < arr.length; i++) {
                push(tail, Integer.parseInt(arr[i]));
                tail = tail.next;
            }

            Solution obj = new Solution();
            DLLNode sorted_head = obj.sortAKSortedDLL(head, k);
            printList(sorted_head);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public DLLNode sortAKSortedDLL(DLLNode head, int k) {
        if(head==null||head.next==null) return head;
        PriorityQueue<DLLNode>minHeap=new PriorityQueue<>((a, b)->a.data-b.data);
        DLLNode newHead=null, tailForNewHead=null;
        DLLNode current=head;
        for(int i=0; i<=k&&current!=null; ++i){
            minHeap.add(current);
            current=current.next;
        }
        while(!minHeap.isEmpty()){
            DLLNode currentMinNode=minHeap.poll();
            if(newHead==null){
                newHead=currentMinNode;
                tailForNewHead=newHead;
            } else{
                tailForNewHead.next=currentMinNode;
                currentMinNode.prev=tailForNewHead;
                tailForNewHead=currentMinNode;
            }
            if(current!=null){
                minHeap.add(current);
                current=current.next;
            }
            currentMinNode.next=null;
        }
        return newHead;
    }
}