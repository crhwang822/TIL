import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        List<int[]> q = new ArrayList<>();
        int index = 0; 
        
        q.add(new int[]{truck_weights[index], 0});
        int weights = truck_weights[index++];
        
        do {
            answer++;
            for(int[] truck : q) {
                truck[1]++;
            }
            int[] front = q.get(0);
            if(front[1] > bridge_length) {
                q.remove(0);
                weights -= front[0];
            }
            if(index < truck_weights.length && 
               weights + truck_weights[index] <= weight) {
                q.add(new int[]{truck_weights[index], 1});
                weights += truck_weights[index];
                
                index++;
            }
            
            
        } while(!q.isEmpty());
        
        return answer;
    }
}