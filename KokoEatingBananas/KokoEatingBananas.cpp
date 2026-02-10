/*
https://www.geeksforgeeks.org/problems/koko-eating-bananas/1
*/

class Solution_TLE {
  public:
    int kokoEat(vector<int>& arr, int k) {
        set<int>allUnqeVals;
        int sz=arr.size(), res=INT_MAX;
        for(auto &vals: arr) allUnqeVals.insert(vals);
        for(int x=1; x<=1000000; ++x){
            bool flag=false;
            int vals=x, curCount=0;
            for(int i=0; i<sz; ++i){
                if(arr[i]<vals){
                    curCount+=1;
                } else{
                    int currentVal=arr[i];
                    while(currentVal>=vals){
                        curCount+=currentVal/vals;
                        currentVal%=vals;
                    }
                    if(currentVal!=0){
                        curCount++;
                    }
                }
                if(curCount>k){
                    flag=true;
                    break;
                }
            }
            if(!flag) res=min(res, vals);
        }
        return res;
    }
};

// ------- ####### -------

class Solution {
  public:
    int kokoEat(vector<int>& arr, int k) {
        int low=1, high=*max_element(arr.begin(), arr.end());
        int res=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            long long hours=0;
            for(auto &vals: arr){
                hours+=(vals+mid-1)/mid;
                if(hours>k) break;
            }
            if(hours<=k){
                res=mid;
                high=mid-1;
            } else{
                low=mid+1;
            }
        }
        return res;
    }
};