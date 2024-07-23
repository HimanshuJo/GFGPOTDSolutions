# https://www.geeksforgeeks.org/problems/check-for-bst/1

#User function Template for python3


class Solution:
    
    #Function to check whether a Binary Tree is BST or not.
    def isBST(self, root):
        
        def depthFirstSearch_forRightTree(primaryRoot, currentRoot):
            if currentRoot is None:
                return True
            if currentRoot.data <= primaryRoot.data:
                return False
            if currentRoot.left is not None:
                if currentRoot.left.data >= currentRoot.data:
                    return False
            if currentRoot.right is not None:
                if currentRoot.right.data <= currentRoot.data:
                    return False
            leftTreeCall=depthFirstSearch_forRightTree(primaryRoot, currentRoot.left)
            rightTreeCall=depthFirstSearch_forRightTree(primaryRoot, currentRoot.right)
            return leftTreeCall and rightTreeCall
        
        def depthFirstSearch_forLeftTree(primaryRoot, currentRoot):
            if currentRoot is None:
                return True
            if currentRoot.data >= primaryRoot.data:
                return False
            if currentRoot.left is not None:
                if currentRoot.left.data >= currentRoot.data:
                    return False
            if currentRoot.right is not None:
                if currentRoot.right.data <= currentRoot.data:
                    return False
            leftTreeCall=depthFirstSearch_forLeftTree(primaryRoot, currentRoot.left)
            rightTreeCall=depthFirstSearch_forLeftTree(primaryRoot, currentRoot.right)
            return leftTreeCall and rightTreeCall
        
        def isBST_postOrderTraversal(root):
            leftTreeCall=depthFirstSearch_forLeftTree(root, root.left)
            rightTreeCall=depthFirstSearch_forRightTree(root, root.right)
            return leftTreeCall and rightTreeCall
        
        return isBST_postOrderTraversal(root);




#{ 
 # Driver Code Starts
#Initial Template for Python 3
from collections import deque


# Tree Node
class Node:

    def __init__(self, val):
        self.right = None
        self.data = val
        self.left = None


# Function to Build Tree
def buildTree(s):
    #Corner Case
    if (len(s) == 0 or s[0] == "N"):
        return None

    # Creating list of strings from input
    # string after spliting by space
    ip = list(map(str, s.split()))

    # Create the root of the tree
    root = Node(int(ip[0]))
    size = 0
    q = deque()

    # Push the root to the queue
    q.append(root)
    size = size + 1

    # Starting from the second element
    i = 1
    while (size > 0 and i < len(ip)):
        # Get and remove the front of the queue
        currNode = q[0]
        q.popleft()
        size = size - 1

        # Get the current node's value from the string
        currVal = ip[i]

        # If the left child is not null
        if (currVal != "N"):

            # Create the left child for the current node
            currNode.left = Node(int(currVal))

            # Push it to the queue
            q.append(currNode.left)
            size = size + 1
        # For the right child
        i = i + 1
        if (i >= len(ip)):
            break
        currVal = ip[i]

        # If the right child is not null
        if (currVal != "N"):

            # Create the right child for the current node
            currNode.right = Node(int(currVal))

            # Push it to the queue
            q.append(currNode.right)
            size = size + 1
        i = i + 1
    return root


if __name__ == "__main__":
    t = int(input())
    for _ in range(0, t):
        s = input()
        root = buildTree(s)
        if Solution().isBST(root):
            print("true")
        else:
            print("false")

# } Driver Code Ends