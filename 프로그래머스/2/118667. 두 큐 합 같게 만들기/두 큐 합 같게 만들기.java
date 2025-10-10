import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        
        int len1 = queue1.length;
        int len2 = queue2.length;
        
        for(int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
        }
        
        
        for(int i = 0; i < queue2.length; i++) {
            sum2 += queue2[i];
        }
        
        if((sum1 + sum2) % 2 == 1)
            return -1;
        
        Queue<long[]> q = new LinkedList<>();
        int answer = -1;
        
        q.add(new long[]{0, sum1, sum2, 0, len1 - 1, 0, len2 - 1});
        
        while(!q.isEmpty()){
            long[] cur = q.poll();
            long s1 = cur[1];
            long s2 = cur[2];
            
            int sp1 = (int)cur[3];
            int ep1 = (int)cur[4];
            int sp2 = (int)cur[5];
            int ep2 = (int)cur[6];
            
            if(s1 == s2) {
                answer = (int)cur[0];
                break;
            }
            
            if(sp1 >= (len1 + len2) || sp2 >= (len1 + len2) || sp1 > ep1 || sp2 > ep2) 
                continue;
            
            int number = 0;
            if(s1 > s2) {
                //pop
                if(sp1 >= len1)
                    number = queue2[sp1 - len1];
                else number = queue1[sp1];
                q.add(new long[]{cur[0] + 1, s1 - number, s2 + number, 
                                 sp1 + 1, ep1, sp2, ep2 + 1});
            } else {
                if(sp2 >= len2)
                    number = queue1[sp2 - len2];
                else number = queue2[sp2];
                q.add(new long[]{cur[0] + 1, s1 + number, s2 - number, 
                                 sp1, ep1 + 1, sp2 + 1, ep2});
            }
            
            
            
        }
        
        
        return answer;
        
    }
}