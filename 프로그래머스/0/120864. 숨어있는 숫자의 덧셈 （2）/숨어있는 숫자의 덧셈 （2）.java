import java.lang.Integer;
import java.lang.StringBuilder;
import java.lang.Character;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        my_string = "0a" + my_string;
        
        String[] arr = my_string.split("\\D+");
        
        for(String s:arr){
            answer += Integer.parseInt(s);
        }
        
        return answer;
    }
}