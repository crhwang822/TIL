import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[][] history = new int[friends.length][friends.length];
        int[] score = new int[friends.length];
        int[] prediction = new int[friends.length];
        List<String> names = Arrays.asList(friends);

        //선물 기록 / 지수 저장
        for(String gift : gifts) {
            String giver = gift.split(" ")[0];
            String receiver = gift.split(" ")[1];
            history[names.indexOf(giver)][names.indexOf(receiver)]++;
            score[names.indexOf(giver)]++;
            score[names.indexOf(receiver)]--;
        }
        
        // 예측
        for(int i = 0; i < history.length; i++) {
            for(int j = i + 1; j < history.length; j++) {
                if(history[i][j] == history[j][i]) {
                    if(score[i] != score[j])
                        prediction[score[i] > score[j]? i : j]++;
                    continue;
                }
                
                if(history[i][j] > history[j][i])
                    prediction[i]++;
                else 
                    prediction[j]++;
            }
        }
    
        for(int i = 0; i < prediction.length; i++) {
            if(prediction[i] > answer) answer = prediction[i];
        }
        
        return answer;
    }
}