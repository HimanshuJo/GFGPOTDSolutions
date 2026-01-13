/*
https://www.geeksforgeeks.org/problems/lemonade-change/1
*/

class Solution {
    public boolean canServe(int[] arr) {
        int countFiveCoins=0, countTenCoins=0, countTwentyCoins=0;
        for(int coin: arr){
            if(coin==5){
                countFiveCoins++;
            } else if(coin==10){
                if(countFiveCoins==0) return false;
                else{
                    countFiveCoins--;
                    countTenCoins++;
                }
            } else{
                if(countTenCoins>=1){
                    if(countFiveCoins==0) return false;
                    else{
                        countFiveCoins--;
                        countTenCoins--;
                        countTwentyCoins++;
                    }
                } else{
                    if(countFiveCoins<3) return false;
                    else{
                        countFiveCoins-=3;
                        countTwentyCoins++;
                    }
                }
            }
        }
        return true;
    }
}