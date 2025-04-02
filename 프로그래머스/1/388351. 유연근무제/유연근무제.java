import java.lang.Math;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i = 0; i < timelogs.length; i++) { //직원
            boolean flag = true;
            int hope = schedules[i] % 100 + (schedules[i] / 100 * 60);
            
            for(int j = 0; j < timelogs[i].length; j++) { //일차
                
                if((j + startday) % 7 == 6 || (j + startday) % 7 == 0)
                    continue;
                
                int real = timelogs[i][j] % 100 + (timelogs[i][j] / 100 * 60);
                if(real - hope > 10) {
                    flag = false;
                    break;
                }
            }
            
            if(flag) answer++;
        }
        
        return answer;
    }
}