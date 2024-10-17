/*
https://www.geeksforgeeks.org/problems/split-singly-linked-list-alternatingly/1
*/

//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = sc.nextLine();
            Scanner ss = new Scanner(input);

            while (ss.hasNextInt()) {
                arr.add(ss.nextInt());
            }

            Node head = new Node(arr.get(0));
            Node tail = head;

            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }

            Solution ob = new Solution();
            Node[] result = ob.alternatingSplitList(head);
            printList(result[0]);
            printList(result[1]);
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java
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
    // Function to append a new node with newData at the end of a linked list
    Node[] alternatingSplitList(Node head) {
        ArrayList<Integer>allNodes=new ArrayList<>();
        while(head!=null){
            allNodes.add(head.data);
            head=head.next;
        }
        ArrayList<Integer>firstList=new ArrayList<>();
        ArrayList<Integer>secondList=new ArrayList<>();
        int sizeOfAllNodes=allNodes.size();
        for(int i=0; i<sizeOfAllNodes; ++i){
            if(i%2==0) firstList.add(allNodes.get(i));
            else secondList.add(allNodes.get(i));
        }
        Node[] resultantNodes=new Node[2];
        Node firstHead=new Node(firstList.get(0));
        Node tailForFirst=firstHead;
        for(int i=1; i<firstList.size(); ++i){
            Node newNode=new Node(firstList.get(i));
            tailForFirst.next=newNode;
            tailForFirst=tailForFirst.next;
        }
        Node secondHead=new Node(secondList.get(0));
        Node tailForSecond=secondHead;
        for(int i=1; i<secondList.size(); ++i){
            Node newNode=new Node(secondList.get(i));
            tailForSecond.next=newNode;
            tailForSecond=tailForSecond.next;
        }
        resultantNodes[0]=firstHead;
        resultantNodes[1]=secondHead;
        return resultantNodes;
    }
}