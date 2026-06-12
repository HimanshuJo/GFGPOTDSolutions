/*
https://www.geeksforgeeks.org/problems/find-equal-point-in-string-of-brackets2542/1
*/

class Solution {
  public:
    int findIndex(string &s) {
        int sz=s.size();
        vector<int>leftCounts(sz, 0);
        vector<int>rightCounts(sz, 0);
        for(int i=0; i<sz; ++i){
            if(s[i]=='('){
                if(i-1>=0){
                    leftCounts[i]=leftCounts[i-1]+1;
                } else leftCounts[i]=1;
            } else{
                if(i-1>=0){
                    leftCounts[i]=leftCounts[i-1];
                } else leftCounts[i]=0;
            }
        }
        for(int i=sz-1; i>=0; --i){
            if(s[i]==')'){
                if(i+1<=sz-1){
                    rightCounts[i]=rightCounts[i+1]+1;
                } else rightCounts[i]=1;
            } else{
                if(i+1<=sz-1){
                    rightCounts[i]=rightCounts[i+1];
                } else rightCounts[i]=0;
            }
        }
        for(int i=0; i<sz; ++i){
            int rightCount=rightCounts[i], leftCount=i-1>=0?leftCounts[i-1]:0;
            if(rightCount==leftCount) return i;
        }
        int leftCount=leftCounts[sz-1], rightCount=0;
        if(leftCount==rightCount) return sz;
    }
};

// ------- ####### -------

class Solution_BF {
  public:
    int findIndex(string &s) {
        int sz=s.size();
        for(int i=0; i<sz; ++i){
            if(i==0){
                int leftCount=0, rightCount=0;
                for(int j=i; j<sz; ++j){
                    if(s[j]==')'){
                        rightCount++;
                    }
                }
                if(leftCount==rightCount) return i;
            } else{
                int curOpeningCounts=0, curClosingCounts=0;
                for(int j=i-1; j>=0; --j){
                    if(s[j]=='(') curOpeningCounts++;
                }
                for(int j=i; j<sz; ++j){
                    if(s[j]==')') curClosingCounts++;
                }
                if(curOpeningCounts==curClosingCounts) return i;   
            }
        }
        int leftCount=0, rightCount=0;
        for(int j=sz-1; j>=0; --j){
            if(s[j]=='('){
                leftCount++;
            }
        }
        if(leftCount==rightCount) return sz;
        return 0;
    }
};