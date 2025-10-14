/*
https://www.geeksforgeeks.org/problems/range-sum-of-bst/1
*/

/*
class Node {
    int data;
    Node left, right;
    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    
    private int resultantRangeSum;
    
    public int getResultantRangeSum(){
        return this.resultantRangeSum;
    }
    
    public void setResultantRangeSum(int resultantRangeSum){
        this.resultantRangeSum=resultantRangeSum;
    }
    
    public void depthFirstSearch_forTrees(Node root, int l, int r){
        if(root==null) return;
        if(root.data>=l&&root.data<=r){
            int currentRangeSum=getResultantRangeSum();
            currentRangeSum+=root.data;
            setResultantRangeSum(currentRangeSum);
        }
        depthFirstSearch_forTrees(root.left, l, r);
        depthFirstSearch_forTrees(root.right, l, r);
        return;
    }
    
    public void preOrderTraversal(Node root, int l, int r){
        depthFirstSearch_forTrees(root, l, r);
    }
    
    public int nodeSum(Node root, int l, int r) {
        preOrderTraversal(root, l, r);
        return getResultantRangeSum();
    }
}
