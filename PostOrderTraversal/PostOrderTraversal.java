/*
https://www.geeksforgeeks.org/problems/postorder-traversal/1
*/

/*
class Node {
    int data;
    Node left, right;
    Node(int val){
        data = val;
        left = right = null;
    }
}
*/

import java.util.*;

class Solution {
    
    private ArrayList<Integer> resultantPostOrderTraversal;

    public Solution() {
        resultantPostOrderTraversal = new ArrayList<>();
    }
    
    private void depthFirstSearch_forTrees(Node root) {
        if (root == null) return;
        depthFirstSearch_forTrees(root.left);
        depthFirstSearch_forTrees(root.right);
        resultantPostOrderTraversal.add(root.data);
    }
    
    public ArrayList<Integer> postOrder(Node root) {
        resultantPostOrderTraversal.clear();
        depthFirstSearch_forTrees(root);
        return resultantPostOrderTraversal;
    }
}