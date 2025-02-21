import java.util.Arrays;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int[] rank = new int[k];
        int min = score[0];
        int idx = k < score.length? k : score.length;
        
        for(int i = 0; i < idx; i++){
            rank[i] = score[i];
            min = min < score[i]? min : score[i];
            answer[i] = min;
        }
        
        Arrays.sort(rank);
        
        for(int i = idx; i < score.length; i++){
            if(score[i] > rank[0]){
                rank[0] = score[i];
                Arrays.sort(rank);
            }
            answer[i] = rank[0];
        }
        
        return answer;
    }
}