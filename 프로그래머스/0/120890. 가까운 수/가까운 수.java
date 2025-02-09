import java.lang.Math;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 100;
        
        for(int elem:array){
            if(Math.abs(elem-n) < Math.abs(answer-n))
                answer = elem;
            else if (Math.abs(elem-n) == Math.abs(answer-n))
                answer = answer<elem? answer:elem;
        }
        
        return answer;
    }
}