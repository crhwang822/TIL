import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Collections;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int num : numlist){
            int distance = Math.abs(n - num);
            if(!map.containsKey(distance))
                map.put(distance, new ArrayList<>());
            map.get(distance).add(num);
        }
        
        //거리 순 정렬
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        
        int index = 0;
        for(int key : keys){
            List<Integer> list = map.get(key);
            //큰 수부터 정렬
            Collections.sort(list, Collections.reverseOrder());
            for(int i : list){
                answer[index] = i;
                index++;
            }
        }
        
        return answer;
    }
}