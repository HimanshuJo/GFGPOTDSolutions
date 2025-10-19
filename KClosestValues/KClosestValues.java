/*
https://www.geeksforgeeks.org/problems/k-closest-values/1
*/

/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Pair{
    
    public int first;
    
    public int second;
    
    Pair(){};
    
    public Pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}

class CustomComparator implements Comparator<Pair>{
    
    public int compare(Pair A, Pair B){
        if(A.second==B.second) return Integer.compare(A.first, B.first);
        return Integer.compare(A.second, B.second);
    }
}

class Solution {
    
    private ArrayList<Pair>absDiffList;
    
    public Solution(){
        absDiffList=new ArrayList<>();
    }
    
    public ArrayList<Pair> getAbsDiffList(){
        return this.absDiffList;
    }
    
    public void setAbsDiffList(ArrayList<Pair>absDiffList){
        this.absDiffList=absDiffList;
    }
    
    public void depthFirstSearch_forTrees(Node root, int target, int k){
        if(root==null) return;
        int currentAbsDiff=Math.abs(root.data-target);
        ArrayList<Pair>currentAbsDiffList=getAbsDiffList();
        currentAbsDiffList.add(new Pair(root.data, currentAbsDiff));
        depthFirstSearch_forTrees(root.left, target, k);
        depthFirstSearch_forTrees(root.right, target, k);
        return;
    }
    
    public void preOrderTraversal(Node root, int target, int k){
        depthFirstSearch_forTrees(root, target, k);
    }
    
    public ArrayList<Integer> getKClosest(Node root, int target, int k) {
        preOrderTraversal(root, target, k);
        ArrayList<Pair>currentAbsDiffList=getAbsDiffList();
        Collections.sort(currentAbsDiffList, new CustomComparator());
        ArrayList<Integer>resultantList=new ArrayList<>();
        for(int i=0; i<currentAbsDiffList.size(); ++i){
            resultantList.add(currentAbsDiffList.get(i).first);
            k--;
            if(k==0) break;
        }
        return resultantList;
    }
}