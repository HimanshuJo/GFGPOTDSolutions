/*
https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class gfg {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int w = Integer.parseInt(br.readLine());

            String line = br.readLine();
            String[] tokens = line.split(" ");
            List<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] val = new int[array.size()];
            int idx = 0;
            for (int i : array) val[idx++] = i;

            String lin = br.readLine();
            String[] toke = lin.split(" ");
            List<Integer> array1 = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : toke) {
                array1.add(Integer.parseInt(token));
            }

            int[] wt = new int[array1.size()];
            idx = 0;
            for (int i : array1) wt[idx++] = i;

            // calling method knapSack() of class Solution
            System.out.println(new Solution().knapSack(w, wt, val));
        }
    }
}
// } Driver Code Ends


class Solution {
    
    public static int depthFirstSearch_forArrays(int W, int wt[], int val[], int beginIndex, int[][] memoization){
        if(beginIndex>=wt.length) return 0;
        if(memoization[W][beginIndex]!=-1) return memoization[W][beginIndex];
        int resultantMaxSumValues=0, resultAfterPickingCurrentElement=0, resultAfterNotPickingCurrentElement=0;
        resultAfterNotPickingCurrentElement=depthFirstSearch_forArrays(W, wt, val, beginIndex+1, memoization);
        if(wt[beginIndex]<=W){
            resultAfterPickingCurrentElement=val[beginIndex]+depthFirstSearch_forArrays(W-wt[beginIndex], wt, val, beginIndex+1, memoization);
            resultantMaxSumValues=Math.max(resultantMaxSumValues, Math.max(resultAfterPickingCurrentElement, resultAfterNotPickingCurrentElement));
        }
        resultantMaxSumValues=Math.max(resultantMaxSumValues, Math.max(resultAfterPickingCurrentElement, resultAfterNotPickingCurrentElement));
        return memoization[W][beginIndex]=resultantMaxSumValues;
    }
    
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[]) {
        int beginIndex=0;
        int[][] memoization=new int[W+1][wt.length+1];
        for(int i=0; i<=W; ++i){
            for(int j=0; j<=wt.length; ++j){
                memoization[i][j]=-1;
            }
        }
        return depthFirstSearch_forArrays(W, wt, val, beginIndex, memoization);
    }
}
