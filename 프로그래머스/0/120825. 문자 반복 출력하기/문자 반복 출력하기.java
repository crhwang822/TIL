import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string, int n) {
        String answer ="";
        String[] strlist = my_string.split("");
        for(int i=0; i<strlist.length; i++){
            answer += strlist[i].repeat(n);
        }
        return answer;
    }
}