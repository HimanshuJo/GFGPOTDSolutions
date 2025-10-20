/*
https://www.geeksforgeeks.org/problems/number-of-bst-from-array/1
*/

class Solution {
  public:
  
    int nCr(int n, int r){
        if (r > n - r) r = n - r;
        int res = 1;
        for (int i = 0; i < r; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }
  
    vector<int> computeCatalan(int n){
        vector<int> catalan(n + 1);
        for (int i = 0; i <= n; ++i) {
            int c = nCr(2 * i, i);
            catalan[i] = c / (i + 1);
        }
        return catalan;
    }
  
    vector<int> countBSTs(vector<int>& arr) {
        int n = arr.size();
        vector<int> sortedArr = arr;
        sort(sortedArr.begin(), sortedArr.end());
        unordered_map<int, int> rankMap;
        for (int i = 0; i < n; ++i) {
            rankMap[sortedArr[i]] = i;
        }
        vector<int> catalan = computeCatalan(n);
        vector<int> result;
        result.reserve(n);
        for (int val : arr) {
            int L = rankMap[val];
            int R = n - 1 - L;
            int total = catalan[L] * catalan[R];
            result.push_back(total);
        }

        return result;
    }
};