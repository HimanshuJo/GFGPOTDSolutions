/*
https://www.geeksforgeeks.org/problems/construct-an-array-from-its-pair-sum-array/1
*/

class Solution {
  public:
    vector<int> constructArr(vector<int>& arr) {
        int m=arr.size(), n=(1+(sqrt(1+8*m)))/2;
        int A=arr[0], B=arr[1], C=arr[n-1];
        vector<int>res(n, 0);
        res[0]=(A+B-C)/2, res[1]=A-res[0], res[2]=B-res[0];
        for(int k=3; k<n; ++k){
            res[k]=arr[k-1]-res[0];
        }
        vector<int>gen;
        gen.reserve(m);
        for(int i=0; i<n; ++i){
            for(int j=i+1; j<n; ++j){
                gen.push_back(res[i]+res[j]);
            }
        }
        sort(gen.begin(), gen.end());
        vector<int>sorted=arr;
        sort(sorted.begin(), sorted.end());
        if(sorted!=gen) return {};
        return res;
    }
};