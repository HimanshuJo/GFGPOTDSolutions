/*
https://www.geeksforgeeks.org/problems/count-number-of-substrings4528/1
*/

class Solution {
    
    public int substringsWithAtMost(String s, int k){
        int lengthOfS=s.length(), resultantCount=0;
        int[] freqMap=new int[26];
        for(int i=0; i<26; ++i){
            freqMap[i]=0;
        }
        int left=0, distinctSubstrings=0;
        for(int right=0; right<lengthOfS; ++right){
            int currentIdx=s.charAt(right)-'a';
            if(freqMap[currentIdx]==0) distinctSubstrings++;
            freqMap[currentIdx]++;
            while(distinctSubstrings>k){
                int leftIdx=s.charAt(left)-'a';
                freqMap[leftIdx]--;
                if(freqMap[leftIdx]==0){
                    distinctSubstrings--;
                }
                left++;
            }
            resultantCount+=(right-left)+1;
        }
        return resultantCount;   
    }
    
    public int countSubstr(String s, int k) {
        return substringsWithAtMost(s, k)-substringsWithAtMost(s, k-1);
    }
}