import java.lang.Math;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int max = Math.max(sides[0], sides[1]);
        int min = Math.min(sides[0], sides[1]);
        
        // 가장 긴 변이 sides 배열에 있는 경우
        answer += min;
        
        // 가장 긴 변이 sides 배열에 없는 경우
        answer +=  min - 1;
        
        return answer;
    }
}