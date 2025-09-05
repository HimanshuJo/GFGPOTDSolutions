# https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1

class Solution:
    def segregate(self, head):
        nodesValsList=[]
        while(head is not None):
            nodesValsList.append(head.data)
            head=head.next
        nodesValsList.sort()
        resulantList=Node(nodesValsList[0])
        tailForResultantList=resulantList
        for i in range(1, len(nodesValsList), 1):
            newNode=Node(nodesValsList[i])
            tailForResultantList.next=newNode
            tailForResultantList=tailForResultantList.next
        return resulantList