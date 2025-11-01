/*
https://www.geeksforgeeks.org/problems/shortest-cycle/1
*/

class Solution {
    public int shortCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>>adjacencyList=new ArrayList<>();
        for(int i=0; i<V; ++i){
            adjacencyList.add(new ArrayList<>());
        }
        for(int edge[]: edges){
            int source=edge[0], destination=edge[1];
            adjacencyList.get(source).add(destination);
            adjacencyList.get(destination).add(source);
        }
        int resultantShortestCycle=Integer.MAX_VALUE;
        for(int node=0; node<V; ++node){
            ArrayList<Integer>distances=new ArrayList<>();
            ArrayList<Integer>parent=new ArrayList<>();
            for(int i=0; i<V; ++i){
                distances.add(-1);
                parent.add(-1);
            }
            LinkedList<Integer>llist=new LinkedList<>();
            llist.add(node);
            distances.set(node, 0);
            while(!llist.isEmpty()){
                int currentLLSize=llist.size();
                while(currentLLSize-- >0){
                    int currentNode=llist.pop();
                    for(int nei: adjacencyList.get(currentNode)){
                        if(distances.get(nei)==-1){
                            distances.set(nei, distances.get(currentNode)+1);
                            parent.set(nei, currentNode);
                            llist.add(nei);
                        } else if(parent.get(currentNode)!=nei){
                            int currentDistance=distances.get(currentNode)+distances.get(nei)+1;
                            resultantShortestCycle=Math.min(resultantShortestCycle, currentDistance);
                        }
                    }
                }
            }
        }
        return resultantShortestCycle==Integer.MAX_VALUE?-1:resultantShortestCycle;
    }
}