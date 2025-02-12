import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        
        if(arr.length == 1)
            return new int[]{-1};
        
        int[] answer = new int[arr.length - 1];
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        
        int j = 0;
        for(int i = 0; i < answer.length; i++){
            if(arr[i] == sorted[0])
                j++;
            answer[i] = arr[j++];
        }
        
        return answer;
    }
}