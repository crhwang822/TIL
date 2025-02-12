import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        
        List<Integer> la = new ArrayList<>();
        List<Integer> lb = new ArrayList<>();
        List<Integer> lc = new ArrayList<>();
        
        for(int i = lines[0][0]; i < lines[0][1]; i++){
            la.add(i);
        }
        for(int i = lines[1][0]; i < lines[1][1]; i++){
            lb.add(i);
        }
        for(int i = lines[2][0]; i < lines[2][1]; i++){
            lc.add(i);
        }
        
        int s = Math.min(Math.min(lines[0][0], lines[1][0]), lines[2][0]);
        int e = Math.max(Math.max(lines[0][1], lines[1][1]), lines[2][1]);
        
        
        for(int i = s; i < e; i++){
            if(la.contains(i) && lb.contains(i)){
                answer++;
                continue;
            }
            if(la.contains(i) && lc.contains(i)){
                answer++;
                continue;
            }
            if(lb.contains(i) && lc.contains(i)){
                answer++;
                continue;
            }
        }
        
        return answer;
    }

}