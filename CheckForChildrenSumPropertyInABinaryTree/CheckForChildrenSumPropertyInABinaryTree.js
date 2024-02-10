/*
https://www.geeksforgeeks.org/problems/children-sum-parent/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
//Initial Template for javascript
'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(string => {
        return string.trim();
    });
    
    main();    
});

function readLine() {
    return inputString[currentLine++];
}

class Node{
    constructor(data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

function buildTree(str){
   // Corner Case
   if(str.length === 0 || str[0] === "N")
       return null;

   // Create the root of the tree
   let root = new Node(parseInt(str[0]));

   // Push the root to the queue
   let queue = [];
   let start = 0;
   queue.push(root);

   // Starting from the second element
   let i = 1;
   while(queue.length !== start && i < str.length) {

       // Get and remove the front of the queue
       let currNode = queue[start];
       start++;

       // Get the current node's value from the string
       let currVal = str[i];

       // If the left child is not null
       if(currVal !== "N") {

           // Create the left child for the current node
           currNode.left = new Node(parseInt(currVal));

           // Push it to the queue
           queue.push(currNode.left);
       }

       // For the right child
       i++;
       if(i >= str.length)
           break;
       currVal = str[i];

       // If the right child is not null
       if(currVal !== "N") {

           // Create the right child for the current node
           currNode.right = new Node(parseInt(currVal));

           // Push it to the queue
           queue.push(currNode.right);
       }
       i++;
   }

   return root;
}

function main() {
    let t = parseInt(readLine());
    let i = 0;
    for(;i<t;i++)
    {
        let input_ar1 = readLine().split(' ');
        let root = buildTree(input_ar1);
        let obj = new Solution();
        console.log(obj.isSumProperty(root));
        
    }
}
// } Driver Code Ends


//User function Template for javascript

/**
 * @param {Node} root
 * @returns {number}
*/

/*
class Node{
    constructor(data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    
    bfs(root){
        let q=[];
        q.push(root);
        let seen=new Set()
        seen.add(root);
        while(q.length!=0){
            let sz=q.length;
            while(sz-- >0){
                let curr=q.shift();
                if(curr.left===null&&curr.right===null) continue;
                let val=curr.data;
                let tochk=0;
                if(curr.left!==null){
                    tochk+=(curr.left.data);
                    if(!seen.has(curr.left)){
                        seen.add(curr.left);
                        q.push(curr.left);
                    }
                }
                if(curr.right!==null){
                    tochk+=(curr.right.data);
                    if(!seen.has(curr.right)){
                        seen.add(curr.right);
                        q.push(curr.right);
                    }
                }
                if(tochk!==val) return 0;
            }
        }
        return 1;
    }
    
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    isSumProperty(root)
    {
        return this.bfs(root);
    }
}