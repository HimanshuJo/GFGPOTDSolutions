# https://www.geeksforgeeks.org/problems/in-first-but-second5423/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd

#User function Template for python3


class Solution:
    def findMissing(self,a,b,n,m):
        res=[]
        mp1={}
        mp2={}
        for i in range(0, n, 1):
            if a[i] in mp1:
                mp1[a[i]]=mp1[a[i]]+1
            else:
                mp1[a[i]]=1
        for i in range(0, m, 1):
            if b[i] in mp1:
                mp1[b[i]]=mp1[b[i]]+1
            else:
                mp1[b[i]]=1
            if b[i] in mp2:
                mp2[b[i]]=mp2[b[i]]+1
            else:
                mp2[b[i]]=1
        for i in range(0, n, 1):
            if a[i] in mp1:
                if mp1[a[i]]==1:
                    res.append(a[i])
                elif a[i] not in mp2:
                        res.append(a[i])
            elif a[i] not in mp2:
                    res.append(a[i])
        return res



#{ 
 # Driver Code Starts
#Initial Template for Python 3



t=int(input())
for _ in range(0,t):
   # n=int(input())
    l = list(map(int, input().split()))
    n=l[0]
    m=l[1]
    a = list(map(int,input().split()))
    b = list(map(int, input().split()))
    ob=Solution()
    ans=ob.findMissing(a,b,n,m)
    for each in ans:
        print(each,end=' ')
    print()
# } Driver Code Ends