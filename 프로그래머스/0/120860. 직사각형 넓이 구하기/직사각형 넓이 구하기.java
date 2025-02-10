import java.lang.Math;

class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int width = 0, length = 0;
        for(int i=0; i<3; i++){
            if(dots[i][0] != dots[i+1][0])
                width = Math.abs(dots[i][0] - dots[i+1][0]);
            if(dots[i][1] != dots[i+1][1])
                length = Math.abs(dots[i][1] - dots[i+1][1]);
        }

        answer = width * length;
        return answer;
    }
}