/*
https://www.geeksforgeeks.org/problems/rotate-deque-by-k/1
*/

class Solution {
  public:
    void rotateDeque(deque<int>& dq, int type, int k) {
        int sz=dq.size();
        vector<int>tmp(sz, -1);
        for(int i=0; i<sz; ++i){
            if(type==1){
                int shiftPos=(i+k)%sz;
                tmp[shiftPos]=dq[i];
            } else{
                int shiftPos=-1;
                if(i<k){
                   int totrv=abs(i-k);
                   shiftPos=sz-totrv;
                   tmp[shiftPos]=dq[i];
                } else{
                    shiftPos=(i-k)%sz;
                    tmp[shiftPos]=dq[i];
                }
            }
        }
        deque<int>res;
        for(auto &vals: tmp){
            res.push_back(vals);
        }
        dq=res;
    }
};