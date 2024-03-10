/*
https://www.geeksforgeeks.org/problems/remove-all-duplicates-from-a-given-string4321/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
//Initial Template for Java



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String str = br.readLine().trim();

            String ans = new Solution().removeDuplicates(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    String removeDuplicates(String str) {
        StringBuilder res=new StringBuilder();
        HashMap<Character, Character>mp=new HashMap<>();
        int lngth=str.length();
        for(int i=0; i<lngth; ++i){
            char curr=str.charAt(i);
            if(!mp.containsKey(curr)){
                res.append(curr);
                mp.put(curr, curr);
            }
        }
        return String.valueOf(res);
    }
}

