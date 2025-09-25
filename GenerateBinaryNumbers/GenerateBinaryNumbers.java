/*
https://www.geeksforgeeks.org/problems/generate-binary-numbers-1587115620/1
*/

class Solution {
    
    public String generateBinaryString(int number){
        if(number==1) return "1";
        StringBuilder resultantBinaryString=new StringBuilder();
        while(number!=1){
            int quotient=number/2, remainder=number%2;
            resultantBinaryString.append(remainder);
            number=quotient;
        }
        resultantBinaryString.append("1");
        resultantBinaryString.reverse();
        return String.valueOf(resultantBinaryString);
    }
    
    public ArrayList<String> generateBinary(int n) {
        ArrayList<String>resultantList=new ArrayList<>();
        for(int i=1; i<=n; ++i){
            String currentBinaryNum=generateBinaryString(i);
            resultantList.add(currentBinaryNum);
        }
        return resultantList;
    }
}