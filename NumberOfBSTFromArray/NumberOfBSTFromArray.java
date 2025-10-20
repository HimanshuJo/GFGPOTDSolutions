/*
https://www.geeksforgeeks.org/problems/number-of-bst-from-array/1
*/

class Solution {
    
    public int nCr(int N, int R){
        if(R>N-R) R=N-R;
        int res=1;
        for(int i=0; i<R; ++i){
            res*=(N-i);
            res/=(i+1);
        }
        return res;
    }
    
    public ArrayList<Integer> computeCatalan(int N){
        ArrayList<Integer>catalan=new ArrayList<>();
        for(int i=0; i<=N; ++i){
            catalan.add(0);
        }
        for(int i=0; i<=N; ++i){
            int c=nCr(2*i, i);
            catalan.set(i, c/(i+1));
        }
        return catalan;
    }
    
    public ArrayList<Integer> countBSTs(int[] arr) {
        int lengthOfArr=arr.length;
        ArrayList<Integer>sortedArr=new ArrayList<>();
        for(int i=0; i<lengthOfArr; ++i){
            sortedArr.add(arr[i]);
        }
        Collections.sort(sortedArr);
        HashMap<Integer, Integer>rankMap=new HashMap<>();
        for(int i=0; i<lengthOfArr; ++i){
            rankMap.put(sortedArr.get(i), i);
        }
        ArrayList<Integer>catalan=computeCatalan(lengthOfArr);
        ArrayList<Integer>resultantList=new ArrayList<>();
        for(int vals: arr){
            int L=rankMap.get(vals), R=lengthOfArr-1-L, total=catalan.get(L)*catalan.get(R);
            resultantList.add(total);
        }
        return resultantList;
    }
}