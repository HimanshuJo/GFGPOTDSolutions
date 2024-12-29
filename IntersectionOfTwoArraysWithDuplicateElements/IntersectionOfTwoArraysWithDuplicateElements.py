# https://www.geeksforgeeks.org/problems/intersection-of-two-arrays-with-duplicate-elements/1

class Solution:
    def intersectionWithDuplicates(self, a, b):
        resultantList=[]
        integerCountMapping={}
        seenValues=set()
        lengthOfA=len(a)
        lengthOfB=len(b)
        for i in range(0, lengthOfA, 1):
            if a[i] in integerCountMapping:
                integerCountMapping[a[i]]=integerCountMapping[a[i]]+1
            else:
                integerCountMapping[a[i]]=1
        for i in range(0, lengthOfB, 1):
            if b[i] not in seenValues:
                if b[i] in integerCountMapping:
                    resultantList.append(b[i])
                    seenValues.add(b[i])
        return resultantList


#{ 
 # Driver Code Starts
#Position this line where user code will be pasted.
t = int(input().strip())
while t > 0:
    t -= 1
    # Read first array
    a = list(map(int, input().strip().split()))

    # Read second array
    b = list(map(int, input().strip().split()))

    #input()  # to consume the empty line

    # ADD Solution initialization
    sln = Solution()

    # Assuming numberofElementsInIntersection function is defined in Solution
    res = sln.intersectionWithDuplicates(a, b)

    # Sort the result
    res.sort()

    # Print the result
    if not res:
        print("[]")
    else:
        print(" ".join(map(str, res)))

    print("~")

# } Driver Code Ends