/*
https://www.geeksforgeeks.org/problems/word-break1352/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> dictionary = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            dictionary.add(p);
                        }
                    String s = sc.next();
                    Solution obj = new Solution();  
                    System.out.println(obj.wordBreak(n, s, dictionary));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Pair{
    public int first;
    public StringBuilder second;
    
    public Pair(){};
    
    public Pair(int first, StringBuilder second){
        this.first=first;
        this.second=second;
    }
}

class Solution
{
    
    public static boolean find(ArrayList<String>dictionary, StringBuilder val){
        int sz=dictionary.size();
        for(int i=0; i<sz; ++i){
            if(dictionary.get(i).equals(String.valueOf(val))) return true;
        }
        return false;
    }
    
    public static class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair pair1, Pair pair2) {
            int firstComparison = Integer.compare(pair1.first, pair2.first);
            if (firstComparison != 0) {
                return firstComparison;
            }
            return pair1.second.toString().compareTo(pair2.second.toString());
        }
    }
    
    public static int dfs(String s, ArrayList<String>dictionary, int curidx, StringBuilder curr, TreeMap<Pair, Integer>memo){
        if(curidx>=s.length()){
            boolean flag=find(dictionary, curr);
            if(!flag) return 0;
            return 1;
        }
        if(memo.containsKey(new Pair(curidx, curr))) return memo.get(new Pair(curidx, curr));
        StringBuilder nw1=new StringBuilder();
        nw1.append(s.charAt(curidx));
        StringBuilder nw2=new StringBuilder(curr);
        nw2.append(s.charAt(curidx));
        boolean flag=find(dictionary, curr);
        int pk=0, ntpk=0;
        if(!flag){
            pk=dfs(s, dictionary, curidx+1, nw1, memo);
            ntpk=dfs(s, dictionary, curidx+1, nw2, memo);
        } else ntpk=dfs(s, dictionary, curidx+1, nw2, memo);
        if(pk==1||ntpk==1){
            memo.put(new Pair(curidx, curr), 1);
            return memo.get(new Pair(curidx, curr));
        }
        memo.put(new Pair(curidx, curr), 0);
        return memo.get(new Pair(curidx, curr));
    }
    
    public static int wordBreak(int n, String s, ArrayList<String> dictionary )
    {
        TreeMap<Pair, Integer>memo=new TreeMap<>(new PairComparator());
        StringBuilder curr=new StringBuilder("");
        return dfs(s, dictionary, 0, curr, memo);
    }
}