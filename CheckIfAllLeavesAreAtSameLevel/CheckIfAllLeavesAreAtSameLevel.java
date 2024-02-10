/*
https://www.geeksforgeeks.org/problems/leaf-at-same-level/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
//Initial Template for Java

// INITIAL CODE
import java.util.*;
import java.lang.*;
import java.io.*;

// A Binary Tree node
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class Is_Leaves_At_Same_Level
{
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
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
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }

    // driver function to test the above functions
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
        
        while(t > 0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
        
            Solution g = new Solution();
	    	boolean b = g.check(root);
		   	if(b == true)
		    	System.out.println(1);
	    	else
		   	    System.out.println(0);
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution
{
    
    boolean bfs(Node root){
        LinkedList<Node>q=new LinkedList<>();
        q.add(root);
        Set<Node>seen=new HashSet<>();
        seen.add(root);
        int curlevel=1;
        HashMap<Node, Integer>mp=new HashMap<>();
        while(q.size()>=1){
            int sz=q.size();
            while(sz-- >0){
                Node curr=q.getFirst();
                q.removeFirst();
                if(curr.left==null&&curr.right==null){
                    mp.put(curr, curlevel);
                }
                if(curr.left!=null){
                    if(!seen.contains(curr.left)){
                        seen.add(curr.left);
                        q.add(curr.left);
                    }
                }
                if(curr.right!=null){
                    if(!seen.contains(curr.right)){
                        seen.add(curr.right);
                        q.add(curr.right);
                    }
                }
            }
            curlevel++;
        }
        int tochk=-1;
        for(Map.Entry<Node, Integer>entries: mp.entrySet()){
            if(tochk==-1){
                tochk=entries.getValue();
            } else{
                if(entries.getValue()!=tochk) return false;
            }
        }
        return true;
    }
    
    boolean check(Node root)
    {
        return bfs(root);
    }
}