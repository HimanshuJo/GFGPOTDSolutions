/*
https://www.geeksforgeeks.org/problems/find-pair-given-difference1559/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
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

            int x;
            x = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.findPair(n, x, arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    
    public boolean performBinarySearch(int otherElementNeededToFormPair, int[] arr, int currentIndexInArray){
        int leftBoundary=0, rightBoundary=arr.length-1;
        boolean isOtherElementNeededToFormPairPresent=false;
        while(leftBoundary<=rightBoundary){
            int middleOfCurrentRange=leftBoundary+(rightBoundary-leftBoundary)/2;
            if(arr[middleOfCurrentRange]==otherElementNeededToFormPair&&middleOfCurrentRange!=currentIndexInArray){
                isOtherElementNeededToFormPairPresent=true;
                break;
            } else if(arr[middleOfCurrentRange]>otherElementNeededToFormPair){
                rightBoundary=middleOfCurrentRange-1;
            } else leftBoundary=middleOfCurrentRange+1;
        }
        return isOtherElementNeededToFormPairPresent;
    }
    
    public int findPair(int n, int x, int[] arr) {
        Arrays.sort(arr);
        for(int i=0; i<n; ++i){
            int currentElementInArray=arr[i], otherElementNeededToFormPair=currentElementInArray+x;
            boolean doesOtherElementNeededToFormPairPresent=performBinarySearch(otherElementNeededToFormPair, arr, i);
            if(doesOtherElementNeededToFormPairPresent) return 1;
        }
        return -1;
    }
}
