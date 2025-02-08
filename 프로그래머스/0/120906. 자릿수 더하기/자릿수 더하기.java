import java.util.Arrays;
import java.lang.Integer;

class Solution {
    public int solution(int n) {
        int answer = 0;
        answer = Arrays.stream(Integer.toString(n).split("")).mapToInt(Integer::parseInt).sum();
        return answer;
    }
}