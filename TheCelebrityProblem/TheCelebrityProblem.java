/*
https://www.geeksforgeeks.org/problems/the-celebrity-problem/1
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    boolean find(ArrayList<Integer>peopleWhoKnowsI, int currentPeople){
        for(int i=0; i<peopleWhoKnowsI.size(); ++i){
            if(peopleWhoKnowsI.get(i)==currentPeople) return true;
        }
        return false;
    }
    
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        int numberOfPeople=mat.length;
        if(numberOfPeople==1) return 0;
        TreeMap<Integer, ArrayList<Integer>>currentPeopleIsKnownByWhom=new TreeMap<>();
        TreeMap<Integer, ArrayList<Integer>>currentPeopleKnowsWhom=new TreeMap<>();
        for(int i=0; i<numberOfPeople; ++i){
            for(int j=0; j<numberOfPeople; ++j){
                if(mat[i][j]==1){
                    if(currentPeopleIsKnownByWhom.containsKey(j)){
                        ArrayList<Integer>peopleWhoKnowsJ=currentPeopleIsKnownByWhom.get(j);
                        peopleWhoKnowsJ.add(i);
                        currentPeopleIsKnownByWhom.put(j, peopleWhoKnowsJ);
                    } else{
                        ArrayList<Integer>peopleWhoKnowsJ=new ArrayList<>();
                        peopleWhoKnowsJ.add(i);
                        currentPeopleIsKnownByWhom.put(j, peopleWhoKnowsJ);
                    }
                    if(currentPeopleKnowsWhom.containsKey(i)){
                        ArrayList<Integer>peopleIKnows=currentPeopleKnowsWhom.get(i);
                        peopleIKnows.add(j);
                        currentPeopleKnowsWhom.put(i, peopleIKnows);
                    } else{
                        ArrayList<Integer>peopleIKnows=new ArrayList<>();
                        peopleIKnows.add(j);
                        currentPeopleKnowsWhom.put(i, peopleIKnows);
                    }
                }
            }
        }
        for(int i=0; i<numberOfPeople; ++i){
            if(!currentPeopleKnowsWhom.containsKey(i)){
                if(currentPeopleIsKnownByWhom.containsKey(i)){
                    ArrayList<Integer>peopleWhoKnowsI=currentPeopleIsKnownByWhom.get(i);
                    boolean doesAllKnowI=true;
                    for(int j=0; j<numberOfPeople; ++j){
                        if(i!=j){
                            if(!find(peopleWhoKnowsI, j)){
                                doesAllKnowI=false;
                                break;
                            }
                        }
                    }
                    if(doesAllKnowI) return i;
                }
            }
        }
        return -1;
    }
}