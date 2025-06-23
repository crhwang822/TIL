import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0 ; i < works.length; i++)
            pq.offer(works[i]);
        
        for(int i = 0; i < n; i++) {
            int max = pq.poll();
            if(max == 0)
                break;
            pq.offer(max - 1);
        }
        
        while(!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}