/*
https://www.geeksforgeeks.org/problems/recursive-sequence1611/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.sequence(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long sequence(int n){
        int mod=1000000000+7;
        long res=1;
        int curcount=2, curnum=2;
        while(curcount<=n){
            int tmpcurcount=curcount;
            tmpcurcount--;
            long curmul=curnum;
            curnum++;
            while(tmpcurcount-- >0){
                curmul*=curnum++;
                curmul%=mod;
            }
            res+=curmul;
            res%=mod;
            curcount++;
        }
        return (res+mod)%mod;
    }
}