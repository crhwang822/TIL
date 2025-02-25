import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int[] box = new int[m];
        Arrays.sort(score);
        int index = score.length - 1;
        
        while(index >= m - 1){
            for(int i = 0; i < box.length; i++){
                box[i] = score[index--];
            }
            answer += box[m - 1] * m;
        }
        
        return answer;
    }
}