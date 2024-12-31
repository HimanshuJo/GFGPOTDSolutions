/*
https://www.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.longestConsecutive(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        TreeSet<Integer>allValues=new TreeSet<>();
        for(int values: arr){
            allValues.add(values);
        }
        ArrayList<Integer>listAllValues=new ArrayList<>();
        Iterator itr=allValues.iterator();
        while(itr.hasNext()){
            int currentValue=(int)itr.next();
            listAllValues.add(currentValue);
        }
        int lengthOfList=listAllValues.size(), resultantLength=Integer.MIN_VALUE;
        for(int i=0; i<lengthOfList; ++i){
            int currentValue=listAllValues.get(i);
            if(i+1<=lengthOfList-1){
                int nextIndex=i+1, currentLength=1;
                while(true){
                    if(nextIndex>=lengthOfList) break;
                    if(listAllValues.get(nextIndex)!=currentValue+1) break;
                    currentValue=listAllValues.get(nextIndex);
                    currentLength++;
                    nextIndex++;
                }
                resultantLength=Math.max(resultantLength, currentLength);
            }
        }
        return resultantLength;
    }
}