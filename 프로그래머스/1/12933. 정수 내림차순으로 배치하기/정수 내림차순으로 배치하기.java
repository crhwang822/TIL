import java.util.Arrays;
import java.util.Collections;
import java.lang.Long;

class Solution {
    public long solution(long n) {
        String[] s = String.valueOf(n).split("");
        Arrays.sort(s, Collections.reverseOrder());
        
        long answer = Long.parseLong(String.join("", s));
        return answer;
    }
}