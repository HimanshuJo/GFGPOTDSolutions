/*
https://www.geeksforgeeks.org/problems/reach-a-given-score-1587115621/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

/*
TLE: 10 /1120

// Complete this function!

class Geeks {
    
    long dfs(int n, StringBuilder curr, HashMap<String, Long>memo){
        if(n<0) return 0L;
        char[] currToChrArr=String.valueOf(curr).toCharArray();
        Arrays.sort(currToChrArr);
        StringBuilder sortedCurr=new StringBuilder(new String(currToChrArr));
        if(memo.containsKey(String.valueOf(sortedCurr))) return 0L;
        if(n==0){
            memo.put(String.valueOf(sortedCurr), 1L);
            return 1;
        }
        long pk3=0, pk5=0, pk10=0;
        if(n-3>=0){
            StringBuilder nw=new StringBuilder(curr);
            nw.append("3");
            pk3=dfs(n-3, nw, memo);
        }
        if(n-5>=0){
            StringBuilder nw=new StringBuilder(curr);
            nw.append("5");
            pk5=dfs(n-5, nw, memo);
        }
        if(n-10>=0){
            StringBuilder nw=new StringBuilder(curr);
            nw.append("10");
            pk10=dfs(n-10, nw, memo);
        }
        memo.put(String.valueOf(sortedCurr), pk3+pk5+pk10);
        return memo.get(String.valueOf(sortedCurr));
    }
    
    public long count(int n) {
        StringBuilder curr=new StringBuilder("");
        HashMap<String, Long>memo=new HashMap<>();
        return dfs(n, curr, memo);
    }
}
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        while(t > 0)
        {
            int n = in.nextInt();
            Geeks obj = new Geeks();
            System.out.println(obj.count(n));
            t--;
        }
    }
}
// } Driver Code Ends


// Complete this function!

class Geeks {
    public long count(int n) {
        int[] dp=new int[n+1];
        for(int i=0; i<=n; ++i){
            dp[i]=0;
        }
        dp[0]=1;
        for(int i=3; i<=n; ++i){
            dp[i]+=dp[i-3];
        }
        for(int i=5; i<=n; ++i){
            dp[i]+=dp[i-5];
        }
        for(int i=10; i<=n; ++i){
            dp[i]+=dp[i-10];
        }
        return dp[n];
    }
}