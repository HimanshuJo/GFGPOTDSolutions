/*
https://www.geeksforgeeks.org/problems/sum-of-leaf-nodes-in-bst/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class leaf_nodes
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            for(int i = 0; i < n; i++)
            {
                int data = sc.nextInt();
                root = insert(root, data);
            }
            Solution gfg = new Solution();
            System.out.println(gfg.sumOfLeafNodes(root));
        }
    }
    
    public static Node insert(Node root, int x)
    {
        
        if(root == null)
          {
              return (new Node(x));
          }
          
          if(x < root.data)
          {
              root.left = insert(root.left, x);
          }
          else if(x >= root.data)
          {
              root.right = insert(root.right, x);
          }
          
      return root;      
    }
    
}

// } Driver Code Ends


/*node class of the binary ssearch tree
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}*/
class Solution
{
    
    public static void dfs(Node root, int[] sumarr){
        if(root==null) return;
        if(root.left==null&&root.right==null){
            sumarr[0]+=root.data;
            return;
        }
        dfs(root.left, sumarr);
        dfs(root.right, sumarr);
        return;
    }
    
    public static int preOrderLeafSum(Node root){
        int[] sumarr=new int[1];
        sumarr[0]=0;
        dfs(root, sumarr);
        return sumarr[0];
    }
    
    public static int sumOfLeafNodes(Node root)
    {
        return preOrderLeafSum(root);
    }
}
