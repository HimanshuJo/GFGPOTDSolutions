/*
https://www.geeksforgeeks.org/problems/longest-subsequence-such-that-difference-between-adjacents-is-one4724/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] a = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.longestSubseq(n, a);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    
    public static int depthFirstSearchTraversal_forArrays(int n, int[] a, int currentElementInA, int index){
        if(index>=n) return 0;
        int lengthLongestSubsequenceWhereAbsoluteDiffAdjacentElementsIsOne_forCurrentElement=0;
        int resultAfterPickingCurrentIndexElementForSubsequence=0;
        int resultAfterNotPickingCurrentIndexElementForSubsequence=0;
        if(Math.abs(a[index]-currentElementInA)==1){
            int currentElementAtIndexInA=a[index];
            resultAfterPickingCurrentIndexElementForSubsequence=1+depthFirstSearchTraversal_forArrays(n, a, currentElementAtIndexInA, index+1);
            resultAfterNotPickingCurrentIndexElementForSubsequence=depthFirstSearchTraversal_forArrays(n, a, currentElementInA, index+1);
            lengthLongestSubsequenceWhereAbsoluteDiffAdjacentElementsIsOne_forCurrentElement=Math.max(lengthLongestSubsequenceWhereAbsoluteDiffAdjacentElementsIsOne_forCurrentElement, 
                Math.max(resultAfterPickingCurrentIndexElementForSubsequence, resultAfterNotPickingCurrentIndexElementForSubsequence));
        } else{
            resultAfterNotPickingCurrentIndexElementForSubsequence=depthFirstSearchTraversal_forArrays(n, a, currentElementInA, index+1);
            lengthLongestSubsequenceWhereAbsoluteDiffAdjacentElementsIsOne_forCurrentElement=Math.max(lengthLongestSubsequenceWhereAbsoluteDiffAdjacentElementsIsOne_forCurrentElement, 
                Math.max(resultAfterPickingCurrentIndexElementForSubsequence, resultAfterNotPickingCurrentIndexElementForSubsequence));
        }
        return lengthLongestSubsequenceWhereAbsoluteDiffAdjacentElementsIsOne_forCurrentElement;
    }
    
    public static int longestSubseq(int n, int[] a) {
        int lengthLongestSubsequenceWhereAbsoluteDiffAdjacentElementsIsOne=0;
        for(int index=0; index<n; ++index){
            int currentElementInA=a[index];
            int lengthLongestSubsequenceWhereAbsoluteDiffAdjacentElementsIsOne_forCurrentElement=1;
            lengthLongestSubsequenceWhereAbsoluteDiffAdjacentElementsIsOne_forCurrentElement+=depthFirstSearchTraversal_forArrays(n, a, currentElementInA, index);
            lengthLongestSubsequenceWhereAbsoluteDiffAdjacentElementsIsOne=Math.max(lengthLongestSubsequenceWhereAbsoluteDiffAdjacentElementsIsOne, lengthLongestSubsequenceWhereAbsoluteDiffAdjacentElementsIsOne_forCurrentElement);
        }
        return lengthLongestSubsequenceWhereAbsoluteDiffAdjacentElementsIsOne;
    }
}
