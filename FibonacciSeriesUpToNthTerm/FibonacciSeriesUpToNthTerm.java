/*
https://www.geeksforgeeks.org/problems/fibonacci-series-up-to-nth-term/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int ans[] = obj.Series(n);
            for (int i : ans) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {

    int[] Series(int n) {
        int[] res=new int[n+1];
        int idx=0, prev=0, curr=1, mod=1000000000+7;
        res[idx++]=prev;
        while(idx<=n){
            res[idx]=curr;
            int temp=curr;
            curr+=prev;
            curr%=mod;
            prev=temp;
            idx++;
        }
        return res;
    }
}