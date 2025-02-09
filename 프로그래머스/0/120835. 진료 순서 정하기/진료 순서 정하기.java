import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        
        int[] emergencyCopy = emergency.clone();
        Arrays.sort(emergencyCopy);
        
        List<Integer> list = new ArrayList<>();
        for(int elem:emergencyCopy){
            list.add(elem);
        }
        
        for(int i=0; i<answer.length; i++){
            answer[i] = emergency.length - list.indexOf(emergency[i]);
        }
        
        return answer;
    }
}