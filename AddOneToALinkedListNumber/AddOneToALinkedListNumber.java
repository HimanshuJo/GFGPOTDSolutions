/*
https://www.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1
*/

//{ Driver Code Starts
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

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        StringBuilder allIndividualDigits=new StringBuilder();
        while(head!=null){
            allIndividualDigits.append(String.valueOf(head.data));
            head=head.next;
        }
        int lengthIndividualDigits=allIndividualDigits.length();
        ArrayList<Integer>listAllIndividualDigits=new ArrayList<>();
        for(int i=0; i<lengthIndividualDigits; ++i){
            listAllIndividualDigits.add((allIndividualDigits.charAt(i))-'0');
        }
        int sizeListIndividualDigits=listAllIndividualDigits.size(), carry=1;
        for(int i=sizeListIndividualDigits-1; i>=0; --i){
            int numberAfterAddingCarry=listAllIndividualDigits.get(i)+carry;
            carry=numberAfterAddingCarry/10;
            if(i!=0){
                numberAfterAddingCarry%=10;
            }
            listAllIndividualDigits.set(i, numberAfterAddingCarry);
        }
        StringBuilder finalStringToBeFormed=new StringBuilder();
        for(int i=0; i<sizeListIndividualDigits; ++i){
            finalStringToBeFormed.append(String.valueOf(listAllIndividualDigits.get(i)));
        }
        Node resultantLinkedList=new Node((finalStringToBeFormed.charAt(0))-'0');
        Node tailForResultantList=resultantLinkedList;
        int lengthFinalString=finalStringToBeFormed.length();
        for(int i=1; i<lengthFinalString; ++i){
            Node newNode=new Node((finalStringToBeFormed.charAt(i))-'0');
            tailForResultantList.next=newNode;
            tailForResultantList=tailForResultantList.next;
        }
        return resultantLinkedList;
    }
}
