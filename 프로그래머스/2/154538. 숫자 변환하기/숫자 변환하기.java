import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, 0});
        while(!q.isEmpty()) {
            int[] arr = q.poll();
            int value = arr[0];
            int count = arr[1];
            if(value == x) 
                return count;
            if(value - n >= x)
                q.add(new int[]{value - n, count + 1});
            if(value % 2 == 0 && value / 2 >= x)
                q.add(new int[]{value / 2, count + 1});
            if(value % 3 == 0 && value / 3 >= x)
                q.add(new int[]{value / 3, count + 1});
        }
        return -1;
    }
}