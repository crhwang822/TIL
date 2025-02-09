import java.util.Arrays;

class Solution {
    public String solution(String my_string) {
        String[] strlist = my_string.toLowerCase().split("");
        Arrays.sort(strlist);
        String answer = String.join("", strlist);
        return answer;
    }
}