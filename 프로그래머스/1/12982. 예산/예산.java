import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        long price = 0;
        
        Arrays.sort(d);
        
        for(int request: d){
            price += request;
            if(price > budget)
                break;
            answer++;
        }
        
        return answer;
    }
}