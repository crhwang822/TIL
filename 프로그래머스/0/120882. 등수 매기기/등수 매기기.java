import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < score.length; i++){
            int sum = score[i][0] + score[i][1];
            
            if(!map.containsKey(sum))
                map.put(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
        
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, Collections.reverseOrder());
        
        int rank = 1;
        for(int key : keys){
            List<Integer> index = map.get(key);
            for(int i : index){
                answer[i] = rank;
            }
            rank += index.size();
        }
        
        return answer;
    }
}