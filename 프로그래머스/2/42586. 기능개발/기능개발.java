import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int before = 0;
        int now = 0;
        List<Integer> temp = new ArrayList<>();
        List<Integer> done = new ArrayList<>();
        done.add(-1);
        
        while(done.size() - 1< progresses.length) {
            for(int i = done.size() - 1; i < progresses.length; i++) {
                progresses[i] += speeds[i];
                if(progresses[i] >= 100 && done.get(done.size() - 1) == i - 1) {
                    done.add(i);
                }
            }
            now = done.size() - 1 - before;
            if(now != 0)
                temp.add(now);
            before = done.size() - 1;
        }
        
        int[] answer = new int[temp.size()];
        
        for(int i = 0; i < answer.length; i++)
            answer[i] = temp.get(i);
        
        return answer;
    }
}