import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        HashMap<Integer, Double> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        //<스테이지 넘버, 해당 스테이지에 멈춰있는 사용자 수> 저장
        for(int i = 0; i < stages.length; i++){
            if(!map.containsKey(stages[i]))
                map.put(stages[i], 1.0);
            else map.replace(stages[i], map.get(stages[i]) + 1.0);
        }
        
        //key 값 오름차순 정렬
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        
        //실패율 계산
        int denom = stages.length;
        for(int key : keys){
            double value = key == N + 1? 0 : map.get(key) / (double)denom;
            denom -= map.get(key);
            map.replace(key, value);
        }
        
        List<Map.Entry<Integer,Double>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        
        for(int i = 0; i < entryList.size(); i++){
            if(entryList.get(i).getKey() != N + 1)
                list.add(entryList.get(i).getKey());    
        }
        
        //실패율이 0인 스테이지들
        for(int i = 1; i < N + 1; i++){
            if(map.containsKey(i))
                continue;
            list.add(i);
        }
        
        //List -> int[]
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}