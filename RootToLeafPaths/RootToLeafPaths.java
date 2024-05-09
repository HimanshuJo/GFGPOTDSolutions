/*
https://www.geeksforgeeks.org/problems/root-to-leaf-paths/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;


class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }

    public static Node buildTree(String str)
    {
        // Corner Case
        if(str.length()==0 || str.charAt(0)=='N')
            return null;

        // Creating array of Strings from input
        // String after spliting by space
        String ip[] = str.split(" ");

        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));

        // Push the root to the queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Starting from the second element
        int i = 1;
        while(queue.size()>0 && i < ip.length)
        {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if(!currVal.equals("N"))
            {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if(i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if(!currVal.equals("N"))
            {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static Node inputTree(BufferedReader br) throws IOException
    {
        return buildTree(br.readLine().trim());
    }

    public static void inorder(Node root)
    {
        if (root == null)
           return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            Node root = Node.inputTree(br);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.Paths(root);
            
            IntMatrix.print(res);
            
        }
    }
}

// } Driver Code Ends


/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    
    public static ArrayList<ArrayList<Integer>> bfs(Node root){
        ArrayList<ArrayList<Node>>q=new ArrayList<>();
        ArrayList<Node>bgn=new ArrayList<>();
        bgn.add(root);
        ArrayList<ArrayList<Integer>>res=new ArrayList<>();
        q.add(bgn);
        while(!q.isEmpty()){
            int sz=q.size();
            while(sz-- >0){
                ArrayList<Node>curr=q.get(q.size()-1);
                q.remove(q.size()-1);
                Node lstnode=curr.get(curr.size()-1);
                if(lstnode.left==null&&lstnode.right==null){
                    ArrayList<Integer>nw=new ArrayList<>();
                    for(int i=0; i<curr.size(); ++i){
                        nw.add(curr.get(i).data);
                    }
                    res.add(nw);
                } else{
                    if(lstnode.left!=null){
                        ArrayList<Node>nwfrlft=new ArrayList<>();
                        for(int i=0; i<curr.size(); ++i){
                            nwfrlft.add(curr.get(i));
                        }
                        nwfrlft.add(lstnode.left);
                        q.add(nwfrlft);
                    }
                    if(lstnode.right!=null){
                        ArrayList<Node>nwfrrght=new ArrayList<>();
                        for(int i=0; i<curr.size(); ++i){
                            nwfrrght.add(curr.get(i));
                        }
                        nwfrrght.add(lstnode.right);
                        q.add(nwfrrght);
                    }
                }
            }
        }
        Collections.reverse(res);
        return res;
    }
    
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        return bfs(root);
    }
}
        
