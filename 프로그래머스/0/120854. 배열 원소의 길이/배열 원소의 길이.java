import java.util.Arrays;

class Solution {
    public int[] solution(String[] strlist) {
        int[] answer = {};
        answer = Arrays.stream(strlist).mapToInt(str -> str.length()).toArray();
        return answer;
    }
}