/*
https://www.geeksforgeeks.org/problems/count-pairs-whose-sum-is-equal-to-x/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class count_pairs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n1 = sc.nextInt();
            Integer arr1[] = new Integer[n1];

            for (int i = 0; i < n1; i++) arr1[i] = sc.nextInt();

            int n2 = sc.nextInt();
            Integer arr2[] = new Integer[n2];

            for (int i = 0; i < n2; i++) arr2[i] = sc.nextInt();

            LinkedList<Integer> head1 = new LinkedList<>(Arrays.asList(arr1));
            LinkedList<Integer> head2 = new LinkedList<>(Arrays.asList(arr2));

            int x = sc.nextInt();
            Solution gfg = new Solution();
            System.out.println(gfg.countPairs(head1, head2, x));
        }
    }
}
// } Driver Code Ends


// your task is to complete this function

/*
class Node
{
    int data;
    Node next;

    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {

    public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2, int x) {
        ArrayList<Integer>frst=new ArrayList<>();
        HashMap<Integer, Integer>mp=new HashMap<>();
        int szhead1=head1.size(), szhead2=head2.size(), idx1=0, idx2=0;
        while(idx1<=szhead1-1){
            frst.add(head1.get(idx1));
            idx1++;
        }
        while(idx2<=szhead2-1){
            if(!mp.containsKey(head2.get(idx2))){
                mp.put(head2.get(idx2), head2.get(idx2));
            }
            idx2++;
        }
        int res=0, sz=frst.size();
        for(int i=0; i<sz; ++i){
            int tochk=x-frst.get(i);
            if(mp.containsKey(tochk)) res++;
        }
        return res;
    }
}
