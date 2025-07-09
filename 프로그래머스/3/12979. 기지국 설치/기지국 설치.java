import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        List<int[]> list = new ArrayList<>();
        
        int s = 1; 
        int e = -1;
        for(int i = 0; i < stations.length; i++) {
            e = stations[i] - w - 1;
            if(s <= e) {
                list.add(new int[]{s, e});
            }
            s = stations[i] + w + 1;
        }
        if(s <= n)
            list.add(new int[]{s, n});
        
        for(int i = 0; i < list.size(); i++) {
            int d = list.get(i)[1] - list.get(i)[0] + 1;
            answer += d / (2 * w + 1);
            if(d % (2 * w + 1) != 0)
                answer++;
        }

        return answer;
    }
}