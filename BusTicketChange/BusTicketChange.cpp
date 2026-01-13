/*
https://www.geeksforgeeks.org/problems/lemonade-change/1
*/

class Solution {
  public:
    bool canServe(vector<int> &arr) {
        int countFives=0, countTens=0, countTwenties=0;
        for(auto &vals: arr){
            int curVal=vals;
            if(curVal==5) countFives++;
            else if(curVal==10){
                if(countFives==0) return false;
                else{
                    countFives--;
                    countTens++;
                }
            } else{
                if(countTens>=1){
                    if(countFives==0) return false;
                    else{
                        countFives--;
                        countTens--;
                        countTwenties++;
                    }
                } else{
                    if(countFives<3) return false;
                    else{
                        countFives-=3;
                        countTwenties++;
                    }
                }
            }
        }
        return true;
    }
};