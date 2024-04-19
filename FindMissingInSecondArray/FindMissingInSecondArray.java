/*
https://www.geeksforgeeks.org/problems/in-first-but-second5423/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
//Initial Template for Java





import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java



class Solution
{
    ArrayList<Integer> findMissing(int a[], int b[], int n, int m)
    {
        ArrayList<Integer>res=new ArrayList<>();
        HashMap<Integer, Integer>mp1=new HashMap<>();
        HashMap<Integer, Integer>mp2=new HashMap<>();
        for(int i=0; i<n; ++i){
            if(mp1.containsKey(a[i])){
                mp1.put(a[i], mp1.get(a[i])+1);
            } else mp1.put(a[i], 1);
        }
        for(int i=0; i<m; ++i){
            if(mp1.containsKey(b[i])){
                mp1.put(b[i], mp1.get(b[i])+1);
            } else mp1.put(b[i], 1);
            if(mp2.containsKey(b[i])){
                mp2.put(b[i], mp2.get(b[i])+1);
            } else mp2.put(b[i], 1);
        }
        for(int i=0; i<n; ++i){
            if(mp1.containsKey(a[i])){
                if(mp1.get(a[i])==1) res.add(a[i]);
                else if(!mp2.containsKey(a[i])) res.add(a[i]);
            } else if(!mp2.containsKey(a[i])) res.add(a[i]);
        }
        return res;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int m =Integer.parseInt(q[1]);
            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(a1[i]);
            }
            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            int b[] = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(a2[i]);
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans=ob.findMissing(a,b,n,m);
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();

        }
    }
}



// } Driver Code Ends