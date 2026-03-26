/*
https://www.geeksforgeeks.org/problems/number-of-ways-to-arrive-at-destination/1
*/

class Pair{
    
    public int first;
    
    public int second;
    
    Pair(int first, int second){
        this.first=first;
        this.second=second;
    }
    
}

class Solution {
    
    public static final int MOD=1000000000+7;
    
    public int countPaths(int V, int[][] edges) {
        ArrayList<ArrayList<Pair>>graph=new ArrayList<>();
        for(int i=0; i<V; ++i){
            graph.add(new ArrayList<Pair>());
        }
        for(int edge[]: edges){
            int currSource=edge[0], currDest=edge[1], currWeight=edge[2];
            ArrayList<Pair>currPairFirst=graph.get(currSource);
            currPairFirst.add(new Pair(currDest, currWeight));
            graph.set(currSource, currPairFirst);
            ArrayList<Pair>currPairSecond=graph.get(currDest);
            currPairSecond.add(new Pair(currSource, currWeight));
            graph.set(currDest, currPairSecond);
        }
        int[] dist=new int[V];
        for(int i=0; i<V; ++i){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[0]=0;
        int[] ways=new int[V];
        for(int i=0; i<V; ++i){
            ways[i]=0;
        }
        ways[0]=1;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((A, B) -> Integer.compare(A.first, B.first));
        minHeap.add(new Pair(0, 0));
        while(!minHeap.isEmpty()){
            int currentSize=minHeap.size();
            while(currentSize-- >0){
                Pair currentPair=minHeap.poll();
                int currentDistance=currentPair.first,
                    currentNode=currentPair.second,
                    previousDistance=dist[currentNode];
                if(currentDistance>previousDistance) continue;
                for(int i=0; i<graph.get(currentNode).size(); ++i){
                    Pair currentNeighbourPair=graph.get(currentNode).get(i);
                    int nextNode=currentNeighbourPair.first;
                    int nextDistance=currentDistance+currentNeighbourPair.second;
                    if(nextDistance<dist[nextNode]){
                        dist[nextNode]=nextDistance;
                        ways[nextNode]=ways[currentNode];
                        minHeap.add(new Pair(nextDistance, nextNode));
                    } else if(nextDistance==dist[nextNode]){
                        ways[nextNode]=(ways[nextNode]+ways[currentNode])%MOD;
                    }
                }
            }
        }
        return ways[V-1]%MOD;
    }
}