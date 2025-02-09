import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(String my_string) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<my_string.length(); i++){
            char c = my_string.charAt(i);
            if ('0' <= c && c <= '9')
                list.add(Integer.parseInt(String.valueOf(c)));
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
         answer[i] = list.get(i);   
        }
        Arrays.sort(answer);
        return answer;
    }
}