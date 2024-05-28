/*
https://www.geeksforgeeks.org/problems/minimum-cost-to-fill-given-weight-in-a-bag1956/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int w;
            w = Integer.parseInt(br.readLine());

            int[] cost = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.minimumCost(n, w, cost);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    
    public static long depthFirstSearch_forArrays(int totalNumberOfPackets, int weightRequired, int[] cost, int[] weightOfThePackets, long[][] memoization){
        if(weightRequired==0) return 0;
        if(totalNumberOfPackets<=0||weightRequired<0) return Integer.MAX_VALUE;
        if(memoization[totalNumberOfPackets][weightRequired]!=-1) return memoization[totalNumberOfPackets][weightRequired];
        long minimumCostToBuyExactlyWKgOranges=Integer.MAX_VALUE;
        long resultAfterPickingCurrentIndexPacketForFinalCost=Integer.MAX_VALUE;
        long resultAfterNotPickingCurrentIndexPacketForFinalCost=Integer.MAX_VALUE;
        if(cost[totalNumberOfPackets-1]!=-1){
            resultAfterNotPickingCurrentIndexPacketForFinalCost=depthFirstSearch_forArrays(totalNumberOfPackets-1, weightRequired, cost, weightOfThePackets, memoization);
            minimumCostToBuyExactlyWKgOranges=Math.min(minimumCostToBuyExactlyWKgOranges, Math.min(resultAfterPickingCurrentIndexPacketForFinalCost, resultAfterNotPickingCurrentIndexPacketForFinalCost));
        }
        if(weightOfThePackets[totalNumberOfPackets-1]<=weightRequired){
            resultAfterPickingCurrentIndexPacketForFinalCost=cost[totalNumberOfPackets-1]+depthFirstSearch_forArrays(totalNumberOfPackets, weightRequired-weightOfThePackets[totalNumberOfPackets-1], cost, weightOfThePackets, memoization);
            resultAfterNotPickingCurrentIndexPacketForFinalCost=depthFirstSearch_forArrays(totalNumberOfPackets-1, weightRequired, cost, weightOfThePackets, memoization);
            minimumCostToBuyExactlyWKgOranges=Math.min(minimumCostToBuyExactlyWKgOranges, Math.min(resultAfterPickingCurrentIndexPacketForFinalCost, resultAfterNotPickingCurrentIndexPacketForFinalCost));
        } else{
            resultAfterNotPickingCurrentIndexPacketForFinalCost=depthFirstSearch_forArrays(totalNumberOfPackets-1, weightRequired, cost, weightOfThePackets, memoization);
            minimumCostToBuyExactlyWKgOranges=Math.min(minimumCostToBuyExactlyWKgOranges, Math.min(resultAfterPickingCurrentIndexPacketForFinalCost, resultAfterNotPickingCurrentIndexPacketForFinalCost));
        }
        memoization[totalNumberOfPackets][weightRequired]=minimumCostToBuyExactlyWKgOranges;
        return memoization[totalNumberOfPackets][weightRequired];
    }
    
    public static int minimumCost(int n, int w, int[] cost) {
        int[] weightsOfThePackets=new int[n];
        for(int packetIIndex=0; packetIIndex<n; ++packetIIndex){
            weightsOfThePackets[packetIIndex]=packetIIndex+1;
        }
        long[][] memoization=new long[n+1][w+1];
        for(int packetIIndex=0; packetIIndex<=n; ++packetIIndex){
            for(int weightIndexOfPacketI=0; weightIndexOfPacketI<=w; ++weightIndexOfPacketI){
                memoization[packetIIndex][weightIndexOfPacketI]=-1L;
            }
        }
        long minimumCostToBuyExactlyWKgOranges=depthFirstSearch_forArrays(n, w, cost, weightsOfThePackets, memoization);
        if(minimumCostToBuyExactlyWKgOranges>=Integer.MAX_VALUE){
            return -1;
        }
        return (int)minimumCostToBuyExactlyWKgOranges;
    }
}
