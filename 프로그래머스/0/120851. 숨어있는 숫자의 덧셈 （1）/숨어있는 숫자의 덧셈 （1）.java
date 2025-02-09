import java.lang.Integer;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        for(int i=0; i<my_string.length(); i++){
            if('0' <= my_string.charAt(i) && my_string.charAt(i) <= '9')
                answer += Integer.parseInt(String.valueOf(my_string.charAt(i)));
        }
        return answer;
    }
}