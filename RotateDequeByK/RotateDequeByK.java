/*
https://www.geeksforgeeks.org/problems/rotate-deque-by-k/1
*/

import java.util.*;

class Solution {
    public static void rotateDeque(Deque<Integer> dq, int type, int k) {
        int sizeOfDq = dq.size();
        LinkedList<Integer> list = (LinkedList<Integer>) dq;
        ArrayList<Integer> tempList = new ArrayList<>(Collections.nCopies(sizeOfDq, -1));
        for (int i = 0; i < sizeOfDq; ++i) {
            int shiftPos = 0;
            if (type == 1) {
                shiftPos = (i + k) % sizeOfDq;
            } else {
                shiftPos = ((i - k) % sizeOfDq + sizeOfDq) % sizeOfDq;
            }
            tempList.set(shiftPos, list.get(i));
        }
        dq.clear();
        for (int num : tempList) {
            dq.offer(num);
        }
    }
    
}
