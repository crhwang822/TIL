import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int t : tangerine) {
            if(!map.containsKey(t))
                map.put(t, 0);
            map.replace(t, map.get(t) + 1);
        }
        
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (o1, o2) -> map.get(o2) - map.get(o1));
        
        for(int key : keys) {
            answer++;
            k -= map.get(key);
            if(k <= 0) break;
        } 
            
        return answer;
    }
}