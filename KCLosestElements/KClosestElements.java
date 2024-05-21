/*
https://www.geeksforgeeks.org/problems/k-closest-elements3619/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);

            int[] ans = new Solution().printKClosest(arr, n, k, x);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class DescendingOrderComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}

class Solution {
    int[] printKClosest(int[] arr, int n, int k, int x) {
        TreeMap<Integer, TreeSet<Integer>>mp=new TreeMap<>();
        for(int i=0; i<n; ++i){
            if(mp.containsKey(Math.abs(arr[i]-x))){
                TreeSet<Integer>curr=mp.get(Math.abs(arr[i]-x));
                curr.add(arr[i]);
                mp.put(Math.abs(arr[i]-x), curr);
            } else{
                TreeSet<Integer>nw=new TreeSet<>(new DescendingOrderComparator());
                nw.add(arr[i]);
                mp.put(Math.abs(arr[i]-x), nw);
            }
        }
        ArrayList<Integer>res=new ArrayList<>();
        HashSet<Integer>seen=new HashSet<>();
        seen.add(x);
        for(Map.Entry<Integer, TreeSet<Integer>>entry: mp.entrySet()){
            TreeSet<Integer>curval=entry.getValue();
            Iterator itr=curval.iterator();
            while (itr.hasNext()) {
                int value = (int)itr.next();
                if (value != x) {
                    res.add(value);
                    seen.add(value);
                    if (res.size() == k) break;
                }
            }
            if(res.size()==k) break;
        }
        int idx=0;
        while(res.size()!=k){
            if(!seen.contains(arr[idx])){
                if(arr[idx]!=x){
                    res.add(arr[idx]);
                }
            }
            idx++;
            if(idx>=n) break;
        }
        int[] fnres=new int[res.size()];
        for(int i=0; i<res.size(); ++i){
            fnres[i]=res.get(i);
        }
        return fnres;
    }
}
