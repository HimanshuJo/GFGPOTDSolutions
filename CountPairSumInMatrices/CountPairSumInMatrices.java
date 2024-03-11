/*
https://www.geeksforgeeks.org/problems/count-pairs-sum-in-matrices4332/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            
            int mat1[][] = new int[n][n];
            
            for(int i = 0;i<n;i++){
                input = read.readLine().split(" ");
                for(int j = 0;j<n;j++){
                    mat1[i][j] = Integer.parseInt(input[j]);
                }
            }
            
            int mat2[][] = new int[n][n];
            
            for(int i = 0;i<n;i++){
                input = read.readLine().split(" ");
                for(int j = 0;j<n;j++){
                    mat2[i][j] = Integer.parseInt(input[j]);
                }
            }
            
        
            
            Solution ob = new Solution();
            System.out.println(ob.countPairs(mat1,mat2,n,x));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    int lowerBound(TreeMap<Integer, Integer>tmp, int val){
        for(Map.Entry<Integer, Integer>entry: tmp.entrySet()){
            if(entry.getKey()>=val) return entry.getValue();
        }
        return -1;
    }
    
    int countPairs(int mat1[][], int mat2[][], int n, int x) {
        int res=0;
        TreeMap<Integer, Integer>tmp=new TreeMap<>();
        for(int rwsmat2=0; rwsmat2<n; ++rwsmat2){
            tmp.put(mat2[rwsmat2][n-1], rwsmat2);
        }
        for(int rws=0; rws<n; ++rws){
            for(int cols=0; cols<n; ++cols){
                int cursm=mat1[rws][cols];
                if(x-cursm>=0){
                    int rwsmat2=lowerBound(tmp, x-cursm);
                    if(rwsmat2>=0){
                        for(; rwsmat2<n; ++rwsmat2){
                            for(int colsmat2=0; colsmat2<n; ++colsmat2){
                                int tochk=cursm+mat2[rwsmat2][colsmat2];
                                if(tochk==x) res++;
                                else if(tochk>x) break;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}